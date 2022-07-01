package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class ContextProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Rules" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Selector", "Requested", "Provided", "AllowedRequestExtensions", "AllowedResponseExtensions" });
  
  private static Descriptors.FileDescriptor e;
  
  public static Descriptors.FileDescriptor a() {
    return e;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ContextProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\030google/api/context.proto\022\ngoogle.api\"1\n\007Context\022&\n\005rules\030\001 \003(\0132\027.google.api.ContextRule\"\001\n\013ContextRule\022\020\n\bselector\030\001 \001(\t\022\021\n\trequested\030\002 \003(\t\022\020\n\bprovided\030\003 \003(\t\022\"\n\032allowed_request_extensions\030\004 \003(\t\022#\n\033allowed_response_extensions\030\005 \003(\tBn\n\016com.google.apiB\fContextProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ContextProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */