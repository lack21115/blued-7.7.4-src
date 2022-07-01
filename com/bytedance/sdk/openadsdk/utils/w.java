package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

public class w {
  public static boolean a(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return false; 
      NetworkInfo[] arrayOfNetworkInfo = connectivityManager.getAllNetworkInfo();
      return false;
    } finally {
      paramContext = null;
    } 
  }
  
  public static boolean a(String paramString) {
    return (!TextUtils.isEmpty(paramString) && (paramString.startsWith("http://") || paramString.startsWith("https://")));
  }
  
  public static int b(Context paramContext) {
    int i = c(paramContext);
    return (i != 1) ? ((i != 4) ? ((i != 5) ? i : 4) : 1) : 0;
  }
  
  public static int c(Context paramContext) {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo == null || !networkInfo.isAvailable())
        return 0; 
      int i = networkInfo.getType();
    } finally {
      paramContext = null;
    } 
    return 4;
  }
  
  public static boolean d(Context paramContext) {
    return (c(paramContext) == 4);
  }
  
  public static boolean e(Context paramContext) {
    return (c(paramContext) == 5);
  }
  
  public static String f(Context paramContext) {
    int i = c(paramContext);
    return (i != 2) ? ((i != 3) ? ((i != 4) ? ((i != 5) ? "mobile" : "4g") : "wifi") : "3g") : "2g";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */