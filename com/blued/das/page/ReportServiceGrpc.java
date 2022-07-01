package com.blued.das.page;

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

public final class ReportServiceGrpc {
  private static final int METHODID_BATCH_REPORT = 0;
  
  public static final String SERVICE_NAME = "com.blued.das.page.ReportService";
  
  private static volatile MethodDescriptor<PageDurationProtos.Requests, PageDurationProtos.Response> getBatchReportMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  public static MethodDescriptor<PageDurationProtos.Requests, PageDurationProtos.Response> getBatchReportMethod() {
    // Byte code:
    //   0: getstatic com/blued/das/page/ReportServiceGrpc.getBatchReportMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 93
    //   8: ldc com/blued/das/page/ReportServiceGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/das/page/ReportServiceGrpc.getBatchReportMethod : Lio/grpc/MethodDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 82
    //   21: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   24: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   27: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   30: ldc 'com.blued.das.page.ReportService'
    //   32: ldc 'BatchReport'
    //   34: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   40: iconst_1
    //   41: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   44: invokestatic getDefaultInstance : ()Lcom/blued/das/page/PageDurationProtos$Requests;
    //   47: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   50: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   53: invokestatic getDefaultInstance : ()Lcom/blued/das/page/PageDurationProtos$Response;
    //   56: invokestatic marshaller : (Lcom/google/protobuf/Message;)Lio/grpc/MethodDescriptor$Marshaller;
    //   59: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   62: new com/blued/das/page/ReportServiceGrpc$ReportServiceMethodDescriptorSupplier
    //   65: dup
    //   66: ldc 'BatchReport'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/MethodDescriptor$Builder;
    //   74: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   77: astore_0
    //   78: aload_0
    //   79: putstatic com/blued/das/page/ReportServiceGrpc.getBatchReportMethod : Lio/grpc/MethodDescriptor;
    //   82: ldc com/blued/das/page/ReportServiceGrpc
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/blued/das/page/ReportServiceGrpc
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
    //   0: getstatic com/blued/das/page/ReportServiceGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 61
    //   8: ldc com/blued/das/page/ReportServiceGrpc
    //   10: monitorenter
    //   11: getstatic com/blued/das/page/ReportServiceGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 50
    //   21: ldc 'com.blued.das.page.ReportService'
    //   23: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   26: new com/blued/das/page/ReportServiceGrpc$ReportServiceFileDescriptorSupplier
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: invokevirtual setSchemaDescriptor : (Ljava/lang/Object;)Lio/grpc/ServiceDescriptor$Builder;
    //   36: invokestatic getBatchReportMethod : ()Lio/grpc/MethodDescriptor;
    //   39: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   42: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   45: astore_0
    //   46: aload_0
    //   47: putstatic com/blued/das/page/ReportServiceGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   50: ldc com/blued/das/page/ReportServiceGrpc
    //   52: monitorexit
    //   53: aload_0
    //   54: areturn
    //   55: astore_0
    //   56: ldc com/blued/das/page/ReportServiceGrpc
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
  
  public static ReportServiceBlockingStub newBlockingStub(Channel paramChannel) {
    return (ReportServiceBlockingStub)ReportServiceBlockingStub.newStub(new AbstractStub.StubFactory<ReportServiceBlockingStub>() {
          public ReportServiceGrpc.ReportServiceBlockingStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ReportServiceGrpc.ReportServiceBlockingStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static ReportServiceFutureStub newFutureStub(Channel paramChannel) {
    return (ReportServiceFutureStub)ReportServiceFutureStub.newStub(new AbstractStub.StubFactory<ReportServiceFutureStub>() {
          public ReportServiceGrpc.ReportServiceFutureStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ReportServiceGrpc.ReportServiceFutureStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  public static ReportServiceStub newStub(Channel paramChannel) {
    return (ReportServiceStub)ReportServiceStub.newStub(new AbstractStub.StubFactory<ReportServiceStub>() {
          public ReportServiceGrpc.ReportServiceStub newStub(Channel param1Channel, CallOptions param1CallOptions) {
            return new ReportServiceGrpc.ReportServiceStub(param1Channel, param1CallOptions);
          }
        }paramChannel);
  }
  
  static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
    private final int methodId;
    
    private final ReportServiceGrpc.ReportServiceImplBase serviceImpl;
    
    MethodHandlers(ReportServiceGrpc.ReportServiceImplBase param1ReportServiceImplBase, int param1Int) {
      this.serviceImpl = param1ReportServiceImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      throw new AssertionError();
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      if (this.methodId == 0) {
        this.serviceImpl.batchReport((PageDurationProtos.Requests)param1Req, (StreamObserver)param1StreamObserver);
        return;
      } 
      throw new AssertionError();
    }
  }
  
  static abstract class ReportServiceBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
    public Descriptors.FileDescriptor getFileDescriptor() {
      return PageDurationProtos.getDescriptor();
    }
    
    public Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReportService");
    }
  }
  
  public static final class ReportServiceBlockingStub extends AbstractBlockingStub<ReportServiceBlockingStub> {
    private ReportServiceBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    public PageDurationProtos.Response batchReport(PageDurationProtos.Requests param1Requests) {
      return (PageDurationProtos.Response)ClientCalls.blockingUnaryCall(getChannel(), ReportServiceGrpc.getBatchReportMethod(), getCallOptions(), param1Requests);
    }
    
    protected ReportServiceBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ReportServiceBlockingStub(param1Channel, param1CallOptions);
    }
  }
  
  static final class ReportServiceFileDescriptorSupplier extends ReportServiceBaseDescriptorSupplier {}
  
  public static final class ReportServiceFutureStub extends AbstractFutureStub<ReportServiceFutureStub> {
    private ReportServiceFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<PageDurationProtos.Response> batchReport(PageDurationProtos.Requests param1Requests) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ReportServiceGrpc.getBatchReportMethod(), getCallOptions()), param1Requests);
    }
    
    protected ReportServiceFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ReportServiceFutureStub(param1Channel, param1CallOptions);
    }
  }
  
  public static abstract class ReportServiceImplBase implements BindableService {
    public void batchReport(PageDurationProtos.Requests param1Requests, StreamObserver<PageDurationProtos.Response> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getBatchReportMethod(), param1StreamObserver);
    }
    
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(ReportServiceGrpc.getServiceDescriptor()).addMethod(ReportServiceGrpc.getBatchReportMethod(), ServerCalls.asyncUnaryCall(new ReportServiceGrpc.MethodHandlers<Object, Object>(this, 0))).build();
    }
  }
  
  static final class ReportServiceMethodDescriptorSupplier extends ReportServiceBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
    private final String methodName;
    
    ReportServiceMethodDescriptorSupplier(String param1String) {
      this.methodName = param1String;
    }
    
    public Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(this.methodName);
    }
  }
  
  public static final class ReportServiceStub extends AbstractAsyncStub<ReportServiceStub> {
    private ReportServiceStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    public void batchReport(PageDurationProtos.Requests param1Requests, StreamObserver<PageDurationProtos.Response> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ReportServiceGrpc.getBatchReportMethod(), getCallOptions()), param1Requests, param1StreamObserver);
    }
    
    protected ReportServiceStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new ReportServiceStub(param1Channel, param1CallOptions);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\page\ReportServiceGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */