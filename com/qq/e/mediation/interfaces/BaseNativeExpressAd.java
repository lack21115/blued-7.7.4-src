package com.qq.e.mediation.interfaces;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

public abstract class BaseNativeExpressAd {
  public static final int DEFAULT_PRIORITY = -1;
  
  public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
  
  public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
  
  public static final int EVENT_TYPE_ON_AD_LOADED = 2;
  
  public static final int EVENT_TYPE_ON_NO_AD = 1;
  
  public BaseNativeExpressAd(Context paramContext, ADSize paramADSize, String paramString1, String paramString2) {}
  
  public int getAdapterPriority() {
    return -1;
  }
  
  public abstract int getECPM();
  
  public abstract void loadAD(int paramInt);
  
  public abstract void loadAD(int paramInt, LoadAdParams paramLoadAdParams);
  
  public abstract void setAdListener(ADListener paramADListener);
  
  public abstract void setMaxVideoDuration(int paramInt);
  
  public abstract void setMinVideoDuration(int paramInt);
  
  public abstract void setVideoOption(VideoOption paramVideoOption);
  
  public abstract void setVideoPlayPolicy(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\mediation\interfaces\BaseNativeExpressAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */