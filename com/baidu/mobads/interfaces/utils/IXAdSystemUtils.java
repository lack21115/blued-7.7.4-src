package com.baidu.mobads.interfaces.utils;

import android.content.Context;
import java.net.HttpURLConnection;
import java.util.List;
import org.json.JSONArray;

public interface IXAdSystemUtils {
  public static final String NT_NONE = "none";
  
  public static final String NT_UNKNOWN = "unknown";
  
  public static final String NT_WIFI = "wifi";
  
  boolean canSupportSdcardStroage(Context paramContext);
  
  long getAllExternalMemorySize();
  
  long getAllInternalMemorySize();
  
  String getAndroidId(Context paramContext);
  
  String getAppSDC();
  
  long getAvailableExternalMemorySize();
  
  long getAvailableInternalMemorySize();
  
  JSONArray getBackgroundBrowsers(Context paramContext);
  
  String getCUID(Context paramContext);
  
  List<String[]> getCell(Context paramContext);
  
  int getCurrentProcessId(Context paramContext);
  
  String getCurrentProcessName(Context paramContext);
  
  String getDeviceId(Context paramContext);
  
  String getEncodedSN(Context paramContext);
  
  double[] getGPS(Context paramContext);
  
  String getGUID(Context paramContext);
  
  HttpURLConnection getHttpConnection(Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  String getIMEI(Context paramContext);
  
  String getIp(Context paramContext);
  
  String getMacAddress(Context paramContext);
  
  String getMaxCpuFreq();
  
  String getMem();
  
  String getNetType(Context paramContext);
  
  int getNetworkCatagory(Context paramContext);
  
  String getNetworkOperator(Context paramContext);
  
  String getNetworkOperatorName(Context paramContext);
  
  String getNetworkType(Context paramContext);
  
  String getPhoneOSBrand();
  
  String getPhoneOSBuildVersionSdk();
  
  String getSn(Context paramContext);
  
  String getSnFrom(Context paramContext);
  
  List<String[]> getWIFI(Context paramContext);
  
  String getWifiConnected(Context paramContext);
  
  JSONArray getWifiScans(Context paramContext);
  
  Boolean is3GConnected(Context paramContext);
  
  boolean isCurrentNetworkAvailable(Context paramContext);
  
  boolean isTablet(Context paramContext);
  
  boolean isUseOldStoragePath();
  
  Boolean isWifiConnected(Context paramContext);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IXAdSystemUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */