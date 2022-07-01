package com.blued.im;

import com.google.common.util.concurrent.ListenableFuture;
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

public final class ConnectorGrpc {
  private static final int METHODID_CONNECT = 2;
  
  private static final int METHODID_KICK = 1;
  
  private static final int METHODID_SEND = 0;
  
  public static final String SERVICE_NAME = "com.blued.im.Connector";
  
  private static volatile MethodDescriptor<Any, Any> getConnectMethod;
  
  private static volatile MethodDescriptor<Any, Any> getKickMethod;
  
  private static volatile MethodDescriptor<Any, Any> getSendMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  public static MethodDescriptor<Any, Any> getConnectMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/ConnectorGrpc.getConnectMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/ConnectorGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/ConnectorGrpc.getConnectMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.BIDI_STREAMING : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.Connector'
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
    //   62: new com/blued/im/ConnectorGrpc$ConnectorMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'Connect'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/ConnectorGrpc.getConnectMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/ConnectorGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/ConnectorGrpc
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
  
  public static MethodDescriptor<Any, Any> getKickMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/ConnectorGrpc.getKickMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/ConnectorGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/ConnectorGrpc.getKickMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.Connector'
    //   32: ldc 'Kick'
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
    //   62: new com/blued/im/ConnectorGrpc$ConnectorMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'Kick'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/ConnectorGrpc.getKickMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/ConnectorGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/ConnectorGrpc
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
  
  public static MethodDescriptor<Any, Any> getSendMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/ConnectorGrpc.getSendMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/ConnectorGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/ConnectorGrpc.getSendMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.Connector'
    //   32: ldc 'Send'
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
    //   62: new com/blued/im/ConnectorGrpc$ConnectorMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'Send'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/ConnectorGrpc.getSendMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/ConnectorGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/ConnectorGrpc
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
    //   0: getstatic com/blued/im/ConnectorGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 73
    //   8: ldc com/blued/im/ConnectorGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/ConnectorGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 62
    //   21: ldc 'com.blued.im.Connector'
    //   23: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   26: new com/blued/im/ConnectorGrpc$ConnectorFileDescriptorSupplier
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/ServiceDescriptor$Builder;
    //   36: invokestatic getConnectMethod : ()Lio/grpc/MethodDescriptor;
    //   39: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   42: invokestatic getSendMethod : ()Lio/grpc/MethodDescriptor;
    //   45: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   48: invokestatic getKickMethod : ()Lio/grpc/MethodDescriptor;
    //   51: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   54: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   57: astore_0
    //   58: aload_0
    //   59: putstatic com/blued/im/ConnectorGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   62: ldc com/blued/im/ConnectorGrpc
    //   64: monitorexit
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: ldc com/blued/im/ConnectorGrpc
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    //   73: aload_0
    //   74: areturn
    // Exception table:
    //   from	to	target	type
    //   11	15	67	finally
    //   21	62	67	finally
    //   62	65	67	finally
    //   68	71	67	finally
  }
  
  public static ConnectorBlockingStub newBlockingStub(Channel paramChannel) {
    return (ConnectorBlockingStub)ConnectorBlockingStub.newStub(new AbstractStub.StubFactory<ConnectorBlockingStub>() {
          public ConnectorGrpc.ConnectorBlockingStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ConnectorGrpc.ConnectorBlockingStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static ConnectorFutureStub newFutureStub(Channel paramChannel) {
    return (ConnectorFutureStub)ConnectorFutureStub.newStub(new AbstractStub.StubFactory<ConnectorFutureStub>() {
          public ConnectorGrpc.ConnectorFutureStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ConnectorGrpc.ConnectorFutureStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static ConnectorStub newStub(Channel paramChannel) {
    return (ConnectorStub)ConnectorStub.newStub(new AbstractStub.StubFactory<ConnectorStub>() {
          public ConnectorGrpc.ConnectorStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ConnectorGrpc.ConnectorStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  static abstract class ConnectorBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
    public Descriptors.FileDescriptor getFileDescriptor() {
      return ConnectorOuterClass.getDescriptor();
    }
    
    public Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Connector");
    }
  }
  
  public static final class ConnectorBlockingStub extends AbstractBlockingStub<ConnectorBlockingStub> {
    private ConnectorBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected ConnectorBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ConnectorBlockingStub(param1Channel, param1CallOptions);
    }
    
    public Any kick(Any param1Any) {
      return (Any)ClientCalls.blockingUnaryCall(getChannel(), ConnectorGrpc.getKickMethod(), getCallOptions(), param1Any);
    }
    
    public Any send(Any param1Any) {
      return (Any)ClientCalls.blockingUnaryCall(getChannel(), ConnectorGrpc.getSendMethod(), getCallOptions(), param1Any);
    }
  }
  
  static final class ConnectorFileDescriptorSupplier extends ConnectorBaseDescriptorSupplier {}
  
  public static final class ConnectorFutureStub extends AbstractFutureStub<ConnectorFutureStub> {
    private ConnectorFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected ConnectorFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ConnectorFutureStub(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<Any> kick(Any param1Any) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ConnectorGrpc.getKickMethod(), getCallOptions()), param1Any);
    }
    
    public ListenableFuture<Any> send(Any param1Any) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ConnectorGrpc.getSendMethod(), getCallOptions()), param1Any);
    }
  }
  
  public static abstract class ConnectorImplBase implements BindableService {
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(ConnectorGrpc.getServiceDescriptor()).addMethod(ConnectorGrpc.getConnectMethod(), ServerCalls.asyncBidiStreamingCall(new ConnectorGrpc.MethodHandlers<Object, Object>(this, 2))).addMethod(ConnectorGrpc.getSendMethod(), ServerCalls.asyncUnaryCall(new ConnectorGrpc.MethodHandlers<Object, Object>(this, 0))).addMethod(ConnectorGrpc.getKickMethod(), ServerCalls.asyncUnaryCall(new ConnectorGrpc.MethodHandlers<Object, Object>(this, 1))).build();
    }
    
    public StreamObserver<Any> connect(StreamObserver<Any> param1StreamObserver) {
      return ServerCalls.asyncUnimplementedStreamingCall(ConnectorGrpc.getConnectMethod(), param1StreamObserver);
    }
    
    public void kick(Any param1Any, StreamObserver<Any> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(ConnectorGrpc.getKickMethod(), param1StreamObserver);
    }
    
    public void send(Any param1Any, StreamObserver<Any> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(ConnectorGrpc.getSendMethod(), param1StreamObserver);
    }
  }
  
  static final class ConnectorMethodDescriptorSupplier extends ConnectorBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
    private final String methodName;
    
    ConnectorMethodDescriptorSupplier(String param1String) {
      this.methodName = param1String;
    }
    
    public Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(this.methodName);
    }
  }
  
  public static final class ConnectorStub extends AbstractAsyncStub<ConnectorStub> {
    private ConnectorStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected ConnectorStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ConnectorStub(param1Channel, param1CallOptions);
    }
    
    public StreamObserver<Any> connect(StreamObserver<Any> param1StreamObserver) {
      return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(ConnectorGrpc.getConnectMethod(), getCallOptions()), param1StreamObserver);
    }
    
    public void kick(Any param1Any, StreamObserver<Any> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ConnectorGrpc.getKickMethod(), getCallOptions()), param1Any, param1StreamObserver);
    }
    
    public void send(Any param1Any, StreamObserver<Any> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ConnectorGrpc.getSendMethod(), getCallOptions()), param1Any, param1StreamObserver);
    }
  }
  
  static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
    private final int methodId;
    
    private final ConnectorGrpc.ConnectorImplBase serviceImpl;
    
    MethodHandlers(ConnectorGrpc.ConnectorImplBase param1ConnectorImplBase, int param1Int) {
      this.serviceImpl = param1ConnectorImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      if (this.methodId == 2)
        return (StreamObserver)this.serviceImpl.connect((StreamObserver)param1StreamObserver); 
      throw new AssertionError();
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      if (i != 0) {
        if (i == 1) {
          this.serviceImpl.kick((Any)param1Req, (StreamObserver)param1StreamObserver);
          return;
        } 
        throw new AssertionError();
      } 
      this.serviceImpl.send((Any)param1Req, (StreamObserver)param1StreamObserver);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\ConnectorGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */