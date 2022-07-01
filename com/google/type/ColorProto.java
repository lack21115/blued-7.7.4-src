package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.WrappersProto;

public final class ColorProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Red", "Green", "Blue", "Alpha" });
  
  private static Descriptors.FileDescriptor c;
  
  static {
    WrappersProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ColorProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = WrappersProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\027google/type/color.proto\022\013google.type\032\036google/protobuf/wrappers.proto\"]\n\005Color\022\013\n\003red\030\001 \001(\002\022\r\n\005green\030\002 \001(\002\022\f\n\004blue\030\003 \001(\002\022*\n\005alpha\030\004 \001(\0132\033.google.protobuf.FloatValueB`\n\017com.google.typeB\nColorProtoP\001Z6google.golang.org/genproto/googleapis/type/color;colorø\001\001¢\002\003GTPb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\ColorProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */