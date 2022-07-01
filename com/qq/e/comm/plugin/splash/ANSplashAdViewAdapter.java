package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.mediation.interfaces.BaseSplashAd;

class ANSplashAdViewAdapter extends BaseSplashAd implements a {
  private b mSplashAdView;
  
  public ANSplashAdViewAdapter(Context paramContext, String paramString1, String paramString2) {
    super(paramContext, paramString1, paramString2);
    this.mSplashAdView = new b(paramContext, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString1, l.b);
  }
  
  public void fetchAdOnly() {
    this.mSplashAdView.fetchAdOnly();
  }
  
  public void fetchAndShowIn(ViewGroup paramViewGroup) {
    this.mSplashAdView.fetchAndShowIn(paramViewGroup);
  }
  
  public int getAdapterPriority() {
    return this.mSplashAdView.g();
  }
  
  public int getECPM() {
    return this.mSplashAdView.h();
  }
  
  public String getECPMLevel() {
    return this.mSplashAdView.getECPMLevel();
  }
  
  public int getMediationPrice() {
    return this.mSplashAdView.i();
  }
  
  public boolean isContractAd() {
    return this.mSplashAdView.j();
  }
  
  public void preload() {
    this.mSplashAdView.preload();
  }
  
  public void setAdListener(ADListener paramADListener) {
    this.mSplashAdView.setAdListener(paramADListener);
  }
  
  public void setFetchDelay(int paramInt) {
    this.mSplashAdView.setFetchDelay(paramInt);
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    this.mSplashAdView.setLoadAdParams(paramLoadAdParams);
  }
  
  public void setSkipView(View paramView) {
    this.mSplashAdView.setSkipView(paramView);
  }
  
  public void showAd(ViewGroup paramViewGroup) {
    this.mSplashAdView.showAd(paramViewGroup);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\ANSplashAdViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */