package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;

public final class AnnotationsProto {
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, HttpRule> a = GeneratedMessage.newFileScopedGeneratedExtension(HttpRule.class, (Message)HttpRule.getDefaultInstance());
  
  private static Descriptors.FileDescriptor b;
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          AnnotationsProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor1 = HttpProto.a();
    Descriptors.FileDescriptor fileDescriptor2 = DescriptorProtos.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\034google/api/annotations.proto\022\ngoogle.api\032\025google/api/http.proto\032 google/protobuf/descriptor.proto:E\n\004http\022\036.google.protobuf.MethodOptions\030°Ê¼\" \001(\0132\024.google.api.HttpRuleBn\n\016com.google.apiB\020AnnotationsProtoP\001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotations¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2 }, internalDescriptorAssigner);
    a.internalInit(b.getExtensions().get(0));
    HttpProto.a();
    DescriptorProtos.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AnnotationsProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */