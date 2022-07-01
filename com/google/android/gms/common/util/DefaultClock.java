package com.google.android.gms.common.util;

import android.os.SystemClock;

public class DefaultClock implements Clock {
  private static final DefaultClock zza = new DefaultClock();
  
  public static Clock getInstance() {
    return zza;
  }
  
  public long currentThreadTimeMillis() {
    return SystemClock.currentThreadTimeMillis();
  }
  
  public long currentTimeMillis() {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime() {
    return SystemClock.elapsedRealtime();
  }
  
  public long nanoTime() {
    return System.nanoTime();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\DefaultClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */