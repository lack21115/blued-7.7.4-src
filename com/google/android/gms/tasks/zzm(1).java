package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzm<TResult> implements zzr<TResult> {
  private final Executor zza;
  
  private final Object zzb = new Object();
  
  private OnSuccessListener<? super TResult> zzc;
  
  public zzm(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener) {
    this.zza = paramExecutor;
    this.zzc = paramOnSuccessListener;
  }
  
  public final void zza() {
    synchronized (this.zzb) {
      this.zzc = null;
      return;
    } 
  }
  
  public final void zza(Task<TResult> paramTask) {
    if (paramTask.isSuccessful())
      synchronized (this.zzb) {
        if (this.zzc == null)
          return; 
        this.zza.execute(new zzn(this, paramTask));
        return;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */