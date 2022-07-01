package com.google.api;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class HttpBodyProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "ContentType", "Data", "Extensions" });
  
  private static Descriptors.FileDescriptor c;
  
  static {
    AnyProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          HttpBodyProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = AnyProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\031google/api/httpbody.proto\022\ngoogle.api\032\031google/protobuf/any.proto\"X\n\bHttpBody\022\024\n\fcontent_type\030\001 \001(\t\022\f\n\004data\030\002 \001(\f\022(\n\nextensions\030\003 \003(\0132\024.google.protobuf.AnyBh\n\016com.google.apiB\rHttpBodyProtoP\001Z;google.golang.org/genproto/googleapis/api/httpbody;httpbodyø\001\001¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\HttpBodyProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */