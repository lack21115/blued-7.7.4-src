package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.a.b;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.e.a;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.b;
import com.bytedance.sdk.openadsdk.utils.ag;
import com.bytedance.sdk.openadsdk.utils.y;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class w implements TTAdNative {
  private final p a = o.f();
  
  private final Context b;
  
  public w(Context paramContext) {
    this.b = paramContext;
  }
  
  private void a(AdSlot paramAdSlot) {
    boolean bool1;
    int i = paramAdSlot.getImgAcceptedWidth();
    boolean bool2 = true;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    y.a(bool1, "必须设置图片素材尺寸");
    if (paramAdSlot.getImgAcceptedHeight() > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    y.a(bool1, "必须设置图片素材尺寸");
  }
  
  private boolean a(b paramb) {
    if (!j.a()) {
      if (paramb != null)
        paramb.onError(1000, "广告请求开关已关闭,请联系穿山甲管理员"); 
      return true;
    } 
    return false;
  }
  
  private void b(AdSlot paramAdSlot) {
    boolean bool;
    a(paramAdSlot);
    if (paramAdSlot.getNativeAdType() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    y.a(bool, "必须设置请求原生广告的类型，目前支持TYPE_BANNER和TYPE_INTERACTION_AD");
  }
  
  private void c(AdSlot paramAdSlot) {
    boolean bool;
    a(paramAdSlot);
    if (paramAdSlot.getNativeAdType() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    y.a(bool, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
  }
  
  public void loadBannerAd(AdSlot paramAdSlot, TTAdNative.BannerAdListener paramBannerAdListener) {
    if (a((b)paramBannerAdListener))
      return; 
    c(paramAdSlot);
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", new Class[] { Context.class, AdSlot.class, TTAdNative.BannerAdListener.class });
    } finally {
      paramAdSlot = null;
    } 
  }
  
  public void loadBannerExpressAd(AdSlot paramAdSlot, TTAdNative.NativeExpressAdListener paramNativeExpressAdListener) {
    if (a((b)paramNativeExpressAdListener))
      return; 
    paramAdSlot.setNativeAdType(1);
    b.a(this.b).a(paramAdSlot, 1, paramNativeExpressAdListener, 5000);
  }
  
  public void loadDrawFeedAd(AdSlot paramAdSlot, TTAdNative.DrawFeedAdListener paramDrawFeedAdListener) {
    if (a((b)paramDrawFeedAdListener))
      return; 
    a(paramAdSlot);
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", new Class[] { Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class });
    } finally {
      paramAdSlot = null;
    } 
  }
  
  public void loadExpressDrawFeedAd(AdSlot paramAdSlot, TTAdNative.NativeExpressAdListener paramNativeExpressAdListener) {
    if (a((b)paramNativeExpressAdListener))
      return; 
    b.a(this.b).a(paramAdSlot, 9, paramNativeExpressAdListener, 5000);
  }
  
  public void loadFeedAd(AdSlot paramAdSlot, TTAdNative.FeedAdListener paramFeedAdListener) {
    if (a((b)paramFeedAdListener))
      return; 
    c(paramAdSlot);
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", new Class[] { Context.class, AdSlot.class, TTAdNative.FeedAdListener.class });
    } finally {
      paramAdSlot = null;
    } 
  }
  
  public void loadFullScreenVideoAd(AdSlot paramAdSlot, TTAdNative.FullScreenVideoAdListener paramFullScreenVideoAdListener) {
    if (a((b)paramFullScreenVideoAdListener))
      return; 
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", new Class[] { Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class });
    } finally {
      paramAdSlot = null;
    } 
  }
  
  public void loadInteractionAd(AdSlot paramAdSlot, TTAdNative.InteractionAdListener paramInteractionAdListener) {
    if (a((b)paramInteractionAdListener))
      return; 
    c(paramAdSlot);
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", new Class[] { Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class });
    } finally {
      paramAdSlot = null;
    } 
  }
  
  public void loadInteractionExpressAd(AdSlot paramAdSlot, TTAdNative.NativeExpressAdListener paramNativeExpressAdListener) {
    if (a((b)paramNativeExpressAdListener))
      return; 
    paramAdSlot.setNativeAdType(2);
    b.a(this.b).a(paramAdSlot, 2, paramNativeExpressAdListener, 5000);
  }
  
  public void loadNativeAd(AdSlot paramAdSlot, TTAdNative.NativeAdListener paramNativeAdListener) {
    if (a((b)paramNativeAdListener))
      return; 
    b(paramAdSlot);
    this.a.a(paramAdSlot, (l)null, paramAdSlot.getNativeAdType(), new p.b(this, paramNativeAdListener, paramAdSlot) {
          public void a(int param1Int, String param1String) {
            this.a.onError(param1Int, param1String);
          }
          
          public void a(a param1a) {
            if (param1a.c() != null && !param1a.c().isEmpty()) {
              List list = param1a.c();
              ArrayList<a> arrayList = new ArrayList(list.size());
              for (k k : list) {
                if (k.aa())
                  arrayList.add(new a(this, w.a(this.c), k, this.b.getNativeAdType()) {
                      
                      }); 
              } 
              if (!arrayList.isEmpty()) {
                this.a.onNativeAdLoad(arrayList);
                return;
              } 
              this.a.onError(-4, g.a(-4));
              return;
            } 
            this.a.onError(-3, g.a(-3));
          }
        });
  }
  
  public void loadNativeExpressAd(AdSlot paramAdSlot, TTAdNative.NativeExpressAdListener paramNativeExpressAdListener) {
    if (a((b)paramNativeExpressAdListener))
      return; 
    b.a(this.b).a(paramAdSlot, 5, paramNativeExpressAdListener, 5000);
  }
  
  public void loadRewardVideoAd(AdSlot paramAdSlot, TTAdNative.RewardVideoAdListener paramRewardVideoAdListener) {
    if (a((b)paramRewardVideoAdListener))
      return; 
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", new Class[] { Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class });
    } finally {
      paramAdSlot = null;
    } 
  }
  
  public void loadSplashAd(AdSlot paramAdSlot, TTAdNative.SplashAdListener paramSplashAdListener) {
    if (a((b)paramSplashAdListener))
      return; 
    c(paramAdSlot);
    loadSplashAd(paramAdSlot, paramSplashAdListener, -1);
  }
  
  public void loadSplashAd(AdSlot paramAdSlot, TTAdNative.SplashAdListener paramSplashAdListener, int paramInt) {
    if (a((b)paramSplashAdListener))
      return; 
    c(paramAdSlot);
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", new Class[] { Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, int.class });
    } finally {
      paramAdSlot = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */