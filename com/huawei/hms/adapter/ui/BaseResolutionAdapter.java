package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class BaseResolutionAdapter implements IBridgeActivityDelegate {
  private WeakReference<Activity> a;
  
  private String b = "";
  
  private void a() {
    Activity activity = b();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      activity.finish();
    } 
  }
  
  private Activity b() {
    WeakReference<Activity> weakReference = this.a;
    return (weakReference == null) ? null : weakReference.get();
  }
  
  private void c() {
    SystemManager.getInstance().notifyResolutionResult(null, this.b);
    a();
  }
  
  public int getRequestCode() {
    return 1001;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    this.a = new WeakReference<Activity>(paramActivity);
    Intent intent = paramActivity.getIntent();
    if (intent == null) {
      c();
      return;
    } 
    Bundle bundle = intent.getExtras();
    this.b = intent.getStringExtra("transaction_id");
    if (bundle == null) {
      c();
      return;
    } 
    Parcelable parcelable = bundle.getParcelable("resolution");
    if (parcelable == null) {
      c();
      return;
    } 
    if (parcelable instanceof Intent)
      try {
        paramActivity.startActivityForResult((Intent)parcelable, 1001);
        return;
      } catch (ActivityNotFoundException activityNotFoundException) {
        c();
        HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
        return;
      }  
    if (parcelable instanceof PendingIntent)
      try {
        activityNotFoundException.startIntentSenderForResult(((PendingIntent)parcelable).getIntentSender(), 1001, null, 0, 0, 0);
        return;
      } catch (android.content.IntentSender.SendIntentException sendIntentException) {
        c();
        HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
      }  
  }
  
  public void onBridgeActivityDestroy() {
    HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 != getRequestCode())
      return false; 
    HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult");
    if (paramInt2 == -1 || paramIntent.hasExtra("kit_update_result")) {
      SystemManager.getInstance().notifyResolutionResult(paramIntent, this.b);
      a();
      return true;
    } 
    SystemManager.getInstance().notifyResolutionResult(null, this.b);
    a();
    return true;
  }
  
  public void onBridgeConfigurationChanged() {
    HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapte\\ui\BaseResolutionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */