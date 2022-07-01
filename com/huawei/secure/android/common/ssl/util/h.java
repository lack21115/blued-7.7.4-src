package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

public class h {
  private static final String a = h.class.getSimpleName();
  
  public static boolean a(String paramString) {
    Context context = c.a();
    if (context == null)
      return false; 
    PackageManager packageManager = context.getPackageManager();
    if (packageManager != null)
      try {
        return false;
      } catch (Exception exception) {
        return false;
      } finally {
        paramString = null;
        g.d(a, "throwable");
      }  
    return false;
  }
  
  public static String b(String paramString) {
    Context context = c.a();
    if (context == null)
      return ""; 
    try {
      return (context.getPackageManager().getPackageInfo(paramString, 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getVersion NameNotFoundException : ");
      return "";
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getVersion: ");
      return "";
    } finally {
      paramString = null;
      g.d(a, "throwable");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ss\\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */