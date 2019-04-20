package services;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import org.sana.example.scanner.CurrentStatus;
import org.sana.example.scanner.Pages;
import org.sana.example.scanner.PagesScannedStatus;
import org.sana.example.scanner.ScanGrpc;
import org.sana.example.scanner.TransitioningToPowerStatus;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class ScannerServer {

    private static final Logger logger = Logger.getLogger(ScannerServer.class.getName());

    /* The port on which the server should run */
    private int port = 50055;
    private Server server;

    private void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new ScannerImpl())
                .build()
                .start();
        JmDNSRegistrationHelper helper = new JmDNSRegistrationHelper("Nci", "_scanner._udp.local.", "", port);
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                ScannerServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon
     * threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws Exception {
        final ScannerServer server = new ScannerServer();
        server.start();
        server.blockUntilShutdown();
    }

    private class ScannerImpl extends ScanGrpc.ScanImplBase {
        
        private int requestedPages = 0;
        private int scansLeft = 0;
        private String finalStatus = "unkown";

        public ScannerImpl() {          
            String name = "Nci's";
            String serviceType = "_scanner._udp.local.";
        }

        @Override
        public void scanDocuments(Pages numberOfPages,
                io.grpc.stub.StreamObserver<org.sana.example.scanner.PagesScannedStatus> responseObserver){
            requestedPages = numberOfPages.getNumberOfPages();
            scansLeft=requestedPages;
            Timer t = new Timer();
                t.schedule(new RemindTask(responseObserver), 0 , 2000);
        }
        
        @Override
        public void togglePower(CurrentStatus status,
                io.grpc.stub.StreamObserver<org.sana.example.scanner.TransitioningToPowerStatus> responseObserver) {
            String powerStatus = status.getStatus().toString();
            
            logger.info("Client requested togglePower of initial state: "+powerStatus);
            
            if (powerStatus.equalsIgnoreCase("on")){
                finalStatus = "off";
            }
            else if (powerStatus.equalsIgnoreCase("off")){
                finalStatus = "on";
            }
            else{
                finalStatus= "Error getting current power state";
            }           
            responseObserver.onNext(TransitioningToPowerStatus.newBuilder().setStatus(finalStatus).build());
            logger.info("Client's state has been changed to: "+finalStatus);
            responseObserver.onCompleted();
        }

        class RemindTask extends TimerTask {

            StreamObserver<PagesScannedStatus> o;

            public RemindTask(StreamObserver<PagesScannedStatus> j) {
                o = j;
            }

            @Override
            public void run() {
                if(scansLeft>0){
                    try{
                        PagesScannedStatus status = PagesScannedStatus.newBuilder().setPagesLeftInTray(scansLeft).build();
                        o.onNext(status);
                        scansLeft -= 1;
                    }
                    catch(RuntimeException e){
                        logger.severe("cannot complete scan request from client"+e);
                    }  
                }
                else{
                    o.onCompleted();
                    this.cancel();
                    logger.info("Client has no more pages to scan...");
                }
                
            }
        }
    }
}
