package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

final class zzq<TResult> {
  private final Object zza = new Object();
  
  private Queue<zzr<TResult>> zzb;
  
  private boolean zzc;
  
  public final void zza(Task<TResult> paramTask) {
    synchronized (this.zza) {
      if (this.zzb == null || this.zzc)
        return; 
      this.zzc = true;
      while (true) {
        synchronized (this.zza) {
          zzr<TResult> zzr = this.zzb.poll();
          if (zzr == null) {
            this.zzc = false;
            return;
          } 
          zzr.zza(paramTask);
        } 
      } 
    } 
  }
  
  public final void zza(zzr<TResult> paramzzr) {
    synchronized (this.zza) {
      if (this.zzb == null)
        this.zzb = new ArrayDeque<zzr<TResult>>(); 
      this.zzb.add(paramzzr);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */