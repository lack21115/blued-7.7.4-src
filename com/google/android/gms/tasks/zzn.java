package com.google.android.gms.tasks;

import java.util.Queue;

public final class zzn {
  final Object mLock = new Object();
  
  Queue zzlej;
  
  private boolean zzlek;
  
  public final void zzb(Task paramTask) {
    synchronized (this.mLock) {
      if (this.zzlej == null || this.zzlek)
        return; 
      this.zzlek = true;
      while (true) {
        synchronized (this.mLock) {
          zzm zzm = this.zzlej.poll();
          if (zzm == null) {
            this.zzlek = false;
            return;
          } 
          zzm.onComplete(paramTask);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\tasks\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */