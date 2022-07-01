package com.huawei.hianalytics.ab.bc.bc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ab {
  private static Object ab(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    if (paramClass != null) {
      StringBuilder stringBuilder;
      if (paramArrayOfClass == null) {
        if (paramArrayOfObject != null)
          throw new ab("paramsType is null, but params is not null"); 
      } else if (paramArrayOfObject != null) {
        if (paramArrayOfClass.length != paramArrayOfObject.length) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("paramsType len:");
          stringBuilder.append(paramArrayOfClass.length);
          stringBuilder.append(" should equal params.len:");
          stringBuilder.append(paramArrayOfObject.length);
          throw new ab(stringBuilder.toString());
        } 
      } else {
        throw new ab("paramsType or params should be same");
      } 
      try {
        String str;
        Method method = stringBuilder.getMethod(paramString, paramArrayOfClass);
        try {
          return method.invoke(null, paramArrayOfObject);
        } catch (IllegalAccessException illegalAccessException) {
          str = "invokeStaticFun(): method invoke Exception!";
          com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", str);
          return null;
        } catch (IllegalArgumentException illegalArgumentException) {
        
        } catch (InvocationTargetException invocationTargetException) {
          str = "invokeStaticFun(): Invocation Target Exception!";
        } 
        com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", str);
        return null;
      } catch (NoSuchMethodException noSuchMethodException) {
        com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        return null;
      } 
    } 
    throw new ab("class is null in invokeStaticFun");
  }
  
  private static Object ab(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    String str;
    try {
      return ab(Class.forName(paramString1), paramString2, paramArrayOfClass, paramArrayOfObject);
    } catch (ClassNotFoundException classNotFoundException) {
      str = "invokeStaticFun() Not found class!";
    } catch (ab ab1) {
      str = "invokeStaticFun(): Static function call Exception ";
    } 
    com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", str);
    return null;
  }
  
  public static String ab() {
    return ab("ro.build.version.emui", "");
  }
  
  public static String ab(Context paramContext) {
    return (paramContext == null) ? "" : Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String ab(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return paramString2; 
    String str2 = ab("android.os.SystemProperties", paramString1, paramString2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = ab("com.huawei.android.os.SystemPropertiesEx", paramString1, paramString2); 
    return str1;
  }
  
  private static String ab(String paramString1, String paramString2, String paramString3) {
    Object object = ab(paramString1, "get", new Class[] { String.class, String.class }, new Object[] { paramString2, paramString3 });
    if (object != null)
      paramString3 = (String)object; 
    return paramString3;
  }
  
  public static String bc() {
    String str2 = ab("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SystemPropertiesEx: get rom_ver: ");
    stringBuilder.append(str2);
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", stringBuilder.toString());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Build.DISPLAY;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("SystemProperties: get rom_ver: ");
      stringBuilder1.append(str1);
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", stringBuilder1.toString());
    } 
    return str1;
  }
  
  public static String bc(Context paramContext) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null && applicationInfo.metaData != null) {
        Object object = applicationInfo.metaData.get("CHANNEL");
        if (object != null) {
          object = object.toString();
          int i = object.length();
          return (String)((i > 256) ? "Unknown" : object);
        } 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "getChannel(): The packageName is not correct!");
    } 
    return "Unknown";
  }
  
  public static String cd(Context paramContext) {
    return (paramContext == null) ? "" : paramContext.getPackageName();
  }
  
  public static String de(Context paramContext) {
    if (paramContext == null)
      return ""; 
    try {
      return (paramContext.getPackageManager().getPackageInfo(cd(paramContext), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "getVersion(): The package name is not correct!");
      return "";
    } 
  }
  
  static class ab extends Exception {
    ab(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\bc\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */