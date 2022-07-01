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

public final class ReceiptGrpc {
  private static final int METHODID_DEL_ALL = 3;
  
  private static final int METHODID_DEL_SESSION = 4;
  
  private static final int METHODID_GOT = 0;
  
  private static final int METHODID_READ = 1;
  
  private static final int METHODID_RETRACT = 2;
  
  public static final String SERVICE_NAME = "com.blued.im.private_chat.Receipt";
  
  private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelAllMethod;
  
  private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelSessionMethod;
  
  private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getGotMethod;
  
  private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getReadMethod;
  
  private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getRetractMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelAllMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/private_chat/ReceiptGrpc.getDelAllMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/private_chat/ReceiptGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/private_chat/ReceiptGrpc.getDelAllMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.private_chat.Receipt'
    //   32: ldc 'DelAll'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptRequest;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptResponse;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new com/blued/im/private_chat/ReceiptGrpc$ReceiptMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'DelAll'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/private_chat/ReceiptGrpc.getDelAllMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/private_chat/ReceiptGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/private_chat/ReceiptGrpc
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
  
  public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelSessionMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/private_chat/ReceiptGrpc.getDelSessionMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/private_chat/ReceiptGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/private_chat/ReceiptGrpc.getDelSessionMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.private_chat.Receipt'
    //   32: ldc 'DelSession'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptRequest;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptResponse;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new com/blued/im/private_chat/ReceiptGrpc$ReceiptMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'DelSession'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/private_chat/ReceiptGrpc.getDelSessionMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/private_chat/ReceiptGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/private_chat/ReceiptGrpc
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
  
  public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getGotMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/private_chat/ReceiptGrpc.getGotMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/private_chat/ReceiptGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/private_chat/ReceiptGrpc.getGotMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.private_chat.Receipt'
    //   32: ldc 'Got'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptRequest;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptResponse;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new com/blued/im/private_chat/ReceiptGrpc$ReceiptMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'Got'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/private_chat/ReceiptGrpc.getGotMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/private_chat/ReceiptGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/private_chat/ReceiptGrpc
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
  
  public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getReadMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/private_chat/ReceiptGrpc.getReadMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/private_chat/ReceiptGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/private_chat/ReceiptGrpc.getReadMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.private_chat.Receipt'
    //   32: ldc 'Read'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptRequest;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptResponse;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new com/blued/im/private_chat/ReceiptGrpc$ReceiptMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'Read'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/private_chat/ReceiptGrpc.getReadMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/private_chat/ReceiptGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/private_chat/ReceiptGrpc
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
  
  public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getRetractMethod() {
    // Byte code:
    //   0: getstatic com/blued/im/private_chat/ReceiptGrpc.getRetractMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/im/private_chat/ReceiptGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/private_chat/ReceiptGrpc.getRetractMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.im.private_chat.Receipt'
    //   32: ldc 'Retract'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptRequest;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcom/blued/im/private_chat/ReceiptOuterClass$ReceiptResponse;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new com/blued/im/private_chat/ReceiptGrpc$ReceiptMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'Retract'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/im/private_chat/ReceiptGrpc.getRetractMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/im/private_chat/ReceiptGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/im/private_chat/ReceiptGrpc
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
    //   0: getstatic com/blued/im/private_chat/ReceiptGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 85
    //   8: ldc com/blued/im/private_chat/ReceiptGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/im/private_chat/ReceiptGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 74
    //   21: ldc 'com.blued.im.private_chat.Receipt'
    //   23: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   26: new com/blued/im/private_chat/ReceiptGrpc$ReceiptFileDescriptorSupplier
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/ServiceDescriptor$Builder;
    //   36: invokestatic getGotMethod : ()Lio/grpc/MethodDescriptor;
    //   39: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   42: invokestatic getReadMethod : ()Lio/grpc/MethodDescriptor;
    //   45: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   48: invokestatic getRetractMethod : ()Lio/grpc/MethodDescriptor;
    //   51: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   54: invokestatic getDelAllMethod : ()Lio/grpc/MethodDescriptor;
    //   57: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   60: invokestatic getDelSessionMethod : ()Lio/grpc/MethodDescriptor;
    //   63: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   66: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   69: astore_0
    //   70: aload_0
    //   71: putstatic com/blued/im/private_chat/ReceiptGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   74: ldc com/blued/im/private_chat/ReceiptGrpc
    //   76: monitorexit
    //   77: aload_0
    //   78: areturn
    //   79: astore_0
    //   80: ldc com/blued/im/private_chat/ReceiptGrpc
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    //   85: aload_0
    //   86: areturn
    // Exception table:
    //   from	to	target	type
    //   11	15	79	finally
    //   21	74	79	finally
    //   74	77	79	finally
    //   80	83	79	finally
  }
  
  public static ReceiptBlockingStub newBlockingStub(Channel paramChannel) {
    return (ReceiptBlockingStub)ReceiptBlockingStub.newStub(new AbstractStub.StubFactory<ReceiptBlockingStub>() {
          public ReceiptGrpc.ReceiptBlockingStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ReceiptGrpc.ReceiptBlockingStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static ReceiptFutureStub newFutureStub(Channel paramChannel) {
    return (ReceiptFutureStub)ReceiptFutureStub.newStub(new AbstractStub.StubFactory<ReceiptFutureStub>() {
          public ReceiptGrpc.ReceiptFutureStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ReceiptGrpc.ReceiptFutureStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static ReceiptStub newStub(Channel paramChannel) {
    return (ReceiptStub)ReceiptStub.newStub(new AbstractStub.StubFactory<ReceiptStub>() {
          public ReceiptGrpc.ReceiptStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ReceiptGrpc.ReceiptStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
    private final int methodId;
    
    private final ReceiptGrpc.ReceiptImplBase serviceImpl;
    
    MethodHandlers(ReceiptGrpc.ReceiptImplBase param1ReceiptImplBase, int param1Int) {
      this.serviceImpl = param1ReceiptImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      throw new AssertionError();
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i == 4) {
                this.serviceImpl.delSession((ReceiptOuterClass.ReceiptRequest)param1Req, (StreamObserver)param1StreamObserver);
                return;
              } 
              throw new AssertionError();
            } 
            this.serviceImpl.delAll((ReceiptOuterClass.ReceiptRequest)param1Req, (StreamObserver)param1StreamObserver);
            return;
          } 
          this.serviceImpl.retract((ReceiptOuterClass.ReceiptRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        } 
        this.serviceImpl.read((ReceiptOuterClass.ReceiptRequest)param1Req, (StreamObserver)param1StreamObserver);
        return;
      } 
      this.serviceImpl.got((ReceiptOuterClass.ReceiptRequest)param1Req, (StreamObserver)param1StreamObserver);
    }
  }
  
  static abstract class ReceiptBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
    public Descriptors.FileDescriptor getFileDescriptor() {
      return ReceiptOuterClass.getDescriptor();
    }
    
    public Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Receipt");
    }
  }
  
  public static final class ReceiptBlockingStub extends AbstractBlockingStub<ReceiptBlockingStub> {
    private ReceiptBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected ReceiptBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ReceiptBlockingStub(param1Channel, param1CallOptions);
    }
    
    public ReceiptOuterClass.ReceiptResponse delAll(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return (ReceiptOuterClass.ReceiptResponse)ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getDelAllMethod(), getCallOptions(), param1ReceiptRequest);
    }
    
    public ReceiptOuterClass.ReceiptResponse delSession(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return (ReceiptOuterClass.ReceiptResponse)ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getDelSessionMethod(), getCallOptions(), param1ReceiptRequest);
    }
    
    public ReceiptOuterClass.ReceiptResponse got(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return (ReceiptOuterClass.ReceiptResponse)ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getGotMethod(), getCallOptions(), param1ReceiptRequest);
    }
    
    public ReceiptOuterClass.ReceiptResponse read(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return (ReceiptOuterClass.ReceiptResponse)ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getReadMethod(), getCallOptions(), param1ReceiptRequest);
    }
    
    public ReceiptOuterClass.ReceiptResponse retract(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return (ReceiptOuterClass.ReceiptResponse)ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getRetractMethod(), getCallOptions(), param1ReceiptRequest);
    }
  }
  
  static final class ReceiptFileDescriptorSupplier extends ReceiptBaseDescriptorSupplier {}
  
  public static final class ReceiptFutureStub extends AbstractFutureStub<ReceiptFutureStub> {
    private ReceiptFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected ReceiptFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ReceiptFutureStub(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<ReceiptOuterClass.ReceiptResponse> delAll(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getDelAllMethod(), getCallOptions()), param1ReceiptRequest);
    }
    
    public ListenableFuture<ReceiptOuterClass.ReceiptResponse> delSession(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getDelSessionMethod(), getCallOptions()), param1ReceiptRequest);
    }
    
    public ListenableFuture<ReceiptOuterClass.ReceiptResponse> got(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getGotMethod(), getCallOptions()), param1ReceiptRequest);
    }
    
    public ListenableFuture<ReceiptOuterClass.ReceiptResponse> read(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getReadMethod(), getCallOptions()), param1ReceiptRequest);
    }
    
    public ListenableFuture<ReceiptOuterClass.ReceiptResponse> retract(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getRetractMethod(), getCallOptions()), param1ReceiptRequest);
    }
  }
  
  public static abstract class ReceiptImplBase implements BindableService {
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(ReceiptGrpc.getServiceDescriptor()).addMethod(ReceiptGrpc.getGotMethod(), ServerCalls.asyncUnaryCall(new ReceiptGrpc.MethodHandlers<Object, Object>(this, 0))).addMethod(ReceiptGrpc.getReadMethod(), ServerCalls.asyncUnaryCall(new ReceiptGrpc.MethodHandlers<Object, Object>(this, 1))).addMethod(ReceiptGrpc.getRetractMethod(), ServerCalls.asyncUnaryCall(new ReceiptGrpc.MethodHandlers<Object, Object>(this, 2))).addMethod(ReceiptGrpc.getDelAllMethod(), ServerCalls.asyncUnaryCall(new ReceiptGrpc.MethodHandlers<Object, Object>(this, 3))).addMethod(ReceiptGrpc.getDelSessionMethod(), ServerCalls.asyncUnaryCall(new ReceiptGrpc.MethodHandlers<Object, Object>(this, 4))).build();
    }
    
    public void delAll(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getDelAllMethod(), param1StreamObserver);
    }
    
    public void delSession(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getDelSessionMethod(), param1StreamObserver);
    }
    
    public void got(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getGotMethod(), param1StreamObserver);
    }
    
    public void read(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getReadMethod(), param1StreamObserver);
    }
    
    public void retract(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getRetractMethod(), param1StreamObserver);
    }
  }
  
  static final class ReceiptMethodDescriptorSupplier extends ReceiptBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
    private final String methodName;
    
    ReceiptMethodDescriptorSupplier(String param1String) {
      this.methodName = param1String;
    }
    
    public Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(this.methodName);
    }
  }
  
  public static final class ReceiptStub extends AbstractAsyncStub<ReceiptStub> {
    private ReceiptStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected ReceiptStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ReceiptStub(param1Channel, param1CallOptions);
    }
    
    public void delAll(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getDelAllMethod(), getCallOptions()), param1ReceiptRequest, param1StreamObserver);
    }
    
    public void delSession(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getDelSessionMethod(), getCallOptions()), param1ReceiptRequest, param1StreamObserver);
    }
    
    public void got(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getGotMethod(), getCallOptions()), param1ReceiptRequest, param1StreamObserver);
    }
    
    public void read(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getReadMethod(), getCallOptions()), param1ReceiptRequest, param1StreamObserver);
    }
    
    public void retract(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getRetractMethod(), getCallOptions()), param1ReceiptRequest, param1StreamObserver);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\ReceiptGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */