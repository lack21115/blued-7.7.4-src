package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class SystemParameterProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Rules" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Selector", "Parameters" });
  
  static final Descriptors.Descriptor e = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Name", "HttpHeader", "UrlQueryParameter" });
  
  private static Descriptors.FileDescriptor g;
  
  public static Descriptors.FileDescriptor a() {
    return g;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          SystemParameterProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!google/api/system_parameter.proto\022\ngoogle.api\"B\n\020SystemParameters\022.\n\005rules\030\001 \003(\0132\037.google.api.SystemParameterRule\"X\n\023SystemParameterRule\022\020\n\bselector\030\001 \001(\t\022/\n\nparameters\030\002 \003(\0132\033.google.api.SystemParameter\"Q\n\017SystemParameter\022\f\n\004name\030\001 \001(\t\022\023\n\013http_header\030\002 \001(\t\022\033\n\023url_query_parameter\030\003 \001(\tBv\n\016com.google.apiB\024SystemParameterProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SystemParameterProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */