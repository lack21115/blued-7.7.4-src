package com.qq.e.ads.splash;

import com.qq.e.comm.util.AdError;

public interface SplashADListener {
  void onADClicked();
  
  void onADDismissed();
  
  void onADExposure();
  
  void onADLoaded(long paramLong);
  
  void onADPresent();
  
  void onADTick(long paramLong);
  
  void onNoAD(AdError paramAdError);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\splash\SplashADListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */