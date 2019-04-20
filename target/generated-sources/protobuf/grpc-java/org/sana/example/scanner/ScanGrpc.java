package org.sana.example.scanner;

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
    comments = "Source: scanner.proto")
public final class ScanGrpc {

  private ScanGrpc() {}

  public static final String SERVICE_NAME = "scanner.Scan";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.sana.example.scanner.Pages,
      org.sana.example.scanner.PagesScannedStatus> getScanDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScanDocuments",
      requestType = org.sana.example.scanner.Pages.class,
      responseType = org.sana.example.scanner.PagesScannedStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.sana.example.scanner.Pages,
      org.sana.example.scanner.PagesScannedStatus> getScanDocumentsMethod() {
    io.grpc.MethodDescriptor<org.sana.example.scanner.Pages, org.sana.example.scanner.PagesScannedStatus> getScanDocumentsMethod;
    if ((getScanDocumentsMethod = ScanGrpc.getScanDocumentsMethod) == null) {
      synchronized (ScanGrpc.class) {
        if ((getScanDocumentsMethod = ScanGrpc.getScanDocumentsMethod) == null) {
          ScanGrpc.getScanDocumentsMethod = getScanDocumentsMethod = 
              io.grpc.MethodDescriptor.<org.sana.example.scanner.Pages, org.sana.example.scanner.PagesScannedStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "scanner.Scan", "ScanDocuments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.scanner.Pages.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.scanner.PagesScannedStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new ScanMethodDescriptorSupplier("ScanDocuments"))
                  .build();
          }
        }
     }
     return getScanDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.sana.example.scanner.CurrentStatus,
      org.sana.example.scanner.TransitioningToPowerStatus> getTogglePowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "togglePower",
      requestType = org.sana.example.scanner.CurrentStatus.class,
      responseType = org.sana.example.scanner.TransitioningToPowerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.sana.example.scanner.CurrentStatus,
      org.sana.example.scanner.TransitioningToPowerStatus> getTogglePowerMethod() {
    io.grpc.MethodDescriptor<org.sana.example.scanner.CurrentStatus, org.sana.example.scanner.TransitioningToPowerStatus> getTogglePowerMethod;
    if ((getTogglePowerMethod = ScanGrpc.getTogglePowerMethod) == null) {
      synchronized (ScanGrpc.class) {
        if ((getTogglePowerMethod = ScanGrpc.getTogglePowerMethod) == null) {
          ScanGrpc.getTogglePowerMethod = getTogglePowerMethod = 
              io.grpc.MethodDescriptor.<org.sana.example.scanner.CurrentStatus, org.sana.example.scanner.TransitioningToPowerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "scanner.Scan", "togglePower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.scanner.CurrentStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.sana.example.scanner.TransitioningToPowerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new ScanMethodDescriptorSupplier("togglePower"))
                  .build();
          }
        }
     }
     return getTogglePowerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ScanStub newStub(io.grpc.Channel channel) {
    return new ScanStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScanBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ScanBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ScanFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ScanFutureStub(channel);
  }

  /**
   */
  public static abstract class ScanImplBase implements io.grpc.BindableService {

    /**
     */
    public void scanDocuments(org.sana.example.scanner.Pages request,
        io.grpc.stub.StreamObserver<org.sana.example.scanner.PagesScannedStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getScanDocumentsMethod(), responseObserver);
    }

    /**
     */
    public void togglePower(org.sana.example.scanner.CurrentStatus request,
        io.grpc.stub.StreamObserver<org.sana.example.scanner.TransitioningToPowerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getTogglePowerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScanDocumentsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.sana.example.scanner.Pages,
                org.sana.example.scanner.PagesScannedStatus>(
                  this, METHODID_SCAN_DOCUMENTS)))
          .addMethod(
            getTogglePowerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.sana.example.scanner.CurrentStatus,
                org.sana.example.scanner.TransitioningToPowerStatus>(
                  this, METHODID_TOGGLE_POWER)))
          .build();
    }
  }

  /**
   */
  public static final class ScanStub extends io.grpc.stub.AbstractStub<ScanStub> {
    private ScanStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScanStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScanStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScanStub(channel, callOptions);
    }

    /**
     */
    public void scanDocuments(org.sana.example.scanner.Pages request,
        io.grpc.stub.StreamObserver<org.sana.example.scanner.PagesScannedStatus> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getScanDocumentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void togglePower(org.sana.example.scanner.CurrentStatus request,
        io.grpc.stub.StreamObserver<org.sana.example.scanner.TransitioningToPowerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTogglePowerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ScanBlockingStub extends io.grpc.stub.AbstractStub<ScanBlockingStub> {
    private ScanBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScanBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScanBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScanBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<org.sana.example.scanner.PagesScannedStatus> scanDocuments(
        org.sana.example.scanner.Pages request) {
      return blockingServerStreamingCall(
          getChannel(), getScanDocumentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.sana.example.scanner.TransitioningToPowerStatus togglePower(org.sana.example.scanner.CurrentStatus request) {
      return blockingUnaryCall(
          getChannel(), getTogglePowerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ScanFutureStub extends io.grpc.stub.AbstractStub<ScanFutureStub> {
    private ScanFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScanFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScanFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScanFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.sana.example.scanner.TransitioningToPowerStatus> togglePower(
        org.sana.example.scanner.CurrentStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getTogglePowerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SCAN_DOCUMENTS = 0;
  private static final int METHODID_TOGGLE_POWER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ScanImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ScanImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCAN_DOCUMENTS:
          serviceImpl.scanDocuments((org.sana.example.scanner.Pages) request,
              (io.grpc.stub.StreamObserver<org.sana.example.scanner.PagesScannedStatus>) responseObserver);
          break;
        case METHODID_TOGGLE_POWER:
          serviceImpl.togglePower((org.sana.example.scanner.CurrentStatus) request,
              (io.grpc.stub.StreamObserver<org.sana.example.scanner.TransitioningToPowerStatus>) responseObserver);
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

  private static abstract class ScanBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScanBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.sana.example.scanner.ScannerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Scan");
    }
  }

  private static final class ScanFileDescriptorSupplier
      extends ScanBaseDescriptorSupplier {
    ScanFileDescriptorSupplier() {}
  }

  private static final class ScanMethodDescriptorSupplier
      extends ScanBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ScanMethodDescriptorSupplier(String methodName) {
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
      synchronized (ScanGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ScanFileDescriptorSupplier())
              .addMethod(getScanDocumentsMethod())
              .addMethod(getTogglePowerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
