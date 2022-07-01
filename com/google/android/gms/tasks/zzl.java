package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzl<TResult> implements zzr<TResult> {
  private final Executor zza;
  
  private final Object zzb = new Object();
  
  private OnFailureListener zzc;
  
  public zzl(Executor paramExecutor, OnFailureListener paramOnFailureListener) {
    this.zza = paramExecutor;
    this.zzc = paramOnFailureListener;
  }
  
  public final void zza() {
    synchronized (this.zzb) {
      this.zzc = null;
      return;
    } 
  }
  
  public final void zza(Task<TResult> paramTask) {
    if (!paramTask.isSuccessful() && !paramTask.isCanceled())
      synchronized (this.zzb) {
        if (this.zzc == null)
          return; 
        this.zza.execute(new zzk(this, paramTask));
        return;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */