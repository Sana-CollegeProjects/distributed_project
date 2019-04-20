package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sana.example.scanner.CurrentStatus;
import org.sana.example.scanner.Pages;
import org.sana.example.scanner.PagesScannedStatus;
import org.sana.example.scanner.ScanGrpc;
import org.sana.example.scanner.TransitioningToPowerStatus;

public class ScannerClient implements ServiceObserver {

    protected ServiceDescription current;
    private final String serviceType;
    private final String name;
    private static final Logger logger = Logger.getLogger(GRPCWorkspaceClient.class.getName());

    private ManagedChannel channel;
    private ScanGrpc.ScanBlockingStub blockingStub;

    /**
     * Constructor.
     */
    public ScannerClient() {
        serviceType = "_scanner._udp.local.";
        name = "Sana";
        jmDNSServiceTracker clientManager = jmDNSServiceTracker.getInstance();
        clientManager.register(this);

        serviceAdded(new ServiceDescription("34.241.178.93", 50055));
    }

    String getServiceType() {
        return serviceType;
    }

    void disable() {
        // no services exist for this client type
    }

    public List<String> serviceInterests() {
        List<String> interests = new ArrayList<String>();
        interests.add(serviceType);
        return interests;
    }

    public void serviceAdded(ServiceDescription service) {
        logger.info("service added");
        current = service;
        channel = ManagedChannelBuilder.forAddress(service.getAddress(), service.getPort())
                .usePlaintext(true)
                .build();
        blockingStub = ScanGrpc.newBlockingStub(channel);
        togglePower();
    }

    public boolean interested(String type) {
        return serviceType.equals(type);
    }

    public String getName() {
        return name;
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void scanDocuments() {
        try {
                int numOfPages = 5;
                Pages request = Pages.newBuilder().setNumberOfPages(numOfPages).build();
                Iterator<PagesScannedStatus> response = blockingStub.scanDocuments(request);
                while(response.hasNext()){
                    logger.info(response.next().toString());
                }
                logger.info("Scanning completed!");
            
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void togglePower() {
        try {
                String initialState = "on";
                CurrentStatus request = CurrentStatus.newBuilder().setStatus(initialState).build();
                TransitioningToPowerStatus response = blockingStub.togglePower(request);
                logger.info(response.toString());
            
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }

    /**
     * Say hello to server.
     */
    public static void main(String[] args) {
        new ScannerClient();
    }

    public void switchService(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
