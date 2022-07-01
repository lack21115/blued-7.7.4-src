package com.google.longrunning;

import com.google.api.AnnotationsProto;
import com.google.protobuf.AnyProto;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DurationProto;
import com.google.protobuf.EmptyProto;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import com.google.rpc.StatusProto;

public final class OperationsProto {
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, OperationInfo> a = GeneratedMessage.newFileScopedGeneratedExtension(OperationInfo.class, (Message)OperationInfo.getDefaultInstance());
  
  static final Descriptors.Descriptor b = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable c = new GeneratedMessageV3.FieldAccessorTable(b, new String[] { "Name", "Metadata", "Done", "Error", "Response", "Result" });
  
  static final Descriptors.Descriptor d = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable e = new GeneratedMessageV3.FieldAccessorTable(d, new String[] { "Name" });
  
  static final Descriptors.Descriptor f = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable g = new GeneratedMessageV3.FieldAccessorTable(f, new String[] { "Name", "Filter", "PageSize", "PageToken" });
  
  static final Descriptors.Descriptor h = a().getMessageTypes().get(3);
  
  static final GeneratedMessageV3.FieldAccessorTable i = new GeneratedMessageV3.FieldAccessorTable(h, new String[] { "Operations", "NextPageToken" });
  
  static final Descriptors.Descriptor j = a().getMessageTypes().get(4);
  
  static final GeneratedMessageV3.FieldAccessorTable k = new GeneratedMessageV3.FieldAccessorTable(j, new String[] { "Name" });
  
  static final Descriptors.Descriptor l = a().getMessageTypes().get(5);
  
  static final GeneratedMessageV3.FieldAccessorTable m = new GeneratedMessageV3.FieldAccessorTable(l, new String[] { "Name" });
  
  static final Descriptors.Descriptor n = a().getMessageTypes().get(6);
  
  static final GeneratedMessageV3.FieldAccessorTable o = new GeneratedMessageV3.FieldAccessorTable(n, new String[] { "Name", "Timeout" });
  
  static final Descriptors.Descriptor p = a().getMessageTypes().get(7);
  
  static final GeneratedMessageV3.FieldAccessorTable q = new GeneratedMessageV3.FieldAccessorTable(p, new String[] { "ResponseType", "MetadataType" });
  
  private static Descriptors.FileDescriptor r;
  
  static {
    a.internalInit(r.getExtensions().get(0));
    ExtensionRegistry extensionRegistry = ExtensionRegistry.newInstance();
    extensionRegistry.add(AnnotationsProto.a);
    Descriptors.FileDescriptor.internalUpdateFileDescriptor(r, extensionRegistry);
    AnnotationsProto.a();
    AnyProto.getDescriptor();
    DurationProto.getDescriptor();
    EmptyProto.getDescriptor();
    StatusProto.a();
    DescriptorProtos.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return r;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          OperationsProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor1 = AnnotationsProto.a();
    Descriptors.FileDescriptor fileDescriptor2 = AnyProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor3 = DurationProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor4 = EmptyProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor5 = StatusProto.a();
    Descriptors.FileDescriptor fileDescriptor6 = DescriptorProtos.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n#google/longrunning/operations.proto\022\022google.longrunning\032\034google/api/annotations.proto\032\031google/protobuf/any.proto\032\036google/protobuf/duration.proto\032\033google/protobuf/empty.proto\032\027google/rpc/status.proto\032 google/protobuf/descriptor.proto\"¨\001\n\tOperation\022\f\n\004name\030\001 \001(\t\022&\n\bmetadata\030\002 \001(\0132\024.google.protobuf.Any\022\f\n\004done\030\003 \001(\b\022#\n\005error\030\004 \001(\0132\022.google.rpc.StatusH\000\022(\n\bresponse\030\005 \001(\0132\024.google.protobuf.AnyH\000B\b\n\006result\"#\n\023GetOperationRequest\022\f\n\004name\030\001 \001(\t\"\\\n\025ListOperationsRequest\022\f\n\004name\030\004 \001(\t\022\016\n\006filter\030\001 \001(\t\022\021\n\tpage_size\030\002 \001(\005\022\022\n\npage_token\030\003 \001(\t\"d\n\026ListOperationsResponse\0221\n\noperations\030\001 \003(\0132\035.google.longrunning.Operation\022\027\n\017next_page_token\030\002 \001(\t\"&\n\026CancelOperationRequest\022\f\n\004name\030\001 \001(\t\"&\n\026DeleteOperationRequest\022\f\n\004name\030\001 \001(\t\"P\n\024WaitOperationRequest\022\f\n\004name\030\001 \001(\t\022*\n\007timeout\030\002 \001(\0132\031.google.protobuf.Duration\"=\n\rOperationInfo\022\025\n\rresponse_type\030\001 \001(\t\022\025\n\rmetadata_type\030\002 \001(\t2è\004\n\nOperations\022\001\n\016ListOperations\022).google.longrunning.ListOperationsRequest\032*.google.longrunning.ListOperationsResponse\"\035Óä\002\027\022\025/v1/{name=operations}\022x\n\fGetOperation\022'.google.longrunning.GetOperationRequest\032\035.google.longrunning.Operation\" Óä\002\032\022\030/v1/{name=operations/**}\022w\n\017DeleteOperation\022*.google.longrunning.DeleteOperationRequest\032\026.google.protobuf.Empty\" Óä\002\032*\030/v1/{name=operations/**}\022\001\n\017CancelOperation\022*.google.longrunning.CancelOperationRequest\032\026.google.protobuf.Empty\"*Óä\002$\"\037/v1/{name=operations/**}:cancel:\001*\022Z\n\rWaitOperation\022(.google.longrunning.WaitOperationRequest\032\035.google.longrunning.Operation\"\000:Z\n\016operation_info\022\036.google.protobuf.MethodOptions\030\b \001(\0132!.google.longrunning.OperationInfoB\001\n\026com.google.longrunningB\017OperationsProtoP\001Z=google.golang.org/genproto/googleapis/longrunning;longrunningø\001\001ª\002\022Google.LongRunningÊ\002\022Google\\LongRunningb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2, fileDescriptor3, fileDescriptor4, fileDescriptor5, fileDescriptor6 }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\OperationsProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */