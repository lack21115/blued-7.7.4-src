package com.google.android.gms.tasks;

final class zze implements Runnable {
  zze(zzc paramzzc, Task paramTask) {}
  
  public final void run() {
    if (this.zza.isCanceled()) {
      zzc.zza(this.zzb).zza();
      return;
    } 
    try {
      Object object = zzc.zzb(this.zzb).then(this.zza);
      zzc.zza(this.zzb).zza(object);
      return;
    } catch (RuntimeExecutionException runtimeExecutionException) {
      if (runtimeExecutionException.getCause() instanceof Exception) {
        zzc.zza(this.zzb).zza((Exception)runtimeExecutionException.getCause());
        return;
      } 
      zzc.zza(this.zzb).zza(runtimeExecutionException);
      return;
    } catch (Exception exception) {
      zzc.zza(this.zzb).zza(exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */