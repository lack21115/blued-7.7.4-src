package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.multipro.b;

@Deprecated
public class TTAdManagerFactory {
  private static final TTAdManager a = (TTAdManager)new v();
  
  static TTAdManager a() {
    return a;
  }
  
  public static TTAdManager getInstance(Context paramContext) {
    return getInstance(paramContext, false);
  }
  
  public static TTAdManager getInstance(Context paramContext, boolean paramBoolean) {
    if (paramBoolean)
      b.a(); 
    l.a(paramContext);
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAdManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */