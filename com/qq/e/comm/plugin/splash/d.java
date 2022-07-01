package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseSplashAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class d extends a<BaseSplashAd> implements NSPVI {
  private ViewGroup d;
  
  private View e;
  
  private int f = -1;
  
  private LoadAdParams g;
  
  private ADListener h;
  
  private BaseSplashAd i;
  
  private Map<BaseSplashAd, a> j = new HashMap<BaseSplashAd, a>();
  
  public d(Context paramContext, String paramString1, String paramString2) {
    super(paramContext, paramString2);
  }
  
  protected int a(BaseSplashAd paramBaseSplashAd) {
    a a1 = new a(new a.a(this, paramBaseSplashAd, System.currentTimeMillis()) {
          public void a() {
            if (d.e(this.c))
              return; 
            long l = System.currentTimeMillis();
            d.b(this.c, this.a, l - this.b, false, 70122);
            if (d.f(this.c) && d.b(this.c, this.a) && !d.g(this.c))
              this.c.a(); 
          }
          
          public boolean a(ADEvent param1ADEvent) {
            boolean bool = d.a(this.c);
            boolean bool1 = false;
            if (bool)
              return false; 
            long l = System.currentTimeMillis();
            int i = -1;
            if (SDKStatus.getSDKVersionCode() >= 100)
              i = this.a.getECPM(); 
            BaseSplashAd baseSplashAd1 = this.a;
            if (baseSplashAd1 instanceof com.qq.e.comm.plugin.r.a) {
              int j = i;
              if (i <= 0)
                j = ((com.qq.e.comm.plugin.r.a)baseSplashAd1).getMediationPrice(); 
              bool = ((com.qq.e.comm.plugin.r.a)this.a).isContractAd();
              i = j;
            } else {
              bool = false;
            } 
            d d1 = this.c;
            BaseSplashAd baseSplashAd2 = this.a;
            d.a(d1, baseSplashAd2, i, bool, baseSplashAd2.getAdapterPriority());
            d.a(this.c, this.a, l - this.b, true, 70112);
            bool = bool1;
            if (d.b(this.c)) {
              bool = bool1;
              if (d.a(this.c, this.a)) {
                bool = bool1;
                if (!d.c(this.c)) {
                  d.d(this.c);
                  d.a(this.c, this.a);
                  bool = true;
                } 
              } 
            } 
            return bool;
          }
          
          public void b() {
            d.a(this.c, this.a, 70142);
          }
          
          public void b(ADEvent param1ADEvent) {
            if (d.h(this.c) != null && d.c(this.c, this.a))
              d.h(this.c).onADEvent(param1ADEvent); 
          }
          
          public void c() {
            d.b(this.c, this.a, 70132);
          }
        });
    paramBaseSplashAd.setAdListener(a1);
    this.j.put(paramBaseSplashAd, a1);
    int i = this.f;
    if (i > 0)
      paramBaseSplashAd.setFetchDelay(i); 
    View view = this.e;
    if (view != null)
      paramBaseSplashAd.setSkipView(view); 
    LoadAdParams loadAdParams = this.g;
    if (loadAdParams != null)
      paramBaseSplashAd.setLoadAdParams(loadAdParams); 
    ViewGroup viewGroup = this.d;
    if (viewGroup == null) {
      paramBaseSplashAd.fetchAdOnly();
    } else {
      paramBaseSplashAd.fetchAndShowIn(viewGroup);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBaseSplashAd.getClass().getSimpleName());
    stringBuilder.append(" load Ad");
    GDTLogger.d(stringBuilder.toString());
    return 70102;
  }
  
  protected BaseSplashAd a(c paramc) {
    if (paramc != null)
      try {
        return a.a(paramc.e(), this.a, paramc.b(), paramc.g());
      } catch (Exception exception) {
        a(70152, paramc);
        exception.printStackTrace();
      }  
    return null;
  }
  
  public void a() {
    if (this.h != null)
      this.c.post(new Runnable(this) {
            public void run() {
              d.h(this.a).onADEvent(new ADEvent(2, new Object[] { Integer.valueOf(501) }));
            }
          }); 
  }
  
  protected void b(BaseSplashAd paramBaseSplashAd) {
    this.i = paramBaseSplashAd;
    paramBaseSplashAd = this.i;
    if (paramBaseSplashAd != null) {
      if (this.h != null) {
        a a1 = this.j.get(paramBaseSplashAd);
        if (a1 != null) {
          a1.a();
          for (ADEvent aDEvent : a1.b())
            this.h.onADEvent(aDEvent); 
        } 
      } 
    } else {
      a();
    } 
  }
  
  public void fetchAdOnly() {
    c();
  }
  
  public void fetchAndShowIn(ViewGroup paramViewGroup) {
    if (!i()) {
      GDTLogger.e("SplashAdViewMediator fetchAndShowIn 不支持并行拉取");
      a();
      return;
    } 
    this.d = paramViewGroup;
    c();
  }
  
  public String getAdNetWorkName() {
    return k();
  }
  
  public String getECPMLevel() {
    BaseSplashAd baseSplashAd = this.i;
    return (baseSplashAd != null) ? baseSplashAd.getECPMLevel() : "";
  }
  
  public void preload() {}
  
  public void setAdListener(ADListener paramADListener) {
    this.h = paramADListener;
  }
  
  public void setAdLogoMargin(int paramInt1, int paramInt2) {}
  
  public void setFetchDelay(int paramInt) {
    this.f = paramInt;
    a(paramInt);
  }
  
  public void setFloatView(View paramView) {}
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    this.g = paramLoadAdParams;
  }
  
  public void setPreloadView(View paramView) {}
  
  public void setSkipView(View paramView) {
    this.e = paramView;
  }
  
  public void showAd(ViewGroup paramViewGroup) {
    this.d = paramViewGroup;
    BaseSplashAd baseSplashAd = this.i;
    if (baseSplashAd != null) {
      baseSplashAd.showAd(paramViewGroup);
      return;
    } 
    a();
  }
  
  static class a implements ADListener {
    a.a a;
    
    boolean b;
    
    boolean c;
    
    boolean d = false;
    
    Queue<ADEvent> e = new LinkedList<ADEvent>();
    
    public a(a.a param1a) {
      this.a = param1a;
    }
    
    void a() {
      this.d = true;
    }
    
    public Queue<ADEvent> b() {
      return this.e;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SplashAdViewMediator type--");
      stringBuilder.append(param1ADEvent.getType());
      GDTLogger.d(stringBuilder.toString());
      int i = param1ADEvent.getType();
      if (i != 2) {
        if (i != 4) {
          if (i != 6) {
            if (i == 7) {
              this.b = true;
              a.a a1 = this.a;
              if (a1 != null) {
                if (a1.a(param1ADEvent))
                  this.d = true; 
                if (this.d)
                  this.a.b(param1ADEvent); 
              } 
              this.e.offer(param1ADEvent);
              return;
            } 
          } else {
            a.a a1 = this.a;
            if (a1 != null) {
              a1.b(param1ADEvent);
              this.a.c();
              return;
            } 
            return;
          } 
        } else {
          a.a a1 = this.a;
          if (a1 != null)
            a1.b(); 
        } 
        if (this.b) {
          a.a a1 = this.a;
          if (a1 != null) {
            a1.b(param1ADEvent);
            return;
          } 
        } 
      } else {
        this.e.offer(param1ADEvent);
        a.a a1 = this.a;
        if (a1 != null && !this.c) {
          this.c = true;
          a1.a();
        } 
        a1 = this.a;
        if (a1 != null && this.b) {
          a1.b(param1ADEvent);
          return;
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */