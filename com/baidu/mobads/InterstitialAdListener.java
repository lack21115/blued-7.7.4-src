package com.baidu.mobads;

public interface InterstitialAdListener {
  void onAdClick(InterstitialAd paramInterstitialAd);
  
  void onAdDismissed();
  
  void onAdFailed(String paramString);
  
  void onAdPresent();
  
  void onAdReady();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\InterstitialAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */