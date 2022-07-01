package com.blued.android.framework.utils;

import android.util.Log;

public class ClickUtils {
  private static final String a = ClickUtils.class.getSimpleName();
  
  private static long b = 0L;
  
  private static int c = -1;
  
  public static boolean a(int paramInt) {
    return a(paramInt, 1000L);
  }
  
  public static boolean a(int paramInt, long paramLong) {
    long l1 = System.currentTimeMillis();
    long l2 = b;
    if (c == paramInt && l2 > 0L && l1 - l2 < paramLong) {
      Log.d(a, "短时间内按钮多次触发");
      return true;
    } 
    b = System.currentTimeMillis();
    c = paramInt;
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\ClickUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */