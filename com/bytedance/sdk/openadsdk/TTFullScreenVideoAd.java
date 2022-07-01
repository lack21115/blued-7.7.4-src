package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import java.util.Map;

public interface TTFullScreenVideoAd {
  int getFullVideoAdType();
  
  int getInteractionType();
  
  Map<String, Object> getMediaExtraInfo();
  
  void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener paramFullScreenVideoAdInteractionListener);
  
  void setShowDownLoadBar(boolean paramBoolean);
  
  void showFullScreenVideoAd(Activity paramActivity);
  
  void showFullScreenVideoAd(Activity paramActivity, TTAdConstant.RitScenes paramRitScenes, String paramString);
  
  public static interface FullScreenVideoAdInteractionListener {
    void onAdClose();
    
    void onAdShow();
    
    void onAdVideoBarClick();
    
    void onSkippedVideo();
    
    void onVideoComplete();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTFullScreenVideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */