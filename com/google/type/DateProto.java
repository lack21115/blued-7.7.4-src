package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class DateProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Year", "Month", "Day" });
  
  private static Descriptors.FileDescriptor c;
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          DateProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\026google/type/date.proto\022\013google.type\"0\n\004Date\022\f\n\004year\030\001 \001(\005\022\r\n\005month\030\002 \001(\005\022\013\n\003day\030\003 \001(\005B]\n\017com.google.typeB\tDateProtoP\001Z4google.golang.org/genproto/googleapis/type/date;dateø\001\001¢\002\003GTPb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\DateProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */