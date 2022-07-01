package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzi<TResult> implements zzr<TResult> {
  private final Executor zza;
  
  private final Object zzb = new Object();
  
  private OnCompleteListener<TResult> zzc;
  
  public zzi(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener) {
    this.zza = paramExecutor;
    this.zzc = paramOnCompleteListener;
  }
  
  public final void zza() {
    synchronized (this.zzb) {
      this.zzc = null;
      return;
    } 
  }
  
  public final void zza(Task<TResult> paramTask) {
    synchronized (this.zzb) {
      if (this.zzc == null)
        return; 
      this.zza.execute(new zzj(this, paramTask));
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */