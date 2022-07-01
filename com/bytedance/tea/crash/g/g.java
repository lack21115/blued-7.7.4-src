package com.bytedance.tea.crash.g;

import android.app.ActivityManager;
import android.os.Build;

public class g {
  static final a a = new a();
  
  public static long a(ActivityManager.MemoryInfo paramMemoryInfo) {
    return a.a(paramMemoryInfo);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 16) {
      a = new b();
      return;
    } 
  }
  
  static class a {
    private a() {}
    
    public long a(ActivityManager.MemoryInfo param1MemoryInfo) {
      return 0L;
    }
  }
  
  static class b extends a {
    private b() {}
    
    public long a(ActivityManager.MemoryInfo param1MemoryInfo) {
      return param1MemoryInfo.totalMem;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */