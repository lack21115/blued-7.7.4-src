package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;

public class u {
  private static u a;
  
  private c b;
  
  private boolean c = true;
  
  private k d;
  
  private TTRewardVideoAd.RewardAdInteractionListener e;
  
  private a f;
  
  private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener g;
  
  private boolean h = false;
  
  public static u a() {
    if (a == null)
      a = new u(); 
    return a;
  }
  
  public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener paramFullScreenVideoAdInteractionListener) {
    this.g = paramFullScreenVideoAdInteractionListener;
  }
  
  public void a(TTRewardVideoAd.RewardAdInteractionListener paramRewardAdInteractionListener) {
    this.e = paramRewardAdInteractionListener;
  }
  
  public void a(k paramk) {
    this.d = paramk;
  }
  
  public void a(a parama) {
    this.f = parama;
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void b(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public boolean b() {
    return this.c;
  }
  
  public k c() {
    return this.d;
  }
  
  public TTRewardVideoAd.RewardAdInteractionListener d() {
    return this.e;
  }
  
  public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
    return this.g;
  }
  
  public a f() {
    return this.f;
  }
  
  public void g() {
    this.b = null;
    this.d = null;
    this.e = null;
    this.g = null;
    this.f = null;
    this.h = false;
    this.c = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\cor\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */