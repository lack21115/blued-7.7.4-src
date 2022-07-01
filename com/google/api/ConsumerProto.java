package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class ConsumerProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Properties" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Name", "Type", "Description" });
  
  private static Descriptors.FileDescriptor e;
  
  public static Descriptors.FileDescriptor a() {
    return e;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ConsumerProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\031google/api/consumer.proto\022\ngoogle.api\"=\n\021ProjectProperties\022(\n\nproperties\030\001 \003(\0132\024.google.api.Property\"¬\001\n\bProperty\022\f\n\004name\030\001 \001(\t\022/\n\004type\030\002 \001(\0162!.google.api.Property.PropertyType\022\023\n\013description\030\003 \001(\t\"L\n\fPropertyType\022\017\n\013UNSPECIFIED\020\000\022\t\n\005INT64\020\001\022\b\n\004BOOL\020\002\022\n\n\006STRING\020\003\022\n\n\006DOUBLE\020\004Bh\n\016com.google.apiB\rConsumerProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfigb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ConsumerProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */