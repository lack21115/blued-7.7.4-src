package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class ExprProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Expression", "Title", "Description", "Location" });
  
  private static Descriptors.FileDescriptor c;
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ExprProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\026google/type/expr.proto\022\013google.type\"P\n\004Expr\022\022\n\nexpression\030\001 \001(\t\022\r\n\005title\030\002 \001(\t\022\023\n\013description\030\003 \001(\t\022\020\n\blocation\030\004 \001(\tBZ\n\017com.google.typeB\tExprProtoP\001Z4google.golang.org/genproto/googleapis/type/expr;expr¢\002\003GTPb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\ExprProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */