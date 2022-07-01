package com.bytedance.sdk.openadsdk.component.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.n;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class e implements TTSplashAd {
  public AtomicBoolean a = new AtomicBoolean(false);
  
  private int b = 3;
  
  private final Context c;
  
  private final k d;
  
  private TsView e;
  
  private TTSplashAd.AdInteractionListener f;
  
  private boolean g;
  
  private long h = 0L;
  
  private a i;
  
  private d j;
  
  private String k = null;
  
  private boolean l = false;
  
  private boolean m = false;
  
  private boolean n;
  
  private boolean o = true;
  
  private int p = -1;
  
  private NativeExpressView q;
  
  private String r;
  
  private AdSlot s;
  
  private TTNativeExpressAd.ExpressAdInteractionListener t;
  
  private AtomicBoolean u = new AtomicBoolean(false);
  
  private AtomicBoolean v = new AtomicBoolean(false);
  
  e(Context paramContext, k paramk, AdSlot paramAdSlot, String paramString) {
    this.c = paramContext;
    this.d = paramk;
    this.m = paramk.W();
    this.s = paramAdSlot;
    this.r = paramString;
    b();
  }
  
  e(Context paramContext, k paramk, String paramString1, AdSlot paramAdSlot, String paramString2) {
    this.c = paramContext;
    this.d = paramk;
    this.m = paramk.W();
    this.k = paramString1;
    this.s = paramAdSlot;
    this.r = paramString2;
    b();
  }
  
  private a a(k paramk) {
    return (paramk.B() == 4) ? a.a(this.c, paramk, this.r) : null;
  }
  
  private void a(int paramInt) {
    TsView tsView = this.e;
    if (tsView != null)
      tsView.setCountDownTime(paramInt); 
  }
  
  private void a(NativeExpressView paramNativeExpressView, k paramk) {
    this.i = a(paramk);
    a a1 = this.i;
    if (a1 != null) {
      a1.b();
      if (paramNativeExpressView.getContext() != null && paramNativeExpressView.getContext() instanceof Activity)
        this.i.a((Activity)paramNativeExpressView.getContext()); 
    } 
    d.a(paramk);
    EmptyView emptyView = new EmptyView(this.c, (View)paramNativeExpressView);
    a a2 = this.i;
    if (a2 != null)
      a2.a((View)emptyView); 
    emptyView.setCallback(new EmptyView.a(this) {
          public void a() {
            if (e.j(this.a) != null)
              e.j(this.a).a(); 
          }
          
          public void a(View param1View) {
            if (e.h(this.a) != null)
              e.h(this.a).g(); 
          }
          
          public void a(boolean param1Boolean) {
            if (e.j(this.a) != null)
              if (param1Boolean) {
                if (e.j(this.a) != null) {
                  e.j(this.a).b();
                  return;
                } 
              } else if (e.j(this.a) != null) {
                e.j(this.a).c();
              }  
          }
          
          public void b() {
            if (e.j(this.a) != null)
              e.j(this.a).d(); 
          }
        });
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("splash_show_type", Integer.valueOf(3));
    Context context2 = this.c;
    String str = this.r;
    com.bytedance.sdk.openadsdk.core.nativeexpress.e e1 = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context2, paramk, str, ah.a(str));
    e1.a((View)paramNativeExpressView);
    e1.a(this.i);
    e1.a(hashMap);
    this.q.setClickListener(e1);
    Context context1 = this.c;
    str = this.r;
    d d1 = new d(context1, paramk, str, ah.a(str));
    d1.a((View)paramNativeExpressView);
    d1.a(this.i);
    d1.a(hashMap);
    this.q.setClickCreativeListener(d1);
    emptyView.setNeedCheckingShow(true);
  }
  
  private void a(String paramString1, String paramString2) {
    d d1 = this.j;
    if (d1 != null) {
      Map map = ah.a(this.d, d1.n(), this.j.t());
      d.a(this.c, this.d, paramString1, paramString2, this.j.o(), this.j.q(), map);
    } 
  }
  
  private void b() {
    this.e = new TsView(this.c);
    d.a(this.d);
    if (this.d.z() != null && this.m) {
      this.e.setVideoViewVisibility(0);
      this.e.setImageViewVisibility(8);
      this.e.setVoiceViewListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              int i;
              if (e.a(this.a)) {
                i = ab.d(e.b(this.a), "tt_splash_unmute");
              } else {
                i = ab.d(e.b(this.a), "tt_splash_mute");
              } 
              e.c(this.a).setVoiceViewImageResource(i);
              e e1 = this.a;
              e.a(e1, e.a(e1) ^ true);
              if (e.d(this.a) != null)
                e.d(this.a).c(e.a(this.a)); 
            }
          });
    } 
    if (!this.m) {
      this.e.setVideoViewVisibility(8);
      this.e.setImageViewVisibility(0);
    } 
    if (this.d.g() == 0) {
      TsView tsView = this.e;
      if (tsView != null)
        tsView.setAdlogoViewVisibility(8); 
    } else {
      TsView tsView = this.e;
      if (tsView != null)
        tsView.setAdlogoViewVisibility(0); 
    } 
    if (this.d.T() <= 0) {
      a(3);
    } else {
      this.b = this.d.T();
      a(this.b);
    } 
    e();
    d();
  }
  
  private boolean b(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte != null && paramArrayOfbyte.length >= 3 && paramArrayOfbyte[0] == 71 && paramArrayOfbyte[1] == 73 && paramArrayOfbyte[2] == 70);
  }
  
  private boolean c() {
    this.j = new d(this.c, (ViewGroup)this.e.getVideoContainer(), this.d);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mVideoCachePath:");
    stringBuilder.append(this.k);
    t.e("wzj", stringBuilder.toString());
    this.j.a(new c.a(this) {
          public void a() {
            if (e.d(this.a) != null)
              e.d(this.a).l(); 
            if (e.e(this.a) != null)
              e.e(this.a).onAdTimeOver(); 
          }
          
          public void a(long param1Long, int param1Int) {}
          
          public void a(long param1Long1, long param1Long2) {}
          
          public void b(long param1Long, int param1Int) {}
        });
    boolean bool = this.j.a(this.k, this.d.M(), this.e.getVideoContainer().getWidth(), this.e.getVideoContainer().getHeight(), null, this.d.P(), 0L, this.o);
    this.n = bool;
    return bool;
  }
  
  private void d() {
    k k1 = this.d;
    if (k1 != null) {
      if (k1.x() == null)
        return; 
      if (this.d.z() == null) {
        this.q = new NativeExpressView(this.c, this.d, this.s, this.r);
      } else if (!TextUtils.isEmpty(this.k)) {
        this.q = (NativeExpressView)new NativeExpressVideoView(this.c, this.d, this.s, this.r);
      } 
      NativeExpressView nativeExpressView = this.q;
      if (nativeExpressView == null)
        return; 
      a(nativeExpressView, this.d);
      this.q.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) {
            public void onAdClicked(View param1View, int param1Int) {
              if (e.f(this.a) != null)
                e.f(this.a).onAdClicked(param1View, param1Int); 
              if (e.e(this.a) != null)
                e.e(this.a).onAdClicked(param1View, param1Int); 
              if (param1Int != 4 && param1Int != -1) {
                TTCountdownView tTCountdownView = e.c(this.a).getCountDownView();
                if (tTCountdownView != null) {
                  tTCountdownView.setCountdownListener(null);
                  if (!e.a(this.a)) {
                    param1Int = ab.d(e.b(this.a), "tt_splash_mute");
                    e.c(this.a).setVoiceViewImageResource(param1Int);
                    e e1 = this.a;
                    e.a(e1, e.a(e1) ^ true);
                  } 
                } 
                e.a(this.a, 0);
              } 
            }
            
            public void onAdShow(View param1View, int param1Int) {}
            
            public void onRenderFail(View param1View, String param1String, int param1Int) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onRenderFail:");
              stringBuilder.append(param1String);
              t.e("splash", stringBuilder.toString());
              if (e.f(this.a) != null)
                e.f(this.a).onRenderFail(param1View, param1String, param1Int); 
            }
            
            public void onRenderSuccess(View param1View, float param1Float1, float param1Float2) {
              if (param1View != null && param1Float1 > 0.0F) {
                if (param1Float2 <= 0.0F)
                  return; 
                if (e.g(this.a).get())
                  return; 
                e.c(this.a).setExpressView(e.h(this.a));
                if (e.f(this.a) != null)
                  e.f(this.a).onRenderSuccess(param1View, param1Float1, param1Float2); 
                e.i(this.a).set(true);
              } 
            }
          });
    } 
  }
  
  private void e() {
    if (this.d.z() != null) {
      if (this.k != null) {
        this.p = 1;
      } else {
        this.p = 2;
      } 
    } else {
      this.p = 0;
    } 
    this.i = a(this.d);
    EmptyView emptyView = new EmptyView(this.c, (View)this.e);
    emptyView.setAdType(3);
    this.e.addView((View)emptyView);
    a a2 = this.i;
    if (a2 != null)
      a2.a((View)emptyView); 
    emptyView.setCallback(new EmptyView.a(this) {
          public void a() {
            e.g(this.a).set(true);
            if (e.j(this.a) != null)
              e.j(this.a).a(); 
            if (e.j(this.a) != null && e.c(this.a) != null) {
              if (e.c(this.a).getParent() == null)
                return; 
              Context context = null;
              try {
                Context context1 = ((View)e.c(this.a).getParent()).getContext();
                context = context1;
              } catch (Exception exception) {}
              if (context != null && context instanceof Activity)
                e.j(this.a).a((Activity)context); 
            } 
          }
          
          public void a(View param1View) {
            e.g(this.a).set(true);
            e.a(this.a, System.currentTimeMillis());
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            if (e.k(this.a) != null)
              if (e.k(this.a).z() != null) {
                if (e.l(this.a) != null) {
                  hashMap.put("splash_show_type", Integer.valueOf(1));
                } else {
                  hashMap.put("splash_show_type", Integer.valueOf(2));
                } 
              } else {
                hashMap.put("splash_show_type", Integer.valueOf(0));
              }  
            if (e.i(this.a).get()) {
              hashMap.put("splash_show_type", Integer.valueOf(3));
              if (!this.a.a.getAndSet(true) && e.h(this.a) != null)
                ai.a(e.b(this.a), e.k(this.a), e.m(this.a), (WebView)e.h(this.a).getWebView()); 
            } 
            d.a(e.b(this.a), e.k(this.a), e.m(this.a), hashMap);
            if (!e.n(this.a) && e.c(this.a) != null) {
              TTCountdownView tTCountdownView = e.c(this.a).getCountDownView();
              if (tTCountdownView != null) {
                tTCountdownView.setCountdownListener(new TTCountdownView.a(this) {
                      public void a() {}
                      
                      public void b() {
                        if (e.e(this.a.a) != null)
                          e.e(this.a.a).onAdTimeOver(); 
                        try {
                          return;
                        } finally {
                          Exception exception = null;
                        } 
                      }
                    });
                tTCountdownView.a();
              } 
            } 
            if (e.e(this.a) != null)
              e.e(this.a).onAdShow((View)e.c(this.a), e.k(this.a).B()); 
            if (e.k(this.a).U())
              ah.a(e.k(this.a), param1View); 
            t.b("TTSplashAdImpl", "bindViewInteraction 开屏广告展示");
          }
          
          public void a(boolean param1Boolean) {
            if (e.j(this.a) != null) {
              if (param1Boolean) {
                e.j(this.a).b();
                return;
              } 
              e.j(this.a).c();
            } 
          }
          
          public void b() {
            (new Handler(Looper.getMainLooper())).postDelayed(new Runnable(this) {
                  public void run() {
                    if (e.j(this.a.a) != null)
                      e.j(this.a.a).d(); 
                  }
                },  1000L);
          }
        });
    emptyView.setNeedCheckingShow(true);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("splash_show_type", Integer.valueOf(this.p));
    a a1 = new a(this.c, this.d, this.r, 4);
    a1.a(hashMap);
    a1.a((View)this.e);
    a1.b(this.e.getDislikeView());
    a1.a(this.i);
    a1.a(new b.a(this) {
          public void a(View param1View, int param1Int) {
            if (e.e(this.a) != null)
              e.e(this.a).onAdClicked(param1View, param1Int); 
            if (param1Int != 4 && param1Int != -1) {
              TTCountdownView tTCountdownView = e.c(this.a).getCountDownView();
              if (tTCountdownView != null) {
                tTCountdownView.setCountdownListener(null);
                if (e.d(this.a) != null && !e.a(this.a)) {
                  param1Int = ab.d(e.b(this.a), "tt_splash_mute");
                  e.c(this.a).setVoiceViewImageResource(param1Int);
                  e e1 = this.a;
                  e.a(e1, e.a(e1) ^ true);
                  e.d(this.a).c(true);
                } 
              } 
              e.a(this.a, 0);
            } 
          }
        });
    this.e.setOnClickListenerInternal((View.OnClickListener)a1);
    this.e.setOnTouchListenerInternal((View.OnTouchListener)a1);
    this.e.setSkipListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (e.k(this.a) != null && e.k(this.a).z() != null && e.o(this.a) && e.d(this.a) != null) {
              e.d(this.a).l();
              if (!e.i(this.a).get()) {
                e e1 = this.a;
                e.a(e1, e.m(e1), "feed_break");
              } 
            } 
            if (!TextUtils.isEmpty(e.k(this.a).P())) {
              long l2 = e.p(this.a);
              long l1 = 0L;
              if (l2 > 0L)
                l1 = System.currentTimeMillis() - e.p(this.a); 
              d.a(e.b(this.a), l1, e.k(this.a));
            } 
            if (e.e(this.a) != null) {
              e.a(this.a, 0);
              e.e(this.a).onAdSkip();
            } 
          }
        });
  }
  
  void a(byte[] paramArrayOfbyte) {
    if (b(paramArrayOfbyte)) {
      this.e.setGifView(paramArrayOfbyte);
      return;
    } 
    if (this.d.F() != null && this.d.F().get(0) != null) {
      Drawable drawable = n.a(paramArrayOfbyte, ((j)this.d.F().get(0)).b());
      this.e.setDrawable(drawable);
    } 
  }
  
  public boolean a() {
    k k1 = this.d;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (k1 != null) {
      bool1 = bool2;
      if (k1.x() != null)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public int getInteractionType() {
    k k1 = this.d;
    return (k1 == null) ? -1 : k1.B();
  }
  
  public Map<String, Object> getMediaExtraInfo() {
    k k1 = this.d;
    return (k1 != null) ? k1.X() : null;
  }
  
  public View getSplashView() {
    k k1 = this.d;
    return (View)((k1 != null && k1.z() != null && this.e.getVideoContainer() != null && this.k != null && !c()) ? null : this.e);
  }
  
  public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener paramExpressAdInteractionListener) {
    if (paramExpressAdInteractionListener != null) {
      NativeExpressView nativeExpressView = this.q;
      if (nativeExpressView == null)
        return; 
      this.t = paramExpressAdInteractionListener;
      nativeExpressView.h();
    } 
  }
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
    a a1 = this.i;
    if (a1 != null)
      a1.a(paramTTAppDownloadListener); 
  }
  
  public void setNotAllowSdkCountdown() {
    this.g = true;
    TsView tsView = this.e;
    if (tsView != null)
      tsView.setSkipIconVisibility(8); 
  }
  
  public void setSplashInteractionListener(TTSplashAd.AdInteractionListener paramAdInteractionListener) {
    this.f = paramAdInteractionListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\splash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */