package com.blued.im.private_chat;

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

public final class PrivateChatGrpc {
  private static final int METHODID_SEND = 0;
  
  public static final String SERVICE_NAME = "com.blued.im.private_chat.PrivateChat";
  
  private static volatile MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> getSendMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  public static MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> getSendMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/private_chat/PrivateChatGrpc.getSendMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/private_chat/PrivateChatGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/private_chat/PrivateChatGrpc.getSendMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.private_chat.PrivateChat'
    //   32: ldc 'Send'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/PrivateChatOuterClass$Request;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/PrivateChatOuterClass$Response;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new com/blued/im/private_chat/PrivateChatGrpc$PrivateChatMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'Send'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/private_chat/PrivateChatGrpc.getSendMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/private_chat/PrivateChatGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/private_chat/PrivateChatGrpc
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
    //   0: getstatic com/blued/im/private_chat/PrivateChatGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 61
    //   8: ldc com/blued/im/private_chat/PrivateChatGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/private_chat/PrivateChatGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 50
    //   21: ldc 'com.blued.im.private_chat.PrivateChat'
    //   23: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   26: new com/blued/im/private_chat/PrivateChatGrpc$PrivateChatFileDescriptorSupplier
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/ServiceDescriptor$Builder;
    //   36: invokestatic getSendMethod : ()Lio/grpc/MethodDescriptor;
    //   39: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   42: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   45: astore_0
    //   46: aload_0
    //   47: putstatic com/blued/im/private_chat/PrivateChatGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   50: ldc com/blued/im/private_chat/PrivateChatGrpc
    //   52: monitorexit
    //   53: aload_0
    //   54: areturn
    //   55: astore_0
    //   56: ldc com/blued/im/private_chat/PrivateChatGrpc
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
  
  public static PrivateChatBlockingStub newBlockingStub(Channel paramChannel) {
    return (PrivateChatBlockingStub)PrivateChatBlockingStub.newStub(new AbstractStub.StubFactory<PrivateChatBlockingStub>() {
          public PrivateChatGrpc.PrivateChatBlockingStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new PrivateChatGrpc.PrivateChatBlockingStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static PrivateChatFutureStub newFutureStub(Channel paramChannel) {
    return (PrivateChatFutureStub)PrivateChatFutureStub.newStub(new AbstractStub.StubFactory<PrivateChatFutureStub>() {
          public PrivateChatGrpc.PrivateChatFutureStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new PrivateChatGrpc.PrivateChatFutureStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static PrivateChatStub newStub(Channel paramChannel) {
    return (PrivateChatStub)PrivateChatStub.newStub(new AbstractStub.StubFactory<PrivateChatStub>() {
          public PrivateChatGrpc.PrivateChatStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new PrivateChatGrpc.PrivateChatStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
    private final int methodId;
    
    private final PrivateChatGrpc.PrivateChatImplBase serviceImpl;
    
    MethodHandlers(PrivateChatGrpc.PrivateChatImplBase param1PrivateChatImplBase, int param1Int) {
      this.serviceImpl = param1PrivateChatImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      throw new AssertionError();
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      if (this.methodId == 0) {
        this.serviceImpl.send((PrivateChatOuterClass.Request)param1Req, (StreamObserver)param1StreamObserver);
        return;
      } 
      throw new AssertionError();
    }
  }
  
  static abstract class PrivateChatBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
    public Descriptors.FileDescriptor getFileDescriptor() {
      return PrivateChatOuterClass.getDescriptor();
    }
    
    public Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrivateChat");
    }
  }
  
  public static final class PrivateChatBlockingStub extends AbstractBlockingStub<PrivateChatBlockingStub> {
    private PrivateChatBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected PrivateChatBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new PrivateChatBlockingStub(param1Channel, param1CallOptions);
    }
    
    public PrivateChatOuterClass.Response send(PrivateChatOuterClass.Request param1Request) {
      return (PrivateChatOuterClass.Response)ClientCalls.blockingUnaryCall(getChannel(), PrivateChatGrpc.getSendMethod(), getCallOptions(), param1Request);
    }
  }
  
  static final class PrivateChatFileDescriptorSupplier extends PrivateChatBaseDescriptorSupplier {}
  
  public static final class PrivateChatFutureStub extends AbstractFutureStub<PrivateChatFutureStub> {
    private PrivateChatFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected PrivateChatFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new PrivateChatFutureStub(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<PrivateChatOuterClass.Response> send(PrivateChatOuterClass.Request param1Request) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(PrivateChatGrpc.getSendMethod(), getCallOptions()), param1Request);
    }
  }
  
  public static abstract class PrivateChatImplBase implements BindableService {
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(PrivateChatGrpc.getServiceDescriptor()).addMethod(PrivateChatGrpc.getSendMethod(), ServerCalls.asyncUnaryCall(new PrivateChatGrpc.MethodHandlers<Object, Object>(this, 0))).build();
    }
    
    public void send(PrivateChatOuterClass.Request param1Request, StreamObserver<PrivateChatOuterClass.Response> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(PrivateChatGrpc.getSendMethod(), param1StreamObserver);
    }
  }
  
  static final class PrivateChatMethodDescriptorSupplier extends PrivateChatBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
    private final String methodName;
    
    PrivateChatMethodDescriptorSupplier(String param1String) {
      this.methodName = param1String;
    }
    
    public Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(this.methodName);
    }
  }
  
  public static final class PrivateChatStub extends AbstractAsyncStub<PrivateChatStub> {
    private PrivateChatStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected PrivateChatStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new PrivateChatStub(param1Channel, param1CallOptions);
    }
    
    public void send(PrivateChatOuterClass.Request param1Request, StreamObserver<PrivateChatOuterClass.Response> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(PrivateChatGrpc.getSendMethod(), getCallOptions()), param1Request, param1StreamObserver);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\PrivateChatGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */