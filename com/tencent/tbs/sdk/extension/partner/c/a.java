package com.tencent.tbs.sdk.extension.partner.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class a {
  public static int a(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (networkInfo != null) {
      bool1 = bool2;
      if (networkInfo.isConnectedOrConnecting()) {
        switch (networkInfo.getType()) {
          default:
            return 0;
          case 1:
            return 3;
          case 0:
            break;
        } 
        switch (networkInfo.getSubtype()) {
          default:
            return 0;
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
            return 2;
          case 1:
          case 2:
          case 4:
          case 7:
          case 11:
            break;
        } 
        bool1 = true;
      } 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */