package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public class GoogleSignatureVerifier {
  @Nullable
  private static GoogleSignatureVerifier zza;
  
  private final Context zzb;
  
  private volatile String zzc;
  
  private GoogleSignatureVerifier(Context paramContext) {
    this.zzb = paramContext.getApplicationContext();
  }
  
  public static GoogleSignatureVerifier getInstance(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: ldc com/google/android/gms/common/GoogleSignatureVerifier
    //   7: monitorenter
    //   8: getstatic com/google/android/gms/common/GoogleSignatureVerifier.zza : Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   11: ifnonnull -> 29
    //   14: aload_0
    //   15: invokestatic zza : (Landroid/content/Context;)V
    //   18: new com/google/android/gms/common/GoogleSignatureVerifier
    //   21: dup
    //   22: aload_0
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: putstatic com/google/android/gms/common/GoogleSignatureVerifier.zza : Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   29: ldc com/google/android/gms/common/GoogleSignatureVerifier
    //   31: monitorexit
    //   32: getstatic com/google/android/gms/common/GoogleSignatureVerifier.zza : Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   35: areturn
    //   36: astore_0
    //   37: ldc com/google/android/gms/common/GoogleSignatureVerifier
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   8	29	36	finally
    //   29	32	36	finally
    //   37	40	36	finally
  }
  
  @Nullable
  private static zzd zza(PackageInfo paramPackageInfo, zzd... paramVarArgs) {
    if (paramPackageInfo.signatures == null)
      return null; 
    if (paramPackageInfo.signatures.length != 1) {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    } 
    Signature[] arrayOfSignature = paramPackageInfo.signatures;
    int i = 0;
    zzg zzg = new zzg(arrayOfSignature[0].toByteArray());
    while (i < paramVarArgs.length) {
      if (paramVarArgs[i].equals(zzg))
        return paramVarArgs[i]; 
      i++;
    } 
    return null;
  }
  
  private final zzl zza(String paramString) {
    if (paramString == null)
      return zzl.zza("null pkg"); 
    if (paramString.equals(this.zzc))
      return zzl.zza(); 
    try {
      zzl zzl;
      PackageInfo packageInfo = Wrappers.packageManager(this.zzb).getPackageInfo(paramString, 64);
      boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
      if (packageInfo == null) {
        zzl = zzl.zza("null pkg");
      } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
        zzl = zzl.zza("single cert required");
      } else {
        zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
        String str = packageInfo.packageName;
        zzl = zzc.zza(str, zzg, bool, false);
        if (zzl.zza && packageInfo.applicationInfo != null && (packageInfo.applicationInfo.flags & 0x2) != 0 && (zzc.zza(str, zzg, false, true)).zza)
          zzl = zzl.zza("debuggable release cert app rejected"); 
      } 
      if (zzl.zza)
        this.zzc = paramString; 
      return zzl;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "no pkg ".concat(paramString);
      } else {
        paramString = new String("no pkg ");
      } 
      return zzl.zza(paramString);
    } 
  }
  
  private final zzl zza(String paramString, int paramInt) {
    zzl zzl;
    try {
      PackageInfo packageInfo = Wrappers.packageManager(this.zzb).zza(paramString, 64, paramInt);
      boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
      if (packageInfo == null)
        return zzl.zza("null pkg"); 
      if (packageInfo.signatures == null || packageInfo.signatures.length != 1)
        return zzl.zza("single cert required"); 
      zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
      String str = packageInfo.packageName;
      zzl = zzc.zza(str, zzg, bool, false);
      if (zzl.zza && packageInfo.applicationInfo != null && (packageInfo.applicationInfo.flags & 0x2) != 0 && (zzc.zza(str, zzg, false, true)).zza)
        return zzl.zza("debuggable release cert app rejected"); 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "no pkg ".concat(paramString);
      } else {
        paramString = new String("no pkg ");
      } 
      return zzl.zza(paramString);
    } 
    return zzl;
  }
  
  public static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean) {
    if (paramPackageInfo != null && paramPackageInfo.signatures != null) {
      zzd zzd;
      if (paramBoolean) {
        zzd = zza(paramPackageInfo, zzi.zza);
      } else {
        zzd = zza((PackageInfo)zzd, new zzd[] { zzi.zza[0] });
      } 
      if (zzd != null)
        return true; 
    } 
    return false;
  }
  
  public boolean isGooglePublicSignedPackage(PackageInfo paramPackageInfo) {
    if (paramPackageInfo == null)
      return false; 
    if (zza(paramPackageInfo, false))
      return true; 
    if (zza(paramPackageInfo, true)) {
      if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb))
        return true; 
      Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    } 
    return false;
  }
  
  public boolean isPackageGoogleSigned(String paramString) {
    zzl zzl = zza(paramString);
    zzl.zzc();
    return zzl.zza;
  }
  
  public boolean isUidGoogleSigned(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzb : Landroid/content/Context;
    //   4: invokestatic packageManager : (Landroid/content/Context;)Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   7: iload_1
    //   8: invokevirtual zza : (I)[Ljava/lang/String;
    //   11: astore #5
    //   13: aload #5
    //   15: ifnull -> 83
    //   18: aload #5
    //   20: arraylength
    //   21: ifne -> 27
    //   24: goto -> 83
    //   27: aconst_null
    //   28: astore #4
    //   30: aload #5
    //   32: arraylength
    //   33: istore_3
    //   34: iconst_0
    //   35: istore_2
    //   36: iload_2
    //   37: iload_3
    //   38: if_icmpge -> 70
    //   41: aload_0
    //   42: aload #5
    //   44: iload_2
    //   45: aaload
    //   46: iload_1
    //   47: invokespecial zza : (Ljava/lang/String;I)Lcom/google/android/gms/common/zzl;
    //   50: astore #4
    //   52: aload #4
    //   54: getfield zza : Z
    //   57: ifeq -> 63
    //   60: goto -> 90
    //   63: iload_2
    //   64: iconst_1
    //   65: iadd
    //   66: istore_2
    //   67: goto -> 36
    //   70: aload #4
    //   72: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast com/google/android/gms/common/zzl
    //   78: astore #4
    //   80: goto -> 90
    //   83: ldc 'no pkgs'
    //   85: invokestatic zza : (Ljava/lang/String;)Lcom/google/android/gms/common/zzl;
    //   88: astore #4
    //   90: aload #4
    //   92: invokevirtual zzc : ()V
    //   95: aload #4
    //   97: getfield zza : Z
    //   100: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\GoogleSignatureVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */