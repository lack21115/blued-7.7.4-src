package com.huawei.hms.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.List;

public class PackageManagerHelper {
  private final PackageManager a;
  
  public PackageManagerHelper(Context paramContext) {
    this.a = paramContext.getPackageManager();
  }
  
  private byte[] a(String paramString) {
    try {
      PackageInfo packageInfo = this.a.getPackageInfo(paramString, 64);
      if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0)
        return packageInfo.signatures[0].toByteArray(); 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to get application signature certificate fingerprint.");
      stringBuilder.append(nameNotFoundException.getMessage());
      HMSLog.e("PackageManagerHelper", stringBuilder.toString());
    } 
    HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
    return new byte[0];
  }
  
  public static boolean isBackground(Context paramContext) {
    if (paramContext == null)
      return false; 
    try {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (activityManager == null)
        return false; 
      List list = activityManager.getRunningAppProcesses();
      if (list == null)
        return false; 
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
        if (runningAppProcessInfo.processName.equals(paramContext.getPackageName())) {
          int i = runningAppProcessInfo.importance;
          if (i >= 200)
            return true; 
        } 
      } 
    } catch (Exception exception) {
      HMSLog.e("PackageManagerHelper", "check the app isBackground", exception);
    } 
    return false;
  }
  
  public String getPackageSignature(String paramString) {
    byte[] arrayOfByte = a(paramString);
    return (arrayOfByte == null || arrayOfByte.length == 0) ? null : HEX.encodeHexString(SHA256.digest(arrayOfByte), true);
  }
  
  public PackageStates getPackageStates(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return PackageStates.NOT_INSTALLED; 
    try {
      return (this.a.getApplicationInfo(paramString, 0)).enabled ? PackageStates.ENABLED : PackageStates.DISABLED;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return PackageStates.NOT_INSTALLED;
    } 
  }
  
  public int getPackageVersionCode(String paramString) {
    try {
      PackageInfo packageInfo = this.a.getPackageInfo(paramString, 16);
      return (packageInfo != null) ? packageInfo.versionCode : 0;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return 0;
    } 
  }
  
  public String getPackageVersionName(String paramString) {
    try {
      PackageInfo packageInfo = this.a.getPackageInfo(paramString, 16);
      return (packageInfo != null && packageInfo.versionName != null) ? packageInfo.versionName : "";
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return "";
    } 
  }
  
  public boolean hasProvider(String paramString1, String paramString2) {
    try {
      PackageInfo packageInfo = this.a.getPackageInfo(paramString1, 8);
      if (packageInfo != null && packageInfo.providers != null) {
        ProviderInfo[] arrayOfProviderInfo = packageInfo.providers;
        int j = arrayOfProviderInfo.length;
        for (int i = 0; i < j; i++) {
          boolean bool = paramString2.equals((arrayOfProviderInfo[i]).authority);
          if (bool)
            return true; 
        } 
      } 
      return false;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  public boolean verifyPackageArchive(String paramString1, String paramString2, String paramString3) {
    PackageInfo packageInfo = this.a.getPackageArchiveInfo(paramString1, 64);
    if (packageInfo != null && packageInfo.signatures.length > 0) {
      if (!paramString2.equals(packageInfo.packageName))
        return false; 
      paramString2 = null;
      InputStream inputStream = null;
      paramString1 = null;
      try {
        InputStream inputStream3 = IOUtils.toInputStream(packageInfo.signatures[0].toByteArray());
        InputStream inputStream1 = inputStream3;
        InputStream inputStream2 = inputStream3;
        inputStream = inputStream3;
        boolean bool = paramString3.equalsIgnoreCase(HEX.encodeHexString(SHA256.digest(CertificateFactory.getInstance("X.509").generateCertificate(inputStream3).getEncoded()), true));
        IOUtils.closeQuietly(inputStream3);
        return bool;
      } catch (IOException iOException) {
        InputStream inputStream1 = inputStream;
      } catch (CertificateException certificateException) {
      
      } finally {}
      paramString1 = paramString2;
      StringBuilder stringBuilder = new StringBuilder();
      paramString1 = paramString2;
      stringBuilder.append("Failed to get application signature certificate fingerprint.");
      paramString1 = paramString2;
      stringBuilder.append(certificateException.getMessage());
      paramString1 = paramString2;
      HMSLog.e("PackageManagerHelper", stringBuilder.toString());
      IOUtils.closeQuietly((InputStream)paramString2);
      return false;
    } 
    return false;
  }
  
  public enum PackageStates {
    DISABLED, ENABLED, NOT_INSTALLED;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\PackageManagerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */