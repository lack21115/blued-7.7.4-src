package com.google.android.gms.tasks;

final class zzf implements Runnable {
  zzf(zze paramzze, Task paramTask) {}
  
  public final void run() {
    synchronized (this.zzlec.mLock) {
      if (this.zzlec.zzleb != null)
        this.zzlec.zzleb.onComplete(this.zzldy); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\tasks\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */