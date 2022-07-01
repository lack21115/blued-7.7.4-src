package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class TimeOfDayProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Hours", "Minutes", "Seconds", "Nanos" });
  
  private static Descriptors.FileDescriptor c;
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          TimeOfDayProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\033google/type/timeofday.proto\022\013google.type\"K\n\tTimeOfDay\022\r\n\005hours\030\001 \001(\005\022\017\n\007minutes\030\002 \001(\005\022\017\n\007seconds\030\003 \001(\005\022\r\n\005nanos\030\004 \001(\005Bl\n\017com.google.typeB\016TimeOfDayProtoP\001Z>google.golang.org/genproto/googleapis/type/timeofday;timeofdayø\001\001¢\002\003GTPb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\TimeOfDayProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */