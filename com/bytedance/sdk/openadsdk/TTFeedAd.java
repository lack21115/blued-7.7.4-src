package com.bytedance.sdk.openadsdk;

public interface TTFeedAd extends TTNativeAd {
  double getVideoDuration();
  
  void setVideoAdListener(VideoAdListener paramVideoAdListener);
  
  public static interface VideoAdListener {
    void onProgressUpdate(long param1Long1, long param1Long2);
    
    void onVideoAdComplete(TTFeedAd param1TTFeedAd);
    
    void onVideoAdContinuePlay(TTFeedAd param1TTFeedAd);
    
    void onVideoAdPaused(TTFeedAd param1TTFeedAd);
    
    void onVideoAdStartPlay(TTFeedAd param1TTFeedAd);
    
    void onVideoError(int param1Int1, int param1Int2);
    
    void onVideoLoad(TTFeedAd param1TTFeedAd);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTFeedAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */