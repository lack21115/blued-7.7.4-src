package cn.irisgw.live;

import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.ProtoFileDescriptorSupplier;
import io.grpc.protobuf.ProtoMethodDescriptorSupplier;
import io.grpc.protobuf.ProtoServiceDescriptorSupplier;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractBlockingStub;
import io.grpc.stub.AbstractFutureStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

public final class LiveConnectorGrpc {
  private static final int METHODID_CONNECT = 0;
  
  public static final String SERVICE_NAME = "cn.irisgw.live.LiveConnector";
  
  private static volatile MethodDescriptor<Any, Any> getConnectMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  public static MethodDescriptor<Any, Any> getConnectMethod() {
    // Byte code:
    //   0: getstatic cn/irisgw/live/LiveConnectorGrpc.getConnectMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc cn/irisgw/live/LiveConnectorGrpc
    //   10: monitorenter
    //   11: getstatic cn/irisgw/live/LiveConnectorGrpc.getConnectMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.BIDI_STREAMING : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'cn.irisgw.live.LiveConnector'
    //   32: ldc 'Connect'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcom/google/protobuf/Any;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcom/google/protobuf/Any;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new cn/irisgw/live/LiveConnectorGrpc$LiveConnectorMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'Connect'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic cn/irisgw/live/LiveConnectorGrpc.getConnectMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc cn/irisgw/live/LiveConnectorGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc cn/irisgw/live/LiveConnectorGrpc
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    //   93: aload_0
    //   94: areturn
    // Exception table:
    //   from	to	target	type
    //   11	15	87	finally
    //   21	82	87	finally
    //   82	85	87	finally
    //   88	91	87	finally
  }
  
  public static ServiceDescriptor getServiceDescriptor() {
    // Byte code:
    //   0: getstatic cn/irisgw/live/LiveConnectorGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 61
    //   8: ldc cn/irisgw/live/LiveConnectorGrpc
    //   10: monitorenter
    //   11: getstatic cn/irisgw/live/LiveConnectorGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 50
    //   21: ldc 'cn.irisgw.live.LiveConnector'
    //   23: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   26: new cn/irisgw/live/LiveConnectorGrpc$LiveConnectorFileDescriptorSupplier
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/ServiceDescriptor$Builder;
    //   36: invokestatic getConnectMethod : ()Lio/grpc/MethodDescriptor;
    //   39: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   42: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   45: astore_0
    //   46: aload_0
    //   47: putstatic cn/irisgw/live/LiveConnectorGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   50: ldc cn/irisgw/live/LiveConnectorGrpc
    //   52: monitorexit
    //   53: aload_0
    //   54: areturn
    //   55: astore_0
    //   56: ldc cn/irisgw/live/LiveConnectorGrpc
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    //   61: aload_0
    //   62: areturn
    // Exception table:
    //   from	to	target	type
    //   11	15	55	finally
    //   21	50	55	finally
    //   50	53	55	finally
    //   56	59	55	finally
  }
  
  public static LiveConnectorBlockingStub newBlockingStub(Channel paramChannel) {
    return (LiveConnectorBlockingStub)LiveConnectorBlockingStub.newStub(new AbstractStub.StubFactory<LiveConnectorBlockingStub>() {
          public LiveConnectorGrpc.LiveConnectorBlockingStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new LiveConnectorGrpc.LiveConnectorBlockingStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static LiveConnectorFutureStub newFutureStub(Channel paramChannel) {
    return (LiveConnectorFutureStub)LiveConnectorFutureStub.newStub(new AbstractStub.StubFactory<LiveConnectorFutureStub>() {
          public LiveConnectorGrpc.LiveConnectorFutureStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new LiveConnectorGrpc.LiveConnectorFutureStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static LiveConnectorStub newStub(Channel paramChannel) {
    return (LiveConnectorStub)LiveConnectorStub.newStub(new AbstractStub.StubFactory<LiveConnectorStub>() {
          public LiveConnectorGrpc.LiveConnectorStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new LiveConnectorGrpc.LiveConnectorStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  static abstract class LiveConnectorBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
    public Descriptors.FileDescriptor getFileDescriptor() {
      return LiveConnect.getDescriptor();
    }
    
    public Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LiveConnector");
    }
  }
  
  public static final class LiveConnectorBlockingStub extends AbstractBlockingStub<LiveConnectorBlockingStub> {
    private LiveConnectorBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected LiveConnectorBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new LiveConnectorBlockingStub(param1Channel, param1CallOptions);
    }
  }
  
  static final class LiveConnectorFileDescriptorSupplier extends LiveConnectorBaseDescriptorSupplier {}
  
  public static final class LiveConnectorFutureStub extends AbstractFutureStub<LiveConnectorFutureStub> {
    private LiveConnectorFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected LiveConnectorFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new LiveConnectorFutureStub(param1Channel, param1CallOptions);
    }
  }
  
  public static abstract class LiveConnectorImplBase implements BindableService {
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(LiveConnectorGrpc.getServiceDescriptor()).addMethod(LiveConnectorGrpc.getConnectMethod(), ServerCalls.asyncBidiStreamingCall(new LiveConnectorGrpc.MethodHandlers<Object, Object>(this, 0))).build();
    }
    
    public StreamObserver<Any> connect(StreamObserver<Any> param1StreamObserver) {
      return ServerCalls.asyncUnimplementedStreamingCall(LiveConnectorGrpc.getConnectMethod(), param1StreamObserver);
    }
  }
  
  static final class LiveConnectorMethodDescriptorSupplier extends LiveConnectorBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
    private final String methodName;
    
    LiveConnectorMethodDescriptorSupplier(String param1String) {
      this.methodName = param1String;
    }
    
    public Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(this.methodName);
    }
  }
  
  public static final class LiveConnectorStub extends AbstractAsyncStub<LiveConnectorStub> {
    private LiveConnectorStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected LiveConnectorStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new LiveConnectorStub(param1Channel, param1CallOptions);
    }
    
    public StreamObserver<Any> connect(StreamObserver<Any> param1StreamObserver) {
      return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(LiveConnectorGrpc.getConnectMethod(), getCallOptions()), param1StreamObserver);
    }
  }
  
  static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
    private final int methodId;
    
    private final LiveConnectorGrpc.LiveConnectorImplBase serviceImpl;
    
    MethodHandlers(LiveConnectorGrpc.LiveConnectorImplBase param1LiveConnectorImplBase, int param1Int) {
      this.serviceImpl = param1LiveConnectorImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      if (this.methodId == 0)
        return (StreamObserver)this.serviceImpl.connect((StreamObserver)param1StreamObserver); 
      throw new AssertionError();
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      throw new AssertionError();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\irisgw\live\LiveConnectorGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */