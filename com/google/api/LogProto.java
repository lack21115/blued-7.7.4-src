package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class LogProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Name", "Labels", "Description", "DisplayName" });
  
  private static Descriptors.FileDescriptor c;
  
  static {
    LabelProto.a();
  }
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          LogProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = LabelProto.a();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\024google/api/log.proto\022\ngoogle.api\032\026google/api/label.proto\"u\n\rLogDescriptor\022\f\n\004name\030\001 \001(\t\022+\n\006labels\030\002 \003(\0132\033.google.api.LabelDescriptor\022\023\n\013description\030\003 \001(\t\022\024\n\fdisplay_name\030\004 \001(\tBj\n\016com.google.apiB\bLogProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\LogProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */