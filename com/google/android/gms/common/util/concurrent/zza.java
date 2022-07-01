package com.google.android.gms.common.util.concurrent;

import android.os.Process;

final class zza implements Runnable {
  private final Runnable zza;
  
  private final int zzb;
  
  public zza(Runnable paramRunnable, int paramInt) {
    this.zza = paramRunnable;
    this.zzb = paramInt;
  }
  
  public final void run() {
    Process.setThreadPriority(this.zzb);
    this.zza.run();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\concurrent\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */