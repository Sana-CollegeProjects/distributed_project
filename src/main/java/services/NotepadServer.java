package services;

import com.google.protobuf.Empty;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.omg.CORBA.SystemException;
import org.sana.example.notepad.NotepadGrpc;
import org.sana.example.notepad.Recommendations;
import org.sana.example.notepad.Task;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class NotepadServer {

    private static final Logger logger = Logger.getLogger(NotepadServer.class.getName());

    /* The port on which the server should run */
    private int port = 50077;
    private Server server;

    private void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new NotepadImpl())
                .build()
                .start();
        JmDNSRegistrationHelper helper = new JmDNSRegistrationHelper("Nci", "_notepad._udp.local.", "", port);
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                NotepadServer.this.stop();
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
        final NotepadServer server = new NotepadServer();
        server.start();
        server.blockUntilShutdown();
    }

    private class NotepadImpl extends NotepadGrpc.NotepadImplBase {
        
        private List<Task> tasks;
        private List<Task> highestPriority;
        private List<Task> highPriority;
        private List<Task> mediumPriority;
        private List<Task> lowPriority;

        public NotepadImpl() {   
            tasks = new ArrayList<Task>();
            Task readReport = Task.newBuilder().setTitle("Read Report").setImportant(true).setUrgent(true).build();
            Task setupMeeting = Task.newBuilder().setTitle("Setup Meeting with Sarah").setImportant(true).setUrgent(true).build();
            Task requestAdminRights = Task.newBuilder().setTitle("Request admin rights to laptop").setImportant(false).setUrgent(false).build();
            Task requestSoftware = Task.newBuilder().setTitle("Request antivirus software").setImportant(false).setUrgent(true).build();
            Task prepareNotes = Task.newBuilder().setTitle("Prepare Notes for meeting").setImportant(true).setUrgent(true).build();
            Task preparePresentation = Task.newBuilder().setTitle("Prepare presentation for demo").setImportant(true).setUrgent(false).build();
            Task makeDiagram = Task.newBuilder().setTitle("Prepare Diagram for demo").setImportant(true).setUrgent(false).build();
            tasks.add(readReport);
            tasks.add(setupMeeting);
            tasks.add(requestAdminRights);
            tasks.add(requestSoftware);
            tasks.add(prepareNotes);
            tasks.add(preparePresentation);
            tasks.add(makeDiagram);
            String name = "Nci's";
            String serviceType = "_scanner._udp.local.";
        }

        @Override
        public void recommendPriorities(Empty request,
                io.grpc.stub.StreamObserver<org.sana.example.notepad.Recommendations> responseObserver){
            for (Task task : tasks){
                boolean important = task.getImportant();
                boolean urgent = task.getUrgent();
                highestPriority = new ArrayList<Task>();
                highPriority = new ArrayList<Task>();
                mediumPriority = new ArrayList<Task>();
                lowPriority = new ArrayList<Task>();
                if ((important==true) && (urgent==true)){
                    highestPriority.add(task);
                }
                else if ((important==false) && (urgent==true)){
                    highPriority.add(task);
                }
                else if ((important==true) && (urgent==false)){
                    mediumPriority.add(task);
                }
                else if ((important==false) && (urgent==false)){
                    lowPriority.add(task);
                }
                else{
                logger.warning("Task doesn't have important/urgent boolean attached!");
                }
            }
            try{
                responseObserver.onNext(Recommendations.newBuilder().addAllTasks(highestPriority).build());
                responseObserver.onNext(Recommendations.newBuilder().addAllTasks(highPriority).build());
                responseObserver.onNext(Recommendations.newBuilder().addAllTasks(mediumPriority).build());
                responseObserver.onNext(Recommendations.newBuilder().addAllTasks(lowPriority).build());
                responseObserver.onCompleted();
            }
            catch (SystemException e){
                    String noTask = "No tasks in notepad!";
                    Task emptyTasklist = Task.newBuilder().setTitle(noTask).setImportant(false).setUrgent(false).build();
                    Recommendations response = Recommendations.newBuilder().setTasks(1,emptyTasklist).build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
            }
        }
        
    }
}
