package com.google.android.gms.tasks;

final class zzj implements Runnable {
  zzj(zzi paramzzi, Task paramTask) {}
  
  public final void run() {
    synchronized (zzi.zza(this.zzb)) {
      if (zzi.zzb(this.zzb) != null)
        zzi.zzb(this.zzb).onComplete(this.zza); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */