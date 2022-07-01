package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult> {
  private final zzu<TResult> zza = new zzu<TResult>();
  
  public TaskCompletionSource() {}
  
  public TaskCompletionSource(CancellationToken paramCancellationToken) {
    paramCancellationToken.onCanceledRequested(new zzs(this));
  }
  
  public Task<TResult> getTask() {
    return this.zza;
  }
  
  public void setException(Exception paramException) {
    this.zza.zza(paramException);
  }
  
  public void setResult(TResult paramTResult) {
    this.zza.zza(paramTResult);
  }
  
  public boolean trySetException(Exception paramException) {
    return this.zza.zzb(paramException);
  }
  
  public boolean trySetResult(TResult paramTResult) {
    return this.zza.zzb(paramTResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\TaskCompletionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */