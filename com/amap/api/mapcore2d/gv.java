package com.amap.api.mapcore2d;

import java.util.Calendar;
import java.util.Date;

public final class gv {
  private static long a(long paramLong) {
    return paramLong - b(paramLong);
  }
  
  public static long a(long paramLong1, long paramLong2) {
    long l = paramLong1;
    try {
      return l;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static long b(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(paramLong));
    calendar.set(11, 0);
    calendar.set(12, 0);
    calendar.set(13, 0);
    calendar.set(14, 0);
    return calendar.getTimeInMillis();
  }
  
  private static long b(long paramLong1, long paramLong2) {
    paramLong1 = a(paramLong1);
    long l1 = b(paramLong2) + paramLong1;
    long l2 = Math.abs(l1 - paramLong2);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(l1));
    int i = calendar.get(11);
    paramLong1 = l1;
    if (i == 23) {
      paramLong1 = l1;
      if (l2 >= 82800000L)
        paramLong1 = l1 - 86400000L; 
    } 
    paramLong2 = paramLong1;
    if (i == 0) {
      paramLong2 = paramLong1;
      if (l2 >= 82800000L)
        paramLong2 = paramLong1 + 86400000L; 
    } 
    return paramLong2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */