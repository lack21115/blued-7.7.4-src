package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult> implements zzr<TResult> {
  private final Executor zza;
  
  private final Continuation<TResult, TContinuationResult> zzb;
  
  private final zzu<TContinuationResult> zzc;
  
  public zzc(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation, zzu<TContinuationResult> paramzzu) {
    this.zza = paramExecutor;
    this.zzb = paramContinuation;
    this.zzc = paramzzu;
  }
  
  public final void zza() {
    throw new UnsupportedOperationException();
  }
  
  public final void zza(Task<TResult> paramTask) {
    this.zza.execute(new zze(this, paramTask));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */