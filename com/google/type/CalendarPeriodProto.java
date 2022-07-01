package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;

public final class CalendarPeriodProto {
  private static Descriptors.FileDescriptor a;
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          CalendarPeriodProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!google/type/calendar_period.proto\022\013google.type*\n\016CalendarPeriod\022\037\n\033CALENDAR_PERIOD_UNSPECIFIED\020\000\022\007\n\003DAY\020\001\022\b\n\004WEEK\020\002\022\r\n\tFORTNIGHT\020\003\022\t\n\005MONTH\020\004\022\013\n\007QUARTER\020\005\022\b\n\004HALF\020\006\022\b\n\004YEAR\020\007Bx\n\017com.google.typeB\023CalendarPeriodProtoP\001ZHgoogle.golang.org/genproto/googleapis/type/calendarperiod;calendarperiod¢\002\003GTPb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
  
  public static Descriptors.FileDescriptor a() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\CalendarPeriodProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */