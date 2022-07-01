package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class BillingProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "ConsumerDestinations" });
  
  static final Descriptors.Descriptor c = a.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "MonitoredResource", "Metrics" });
  
  private static Descriptors.FileDescriptor e;
  
  static {
    MetricProto.a();
  }
  
  public static Descriptors.FileDescriptor a() {
    return e;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          BillingProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = MetricProto.a();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\030google/api/billing.proto\022\ngoogle.api\032\027google/api/metric.proto\"\001\n\007Billing\022E\n\025consumer_destinations\030\b \003(\0132&.google.api.Billing.BillingDestination\032A\n\022BillingDestination\022\032\n\022monitored_resource\030\001 \001(\t\022\017\n\007metrics\030\002 \003(\tBn\n\016com.google.apiB\fBillingProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\BillingProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */