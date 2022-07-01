package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class HttpProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Rules", "FullyDecodeReservedExpansion" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { 
        "Selector", "Get", "Put", "Post", "Delete", "Patch", "Custom", "Body", "ResponseBody", "AdditionalBindings", 
        "Pattern" });
  
  static final Descriptors.Descriptor e = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Kind", "Path" });
  
  private static Descriptors.FileDescriptor g;
  
  public static Descriptors.FileDescriptor a() {
    return g;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          HttpProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\025google/api/http.proto\022\ngoogle.api\"T\n\004Http\022#\n\005rules\030\001 \003(\0132\024.google.api.HttpRule\022'\n\037fully_decode_reserved_expansion\030\002 \001(\b\"\002\n\bHttpRule\022\020\n\bselector\030\001 \001(\t\022\r\n\003get\030\002 \001(\tH\000\022\r\n\003put\030\003 \001(\tH\000\022\016\n\004post\030\004 \001(\tH\000\022\020\n\006delete\030\005 \001(\tH\000\022\017\n\005patch\030\006 \001(\tH\000\022/\n\006custom\030\b \001(\0132\035.google.api.CustomHttpPatternH\000\022\f\n\004body\030\007 \001(\t\022\025\n\rresponse_body\030\f \001(\t\0221\n\023additional_bindings\030\013 \003(\0132\024.google.api.HttpRuleB\t\n\007pattern\"/\n\021CustomHttpPattern\022\f\n\004kind\030\001 \001(\t\022\f\n\004path\030\002 \001(\tBj\n\016com.google.apiB\tHttpProtoP\001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotationsø\001\001¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\HttpProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */