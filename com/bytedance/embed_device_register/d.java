package com.bytedance.embed_device_register;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;

final class d {
  static int a(String paramString, int paramInt) {
    try {
      return Integer.parseInt(paramString);
    } catch (NumberFormatException numberFormatException) {
      numberFormatException.printStackTrace();
      return paramInt;
    } 
  }
  
  static long a(String paramString, long paramLong) {
    try {
      return Long.parseLong(paramString);
    } catch (NumberFormatException numberFormatException) {
      numberFormatException.printStackTrace();
      return paramLong;
    } 
  }
  
  static void a(Runnable paramRunnable) {
    a((String)null, paramRunnable);
  }
  
  static void a(String paramString, Runnable paramRunnable) {
    if (paramRunnable == null)
      return; 
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "TrackerDr"; 
    (new Thread(new a(paramRunnable, str), str)).start();
  }
  
  static <K, V> void a(Map<K, V> paramMap, K paramK, V paramV) {
    if (paramK != null && paramV != null)
      paramMap.put(paramK, paramV); 
  }
  
  static boolean a(Context paramContext, String paramString) {
    PackageManager packageManager = paramContext.getPackageManager();
    boolean bool = false;
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 128);
      if (packageInfo != null)
        bool = true; 
      return bool;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  static class a implements Runnable {
    private final Runnable a;
    
    private final String b;
    
    private final String c;
    
    a(Runnable param1Runnable, String param1String) {
      this.a = param1Runnable;
      this.b = param1String;
      this.c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));
    }
    
    public void run() {
      try {
        this.a.run();
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thread:");
        stringBuilder.append(this.b);
        stringBuilder.append(" exception\n");
        stringBuilder.append(this.c);
        c.a("TrackerDr", stringBuilder.toString(), exception);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embed_device_register\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */