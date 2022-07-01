package com.huawei.updatesdk.service.otaupdate;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.a.c.h.b;
import com.huawei.updatesdk.a.b.d.b;
import com.huawei.updatesdk.a.b.d.c.c;
import com.huawei.updatesdk.a.b.d.c.d;
import com.huawei.updatesdk.b.b.a;
import com.huawei.updatesdk.b.e.a.b;
import com.huawei.updatesdk.b.f.b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.a;
import com.huawei.updatesdk.service.appmgr.bean.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e extends AsyncTask<Void, Void, d> {
  private Context a;
  
  private CheckUpdateCallBack b;
  
  private UpdateParams c;
  
  private Toast d;
  
  private boolean e = false;
  
  private List<String> f = new ArrayList<String>();
  
  private b g;
  
  private String h;
  
  public e(Context paramContext, UpdateParams paramUpdateParams, CheckUpdateCallBack paramCheckUpdateCallBack) {
    this.c = paramUpdateParams;
    this.a = paramContext;
    this.b = paramCheckUpdateCallBack;
    h.g().b(paramUpdateParams.getServiceZone());
    if (TextUtils.isEmpty(h.g().c()))
      h.g().d("com.huawei.appmarket"); 
    this.h = h.g().c();
  }
  
  private PackageInfo a(Context paramContext, String paramString) {
    PackageInfo packageInfo2 = b.a(paramString, paramContext);
    PackageInfo packageInfo1 = packageInfo2;
    if (packageInfo2 == null) {
      packageInfo1 = new PackageInfo();
      packageInfo1.packageName = paramString;
      packageInfo1.versionName = "1.0";
      packageInfo1.versionCode = 1;
      ApplicationInfo applicationInfo = new ApplicationInfo();
      applicationInfo.targetSdkVersion = 19;
      packageInfo1.applicationInfo = applicationInfo;
    } 
    return packageInfo1;
  }
  
  private d a(Context paramContext, List<String> paramList) {
    a a;
    boolean bool;
    ArrayList<PackageInfo> arrayList = new ArrayList();
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(a(paramContext, iterator.next())); 
    if (!i.a(this.c.getParamList())) {
      a = new a(this.c.getParamList());
    } else {
      a = a.a(arrayList);
    } 
    if (h.g().e()) {
      bool = true;
    } else {
      bool = false;
    } 
    a.a(bool);
    a.d(0);
    if (isCancelled()) {
      Log.w("UpdateSDKCheckTask", "UpdateSDK task is canceled and return empty upgradeInfo");
      return null;
    } 
    this.g = new b((c)a, null);
    return this.g.c();
  }
  
  private void a() {
    Toast toast = this.d;
    if (toast != null)
      toast.cancel(); 
  }
  
  private void a(Context paramContext, ApkUpgradeInfo paramApkUpgradeInfo) {
    if (paramContext == null)
      return; 
    Intent intent = new Intent(paramContext, AppUpdateActivity.class);
    Bundle bundle = new Bundle();
    bundle.putSerializable("app_update_parm", (Serializable)paramApkUpgradeInfo);
    bundle.putBoolean("app_must_btn", this.c.isMustBtnOne());
    intent.putExtras(bundle);
    if (!(paramContext instanceof android.app.Activity))
      intent.setFlags(268435456); 
    try {
      paramContext.startActivity(intent);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("go AppUpdateActivity error: ");
      stringBuilder.append(activityNotFoundException.toString());
      a.b("UpdateSDKCheckTask", stringBuilder.toString());
      return;
    } 
  }
  
  private void a(List<ApkUpgradeInfo> paramList) {
    if (i.a(paramList))
      return; 
    for (ApkUpgradeInfo apkUpgradeInfo : paramList) {
      if (apkUpgradeInfo != null && !TextUtils.isEmpty(apkUpgradeInfo.getFullDownUrl_())) {
        if (apkUpgradeInfo.getDiffSize_() > 0)
          apkUpgradeInfo.setDiffDownUrl_(apkUpgradeInfo.getDownurl_()); 
        apkUpgradeInfo.setDownurl_(apkUpgradeInfo.getFullDownUrl_());
      } 
    } 
  }
  
  private void b(d paramd) {
    if (this.b != null) {
      Intent intent = new Intent();
      intent.putExtra("status", 6);
      if (paramd.a() != null)
        intent.putExtra("failcause", paramd.a().ordinal()); 
      intent.putExtra("failreason", paramd.c());
      intent.putExtra("responsecode", paramd.b());
      this.b.onUpdateInfo(intent);
      this.b.onUpdateStoreError(paramd.d());
    } 
  }
  
  private boolean b() {
    return (!this.e && TextUtils.isEmpty(this.c.getTargetPkgName()) && i.a(this.c.getPackageList()) && i.a(this.c.getParamList()));
  }
  
  protected d a(Void... paramVarArgs) {
    a.a("UpdateSDKCheckTask", "CheckOtaAndUpdataTask doInBackground");
    b.a(this);
    h.g().a(this.a, this.h);
    Context context = this.a;
    if (h.g().e()) {
      str1 = "upsdk_apptouch_store_url";
    } else {
      str1 = "upsdk_store_url";
    } 
    String str1 = g.f(context, str1);
    c.c(b.c(this.a, str1));
    String str2 = this.c.getTargetPkgName();
    str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = this.a.getPackageName(); 
    if (i.a(this.c.getPackageList())) {
      if (!TextUtils.isEmpty(str1))
        this.f.add(str1); 
    } else {
      this.f.addAll(this.c.getPackageList());
    } 
    a.c().d(h.g().a());
    return a(this.a, this.f);
  }
  
  protected void a(d paramd) {
    Intent intent;
    ArrayList<ApkUpgradeInfo> arrayList1;
    b.a().remove(this);
    a();
    if (paramd == null) {
      if (this.b != null) {
        intent = new Intent();
        intent.putExtra("status", 3);
        this.b.onUpdateInfo(intent);
      } 
      return;
    } 
    int i = intent.b();
    ArrayList<ApkUpgradeInfo> arrayList2 = null;
    if (intent.d() == 0 && intent.e() == 0) {
      b b1 = (b)intent;
      arrayList2 = b1.list_;
      if (!i.a(b1.notRcmList_)) {
        ApkUpgradeInfo apkUpgradeInfo = b1.notRcmList_.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UpdateSDK get update info is not recommend,reason: ");
        stringBuilder.append(apkUpgradeInfo.getNotRcmReason_());
        stringBuilder.append(",is same signature: ");
        stringBuilder.append(apkUpgradeInfo.getSameS_());
        Log.w("UpdateSDKCheckTask", stringBuilder.toString());
      } 
      a(arrayList2);
      arrayList1 = arrayList2;
      if (i.a(arrayList2)) {
        arrayList1 = arrayList2;
        if (this.b != null) {
          Intent intent1 = new Intent();
          intent1.putExtra("status", 3);
          intent1.putExtra("responsecode", i);
          this.b.onUpdateInfo(intent1);
          arrayList1 = arrayList2;
        } 
      } 
    } else {
      b((d)arrayList1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get app update msg failed,responseCode is ");
      stringBuilder.append(arrayList1.d());
      stringBuilder.append(",failreason: ");
      stringBuilder.append(arrayList1.c());
      Log.e("UpdateSDKCheckTask", stringBuilder.toString());
      arrayList1 = arrayList2;
    } 
    if (!i.a(arrayList1)) {
      ApkUpgradeInfo apkUpgradeInfo = arrayList1.get(0);
      if (this.b != null) {
        Intent intent1 = new Intent();
        intent1.putExtra("updatesdk_update_info", (Serializable)apkUpgradeInfo);
        intent1.putParcelableArrayListExtra("updatesdk_update_info_list", arrayList1);
        intent1.putExtra("status", 7);
        intent1.putExtra("responsecode", i);
        this.b.onUpdateInfo(intent1);
      } 
      if (apkUpgradeInfo != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ApkUpgradeInfo,version = ");
        stringBuilder.append(apkUpgradeInfo.getVersion_());
        stringBuilder.append(",versionCode = ");
        stringBuilder.append(apkUpgradeInfo.getVersionCode_());
        stringBuilder.append(",detailId = ");
        stringBuilder.append(apkUpgradeInfo.getDetailId_());
        stringBuilder.append(",devType = ");
        stringBuilder.append(apkUpgradeInfo.getDevType_());
        stringBuilder.append(",packageName = ");
        stringBuilder.append(apkUpgradeInfo.getPackage_());
        stringBuilder.append(",oldVersionCode = ");
        stringBuilder.append(apkUpgradeInfo.getOldVersionCode_());
        Log.i("UpdateSDKCheckTask", stringBuilder.toString());
      } else {
        Log.e("UpdateSDKCheckTask", "info == null");
      } 
      if (this.c.isShowImmediate()) {
        a(this.a, apkUpgradeInfo);
        return;
      } 
    } else if (b()) {
      Context context = this.a;
      Toast.makeText(context, g.e(context, "upsdk_update_check_no_new_version"), 0).show();
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  protected void onCancelled() {
    super.onCancelled();
    b b1 = this.g;
    if (b1 != null)
      b1.b(); 
  }
  
  protected void onPreExecute() {
    super.onPreExecute();
    d.a().a(this.b);
    if (b()) {
      Context context = this.a;
      this.d = Toast.makeText(context, g.e(context, "upsdk_checking_update_prompt"), 1);
      this.d.show();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */