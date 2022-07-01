package com.google.logging.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum LogSeverity implements ProtocolMessageEnum {
  ALERT,
  CRITICAL,
  DEBUG,
  DEFAULT(0),
  EMERGENCY(0),
  ERROR(0),
  INFO(0),
  NOTICE(0),
  UNRECOGNIZED(0),
  WARNING(0);
  
  public static final int ALERT_VALUE = 700;
  
  public static final int CRITICAL_VALUE = 600;
  
  public static final int DEBUG_VALUE = 100;
  
  public static final int DEFAULT_VALUE = 0;
  
  public static final int EMERGENCY_VALUE = 800;
  
  public static final int ERROR_VALUE = 500;
  
  public static final int INFO_VALUE = 200;
  
  public static final int NOTICE_VALUE = 300;
  
  private static final LogSeverity[] VALUES;
  
  public static final int WARNING_VALUE = 400;
  
  private static final Internal.EnumLiteMap<LogSeverity> internalValueMap;
  
  private final int value;
  
  static {
    DEBUG = new LogSeverity("DEBUG", 1, 100);
    INFO = new LogSeverity("INFO", 2, 200);
    NOTICE = new LogSeverity("NOTICE", 3, 300);
    WARNING = new LogSeverity("WARNING", 4, 400);
    ERROR = new LogSeverity("ERROR", 5, 500);
    CRITICAL = new LogSeverity("CRITICAL", 6, 600);
    ALERT = new LogSeverity("ALERT", 7, 700);
    EMERGENCY = new LogSeverity("EMERGENCY", 8, 800);
    UNRECOGNIZED = new LogSeverity("UNRECOGNIZED", 9, -1);
    $VALUES = new LogSeverity[] { DEFAULT, DEBUG, INFO, NOTICE, WARNING, ERROR, CRITICAL, ALERT, EMERGENCY, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<LogSeverity>() {
        public LogSeverity a(int param1Int) {
          return LogSeverity.forNumber(param1Int);
        }
      };
    VALUES = values();
  }
  
  LogSeverity(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static LogSeverity forNumber(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 100) ? ((paramInt != 200) ? ((paramInt != 300) ? ((paramInt != 400) ? ((paramInt != 500) ? ((paramInt != 600) ? ((paramInt != 700) ? ((paramInt != 800) ? null : EMERGENCY) : ALERT) : CRITICAL) : ERROR) : WARNING) : NOTICE) : INFO) : DEBUG) : DEFAULT;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor() {
    return LogSeverityProto.a().getEnumTypes().get(0);
  }
  
  public static Internal.EnumLiteMap<LogSeverity> internalGetValueMap() {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\logging\type\LogSeverity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */