package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.component.reward.c;
import com.bytedance.sdk.openadsdk.component.reward.d;
import com.bytedance.sdk.openadsdk.component.reward.g;

public class TTC3Proxy {
  public static void a(Context paramContext) {
    try {
      g.a(paramContext).b();
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void loadFull(Context paramContext, AdSlot paramAdSlot, TTAdNative.FullScreenVideoAdListener paramFullScreenVideoAdListener) {
    c.a(paramContext).a(paramAdSlot, paramFullScreenVideoAdListener);
  }
  
  public static void loadReward(Context paramContext, AdSlot paramAdSlot, TTAdNative.RewardVideoAdListener paramRewardVideoAdListener) {
    g.a(paramContext).a(paramAdSlot, paramRewardVideoAdListener);
  }
  
  public static void verityPlayable(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {
    d.a(paramString1, paramInt, paramString2, paramString3, paramString4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTC3Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */