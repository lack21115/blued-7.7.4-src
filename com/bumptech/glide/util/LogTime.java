package com.bumptech.glide.util;

import android.os.Build;
import android.os.SystemClock;

public final class LogTime {
  private static final double a;
  
  static {
    int i = Build.VERSION.SDK_INT;
    double d = 1.0D;
    if (i >= 17)
      d = 1.0D / Math.pow(10.0D, 6.0D); 
    a = d;
  }
  
  public static double a(long paramLong) {
    return (a() - paramLong) * a;
  }
  
  public static long a() {
    return (Build.VERSION.SDK_INT >= 17) ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\LogTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */