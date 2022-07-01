package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

public interface UnifiedInterstitialADListener {
  void onADClicked();
  
  void onADClosed();
  
  void onADExposure();
  
  void onADLeftApplication();
  
  void onADOpened();
  
  void onADReceive();
  
  void onNoAD(AdError paramAdError);
  
  void onVideoCached();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\interstitial2\UnifiedInterstitialADListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */