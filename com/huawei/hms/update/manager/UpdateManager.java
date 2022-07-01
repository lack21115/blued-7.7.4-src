package com.huawei.hms.update.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.update.ui.a;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class UpdateManager {
  private static void a(Activity paramActivity, ArrayList<Integer> paramArrayList) {
    if (a((Context)paramActivity, "com.huawei.appmarket") && !"com.huawei.appmarket".equals(paramActivity.getPackageName())) {
      paramArrayList.add(Integer.valueOf(5));
      return;
    } 
    paramArrayList.add(Integer.valueOf(4));
  }
  
  private static void a(Context paramContext, ArrayList<Integer> paramArrayList) {
    if (SystemUtils.isTVDevice()) {
      paramArrayList.add(Integer.valueOf(5));
      return;
    } 
    if (SystemUtils.isSystemApp(paramContext.getApplicationContext(), "com.huawei.appmarket") && c(paramContext) && SystemUtils.isChinaROM()) {
      paramArrayList.add(Integer.valueOf(0));
      return;
    } 
    b(paramContext, paramArrayList);
  }
  
  private static boolean a(Context paramContext) {
    if (paramContext == null) {
      HMSLog.i("UpdateManager", "In isAgNewVersion, context is null.");
      return false;
    } 
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        ApplicationInfo applicationInfo = (packageManager.getPackageInfo("com.huawei.appmarket", 128)).applicationInfo;
        if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("com.huawei.hms.client.service.name:base")) {
          String str = applicationInfo.metaData.getString("com.huawei.hms.client.service.name:base");
          if (!TextUtils.isEmpty(str)) {
            String[] arrayOfString = str.split(":");
            if (arrayOfString.length == 2) {
              int i = StringUtil.convertVersion2Integer(arrayOfString[1]);
              if (i >= 50004100)
                return true; 
            } 
          } 
        } 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        HMSLog.e("UpdateManager", "In isAgNewVersion, Failed to read meta data from base version setting channel.");
      }  
    HMSLog.i("UpdateManager", "In isAgNewVersion, configuration not found for base version setting");
    return false;
  }
  
  private static boolean a(Context paramContext, String paramString) {
    PackageManagerHelper.PackageStates packageStates = (new PackageManagerHelper(paramContext)).getPackageStates(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("app is: ");
    stringBuilder.append(paramString);
    stringBuilder.append(";status is:");
    stringBuilder.append(packageStates);
    HMSLog.i("UpdateManager", stringBuilder.toString());
    return (PackageManagerHelper.PackageStates.ENABLED == packageStates);
  }
  
  private static void b(Context paramContext, ArrayList<Integer> paramArrayList) {
    if (a(paramContext, "com.huawei.appmarket") && !"com.huawei.appmarket".equals(paramContext.getPackageName()) && a(paramContext)) {
      paramArrayList.add(Integer.valueOf(5));
      return;
    } 
    if (d(paramContext)) {
      paramArrayList.add(Integer.valueOf(7));
      return;
    } 
    if (!b(paramContext))
      paramArrayList.add(Integer.valueOf(6)); 
  }
  
  private static boolean b(Context paramContext) {
    if (paramContext == null) {
      HMSLog.e("UpdateManager", "In getAndroidMarketSetting, context is null.");
      return true;
    } 
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        ApplicationInfo applicationInfo = (packageManager.getPackageInfo(paramContext.getPackageName(), 128)).applicationInfo;
        if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("com.huawei.hms.client.channel.androidMarket"))
          return applicationInfo.metaData.getBoolean("com.huawei.hms.client.channel.androidMarket", true); 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        HMSLog.e("UpdateManager", "In getAndroidMarketSetting, Failed to read meta data from android market channel.");
      }  
    HMSLog.i("UpdateManager", "In getAndroidMarketSetting, configuration not found for android channel market setting.");
    return true;
  }
  
  private static void c(Context paramContext, ArrayList<Integer> paramArrayList) {
    if (a(paramContext, "com.huawei.appmarket") && !"com.huawei.appmarket".equals(paramContext.getPackageName())) {
      paramArrayList.add(Integer.valueOf(5));
      return;
    } 
    paramArrayList.add(Integer.valueOf(4));
  }
  
  private static boolean c(Context paramContext) {
    int i = (new PackageManagerHelper(paramContext)).getPackageVersionCode("com.huawei.appmarket");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getHiappVersion is ");
    stringBuilder.append(i);
    HMSLog.i("UpdateManager", stringBuilder.toString());
    return (i >= 70203000L);
  }
  
  private static boolean d(Context paramContext) {
    // Byte code:
    //   0: new android/content/Intent
    //   3: dup
    //   4: ldc 'com.apptouch.intent.action.update_hms'
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   14: astore_3
    //   15: iconst_0
    //   16: istore_1
    //   17: aload_3
    //   18: aload_2
    //   19: iconst_0
    //   20: invokevirtual queryIntentServices : (Landroid/content/Intent;I)Ljava/util/List;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull -> 98
    //   28: aload_2
    //   29: invokeinterface isEmpty : ()Z
    //   34: ifne -> 98
    //   37: aload_2
    //   38: invokeinterface iterator : ()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface hasNext : ()Z
    //   50: ifeq -> 98
    //   53: aload_3
    //   54: invokeinterface next : ()Ljava/lang/Object;
    //   59: checkcast android/content/pm/ResolveInfo
    //   62: getfield serviceInfo : Landroid/content/pm/ServiceInfo;
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull -> 44
    //   70: aload_2
    //   71: getfield packageName : Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   79: ifne -> 44
    //   82: aload_0
    //   83: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   86: aload_2
    //   87: invokestatic isSystemApp : (Landroid/content/Context;Ljava/lang/String;)Z
    //   90: ifeq -> 44
    //   93: aload_2
    //   94: astore_0
    //   95: goto -> 100
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull -> 106
    //   104: iconst_1
    //   105: istore_1
    //   106: iload_1
    //   107: ireturn
  }
  
  public static Intent getStartUpdateIntent(Activity paramActivity, UpdateBean paramUpdateBean) {
    if (paramActivity == null || paramUpdateBean == null)
      return null; 
    ArrayList<Integer> arrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramUpdateBean.getClientAppName())) {
      a((Context)paramActivity, arrayList);
    } else {
      a(paramActivity, arrayList);
    } 
    int i = -2;
    if (arrayList.size() > 0) {
      i = ((Integer)arrayList.get(0)).intValue();
    } else {
      HMSLog.i("UpdateManager", "typeList is empty, no upgrade solution");
    } 
    paramUpdateBean.setTypeList(arrayList);
    Intent intent = BridgeActivity.getIntentStartBridgeActivity(paramActivity, a.a(i));
    intent.putExtra("intent.extra.update.info", (Serializable)paramUpdateBean);
    return intent;
  }
  
  public static Intent getStartUpdateIntent(Context paramContext, UpdateBean paramUpdateBean) {
    if (paramContext == null || paramUpdateBean == null)
      return null; 
    ArrayList<Integer> arrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramUpdateBean.getClientAppName())) {
      a(paramContext, arrayList);
    } else {
      c(paramContext, arrayList);
    } 
    int i = -2;
    if (arrayList.size() > 0) {
      i = ((Integer)arrayList.get(0)).intValue();
    } else {
      HMSLog.i("UpdateManager", "typeList is empty, no upgrade solution");
    } 
    paramUpdateBean.setTypeList(arrayList);
    Intent intent = BridgeActivity.getIntentStartBridgeActivity(paramContext, a.a(i));
    intent.putExtra("intent.extra.update.info", (Serializable)paramUpdateBean);
    return intent;
  }
  
  public static void startUpdate(Activity paramActivity, int paramInt, UpdateBean paramUpdateBean) {
    Intent intent = getStartUpdateIntent(paramActivity, paramUpdateBean);
    if (intent != null)
      paramActivity.startActivityForResult(intent, paramInt); 
  }
  
  public static Intent startUpdateIntent(Activity paramActivity) {
    Intent intent;
    if (paramActivity == null)
      return null; 
    UpdateBean updateBean = new UpdateBean();
    updateBean.setHmsOrApkUpgrade(true);
    updateBean.setClientPackageName(HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHMSPackageName());
    updateBean.setClientVersionCode(HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHmsVersionCode());
    updateBean.setClientAppId("C10132067");
    updateBean.setNeedConfirm(false);
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext()); 
    updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    ArrayList<Integer> arrayList = new ArrayList();
    if (!TextUtils.isEmpty(updateBean.getClientAppName())) {
      a((Context)paramActivity, arrayList);
    } else {
      a(paramActivity, arrayList);
    } 
    updateBean.setTypeList(arrayList);
    if (arrayList.size() > 1) {
      intent = BridgeActivity.getIntentStartBridgeActivity(paramActivity, a.a(((Integer)arrayList.get(1)).intValue()));
    } else {
      int i = -2;
      if (arrayList.size() > 0) {
        i = ((Integer)arrayList.get(0)).intValue();
      } else {
        HMSLog.i("UpdateManager", "typeList is empty, no upgrade solution");
      } 
      intent = BridgeActivity.getIntentStartBridgeActivity((Activity)intent, a.a(i));
    } 
    intent.putExtra("intent.extra.update.info", (Serializable)updateBean);
    return intent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\manager\UpdateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */