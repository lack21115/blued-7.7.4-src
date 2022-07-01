package com.google.android.gms.tasks;

final class zzf implements Runnable {
  zzf(zzd paramzzd, Task paramTask) {}
  
  public final void run() {
    try {
      Task task = (Task)zzd.zza(this.zzb).then(this.zza);
      if (task == null) {
        this.zzb.onFailure(new NullPointerException("Continuation returned null"));
        return;
      } 
      task.addOnSuccessListener(TaskExecutors.zza, this.zzb);
      task.addOnFailureListener(TaskExecutors.zza, this.zzb);
      task.addOnCanceledListener(TaskExecutors.zza, this.zzb);
      return;
    } catch (RuntimeExecutionException runtimeExecutionException) {
      if (runtimeExecutionException.getCause() instanceof Exception) {
        zzd.zzb(this.zzb).zza((Exception)runtimeExecutionException.getCause());
        return;
      } 
      zzd.zzb(this.zzb).zza(runtimeExecutionException);
      return;
    } catch (Exception exception) {
      zzd.zzb(this.zzb).zza(exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */