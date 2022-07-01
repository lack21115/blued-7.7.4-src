package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

public interface UnifiedInterstitialMediaListener {
  void onVideoComplete();
  
  void onVideoError(AdError paramAdError);
  
  void onVideoInit();
  
  void onVideoLoading();
  
  void onVideoPageClose();
  
  void onVideoPageOpen();
  
  void onVideoPause();
  
  void onVideoReady(long paramLong);
  
  void onVideoStart();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\interstitial2\UnifiedInterstitialMediaListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */