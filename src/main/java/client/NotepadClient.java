package client;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sana.example.notepad.NotepadGrpc;
import org.sana.example.notepad.Recommendations;
import org.sana.example.notepad.Task;

public class NotepadClient implements ServiceObserver {

    protected ServiceDescription current;
    private final String serviceType;
    private final String name;
    private static final Logger logger = Logger.getLogger(GRPCWorkspaceClient.class.getName());

    private ManagedChannel channel;
    private NotepadGrpc.NotepadBlockingStub blockingStub;

    /**
     * Constructor.
     */
    public NotepadClient() {
        serviceType = "_notepad._udp.local.";
        name = "Sana";
        jmDNSServiceTracker clientManager = jmDNSServiceTracker.getInstance();
        clientManager.register(this);

        serviceAdded(new ServiceDescription("34.241.178.97", 50077));
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
        blockingStub = NotepadGrpc.newBlockingStub(channel);
        recommendPriorities();
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
    
    public void recommendPriorities() {
        try {
                Empty request = Empty.newBuilder().build();
                Recommendations recommended = blockingStub.recommendPriorities(request);
                List<Task> recommendedTasks = recommended.getTasksList();
                for (Task entry : recommendedTasks){
                    System.out.println(entry.toString());
                }
            
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    /**
     * Say hello to server.
     */
    public static void main(String[] args) {
        new NotepadClient();
    }

    public void switchService(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
