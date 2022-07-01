package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class AGCUtils {
  private static String a(Context paramContext, String paramString) {
    AGConnectServicesConfig aGConnectServicesConfig = AGConnectServicesConfig.a(paramContext);
    InputStream inputStream2 = null;
    InputStream inputStream3 = null;
    InputStream inputStream1 = null;
    try {
      InputStream inputStream = paramContext.getResources().getAssets().open("agconnect-services.json");
      inputStream1 = inputStream;
      inputStream2 = inputStream;
      inputStream3 = inputStream;
      aGConnectServicesConfig.a(inputStream);
      inputStream1 = inputStream;
      inputStream2 = inputStream;
      inputStream3 = inputStream;
      String str2 = aGConnectServicesConfig.a(paramString);
      IOUtils.closeQuietly(inputStream);
      String str1 = str2;
    } catch (IOException iOException) {
      inputStream1 = inputStream3;
      StringBuilder stringBuilder1 = new StringBuilder();
      inputStream1 = inputStream3;
      stringBuilder1.append("Get ");
      inputStream1 = inputStream3;
      stringBuilder1.append(paramString);
      inputStream1 = inputStream3;
      stringBuilder1.append(" failed: ");
      inputStream1 = inputStream3;
      stringBuilder1.append(iOException);
      inputStream1 = inputStream3;
      HMSLog.e("AGCUtils", stringBuilder1.toString());
      inputStream2 = inputStream3;
      IOUtils.closeQuietly(inputStream2);
      String str = "";
    } catch (NullPointerException nullPointerException) {
      inputStream1 = inputStream2;
      StringBuilder stringBuilder1 = new StringBuilder();
      inputStream1 = inputStream2;
      stringBuilder1.append("Get ");
      inputStream1 = inputStream2;
      stringBuilder1.append(paramString);
      inputStream1 = inputStream2;
      stringBuilder1.append(" with AGConnectServicesConfig failed: ");
      inputStream1 = inputStream2;
      stringBuilder1.append(nullPointerException);
      inputStream1 = inputStream2;
      HMSLog.e("AGCUtils", stringBuilder1.toString());
    } finally {}
    if (!TextUtils.isEmpty((CharSequence)paramContext))
      return (String)paramContext; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("The ");
    stringBuilder.append(paramString);
    stringBuilder.append(" is null.");
    HMSLog.e("AGCUtils", stringBuilder.toString());
    return "";
  }
  
  private static boolean a(Context paramContext) {
    return paramContext.getPackageName().equals(HMSPackageManager.getInstance(paramContext).getHMSPackageName());
  }
  
  private static String b(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager == null) {
      HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
      return "";
    } 
    try {
      ApplicationInfo applicationInfo = (packageManager.getPackageInfo(paramContext.getPackageName(), 128)).applicationInfo;
      if (applicationInfo != null && applicationInfo.metaData != null) {
        object = applicationInfo.metaData.get("com.huawei.hms.client.appid");
        if (object != null) {
          object = String.valueOf(object);
          if (object.startsWith("appid="))
            return object.substring(6); 
        } else {
          HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
          return "";
        } 
      } else {
        HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
        return "";
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException object) {
      HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
      return "";
    } 
    return (String)object;
  }
  
  private static String c(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager == null) {
      HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
      return "";
    } 
    try {
      ApplicationInfo applicationInfo = (packageManager.getPackageInfo(paramContext.getPackageName(), 128)).applicationInfo;
      if (applicationInfo != null && applicationInfo.metaData != null) {
        object = applicationInfo.metaData.get("com.huawei.hms.client.cpid");
        if (object != null) {
          object = String.valueOf(object);
          if (object.startsWith("cpid="))
            return object.substring(5); 
        } else {
          HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
          return "";
        } 
      } else {
        HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
        return "";
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException object) {
      HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
      return "";
    } 
    return (String)object;
  }
  
  public static String getAppId(Context paramContext) {
    if (a(paramContext))
      return a(paramContext, "client/app_id"); 
    String str = null;
    try {
      String str1 = AGConnectServicesConfig.a(paramContext).a("client/app_id");
      str = str1;
    } catch (NullPointerException nullPointerException) {
      HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
    } 
    if (!TextUtils.isEmpty(str))
      return str; 
    str = b(paramContext);
    return !TextUtils.isEmpty(str) ? str : a(paramContext, "client/app_id");
  }
  
  public static String getCpId(Context paramContext) {
    if (a(paramContext))
      return a(paramContext, "client/cp_id"); 
    String str = null;
    try {
      String str1 = AGConnectServicesConfig.a(paramContext).a("client/cp_id");
      str = str1;
    } catch (NullPointerException nullPointerException) {
      HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
    } 
    if (!TextUtils.isEmpty(str))
      return str; 
    str = c(paramContext);
    return !TextUtils.isEmpty(str) ? str : a(paramContext, "client/cp_id");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\commo\\util\AGCUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */