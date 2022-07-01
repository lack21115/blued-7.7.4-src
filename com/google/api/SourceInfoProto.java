package com.google.api;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class SourceInfoProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "SourceFiles" });
  
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
          SourceInfoProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = AnyProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\034google/api/source_info.proto\022\ngoogle.api\032\031google/protobuf/any.proto\"8\n\nSourceInfo\022*\n\fsource_files\030\001 \003(\0132\024.google.protobuf.AnyBq\n\016com.google.apiB\017SourceInfoProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SourceInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */