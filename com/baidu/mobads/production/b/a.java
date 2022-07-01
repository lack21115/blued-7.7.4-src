package com.baidu.mobads.production.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

public class a {
  public static int a(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    if (networkInfo != null) {
      if (!networkInfo.isConnected())
        return 0; 
      networkInfo = connectivityManager.getNetworkInfo(1);
      if (networkInfo != null && a(networkInfo.getState()))
        return 100; 
      if (Build.VERSION.SDK_INT >= 13) {
        networkInfo = connectivityManager.getNetworkInfo(9);
        if (networkInfo != null && a(networkInfo.getState()))
          return 101; 
      } 
      NetworkInfo networkInfo1 = connectivityManager.getNetworkInfo(0);
      if (networkInfo1 != null && a(networkInfo1.getState())) {
        switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType()) {
          default:
            return 1;
          case 13:
            return 4;
          case 3:
          case 5:
          case 6:
          case 8:
          case 9:
          case 10:
          case 12:
          case 14:
          case 15:
            return 3;
          case 1:
          case 2:
          case 4:
          case 7:
          case 11:
            break;
        } 
        return 2;
      } 
      return 999;
    } 
    return 0;
  }
  
  private static boolean a(NetworkInfo.State paramState) {
    return (paramState != null && (paramState == NetworkInfo.State.CONNECTED || paramState == NetworkInfo.State.CONNECTING));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */