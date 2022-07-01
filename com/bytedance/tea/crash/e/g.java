package com.bytedance.tea.crash.e;

import java.util.concurrent.atomic.AtomicReference;

public class g {
  private static final AtomicReference<Long> a = new AtomicReference<Long>(Long.valueOf(0L));
  
  public static void a(long paramLong) {
    for (int i = 0; i < 5L; i++) {
      long l = ((Long)a.get()).longValue();
      if (a.compareAndSet(Long.valueOf(l), Long.valueOf(l | paramLong)))
        return; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */