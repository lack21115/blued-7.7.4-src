package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

public interface NativeADMediaListener {
  void onVideoClicked();
  
  void onVideoCompleted();
  
  void onVideoError(AdError paramAdError);
  
  void onVideoInit();
  
  void onVideoLoaded(int paramInt);
  
  void onVideoLoading();
  
  void onVideoPause();
  
  void onVideoReady();
  
  void onVideoResume();
  
  void onVideoStart();
  
  void onVideoStop();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\NativeADMediaListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */