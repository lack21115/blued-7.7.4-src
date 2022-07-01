package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzao;

final class zzas extends zzao {
  private final ListenerHolder<LocationCallback> zza;
  
  zzas(ListenerHolder<LocationCallback> paramListenerHolder) {
    this.zza = paramListenerHolder;
  }
  
  public final void zza() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zza : Lcom/google/android/gms/common/api/internal/ListenerHolder;
    //   6: invokevirtual clear : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public final void zza(LocationAvailability paramLocationAvailability) {
    this.zza.notifyListener(new zzau(this, paramLocationAvailability));
  }
  
  public final void zza(LocationResult paramLocationResult) {
    this.zza.notifyListener(new zzar(this, paramLocationResult));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */