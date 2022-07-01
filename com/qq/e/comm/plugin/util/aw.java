package com.qq.e.comm.plugin.util;

import java.util.Locale;

public class aw {
  public static String a(long paramLong) {
    float f = (float)paramLong / 1048576.0F;
    return String.format(Locale.ENGLISH, "%.2f M", new Object[] { Float.valueOf(f) });
  }
  
  public static String b(long paramLong) {
    float f = (float)paramLong / 1024.0F;
    return String.format(Locale.ENGLISH, "%.2f K", new Object[] { Float.valueOf(f) });
  }
  
  public static String c(long paramLong) {
    return (paramLong > 1048576L) ? a(paramLong) : b(paramLong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */