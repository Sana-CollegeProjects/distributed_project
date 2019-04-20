package client;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sana.example.phone.CallStatus;
import org.sana.example.phone.EmailInfo;
import org.sana.example.phone.EmailStatus;
import org.sana.example.phone.Name;
import org.sana.example.phone.Person;
import org.sana.example.phone.PhoneGrpc;

public class PhoneClient implements ServiceObserver {

    protected ServiceDescription current;
    private final String serviceType;
    private final String name;
    private static final Logger logger = Logger.getLogger(GRPCWorkspaceClient.class.getName());

    private ManagedChannel channel;
    private PhoneGrpc.PhoneBlockingStub blockingStub;

    /**
     * Constructor.
     */
    public PhoneClient() {
        serviceType = "_phone._udp.local.";
        name = "Sana";
        jmDNSServiceTracker clientManager = jmDNSServiceTracker.getInstance();
        clientManager.register(this);

        serviceAdded(new ServiceDescription("34.241.178.95", 50022));
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
        blockingStub = PhoneGrpc.newBlockingStub(channel);
        endCall();
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
    
    public void emailContact() {
        try {
                String name = "sana";
                String content = "Hey, was wondering if you know where the meeting is! -J";
                EmailInfo request = EmailInfo.newBuilder().setName(name).setContent(content).build();
                EmailStatus response = blockingStub.emailContact(request);
                logger.info(response.toString());
            
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void callContact() {
        try {
                String name = "sana";
                Name request = Name.newBuilder().setName(name).build();
                CallStatus response = blockingStub.callContact(request);
                logger.info(response.toString());
            
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void endCall() {
        try {
                Empty request = Empty.newBuilder().build();
                CallStatus response = blockingStub.endCall(request);
                logger.info(response.toString());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void getAllContacts() {
        try {
                Empty request = Empty.newBuilder().build();
                Iterator<Person> response = blockingStub.getAllContacts(request);
                while(response.hasNext()){
                    logger.info(response.toString());
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
        new PhoneClient();
    }

    public void switchService(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
