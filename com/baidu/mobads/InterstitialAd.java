package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.e.b;
import com.baidu.mobads.production.f.a;
import com.baidu.mobads.production.f.b;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class InterstitialAd {
  public static final String TAG = InterstitialAd.class.getSimpleName();
  
  IOAdEventListener a = new n(this);
  
  private AdSize b;
  
  private a c;
  
  private final IXAdLogger d = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  private InterstitialAdListener e = new m(this);
  
  public InterstitialAd(Context paramContext, AdSize paramAdSize, String paramString) {
    XAdView xAdView = new XAdView(paramContext);
    xAdView.setListener(new p(this));
    this.b = paramAdSize;
    boolean bool = a();
    Boolean bool1 = Boolean.valueOf(true);
    if (bool) {
      this.c = (a)new b(paramContext, (RelativeLayout)xAdView, bool1, paramString);
    } else if (b()) {
      this.c = (a)new b(paramContext, (RelativeLayout)xAdView, bool1, paramAdSize, paramString);
    } 
    this.c.addEventListener("AdLoaded", this.a);
    this.c.addEventListener("AdError", this.a);
    this.c.addEventListener("AdStopped", this.a);
    this.c.addEventListener("AdUserClose", this.a);
    this.c.addEventListener("AdStarted", this.a);
    this.c.addEventListener("AdUserClick", this.a);
    this.c.request();
  }
  
  public InterstitialAd(Context paramContext, String paramString) {
    this(paramContext, AdSize.InterstitialGame, paramString);
  }
  
  private boolean a() {
    return (this.b.getValue() <= AdSize.InterstitialOther.getValue() && this.b.getValue() >= AdSize.InterstitialGame.getValue());
  }
  
  private boolean b() {
    return (this.b.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.b.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue());
  }
  
  @Deprecated
  public static void setAppSec(Context paramContext, String paramString) {}
  
  public static void setAppSid(Context paramContext, String paramString) {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(paramString);
  }
  
  public void destroy() {
    this.c.r();
  }
  
  public boolean isAdReady() {
    return this.c.w();
  }
  
  public void loadAd() {
    this.c.a();
  }
  
  public void loadAdForVideoApp(int paramInt1, int paramInt2) {
    this.c.a(paramInt1, paramInt2);
  }
  
  public void setListener(InterstitialAdListener paramInterstitialAdListener) {
    if (paramInterstitialAdListener != null) {
      this.e = paramInterstitialAdListener;
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  public void showAd(Activity paramActivity) {
    this.c.a(paramActivity);
  }
  
  public void showAdInParentForVideoApp(Activity paramActivity, RelativeLayout paramRelativeLayout) {
    if (paramActivity != null && paramRelativeLayout != null) {
      this.c.a(paramActivity, paramRelativeLayout);
      return;
    } 
    throw new IllegalArgumentException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */