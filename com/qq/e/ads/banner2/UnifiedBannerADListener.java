package com.qq.e.ads.banner2;

import com.qq.e.comm.util.AdError;

public interface UnifiedBannerADListener {
  void onADClicked();
  
  void onADCloseOverlay();
  
  void onADClosed();
  
  void onADExposure();
  
  void onADLeftApplication();
  
  void onADOpenOverlay();
  
  void onADReceive();
  
  void onNoAD(AdError paramAdError);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\banner2\UnifiedBannerADListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */