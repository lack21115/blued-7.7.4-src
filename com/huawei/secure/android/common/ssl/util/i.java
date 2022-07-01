package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;

public class i {
  private static SharedPreferences a;
  
  public static SharedPreferences a(Context paramContext) {
    // Byte code:
    //   0: ldc com/huawei/secure/android/common/ssl/util/i
    //   2: monitorenter
    //   3: getstatic com/huawei/secure/android/common/ssl/util/i.a : Landroid/content/SharedPreferences;
    //   6: ifnonnull -> 46
    //   9: getstatic android/os/Build$VERSION.SDK_INT : I
    //   12: bipush #24
    //   14: if_icmplt -> 33
    //   17: aload_0
    //   18: invokevirtual createDeviceProtectedStorageContext : ()Landroid/content/Context;
    //   21: ldc 'aegis'
    //   23: iconst_0
    //   24: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   27: putstatic com/huawei/secure/android/common/ssl/util/i.a : Landroid/content/SharedPreferences;
    //   30: goto -> 46
    //   33: aload_0
    //   34: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   37: ldc 'aegis'
    //   39: iconst_0
    //   40: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   43: putstatic com/huawei/secure/android/common/ssl/util/i.a : Landroid/content/SharedPreferences;
    //   46: getstatic com/huawei/secure/android/common/ssl/util/i.a : Landroid/content/SharedPreferences;
    //   49: astore_0
    //   50: ldc com/huawei/secure/android/common/ssl/util/i
    //   52: monitorexit
    //   53: aload_0
    //   54: areturn
    //   55: astore_0
    //   56: ldc com/huawei/secure/android/common/ssl/util/i
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	55	finally
    //   33	46	55	finally
    //   46	50	55	finally
  }
  
  public static void a(String paramString, long paramLong, Context paramContext) {
    a(paramContext).edit().putLong(paramString, paramLong).apply();
  }
  
  public static long b(String paramString, long paramLong, Context paramContext) {
    return a(paramContext).getLong(paramString, paramLong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ss\\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */