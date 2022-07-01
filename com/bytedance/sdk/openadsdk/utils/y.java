package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;

public class y {
  public static void a(Context paramContext, String paramString) {
    if (!(paramContext instanceof android.app.Activity))
      b(paramString); 
  }
  
  public static void a(Object paramObject, String paramString) {
    if (paramObject == null)
      b(paramString); 
  }
  
  public static void a(String paramString) {
    b(paramString);
  }
  
  public static void a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      b(paramString2); 
  }
  
  public static void a(boolean paramBoolean, String paramString) {
    if (!paramBoolean)
      b(paramString); 
  }
  
  private static void b(String paramString) {
    throw new IllegalArgumentException(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */