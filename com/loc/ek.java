package com.loc;

import java.util.Calendar;
import java.util.Date;

public final class ek {
  private static long a(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(paramLong));
    calendar.set(11, 0);
    calendar.set(12, 0);
    calendar.set(13, 0);
    calendar.set(14, 0);
    return calendar.getTimeInMillis();
  }
  
  public static long a(long paramLong1, long paramLong2, int paramInt) {
    if (paramInt > 0)
      try {
        return paramLong1;
      } finally {
        Exception exception = null;
      }  
    return paramLong1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */