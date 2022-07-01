package com.blued.android.framework.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.blued.android.core.AppInfo;

public class NetworkUtils {
  private static final String a = NetworkUtils.class.getSimpleName();
  
  public static boolean a() {
    NetworkInfo networkInfo = ((ConnectivityManager)AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isAvailable()) {
      if (networkInfo != null && networkInfo.getType() == 1) {
        Logger.b(a, new Object[] { "  wifi状态" });
        return false;
      } 
      Logger.b(a, new Object[] { "  正常联网的非wifi状态" });
      return true;
    } 
    return false;
  }
  
  public static boolean b() {
    NetworkInfo networkInfo = ((ConnectivityManager)AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo != null && networkInfo.isAvailable());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */