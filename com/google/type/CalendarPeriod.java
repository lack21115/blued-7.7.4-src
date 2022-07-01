package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum CalendarPeriod implements ProtocolMessageEnum {
  CALENDAR_PERIOD_UNSPECIFIED(0),
  DAY(1),
  FORTNIGHT(1),
  HALF(1),
  MONTH(1),
  QUARTER(1),
  UNRECOGNIZED(1),
  WEEK(2),
  YEAR(2);
  
  public static final int CALENDAR_PERIOD_UNSPECIFIED_VALUE = 0;
  
  public static final int DAY_VALUE = 1;
  
  public static final int FORTNIGHT_VALUE = 3;
  
  public static final int HALF_VALUE = 6;
  
  public static final int MONTH_VALUE = 4;
  
  public static final int QUARTER_VALUE = 5;
  
  private static final CalendarPeriod[] VALUES;
  
  public static final int WEEK_VALUE = 2;
  
  public static final int YEAR_VALUE = 7;
  
  private static final Internal.EnumLiteMap<CalendarPeriod> internalValueMap;
  
  private final int value;
  
  static {
    FORTNIGHT = new CalendarPeriod("FORTNIGHT", 3, 3);
    MONTH = new CalendarPeriod("MONTH", 4, 4);
    QUARTER = new CalendarPeriod("QUARTER", 5, 5);
    HALF = new CalendarPeriod("HALF", 6, 6);
    YEAR = new CalendarPeriod("YEAR", 7, 7);
    UNRECOGNIZED = new CalendarPeriod("UNRECOGNIZED", 8, -1);
    $VALUES = new CalendarPeriod[] { CALENDAR_PERIOD_UNSPECIFIED, DAY, WEEK, FORTNIGHT, MONTH, QUARTER, HALF, YEAR, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<CalendarPeriod>() {
        public CalendarPeriod a(int param1Int) {
          return CalendarPeriod.forNumber(param1Int);
        }
      };
    VALUES = values();
  }
  
  CalendarPeriod(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static CalendarPeriod forNumber(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 7:
        return YEAR;
      case 6:
        return HALF;
      case 5:
        return QUARTER;
      case 4:
        return MONTH;
      case 3:
        return FORTNIGHT;
      case 2:
        return WEEK;
      case 1:
        return DAY;
      case 0:
        break;
    } 
    return CALENDAR_PERIOD_UNSPECIFIED;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor() {
    return CalendarPeriodProto.a().getEnumTypes().get(0);
  }
  
  public static Internal.EnumLiteMap<CalendarPeriod> internalGetValueMap() {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\CalendarPeriod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */