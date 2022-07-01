package com.qq.e.mediation.interfaces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

public abstract class BaseSplashAd {
  public static final int DEFAULT_PRIORITY = -1;
  
  public static final int EVENT_TYPE_AD_CLICKED = 4;
  
  public static final int EVENT_TYPE_AD_DISMISSED = 1;
  
  public static final int EVENT_TYPE_AD_EXPOSURE = 6;
  
  public static final int EVENT_TYPE_AD_LOADED = 7;
  
  public static final int EVENT_TYPE_AD_PRESENT = 3;
  
  public static final int EVENT_TYPE_AD_TICK = 5;
  
  public static final int EVENT_TYPE_NO_AD = 2;
  
  public BaseSplashAd(Context paramContext, String paramString1, String paramString2) {}
  
  public abstract void fetchAdOnly();
  
  public abstract void fetchAndShowIn(ViewGroup paramViewGroup);
  
  public int getAdapterPriority() {
    return -1;
  }
  
  public abstract int getECPM();
  
  public abstract String getECPMLevel();
  
  public abstract void preload();
  
  public abstract void setAdListener(ADListener paramADListener);
  
  public abstract void setFetchDelay(int paramInt);
  
  public abstract void setLoadAdParams(LoadAdParams paramLoadAdParams);
  
  public abstract void setSkipView(View paramView);
  
  public abstract void showAd(ViewGroup paramViewGroup);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\mediation\interfaces\BaseSplashAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */