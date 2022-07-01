package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class LabelProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Key", "ValueType", "Description" });
  
  private static Descriptors.FileDescriptor c;
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          LabelProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\026google/api/label.proto\022\ngoogle.api\"\001\n\017LabelDescriptor\022\013\n\003key\030\001 \001(\t\0229\n\nvalue_type\030\002 \001(\0162%.google.api.LabelDescriptor.ValueType\022\023\n\013description\030\003 \001(\t\",\n\tValueType\022\n\n\006STRING\020\000\022\b\n\004BOOL\020\001\022\t\n\005INT64\020\002B_\n\016com.google.apiB\nLabelProtoP\001Z5google.golang.org/genproto/googleapis/api/label;labelø\001\001¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\LabelProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */