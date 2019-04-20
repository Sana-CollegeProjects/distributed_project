package org.sana.example.phone;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: phone.proto")
public final class PhoneGrpc {

  private PhoneGrpc() {}

  public static final String SERVICE_NAME = "phone.Phone";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.sana.example.phone.EmailInfo,
      org.sana.example.phone.EmailStatus> getEmailContactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmailContact",
      requestType = org.sana.example.phone.EmailInfo.class,
      responseType = org.sana.example.phone.EmailStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.sana.example.phone.EmailInfo,
      org.sana.example.phone.EmailStatus> getEmailContactMethod() {
    io.grpc.MethodDescriptor<org.sana.example.phone.EmailInfo, org.sana.example.phone.EmailStatus> getEmailContactMethod;
    if ((getEmailContactMethod = PhoneGrpc.getEmailContactMethod) == null) {
      synchronized (PhoneGrpc.class) {
        if ((getEmailContactMethod = PhoneGrpc.getEmailContactMethod) == null) {
          PhoneGrpc.getEmailContactMethod = getEmailContactMethod = 
              io.grpc.MethodDescriptor.<org.sana.example.phone.EmailInfo, org.sana.example.phone.EmailStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "phone.Phone", "EmailContact"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.phone.EmailInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.phone.EmailStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new PhoneMethodDescriptorSupplier("EmailContact"))
                  .build();
          }
        }
     }
     return getEmailContactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.sana.example.phone.Name,
      org.sana.example.phone.CallStatus> getCallContactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CallContact",
      requestType = org.sana.example.phone.Name.class,
      responseType = org.sana.example.phone.CallStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.sana.example.phone.Name,
      org.sana.example.phone.CallStatus> getCallContactMethod() {
    io.grpc.MethodDescriptor<org.sana.example.phone.Name, org.sana.example.phone.CallStatus> getCallContactMethod;
    if ((getCallContactMethod = PhoneGrpc.getCallContactMethod) == null) {
      synchronized (PhoneGrpc.class) {
        if ((getCallContactMethod = PhoneGrpc.getCallContactMethod) == null) {
          PhoneGrpc.getCallContactMethod = getCallContactMethod = 
              io.grpc.MethodDescriptor.<org.sana.example.phone.Name, org.sana.example.phone.CallStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "phone.Phone", "CallContact"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.phone.Name.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.phone.CallStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new PhoneMethodDescriptorSupplier("CallContact"))
                  .build();
          }
        }
     }
     return getCallContactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.sana.example.phone.CallStatus> getEndCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EndCall",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.sana.example.phone.CallStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.sana.example.phone.CallStatus> getEndCallMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.sana.example.phone.CallStatus> getEndCallMethod;
    if ((getEndCallMethod = PhoneGrpc.getEndCallMethod) == null) {
      synchronized (PhoneGrpc.class) {
        if ((getEndCallMethod = PhoneGrpc.getEndCallMethod) == null) {
          PhoneGrpc.getEndCallMethod = getEndCallMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.sana.example.phone.CallStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "phone.Phone", "EndCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.phone.CallStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new PhoneMethodDescriptorSupplier("EndCall"))
                  .build();
          }
        }
     }
     return getEndCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.sana.example.phone.Person> getGetAllContactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllContacts",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.sana.example.phone.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.sana.example.phone.Person> getGetAllContactsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.sana.example.phone.Person> getGetAllContactsMethod;
    if ((getGetAllContactsMethod = PhoneGrpc.getGetAllContactsMethod) == null) {
      synchronized (PhoneGrpc.class) {
        if ((getGetAllContactsMethod = PhoneGrpc.getGetAllContactsMethod) == null) {
          PhoneGrpc.getGetAllContactsMethod = getGetAllContactsMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.sana.example.phone.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "phone.Phone", "getAllContacts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.phone.Person.getDefaultInstance()))
                  .setSchemaDescriptor(new PhoneMethodDescriptorSupplier("getAllContacts"))
                  .build();
          }
        }
     }
     return getGetAllContactsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PhoneStub newStub(io.grpc.Channel channel) {
    return new PhoneStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PhoneBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PhoneBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PhoneFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PhoneFutureStub(channel);
  }

  /**
   */
  public static abstract class PhoneImplBase implements io.grpc.BindableService {

    /**
     */
    public void emailContact(org.sana.example.phone.EmailInfo request,
        io.grpc.stub.StreamObserver<org.sana.example.phone.EmailStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getEmailContactMethod(), responseObserver);
    }

    /**
     */
    public void callContact(org.sana.example.phone.Name request,
        io.grpc.stub.StreamObserver<org.sana.example.phone.CallStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getCallContactMethod(), responseObserver);
    }

    /**
     */
    public void endCall(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.sana.example.phone.CallStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getEndCallMethod(), responseObserver);
    }

    /**
     */
    public void getAllContacts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.sana.example.phone.Person> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllContactsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEmailContactMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.sana.example.phone.EmailInfo,
                org.sana.example.phone.EmailStatus>(
                  this, METHODID_EMAIL_CONTACT)))
          .addMethod(
            getCallContactMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.sana.example.phone.Name,
                org.sana.example.phone.CallStatus>(
                  this, METHODID_CALL_CONTACT)))
          .addMethod(
            getEndCallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.sana.example.phone.CallStatus>(
                  this, METHODID_END_CALL)))
          .addMethod(
            getGetAllContactsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.sana.example.phone.Person>(
                  this, METHODID_GET_ALL_CONTACTS)))
          .build();
    }
  }

  /**
   */
  public static final class PhoneStub extends io.grpc.stub.AbstractStub<PhoneStub> {
    private PhoneStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PhoneStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhoneStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PhoneStub(channel, callOptions);
    }

    /**
     */
    public void emailContact(org.sana.example.phone.EmailInfo request,
        io.grpc.stub.StreamObserver<org.sana.example.phone.EmailStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmailContactMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void callContact(org.sana.example.phone.Name request,
        io.grpc.stub.StreamObserver<org.sana.example.phone.CallStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCallContactMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void endCall(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.sana.example.phone.CallStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEndCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllContacts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.sana.example.phone.Person> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllContactsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PhoneBlockingStub extends io.grpc.stub.AbstractStub<PhoneBlockingStub> {
    private PhoneBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PhoneBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhoneBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PhoneBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.sana.example.phone.EmailStatus emailContact(org.sana.example.phone.EmailInfo request) {
      return blockingUnaryCall(
          getChannel(), getEmailContactMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.sana.example.phone.CallStatus callContact(org.sana.example.phone.Name request) {
      return blockingUnaryCall(
          getChannel(), getCallContactMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.sana.example.phone.CallStatus endCall(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getEndCallMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<org.sana.example.phone.Person> getAllContacts(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllContactsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PhoneFutureStub extends io.grpc.stub.AbstractStub<PhoneFutureStub> {
    private PhoneFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PhoneFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhoneFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PhoneFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.sana.example.phone.EmailStatus> emailContact(
        org.sana.example.phone.EmailInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getEmailContactMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.sana.example.phone.CallStatus> callContact(
        org.sana.example.phone.Name request) {
      return futureUnaryCall(
          getChannel().newCall(getCallContactMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.sana.example.phone.CallStatus> endCall(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getEndCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EMAIL_CONTACT = 0;
  private static final int METHODID_CALL_CONTACT = 1;
  private static final int METHODID_END_CALL = 2;
  private static final int METHODID_GET_ALL_CONTACTS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PhoneImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PhoneImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EMAIL_CONTACT:
          serviceImpl.emailContact((org.sana.example.phone.EmailInfo) request,
              (io.grpc.stub.StreamObserver<org.sana.example.phone.EmailStatus>) responseObserver);
          break;
        case METHODID_CALL_CONTACT:
          serviceImpl.callContact((org.sana.example.phone.Name) request,
              (io.grpc.stub.StreamObserver<org.sana.example.phone.CallStatus>) responseObserver);
          break;
        case METHODID_END_CALL:
          serviceImpl.endCall((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.sana.example.phone.CallStatus>) responseObserver);
          break;
        case METHODID_GET_ALL_CONTACTS:
          serviceImpl.getAllContacts((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.sana.example.phone.Person>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PhoneBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PhoneBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.sana.example.phone.PhoneProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Phone");
    }
  }

  private static final class PhoneFileDescriptorSupplier
      extends PhoneBaseDescriptorSupplier {
    PhoneFileDescriptorSupplier() {}
  }

  private static final class PhoneMethodDescriptorSupplier
      extends PhoneBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PhoneMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PhoneGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PhoneFileDescriptorSupplier())
              .addMethod(getEmailContactMethod())
              .addMethod(getCallContactMethod())
              .addMethod(getEndCallMethod())
              .addMethod(getGetAllContactsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
