package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
  private static final BackgroundDetector zza = new BackgroundDetector();
  
  private final AtomicBoolean zzb = new AtomicBoolean();
  
  private final AtomicBoolean zzc = new AtomicBoolean();
  
  private final ArrayList<BackgroundStateChangeListener> zzd = new ArrayList<BackgroundStateChangeListener>();
  
  private boolean zze = false;
  
  public static BackgroundDetector getInstance() {
    return zza;
  }
  
  public static void initialize(Application paramApplication) {
    synchronized (zza) {
      if (!zza.zze) {
        paramApplication.registerActivityLifecycleCallbacks(zza);
        paramApplication.registerComponentCallbacks((ComponentCallbacks)zza);
        zza.zze = true;
      } 
      return;
    } 
  }
  
  private final void zza(boolean paramBoolean) {
    synchronized (zza) {
      ArrayList<BackgroundStateChangeListener> arrayList = this.zzd;
      int j = arrayList.size();
      int i = 0;
      while (i < j) {
        BackgroundStateChangeListener backgroundStateChangeListener = (BackgroundStateChangeListener)arrayList.get(i);
        i++;
        ((BackgroundStateChangeListener)backgroundStateChangeListener).onBackgroundStateChanged(paramBoolean);
      } 
      return;
    } 
  }
  
  public final void addListener(BackgroundStateChangeListener paramBackgroundStateChangeListener) {
    synchronized (zza) {
      this.zzd.add(paramBackgroundStateChangeListener);
      return;
    } 
  }
  
  public final boolean isInBackground() {
    return this.zzb.get();
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    boolean bool = this.zzb.compareAndSet(true, false);
    this.zzc.set(true);
    if (bool)
      zza(false); 
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {
    boolean bool = this.zzb.compareAndSet(true, false);
    this.zzc.set(true);
    if (bool)
      zza(false); 
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt) {
    if (paramInt == 20 && this.zzb.compareAndSet(false, true)) {
      this.zzc.set(true);
      zza(true);
    } 
  }
  
  public final boolean readCurrentStateIfPossible(boolean paramBoolean) {
    if (!this.zzc.get())
      if (PlatformVersion.isAtLeastJellyBean()) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        if (!this.zzc.getAndSet(true) && runningAppProcessInfo.importance > 100)
          this.zzb.set(true); 
      } else {
        return paramBoolean;
      }  
    return isInBackground();
  }
  
  public static interface BackgroundStateChangeListener {
    void onBackgroundStateChanged(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\BackgroundDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */