package com.bytedance.sdk.openadsdk;

import android.view.View;
import java.util.Map;

public interface TTBannerAd {
  View getBannerView();
  
  TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback);
  
  int getInteractionType();
  
  Map<String, Object> getMediaExtraInfo();
  
  void setBannerInteractionListener(AdInteractionListener paramAdInteractionListener);
  
  void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback);
  
  void setSlideIntervalTime(int paramInt);
  
  public static interface AdInteractionListener {
    void onAdClicked(View param1View, int param1Int);
    
    void onAdShow(View param1View, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTBannerAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */