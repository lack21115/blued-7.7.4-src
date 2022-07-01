package com.huawei.hms.support.api.push.pushselfshow.utils;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommFun {
  public static final long CLEAR_FILES_INTERVAL = 86400000L;
  
  public static final String TAG = "PushSelfShowLog";
  
  public static void cancelNotificationAlarm(Context paramContext, Intent paramIntent) {
    try {
      int i = paramIntent.getIntExtra("selfshow_auto_clear_id", 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setDelayAlarm(cancel) alarmNotityId ");
      stringBuilder.append(i);
      HMSLog.d("PushSelfShowLog", stringBuilder.toString());
      if (i == 0)
        return; 
      Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
      intent.setPackage(paramContext.getPackageName()).setFlags(32);
      AlarmManager alarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      PendingIntent pendingIntent = PendingIntent.getBroadcast(paramContext, i, intent, 536870912);
      if (pendingIntent != null && alarmManager != null) {
        HMSLog.d("PushSelfShowLog", "alarm cancel");
        alarmManager.cancel(pendingIntent);
        return;
      } 
      HMSLog.d("PushSelfShowLog", "alarm not exist");
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cancelAlarm err:");
      stringBuilder.append(exception.toString());
      HMSLog.e("PushSelfShowLog", stringBuilder.toString());
      return;
    } 
  }
  
  public static void delete(File paramFile) throws IOException {
    if (paramFile == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("delete file ");
    stringBuilder.append(paramFile.getCanonicalPath());
    HMSLog.d("PushSelfShowLog", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramFile.getCanonicalPath());
    stringBuilder.append(System.currentTimeMillis());
    File file = new File(stringBuilder.toString());
    if (!paramFile.renameTo(file))
      return; 
    if (file.isFile() && file.delete())
      return; 
    if (file.isDirectory()) {
      File[] arrayOfFile = file.listFiles();
      if (arrayOfFile == null || arrayOfFile.length == 0) {
        if (!file.delete())
          HMSLog.d("PushSelfShowLog", "delete file failed"); 
        return;
      } 
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++)
        delete(arrayOfFile[i]); 
      if (!file.delete()) {
        HMSLog.d("PushSelfShowLog", "delete file unsuccess");
        return;
      } 
    } 
  }
  
  public static void deleteFileBefore(File paramFile) {
    HMSLog.d("PushSelfShowLog", "delete file before ");
    if (paramFile != null && paramFile.exists()) {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null) {
        if (arrayOfFile.length == 0)
          return; 
        long l = System.currentTimeMillis();
        for (int i = 0; i < arrayOfFile.length; i++) {
          File file = arrayOfFile[i];
          try {
            if (l - file.lastModified() > 86400000L) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("delete file before ");
              stringBuilder.append(file.getCanonicalPath());
              HMSLog.i("PushSelfShowLog", stringBuilder.toString());
              delete(file);
            } 
          } catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete file failed.");
            stringBuilder.append(exception.toString());
            HMSLog.e("PushSelfShowLog", stringBuilder.toString());
          } 
        } 
      } 
    } 
  }
  
  public static Boolean findActivityByIntent(Context paramContext, String paramString, Intent paramIntent) {
    try {
      List list = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
      if (list != null && list.size() > 0) {
        int j = list.size();
        for (int i = 0; i < j; i++) {
          if (((ResolveInfo)list.get(i)).activityInfo != null && paramString.equals(((ResolveInfo)list.get(i)).activityInfo.applicationInfo.packageName))
            return Boolean.valueOf(true); 
        } 
      } 
    } catch (Exception exception) {
      HMSLog.e("PushSelfShowLog", exception.toString(), exception);
    } 
    return Boolean.valueOf(false);
  }
  
  public static long getAPDelayTime(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    long l = 0L;
    try {
      Date date = new Date();
      int j = date.getHours() * 2 + date.getMinutes() / 30;
      str = str.concat(str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("startIndex is ");
      stringBuilder.append(j);
      stringBuilder.append(",ap is:");
      stringBuilder.append(str);
      stringBuilder.append(",length is:");
      stringBuilder.append(str.length());
      HMSLog.i("PushSelfShowLog", stringBuilder.toString());
      int k = str.length();
      for (int i = j; i < k; i++) {
        if (str.charAt(i) != '0') {
          long l1 = 60000L * ((i - j) * 30 - date.getMinutes() % 30);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("startIndex is:");
          stringBuilder1.append(j);
          stringBuilder1.append(" i is:");
          stringBuilder1.append(i);
          stringBuilder1.append(" delay:");
          stringBuilder1.append(l1);
          HMSLog.d("PushSelfShowLog", stringBuilder1.toString());
          if (l1 >= 0L)
            l = l1; 
          return l;
        } 
      } 
    } catch (Exception exception) {
      HMSLog.e("PushSelfShowLog", "error ", exception);
    } 
    return 0L;
  }
  
  public static String getAppName(Context paramContext, String paramString) {
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      return packageManager.getApplicationLabel(packageManager.getApplicationInfo(paramString, 128)).toString();
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get the app name of package:");
      stringBuilder.append(paramString);
      stringBuilder.append(" failed.");
      HMSLog.i("PushSelfShowLog", stringBuilder.toString());
      return null;
    } 
  }
  
  public static long getIntMetaValue(ResolveInfo paramResolveInfo, String paramString) {
    if (paramResolveInfo == null)
      return -1L; 
    try {
      String str = getStringMetaValue(paramResolveInfo, paramString);
      return (str != null) ? ((str.length() == 0) ? -1L : Long.parseLong(str)) : -1L;
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" is not set in ");
      stringBuilder.append(getPkgName(paramResolveInfo));
      HMSLog.i("PushSelfShowLog", stringBuilder.toString());
      return -1L;
    } 
  }
  
  public static String getPkgName(ResolveInfo paramResolveInfo) {
    ServiceInfo serviceInfo = paramResolveInfo.serviceInfo;
    return (serviceInfo != null) ? serviceInfo.packageName : paramResolveInfo.activityInfo.packageName;
  }
  
  public static String getStringMetaValue(ResolveInfo paramResolveInfo, String paramString) {
    Bundle bundle;
    ServiceInfo serviceInfo = paramResolveInfo.serviceInfo;
    if (serviceInfo != null) {
      bundle = serviceInfo.metaData;
    } else {
      bundle = ((ResolveInfo)bundle).activityInfo.metaData;
    } 
    return (bundle == null) ? null : bundle.getString(paramString);
  }
  
  public static long getVersion(Context paramContext) {
    HMSLog.d("PushSelfShowLog", "enter getVersion()");
    long l = -1000L;
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      List<ResolveInfo> list = packageManager.queryBroadcastReceivers((new Intent("com.huawei.android.push.intent.REGISTER")).setPackage(paramContext.getPackageName()), 640);
      if (list != null) {
        if (list.size() == 0)
          return -1000L; 
        ResolveInfo resolveInfo = list.get(0);
        long l1 = getIntMetaValue(resolveInfo, "CS_cloud_version");
        l = l1;
      } else {
        return -1000L;
      } 
    } catch (Exception exception) {
      HMSLog.e("PushSelfShowLog", exception.toString(), exception);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("get the version is :");
    stringBuilder.append(l);
    HMSLog.d("PushSelfShowLog", stringBuilder.toString());
    return l;
  }
  
  public static Intent hasActivity(Context paramContext, String paramString) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      return packageManager.getLaunchIntentForPackage(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("not have launch activity");
      HMSLog.w("PushSelfShowLog", stringBuilder.toString());
      return null;
    } 
  }
  
  public static boolean hasPermissionToStartActivity(Context paramContext, Intent paramIntent) {
    if (paramContext == null) {
      HMSLog.i("PushSelfShowLog", "context is null");
      return false;
    } 
    if (paramIntent == null) {
      HMSLog.i("PushSelfShowLog", "intent is null");
      return false;
    } 
    List list = paramContext.getPackageManager().queryIntentActivities(paramIntent, 640);
    if (list == null || list.size() == 0) {
      HMSLog.e("PushSelfShowLog", "no activity exist, may be system Err!! pkgName:");
      return false;
    } 
    boolean bool = ((ResolveInfo)list.get(0)).activityInfo.exported;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("exportedFlag:");
    stringBuilder.append(bool);
    HMSLog.i("PushSelfShowLog", stringBuilder.toString());
    String str = ((ResolveInfo)list.get(0)).activityInfo.permission;
    stringBuilder = new StringBuilder();
    stringBuilder.append("need permission:");
    stringBuilder.append(str);
    HMSLog.i("PushSelfShowLog", stringBuilder.toString());
    if (!bool)
      return false; 
    if (TextUtils.isEmpty(str))
      return true; 
    HMSLog.e("PushSelfShowLog", "does't have the permission to open this activity");
    return false;
  }
  
  public static boolean isCurrentHMS(Context paramContext) {
    return "com.huawei.hwid".equals(paramContext.getPackageName());
  }
  
  public static boolean isCurrentPushApk(Context paramContext) {
    return "com.huawei.android.pushagent".equals(paramContext.getPackageName());
  }
  
  public static boolean isExistPushApk(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    boolean bool = false;
    try {
      ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.huawei.android.pushagent", 128);
      if (applicationInfo != null)
        bool = true; 
      return bool;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  public static boolean isInstalled(Context paramContext, String paramString) {
    if (paramContext != null && paramString != null) {
      if ("".equals(paramString))
        return false; 
      try {
        ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
        if (applicationInfo == null)
          return false; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(" is installed");
        HMSLog.d("PushSelfShowLog", stringBuilder.toString());
        return true;
      } catch (Exception exception) {
        return false;
      } 
    } 
    return false;
  }
  
  public static boolean isPreferredPkg(Context paramContext, String paramString) {
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    paramContext.getPackageManager().getPreferredActivities(arrayList1, arrayList2, paramString);
    return (arrayList2.size() > 0);
  }
  
  public static boolean isSelf(Context paramContext, String paramString) {
    return paramContext.getPackageName().equals(paramString);
  }
  
  public static boolean isSupportLargeIcon() {
    return (Build.VERSION.SDK_INT >= 11);
  }
  
  public static ArrayList<String> lsAppmarketSuportCMD(Context paramContext) {
    ArrayList<String> arrayList = new ArrayList();
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setData(Uri.parse("market://details?id="));
    PackageManager packageManager = paramContext.getPackageManager();
    int i = 0;
    List list = packageManager.queryIntentActivities(intent, 0);
    if (list != null && list.size() != 0) {
      int j = list.size();
      while (i < j) {
        if (((ResolveInfo)list.get(i)).activityInfo != null)
          arrayList.add(((ResolveInfo)list.get(i)).activityInfo.applicationInfo.packageName); 
        i++;
      } 
    } 
    return arrayList;
  }
  
  public static void removeNotifiCationById(Context paramContext, int paramInt) {
    if (paramContext == null) {
      HMSLog.e("PushSelfShowLog", "context is null");
      return;
    } 
    try {
      NotificationManager notificationManager = (NotificationManager)paramContext.getSystemService("notification");
      if (notificationManager != null) {
        notificationManager.cancel(paramInt);
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("removeNotifiCationById err:");
      stringBuilder.append(exception.toString());
      HMSLog.e("PushSelfShowLog", stringBuilder.toString());
    } 
  }
  
  public static void setAPDelayAlarm(Context paramContext, Intent paramIntent, long paramLong) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("enter setAPDelayAlarm(intent:");
      stringBuilder.append(paramIntent.toURI());
      stringBuilder.append(" interval:");
      stringBuilder.append(paramLong);
      stringBuilder.append("ms, context:");
      stringBuilder.append(paramContext);
      HMSLog.d("PushSelfShowLog", stringBuilder.toString());
      AlarmManager alarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      if (alarmManager != null) {
        PendingIntent pendingIntent = PendingIntent.getBroadcast(paramContext, (int)(System.currentTimeMillis() / 1000L), paramIntent, 0);
        alarmManager.set(0, System.currentTimeMillis() + paramLong, pendingIntent);
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set DelayAlarm error");
      stringBuilder.append(exception.toString());
      HMSLog.w("PushSelfShowLog", stringBuilder.toString());
    } 
  }
  
  public static void startBrowserActivity(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      HMSLog.i("PushSelfShowLog", "url is null.");
      return;
    } 
    try {
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.setData(Uri.parse(paramString));
      intent.setFlags(402653184);
      List list = paramContext.getPackageManager().queryIntentActivities(intent, 0);
      String str = null;
      Iterator iterator = list.iterator();
      while (true) {
        paramString = str;
        if (iterator.hasNext()) {
          paramString = ((ResolveInfo)iterator.next()).activityInfo.packageName;
          boolean bool = isPreferredPkg(paramContext, paramString);
          if (bool)
            break; 
          continue;
        } 
        break;
      } 
      str = paramString;
      if (paramString == null) {
        Iterator iterator1 = list.iterator();
        while (true) {
          str = paramString;
          if (iterator1.hasNext()) {
            str = ((ResolveInfo)iterator1.next()).activityInfo.packageName;
            if ("com.android.browser".equalsIgnoreCase(str))
              break; 
            continue;
          } 
          break;
        } 
      } 
      if (str != null)
        intent.setPackage(str); 
      paramContext.startActivity(intent);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start browser activity failed, exception:");
      stringBuilder.append(exception.getMessage());
      HMSLog.e("PushSelfShowLog", stringBuilder.toString());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfsho\\utils\CommFun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */