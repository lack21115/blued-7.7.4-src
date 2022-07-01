package com.bytedance.tea.crash.e;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;

public class i {
  private static long a = -1L;
  
  static class a {
    private static long a = -1L;
    
    public static long a() {
      if (i.a() == -1L)
        i.a(1000L / b()); 
      return i.a();
    }
    
    public static long a(long param1Long) {
      long l = a;
      if (l > 0L)
        return l; 
      if (Build.VERSION.SDK_INT >= 21) {
        l = Os.sysconf(OsConstants._SC_CLK_TCK);
      } else if (Build.VERSION.SDK_INT >= 14) {
        l = a("_SC_CLK_TCK", param1Long);
      } else {
        l = param1Long;
      } 
      if (l > 0L)
        param1Long = l; 
      a = param1Long;
      return a;
    }
    
    private static long a(String param1String, long param1Long) {
      try {
        int i = Class.forName("libcore.io.OsConstants").getField(param1String).getInt(null);
        Class<?> clazz2 = Class.forName("libcore.io.Libcore");
        return ((Long)clazz1.getMethod("sysconf", new Class[] { int.class }).invoke(object, new Object[] { Integer.valueOf(i) })).longValue();
      } finally {
        param1String = null;
        param1String.printStackTrace();
      } 
    }
    
    public static long b() {
      return a(100L);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */