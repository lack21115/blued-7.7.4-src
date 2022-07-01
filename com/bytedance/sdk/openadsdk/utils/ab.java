package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public final class ab {
  private static String a;
  
  private static Resources b;
  
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
  
  public static String a(Context paramContext, String paramString) {
    return paramContext.getResources().getString(b(paramContext, paramString));
  }
  
  public static int b(Context paramContext, String paramString) {
    return a(paramContext, paramString, "string");
  }
  
  public static Drawable c(Context paramContext, String paramString) {
    return paramContext.getResources().getDrawable(d(paramContext, paramString));
  }
  
  public static int d(Context paramContext, String paramString) {
    return a(paramContext, paramString, "drawable");
  }
  
  public static int e(Context paramContext, String paramString) {
    return a(paramContext, paramString, "id");
  }
  
  public static int f(Context paramContext, String paramString) {
    return a(paramContext, paramString, "layout");
  }
  
  public static int g(Context paramContext, String paramString) {
    return a(paramContext, paramString, "style");
  }
  
  public static int h(Context paramContext, String paramString) {
    return a(paramContext, paramString, "dimen");
  }
  
  public static int i(Context paramContext, String paramString) {
    return paramContext.getResources().getColor(j(paramContext, paramString));
  }
  
  public static int j(Context paramContext, String paramString) {
    return a(paramContext, paramString, "color");
  }
  
  public static int k(Context paramContext, String paramString) {
    return a(paramContext, paramString, "integer");
  }
  
  public static int l(Context paramContext, String paramString) {
    return paramContext.getResources().getInteger(k(paramContext, paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */