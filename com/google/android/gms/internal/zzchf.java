package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.zzy;

final class zzchf extends zzy {
  private final zzci zzgbb;
  
  zzchf(zzci paramzzci) {
    this.zzgbb = paramzzci;
  }
  
  public final void onLocationChanged(Location paramLocation) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzgbb : Lcom/google/android/gms/common/api/internal/zzci;
    //   6: new com/google/android/gms/internal/zzchg
    //   9: dup
    //   10: aload_1
    //   11: invokespecial <init> : (Landroid/location/Location;)V
    //   14: invokevirtual zza : (Lcom/google/android/gms/common/api/internal/zzcl;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  public final void release() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzgbb : Lcom/google/android/gms/common/api/internal/zzci;
    //   6: aconst_null
    //   7: putfield zzgat : Ljava/lang/Object;
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzchf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */