package com.google.android.gms.common.providers;

import com.google.android.gms.internal.common.zze;
import com.google.android.gms.internal.common.zzj;
import java.util.concurrent.ScheduledExecutorService;

final class zza implements PooledExecutorsProvider.PooledExecutorFactory {
  public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
    return zze.zza().zza(1, zzj.zza);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\providers\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */