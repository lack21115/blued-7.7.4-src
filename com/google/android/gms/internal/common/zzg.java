package com.google.android.gms.internal.common;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class zzg implements zzf {
  private zzg() {}
  
  public final ScheduledExecutorService zza(int paramInt1, int paramInt2) {
    return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\common\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */