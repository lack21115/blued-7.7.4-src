package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class o {
  public static DeleteTokenReq a(Context paramContext, String paramString) {
    return a(paramContext, null, null, paramString, null);
  }
  
  public static DeleteTokenReq a(Context paramContext, String paramString1, String paramString2) {
    return a(paramContext, paramString1, null, null, paramString2);
  }
  
  public static DeleteTokenReq a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    DeleteTokenReq deleteTokenReq = new DeleteTokenReq();
    deleteTokenReq.setAppId(paramString1);
    deleteTokenReq.setScope(paramString4);
    deleteTokenReq.setProjectId(paramString2);
    deleteTokenReq.setPkgName(paramContext.getPackageName());
    deleteTokenReq.setSubjectId(paramString3);
    if (TextUtils.isEmpty(paramString1))
      deleteTokenReq.setAppId(Util.getAppId(paramContext)); 
    if (TextUtils.isEmpty(paramString4))
      deleteTokenReq.setScope("HCM"); 
    if (TextUtils.isEmpty(paramString2))
      deleteTokenReq.setProjectId(d(paramContext)); 
    return deleteTokenReq;
  }
  
  public static String a(Context paramContext) {
    PushPreferences pushPreferences = new PushPreferences(paramContext, "aaid");
    return pushPreferences.containsKey("aaid") ? pushPreferences.getString("aaid") : null;
  }
  
  public static DeleteTokenReq b(Context paramContext) {
    return a(paramContext, null, null, null, null);
  }
  
  public static TokenReq b(Context paramContext, String paramString) {
    return b(paramContext, null, null, paramString, null);
  }
  
  public static TokenReq b(Context paramContext, String paramString1, String paramString2) {
    return b(paramContext, paramString1, null, null, paramString2);
  }
  
  public static TokenReq b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    TokenReq tokenReq = new TokenReq();
    tokenReq.setPackageName(paramContext.getPackageName());
    tokenReq.setAppId(paramString1);
    tokenReq.setScope(paramString4);
    tokenReq.setProjectId(paramString2);
    tokenReq.setSubjectId(paramString3);
    tokenReq.setMultiSender(false);
    if (TextUtils.isEmpty(paramString1))
      tokenReq.setAppId(Util.getAppId(paramContext)); 
    if (TextUtils.isEmpty(paramString2))
      tokenReq.setProjectId(d(paramContext)); 
    if (TextUtils.isEmpty(paramString4))
      tokenReq.setScope("HCM"); 
    i i = i.a(paramContext);
    if (!i.getBoolean("hasRequestAgreement")) {
      tokenReq.setFirstTime(true);
      i.saveBoolean("hasRequestAgreement", true);
      return tokenReq;
    } 
    tokenReq.setFirstTime(false);
    return tokenReq;
  }
  
  public static String c(Context paramContext) {
    // Byte code:
    //   0: ldc com/huawei/hms/opendevice/o
    //   2: monitorenter
    //   3: new com/huawei/hms/aaid/utils/PushPreferences
    //   6: dup
    //   7: aload_0
    //   8: ldc 'aaid'
    //   10: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 'aaid'
    //   17: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   20: ifeq -> 33
    //   23: aload_1
    //   24: ldc 'aaid'
    //   26: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_0
    //   30: goto -> 60
    //   33: invokestatic randomUUID : ()Ljava/util/UUID;
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: astore_0
    //   40: aload_1
    //   41: ldc 'aaid'
    //   43: aload_0
    //   44: invokevirtual saveString : (Ljava/lang/String;Ljava/lang/String;)Z
    //   47: pop
    //   48: aload_1
    //   49: ldc 'creationTime'
    //   51: invokestatic currentTimeMillis : ()J
    //   54: invokestatic valueOf : (J)Ljava/lang/Long;
    //   57: invokevirtual saveLong : (Ljava/lang/String;Ljava/lang/Long;)V
    //   60: ldc com/huawei/hms/opendevice/o
    //   62: monitorexit
    //   63: aload_0
    //   64: areturn
    //   65: astore_0
    //   66: ldc com/huawei/hms/opendevice/o
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	65	finally
    //   33	60	65	finally
  }
  
  public static String d(Context paramContext) {
    return AGConnectServicesConfig.a(paramContext).a("client/project_id");
  }
  
  public static boolean e(Context paramContext) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null) {
        if (applicationInfo.metaData == null)
          return false; 
        Bundle bundle = applicationInfo.metaData;
        boolean bool = TextUtils.isEmpty(bundle.getString("com.huawei.hms.client.service.name:base"));
        if (bool)
          return false; 
      } else {
        return false;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      HMSLog.e(HmsInstanceId.TAG, "isIntegratedBaseSdk failed.");
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */