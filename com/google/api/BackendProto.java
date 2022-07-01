package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class BackendProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Rules" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Selector", "Address", "Deadline", "MinDeadline", "OperationDeadline", "PathTranslation", "JwtAudience", "Authentication" });
  
  private static Descriptors.FileDescriptor e;
  
  public static Descriptors.FileDescriptor a() {
    return e;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          BackendProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\030google/api/backend.proto\022\ngoogle.api\"1\n\007Backend\022&\n\005rules\030\001 \003(\0132\027.google.api.BackendRule\"È\002\n\013BackendRule\022\020\n\bselector\030\001 \001(\t\022\017\n\007address\030\002 \001(\t\022\020\n\bdeadline\030\003 \001(\001\022\024\n\fmin_deadline\030\004 \001(\001\022\032\n\022operation_deadline\030\005 \001(\001\022A\n\020path_translation\030\006 \001(\0162'.google.api.BackendRule.PathTranslation\022\026\n\fjwt_audience\030\007 \001(\tH\000\"e\n\017PathTranslation\022 \n\034PATH_TRANSLATION_UNSPECIFIED\020\000\022\024\n\020CONSTANT_ADDRESS\020\001\022\032\n\026APPEND_PATH_TO_ADDRESS\020\002B\020\n\016authenticationBn\n\016com.google.apiB\fBackendProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\BackendProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */