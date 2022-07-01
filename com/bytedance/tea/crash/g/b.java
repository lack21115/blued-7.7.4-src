package com.bytedance.tea.crash.g;

import android.os.Build;
import android.os.Debug;

public class b {
  static final a a = new a();
  
  public static int a(Debug.MemoryInfo paramMemoryInfo) {
    return a.a(paramMemoryInfo);
  }
  
  public static int b(Debug.MemoryInfo paramMemoryInfo) {
    return a.b(paramMemoryInfo);
  }
  
  public static int c(Debug.MemoryInfo paramMemoryInfo) {
    return a.c(paramMemoryInfo);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 19) {
      a = new b();
      return;
    } 
  }
  
  static class a {
    private a() {}
    
    public int a(Debug.MemoryInfo param1MemoryInfo) {
      return -1;
    }
    
    public int b(Debug.MemoryInfo param1MemoryInfo) {
      return -1;
    }
    
    public int c(Debug.MemoryInfo param1MemoryInfo) {
      return -1;
    }
  }
  
  static class b extends a {
    private b() {}
    
    public int a(Debug.MemoryInfo param1MemoryInfo) {
      return param1MemoryInfo.getTotalPrivateClean();
    }
    
    public int b(Debug.MemoryInfo param1MemoryInfo) {
      return param1MemoryInfo.getTotalSharedClean();
    }
    
    public int c(Debug.MemoryInfo param1MemoryInfo) {
      return param1MemoryInfo.getTotalSwappablePss();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */