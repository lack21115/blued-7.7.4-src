package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzat;

final class zzaw extends zzat {
  private final ListenerHolder<LocationListener> zza;
  
  zzaw(ListenerHolder<LocationListener> paramListenerHolder) {
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
  
  public final void zza(Location paramLocation) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zza : Lcom/google/android/gms/common/api/internal/ListenerHolder;
    //   6: new com/google/android/gms/internal/location/zzav
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial <init> : (Lcom/google/android/gms/internal/location/zzaw;Landroid/location/Location;)V
    //   15: invokevirtual notifyListener : (Lcom/google/android/gms/common/api/internal/ListenerHolder$Notifier;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */