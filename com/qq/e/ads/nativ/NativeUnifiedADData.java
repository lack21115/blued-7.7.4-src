package com.qq.e.ads.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.adevent.ADEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NativeUnifiedADData {
  public static final int AD_CLICKED = 2;
  
  public static final int AD_ERROR = 3;
  
  public static final int AD_EXPOSED = 1;
  
  public static final int AD_STATUS_CHANGED = 4;
  
  public static final int MEDIA_CLICKED = 15;
  
  public static final int MEDIA_COMPLETED = 12;
  
  public static final int MEDIA_ERROR = 13;
  
  public static final int MEDIA_INIT = 5;
  
  public static final int MEDIA_LOADED = 8;
  
  public static final int MEDIA_LOADING = 6;
  
  public static final int MEDIA_PAUSE = 10;
  
  public static final int MEDIA_READY = 7;
  
  public static final int MEDIA_RESUME = 11;
  
  public static final int MEDIA_START = 9;
  
  public static final int MEDIA_STOP = 14;
  
  public static final Map<String, String> ext = new HashMap<String, String>();
  
  void bindAdToView(Context paramContext, NativeAdContainer paramNativeAdContainer, FrameLayout.LayoutParams paramLayoutParams, List<View> paramList);
  
  void bindAdToView(Context paramContext, NativeAdContainer paramNativeAdContainer, FrameLayout.LayoutParams paramLayoutParams, List<View> paramList1, List<View> paramList2);
  
  void bindCTAViews(List<View> paramList);
  
  void bindMediaView(MediaView paramMediaView, VideoOption paramVideoOption, NativeADMediaListener paramNativeADMediaListener);
  
  void destroy();
  
  boolean equalsAdData(NativeUnifiedADData paramNativeUnifiedADData);
  
  int getAdPatternType();
  
  double getAppPrice();
  
  int getAppScore();
  
  int getAppStatus();
  
  String getCTAText();
  
  String getDesc();
  
  long getDownloadCount();
  
  int getECPM();
  
  String getECPMLevel();
  
  String getIconUrl();
  
  List<String> getImgList();
  
  String getImgUrl();
  
  int getPictureHeight();
  
  int getPictureWidth();
  
  int getProgress();
  
  String getTitle();
  
  @Deprecated
  String getVastContent();
  
  @Deprecated
  String getVastTag();
  
  int getVideoCurrentPosition();
  
  int getVideoDuration();
  
  boolean isAppAd();
  
  @Deprecated
  boolean isSkippable();
  
  void negativeFeedback();
  
  @Deprecated
  void onVideoADExposured(View paramView);
  
  void pauseVideo();
  
  void preloadVideo(VideoPreloadListener paramVideoPreloadListener);
  
  @Deprecated
  void reportVastEvent(ADEvent paramADEvent);
  
  void resume();
  
  void resumeVideo();
  
  void setNativeAdEventListener(NativeADEventListener paramNativeADEventListener);
  
  void setVideoMute(boolean paramBoolean);
  
  void startVideo();
  
  void stopVideo();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\NativeUnifiedADData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */