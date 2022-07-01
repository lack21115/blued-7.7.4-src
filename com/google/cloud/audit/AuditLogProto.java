package com.google.cloud.audit;

import com.google.api.AnnotationsProto;
import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.StructProto;
import com.google.rpc.StatusProto;

public final class AuditLogProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { 
        "ServiceName", "MethodName", "ResourceName", "NumResponseItems", "Status", "AuthenticationInfo", "AuthorizationInfo", "RequestMetadata", "Request", "Response", 
        "ServiceData" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "PrincipalEmail" });
  
  static final Descriptors.Descriptor e = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Resource", "Permission", "Granted" });
  
  static final Descriptors.Descriptor g = a().getMessageTypes().get(3);
  
  static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "CallerIp", "CallerSuppliedUserAgent" });
  
  private static Descriptors.FileDescriptor i;
  
  static {
    AnnotationsProto.a();
    AnyProto.getDescriptor();
    StructProto.getDescriptor();
    StatusProto.a();
  }
  
  public static Descriptors.FileDescriptor a() {
    return i;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          AuditLogProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor1 = AnnotationsProto.a();
    Descriptors.FileDescriptor fileDescriptor2 = AnyProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor3 = StructProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor4 = StatusProto.a();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\"google/cloud/audit/audit_log.proto\022\022google.cloud.audit\032\034google/api/annotations.proto\032\031google/protobuf/any.proto\032\034google/protobuf/struct.proto\032\027google/rpc/status.proto\"Ô\003\n\bAuditLog\022\024\n\fservice_name\030\007 \001(\t\022\023\n\013method_name\030\b \001(\t\022\025\n\rresource_name\030\013 \001(\t\022\032\n\022num_response_items\030\f \001(\003\022\"\n\006status\030\002 \001(\0132\022.google.rpc.Status\022C\n\023authentication_info\030\003 \001(\0132&.google.cloud.audit.AuthenticationInfo\022A\n\022authorization_info\030\t \003(\0132%.google.cloud.audit.AuthorizationInfo\022=\n\020request_metadata\030\004 \001(\0132#.google.cloud.audit.RequestMetadata\022(\n\007request\030\020 \001(\0132\027.google.protobuf.Struct\022)\n\bresponse\030\021 \001(\0132\027.google.protobuf.Struct\022*\n\fservice_data\030\017 \001(\0132\024.google.protobuf.Any\"-\n\022AuthenticationInfo\022\027\n\017principal_email\030\001 \001(\t\"J\n\021AuthorizationInfo\022\020\n\bresource\030\001 \001(\t\022\022\n\npermission\030\002 \001(\t\022\017\n\007granted\030\003 \001(\b\"H\n\017RequestMetadata\022\021\n\tcaller_ip\030\001 \001(\t\022\"\n\032caller_supplied_user_agent\030\002 \001(\tBb\n\026com.google.cloud.auditB\rAuditLogProtoP\001Z7google.golang.org/genproto/googleapis/cloud/audit;auditb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2, fileDescriptor3, fileDescriptor4 }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\AuditLogProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */