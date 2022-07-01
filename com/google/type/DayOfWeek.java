package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum DayOfWeek implements ProtocolMessageEnum {
  DAY_OF_WEEK_UNSPECIFIED(0),
  FRIDAY(0),
  MONDAY(1),
  SATURDAY(1),
  SUNDAY(1),
  THURSDAY(1),
  TUESDAY(2),
  UNRECOGNIZED(2),
  WEDNESDAY(3);
  
  public static final int DAY_OF_WEEK_UNSPECIFIED_VALUE = 0;
  
  public static final int FRIDAY_VALUE = 5;
  
  public static final int MONDAY_VALUE = 1;
  
  public static final int SATURDAY_VALUE = 6;
  
  public static final int SUNDAY_VALUE = 7;
  
  public static final int THURSDAY_VALUE = 4;
  
  public static final int TUESDAY_VALUE = 2;
  
  private static final DayOfWeek[] VALUES;
  
  public static final int WEDNESDAY_VALUE = 3;
  
  private static final Internal.EnumLiteMap<DayOfWeek> internalValueMap;
  
  private final int value;
  
  static {
    THURSDAY = new DayOfWeek("THURSDAY", 4, 4);
    FRIDAY = new DayOfWeek("FRIDAY", 5, 5);
    SATURDAY = new DayOfWeek("SATURDAY", 6, 6);
    SUNDAY = new DayOfWeek("SUNDAY", 7, 7);
    UNRECOGNIZED = new DayOfWeek("UNRECOGNIZED", 8, -1);
    $VALUES = new DayOfWeek[] { DAY_OF_WEEK_UNSPECIFIED, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<DayOfWeek>() {
        public DayOfWeek a(int param1Int) {
          return DayOfWeek.forNumber(param1Int);
        }
      };
    VALUES = values();
  }
  
  DayOfWeek(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static DayOfWeek forNumber(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 7:
        return SUNDAY;
      case 6:
        return SATURDAY;
      case 5:
        return FRIDAY;
      case 4:
        return THURSDAY;
      case 3:
        return WEDNESDAY;
      case 2:
        return TUESDAY;
      case 1:
        return MONDAY;
      case 0:
        break;
    } 
    return DAY_OF_WEEK_UNSPECIFIED;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor() {
    return DayOfWeekProto.a().getEnumTypes().get(0);
  }
  
  public static Internal.EnumLiteMap<DayOfWeek> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final Descriptors.EnumDescriptor getDescriptorForType() {
    return getDescriptor();
  }
  
  public final int getNumber() {
    if (this != UNRECOGNIZED)
      return this.value; 
    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\DayOfWeek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */