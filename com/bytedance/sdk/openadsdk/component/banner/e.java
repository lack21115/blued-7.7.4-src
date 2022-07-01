package com.bytedance.sdk.openadsdk.component.banner;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Map;

public class e implements TTBannerAd, ak.a {
  private final d a;
  
  private final a b;
  
  private final Context c;
  
  private ak d;
  
  private int e;
  
  private k f;
  
  private TTBannerAd.AdInteractionListener g;
  
  private TTAppDownloadListener h;
  
  private b i;
  
  private final b j;
  
  private a k;
  
  private String l = "banner_ad";
  
  private AdSlot m;
  
  public e(Context paramContext, a parama, AdSlot paramAdSlot) {
    this.c = paramContext;
    this.b = parama;
    this.m = paramAdSlot;
    this.f = parama.b();
    this.a = new d(paramContext);
    this.j = b.a(this.c);
    a(this.a.b(), parama);
  }
  
  private EmptyView a(ViewGroup paramViewGroup) {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof EmptyView)
        return (EmptyView)view; 
    } 
    return null;
  }
  
  private a a(k paramk) {
    return (paramk.B() == 4) ? a.a(this.c, paramk, this.l) : null;
  }
  
  private void a() {
    this.j.a(this.m, new b.a(this) {
          public void a() {
            e.a(this.a);
          }
          
          public void a(a param1a) {
            e.a(this.a, param1a);
            e.d(this.a).e();
            e.a(this.a);
          }
        });
  }
  
  private void a(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    b(paramDislikeInteractionCallback);
    this.a.a(this.i);
  }
  
  private void a(a parama) {
    if (this.a.c() != null && !this.a.f())
      a(this.a.c(), parama); 
  }
  
  private void a(c paramc, a parama) {
    paramc.a(parama.a());
    k k1 = parama.b();
    this.f = k1;
    this.i = new b(this.c, this.f);
    paramc.a(k1);
    this.k = a(k1);
    a a2 = this.k;
    if (a2 != null) {
      a2.b();
      if (paramc.getContext() != null && paramc.getContext() instanceof Activity)
        this.k.a((Activity)paramc.getContext()); 
    } 
    d.a(k1);
    EmptyView emptyView2 = a((ViewGroup)paramc);
    EmptyView emptyView1 = emptyView2;
    if (emptyView2 == null) {
      emptyView1 = new EmptyView(this.c, (View)paramc);
      paramc.addView((View)emptyView1);
    } 
    a a4 = this.k;
    if (a4 != null)
      a4.a((View)emptyView1); 
    emptyView1.setCallback(new EmptyView.a(this, k1) {
          public void a() {
            if (e.b(this.b) != null)
              e.b(this.b).a(); 
          }
          
          public void a(View param1View) {
            e.a(this.b);
            t.b("TTBannerAd", "BANNER SHOW");
            d.a(e.e(this.b), this.a, e.f(this.b), null);
            if (e.g(this.b) != null)
              e.g(this.b).onAdShow(param1View, this.a.B()); 
            if (this.a.U())
              ah.a(this.a, param1View); 
          }
          
          public void a(boolean param1Boolean) {
            if (e.b(this.b) != null)
              if (param1Boolean) {
                if (e.b(this.b) != null)
                  e.b(this.b).b(); 
              } else if (e.b(this.b) != null) {
                e.b(this.b).c();
              }  
            if (param1Boolean) {
              e.a(this.b);
              t.b("TTBannerAd", "获得焦点，开始计时");
              return;
            } 
            t.b("TTBannerAd", "失去焦点，停止计时");
            e.c(this.b);
          }
          
          public void b() {
            e.c(this.b);
            if (e.b(this.b) != null)
              e.b(this.b).d(); 
          }
        });
    a a3 = new a(this.c, k1, this.l, 2);
    a3.a((View)paramc);
    a3.b(this.a.d());
    a3.a(this.k);
    a3.a(new b.a(this) {
          public void a(View param1View, int param1Int) {
            if (e.g(this.a) != null)
              e.g(this.a).onAdClicked(param1View, param1Int); 
          }
        });
    paramc.setOnClickListener((View.OnClickListener)a3);
    paramc.setOnTouchListener((View.OnTouchListener)a3);
    a a1 = this.k;
    if (a1 != null)
      a1.a(this.h); 
    emptyView1.setNeedCheckingShow(true);
  }
  
  private void b() {
    ak ak1 = this.d;
    if (ak1 != null) {
      ak1.removeCallbacksAndMessages(null);
      this.d.sendEmptyMessageDelayed(1, this.e);
    } 
  }
  
  private void b(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (this.i == null)
      this.i = new b(this.c, this.f); 
    this.i.setDislikeInteractionCallback(paramDislikeInteractionCallback);
  }
  
  private void c() {
    ak ak1 = this.d;
    if (ak1 != null)
      ak1.removeCallbacksAndMessages(null); 
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what == 1)
      a(); 
  }
  
  public View getBannerView() {
    return (View)this.a;
  }
  
  public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (paramDislikeInteractionCallback == null)
      return null; 
    b(paramDislikeInteractionCallback);
    return (TTAdDislike)this.i;
  }
  
  public int getInteractionType() {
    k k1 = this.f;
    return (k1 == null) ? -1 : k1.B();
  }
  
  public Map<String, Object> getMediaExtraInfo() {
    k k1 = this.f;
    return (k1 != null) ? k1.X() : null;
  }
  
  public void setBannerInteractionListener(TTBannerAd.AdInteractionListener paramAdInteractionListener) {
    this.g = paramAdInteractionListener;
  }
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
    this.h = paramTTAppDownloadListener;
    a a1 = this.k;
    if (a1 != null)
      a1.a(this.h); 
  }
  
  public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (paramDislikeInteractionCallback == null)
      return; 
    a(paramDislikeInteractionCallback);
  }
  
  public void setSlideIntervalTime(int paramInt) {
    int i;
    if (paramInt <= 0)
      return; 
    this.l = "slide_banner_ad";
    a(this.a.b(), this.b);
    this.a.a();
    this.a.a(1000);
    if (paramInt < 30000) {
      i = 30000;
    } else {
      i = paramInt;
      if (paramInt > 120000)
        i = 120000; 
    } 
    this.e = i;
    this.d = new ak(Looper.getMainLooper(), this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\banner\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */