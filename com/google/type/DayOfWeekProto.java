package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;

public final class DayOfWeekProto {
  private static Descriptors.FileDescriptor a;
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          DayOfWeekProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\033google/type/dayofweek.proto\022\013google.type*\001\n\tDayOfWeek\022\033\n\027DAY_OF_WEEK_UNSPECIFIED\020\000\022\n\n\006MONDAY\020\001\022\013\n\007TUESDAY\020\002\022\r\n\tWEDNESDAY\020\003\022\f\n\bTHURSDAY\020\004\022\n\n\006FRIDAY\020\005\022\f\n\bSATURDAY\020\006\022\n\n\006SUNDAY\020\007Bi\n\017com.google.typeB\016DayOfWeekProtoP\001Z>google.golang.org/genproto/googleapis/type/dayofweek;dayofweek¢\002\003GTPb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
  
  public static Descriptors.FileDescriptor a() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\DayOfWeekProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */