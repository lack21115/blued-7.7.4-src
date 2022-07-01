package com.huawei.hms.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class NetWorkUtil {
  private static int a(NetworkInfo paramNetworkInfo) {
    if (paramNetworkInfo != null && paramNetworkInfo.isConnected()) {
      if (paramNetworkInfo.getType() == 1)
        return 1; 
      if (paramNetworkInfo.getType() == 0) {
        switch (paramNetworkInfo.getSubtype()) {
          default:
            return 6;
          case 13:
          case 14:
            return 4;
          case 3:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10:
          case 11:
          case 12:
          case 15:
            return 3;
          case 1:
          case 2:
          case 4:
            break;
        } 
        return 2;
      } 
    } 
    return 0;
  }
  
  private static NetworkInfo a(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    return (connectivityManager != null) ? connectivityManager.getActiveNetworkInfo() : null;
  }
  
  public static int getNetworkType(Context paramContext) {
    return a(a(paramContext));
  }
  
  public static final class NetType {
    public static final int NET = -2;
    
    public static final int TYPE_2G = 2;
    
    public static final int TYPE_3G = 3;
    
    public static final int TYPE_4G = 4;
    
    public static final int TYPE_5G = 5;
    
    public static final int TYPE_NEED_INIT = -1;
    
    public static final int TYPE_OTHER = 6;
    
    public static final int TYPE_UNKNOWN = 0;
    
    public static final int TYPE_WIFI = 1;
    
    public static final int WAP = -3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\NetWorkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */