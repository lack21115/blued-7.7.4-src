package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

final class zzo implements Runnable {
  zzo(zzp paramzzp, Task paramTask) {}
  
  public final void run() {
    try {
      Task task = zzp.zza(this.zzb).then(this.zza.getResult());
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
        this.zzb.onFailure((Exception)runtimeExecutionException.getCause());
        return;
      } 
      this.zzb.onFailure(runtimeExecutionException);
      return;
    } catch (CancellationException cancellationException) {
      this.zzb.onCanceled();
      return;
    } catch (Exception exception) {
      this.zzb.onFailure(exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */