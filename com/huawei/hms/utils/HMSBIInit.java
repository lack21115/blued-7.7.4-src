package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hianalytics.hms.HiAnalyticsConf;
import com.huawei.hms.stats.a;

public class HMSBIInit {
  private static final String TAG = "HMSBIInit";
  
  public static <T> T checkNonNull(T paramT, String paramString) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramString));
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {
    checkNonNull(paramContext, "context must not be null.");
    (new HiAnalyticsConf.Builder(paramContext)).setEnableImei(paramBoolean1).setEnableUDID(paramBoolean2).setEnableSN(paramBoolean3).setCollectURL(0, paramString).create();
  }
  
  public boolean isInit() {
    return a.b();
  }
  
  public void refresh(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4) {
    checkNonNull(paramContext, "context must not be null.");
    (new HiAnalyticsConf.Builder(paramContext)).setEnableImei(paramBoolean1).setEnableUDID(paramBoolean2).setEnableSN(paramBoolean3).setCollectURL(0, paramString).refresh(paramBoolean4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\HMSBIInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */