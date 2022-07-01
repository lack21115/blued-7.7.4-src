package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zze implements zzm {
  final Object mLock = new Object();
  
  private final Executor zzkou;
  
  OnCompleteListener zzleb;
  
  public zze(Executor paramExecutor, OnCompleteListener paramOnCompleteListener) {
    this.zzkou = paramExecutor;
    this.zzleb = paramOnCompleteListener;
  }
  
  public final void onComplete(Task paramTask) {
    synchronized (this.mLock) {
      if (this.zzleb == null)
        return; 
      this.zzkou.execute(new zzf(this, paramTask));
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\tasks\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */