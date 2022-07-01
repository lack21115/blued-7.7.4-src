package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

@Deprecated
public class PooledExecutorsProvider {
  private static PooledExecutorFactory zza;
  
  @Deprecated
  public static PooledExecutorFactory getInstance() {
    // Byte code:
    //   0: ldc com/google/android/gms/common/providers/PooledExecutorsProvider
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/common/providers/PooledExecutorsProvider.zza : Lcom/google/android/gms/common/providers/PooledExecutorsProvider$PooledExecutorFactory;
    //   6: ifnonnull -> 19
    //   9: new com/google/android/gms/common/providers/zza
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/google/android/gms/common/providers/PooledExecutorsProvider.zza : Lcom/google/android/gms/common/providers/PooledExecutorsProvider$PooledExecutorFactory;
    //   19: getstatic com/google/android/gms/common/providers/PooledExecutorsProvider.zza : Lcom/google/android/gms/common/providers/PooledExecutorsProvider$PooledExecutorFactory;
    //   22: astore_0
    //   23: ldc com/google/android/gms/common/providers/PooledExecutorsProvider
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/google/android/gms/common/providers/PooledExecutorsProvider
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public static interface PooledExecutorFactory {
    @Deprecated
    ScheduledExecutorService newSingleThreadScheduledExecutor();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\providers\PooledExecutorsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */