package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.util.AdError;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.util.HashSet;
import java.util.Set;

class e extends a<BaseInterstitialAd> implements UIADI {
  private UnifiedInterstitialADListener d;
  
  private BaseInterstitialAd e;
  
  private Activity f;
  
  private boolean g;
  
  private DownAPPConfirmPolicy h = null;
  
  private VideoOption i = null;
  
  private int j = -1;
  
  private int k = -1;
  
  private int l = -1;
  
  private UnifiedInterstitialMediaListener m;
  
  private Set<BaseInterstitialAd> n = new HashSet<BaseInterstitialAd>();
  
  private af o = new af();
  
  public e(Activity paramActivity, String paramString1, String paramString2, UnifiedInterstitialADListener paramUnifiedInterstitialADListener) {
    super((Context)paramActivity, paramString2);
    this.d = paramUnifiedInterstitialADListener;
    this.f = paramActivity;
  }
  
  private void l() {
    UnifiedInterstitialADListener unifiedInterstitialADListener = this.d;
    if (unifiedInterstitialADListener != null)
      unifiedInterstitialADListener.onADReceive(); 
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.setMediaListener(this.m); 
  }
  
  protected int a(BaseInterstitialAd paramBaseInterstitialAd) {
    paramBaseInterstitialAd.setAdListener(new UnifiedInterstitialADListener(this, paramBaseInterstitialAd, System.currentTimeMillis()) {
          public void onADClicked() {
            if (this.a == e.e(this.c) && e.f(this.c) != null) {
              e.b(this.c, this.a, 70442);
              e.f(this.c).onADClicked();
            } 
          }
          
          public void onADClosed() {
            e.j(this.c).a();
            if (this.a == e.e(this.c) && e.f(this.c) != null)
              e.f(this.c).onADClosed(); 
          }
          
          public void onADExposure() {
            if (this.a == e.e(this.c) && e.f(this.c) != null) {
              e.a(this.c, this.a, 70432);
              e.f(this.c).onADExposure();
            } 
          }
          
          public void onADLeftApplication() {
            if (this.a == e.e(this.c) && e.f(this.c) != null)
              e.f(this.c).onADLeftApplication(); 
          }
          
          public void onADOpened() {
            if (this.a == e.e(this.c) && e.f(this.c) != null)
              e.f(this.c).onADOpened(); 
          }
          
          public void onADReceive() {
            int i;
            boolean bool;
            long l = System.currentTimeMillis();
            int j = this.a.getECPM();
            BaseInterstitialAd baseInterstitialAd1 = this.a;
            if (baseInterstitialAd1 instanceof a) {
              i = j;
              if (j <= 0)
                i = ((a)baseInterstitialAd1).getMediationPrice(); 
              bool = ((a)this.a).isContractAd();
            } else {
              bool = false;
              i = j;
            } 
            e e1 = this.c;
            BaseInterstitialAd baseInterstitialAd2 = this.a;
            e.a(e1, baseInterstitialAd2, i, bool, baseInterstitialAd2.getAdapterPriority());
            e.a(this.c, this.a, l - this.b, true, 70412);
            if (e.a(this.c) && e.a(this.c, this.a) && !e.b(this.c)) {
              e.c(this.c);
              e.a(this.c, this.a);
              e.d(this.c);
            } 
            e.a(this.c, false);
          }
          
          public void onNoAD(AdError param1AdError) {
            long l = System.currentTimeMillis();
            e.b(this.c, this.a, l - this.b, false, 70422);
            if (e.h(this.c) && e.b(this.c, this.a) && !e.i(this.c))
              this.c.a(); 
          }
          
          public void onVideoCached() {
            if (this.a == e.e(this.c) && e.f(this.c) != null)
              e.f(this.c).onVideoCached(); 
            e.g(this.c).add(this.a);
          }
        });
    VideoOption videoOption = this.i;
    if (videoOption != null)
      paramBaseInterstitialAd.setVideoOption(videoOption); 
    int i = this.l;
    if (i >= 0)
      paramBaseInterstitialAd.setVideoPlayPolicy(i); 
    i = this.j;
    if (i > 0)
      paramBaseInterstitialAd.setMinVideoDuration(i); 
    i = this.k;
    if (i > 0)
      paramBaseInterstitialAd.setMaxVideoDuration(i); 
    DownAPPConfirmPolicy downAPPConfirmPolicy = this.h;
    if (downAPPConfirmPolicy != null)
      paramBaseInterstitialAd.setDownAPPConfirmPolicy(downAPPConfirmPolicy); 
    paramBaseInterstitialAd.loadAd();
    return 70402;
  }
  
  protected BaseInterstitialAd a(c paramc) {
    if (paramc != null)
      try {
        return b.a(paramc.e(), this.f, paramc.b(), paramc.g());
      } catch (Exception exception) {
        a(70452, paramc);
        exception.printStackTrace();
      }  
    return null;
  }
  
  public void a() {
    UnifiedInterstitialADListener unifiedInterstitialADListener = this.d;
    if (unifiedInterstitialADListener != null)
      unifiedInterstitialADListener.onNoAD(new AdError(5004, "No AD")); 
  }
  
  protected void b(BaseInterstitialAd paramBaseInterstitialAd) {
    this.e = paramBaseInterstitialAd;
    if (this.e != null) {
      l();
      if (this.n.contains(this.e)) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.d;
        if (unifiedInterstitialADListener != null) {
          unifiedInterstitialADListener.onVideoCached();
          return;
        } 
      } 
    } else {
      a();
    } 
  }
  
  public void close() {
    this.o.a();
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.close(); 
  }
  
  public void destory() {
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.destory(); 
  }
  
  public String getAdNetWorkName() {
    return k();
  }
  
  public int getAdPatternType() {
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.getAdPatternType(); 
    return 0;
  }
  
  public int getECPM() {
    BaseInterstitialAd baseInterstitialAd = this.e;
    return (baseInterstitialAd != null) ? baseInterstitialAd.getECPM() : -1;
  }
  
  public String getECPMLevel() {
    BaseInterstitialAd baseInterstitialAd = this.e;
    return (baseInterstitialAd != null) ? baseInterstitialAd.getECPMLevel() : null;
  }
  
  public boolean isValid() {
    BaseInterstitialAd baseInterstitialAd = this.e;
    return (baseInterstitialAd != null) ? baseInterstitialAd.isValid() : false;
  }
  
  public void loadAd() {
    c();
  }
  
  public void loadFullScreenAD() {}
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    this.h = paramDownAPPConfirmPolicy;
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.k = paramInt;
  }
  
  public void setMediaListener(UnifiedInterstitialMediaListener paramUnifiedInterstitialMediaListener) {
    this.m = paramUnifiedInterstitialMediaListener;
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.setMediaListener(paramUnifiedInterstitialMediaListener); 
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.j = paramInt;
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    this.i = paramVideoOption;
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.l = paramInt;
  }
  
  public void show() {
    if (this.g)
      return; 
    this.o.a(this.f);
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.show(); 
    this.g = true;
  }
  
  public void show(Activity paramActivity) {
    if (this.g)
      return; 
    this.o.a(paramActivity);
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.show(paramActivity); 
    this.g = true;
  }
  
  public void showAsPopupWindow() {
    if (this.g)
      return; 
    this.o.a(this.f);
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.showAsPopupWindow(); 
    this.g = true;
  }
  
  public void showAsPopupWindow(Activity paramActivity) {
    if (this.g)
      return; 
    this.o.a(paramActivity);
    BaseInterstitialAd baseInterstitialAd = this.e;
    if (baseInterstitialAd != null)
      baseInterstitialAd.showAsPopupWindow(paramActivity); 
    this.g = true;
  }
  
  public void showFullScreenAD(Activity paramActivity) {
    this.o.a(paramActivity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */