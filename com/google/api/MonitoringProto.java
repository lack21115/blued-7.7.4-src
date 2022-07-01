package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class MonitoringProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "ProducerDestinations", "ConsumerDestinations" });
  
  static final Descriptors.Descriptor c = a.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "MonitoredResource", "Metrics" });
  
  private static Descriptors.FileDescriptor e;
  
  public static Descriptors.FileDescriptor a() {
    return e;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          MonitoringProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\033google/api/monitoring.proto\022\ngoogle.api\"ì\001\n\nMonitoring\022K\n\025producer_destinations\030\001 \003(\0132,.google.api.Monitoring.MonitoringDestination\022K\n\025consumer_destinations\030\002 \003(\0132,.google.api.Monitoring.MonitoringDestination\032D\n\025MonitoringDestination\022\032\n\022monitored_resource\030\001 \001(\t\022\017\n\007metrics\030\002 \003(\tBq\n\016com.google.apiB\017MonitoringProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoringProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */