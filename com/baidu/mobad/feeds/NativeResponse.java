package com.baidu.mobad.feeds;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import java.util.List;
import java.util.Map;

public interface NativeResponse {
  public static final int INFO_FLOW_GROUP_PIC = 35;
  
  public static final int INFO_FLOW_GROUP_PIC_LOGO = 36;
  
  public static final int INFO_FLOW_LEFT_PIC = 33;
  
  public static final int INFO_FLOW_PIC_BOTTOM_TITLE = 28;
  
  public static final int INFO_FLOW_PIC_LOGO = 30;
  
  public static final int INFO_FLOW_PIC_TOP_TITLE = 29;
  
  public static final int INFO_FLOW_RIGHT_PIC = 34;
  
  public static final int INFO_FLOW_VIDEO_TOP_TITLE = 37;
  
  String getAdLogoUrl();
  
  String getAdMaterialType();
  
  String getAppPackage();
  
  long getAppSize();
  
  String getBaiduLogoUrl();
  
  String getBrandName();
  
  int getContainerHeight();
  
  int getContainerSizeType();
  
  int getContainerWidth();
  
  String getDesc();
  
  int getDownloadStatus();
  
  int getDuration();
  
  String getECPMLevel();
  
  Map<String, String> getExtras();
  
  String getHtmlSnippet();
  
  String getIconUrl();
  
  String getImageUrl();
  
  int getMainPicHeight();
  
  int getMainPicWidth();
  
  MaterialType getMaterialType();
  
  List<String> getMultiPicUrls();
  
  int getStyleType();
  
  String getTitle();
  
  String getVideoUrl();
  
  WebView getWebView();
  
  void handleClick(View paramView);
  
  void handleClick(View paramView, int paramInt);
  
  boolean isAdAvailable(Context paramContext);
  
  boolean isAutoPlay();
  
  boolean isDownloadApp();
  
  boolean isNonWifiAutoPlay();
  
  void onClickAd(Context paramContext);
  
  void onClose(Context paramContext, int paramInt);
  
  void onComplete(Context paramContext);
  
  void onError(Context paramContext, int paramInt1, int paramInt2);
  
  void onFullScreen(Context paramContext, int paramInt);
  
  void onStart(Context paramContext);
  
  void pauseAppDownload();
  
  void recordImpression(View paramView);
  
  void registerViewForInteraction(View paramView, AdInteractionListener paramAdInteractionListener);
  
  void resumeAppDownload();
  
  public static interface AdInteractionListener {
    void onADExposed();
    
    void onADStatusChanged();
    
    void onAdClick();
  }
  
  public enum MaterialType {
    HTML,
    NORMAL("normal"),
    VIDEO("video");
    
    private final String a;
    
    static {
    
    }
    
    MaterialType(String param1String1) {
      this.a = param1String1;
    }
    
    public static MaterialType parse(String param1String) {
      for (MaterialType materialType : values()) {
        if (materialType.a.equalsIgnoreCase(param1String))
          return materialType; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\feeds\NativeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */