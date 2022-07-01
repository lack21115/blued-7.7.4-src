package com.bytedance.sdk.openadsdk;

import android.view.View;
import java.util.Map;

public interface TTSplashAd {
  int getInteractionType();
  
  Map<String, Object> getMediaExtraInfo();
  
  View getSplashView();
  
  void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener paramExpressAdInteractionListener);
  
  void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  void setNotAllowSdkCountdown();
  
  void setSplashInteractionListener(AdInteractionListener paramAdInteractionListener);
  
  public static interface AdInteractionListener {
    void onAdClicked(View param1View, int param1Int);
    
    void onAdShow(View param1View, int param1Int);
    
    void onAdSkip();
    
    void onAdTimeOver();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTSplashAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */