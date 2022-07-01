package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeBundle;
import com.huawei.hms.utils.ResourceLoaderUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k extends a {
  private BroadcastReceiver k;
  
  private Handler l = new Handler();
  
  private int m = 0;
  
  private Handler n = new Handler(this) {
      public void handleMessage(Message param1Message) {
        SafeBundle safeBundle = new SafeBundle((Bundle)param1Message.obj);
        switch (param1Message.what) {
          default:
            return;
          case 103:
            k.c(this.a, safeBundle);
            return;
          case 102:
            k.b(this.a, safeBundle);
            return;
          case 101:
            break;
        } 
        k.a(this.a, safeBundle);
      }
    };
  
  private void a(SafeBundle paramSafeBundle) {
    String str;
    if (paramSafeBundle.containsKey("UpgradePkgName")) {
      str = paramSafeBundle.getString("UpgradePkgName");
    } else {
      str = null;
    } 
    if (str != null) {
      if (!str.equals(this.g))
        return; 
      if (paramSafeBundle.containsKey("downloadtask.status")) {
        int i = paramSafeBundle.getInt("downloadtask.status");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handleDownloadStatus-status is ");
        stringBuilder.append(i);
        HMSLog.i("SilentUpdateWizard", stringBuilder.toString());
        if (i == 3 || i == 5 || i == 6 || i == 8) {
          c(i);
          return;
        } 
        if (i == 4) {
          b(60000);
          return;
        } 
        b(20000);
        return;
      } 
    } 
  }
  
  private boolean a(Activity paramActivity) {
    if (TextUtils.isEmpty(this.g))
      return false; 
    Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
    intent.setPackage("com.huawei.appmarket");
    JSONArray jSONArray = new JSONArray();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("pkgName", this.g);
      jSONObject.put("versioncode", this.i);
      jSONArray.put(jSONObject);
      intent.putExtra("params", jSONArray.toString());
      intent.putExtra("isHmsOrApkUpgrade", this.c.a());
      intent.putExtra("buttonDlgY", ResourceLoaderUtil.getString("hms_install"));
      intent.putExtra("buttonDlgN", ResourceLoaderUtil.getString("hms_cancel"));
      intent.putExtra("upgradeDlgContent", ResourceLoaderUtil.getString("hms_update_message_new", new Object[] { "%P" }));
      try {
        HMSLog.i("SilentUpdateWizard", "start silent activity of AppMarket");
        paramActivity.startActivityForResult(intent, getRequestCode());
        HMSLog.i("SilentUpdateWizard", "start silent activity finished");
        return true;
      } catch (ActivityNotFoundException activityNotFoundException) {}
      HMSLog.e("SilentUpdateWizard", "ActivityNotFoundException");
      return false;
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create hmsJsonObject fail");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("SilentUpdateWizard", stringBuilder.toString());
      return false;
    } 
  }
  
  private void b(int paramInt) {
    this.l.removeCallbacksAndMessages(null);
    this.l.postDelayed(new a(), paramInt);
  }
  
  private void b(SafeBundle paramSafeBundle) {
    String str;
    if (paramSafeBundle.containsKey("UpgradePkgName")) {
      str = paramSafeBundle.getString("UpgradePkgName");
    } else {
      str = null;
    } 
    if (str != null) {
      if (!str.equals(this.g))
        return; 
      if (paramSafeBundle.containsKey("UpgradeDownloadProgress") && paramSafeBundle.containsKey("UpgradeAppName")) {
        int j = paramSafeBundle.getInt("UpgradeDownloadProgress");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handlerDownloadProgress-progress is ");
        stringBuilder.append(j);
        HMSLog.i("SilentUpdateWizard", stringBuilder.toString());
        b(20000);
        int i = j;
        if (j >= 99)
          i = 99; 
        this.m = i;
        if (this.d == null)
          a((Class)f.class); 
        if (this.d != null)
          ((f)this.d).b(i); 
      } 
    } 
  }
  
  private void c(int paramInt) {
    this.l.removeCallbacksAndMessages(null);
    e();
    c();
    if (!a(false)) {
      b(paramInt, this.f);
      return;
    } 
    a(paramInt, this.f);
  }
  
  private void c(SafeBundle paramSafeBundle) {
    if (paramSafeBundle.containsKey("packagename") && paramSafeBundle.containsKey("status")) {
      String str = paramSafeBundle.getString("packagename");
      int i = paramSafeBundle.getInt("status");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("handlerInstallStatus-status is ");
      stringBuilder.append(i);
      HMSLog.i("SilentUpdateWizard", stringBuilder.toString());
      if (str != null) {
        if (!str.equals(this.g))
          return; 
        if (i == 2) {
          this.l.removeCallbacksAndMessages(null);
          if (this.d != null)
            ((f)this.d).b(100); 
          b(0, this.f);
          return;
        } 
        if (i == -1 || i == -2) {
          c(i);
          return;
        } 
        b(60000);
        return;
      } 
    } 
  }
  
  private void d() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("com.huawei.appmarket.service.downloadservice.Receiver");
    intentFilter.addAction("com.huawei.appmarket.service.downloadservice.progress.Receiver");
    intentFilter.addAction("com.huawei.appmarket.service.installerservice.Receiver");
    this.k = (BroadcastReceiver)new com.huawei.hms.update.c.a(this.n);
    Activity activity = b();
    if (activity != null)
      activity.registerReceiver(this.k, intentFilter); 
  }
  
  private void e() {
    Activity activity = b();
    if (activity != null) {
      BroadcastReceiver broadcastReceiver = this.k;
      if (broadcastReceiver != null) {
        activity.unregisterReceiver(broadcastReceiver);
        this.k = null;
      } 
    } 
  }
  
  void a() {
    b(13, this.f);
  }
  
  void a(Class<? extends b> paramClass) {
    try {
      b b = paramClass.newInstance();
      if (this.m > 0 && b instanceof f)
        ((f)b).a(this.m); 
      b.a(this);
      this.d = b;
      return;
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (IllegalStateException illegalStateException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In showDialog, Failed to show the dialog.");
    stringBuilder.append(illegalStateException.getMessage());
    HMSLog.e("SilentUpdateWizard", stringBuilder.toString());
  }
  
  public int getRequestCode() {
    return 2000;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null)
      return; 
    this.f = 0;
    if (!a(paramActivity)) {
      if (!a(true)) {
        b(8, this.f);
        return;
      } 
      a(8, this.f);
    } 
  }
  
  public void onBridgeActivityDestroy() {
    this.l.removeCallbacksAndMessages(null);
    e();
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.e && this.b != null)
      return this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onBridgeActivityResult requestCode is ");
    stringBuilder.append(paramInt1);
    stringBuilder.append("resultCode is ");
    stringBuilder.append(paramInt2);
    HMSLog.i("SilentUpdateWizard", stringBuilder.toString());
    if (paramInt1 == getRequestCode()) {
      if (paramInt2 == 0) {
        d();
        b(20000);
        return true;
      } 
      if (paramInt2 == 4) {
        a();
        return true;
      } 
      if (!a(true)) {
        b(paramInt2, this.f);
        return true;
      } 
      a(paramInt2, this.f);
      return true;
    } 
    return false;
  }
  
  public void onBridgeConfigurationChanged() {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  class a implements Runnable {
    private a(k this$0) {}
    
    public void run() {
      k.a(this.a, 14);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */