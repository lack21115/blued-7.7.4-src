package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.StructProto;

public final class MonitoredResourceProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Name", "Type", "DisplayName", "Description", "Labels", "LaunchStage" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Type", "Labels" });
  
  static final Descriptors.Descriptor e = c.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Key", "Value" });
  
  static final Descriptors.Descriptor g = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "SystemLabels", "UserLabels" });
  
  static final Descriptors.Descriptor i = g.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "Key", "Value" });
  
  private static Descriptors.FileDescriptor k;
  
  static {
    LabelProto.a();
    LaunchStageProto.a();
    StructProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return k;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          MonitoredResourceProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor1 = LabelProto.a();
    Descriptors.FileDescriptor fileDescriptor2 = LaunchStageProto.a();
    Descriptors.FileDescriptor fileDescriptor3 = StructProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n#google/api/monitored_resource.proto\022\ngoogle.api\032\026google/api/label.proto\032\035google/api/launch_stage.proto\032\034google/protobuf/struct.proto\"À\001\n\033MonitoredResourceDescriptor\022\f\n\004name\030\005 \001(\t\022\f\n\004type\030\001 \001(\t\022\024\n\fdisplay_name\030\002 \001(\t\022\023\n\013description\030\003 \001(\t\022+\n\006labels\030\004 \003(\0132\033.google.api.LabelDescriptor\022-\n\flaunch_stage\030\007 \001(\0162\027.google.api.LaunchStage\"\001\n\021MonitoredResource\022\f\n\004type\030\001 \001(\t\0229\n\006labels\030\002 \003(\0132).google.api.MonitoredResource.LabelsEntry\032-\n\013LabelsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\"Ê\001\n\031MonitoredResourceMetadata\022.\n\rsystem_labels\030\001 \001(\0132\027.google.protobuf.Struct\022J\n\013user_labels\030\002 \003(\01325.google.api.MonitoredResourceMetadata.UserLabelsEntry\0321\n\017UserLabelsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001By\n\016com.google.apiB\026MonitoredResourceProtoP\001ZCgoogle.golang.org/genproto/googleapis/api/monitoredres;monitoredresø\001\001¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2, fileDescriptor3 }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoredResourceProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */