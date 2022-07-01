package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.comm.util.AdError;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;

class ANInterstitialAdAdapter extends BaseInterstitialAd implements a {
  private UnifiedInterstitialADListener mListener;
  
  private d unifiedInterstitialADDelegate;
  
  public ANInterstitialAdAdapter(Activity paramActivity, String paramString1, String paramString2) {
    super(paramActivity, paramString1, paramString2);
    this.unifiedInterstitialADDelegate = new d(paramActivity, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString1, l.b, new UnifiedInterstitialADListener(this) {
          public void onADClicked() {
            if (this.a.mListener != null)
              this.a.mListener.onADClicked(); 
          }
          
          public void onADClosed() {
            if (this.a.mListener != null)
              this.a.mListener.onADClosed(); 
          }
          
          public void onADExposure() {
            if (this.a.mListener != null)
              this.a.mListener.onADExposure(); 
          }
          
          public void onADLeftApplication() {
            if (this.a.mListener != null)
              this.a.mListener.onADLeftApplication(); 
          }
          
          public void onADOpened() {
            if (this.a.mListener != null)
              this.a.mListener.onADOpened(); 
          }
          
          public void onADReceive() {
            if (this.a.mListener != null)
              this.a.mListener.onADReceive(); 
          }
          
          public void onNoAD(AdError param1AdError) {
            if (this.a.mListener != null)
              this.a.mListener.onNoAD(param1AdError); 
          }
          
          public void onVideoCached() {
            if (this.a.mListener != null)
              this.a.mListener.onVideoCached(); 
          }
        });
  }
  
  public void close() {
    d d1 = this.unifiedInterstitialADDelegate;
    if (d1 != null)
      d1.close(); 
  }
  
  public void destory() {
    d d1 = this.unifiedInterstitialADDelegate;
    if (d1 != null)
      d1.destory(); 
  }
  
  public int getAdPatternType() {
    return this.unifiedInterstitialADDelegate.getAdPatternType();
  }
  
  public int getAdapterPriority() {
    return this.unifiedInterstitialADDelegate.a();
  }
  
  public int getECPM() {
    return this.unifiedInterstitialADDelegate.getECPM();
  }
  
  public String getECPMLevel() {
    return this.unifiedInterstitialADDelegate.getECPMLevel();
  }
  
  public int getMediationPrice() {
    return this.unifiedInterstitialADDelegate.getMediationPrice();
  }
  
  public boolean isContractAd() {
    return this.unifiedInterstitialADDelegate.isContractAd();
  }
  
  public boolean isValid() {
    return this.unifiedInterstitialADDelegate.isValid();
  }
  
  public void loadAd() {
    d d1 = this.unifiedInterstitialADDelegate;
    if (d1 != null)
      d1.loadAd(); 
  }
  
  public void setAdListener(UnifiedInterstitialADListener paramUnifiedInterstitialADListener) {
    this.mListener = paramUnifiedInterstitialADListener;
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    d d1 = this.unifiedInterstitialADDelegate;
    if (d1 != null)
      d1.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy); 
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.unifiedInterstitialADDelegate.setMaxVideoDuration(paramInt);
  }
  
  public void setMediaListener(UnifiedInterstitialMediaListener paramUnifiedInterstitialMediaListener) {
    this.unifiedInterstitialADDelegate.setMediaListener(paramUnifiedInterstitialMediaListener);
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.unifiedInterstitialADDelegate.setMinVideoDuration(paramInt);
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    this.unifiedInterstitialADDelegate.setVideoOption(paramVideoOption);
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.unifiedInterstitialADDelegate.setVideoPlayPolicy(paramInt);
  }
  
  public void show() {
    d d1 = this.unifiedInterstitialADDelegate;
    if (d1 != null)
      d1.show(); 
  }
  
  public void show(Activity paramActivity) {
    d d1 = this.unifiedInterstitialADDelegate;
    if (d1 != null)
      d1.show(paramActivity); 
  }
  
  public void showAsPopupWindow() {
    d d1 = this.unifiedInterstitialADDelegate;
    if (d1 != null)
      d1.showAsPopupWindow(); 
  }
  
  public void showAsPopupWindow(Activity paramActivity) {
    d d1 = this.unifiedInterstitialADDelegate;
    if (d1 != null)
      d1.showAsPopupWindow(paramActivity); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\ANInterstitialAdAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */