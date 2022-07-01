package cn.irisgw.live;

import com.google.common.util.concurrent.ListenableFuture;
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

public final class LiveChatGrpc {
  private static final int METHODID_SEND_LIKE = 1;
  
  private static final int METHODID_SEND_MSG = 0;
  
  public static final String SERVICE_NAME = "cn.irisgw.live.LiveChat";
  
  private static volatile MethodDescriptor<LiveChatOuterClass.LiveLikeRequest, LiveChatOuterClass.LiveLikeResponse> getSendLikeMethod;
  
  private static volatile MethodDescriptor<LiveChatOuterClass.LiveMsgRequest, LiveChatOuterClass.LiveMsgResponse> getSendMsgMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  public static MethodDescriptor<LiveChatOuterClass.LiveLikeRequest, LiveChatOuterClass.LiveLikeResponse> getSendLikeMethod() {
    // Byte code:
    //   0: getstatic cn/irisgw/live/LiveChatGrpc.getSendLikeMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc cn/irisgw/live/LiveChatGrpc
    //   10: monitorenter
    //   11: getstatic cn/irisgw/live/LiveChatGrpc.getSendLikeMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'cn.irisgw.live.LiveChat'
    //   32: ldc 'SendLike'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcn/irisgw/live/LiveChatOuterClass$LiveLikeRequest;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcn/irisgw/live/LiveChatOuterClass$LiveLikeResponse;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new cn/irisgw/live/LiveChatGrpc$LiveChatMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'SendLike'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic cn/irisgw/live/LiveChatGrpc.getSendLikeMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc cn/irisgw/live/LiveChatGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc cn/irisgw/live/LiveChatGrpc
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
  
  public static MethodDescriptor<LiveChatOuterClass.LiveMsgRequest, LiveChatOuterClass.LiveMsgResponse> getSendMsgMethod() {
    // Byte code:
    //   0: getstatic cn/irisgw/live/LiveChatGrpc.getSendMsgMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc cn/irisgw/live/LiveChatGrpc
    //   10: monitorenter
    //   11: getstatic cn/irisgw/live/LiveChatGrpc.getSendMsgMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'cn.irisgw.live.LiveChat'
    //   32: ldc 'SendMsg'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcn/irisgw/live/LiveChatOuterClass$LiveMsgRequest;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcn/irisgw/live/LiveChatOuterClass$LiveMsgResponse;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new cn/irisgw/live/LiveChatGrpc$LiveChatMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'SendMsg'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic cn/irisgw/live/LiveChatGrpc.getSendMsgMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc cn/irisgw/live/LiveChatGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc cn/irisgw/live/LiveChatGrpc
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
    //   0: getstatic cn/irisgw/live/LiveChatGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 67
    //   8: ldc cn/irisgw/live/LiveChatGrpc
    //   10: monitorenter
    //   11: getstatic cn/irisgw/live/LiveChatGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 56
    //   21: ldc 'cn.irisgw.live.LiveChat'
    //   23: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   26: new cn/irisgw/live/LiveChatGrpc$LiveChatFileDescriptorSupplier
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/ServiceDescriptor$Builder;
    //   36: invokestatic getSendMsgMethod : ()Lio/grpc/MethodDescriptor;
    //   39: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   42: invokestatic getSendLikeMethod : ()Lio/grpc/MethodDescriptor;
    //   45: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   48: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   51: astore_0
    //   52: aload_0
    //   53: putstatic cn/irisgw/live/LiveChatGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   56: ldc cn/irisgw/live/LiveChatGrpc
    //   58: monitorexit
    //   59: aload_0
    //   60: areturn
    //   61: astore_0
    //   62: ldc cn/irisgw/live/LiveChatGrpc
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    //   67: aload_0
    //   68: areturn
    // Exception table:
    //   from	to	target	type
    //   11	15	61	finally
    //   21	56	61	finally
    //   56	59	61	finally
    //   62	65	61	finally
  }
  
  public static LiveChatBlockingStub newBlockingStub(Channel paramChannel) {
    return (LiveChatBlockingStub)LiveChatBlockingStub.newStub(new AbstractStub.StubFactory<LiveChatBlockingStub>() {
          public LiveChatGrpc.LiveChatBlockingStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new LiveChatGrpc.LiveChatBlockingStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static LiveChatFutureStub newFutureStub(Channel paramChannel) {
    return (LiveChatFutureStub)LiveChatFutureStub.newStub(new AbstractStub.StubFactory<LiveChatFutureStub>() {
          public LiveChatGrpc.LiveChatFutureStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new LiveChatGrpc.LiveChatFutureStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static LiveChatStub newStub(Channel paramChannel) {
    return (LiveChatStub)LiveChatStub.newStub(new AbstractStub.StubFactory<LiveChatStub>() {
          public LiveChatGrpc.LiveChatStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new LiveChatGrpc.LiveChatStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  static abstract class LiveChatBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
    public Descriptors.FileDescriptor getFileDescriptor() {
      return LiveChatOuterClass.getDescriptor();
    }
    
    public Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LiveChat");
    }
  }
  
  public static final class LiveChatBlockingStub extends AbstractBlockingStub<LiveChatBlockingStub> {
    private LiveChatBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected LiveChatBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new LiveChatBlockingStub(param1Channel, param1CallOptions);
    }
    
    public LiveChatOuterClass.LiveLikeResponse sendLike(LiveChatOuterClass.LiveLikeRequest param1LiveLikeRequest) {
      return (LiveChatOuterClass.LiveLikeResponse)ClientCalls.blockingUnaryCall(getChannel(), LiveChatGrpc.getSendLikeMethod(), getCallOptions(), param1LiveLikeRequest);
    }
    
    public LiveChatOuterClass.LiveMsgResponse sendMsg(LiveChatOuterClass.LiveMsgRequest param1LiveMsgRequest) {
      return (LiveChatOuterClass.LiveMsgResponse)ClientCalls.blockingUnaryCall(getChannel(), LiveChatGrpc.getSendMsgMethod(), getCallOptions(), param1LiveMsgRequest);
    }
  }
  
  static final class LiveChatFileDescriptorSupplier extends LiveChatBaseDescriptorSupplier {}
  
  public static final class LiveChatFutureStub extends AbstractFutureStub<LiveChatFutureStub> {
    private LiveChatFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected LiveChatFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new LiveChatFutureStub(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<LiveChatOuterClass.LiveLikeResponse> sendLike(LiveChatOuterClass.LiveLikeRequest param1LiveLikeRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(LiveChatGrpc.getSendLikeMethod(), getCallOptions()), param1LiveLikeRequest);
    }
    
    public ListenableFuture<LiveChatOuterClass.LiveMsgResponse> sendMsg(LiveChatOuterClass.LiveMsgRequest param1LiveMsgRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(LiveChatGrpc.getSendMsgMethod(), getCallOptions()), param1LiveMsgRequest);
    }
  }
  
  public static abstract class LiveChatImplBase implements BindableService {
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(LiveChatGrpc.getServiceDescriptor()).addMethod(LiveChatGrpc.getSendMsgMethod(), ServerCalls.asyncUnaryCall(new LiveChatGrpc.MethodHandlers<Object, Object>(this, 0))).addMethod(LiveChatGrpc.getSendLikeMethod(), ServerCalls.asyncUnaryCall(new LiveChatGrpc.MethodHandlers<Object, Object>(this, 1))).build();
    }
    
    public void sendLike(LiveChatOuterClass.LiveLikeRequest param1LiveLikeRequest, StreamObserver<LiveChatOuterClass.LiveLikeResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(LiveChatGrpc.getSendLikeMethod(), param1StreamObserver);
    }
    
    public void sendMsg(LiveChatOuterClass.LiveMsgRequest param1LiveMsgRequest, StreamObserver<LiveChatOuterClass.LiveMsgResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(LiveChatGrpc.getSendMsgMethod(), param1StreamObserver);
    }
  }
  
  static final class LiveChatMethodDescriptorSupplier extends LiveChatBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
    private final String methodName;
    
    LiveChatMethodDescriptorSupplier(String param1String) {
      this.methodName = param1String;
    }
    
    public Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(this.methodName);
    }
  }
  
  public static final class LiveChatStub extends AbstractAsyncStub<LiveChatStub> {
    private LiveChatStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected LiveChatStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new LiveChatStub(param1Channel, param1CallOptions);
    }
    
    public void sendLike(LiveChatOuterClass.LiveLikeRequest param1LiveLikeRequest, StreamObserver<LiveChatOuterClass.LiveLikeResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(LiveChatGrpc.getSendLikeMethod(), getCallOptions()), param1LiveLikeRequest, param1StreamObserver);
    }
    
    public void sendMsg(LiveChatOuterClass.LiveMsgRequest param1LiveMsgRequest, StreamObserver<LiveChatOuterClass.LiveMsgResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(LiveChatGrpc.getSendMsgMethod(), getCallOptions()), param1LiveMsgRequest, param1StreamObserver);
    }
  }
  
  static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
    private final int methodId;
    
    private final LiveChatGrpc.LiveChatImplBase serviceImpl;
    
    MethodHandlers(LiveChatGrpc.LiveChatImplBase param1LiveChatImplBase, int param1Int) {
      this.serviceImpl = param1LiveChatImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      throw new AssertionError();
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      if (i != 0) {
        if (i == 1) {
          this.serviceImpl.sendLike((LiveChatOuterClass.LiveLikeRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        } 
        throw new AssertionError();
      } 
      this.serviceImpl.sendMsg((LiveChatOuterClass.LiveMsgRequest)param1Req, (StreamObserver)param1StreamObserver);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\irisgw\live\LiveChatGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */