package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import java.util.Map;

public interface TTInteractionAd {
  int getInteractionType();
  
  Map<String, Object> getMediaExtraInfo();
  
  void setAdInteractionListener(AdInteractionListener paramAdInteractionListener);
  
  void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  void showInteractionAd(Activity paramActivity);
  
  public static interface AdInteractionListener {
    void onAdClicked();
    
    void onAdDismiss();
    
    void onAdShow();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTInteractionAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */