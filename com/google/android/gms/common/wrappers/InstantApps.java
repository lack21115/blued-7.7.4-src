package com.google.android.gms.common.wrappers;

import android.content.Context;

public class InstantApps {
  private static Context zza;
  
  private static Boolean zzb;
  
  public static boolean isInstantApp(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/common/wrappers/InstantApps
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   7: astore_2
    //   8: getstatic com/google/android/gms/common/wrappers/InstantApps.zza : Landroid/content/Context;
    //   11: ifnull -> 39
    //   14: getstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   17: ifnull -> 39
    //   20: getstatic com/google/android/gms/common/wrappers/InstantApps.zza : Landroid/content/Context;
    //   23: aload_2
    //   24: if_acmpne -> 39
    //   27: getstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   30: invokevirtual booleanValue : ()Z
    //   33: istore_1
    //   34: ldc com/google/android/gms/common/wrappers/InstantApps
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: aconst_null
    //   40: putstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   43: invokestatic isAtLeastO : ()Z
    //   46: ifeq -> 65
    //   49: aload_2
    //   50: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   53: invokevirtual isInstantApp : ()Z
    //   56: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   59: putstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   62: goto -> 92
    //   65: aload_0
    //   66: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   69: ldc 'com.google.android.instantapps.supervisor.InstantAppsRuntime'
    //   71: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   74: pop
    //   75: iconst_1
    //   76: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   79: putstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   82: goto -> 92
    //   85: iconst_0
    //   86: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   89: putstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   92: aload_2
    //   93: putstatic com/google/android/gms/common/wrappers/InstantApps.zza : Landroid/content/Context;
    //   96: getstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   99: invokevirtual booleanValue : ()Z
    //   102: istore_1
    //   103: ldc com/google/android/gms/common/wrappers/InstantApps
    //   105: monitorexit
    //   106: iload_1
    //   107: ireturn
    //   108: astore_0
    //   109: ldc com/google/android/gms/common/wrappers/InstantApps
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: goto -> 85
    // Exception table:
    //   from	to	target	type
    //   3	34	108	finally
    //   39	62	108	finally
    //   65	82	114	java/lang/ClassNotFoundException
    //   65	82	108	finally
    //   85	92	108	finally
    //   92	103	108	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\wrappers\InstantApps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */