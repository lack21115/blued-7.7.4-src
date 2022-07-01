package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import java.util.HashMap;
import java.util.Map;

public interface UIADI {
  public static final Map<String, String> ext = new HashMap<String, String>();
  
  void close();
  
  void destory();
  
  String getAdNetWorkName();
  
  int getAdPatternType();
  
  int getECPM();
  
  String getECPMLevel();
  
  boolean isValid();
  
  void loadAd();
  
  void loadFullScreenAD();
  
  void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy);
  
  void setMaxVideoDuration(int paramInt);
  
  void setMediaListener(UnifiedInterstitialMediaListener paramUnifiedInterstitialMediaListener);
  
  void setMinVideoDuration(int paramInt);
  
  void setVideoOption(VideoOption paramVideoOption);
  
  void setVideoPlayPolicy(int paramInt);
  
  void show();
  
  void show(Activity paramActivity);
  
  void showAsPopupWindow();
  
  void showAsPopupWindow(Activity paramActivity);
  
  void showFullScreenAD(Activity paramActivity);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\UIADI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */