package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class EndpointProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Name", "Aliases", "Features", "Target", "AllowCors" });
  
  private static Descriptors.FileDescriptor c;
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          EndpointProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\031google/api/endpoint.proto\022\ngoogle.api\"c\n\bEndpoint\022\f\n\004name\030\001 \001(\t\022\023\n\007aliases\030\002 \003(\tB\002\030\001\022\020\n\bfeatures\030\004 \003(\t\022\016\n\006target\030e \001(\t\022\022\n\nallow_cors\030\005 \001(\bBo\n\016com.google.apiB\rEndpointProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\EndpointProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */