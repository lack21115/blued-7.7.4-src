package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import java.util.List;

public final class FieldBehaviorProto {
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FieldOptions, List<FieldBehavior>> a = GeneratedMessage.newFileScopedGeneratedExtension(FieldBehavior.class, null);
  
  private static Descriptors.FileDescriptor b;
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          FieldBehaviorProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = DescriptorProtos.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\037google/api/field_behavior.proto\022\ngoogle.api\032 google/protobuf/descriptor.proto*{\n\rFieldBehavior\022\036\n\032FIELD_BEHAVIOR_UNSPECIFIED\020\000\022\f\n\bOPTIONAL\020\001\022\f\n\bREQUIRED\020\002\022\017\n\013OUTPUT_ONLY\020\003\022\016\n\nINPUT_ONLY\020\004\022\r\n\tIMMUTABLE\020\005:Q\n\016field_behavior\022\035.google.protobuf.FieldOptions\030\b \003(\0162\031.google.api.FieldBehaviorBp\n\016com.google.apiB\022FieldBehaviorProtoP\001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotations¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
    a.internalInit(b.getExtensions().get(0));
    DescriptorProtos.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\FieldBehaviorProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */