package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class l implements TTNativeExpressAd {
  public AtomicBoolean e = new AtomicBoolean(false);
  
  public void destroy() {}
  
  public View getExpressAdView() {
    return null;
  }
  
  public List<FilterWord> getFilterWords() {
    return null;
  }
  
  public int getImageMode() {
    return 0;
  }
  
  public int getInteractionType() {
    return 0;
  }
  
  public Map<String, Object> getMediaExtraInfo() {
    return null;
  }
  
  public a getVideoModel() {
    return null;
  }
  
  public void render() {}
  
  public void setCanInterruptVideoPlay(boolean paramBoolean) {}
  
  public void setDislikeCallback(Activity paramActivity, TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {}
  
  public void setDislikeDialog(TTDislikeDialogAbstract paramTTDislikeDialogAbstract) {}
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {}
  
  public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener paramAdInteractionListener) {}
  
  public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener paramExpressAdInteractionListener) {}
  
  public void setSlideIntervalTime(int paramInt) {}
  
  public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener paramExpressVideoAdListener) {}
  
  public void showInteractionExpressAd(Activity paramActivity) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */