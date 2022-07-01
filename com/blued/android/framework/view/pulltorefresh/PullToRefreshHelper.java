package com.blued.android.framework.view.pulltorefresh;

import com.blued.android.core.AppInfo;

public class PullToRefreshHelper {
  private static int a = 0;
  
  private static int b = 0;
  
  private static int c = 0;
  
  private static int d = 0;
  
  private static int e = 0;
  
  private static String f = "";
  
  public static String a() {
    return (a > 0) ? AppInfo.d().getString(a) : "";
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
    d = paramInt4;
    e = paramInt5;
  }
  
  public static void a(String paramString) {
    f = paramString;
  }
  
  public static String b() {
    return (b > 0) ? AppInfo.d().getString(b) : "";
  }
  
  public static String c() {
    return (c > 0) ? AppInfo.d().getString(c) : "";
  }
  
  public static String d() {
    return (d > 0) ? AppInfo.d().getString(d) : "";
  }
  
  public static String e() {
    return f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PullToRefreshHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */