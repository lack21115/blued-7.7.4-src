package com.qq.e.ads.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;

public class NativeUnifiedADDataAdapter implements NativeUnifiedADData {
  private NativeUnifiedADData a;
  
  private NativeADEventListener b;
  
  private NativeADMediaListener c;
  
  public NativeUnifiedADDataAdapter(NativeUnifiedADData paramNativeUnifiedADData) {
    this.a = paramNativeUnifiedADData;
    paramNativeUnifiedADData = this.a;
    if (paramNativeUnifiedADData instanceof ADEventListener)
      ((ADEventListener)paramNativeUnifiedADData).setAdListener(new UnifiedAdListener((byte)0)); 
  }
  
  public void bindAdToView(Context paramContext, NativeAdContainer paramNativeAdContainer, FrameLayout.LayoutParams paramLayoutParams, List<View> paramList) {
    this.a.bindAdToView(paramContext, paramNativeAdContainer, paramLayoutParams, paramList);
  }
  
  public void bindAdToView(Context paramContext, NativeAdContainer paramNativeAdContainer, FrameLayout.LayoutParams paramLayoutParams, List<View> paramList1, List<View> paramList2) {
    this.a.bindAdToView(paramContext, paramNativeAdContainer, paramLayoutParams, paramList1, paramList2);
  }
  
  public void bindCTAViews(List<View> paramList) {
    this.a.bindCTAViews(paramList);
  }
  
  public void bindMediaView(MediaView paramMediaView, VideoOption paramVideoOption, NativeADMediaListener paramNativeADMediaListener) {
    this.c = paramNativeADMediaListener;
    this.a.bindMediaView(paramMediaView, paramVideoOption, null);
  }
  
  public void destroy() {
    this.a.destroy();
  }
  
  public boolean equalsAdData(NativeUnifiedADData paramNativeUnifiedADData) {
    return this.a.equalsAdData(paramNativeUnifiedADData);
  }
  
  public NativeUnifiedADData getAdData() {
    return this.a;
  }
  
  public int getAdPatternType() {
    return this.a.getAdPatternType();
  }
  
  public double getAppPrice() {
    return this.a.getAppPrice();
  }
  
  public int getAppScore() {
    return this.a.getAppScore();
  }
  
  public int getAppStatus() {
    return this.a.getAppStatus();
  }
  
  public String getCTAText() {
    return this.a.getCTAText();
  }
  
  public String getDesc() {
    return this.a.getDesc();
  }
  
  public long getDownloadCount() {
    return this.a.getDownloadCount();
  }
  
  public int getECPM() {
    return this.a.getECPM();
  }
  
  public String getECPMLevel() {
    return this.a.getECPMLevel();
  }
  
  public String getIconUrl() {
    return this.a.getIconUrl();
  }
  
  public List<String> getImgList() {
    return this.a.getImgList();
  }
  
  public String getImgUrl() {
    return this.a.getImgUrl();
  }
  
  public int getPictureHeight() {
    return this.a.getPictureHeight();
  }
  
  public int getPictureWidth() {
    return this.a.getPictureWidth();
  }
  
  public int getProgress() {
    return this.a.getProgress();
  }
  
  public String getTitle() {
    return this.a.getTitle();
  }
  
  public String getVastContent() {
    return this.a.getVastContent();
  }
  
  public String getVastTag() {
    return this.a.getVastTag();
  }
  
  public int getVideoCurrentPosition() {
    return this.a.getVideoCurrentPosition();
  }
  
  public int getVideoDuration() {
    return this.a.getVideoDuration();
  }
  
  public boolean isAppAd() {
    return this.a.isAppAd();
  }
  
  public boolean isSkippable() {
    return this.a.isSkippable();
  }
  
  public void negativeFeedback() {
    this.a.negativeFeedback();
  }
  
  public void onVideoADExposured(View paramView) {
    this.a.onVideoADExposured(paramView);
  }
  
  public void pauseVideo() {
    this.a.pauseVideo();
  }
  
  public void preloadVideo(VideoPreloadListener paramVideoPreloadListener) {
    this.a.preloadVideo(paramVideoPreloadListener);
  }
  
  public void reportVastEvent(ADEvent paramADEvent) {}
  
  public void resume() {
    this.a.resume();
  }
  
  public void resumeVideo() {
    this.a.resumeVideo();
  }
  
  public void setNativeAdEventListener(NativeADEventListener paramNativeADEventListener) {
    this.b = paramNativeADEventListener;
  }
  
  public void setVideoMute(boolean paramBoolean) {
    this.a.setVideoMute(paramBoolean);
  }
  
  public void startVideo() {
    this.a.startVideo();
  }
  
  public void stopVideo() {
    this.a.stopVideo();
  }
  
  class UnifiedAdListener implements ADListener {
    private UnifiedAdListener(NativeUnifiedADDataAdapter this$0) {}
    
    public void onADEvent(ADEvent param1ADEvent) {
      if (param1ADEvent.getType() <= 4) {
        NativeUnifiedADDataAdapter.a(this.a, param1ADEvent);
        return;
      } 
      NativeUnifiedADDataAdapter.b(this.a, param1ADEvent);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\NativeUnifiedADDataAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */