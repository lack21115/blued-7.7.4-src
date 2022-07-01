package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements Application.ActivityLifecycleCallbacks {
  private AtomicInteger a = new AtomicInteger(0);
  
  private AtomicBoolean b = new AtomicBoolean(false);
  
  private HashSet<Integer> c = new HashSet<Integer>();
  
  public boolean a() {
    return this.b.get();
  }
  
  public boolean a(Activity paramActivity) {
    return (paramActivity == null) ? false : (this.c.contains(Integer.valueOf(paramActivity.hashCode())));
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {
    if (paramActivity != null)
      this.c.remove(Integer.valueOf(paramActivity.hashCode())); 
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {
    if (paramActivity != null)
      this.c.add(Integer.valueOf(paramActivity.hashCode())); 
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {
    if (this.a.incrementAndGet() > 0)
      this.b.set(false); 
  }
  
  public void onActivityStopped(Activity paramActivity) {
    if (this.a.decrementAndGet() == 0)
      this.b.set(true); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */