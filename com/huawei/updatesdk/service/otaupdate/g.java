package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

public final class g {
  private static String a;
  
  private static Resources b;
  
  public static int a(Context paramContext, String paramString) {
    return a(paramContext, paramString, "color");
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2) {
    if (b == null)
      b = paramContext.getResources(); 
    return b.getIdentifier(paramString1, paramString2, a(paramContext));
  }
  
  private static String a(Context paramContext) {
    if (a == null)
      a = paramContext.getPackageName(); 
    return a;
  }
  
  public static int b(Context paramContext, String paramString) {
    return a(paramContext, paramString, "drawable");
  }
  
  public static int c(Context paramContext, String paramString) {
    return a(paramContext, paramString, "id");
  }
  
  public static int d(Context paramContext, String paramString) {
    return a(paramContext, paramString, "layout");
  }
  
  public static int e(Context paramContext, String paramString) {
    return a(paramContext, paramString, "string");
  }
  
  public static String f(Context paramContext, String paramString) {
    try {
      return paramContext.getResources().getString(a(paramContext, paramString, "string"));
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("recource get error name: ");
      stringBuilder.append(paramString);
      Log.e("UpdateSDK", stringBuilder.toString());
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */