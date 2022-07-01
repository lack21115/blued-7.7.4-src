package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class QuaternionProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "X", "Y", "Z", "W" });
  
  private static Descriptors.FileDescriptor c;
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          QuaternionProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\034google/type/quaternion.proto\022\013google.type\"8\n\nQuaternion\022\t\n\001x\030\001 \001(\001\022\t\n\001y\030\002 \001(\001\022\t\n\001z\030\003 \001(\001\022\t\n\001w\030\004 \001(\001Bo\n\017com.google.typeB\017QuaternionProtoP\001Z@google.golang.org/genproto/googleapis/type/quaternion;quaternionø\001\001¢\002\003GTPb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\QuaternionProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */