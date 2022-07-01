package com.huawei.hms.framework.common.hianalytics;

import android.content.Context;
import android.provider.Settings;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.v2.HiAnalytics;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;

public class HianalyticsHelper {
  private static final String EVENT_ID = "networkkit_restclient";
  
  private static final String HWID_HA_SERVICE_TAG = "hms_hwid";
  
  private static final String TAG = "HianalyticsHelper";
  
  private static final int TYPE_MAINTF = 1;
  
  private static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
  
  private static final int USER_EXPERIENCE_ON = 1;
  
  private static volatile HianalyticsHelper instance;
  
  private HiAnalyticsInstance hInstance = null;
  
  private String haTag = "hms_hwid";
  
  private boolean hasHianalytics;
  
  private ExecutorService reportExecutor = ExecutorsUtils.newSingleThreadExecutor("report_ha");
  
  private HianalyticsHelper() {
    try {
      return;
    } finally {
      Exception exception = null;
      Logger.w("HianalyticsHelper", "maybe you need add Hianalytics sdk");
      this.hasHianalytics = false;
    } 
  }
  
  public static HianalyticsHelper getInstance() {
    // Byte code:
    //   0: getstatic com/huawei/hms/framework/common/hianalytics/HianalyticsHelper.instance : Lcom/huawei/hms/framework/common/hianalytics/HianalyticsHelper;
    //   3: ifnonnull -> 37
    //   6: ldc com/huawei/hms/framework/common/hianalytics/HianalyticsHelper
    //   8: monitorenter
    //   9: getstatic com/huawei/hms/framework/common/hianalytics/HianalyticsHelper.instance : Lcom/huawei/hms/framework/common/hianalytics/HianalyticsHelper;
    //   12: ifnonnull -> 25
    //   15: new com/huawei/hms/framework/common/hianalytics/HianalyticsHelper
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/huawei/hms/framework/common/hianalytics/HianalyticsHelper.instance : Lcom/huawei/hms/framework/common/hianalytics/HianalyticsHelper;
    //   25: ldc com/huawei/hms/framework/common/hianalytics/HianalyticsHelper
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/huawei/hms/framework/common/hianalytics/HianalyticsHelper
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/huawei/hms/framework/common/hianalytics/HianalyticsHelper.instance : Lcom/huawei/hms/framework/common/hianalytics/HianalyticsHelper;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public ExecutorService getReportExecutor() {
    return this.reportExecutor;
  }
  
  public boolean isEnableReport(Context paramContext) {
    return !this.hasHianalytics ? false : isEnableReportNoSeed(paramContext);
  }
  
  public boolean isEnableReportNoSeed(Context paramContext) {
    if (!this.hasHianalytics) {
      str = "Hianalytics sdk need to be initialized";
      Logger.i("HianalyticsHelper", str);
      return false;
    } 
    if (str == null) {
      str = "HianalyticsHelper context can't be null";
      Logger.i("HianalyticsHelper", str);
      return false;
    } 
    if (Settings.Secure.getInt(str.getContentResolver(), "user_experience_involved", -1) == 1) {
      if (HiAnalytics.getInitFlag())
        return true; 
      if (this.hInstance == null)
        this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag); 
      return (this.hInstance != null);
    } 
    String str = "user experience involved needs to be opened";
    Logger.i("HianalyticsHelper", str);
    return false;
  }
  
  public void onEvent(LinkedHashMap<String, String> paramLinkedHashMap) {
    onEvent(paramLinkedHashMap, "networkkit_restclient");
  }
  
  public void onEvent(LinkedHashMap<String, String> paramLinkedHashMap, String paramString) {
    if (!this.hasHianalytics)
      return; 
    if (paramLinkedHashMap == null)
      return; 
    Logger.v("HianalyticsHelper", "data = %s", new Object[] { paramLinkedHashMap });
    if (HiAnalytics.getInitFlag()) {
      HiAnalytics.onEvent(1, paramString, paramLinkedHashMap);
      return;
    } 
    HiAnalyticsInstance hiAnalyticsInstance = this.hInstance;
    if (hiAnalyticsInstance != null)
      hiAnalyticsInstance.onEvent(1, paramString, paramLinkedHashMap); 
  }
  
  public void setHaTag(String paramString) {
    this.haTag = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\hianalytics\HianalyticsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */