package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.hms.update.manager.PackageNameManager;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.lang.ref.WeakReference;

public class UpdateAdapter implements IBridgeActivityDelegate, PackageNameManager.QueryPublishCallback {
  private WeakReference<Activity> a;
  
  private int b;
  
  private UpdateBean c;
  
  private String d;
  
  private void a() {
    PackageNameManager.getInstance((Context)d()).queryPackageName(this);
  }
  
  private boolean a(Context paramContext, String paramString, int paramInt) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString)) {
        if (paramInt == 0)
          return false; 
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(paramContext);
        PackageManagerHelper.PackageStates packageStates = packageManagerHelper.getPackageStates(paramString);
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates))
          return true; 
        bool1 = bool2;
        if (packageManagerHelper.getPackageVersionCode(paramString) < paramInt)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  private void b() {
    Activity activity = d();
    UpdateBean updateBean = new UpdateBean();
    updateBean.setHmsOrApkUpgrade(true);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("target HMS Core packageName is ");
    stringBuilder.append(this.d);
    HMSLog.i("UpdateAdapter", stringBuilder.toString());
    updateBean.setClientPackageName(this.d);
    updateBean.setClientVersionCode(this.b);
    updateBean.setClientAppId("C10132067");
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(activity.getApplicationContext()); 
    updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    this.c = updateBean;
    HMSLog.i("UpdateAdapter", "old framework HMSCore upgrade process");
    UpdateManager.startUpdate(activity, 1001, updateBean);
    this.c = null;
  }
  
  private void c() {
    Activity activity = d();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      activity.finish();
    } 
  }
  
  private Activity d() {
    WeakReference<Activity> weakReference = this.a;
    return (weakReference == null) ? null : weakReference.get();
  }
  
  private void e() {
    SystemManager.getInstance().notifyUpdateResult(8);
    c();
  }
  
  public int getRequestCode() {
    return 1001;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    this.a = new WeakReference<Activity>(paramActivity);
    Intent intent = paramActivity.getIntent();
    if (intent == null) {
      e();
      return;
    } 
    this.b = intent.getIntExtra("update_version", 0);
    if (this.b == 0) {
      e();
      return;
    } 
    if (intent.getBooleanExtra("new_update", false)) {
      HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
      String str = HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHMSPackageName();
      ComponentName componentName = new ComponentName(str, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
      Intent intent1 = new Intent();
      intent1.putExtra("kpms_key_caller_packagename", paramActivity.getApplicationContext().getPackageName());
      intent1.putExtra("kitUpdatePackageName", str);
      intent1.setComponent(componentName);
      paramActivity.startActivityForResult(intent1, 1001);
      return;
    } 
    HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance((Context)paramActivity);
    PackageManagerHelper.PackageStates packageStates = hMSPackageManager.getHMSPackageStates();
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates)) {
      if (HMSPublishStateHolder.getPublishState() == 0) {
        a();
        return;
      } 
      if (HMSPublishStateHolder.getPublishState() == 1) {
        this.d = "com.huawei.hms";
        b();
        return;
      } 
      this.d = "com.huawei.hwid";
      b();
      return;
    } 
    this.d = hMSPackageManager.getHMSPackageName();
    b();
  }
  
  public void onBridgeActivityDestroy() {
    HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 != getRequestCode()) {
      this.c = null;
      return false;
    } 
    HMSLog.i("UpdateAdapter", "onBridgeActivityResult");
    if (paramInt2 == 1214) {
      HMSLog.i("UpdateAdapter", "Enter update escape route");
      Activity activity = d();
      if (activity == null) {
        HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
        this.c = null;
        return true;
      } 
      UpdateManager.startUpdate(activity, 1001, this.c);
      this.c = null;
    } 
    if (paramInt2 == -1) {
      if (paramIntent != null) {
        if (paramIntent.getIntExtra("kit_update_result", 0) == 1) {
          HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
          SystemManager.getInstance().notifyUpdateResult(0);
          this.c = null;
          c();
          return true;
        } 
        paramInt1 = paramIntent.getIntExtra("intent.extra.RESULT", -1);
        if (paramInt1 == 0) {
          HMSLog.i("UpdateAdapter", "Error resolved successfully!");
          SystemManager.getInstance().notifyUpdateResult(0);
        } else if (paramInt1 == 13) {
          HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
          SystemManager.getInstance().notifyUpdateResult(13);
        } else if (paramInt1 == 8) {
          HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
          SystemManager.getInstance().notifyUpdateResult(8);
        } else {
          HMSLog.i("UpdateAdapter", "Other error codes.");
          SystemManager.getInstance().notifyUpdateResult(paramInt1);
        } 
      } 
    } else if (paramInt2 == 0) {
      HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
      this.c = null;
      Activity activity = d();
      if (activity == null)
        return true; 
      if (a((Context)activity, HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName(), this.b)) {
        HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
        SystemManager.getInstance().notifyUpdateResult(13);
      } else {
        SystemManager.getInstance().notifyUpdateResult(0);
      } 
    } else if (paramInt2 == 1) {
      SystemManager.getInstance().notifyUpdateResult(28);
    } 
    c();
    return true;
  }
  
  public void onBridgeConfigurationChanged() {
    HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
  }
  
  public void onQueryResult() {
    if (HMSPublishStateHolder.getPublishState() == 1) {
      this.d = "com.huawei.hms";
    } else {
      this.d = "com.huawei.hwid";
    } 
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapte\\ui\UpdateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */