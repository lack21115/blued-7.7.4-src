package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class zzj {
  private static Boolean zzgks;
  
  private static Boolean zzgkt;
  
  public static Boolean zzgku;
  
  @TargetApi(24)
  public static boolean zzcv(Context paramContext) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #24
    //   5: if_icmplt -> 13
    //   8: iconst_1
    //   9: istore_1
    //   10: goto -> 15
    //   13: iconst_0
    //   14: istore_1
    //   15: iload_1
    //   16: ifeq -> 66
    //   19: getstatic com/google/android/gms/common/util/zzj.zzgkt : Ljava/lang/Boolean;
    //   22: ifnonnull -> 57
    //   25: invokestatic zzanx : ()Z
    //   28: ifeq -> 48
    //   31: aload_0
    //   32: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   35: ldc 'cn.google'
    //   37: invokevirtual hasSystemFeature : (Ljava/lang/String;)Z
    //   40: ifeq -> 48
    //   43: iconst_1
    //   44: istore_2
    //   45: goto -> 50
    //   48: iconst_0
    //   49: istore_2
    //   50: iload_2
    //   51: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   54: putstatic com/google/android/gms/common/util/zzj.zzgkt : Ljava/lang/Boolean;
    //   57: getstatic com/google/android/gms/common/util/zzj.zzgkt : Ljava/lang/Boolean;
    //   60: invokevirtual booleanValue : ()Z
    //   63: ifeq -> 115
    //   66: getstatic com/google/android/gms/common/util/zzj.zzgks : Ljava/lang/Boolean;
    //   69: ifnonnull -> 104
    //   72: invokestatic zzanw : ()Z
    //   75: ifeq -> 95
    //   78: aload_0
    //   79: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   82: ldc 'android.hardware.type.watch'
    //   84: invokevirtual hasSystemFeature : (Ljava/lang/String;)Z
    //   87: ifeq -> 95
    //   90: iconst_1
    //   91: istore_2
    //   92: goto -> 97
    //   95: iconst_0
    //   96: istore_2
    //   97: iload_2
    //   98: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   101: putstatic com/google/android/gms/common/util/zzj.zzgks : Ljava/lang/Boolean;
    //   104: getstatic com/google/android/gms/common/util/zzj.zzgks : Ljava/lang/Boolean;
    //   107: invokevirtual booleanValue : ()Z
    //   110: ifeq -> 115
    //   113: iconst_1
    //   114: ireturn
    //   115: iconst_0
    //   116: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\commo\\util\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */