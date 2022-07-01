package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
  public static final ActivityMgr INST = new ActivityMgr();
  
  private static final String TAG = "ActivityMgr";
  
  private WeakReference<Activity> mCurrentActivity;
  
  private static String objDesc(Object paramObject) {
    if (paramObject == null)
      return "null"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append('@');
    stringBuilder.append(Integer.toHexString(paramObject.hashCode()));
    return stringBuilder.toString();
  }
  
  public Activity getCurrentActivity() {
    if (this.mCurrentActivity == null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("mCurrentActivity is ");
      stringBuilder1.append(this.mCurrentActivity);
      HMSLog.i("ActivityMgr", stringBuilder1.toString());
      return null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mCurrentActivity.get() is ");
    stringBuilder.append(this.mCurrentActivity.get());
    HMSLog.i("ActivityMgr", stringBuilder.toString());
    return this.mCurrentActivity.get();
  }
  
  public void init(Application paramApplication) {
    HMSLog.d("ActivityMgr", "init");
    if (paramApplication == null) {
      HMSLog.w("ActivityMgr", "init failed for app is null");
      return;
    } 
    paramApplication.unregisterActivityLifecycleCallbacks(INST);
    paramApplication.registerActivityLifecycleCallbacks(INST);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onCreated:");
    stringBuilder.append(objDesc(paramActivity));
    HMSLog.d("ActivityMgr", stringBuilder.toString());
    this.mCurrentActivity = new WeakReference<Activity>(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResumed:");
    stringBuilder.append(objDesc(paramActivity));
    HMSLog.d("ActivityMgr", stringBuilder.toString());
    this.mCurrentActivity = new WeakReference<Activity>(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onStarted:");
    stringBuilder.append(objDesc(paramActivity));
    HMSLog.d("ActivityMgr", stringBuilder.toString());
    this.mCurrentActivity = new WeakReference<Activity>(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\common\ActivityMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */