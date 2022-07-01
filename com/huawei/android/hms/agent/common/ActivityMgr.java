package com.huawei.android.hms.agent.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
  public static final ActivityMgr INST = new ActivityMgr();
  
  private static final Object LOCK_LASTACTIVITIES = new Object();
  
  private Application application;
  
  private List<Activity> curActivities = new ArrayList<Activity>();
  
  private List<IActivityDestroyedCallback> destroyedCallbacks = new ArrayList<IActivityDestroyedCallback>();
  
  private List<IActivityPauseCallback> pauseCallbacks = new ArrayList<IActivityPauseCallback>();
  
  private List<IActivityResumeCallback> resumeCallbacks = new ArrayList<IActivityResumeCallback>();
  
  private void clearCurActivities() {
    synchronized (LOCK_LASTACTIVITIES) {
      this.curActivities.clear();
      return;
    } 
  }
  
  private Activity getLastActivityInner() {
    synchronized (LOCK_LASTACTIVITIES) {
      if (this.curActivities.size() > 0)
        return this.curActivities.get(this.curActivities.size() - 1); 
      return null;
    } 
  }
  
  private void removeActivity(Activity paramActivity) {
    synchronized (LOCK_LASTACTIVITIES) {
      this.curActivities.remove(paramActivity);
      return;
    } 
  }
  
  private void setCurActivity(Activity paramActivity) {
    synchronized (LOCK_LASTACTIVITIES) {
      int i = this.curActivities.indexOf(paramActivity);
      if (i == -1) {
        this.curActivities.add(paramActivity);
      } else if (i < this.curActivities.size() - 1) {
        this.curActivities.remove(paramActivity);
        this.curActivities.add(paramActivity);
      } 
      return;
    } 
  }
  
  public void clearActivitPauseCallbacks() {
    HMSAgentLog.d("clearOnPauseCallback");
    this.pauseCallbacks.clear();
  }
  
  public void clearActivitResumeCallbacks() {
    HMSAgentLog.d("clearOnResumeCallback");
    this.resumeCallbacks.clear();
  }
  
  public Activity getLastActivity() {
    return getLastActivityInner();
  }
  
  public void init(Application paramApplication, Activity paramActivity) {
    HMSAgentLog.d("init");
    Application application = this.application;
    if (application != null)
      application.unregisterActivityLifecycleCallbacks(this); 
    this.application = paramApplication;
    setCurActivity(paramActivity);
    paramApplication.registerActivityLifecycleCallbacks(this);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onCreated:");
    stringBuilder.append(StrUtils.objDesc(paramActivity));
    HMSAgentLog.d(stringBuilder.toString());
    setCurActivity(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onDestroyed:");
    stringBuilder.append(StrUtils.objDesc(paramActivity));
    HMSAgentLog.d(stringBuilder.toString());
    removeActivity(paramActivity);
    Iterator<?> iterator = (new ArrayList(this.destroyedCallbacks)).iterator();
    while (iterator.hasNext())
      ((IActivityDestroyedCallback)iterator.next()).onActivityDestroyed(paramActivity, getLastActivityInner()); 
  }
  
  public void onActivityPaused(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPaused:");
    stringBuilder.append(StrUtils.objDesc(paramActivity));
    HMSAgentLog.d(stringBuilder.toString());
    Iterator<?> iterator = (new ArrayList(this.pauseCallbacks)).iterator();
    while (iterator.hasNext())
      ((IActivityPauseCallback)iterator.next()).onActivityPause(paramActivity); 
  }
  
  public void onActivityResumed(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResumed:");
    stringBuilder.append(StrUtils.objDesc(paramActivity));
    HMSAgentLog.d(stringBuilder.toString());
    setCurActivity(paramActivity);
    Iterator<?> iterator = (new ArrayList(this.resumeCallbacks)).iterator();
    while (iterator.hasNext())
      ((IActivityResumeCallback)iterator.next()).onActivityResume(paramActivity); 
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onStarted:");
    stringBuilder.append(StrUtils.objDesc(paramActivity));
    HMSAgentLog.d(stringBuilder.toString());
    setCurActivity(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onStopped:");
    stringBuilder.append(StrUtils.objDesc(paramActivity));
    HMSAgentLog.d(stringBuilder.toString());
  }
  
  public void registerActivitDestroyedEvent(IActivityDestroyedCallback paramIActivityDestroyedCallback) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("registerOnDestroyed:");
    stringBuilder.append(StrUtils.objDesc(paramIActivityDestroyedCallback));
    HMSAgentLog.d(stringBuilder.toString());
    this.destroyedCallbacks.add(paramIActivityDestroyedCallback);
  }
  
  public void registerActivitPauseEvent(IActivityPauseCallback paramIActivityPauseCallback) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("registerOnPause:");
    stringBuilder.append(StrUtils.objDesc(paramIActivityPauseCallback));
    HMSAgentLog.d(stringBuilder.toString());
    this.pauseCallbacks.add(paramIActivityPauseCallback);
  }
  
  public void registerActivitResumeEvent(IActivityResumeCallback paramIActivityResumeCallback) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("registerOnResume:");
    stringBuilder.append(StrUtils.objDesc(paramIActivityResumeCallback));
    HMSAgentLog.d(stringBuilder.toString());
    this.resumeCallbacks.add(paramIActivityResumeCallback);
  }
  
  public void release() {
    HMSAgentLog.d("release");
    Application application = this.application;
    if (application != null)
      application.unregisterActivityLifecycleCallbacks(this); 
    clearCurActivities();
    clearActivitResumeCallbacks();
    clearActivitPauseCallbacks();
    this.application = null;
  }
  
  public void unRegisterActivitDestroyedEvent(IActivityDestroyedCallback paramIActivityDestroyedCallback) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unRegisterOnDestroyed:");
    stringBuilder.append(StrUtils.objDesc(paramIActivityDestroyedCallback));
    HMSAgentLog.d(stringBuilder.toString());
    this.destroyedCallbacks.remove(paramIActivityDestroyedCallback);
  }
  
  public void unRegisterActivitPauseEvent(IActivityPauseCallback paramIActivityPauseCallback) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unRegisterOnPause:");
    stringBuilder.append(StrUtils.objDesc(paramIActivityPauseCallback));
    HMSAgentLog.d(stringBuilder.toString());
    this.pauseCallbacks.remove(paramIActivityPauseCallback);
  }
  
  public void unRegisterActivitResumeEvent(IActivityResumeCallback paramIActivityResumeCallback) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unRegisterOnResume:");
    stringBuilder.append(StrUtils.objDesc(paramIActivityResumeCallback));
    HMSAgentLog.d(stringBuilder.toString());
    this.resumeCallbacks.remove(paramIActivityResumeCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\ActivityMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */