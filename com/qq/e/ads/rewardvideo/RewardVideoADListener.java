package com.qq.e.ads.rewardvideo;

import com.qq.e.comm.util.AdError;

public interface RewardVideoADListener {
  void onADClick();
  
  void onADClose();
  
  void onADExpose();
  
  void onADLoad();
  
  void onADShow();
  
  void onError(AdError paramAdError);
  
  void onReward();
  
  void onVideoCached();
  
  void onVideoComplete();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\rewardvideo\RewardVideoADListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */