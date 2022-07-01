package com.qq.e.ads.rewardvideo2;

import com.qq.e.comm.util.AdError;

public interface ExpressRewardVideoAdListener {
  void onAdLoaded();
  
  void onClick();
  
  void onClose();
  
  void onError(AdError paramAdError);
  
  void onExpose();
  
  void onReward();
  
  void onShow();
  
  void onVideoCached();
  
  void onVideoComplete();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\rewardvideo2\ExpressRewardVideoAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */