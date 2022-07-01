package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class ConfigChangeProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Element", "OldValue", "NewValue", "ChangeType", "Advices" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Description" });
  
  private static Descriptors.FileDescriptor e;
  
  public static Descriptors.FileDescriptor a() {
    return e;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ConfigChangeProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\036google/api/config_change.proto\022\ngoogle.api\"\001\n\fConfigChange\022\017\n\007element\030\001 \001(\t\022\021\n\told_value\030\002 \001(\t\022\021\n\tnew_value\030\003 \001(\t\022+\n\013change_type\030\004 \001(\0162\026.google.api.ChangeType\022#\n\007advices\030\005 \003(\0132\022.google.api.Advice\"\035\n\006Advice\022\023\n\013description\030\002 \001(\t*O\n\nChangeType\022\033\n\027CHANGE_TYPE_UNSPECIFIED\020\000\022\t\n\005ADDED\020\001\022\013\n\007REMOVED\020\002\022\f\n\bMODIFIED\020\003Bq\n\016com.google.apiB\021ConfigChangeProtoP\001ZCgoogle.golang.org/genproto/googleapis/api/configchange;configchange¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ConfigChangeProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */