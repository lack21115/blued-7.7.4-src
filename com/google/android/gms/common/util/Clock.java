package com.google.android.gms.common.util;

public interface Clock {
  long currentThreadTimeMillis();
  
  long currentTimeMillis();
  
  long elapsedRealtime();
  
  long nanoTime();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */