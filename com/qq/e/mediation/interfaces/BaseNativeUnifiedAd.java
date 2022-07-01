package com.qq.e.mediation.interfaces;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;
import java.util.List;

public abstract class BaseNativeUnifiedAd {
  public static final int CALLBACK_CLICK = 3;
  
  public static final int CALLBACK_IMPRESSION = 4;
  
  public static final int CALLBACK_LOADED = 1;
  
  public static final int CALLBACK_NO_AD = 2;
  
  public static final int DEFAULT_PRIORITY = -1;
  
  public BaseNativeUnifiedAd(Context paramContext, String paramString1, String paramString2) {}
  
  public int getAdapterPriority() {
    return -1;
  }
  
  public abstract int getECPM();
  
  public abstract void loadData(int paramInt);
  
  public abstract void setAdListener(ADListener paramADListener);
  
  public abstract void setBrowserType(int paramInt);
  
  public abstract void setCategories(List<String> paramList);
  
  public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy);
  
  public abstract void setMaxVideoDuration(int paramInt);
  
  public abstract void setMinVideoDuration(int paramInt);
  
  public abstract void setVideoADContainerRender(int paramInt);
  
  public abstract void setVideoPlayPolicy(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\mediation\interfaces\BaseNativeUnifiedAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */