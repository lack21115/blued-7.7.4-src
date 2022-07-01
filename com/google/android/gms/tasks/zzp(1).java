package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzp<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzr<TResult> {
  private final Executor zza;
  
  private final SuccessContinuation<TResult, TContinuationResult> zzb;
  
  private final zzu<TContinuationResult> zzc;
  
  public zzp(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation, zzu<TContinuationResult> paramzzu) {
    this.zza = paramExecutor;
    this.zzb = paramSuccessContinuation;
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
    this.zza.execute(new zzo(this, paramTask));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */