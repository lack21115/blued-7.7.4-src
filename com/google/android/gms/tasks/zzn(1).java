package com.google.android.gms.tasks;

final class zzn implements Runnable {
  zzn(zzm paramzzm, Task paramTask) {}
  
  public final void run() {
    synchronized (zzm.zza(this.zzb)) {
      if (zzm.zzb(this.zzb) != null)
        zzm.zzb(this.zzb).onSuccess(this.zza.getResult()); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */