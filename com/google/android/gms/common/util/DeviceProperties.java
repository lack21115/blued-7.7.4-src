package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;

public final class DeviceProperties {
  private static Boolean zza;
  
  private static Boolean zzb;
  
  private static Boolean zzc;
  
  private static Boolean zzd;
  
  private static Boolean zze;
  
  private static Boolean zzf;
  
  private static Boolean zzg;
  
  private static Boolean zzh;
  
  public static boolean isAuto(Context paramContext) {
    return isAuto(paramContext.getPackageManager());
  }
  
  public static boolean isAuto(PackageManager paramPackageManager) {
    if (zzg == null) {
      boolean bool;
      if (PlatformVersion.isAtLeastO() && paramPackageManager.hasSystemFeature("android.hardware.type.automotive")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzg = Boolean.valueOf(bool);
    } 
    return zzg.booleanValue();
  }
  
  @Deprecated
  public static boolean isFeaturePhone(Context paramContext) {
    return false;
  }
  
  public static boolean isLatchsky(Context paramContext) {
    if (zze == null) {
      boolean bool;
      PackageManager packageManager = paramContext.getPackageManager();
      if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
        bool = true;
      } else {
        bool = false;
      } 
      zze = Boolean.valueOf(bool);
    } 
    return zze.booleanValue();
  }
  
  public static boolean isSidewinder(Context paramContext) {
    return zzb(paramContext);
  }
  
  public static boolean isTablet(Resources paramResources) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ifnonnull -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: getstatic com/google/android/gms/common/util/DeviceProperties.zza : Ljava/lang/Boolean;
    //   11: ifnonnull -> 105
    //   14: aload_0
    //   15: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   18: getfield screenLayout : I
    //   21: bipush #15
    //   23: iand
    //   24: iconst_3
    //   25: if_icmple -> 33
    //   28: iconst_1
    //   29: istore_1
    //   30: goto -> 35
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_1
    //   36: ifne -> 96
    //   39: getstatic com/google/android/gms/common/util/DeviceProperties.zzb : Ljava/lang/Boolean;
    //   42: ifnonnull -> 85
    //   45: aload_0
    //   46: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   49: astore_0
    //   50: aload_0
    //   51: getfield screenLayout : I
    //   54: bipush #15
    //   56: iand
    //   57: iconst_3
    //   58: if_icmpgt -> 76
    //   61: aload_0
    //   62: getfield smallestScreenWidthDp : I
    //   65: sipush #600
    //   68: if_icmplt -> 76
    //   71: iconst_1
    //   72: istore_2
    //   73: goto -> 78
    //   76: iconst_0
    //   77: istore_2
    //   78: iload_2
    //   79: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   82: putstatic com/google/android/gms/common/util/DeviceProperties.zzb : Ljava/lang/Boolean;
    //   85: iload_3
    //   86: istore_2
    //   87: getstatic com/google/android/gms/common/util/DeviceProperties.zzb : Ljava/lang/Boolean;
    //   90: invokevirtual booleanValue : ()Z
    //   93: ifeq -> 98
    //   96: iconst_1
    //   97: istore_2
    //   98: iload_2
    //   99: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   102: putstatic com/google/android/gms/common/util/DeviceProperties.zza : Ljava/lang/Boolean;
    //   105: getstatic com/google/android/gms/common/util/DeviceProperties.zza : Ljava/lang/Boolean;
    //   108: invokevirtual booleanValue : ()Z
    //   111: ireturn
  }
  
  public static boolean isTv(Context paramContext) {
    return isTv(paramContext.getPackageManager());
  }
  
  public static boolean isTv(PackageManager paramPackageManager) {
    if (zzh == null) {
      boolean bool;
      if (paramPackageManager.hasSystemFeature("com.google.android.tv") || paramPackageManager.hasSystemFeature("android.hardware.type.television") || paramPackageManager.hasSystemFeature("android.software.leanback")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzh = Boolean.valueOf(bool);
    } 
    return zzh.booleanValue();
  }
  
  public static boolean isUserBuild() {
    return "user".equals(Build.TYPE);
  }
  
  public static boolean isWearable(Context paramContext) {
    return isWearable(paramContext.getPackageManager());
  }
  
  public static boolean isWearable(PackageManager paramPackageManager) {
    if (zzc == null) {
      boolean bool;
      if (PlatformVersion.isAtLeastKitKatWatch() && paramPackageManager.hasSystemFeature("android.hardware.type.watch")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzc = Boolean.valueOf(bool);
    } 
    return zzc.booleanValue();
  }
  
  public static boolean isWearableWithoutPlayStore(Context paramContext) {
    return (isWearable(paramContext) && (!PlatformVersion.isAtLeastN() || (zzb(paramContext) && !PlatformVersion.isAtLeastO())));
  }
  
  public static boolean zza(Context paramContext) {
    if (zzf == null) {
      boolean bool;
      if (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot") || paramContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzf = Boolean.valueOf(bool);
    } 
    return zzf.booleanValue();
  }
  
  private static boolean zzb(Context paramContext) {
    if (zzd == null) {
      boolean bool;
      if (PlatformVersion.isAtLeastLollipop() && paramContext.getPackageManager().hasSystemFeature("cn.google")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzd = Boolean.valueOf(bool);
    } 
    return zzd.booleanValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\DeviceProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */