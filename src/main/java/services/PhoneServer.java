package services;

import com.google.protobuf.Empty;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import org.sana.example.phone.CallStatus;
import org.sana.example.phone.EmailInfo;
import org.sana.example.phone.EmailStatus;
import org.sana.example.phone.Name;
import org.sana.example.phone.Person;
import org.sana.example.phone.PhoneGrpc;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class PhoneServer {

    private static final Logger logger = Logger.getLogger(PhoneServer.class.getName());

    /* The port on which the server should run */
    private int port = 50022;
    private Server server;

    private void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new PhoneImpl())
                .build()
                .start();
        JmDNSRegistrationHelper helper = new JmDNSRegistrationHelper("Nci", "_phone._udp.local.", "", port);
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                PhoneServer.this.stop();
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
        final PhoneServer server = new PhoneServer();
        server.start();
        server.blockUntilShutdown();
    }

    private class PhoneImpl extends PhoneGrpc.PhoneImplBase {
        
        private int requestedPages = 0;
        private int scansLeft = 0;
        private String finalStatus = "unkown";
        private List<Person> addressBook;

        public PhoneImpl() {          
            String name = "Nci's";
            String serviceType = "_phone._udp.local.";
            
            addressBook = new ArrayList<Person>();
            Person joe = Person.newBuilder().setName("Joe").setEmail("joe@gmail.com").setPhone("555-555-5555").build();
            Person sana = Person.newBuilder().setName("Sana").setEmail("sana@gmail.com").setPhone("555-444-5555").build();
            Person mary = Person.newBuilder().setName("Mary").setEmail("mary@gmail.com").setPhone("333-555-5555").build();
            Person john = Person.newBuilder().setName("John").setEmail("john@gmail.com").setPhone("333-555-3333").build();
            Person eva = Person.newBuilder().setName("Eva").setEmail("eva@gmail.com").setPhone("666-666-5555").build();
        }
        
        public void emailContact(EmailInfo info,
                io.grpc.stub.StreamObserver<org.sana.example.phone.EmailStatus> responseObserver){
            String name = EmailInfo.newBuilder().getName();
            String email = EmailInfo.newBuilder().getContent();
            
            
            for (Person person : addressBook){
                if (person.getName().equalsIgnoreCase(name)){
                    String matchedEmail = person.getEmail();
                    responseObserver.onNext(EmailStatus.newBuilder().setAddress(matchedEmail).setSent(true).build());
                    responseObserver.onCompleted();
                }
                else{
                    String error = "Contact doesn't exist in address book";
                    responseObserver.onNext(EmailStatus.newBuilder().setAddress(error).setSent(false).build());
                    responseObserver.onCompleted();
                }
            }
            
        }
        
        public void callContact(Name name,
                io.grpc.stub.StreamObserver<org.sana.example.phone.CallStatus> responseObserver){
            String clientName = Name.newBuilder().getName().toString();
            
            for (Person person : addressBook){
                if (person.getName().equalsIgnoreCase(clientName)){
                    String status = clientName+" dialed successfully";
                    responseObserver.onNext(CallStatus.newBuilder().setStatus(status).build());
                    responseObserver.onCompleted();
                }
                else{
                    String error = "Contact doesn't exist in address book";
                    responseObserver.onNext(CallStatus.newBuilder().setStatus(error).build());
                    responseObserver.onCompleted();
                }
            }
            
        }
        
        public void endCall(Empty request,
                io.grpc.stub.StreamObserver<org.sana.example.phone.CallStatus> responseObserver){
            String status = "Phone disconnected...";
            responseObserver.onNext(CallStatus.newBuilder().setStatus(status).build());
            responseObserver.onCompleted();
            
        }
        
        public void getAllContacts(Empty request,
                StreamObserver<Person> responseObserver){
            
            Timer t = new Timer();
            t.schedule(new StreamTask(responseObserver),0,2000);
        }
        
        class StreamTask extends TimerTask {
            StreamObserver<Person> o;
            int index = 0;

            public StreamTask(StreamObserver<Person> j) {
                o = j;
            }

            @Override
            public void run(){
                if(index== addressBook.size()){
                    o.onCompleted();
                    this.cancel();
                } else{
                    o.onNext(addressBook.get(index++));
                }
            }
        }
        
    }
}
