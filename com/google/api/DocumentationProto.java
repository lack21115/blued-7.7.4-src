package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class DocumentationProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Summary", "Pages", "Rules", "DocumentationRootUrl", "Overview" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Selector", "Description", "DeprecationDescription" });
  
  static final Descriptors.Descriptor e = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Name", "Content", "Subpages" });
  
  private static Descriptors.FileDescriptor g;
  
  public static Descriptors.FileDescriptor a() {
    return g;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          DocumentationProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\036google/api/documentation.proto\022\ngoogle.api\"¡\001\n\rDocumentation\022\017\n\007summary\030\001 \001(\t\022\037\n\005pages\030\005 \003(\0132\020.google.api.Page\022,\n\005rules\030\003 \003(\0132\035.google.api.DocumentationRule\022\036\n\026documentation_root_url\030\004 \001(\t\022\020\n\boverview\030\002 \001(\t\"[\n\021DocumentationRule\022\020\n\bselector\030\001 \001(\t\022\023\n\013description\030\002 \001(\t\022\037\n\027deprecation_description\030\003 \001(\t\"I\n\004Page\022\f\n\004name\030\001 \001(\t\022\017\n\007content\030\002 \001(\t\022\"\n\bsubpages\030\003 \003(\0132\020.google.api.PageBt\n\016com.google.apiB\022DocumentationProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\DocumentationProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */