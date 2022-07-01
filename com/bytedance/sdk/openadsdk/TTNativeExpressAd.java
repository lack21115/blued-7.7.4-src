package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import java.util.List;
import java.util.Map;

public interface TTNativeExpressAd {
  void destroy();
  
  View getExpressAdView();
  
  List<FilterWord> getFilterWords();
  
  int getImageMode();
  
  int getInteractionType();
  
  Map<String, Object> getMediaExtraInfo();
  
  a getVideoModel();
  
  void render();
  
  void setCanInterruptVideoPlay(boolean paramBoolean);
  
  void setDislikeCallback(Activity paramActivity, TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback);
  
  void setDislikeDialog(TTDislikeDialogAbstract paramTTDislikeDialogAbstract);
  
  void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  void setExpressInteractionListener(AdInteractionListener paramAdInteractionListener);
  
  void setExpressInteractionListener(ExpressAdInteractionListener paramExpressAdInteractionListener);
  
  void setSlideIntervalTime(int paramInt);
  
  void setVideoAdListener(ExpressVideoAdListener paramExpressVideoAdListener);
  
  void showInteractionExpressAd(Activity paramActivity);
  
  public static interface AdInteractionListener extends ExpressAdInteractionListener {
    void onAdDismiss();
  }
  
  public static interface ExpressAdInteractionListener {
    void onAdClicked(View param1View, int param1Int);
    
    void onAdShow(View param1View, int param1Int);
    
    void onRenderFail(View param1View, String param1String, int param1Int);
    
    void onRenderSuccess(View param1View, float param1Float1, float param1Float2);
  }
  
  public static interface ExpressVideoAdListener {
    void onClickRetry();
    
    void onProgressUpdate(long param1Long1, long param1Long2);
    
    void onVideoAdComplete();
    
    void onVideoAdContinuePlay();
    
    void onVideoAdPaused();
    
    void onVideoAdStartPlay();
    
    void onVideoError(int param1Int1, int param1Int2);
    
    void onVideoLoad();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTNativeExpressAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */