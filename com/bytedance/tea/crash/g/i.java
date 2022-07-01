package com.bytedance.tea.crash.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.tea.crash.upload.b;

public final class i {
  public static String a(Context paramContext) {
    return a(c(paramContext));
  }
  
  public static String a(b.b paramb) {
    try {
      int j = null.a[paramb.ordinal()];
      if (j != 1) {
        if (j != 2)
          return (j != 3) ? ((j != 4) ? ((j != 5) ? "" : "mobile") : "4g") : "3g"; 
      } else {
        return "wifi";
      } 
    } catch (Exception exception) {
      return "";
    } 
    return "2g";
  }
  
  public static boolean b(Context paramContext) {
    boolean bool = false;
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return false; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      boolean bool1 = bool;
      if (networkInfo != null) {
        boolean bool2 = networkInfo.isAvailable();
        bool1 = bool;
        if (bool2)
          bool1 = true; 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static b.b c(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return b.b.a; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo == null || !networkInfo.isAvailable())
        return b.b.a; 
      int j = networkInfo.getType();
      if (1 == j)
        return b.b.e; 
      return b.b.b;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */