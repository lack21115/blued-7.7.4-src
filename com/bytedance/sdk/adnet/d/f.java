package com.bytedance.sdk.adnet.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class f {
  public static boolean a(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return false; 
      NetworkInfo[] arrayOfNetworkInfo = connectivityManager.getAllNetworkInfo();
    } finally {
      paramContext = null;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */