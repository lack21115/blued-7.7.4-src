package com.google.android.gms.common;

import android.content.Context;

final class zzg {
  private static Context zzfrc;
  
  static {
    new Object();
    throw new VerifyError("bad dex opcode");
  }
  
  static void zzch(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/common/zzg
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/common/zzg.zzfrc : Landroid/content/Context;
    //   6: ifnonnull -> 24
    //   9: aload_0
    //   10: ifnull -> 32
    //   13: aload_0
    //   14: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   17: putstatic com/google/android/gms/common/zzg.zzfrc : Landroid/content/Context;
    //   20: ldc com/google/android/gms/common/zzg
    //   22: monitorexit
    //   23: return
    //   24: ldc 'GoogleCertificates'
    //   26: ldc 'GoogleCertificates has been initialized already'
    //   28: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: ldc com/google/android/gms/common/zzg
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/google/android/gms/common/zzg
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	36	finally
    //   13	20	36	finally
    //   24	32	36	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */