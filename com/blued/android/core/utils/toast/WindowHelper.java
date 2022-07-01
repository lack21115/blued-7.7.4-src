package com.blued.android.core.utils.toast;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.WindowManager;

final class WindowHelper implements Application.ActivityLifecycleCallbacks {
  private final ArrayMap<String, Activity> a = new ArrayMap();
  
  private final ToastHelper b;
  
  private String c;
  
  private WindowHelper(ToastHelper paramToastHelper) {
    this.b = paramToastHelper;
  }
  
  private static WindowManager a(Activity paramActivity) {
    return (WindowManager)paramActivity.getSystemService("window");
  }
  
  static WindowHelper a(ToastHelper paramToastHelper, Application paramApplication) {
    WindowHelper windowHelper = new WindowHelper(paramToastHelper);
    paramApplication.registerActivityLifecycleCallbacks(windowHelper);
    return windowHelper;
  }
  
  private static String a(Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(Integer.toHexString(paramObject.hashCode()));
    return stringBuilder.toString();
  }
  
  WindowManager a() throws NullPointerException {
    String str = this.c;
    if (str != null) {
      Activity activity = (Activity)this.a.get(str);
      if (activity != null)
        return a(activity); 
    } 
    throw new NullPointerException();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    this.c = a(paramActivity);
    this.a.put(this.c, paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {
    this.a.remove(a(paramActivity));
    if (a(paramActivity).equals(this.c))
      this.c = null; 
  }
  
  public void onActivityPaused(Activity paramActivity) {
    this.b.b();
  }
  
  public void onActivityResumed(Activity paramActivity) {
    this.c = a(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {
    this.c = a(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\WindowHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */