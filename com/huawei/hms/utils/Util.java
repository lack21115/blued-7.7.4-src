package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;

public class Util {
  private static final String AVAILABLE_LOADED = "availableLoaded";
  
  private static final Object LOCK_OBJECT = new Object();
  
  private static final String META_HMSVERSION_NAME = "com.huawei.hms.version";
  
  private static final String TAG = "Util";
  
  private static boolean availableInit = false;
  
  private static boolean isAvailableAvailable = false;
  
  public static int compareHmsVersion(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return -1; 
    if (TextUtils.isEmpty(paramString2))
      return 1; 
    if (StringUtil.checkVersion(paramString1) && StringUtil.checkVersion(paramString2)) {
      String[] arrayOfString1 = paramString1.split("\\.");
      String[] arrayOfString2 = paramString2.split("\\.");
      if (2 < arrayOfString1.length && 2 < arrayOfString2.length) {
        if (Integer.parseInt(arrayOfString1[0]) > Integer.parseInt(arrayOfString2[0]))
          return 1; 
        if (Integer.parseInt(arrayOfString1[0]) < Integer.parseInt(arrayOfString2[0]))
          return -1; 
        if (Integer.parseInt(arrayOfString1[1]) > Integer.parseInt(arrayOfString2[1]))
          return 1; 
        if (Integer.parseInt(arrayOfString1[1]) < Integer.parseInt(arrayOfString2[1]))
          return -1; 
        if (Integer.parseInt(arrayOfString1[2]) > Integer.parseInt(arrayOfString2[2]))
          return 1; 
        if (Integer.parseInt(arrayOfString1[2]) < Integer.parseInt(arrayOfString2[2]))
          return -1; 
      } 
    } 
    return 0;
  }
  
  public static Activity getActiveActivity(Activity paramActivity, Context paramContext) {
    return UIUtil.getActiveActivity(paramActivity, paramContext);
  }
  
  public static String getAppId(Context paramContext) {
    return AGCUtils.getAppId(paramContext);
  }
  
  public static String getAppName(Context paramContext, String paramString) {
    if (paramContext == null) {
      HMSLog.e("Util", "In getAppName, context is null.");
      return "";
    } 
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager == null) {
      HMSLog.e("Util", "In getAppName, Failed to get 'PackageManager' instance.");
      return "";
    } 
    String str = paramString;
    try {
      if (TextUtils.isEmpty(paramString))
        str = paramContext.getPackageName(); 
      null = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
      return (null == null) ? "" : null.toString();
    } catch (android.content.pm.PackageManager.NameNotFoundException|android.content.res.Resources.NotFoundException nameNotFoundException) {
      HMSLog.e("Util", "In getAppName, Failed to get app name.");
      return "";
    } 
  }
  
  public static String getCpId(Context paramContext) {
    return AGCUtils.getCpId(paramContext);
  }
  
  public static int getHmsVersion(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager == null) {
      HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
      return 0;
    } 
    try {
      ApplicationInfo applicationInfo = (packageManager.getPackageInfo(paramContext.getPackageName(), 128)).applicationInfo;
      if (applicationInfo != null && applicationInfo.metaData != null) {
        Object object = applicationInfo.metaData.get("com.huawei.hms.version");
        if (object != null) {
          object = String.valueOf(object);
          if (!TextUtils.isEmpty((CharSequence)object))
            return StringUtil.convertVersion2Integer((String)object); 
        } 
      } 
      HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
      return 0;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
      return 0;
    } 
  }
  
  public static String getNetType(Context paramContext) {
    return SystemUtils.getNetType(paramContext);
  }
  
  public static String getProcessName(Context paramContext, int paramInt) {
    return UIUtil.getProcessName(paramContext, paramInt);
  }
  
  @Deprecated
  public static String getProductCountry() {
    String str1 = "";
    String str2 = getSystemProperties("ro.product.locale.region", "");
    if (!TextUtils.isEmpty(str2))
      return str2; 
    str2 = getSystemProperties("ro.product.locale", "");
    if (!TextUtils.isEmpty(str2)) {
      int i = str2.lastIndexOf("-");
      if (i != -1)
        return str2.substring(i + 1); 
    } 
    str2 = SystemUtils.getLocalCountry();
    if (!TextUtils.isEmpty(str2))
      str1 = str2; 
    return str1;
  }
  
  public static String getSystemProperties(String paramString1, String paramString2) {
    return SystemUtils.getSystemProperties(paramString1, paramString2);
  }
  
  public static Activity getValidActivity(Activity paramActivity1, Activity paramActivity2) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 13
    //   4: aload_0
    //   5: astore_2
    //   6: aload_0
    //   7: invokevirtual isFinishing : ()Z
    //   10: ifeq -> 31
    //   13: aload_1
    //   14: ifnull -> 29
    //   17: aload_1
    //   18: invokevirtual isFinishing : ()Z
    //   21: ifeq -> 27
    //   24: goto -> 29
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: areturn
  }
  
  public static boolean isAvailableLibExist(Context paramContext) {
    synchronized (LOCK_OBJECT) {
      if (!availableInit) {
        boolean bool1 = false;
        boolean bool3 = false;
        boolean bool2 = false;
        PackageManager packageManager = paramContext.getPackageManager();
        if (packageManager == null) {
          HMSLog.e("Util", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
          try {
            Class.forName("com.huawei.hms.adapter.AvailableAdapter");
            bool1 = true;
          } catch (ClassNotFoundException classNotFoundException) {
            HMSLog.e("Util", "In isAvailableLibExist, Failed to find class AvailableAdapter.");
          } 
        } else {
          boolean bool = bool3;
          try {
            ApplicationInfo applicationInfo = (packageManager.getPackageInfo(classNotFoundException.getPackageName(), 128)).applicationInfo;
            bool1 = bool2;
            if (applicationInfo != null) {
              bool1 = bool2;
              bool = bool3;
              if (applicationInfo.metaData != null) {
                bool = bool3;
                Object object = applicationInfo.metaData.get("availableLoaded");
                bool1 = bool2;
                if (object != null) {
                  bool1 = bool2;
                  bool = bool3;
                  if (String.valueOf(object).equalsIgnoreCase("yes")) {
                    bool = bool3;
                    HMSLog.i("Util", "available exist: true");
                    bool1 = true;
                  } 
                } 
              } 
            } 
            bool = bool1;
            HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
            bool1 = bool;
          } 
        } 
        isAvailableAvailable = bool1;
        availableInit = true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("available exist: ");
      stringBuilder.append(isAvailableAvailable);
      HMSLog.i("Util", stringBuilder.toString());
      return isAvailableAvailable;
    } 
  }
  
  public static boolean isBackground(Context paramContext) {
    boolean bool2 = true;
    if (paramContext == null)
      return true; 
    ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
    KeyguardManager keyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
    boolean bool1 = bool2;
    if (activityManager != null) {
      if (keyguardManager == null)
        return true; 
      List list = activityManager.getRunningAppProcesses();
      if (list == null)
        return true; 
      String str = getProcessName(paramContext, Process.myPid());
      Iterator<ActivityManager.RunningAppProcessInfo> iterator = list.iterator();
      while (true) {
        bool1 = bool2;
        if (iterator.hasNext()) {
          ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
          if (TextUtils.equals(runningAppProcessInfo.processName, str)) {
            boolean bool;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("appProcess.importance is ");
            stringBuilder.append(runningAppProcessInfo.importance);
            HMSLog.i("Util", stringBuilder.toString());
            if (runningAppProcessInfo.importance == 100) {
              bool = true;
            } else {
              bool = false;
            } 
            boolean bool3 = keyguardManager.inKeyguardRestrictedInputMode();
            stringBuilder = new StringBuilder();
            stringBuilder.append("isForground is ");
            stringBuilder.append(bool);
            stringBuilder.append("***  isLockedState is ");
            stringBuilder.append(bool3);
            HMSLog.i("Util", stringBuilder.toString());
            bool1 = bool2;
            if (bool) {
              if (bool3)
                return true; 
              bool1 = false;
            } 
            break;
          } 
          continue;
        } 
        break;
      } 
    } 
    return bool1;
  }
  
  public static boolean isChinaROM() {
    return SystemUtils.isChinaROM();
  }
  
  public static boolean isEMUI() {
    return SystemUtils.isEMUI();
  }
  
  public static void unBindServiceCatchException(Context paramContext, ServiceConnection paramServiceConnection) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Trying to unbind service from ");
      stringBuilder.append(paramServiceConnection);
      HMSLog.i("Util", stringBuilder.toString());
      paramContext.unbindService(paramServiceConnection);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("On unBindServiceException:");
      stringBuilder.append(exception.getMessage());
      HMSLog.e("Util", stringBuilder.toString());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */