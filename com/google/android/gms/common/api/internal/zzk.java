package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzk implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
  static final zzk zzfuo = new zzk();
  
  private boolean zzdyq = false;
  
  final AtomicBoolean zzfup = new AtomicBoolean();
  
  final AtomicBoolean zzfuq = new AtomicBoolean();
  
  final ArrayList zzfur = new ArrayList();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void zza(Application paramApplication) {
    synchronized (zzfuo) {
      if (!zzfuo.zzdyq) {
        paramApplication.registerActivityLifecycleCallbacks(zzfuo);
        paramApplication.registerComponentCallbacks((ComponentCallbacks)zzfuo);
        zzfuo.zzdyq = true;
      } 
      return;
    } 
  }
  
  public static zzk zzaij() {
    return zzfuo;
  }
  
  private final void zzbj(boolean paramBoolean) {
    synchronized (zzfuo) {
      ArrayList<Object> arrayList = this.zzfur;
      int j = arrayList.size();
      int i = 0;
      while (i < j) {
        zzl zzl = (zzl)arrayList.get(i);
        i++;
        ((zzl)zzl).zzbj(paramBoolean);
      } 
      return;
    } 
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    boolean bool = this.zzfup.compareAndSet(true, false);
    this.zzfuq.set(true);
    if (bool)
      zzbj(false); 
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {
    boolean bool = this.zzfup.compareAndSet(true, false);
    this.zzfuq.set(true);
    if (bool)
      zzbj(false); 
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt) {
    if (paramInt == 20 && this.zzfup.compareAndSet(false, true)) {
      this.zzfuq.set(true);
      zzbj(true);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */