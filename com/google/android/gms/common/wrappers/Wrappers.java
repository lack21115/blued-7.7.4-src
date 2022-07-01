package com.google.android.gms.common.wrappers;

import android.content.Context;

public class Wrappers {
  private static Wrappers zzb = new Wrappers();
  
  private PackageManagerWrapper zza = null;
  
  public static PackageManagerWrapper packageManager(Context paramContext) {
    return zzb.zza(paramContext);
  }
  
  private final PackageManagerWrapper zza(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zza : Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   6: ifnonnull -> 36
    //   9: aload_1
    //   10: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   13: ifnonnull -> 19
    //   16: goto -> 24
    //   19: aload_1
    //   20: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   23: astore_1
    //   24: aload_0
    //   25: new com/google/android/gms/common/wrappers/PackageManagerWrapper
    //   28: dup
    //   29: aload_1
    //   30: invokespecial <init> : (Landroid/content/Context;)V
    //   33: putfield zza : Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   36: aload_0
    //   37: getfield zza : Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	45	finally
    //   19	24	45	finally
    //   24	36	45	finally
    //   36	41	45	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\wrappers\Wrappers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */