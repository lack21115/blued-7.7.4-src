package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import java.util.List;

public final class ClientProto {
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, List<String>> a = GeneratedMessage.newFileScopedGeneratedExtension(String.class, null);
  
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.ServiceOptions, String> b = GeneratedMessage.newFileScopedGeneratedExtension(String.class, null);
  
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.ServiceOptions, String> c = GeneratedMessage.newFileScopedGeneratedExtension(String.class, null);
  
  private static Descriptors.FileDescriptor d;
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ClientProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = DescriptorProtos.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\027google/api/client.proto\022\ngoogle.api\032 google/protobuf/descriptor.proto:9\n\020method_signature\022\036.google.protobuf.MethodOptions\030\b \003(\t:6\n\fdefault_host\022\037.google.protobuf.ServiceOptions\030\b \001(\t:6\n\foauth_scopes\022\037.google.protobuf.ServiceOptions\030\b \001(\tBi\n\016com.google.apiB\013ClientProtoP\001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotations¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
    a.internalInit(d.getExtensions().get(0));
    b.internalInit(d.getExtensions().get(1));
    c.internalInit(d.getExtensions().get(2));
    DescriptorProtos.getDescriptor();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ClientProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */