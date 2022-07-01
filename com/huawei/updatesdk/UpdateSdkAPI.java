package com.huawei.updatesdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.a.a.c.i.b;
import com.huawei.updatesdk.a.b.a.a;
import com.huawei.updatesdk.b.b.a;
import com.huawei.updatesdk.b.e.a.b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import com.huawei.updatesdk.service.otaupdate.d;
import com.huawei.updatesdk.service.otaupdate.e;
import com.huawei.updatesdk.service.otaupdate.g;
import com.huawei.updatesdk.service.otaupdate.h;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Executors;

public final class UpdateSdkAPI {
  public static final String TAG = "UpdateSdk";
  
  public static void checkAppUpdate(Context paramContext, CheckUpdateCallBack paramCheckUpdateCallBack, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramContext == null)
      return; 
    if (b.d(paramContext)) {
      init(paramContext);
      (new e(paramContext, (new UpdateParams.Builder()).setIsShowImmediate(paramBoolean1).setMustBtnOne(paramBoolean2).build(), paramCheckUpdateCallBack)).executeOnExecutor(Executors.newSingleThreadExecutor(), (Object[])new Void[0]);
      return;
    } 
    if (paramCheckUpdateCallBack != null) {
      Intent intent = new Intent();
      intent.putExtra("status", 2);
      paramCheckUpdateCallBack.onUpdateInfo(intent);
    } 
    Toast.makeText(paramContext, g.e(paramContext, "upsdk_no_available_network_prompt_toast"), 0).show();
  }
  
  public static void checkAppUpdate(Context paramContext, UpdateParams paramUpdateParams, CheckUpdateCallBack paramCheckUpdateCallBack) {
    if (paramContext != null && paramUpdateParams != null) {
      if (paramCheckUpdateCallBack == null)
        return; 
      init(paramContext);
      paramUpdateParams.resetParamList();
      checkAppUpdateForHMSKit(paramContext, paramUpdateParams, paramCheckUpdateCallBack);
    } 
  }
  
  public static void checkAppUpdateByAppInfo(Context paramContext, CheckUpdateCallBack paramCheckUpdateCallBack, AppInfoAdapter paramAppInfoAdapter) {
    h h;
    String str;
    if (paramContext == null)
      return; 
    UpdateParams.Builder builder = new UpdateParams.Builder();
    if (paramAppInfoAdapter != null && !TextUtils.isEmpty(paramAppInfoAdapter.getAppStorePkgName())) {
      h = h.g();
      str = paramAppInfoAdapter.getBusiness();
    } else {
      h = h.g();
      str = null;
    } 
    h.c(str);
    if (paramAppInfoAdapter != null) {
      if (!TextUtils.isEmpty(paramAppInfoAdapter.getServiceZone()))
        builder.setServiceZone(paramAppInfoAdapter.getServiceZone()); 
      setAppStorePkgName(paramAppInfoAdapter.getAppStorePkgName());
      builder.setTargetPkgName(paramAppInfoAdapter.getTargetPkgName()).setPackageList(paramAppInfoAdapter.getPackageList()).setMustBtnOne(paramAppInfoAdapter.isMustBtnOne()).setIsShowImmediate(paramAppInfoAdapter.isShowImmediate()).setMinIntervalDay(paramAppInfoAdapter.getMinIntervalDay());
    } 
    checkAppUpdate(paramContext, builder.build(), paramCheckUpdateCallBack);
  }
  
  public static void checkAppUpdateForHMSKit(Context paramContext, UpdateParams paramUpdateParams, CheckUpdateCallBack paramCheckUpdateCallBack) {
    if (paramContext != null && paramUpdateParams != null) {
      if (paramCheckUpdateCallBack == null)
        return; 
      init(paramContext);
      long l1 = System.currentTimeMillis();
      long l2 = a.c().b();
      if (paramUpdateParams.getMinIntervalDay() == 0 || Math.abs(l1 - l2) >= paramUpdateParams.getMinIntervalDay() * 86400000L) {
        if (b.d(paramContext)) {
          a.c().a(l1);
          (new e(paramContext, paramUpdateParams, paramCheckUpdateCallBack)).executeOnExecutor(Executors.newSingleThreadExecutor(), (Object[])new Void[0]);
          return;
        } 
        Intent intent = new Intent();
        intent.putExtra("status", 2);
        paramCheckUpdateCallBack.onUpdateInfo(intent);
      } 
    } 
  }
  
  public static void checkClientOTAUpdate(Context paramContext, CheckUpdateCallBack paramCheckUpdateCallBack, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
    if (paramContext != null) {
      if (!b.d(paramContext))
        return; 
      init(paramContext);
      long l1 = System.currentTimeMillis();
      long l2 = a.c().b();
      if (paramInt == 0 || Math.abs(l1 - l2) >= paramInt * 86400000L) {
        a.c().a(l1);
        e e = new e(paramContext, (new UpdateParams.Builder()).setIsShowImmediate(paramBoolean1).setMustBtnOne(paramBoolean2).setMinIntervalDay(paramInt).build(), paramCheckUpdateCallBack);
        e.a(true);
        e.executeOnExecutor(Executors.newSingleThreadExecutor(), (Object[])new Void[0]);
      } 
    } 
  }
  
  public static void checkTargetAppUpdate(Context paramContext, String paramString, CheckUpdateCallBack paramCheckUpdateCallBack) {
    if (paramContext == null || TextUtils.isEmpty(paramString) || paramCheckUpdateCallBack == null) {
      if (paramCheckUpdateCallBack != null) {
        intent = new Intent();
        intent.putExtra("status", 1);
        paramCheckUpdateCallBack.onUpdateInfo(intent);
      } 
      return;
    } 
    if (b.d((Context)intent)) {
      init((Context)intent);
      (new e((Context)intent, (new UpdateParams.Builder()).setMustBtnOne(false).setTargetPkgName(paramString).build(), paramCheckUpdateCallBack)).executeOnExecutor(Executors.newSingleThreadExecutor(), (Object[])new Void[0]);
      return;
    } 
    Intent intent = new Intent();
    intent.putExtra("status", 2);
    paramCheckUpdateCallBack.onUpdateInfo(intent);
  }
  
  private static void init(Context paramContext) {
    a.a(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UpdateSDK version is: 2.0.7.302 ,flavor: envrelease ,pkgName: ");
    stringBuilder.append(paramContext.getPackageName());
    Log.i("updatesdk", stringBuilder.toString());
  }
  
  public static void releaseCallBack() {
    d.a().a(null);
    List list = b.a();
    if (list != null) {
      if (list.isEmpty())
        return; 
      for (AsyncTask asyncTask : list) {
        if (asyncTask != null)
          asyncTask.cancel(true); 
        Log.d("UpdateSdk", "cancel task");
      } 
      list.clear();
    } 
  }
  
  public static void setAppStorePkgName(String paramString) {
    h.g().d(paramString);
  }
  
  public static void setServiceZone(String paramString) {
    h.g().b(paramString);
  }
  
  public static void showUpdateDialog(Context paramContext, ApkUpgradeInfo paramApkUpgradeInfo, boolean paramBoolean) {
    if (paramContext != null) {
      String str;
      StringBuilder stringBuilder;
      if (paramApkUpgradeInfo == null)
        return; 
      Intent intent = new Intent(paramContext, AppUpdateActivity.class);
      Bundle bundle = new Bundle();
      bundle.putSerializable("app_update_parm", (Serializable)paramApkUpgradeInfo);
      bundle.putBoolean("app_must_btn", paramBoolean);
      intent.putExtras(bundle);
      if (!(paramContext instanceof android.app.Activity))
        intent.setFlags(268435456); 
      try {
        paramContext.startActivity(intent);
        return;
      } catch (ActivityNotFoundException activityNotFoundException) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("go AppUpdateActivity error: ");
        str = activityNotFoundException.toString();
      } catch (SecurityException securityException) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("go AppUpdateActivity security error: ");
        str = securityException.toString();
      } 
      stringBuilder.append(str);
      Log.e("UpdateSdk", stringBuilder.toString());
    } 
  }
  
  public static void showUpdateDialogByAppInfo(Context paramContext, ApkUpgradeInfo paramApkUpgradeInfo, AppInfoAdapter paramAppInfoAdapter) {
    boolean bool;
    if (paramAppInfoAdapter != null && !TextUtils.isEmpty(paramAppInfoAdapter.getAppStorePkgName()) && !TextUtils.equals(h.g().c(), paramAppInfoAdapter.getAppStorePkgName()))
      h.g().d(paramAppInfoAdapter.getAppStorePkgName()); 
    if (paramAppInfoAdapter != null && !TextUtils.isEmpty(paramAppInfoAdapter.getAppStorePkgName()))
      h.g().c(paramAppInfoAdapter.getBusiness()); 
    if (paramAppInfoAdapter != null && paramAppInfoAdapter.isMustBtnOne()) {
      bool = true;
    } else {
      bool = false;
    } 
    showUpdateDialog(paramContext, paramApkUpgradeInfo, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\UpdateSdkAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */