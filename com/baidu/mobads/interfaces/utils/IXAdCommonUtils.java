package com.baidu.mobads.interfaces.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import java.io.File;
import java.util.List;
import org.json.JSONArray;

public interface IXAdCommonUtils {
  public static final String APPSEC = "BaiduMobAd_APP_SEC";
  
  public static final String APPSID = "BaiduMobAd_APP_ID";
  
  public static final String DEBUG_TOKEN = "BaiduMobAd_DEBUG_TOKEN";
  
  public static final String PKGS_PREF_ACTIVATION = "__sdk_pasys_pkgs_2";
  
  public static final String PKGS_PREF_DOWNLOAD = "__sdk_remote_dl_2";
  
  @Deprecated
  public static final String PKGS_PREF_DOWNLOAD_KEY = "pkgs";
  
  public static final String PKGS_PREF_DOWNLOAD_STATUS = "dl";
  
  public static final int PREF_DOWNLOADED = 3;
  
  public static final int PREF_DOWNLOADED_DELETE = 5;
  
  public static final int PREF_DOWNOADING = 1;
  
  public static final int PREF_DOWNOAD_CANCELED = 2;
  
  public static final int PREF_DOWNOAD_FAILED = 4;
  
  public static final int PREF_LAUNCH_APP = 100;
  
  public static final int PREF_NOT_DOWNLOAD = 0;
  
  JSONArray array2Json(double[] paramArrayOfdouble);
  
  String base64Encode(String paramString);
  
  boolean bitMaskContainsFlag(int paramInt1, int paramInt2);
  
  void browserOutside(Context paramContext, String paramString);
  
  boolean checkSelfPermission(Context paramContext, String paramString);
  
  String createRequestId(Context paramContext, String paramString);
  
  String decodeURIComponent(String paramString);
  
  String encodeURIComponent(String paramString);
  
  long generateUniqueId();
  
  int getApkDownloadStatus(Context paramContext, String paramString1, String paramString2);
  
  String getApkFileLocalPath(Context paramContext, String paramString);
  
  String getAppId(Context paramContext);
  
  String getAppPackage(Context paramContext);
  
  String getAppSec(Context paramContext);
  
  String getBaiduMapsInfo(Context paramContext);
  
  String getChannelId();
  
  String getDebugToken(Context paramContext);
  
  DisplayMetrics getDisplayMetrics(Context paramContext);
  
  String getFileLocalFullPath(Context paramContext, String paramString);
  
  String getLocationInfo(Context paramContext);
  
  int getLogicalPixel(Context paramContext, int paramInt);
  
  String getMD5(String paramString);
  
  int getPixel(Context paramContext, int paramInt);
  
  float getScreenDensity(Context paramContext);
  
  Rect getScreenRect(Context paramContext);
  
  String getStatusStr(Context paramContext, String paramString1, String paramString2);
  
  String getSubscriberId(Context paramContext);
  
  String getTextEncoder(String paramString);
  
  Rect getWindowRect(Context paramContext);
  
  boolean hasPermission(Context paramContext, String paramString);
  
  boolean hasSupportedApps(Context paramContext, int paramInt);
  
  void installApp(Context paramContext, String paramString, File paramFile, boolean paramBoolean);
  
  boolean isOldPermissionModel();
  
  boolean isStringAvailable(String paramString);
  
  JSONArray list2Json(List<String[]> paramList);
  
  String md5(String paramString);
  
  void sendDownloadAdLog(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2);
  
  void sendDownloadAdLog(Context paramContext, String paramString1, int paramInt, String paramString2);
  
  void sendSMS(Context paramContext, String paramString1, String paramString2);
  
  void setAppId(String paramString);
  
  void setAppSec(String paramString);
  
  void setChannelId(String paramString);
  
  String vdUrl(String paramString, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IXAdCommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */