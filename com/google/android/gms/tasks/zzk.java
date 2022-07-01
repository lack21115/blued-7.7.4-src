package com.google.android.gms.tasks;

final class zzk implements Runnable {
  zzk(zzl paramzzl, Task paramTask) {}
  
  public final void run() {
    synchronized (zzl.zza(this.zzb)) {
      if (zzl.zzb(this.zzb) != null)
        zzl.zzb(this.zzb).onFailure(this.zza.getException()); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */