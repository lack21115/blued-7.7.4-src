package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import java.util.List;

public final class ResourceProto {
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FieldOptions, ResourceReference> a = GeneratedMessage.newFileScopedGeneratedExtension(ResourceReference.class, (Message)ResourceReference.getDefaultInstance());
  
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FileOptions, List<ResourceDescriptor>> b = GeneratedMessage.newFileScopedGeneratedExtension(ResourceDescriptor.class, (Message)ResourceDescriptor.getDefaultInstance());
  
  public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.MessageOptions, ResourceDescriptor> c = GeneratedMessage.newFileScopedGeneratedExtension(ResourceDescriptor.class, (Message)ResourceDescriptor.getDefaultInstance());
  
  static final Descriptors.Descriptor d = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable e = new GeneratedMessageV3.FieldAccessorTable(d, new String[] { "Type", "Pattern", "NameField", "History", "Plural", "Singular" });
  
  static final Descriptors.Descriptor f = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable g = new GeneratedMessageV3.FieldAccessorTable(f, new String[] { "Type", "ChildType" });
  
  private static Descriptors.FileDescriptor h;
  
  static {
    a.internalInit(h.getExtensions().get(0));
    b.internalInit(h.getExtensions().get(1));
    c.internalInit(h.getExtensions().get(2));
    DescriptorProtos.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return h;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ResourceProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = DescriptorProtos.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\031google/api/resource.proto\022\ngoogle.api\032 google/protobuf/descriptor.proto\"ÿ\001\n\022ResourceDescriptor\022\f\n\004type\030\001 \001(\t\022\017\n\007pattern\030\002 \003(\t\022\022\n\nname_field\030\003 \001(\t\0227\n\007history\030\004 \001(\0162&.google.api.ResourceDescriptor.History\022\016\n\006plural\030\005 \001(\t\022\020\n\bsingular\030\006 \001(\t\"[\n\007History\022\027\n\023HISTORY_UNSPECIFIED\020\000\022\035\n\031ORIGINALLY_SINGLE_PATTERN\020\001\022\030\n\024FUTURE_MULTI_PATTERN\020\002\"5\n\021ResourceReference\022\f\n\004type\030\001 \001(\t\022\022\n\nchild_type\030\002 \001(\t:Y\n\022resource_reference\022\035.google.protobuf.FieldOptions\030\b \001(\0132\035.google.api.ResourceReference:Z\n\023resource_definition\022\034.google.protobuf.FileOptions\030\b \003(\0132\036.google.api.ResourceDescriptor:R\n\bresource\022\037.google.protobuf.MessageOptions\030\b \001(\0132\036.google.api.ResourceDescriptorBn\n\016com.google.apiB\rResourceProtoP\001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotationsø\001\001¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ResourceProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */