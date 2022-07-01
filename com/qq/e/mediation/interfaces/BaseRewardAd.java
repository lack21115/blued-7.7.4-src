package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

public abstract class BaseRewardAd {
  public static final int DEFAULT_PRIORITY = -1;
  
  public static final int EVENT_TYPE_ON_AD_CLICK = 6;
  
  public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
  
  public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
  
  public static final int EVENT_TYPE_ON_AD_LOADED = 1;
  
  public static final int EVENT_TYPE_ON_AD_SHOW = 3;
  
  public static final int EVENT_TYPE_ON_ERROR = 9;
  
  public static final int EVENT_TYPE_ON_REWARD = 5;
  
  public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
  
  public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;
  
  private LoadAdParams a = null;
  
  public BaseRewardAd(Context paramContext, String paramString1, String paramString2) {}
  
  public int getAdapterPriority() {
    return -1;
  }
  
  public abstract int getECPM();
  
  public abstract String getECPMLevel();
  
  public abstract long getExpireTimestamp();
  
  public LoadAdParams getLoadAdParams() {
    return this.a;
  }
  
  public int getRewardAdType() {
    return 0;
  }
  
  public abstract int getVideoDuration();
  
  public abstract boolean hasShown();
  
  public abstract void loadAD();
  
  public abstract void setAdListener(ADListener paramADListener);
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    this.a = paramLoadAdParams;
  }
  
  public abstract void setVolumOn(boolean paramBoolean);
  
  public abstract void showAD();
  
  public void showAD(Activity paramActivity) {
    showAD();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\mediation\interfaces\BaseRewardAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */