package com.baidu.mobads;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.production.g.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class u implements XAdView.Listener {
  u(SplashAd paramSplashAd, Context paramContext, XAdView paramXAdView, String paramString, boolean paramBoolean, int paramInt, RequestParameters paramRequestParameters) {}
  
  public void onAttachedToWindow() {
    if (SplashAd.b(this.g) != null)
      SplashAd.b(this.g).p(); 
  }
  
  public void onDetachedFromWindow() {
    if (SplashAd.b(this.g) != null)
      SplashAd.b(this.g).q(); 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return false;
  }
  
  public void onLayoutComplete(int paramInt1, int paramInt2) {
    if (SplashAd.b(this.g) != null)
      return; 
    float f = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.a);
    if (paramInt1 < 200.0F * f || paramInt2 < f * 150.0F) {
      String str = XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp");
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(str);
      SplashAd.a(this.g).onAdDismissed();
      return;
    } 
    SplashAd splashAd = this.g;
    SplashAd.a(splashAd, new a(this.a, (RelativeLayout)this.b, this.c, this.d, paramInt1, paramInt2, SplashAd.e(splashAd), this.e));
    if (this.f != null)
      SplashAd.b(this.g).a(this.f); 
    SplashAd.b(this.g).addEventListener("AdUserClick", SplashAd.d(this.g));
    SplashAd.b(this.g).addEventListener("AdLoaded", SplashAd.d(this.g));
    SplashAd.b(this.g).addEventListener("AdStarted", SplashAd.d(this.g));
    SplashAd.b(this.g).addEventListener("AdStopped", SplashAd.d(this.g));
    SplashAd.b(this.g).addEventListener("AdError", SplashAd.d(this.g));
    SplashAd.b(this.g).request();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    if (SplashAd.b(this.g) != null)
      SplashAd.b(this.g).a(paramBoolean); 
  }
  
  public void onWindowVisibilityChanged(int paramInt) {
    if (SplashAd.b(this.g) != null)
      SplashAd.b(this.g).b(paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */