package org.sana.example.notepad;

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
    comments = "Source: notepad.proto")
public final class NotepadGrpc {

  private NotepadGrpc() {}

  public static final String SERVICE_NAME = "notepad.Notepad";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.sana.example.notepad.Recommendations> getRecommendPrioritiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecommendPriorities",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.sana.example.notepad.Recommendations.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.sana.example.notepad.Recommendations> getRecommendPrioritiesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.sana.example.notepad.Recommendations> getRecommendPrioritiesMethod;
    if ((getRecommendPrioritiesMethod = NotepadGrpc.getRecommendPrioritiesMethod) == null) {
      synchronized (NotepadGrpc.class) {
        if ((getRecommendPrioritiesMethod = NotepadGrpc.getRecommendPrioritiesMethod) == null) {
          NotepadGrpc.getRecommendPrioritiesMethod = getRecommendPrioritiesMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.sana.example.notepad.Recommendations>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "notepad.Notepad", "RecommendPriorities"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.notepad.Recommendations.getDefaultInstance()))
                  .setSchemaDescriptor(new NotepadMethodDescriptorSupplier("RecommendPriorities"))
                  .build();
          }
        }
     }
     return getRecommendPrioritiesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NotepadStub newStub(io.grpc.Channel channel) {
    return new NotepadStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotepadBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NotepadBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NotepadFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NotepadFutureStub(channel);
  }

  /**
   */
  public static abstract class NotepadImplBase implements io.grpc.BindableService {

    /**
     */
    public void recommendPriorities(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.sana.example.notepad.Recommendations> responseObserver) {
      asyncUnimplementedUnaryCall(getRecommendPrioritiesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecommendPrioritiesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.sana.example.notepad.Recommendations>(
                  this, METHODID_RECOMMEND_PRIORITIES)))
          .build();
    }
  }

  /**
   */
  public static final class NotepadStub extends io.grpc.stub.AbstractStub<NotepadStub> {
    private NotepadStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotepadStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotepadStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotepadStub(channel, callOptions);
    }

    /**
     */
    public void recommendPriorities(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.sana.example.notepad.Recommendations> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecommendPrioritiesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NotepadBlockingStub extends io.grpc.stub.AbstractStub<NotepadBlockingStub> {
    private NotepadBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotepadBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotepadBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotepadBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.sana.example.notepad.Recommendations recommendPriorities(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getRecommendPrioritiesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NotepadFutureStub extends io.grpc.stub.AbstractStub<NotepadFutureStub> {
    private NotepadFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotepadFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotepadFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotepadFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.sana.example.notepad.Recommendations> recommendPriorities(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getRecommendPrioritiesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECOMMEND_PRIORITIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NotepadImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NotepadImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECOMMEND_PRIORITIES:
          serviceImpl.recommendPriorities((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.sana.example.notepad.Recommendations>) responseObserver);
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

  private static abstract class NotepadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotepadBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.sana.example.notepad.NotepadProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Notepad");
    }
  }

  private static final class NotepadFileDescriptorSupplier
      extends NotepadBaseDescriptorSupplier {
    NotepadFileDescriptorSupplier() {}
  }

  private static final class NotepadMethodDescriptorSupplier
      extends NotepadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NotepadMethodDescriptorSupplier(String methodName) {
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
      synchronized (NotepadGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotepadFileDescriptorSupplier())
              .addMethod(getRecommendPrioritiesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
