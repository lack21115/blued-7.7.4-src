package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import java.util.Map;

public interface TTRewardVideoAd {
  int getInteractionType();
  
  Map<String, Object> getMediaExtraInfo();
  
  int getRewardVideoAdType();
  
  void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  void setRewardAdInteractionListener(RewardAdInteractionListener paramRewardAdInteractionListener);
  
  void setShowDownLoadBar(boolean paramBoolean);
  
  void showRewardVideoAd(Activity paramActivity);
  
  void showRewardVideoAd(Activity paramActivity, TTAdConstant.RitScenes paramRitScenes, String paramString);
  
  public static interface RewardAdInteractionListener {
    void onAdClose();
    
    void onAdShow();
    
    void onAdVideoBarClick();
    
    void onRewardVerify(boolean param1Boolean, int param1Int, String param1String);
    
    void onSkippedVideo();
    
    void onVideoComplete();
    
    void onVideoError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTRewardVideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */