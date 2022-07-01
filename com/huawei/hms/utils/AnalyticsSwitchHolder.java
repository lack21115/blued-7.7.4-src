package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.support.log.HMSLog;

public class AnalyticsSwitchHolder {
  private static final int ANALYTICS_DISABLED = 2;
  
  private static final int ANALYTICS_ENABLED = 1;
  
  private static final Object LOCK_OBJ = new Object();
  
  private static final String META_BI_REPORT_SETTING = "com.huawei.hms.client.bireport.setting";
  
  private static final String META_BI_SETTING = "com.huawei.hms.client.bi.setting";
  
  private static final int NOT_CHECKED = 0;
  
  private static final String TAG = "AnalyticsSwitchHolder";
  
  private static int analyticsState;
  
  private static boolean getBiIsReportSetting(Context paramContext) {
    if (paramContext == null) {
      HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
      return false;
    } 
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        ApplicationInfo applicationInfo = (packageManager.getPackageInfo(paramContext.getPackageName(), 128)).applicationInfo;
        if (applicationInfo != null && applicationInfo.metaData != null)
          return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bireport.setting"); 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
      }  
    HMSLog.i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
    return false;
  }
  
  public static boolean getBiSetting(Context paramContext) {
    if (paramContext == null) {
      HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
      return false;
    } 
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        ApplicationInfo applicationInfo = (packageManager.getPackageInfo(paramContext.getPackageName(), 128)).applicationInfo;
        if (applicationInfo != null && applicationInfo.metaData != null)
          return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bi.setting"); 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
      }  
    HMSLog.i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
    return false;
  }
  
  public static boolean isAnalyticsDisabled(Context paramContext) {
    synchronized (LOCK_OBJ) {
      int i = analyticsState;
      boolean bool = true;
      if (i == 0) {
        if (paramContext == null)
          return true; 
        if (getBiIsReportSetting(paramContext)) {
          HMSLog.i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
          analyticsState = 1;
        } else if (getBiSetting(paramContext)) {
          HMSLog.i("AnalyticsSwitchHolder", "Builder->biSetting :true");
          analyticsState = 2;
        } else if ("CN".equalsIgnoreCase(GrsApp.getInstance().getIssueCountryCode(paramContext))) {
          analyticsState = 1;
        } else {
          HMSLog.i("AnalyticsSwitchHolder", "not ChinaROM");
          try {
            i = Settings.Secure.getInt(paramContext.getContentResolver(), "hw_app_analytics_state");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hw_app_analytics_state value is ");
            stringBuilder.append(i);
            HMSLog.i("AnalyticsSwitchHolder", stringBuilder.toString());
            if (i == 1) {
              analyticsState = 1;
            } else {
              analyticsState = 2;
            } 
          } catch (android.provider.Settings.SettingNotFoundException settingNotFoundException) {
            HMSLog.i("AnalyticsSwitchHolder", "Get OOBE failed");
            analyticsState = 2;
          } 
        } 
      } 
      if (analyticsState == 1)
        bool = false; 
      return bool;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\AnalyticsSwitchHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */