package com.huawei.hms.support.api.push.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

public abstract class CommFun {
  public static final int EMUI_8_0_1 = 15;
  
  public static final int EMUI_9_1 = 19;
  
  public static final Object LOCK = new Object();
  
  public static final int PROFILE_NC_MIN_VERSION = 110001400;
  
  public static final String TAG = "CommFun";
  
  public static int existFrameworkPush = -1;
  
  public static boolean checkFrameworkPushExist(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("existFrameworkPush:");
    stringBuilder.append(existFrameworkPush);
    HMSLog.d("CommFun", stringBuilder.toString());
    try {
      stringBuilder = new StringBuilder();
      stringBuilder.append("/system/framework/");
      stringBuilder.append("hwpush.jar");
      File file = new File(stringBuilder.toString());
      boolean bool = isCustExistHwPush();
      if (bool) {
        HMSLog.d("CommFun", "push jarFile is exist");
      } else {
        if (file.isFile()) {
          HMSLog.d("CommFun", "push jarFile is exist");
          return true;
        } 
        return false;
      } 
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("get Apk version faild ,Exception e= ");
      stringBuilder1.append(exception.toString());
      HMSLog.e("CommFun", stringBuilder1.toString());
      return false;
    } 
  }
  
  public static String getApkVersionName(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      HMSLog.d("CommFun", "package not exist");
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getApkVersionName error");
      stringBuilder.append(exception.getMessage());
      HMSLog.e("CommFun", stringBuilder.toString());
    } 
    return "0.0";
  }
  
  public static long getNCVersionCode(Context paramContext) {
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      int i = (packageManager.getPackageInfo("com.huawei.android.pushagent", 0)).versionCode;
      return i;
    } catch (Exception exception) {
      HMSLog.e("CommFun", "get nc versionCode error");
      return -1L;
    } 
  }
  
  public static String getProjectId(Context paramContext) {
    return AGConnectServicesConfig.a(paramContext).a("client/project_id");
  }
  
  public static boolean isCustExistHwPush() {
    try {
      Class<?> clazz = Class.forName("huawei.cust.HwCfgFilePolicy");
      int i = ((Integer)clazz.getDeclaredField("CUST_TYPE_CONFIG").get(clazz)).intValue();
      Method method = clazz.getDeclaredMethod("getCfgFile", new Class[] { String.class, int.class });
      File file = (File)method.invoke(clazz, new Object[] { "jars/hwpush.jar", Integer.valueOf(i) });
      if (file != null && file.exists()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get push cust File path is ");
        stringBuilder.append(file.getCanonicalPath());
        HMSLog.d("CommFun", stringBuilder.toString());
        return true;
      } 
      return false;
    } catch (ClassNotFoundException classNotFoundException) {
      HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
      return false;
    } catch (SecurityException securityException) {
      HMSLog.e("CommFun", "check cust exist push SecurityException.");
      return false;
    } catch (NoSuchFieldException noSuchFieldException) {
      HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
      return false;
    } catch (NoSuchMethodException noSuchMethodException) {
      HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
      return false;
    } catch (IllegalArgumentException illegalArgumentException) {
      HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
      return false;
    } catch (IllegalAccessException illegalAccessException) {
      HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
      return false;
    } catch (InvocationTargetException invocationTargetException) {
      HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
      return false;
    } catch (IOException iOException) {
      HMSLog.e("CommFun", "check jarFile exist but get not path");
      return false;
    } 
  }
  
  public static boolean isEmui10Plus() {
    return (HwBuildEx.VERSION.EMUI_SDK_INT >= 21);
  }
  
  public static boolean isEmui8Plus() {
    return (HwBuildEx.VERSION.EMUI_SDK_INT >= 15);
  }
  
  public static boolean isEmui91Below() {
    return (HwBuildEx.VERSION.EMUI_SDK_INT < 19);
  }
  
  public static boolean isFrameworkPushExist(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("existFrameworkPush:");
    stringBuilder.append(existFrameworkPush);
    HMSLog.d("CommFun", stringBuilder.toString());
    synchronized (LOCK) {
      int i = existFrameworkPush;
      boolean bool2 = false;
      boolean bool1 = false;
      if (-1 != i) {
        if (1 == existFrameworkPush)
          bool1 = true; 
        return bool1;
      } 
      if (checkFrameworkPushExist(paramContext)) {
        existFrameworkPush = 1;
      } else {
        existFrameworkPush = 0;
      } 
      bool1 = bool2;
      if (1 == existFrameworkPush)
        bool1 = true; 
      return bool1;
    } 
  }
  
  public static boolean isInstalled(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      try {
        ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramString, 0);
        if (applicationInfo == null)
          return false; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(" is installed");
        HMSLog.d("CommFun", stringBuilder.toString());
        return true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        return false;
      } 
    } 
    return false;
  }
  
  public static boolean isOldMsg(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString) {
    return (paramJSONObject1 == null || (TextUtils.isEmpty(paramString) && paramJSONObject2 == null));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\pus\\utils\CommFun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */