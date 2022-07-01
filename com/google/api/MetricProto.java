package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.DurationProto;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class MetricProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Name", "Type", "Labels", "MetricKind", "ValueType", "Unit", "Description", "DisplayName", "Metadata", "LaunchStage" });
  
  static final Descriptors.Descriptor c = a.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "LaunchStage", "SamplePeriod", "IngestDelay" });
  
  static final Descriptors.Descriptor e = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Type", "Labels" });
  
  static final Descriptors.Descriptor g = e.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "Key", "Value" });
  
  private static Descriptors.FileDescriptor i;
  
  static {
    LabelProto.a();
    LaunchStageProto.a();
    DurationProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return i;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          MetricProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor1 = LabelProto.a();
    Descriptors.FileDescriptor fileDescriptor2 = LaunchStageProto.a();
    Descriptors.FileDescriptor fileDescriptor3 = DurationProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\027google/api/metric.proto\022\ngoogle.api\032\026google/api/label.proto\032\035google/api/launch_stage.proto\032\036google/protobuf/duration.proto\"ý\005\n\020MetricDescriptor\022\f\n\004name\030\001 \001(\t\022\f\n\004type\030\b \001(\t\022+\n\006labels\030\002 \003(\0132\033.google.api.LabelDescriptor\022<\n\013metric_kind\030\003 \001(\0162'.google.api.MetricDescriptor.MetricKind\022:\n\nvalue_type\030\004 \001(\0162&.google.api.MetricDescriptor.ValueType\022\f\n\004unit\030\005 \001(\t\022\023\n\013description\030\006 \001(\t\022\024\n\fdisplay_name\030\007 \001(\t\022G\n\bmetadata\030\n \001(\01325.google.api.MetricDescriptor.MetricDescriptorMetadata\022-\n\flaunch_stage\030\f \001(\0162\027.google.api.LaunchStage\032°\001\n\030MetricDescriptorMetadata\0221\n\flaunch_stage\030\001 \001(\0162\027.google.api.LaunchStageB\002\030\001\0220\n\rsample_period\030\002 \001(\0132\031.google.protobuf.Duration\022/\n\fingest_delay\030\003 \001(\0132\031.google.protobuf.Duration\"O\n\nMetricKind\022\033\n\027METRIC_KIND_UNSPECIFIED\020\000\022\t\n\005GAUGE\020\001\022\t\n\005DELTA\020\002\022\016\n\nCUMULATIVE\020\003\"q\n\tValueType\022\032\n\026VALUE_TYPE_UNSPECIFIED\020\000\022\b\n\004BOOL\020\001\022\t\n\005INT64\020\002\022\n\n\006DOUBLE\020\003\022\n\n\006STRING\020\004\022\020\n\fDISTRIBUTION\020\005\022\t\n\005MONEY\020\006\"u\n\006Metric\022\f\n\004type\030\003 \001(\t\022.\n\006labels\030\002 \003(\0132\036.google.api.Metric.LabelsEntry\032-\n\013LabelsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001B_\n\016com.google.apiB\013MetricProtoP\001Z7google.golang.org/genproto/googleapis/api/metric;metric¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2, fileDescriptor3 }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MetricProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */