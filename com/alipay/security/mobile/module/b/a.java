package com.alipay.security.mobile.module.b;

import android.content.Context;

public final class a {
  private static a a = new a();
  
  public static a a() {
    return a;
  }
  
  public static String a(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16)).versionName;
    } catch (Exception exception) {
      return "0.0.0";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */