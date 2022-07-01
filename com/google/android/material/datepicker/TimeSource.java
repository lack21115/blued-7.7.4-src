package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class TimeSource {
  private static final TimeSource a = new TimeSource(null, null);
  
  private final Long b;
  
  private final TimeZone c;
  
  private TimeSource(Long paramLong, TimeZone paramTimeZone) {
    this.b = paramLong;
    this.c = paramTimeZone;
  }
  
  static TimeSource a() {
    return a;
  }
  
  Calendar a(TimeZone paramTimeZone) {
    Calendar calendar;
    if (paramTimeZone == null) {
      calendar = Calendar.getInstance();
    } else {
      calendar = Calendar.getInstance((TimeZone)calendar);
    } 
    Long long_ = this.b;
    if (long_ != null)
      calendar.setTimeInMillis(long_.longValue()); 
    return calendar;
  }
  
  Calendar b() {
    return a(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\TimeSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */