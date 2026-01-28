package cse5306.project1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CrossLangServiceGrpc {

  private CrossLangServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "project1.CrossLangService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cse5306.project1.HelloRequest,
      cse5306.project1.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = cse5306.project1.HelloRequest.class,
      responseType = cse5306.project1.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cse5306.project1.HelloRequest,
      cse5306.project1.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<cse5306.project1.HelloRequest, cse5306.project1.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = CrossLangServiceGrpc.getSayHelloMethod) == null) {
      synchronized (CrossLangServiceGrpc.class) {
        if ((getSayHelloMethod = CrossLangServiceGrpc.getSayHelloMethod) == null) {
          CrossLangServiceGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<cse5306.project1.HelloRequest, cse5306.project1.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cse5306.project1.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cse5306.project1.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new CrossLangServiceMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CrossLangServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossLangServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrossLangServiceStub>() {
        @java.lang.Override
        public CrossLangServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrossLangServiceStub(channel, callOptions);
        }
      };
    return CrossLangServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static CrossLangServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossLangServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrossLangServiceBlockingV2Stub>() {
        @java.lang.Override
        public CrossLangServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrossLangServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return CrossLangServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CrossLangServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossLangServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrossLangServiceBlockingStub>() {
        @java.lang.Override
        public CrossLangServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrossLangServiceBlockingStub(channel, callOptions);
        }
      };
    return CrossLangServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CrossLangServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossLangServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrossLangServiceFutureStub>() {
        @java.lang.Override
        public CrossLangServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrossLangServiceFutureStub(channel, callOptions);
        }
      };
    return CrossLangServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sayHello(cse5306.project1.HelloRequest request,
        io.grpc.stub.StreamObserver<cse5306.project1.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CrossLangService.
   */
  public static abstract class CrossLangServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CrossLangServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CrossLangService.
   */
  public static final class CrossLangServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CrossLangServiceStub> {
    private CrossLangServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossLangServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossLangServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(cse5306.project1.HelloRequest request,
        io.grpc.stub.StreamObserver<cse5306.project1.HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CrossLangService.
   */
  public static final class CrossLangServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CrossLangServiceBlockingV2Stub> {
    private CrossLangServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossLangServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossLangServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public cse5306.project1.HelloReply sayHello(cse5306.project1.HelloRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CrossLangService.
   */
  public static final class CrossLangServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CrossLangServiceBlockingStub> {
    private CrossLangServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossLangServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossLangServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cse5306.project1.HelloReply sayHello(cse5306.project1.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CrossLangService.
   */
  public static final class CrossLangServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CrossLangServiceFutureStub> {
    private CrossLangServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossLangServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossLangServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cse5306.project1.HelloReply> sayHello(
        cse5306.project1.HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((cse5306.project1.HelloRequest) request,
              (io.grpc.stub.StreamObserver<cse5306.project1.HelloReply>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSayHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cse5306.project1.HelloRequest,
              cse5306.project1.HelloReply>(
                service, METHODID_SAY_HELLO)))
        .build();
  }

  private static abstract class CrossLangServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CrossLangServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cse5306.project1.Project1Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CrossLangService");
    }
  }

  private static final class CrossLangServiceFileDescriptorSupplier
      extends CrossLangServiceBaseDescriptorSupplier {
    CrossLangServiceFileDescriptorSupplier() {}
  }

  private static final class CrossLangServiceMethodDescriptorSupplier
      extends CrossLangServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CrossLangServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CrossLangServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CrossLangServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
