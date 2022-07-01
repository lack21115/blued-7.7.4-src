package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzd<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzr<TResult> {
  private final Executor zza;
  
  private final Continuation<TResult, Task<TContinuationResult>> zzb;
  
  private final zzu<TContinuationResult> zzc;
  
  public zzd(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation, zzu<TContinuationResult> paramzzu) {
    this.zza = paramExecutor;
    this.zzb = paramContinuation;
    this.zzc = paramzzu;
  }
  
  public final void onCanceled() {
    this.zzc.zza();
  }
  
  public final void onFailure(Exception paramException) {
    this.zzc.zza(paramException);
  }
  
  public final void onSuccess(TContinuationResult paramTContinuationResult) {
    this.zzc.zza(paramTContinuationResult);
  }
  
  public final void zza() {
    throw new UnsupportedOperationException();
  }
  
  public final void zza(Task<TResult> paramTask) {
    this.zza.execute(new zzf(this, paramTask));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */