package com.qq.e.mediation.interfaces;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;

public abstract class BaseInterstitialAd {
  public static final int DEFAULT_PRIORITY = -1;
  
  public BaseInterstitialAd(Activity paramActivity, String paramString1, String paramString2) {}
  
  public abstract void close();
  
  public abstract void destory();
  
  public abstract int getAdPatternType();
  
  public int getAdapterPriority() {
    return -1;
  }
  
  public abstract int getECPM();
  
  public abstract String getECPMLevel();
  
  public abstract boolean isValid();
  
  public abstract void loadAd();
  
  public abstract void setAdListener(UnifiedInterstitialADListener paramUnifiedInterstitialADListener);
  
  public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy);
  
  public abstract void setMaxVideoDuration(int paramInt);
  
  public abstract void setMediaListener(UnifiedInterstitialMediaListener paramUnifiedInterstitialMediaListener);
  
  public abstract void setMinVideoDuration(int paramInt);
  
  public abstract void setVideoOption(VideoOption paramVideoOption);
  
  public abstract void setVideoPlayPolicy(int paramInt);
  
  public abstract void show();
  
  public abstract void show(Activity paramActivity);
  
  public abstract void showAsPopupWindow();
  
  public abstract void showAsPopupWindow(Activity paramActivity);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\mediation\interfaces\BaseInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */