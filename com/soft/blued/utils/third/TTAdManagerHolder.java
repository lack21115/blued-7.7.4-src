package com.soft.blued.utils.third;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;

public class TTAdManagerHolder {
  private static boolean a;
  
  public static TTAdManager a(Context paramContext) {
    if (!a)
      c(paramContext); 
    return TTAdSdk.getAdManager();
  }
  
  public static void b(Context paramContext) {
    c(paramContext);
  }
  
  private static void c(Context paramContext) {
    if (!a) {
      TTADUtils.a(paramContext);
      a = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\third\TTAdManagerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */