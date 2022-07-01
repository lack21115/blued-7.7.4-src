package com.google.rpc;

import com.google.protobuf.Descriptors;
import com.google.protobuf.DurationProto;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class ErrorDetailsProto {
  private static Descriptors.FileDescriptor A;
  
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "RetryDelay" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "StackEntries", "Detail" });
  
  static final Descriptors.Descriptor e = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Violations" });
  
  static final Descriptors.Descriptor g = e.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "Subject", "Description" });
  
  static final Descriptors.Descriptor i = a().getMessageTypes().get(3);
  
  static final GeneratedMessageV3.FieldAccessorTable j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "Violations" });
  
  static final Descriptors.Descriptor k = i.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable l = new GeneratedMessageV3.FieldAccessorTable(k, new String[] { "Type", "Subject", "Description" });
  
  static final Descriptors.Descriptor m = a().getMessageTypes().get(4);
  
  static final GeneratedMessageV3.FieldAccessorTable n = new GeneratedMessageV3.FieldAccessorTable(m, new String[] { "FieldViolations" });
  
  static final Descriptors.Descriptor o = m.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable p = new GeneratedMessageV3.FieldAccessorTable(o, new String[] { "Field", "Description" });
  
  static final Descriptors.Descriptor q = a().getMessageTypes().get(5);
  
  static final GeneratedMessageV3.FieldAccessorTable r = new GeneratedMessageV3.FieldAccessorTable(q, new String[] { "RequestId", "ServingData" });
  
  static final Descriptors.Descriptor s = a().getMessageTypes().get(6);
  
  static final GeneratedMessageV3.FieldAccessorTable t = new GeneratedMessageV3.FieldAccessorTable(s, new String[] { "ResourceType", "ResourceName", "Owner", "Description" });
  
  static final Descriptors.Descriptor u = a().getMessageTypes().get(7);
  
  static final GeneratedMessageV3.FieldAccessorTable v = new GeneratedMessageV3.FieldAccessorTable(u, new String[] { "Links" });
  
  static final Descriptors.Descriptor w = u.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable x = new GeneratedMessageV3.FieldAccessorTable(w, new String[] { "Description", "Url" });
  
  static final Descriptors.Descriptor y = a().getMessageTypes().get(8);
  
  static final GeneratedMessageV3.FieldAccessorTable z = new GeneratedMessageV3.FieldAccessorTable(y, new String[] { "Locale", "Message" });
  
  static {
    DurationProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return A;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ErrorDetailsProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = DurationProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\036google/rpc/error_details.proto\022\ngoogle.rpc\032\036google/protobuf/duration.proto\";\n\tRetryInfo\022.\n\013retry_delay\030\001 \001(\0132\031.google.protobuf.Duration\"2\n\tDebugInfo\022\025\n\rstack_entries\030\001 \003(\t\022\016\n\006detail\030\002 \001(\t\"y\n\fQuotaFailure\0226\n\nviolations\030\001 \003(\0132\".google.rpc.QuotaFailure.Violation\0321\n\tViolation\022\017\n\007subject\030\001 \001(\t\022\023\n\013description\030\002 \001(\t\"\001\n\023PreconditionFailure\022=\n\nviolations\030\001 \003(\0132).google.rpc.PreconditionFailure.Violation\032?\n\tViolation\022\f\n\004type\030\001 \001(\t\022\017\n\007subject\030\002 \001(\t\022\023\n\013description\030\003 \001(\t\"\001\n\nBadRequest\022?\n\020field_violations\030\001 \003(\0132%.google.rpc.BadRequest.FieldViolation\0324\n\016FieldViolation\022\r\n\005field\030\001 \001(\t\022\023\n\013description\030\002 \001(\t\"7\n\013RequestInfo\022\022\n\nrequest_id\030\001 \001(\t\022\024\n\fserving_data\030\002 \001(\t\"`\n\fResourceInfo\022\025\n\rresource_type\030\001 \001(\t\022\025\n\rresource_name\030\002 \001(\t\022\r\n\005owner\030\003 \001(\t\022\023\n\013description\030\004 \001(\t\"V\n\004Help\022$\n\005links\030\001 \003(\0132\025.google.rpc.Help.Link\032(\n\004Link\022\023\n\013description\030\001 \001(\t\022\013\n\003url\030\002 \001(\t\"3\n\020LocalizedMessage\022\016\n\006locale\030\001 \001(\t\022\017\n\007message\030\002 \001(\tBl\n\016com.google.rpcB\021ErrorDetailsProtoP\001Z?google.golang.org/genproto/googleapis/rpc/errdetails;errdetails¢\002\003RPCb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\ErrorDetailsProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */