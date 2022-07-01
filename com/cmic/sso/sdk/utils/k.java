package com.cmic.sso.sdk.utils;

import android.content.Context;

public class k {
  public static boolean a(Context paramContext, String paramString) {
    return (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */