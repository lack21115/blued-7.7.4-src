package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class UsageProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Requirements", "Rules", "ProducerNotificationChannel" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Selector", "AllowUnregisteredCalls", "SkipServiceControl" });
  
  private static Descriptors.FileDescriptor e;
  
  public static Descriptors.FileDescriptor a() {
    return e;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          UsageProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\026google/api/usage.proto\022\ngoogle.api\"j\n\005Usage\022\024\n\frequirements\030\001 \003(\t\022$\n\005rules\030\006 \003(\0132\025.google.api.UsageRule\022%\n\035producer_notification_channel\030\007 \001(\t\"]\n\tUsageRule\022\020\n\bselector\030\001 \001(\t\022 \n\030allow_unregistered_calls\030\002 \001(\b\022\034\n\024skip_service_control\030\003 \001(\bBl\n\016com.google.apiB\nUsageProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\UsageProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */