package com.google.android.gms.tasks;

final class zzg implements Runnable {
  zzg(zzh paramzzh) {}
  
  public final void run() {
    synchronized (zzh.zza(this.zza)) {
      if (zzh.zzb(this.zza) != null)
        zzh.zzb(this.zza).onCanceled(); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */