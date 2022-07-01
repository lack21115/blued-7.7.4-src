package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.a.a.d;
import com.huawei.hms.update.a.c;
import com.huawei.hms.update.a.d;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.File;
import java.io.Serializable;

public class l extends a implements b {
  private a k;
  
  private c l;
  
  private int m = 0;
  
  private static Uri a(Context paramContext, File paramFile) {
    PackageManagerHelper packageManagerHelper = new PackageManagerHelper(paramContext);
    String str1 = paramContext.getPackageName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(".hms.update.provider");
    String str2 = stringBuilder.toString();
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i <= 23 || ((paramContext.getApplicationInfo()).targetSdkVersion <= 23 && !packageManagerHelper.hasProvider(str1, str2)))
      bool = false; 
    return bool ? UpdateProvider.getUriForFile(paramContext, str2, paramFile) : Uri.fromFile(paramFile);
  }
  
  private void a(Intent paramIntent, b paramb) {
    try {
      int i = paramIntent.getIntExtra("status", -99);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CheckUpdateCallBack status is ");
      stringBuilder.append(i);
      HMSLog.i("UpdateWizard", stringBuilder.toString());
      String str = paramIntent.getStringExtra("failreason");
      if (!TextUtils.isEmpty(str)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("checkTargetAppUpdate reason is ");
        stringBuilder1.append(str);
        HMSLog.e("UpdateWizard", stringBuilder1.toString());
      } 
      if (i == 7) {
        Serializable serializable = paramIntent.getSerializableExtra("updatesdk_update_info");
        if (serializable instanceof ApkUpgradeInfo) {
          ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo)serializable;
          serializable = apkUpgradeInfo.getPackage_();
          i = apkUpgradeInfo.getVersionCode_();
          str = apkUpgradeInfo.getDownurl_();
          int j = apkUpgradeInfo.getSize_();
          String str1 = apkUpgradeInfo.getSha256_();
          if (TextUtils.isEmpty((CharSequence)serializable) || !serializable.equals(this.c.b())) {
            a(paramb, 1201, (c)null);
            return;
          } 
          if (i < this.c.c()) {
            serializable = new StringBuilder();
            serializable.append("CheckUpdateCallBack versionCode is ");
            serializable.append(i);
            serializable.append("bean.getClientVersionCode() is ");
            serializable.append(this.c.c());
            HMSLog.e("UpdateWizard", serializable.toString());
            a(paramb, 1203, (c)null);
            return;
          } 
          if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str1)) {
            a(paramb, 1201, (c)null);
            return;
          } 
          a(paramb, 1000, new c((String)serializable, i, str, j, str1));
          return;
        } 
      } else {
        if (i == 3) {
          a(paramb, 1202, (c)null);
          return;
        } 
        a(paramb, 1201, (c)null);
      } 
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("intent has some error");
      stringBuilder.append(exception.getMessage());
      HMSLog.e("UpdateWizard", stringBuilder.toString());
      a(paramb, 1201, (c)null);
      return;
    } 
  }
  
  private void a(b paramb) {
    if (paramb == null)
      return; 
    Activity activity = b();
    if (activity == null || activity.isFinishing()) {
      a(paramb, 1201, (c)null);
      return;
    } 
    if (!a(activity))
      return; 
    UpdateSdkAPI.checkTargetAppUpdate((Context)activity, this.c.b(), new CheckUpdateCallBack(this, paramb) {
          public void onMarketInstallInfo(Intent param1Intent) {}
          
          public void onMarketStoreError(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onMarketStoreError responseCode: ");
            stringBuilder.append(param1Int);
            HMSLog.e("UpdateWizard", stringBuilder.toString());
          }
          
          public void onUpdateInfo(Intent param1Intent) {
            if (param1Intent != null)
              l.a(this.b, param1Intent, this.a); 
          }
          
          public void onUpdateStoreError(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onUpdateStoreError responseCode: ");
            stringBuilder.append(param1Int);
            HMSLog.e("UpdateWizard", stringBuilder.toString());
          }
        });
  }
  
  private static void a(b paramb, int paramInt, c paramc) {
    if (paramb != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(paramb, paramInt, paramc) {
            public void run() {
              this.a.a(this.b, this.c);
            }
          }); 
  }
  
  private void a(File paramFile) {
    Activity activity = b();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      Uri uri = a((Context)activity, paramFile);
      if (uri == null) {
        HMSLog.e("UpdateWizard", "In startInstaller, Failed to creates a Uri from a file.");
        e();
        return;
      } 
      if (!a(activity))
        return; 
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.setDataAndType(uri, "application/vnd.android.package-archive");
      intent.setFlags(3);
      intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
      try {
        activity.startActivityForResult(intent, getRequestCode());
        return;
      } catch (ActivityNotFoundException activityNotFoundException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("In startInstaller, Failed to start package installer.");
        stringBuilder.append(activityNotFoundException.getMessage());
        HMSLog.e("UpdateWizard", stringBuilder.toString());
        e();
      } 
    } 
  }
  
  private boolean a(Activity paramActivity) {
    if (HMSPackageManager.getInstance((Context)paramActivity).isApkUpdateNecessary(this.c.c()))
      return true; 
    c();
    SystemManager.getInstance().notifyUpdateResult(0);
    return false;
  }
  
  private void d() {
    String str;
    Activity activity = b();
    if (activity != null) {
      str = SystemUtils.getNetType(activity.getBaseContext());
    } else {
      str = "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("current network is ");
    stringBuilder.append(str);
    HMSLog.i("UpdateWizard", stringBuilder.toString());
    if ("WIFI".equals(str)) {
      a((Class)f.class);
      f();
      HMSLog.i("UpdateWizard", "current network is wifi");
      return;
    } 
    a((Class)e.b.class);
    HMSLog.i("UpdateWizard", "current network is not wifi");
  }
  
  private void e() {
    if (!a(false)) {
      b(8, this.f);
      return;
    } 
    a(8, this.f);
  }
  
  private void f() {
    Activity activity = b();
    if (activity == null || activity.isFinishing()) {
      a((Class)j.c.class);
      return;
    } 
    if (!a(activity))
      return; 
    g();
    this.k = (a)new c((a)new d((Context)activity));
    this.k.a(this, this.l);
  }
  
  private void g() {
    a a1 = this.k;
    if (a1 != null) {
      a1.a();
      this.k = null;
    } 
  }
  
  void a() {
    b(13, this.f);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, File paramFile) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter onDownloadPackage, status: ");
    stringBuilder.append(d.a(paramInt1));
    stringBuilder.append(", reveived: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", total: ");
    stringBuilder.append(paramInt3);
    HMSLog.i("UpdateWizard", stringBuilder.toString());
    if (paramInt1 != 2000) {
      if (paramInt1 != 2100) {
        if (paramInt1 != 2101) {
          switch (paramInt1) {
            default:
              return;
            case 2203:
            case 2204:
              a((Class)j.d.class);
              return;
            case 2202:
              a((Class)e.c.class);
              return;
            case 2201:
              break;
          } 
          a((Class)j.c.class);
          return;
        } 
      } else if (this.d != null && this.d instanceof f) {
        boolean bool = false;
        paramInt1 = bool;
        if (paramInt2 >= 0) {
          paramInt1 = bool;
          if (paramInt3 > 0)
            paramInt1 = (int)(paramInt2 * 100L / paramInt3); 
        } 
        this.m = paramInt1;
        ((f)this.d).b(paramInt1);
        return;
      } 
    } else {
      c();
      if (paramFile == null) {
        e();
        return;
      } 
      if (FileUtil.verifyHash(this.l.e, paramFile)) {
        a(paramFile);
        return;
      } 
      HMSLog.i("UpdateWizard", "Hash value mismatch for download file");
    } 
  }
  
  public void a(int paramInt, c paramc) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter onCheckUpdate, status: ");
    stringBuilder.append(d.a(paramInt));
    HMSLog.i("UpdateWizard", stringBuilder.toString());
    if (paramInt != 1000) {
      switch (paramInt) {
        default:
          a((Class)j.b.class);
          return;
        case 1201:
        case 1202:
        case 1203:
          break;
      } 
      a((Class)j.b.class);
      return;
    } 
    this.l = paramc;
    d();
  }
  
  public void a(b paramb) {
    HMSLog.i("UpdateWizard", "Enter onCancel.");
    if (paramb instanceof i) {
      a();
      return;
    } 
    if (paramb instanceof d) {
      g();
      a();
      return;
    } 
    if (paramb instanceof f) {
      g();
      a((Class)e.d.class);
      return;
    } 
    if (paramb instanceof e.d) {
      a((Class)f.class);
      f();
      return;
    } 
    if (paramb instanceof e.c) {
      a();
      return;
    } 
    if (paramb instanceof e.b) {
      a();
      return;
    } 
    e();
  }
  
  void a(Class<? extends b> paramClass) {
    if (!a(b()))
      return; 
    c();
    try {
      b b1 = paramClass.newInstance();
      if (!TextUtils.isEmpty(this.h) && b1 instanceof i) {
        this.h = ResourceLoaderUtil.getString("hms_update_title");
        ((i)b1).a(this.h);
      } 
      if (this.m > 0 && b1 instanceof f)
        ((f)b1).a(this.m); 
      b1.a(this);
      this.d = b1;
      return;
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (IllegalStateException illegalStateException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In showDialog, Failed to show the dialog.");
    stringBuilder.append(illegalStateException.getMessage());
    HMSLog.e("UpdateWizard", stringBuilder.toString());
  }
  
  public void b(b paramb) {
    HMSLog.i("UpdateWizard", "Enter onDoWork.");
    if (paramb instanceof i) {
      paramb.c();
      a((Class)d.class);
      a(this);
      return;
    } 
    if (paramb instanceof e.d) {
      paramb.c();
      a();
      return;
    } 
    if (paramb instanceof e.c) {
      a((Class)f.class);
      f();
      return;
    } 
    if (paramb instanceof e.b) {
      a((Class)f.class);
      f();
      return;
    } 
    if (paramb instanceof j.b) {
      e();
      return;
    } 
    if (paramb instanceof j.c) {
      e();
      return;
    } 
    if (paramb instanceof j.d)
      e(); 
  }
  
  public int getRequestCode() {
    return 2006;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null)
      return; 
    this.f = 6;
    if (!a(paramActivity))
      return; 
    if (this.c.isNeedConfirm() && !TextUtils.isEmpty(this.h)) {
      a((Class)i.class);
      return;
    } 
    a((Class)d.class);
    a(this);
  }
  
  public void onBridgeActivityDestroy() {
    g();
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.e && this.b != null)
      return this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent); 
    if (this.f == 6 && paramInt1 == getRequestCode()) {
      if (a(this.g, this.i)) {
        b(0, this.f);
      } else {
        e();
      } 
      return true;
    } 
    return false;
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (this.e && this.b != null) {
      this.b.onKeyUp(paramInt, paramKeyEvent);
      return;
    } 
    if (4 == paramInt) {
      HMSLog.i("UpdateWizard", "In onKeyUp, Call finish.");
      Activity activity = b();
      if (activity != null && !activity.isFinishing()) {
        activity.setResult(0, null);
        activity.finish();
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */