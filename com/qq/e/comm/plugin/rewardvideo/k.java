package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class k extends a<BaseRewardAd> implements RVADI {
  ADListener d;
  
  BaseRewardAd e;
  
  Map<BaseRewardAd, a> f = new HashMap<BaseRewardAd, a>();
  
  boolean g = true;
  
  LoadAdParams h = null;
  
  public k(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    super(paramContext, paramString2);
    this.d = paramADListener;
  }
  
  protected int a(BaseRewardAd paramBaseRewardAd) {
    a a1 = new a(new a.a(this, paramBaseRewardAd, System.currentTimeMillis()) {
          public void a() {
            if (k.e(this.c))
              return; 
            long l = System.currentTimeMillis();
            k.b(this.c, this.a, l - this.b, false, 70222);
            if (k.f(this.c) && k.b(this.c, this.a) && !k.g(this.c))
              this.c.a(); 
          }
          
          public boolean a(ADEvent param1ADEvent) {
            int i;
            boolean bool = k.a(this.c);
            boolean bool1 = false;
            if (bool)
              return false; 
            long l = System.currentTimeMillis();
            int j = this.a.getECPM();
            BaseRewardAd baseRewardAd1 = this.a;
            if (baseRewardAd1 instanceof com.qq.e.comm.plugin.r.a) {
              i = j;
              if (j <= 0)
                i = ((com.qq.e.comm.plugin.r.a)baseRewardAd1).getMediationPrice(); 
              bool = ((com.qq.e.comm.plugin.r.a)this.a).isContractAd();
            } else {
              bool = false;
              i = j;
            } 
            k k1 = this.c;
            BaseRewardAd baseRewardAd2 = this.a;
            k.a(k1, baseRewardAd2, i, bool, baseRewardAd2.getAdapterPriority());
            k.a(this.c, this.a, l - this.b, true, 70212);
            bool = bool1;
            if (k.b(this.c)) {
              bool = bool1;
              if (k.a(this.c, this.a)) {
                bool = bool1;
                if (!k.c(this.c)) {
                  k.d(this.c);
                  this.c.e = this.a;
                  bool = true;
                } 
              } 
            } 
            return bool;
          }
          
          public void b() {
            k.a(this.c, this.a, 70242);
          }
          
          public void b(ADEvent param1ADEvent) {
            if (this.c.d != null && k.c(this.c, this.a))
              this.c.d.onADEvent(param1ADEvent); 
          }
          
          public void c() {
            k.b(this.c, this.a, 70232);
          }
        });
    paramBaseRewardAd.setAdListener(a1);
    if (SDKStatus.getSDKVersionCode() >= 80)
      paramBaseRewardAd.setVolumOn(this.g); 
    if (SDKStatus.getSDKVersionCode() >= 120)
      paramBaseRewardAd.setLoadAdParams(this.h); 
    this.f.put(paramBaseRewardAd, a1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBaseRewardAd.getClass().getSimpleName());
    stringBuilder.append(" load Ad");
    GDTLogger.d(stringBuilder.toString());
    paramBaseRewardAd.loadAD();
    return 70202;
  }
  
  protected BaseRewardAd a(c paramc) {
    if (paramc != null)
      try {
        return a.a(paramc.e(), this.b, paramc.b(), paramc.g());
      } catch (Exception exception) {
        a(70252, paramc);
        exception.printStackTrace();
      }  
    return null;
  }
  
  public void a() {
    ADListener aDListener = this.d;
    if (aDListener != null)
      aDListener.onADEvent(new ADEvent(9, new Object[] { Integer.valueOf(501) })); 
  }
  
  protected void b(BaseRewardAd paramBaseRewardAd) {
    this.e = paramBaseRewardAd;
    paramBaseRewardAd = this.e;
    if (paramBaseRewardAd != null) {
      if (this.d != null) {
        a a1 = this.f.get(paramBaseRewardAd);
        if (a1 != null) {
          a1.a();
          for (ADEvent aDEvent : a1.b())
            this.d.onADEvent(aDEvent); 
        } 
      } 
    } else {
      a();
    } 
  }
  
  public String getAdNetWorkName() {
    return k();
  }
  
  public int getECPM() {
    BaseRewardAd baseRewardAd = this.e;
    return (baseRewardAd != null) ? baseRewardAd.getECPM() : -1;
  }
  
  public String getECPMLevel() {
    BaseRewardAd baseRewardAd = this.e;
    return (baseRewardAd != null) ? baseRewardAd.getECPMLevel() : null;
  }
  
  public long getExpireTimestamp() {
    BaseRewardAd baseRewardAd = this.e;
    return (baseRewardAd != null) ? baseRewardAd.getExpireTimestamp() : 0L;
  }
  
  public int getRewardAdType() {
    BaseRewardAd baseRewardAd = this.e;
    return (baseRewardAd != null) ? baseRewardAd.getRewardAdType() : 0;
  }
  
  public int getVideoDuration() {
    BaseRewardAd baseRewardAd = this.e;
    return (baseRewardAd != null) ? baseRewardAd.getVideoDuration() : 0;
  }
  
  public boolean hasShown() {
    BaseRewardAd baseRewardAd = this.e;
    return (baseRewardAd != null) ? baseRewardAd.hasShown() : false;
  }
  
  public void loadAD() {
    c();
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    this.h = paramLoadAdParams;
  }
  
  public void setVolumeOn(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void showAD() {
    BaseRewardAd baseRewardAd = this.e;
    if (baseRewardAd != null)
      baseRewardAd.showAD(); 
  }
  
  public void showAD(Activity paramActivity) {
    if (this.e != null) {
      if (SDKStatus.getSDKVersionCode() >= 100) {
        this.e.showAD(paramActivity);
        return;
      } 
      GDTLogger.e("showAD(Activity activity) is not support in current SDK version, please upgrade");
    } 
  }
  
  static class a implements ADListener {
    a.a a;
    
    k.a$a b = k.a$a.c;
    
    int c = 0;
    
    Queue<ADEvent> d = new LinkedList<ADEvent>();
    
    a(a.a param1a) {
      this.a = param1a;
    }
    
    private void a(ADEvent param1ADEvent) {
      if (this.c > 0) {
        a.a a1 = this.a;
        if (a1 != null) {
          a1.b(param1ADEvent);
          return;
        } 
      } 
      this.d.offer(param1ADEvent);
    }
    
    void a() {
      this.c |= 0x2;
    }
    
    public Queue<ADEvent> b() {
      return this.d;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      a.a a1;
      int i = param1ADEvent.getType();
      if (i != 1) {
        if (i != 4 && i != 6) {
          if (i != 9)
            a(param1ADEvent); 
          if (this.b == k.a$a.c) {
            this.b = k.a$a.b;
            a1 = this.a;
            if (a1 != null) {
              a1.a();
              return;
            } 
          } else if (this.b == k.a$a.a) {
            a((ADEvent)a1);
          } 
        } else {
          if (this.a != null)
            if (a1.getType() == 4) {
              this.a.c();
            } else {
              this.a.b();
            }  
          a((ADEvent)a1);
        } 
      } else {
        a.a a2 = this.a;
        if (a2 != null) {
          if (a2.a(null))
            this.c |= 0x1; 
          if (this.c > 0)
            this.a.b((ADEvent)a1); 
        } 
        this.b = k.a$a.a;
        this.d.offer(a1);
      } 
    }
    
    enum a$a {
      a, b, c;
    }
  }
  
  enum a$a {
    a, b, c;
  }
  
  enum a$a {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */