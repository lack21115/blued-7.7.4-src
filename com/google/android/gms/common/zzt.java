package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;

public class zzt {
  private static zzt zzfrx;
  
  private zzt(Context paramContext) {
    paramContext.getApplicationContext();
  }
  
  private static zzh zza(PackageInfo paramPackageInfo, zzh... paramVarArgs) {
    if (paramPackageInfo.signatures == null)
      return null; 
    if (paramPackageInfo.signatures.length != 1) {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    } 
    Signature[] arrayOfSignature = paramPackageInfo.signatures;
    int i = 0;
    zzi zzi = new zzi(arrayOfSignature[0].toByteArray());
    while (i < paramVarArgs.length) {
      if (paramVarArgs[i].equals(zzi))
        return paramVarArgs[i]; 
      i++;
    } 
    return null;
  }
  
  public static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean) {
    if (paramPackageInfo != null && paramPackageInfo.signatures != null) {
      zzh[] arrayOfZzh;
      if (paramBoolean) {
        arrayOfZzh = zzk.zzfrh;
      } else {
        arrayOfZzh = new zzh[1];
        arrayOfZzh[0] = zzk.zzfrh[0];
      } 
      zzh zzh = zza(paramPackageInfo, arrayOfZzh);
      if (zzh != null)
        return true; 
    } 
    return false;
  }
  
  public static zzt zzcj(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: ldc com/google/android/gms/common/zzt
    //   7: monitorenter
    //   8: getstatic com/google/android/gms/common/zzt.zzfrx : Lcom/google/android/gms/common/zzt;
    //   11: ifnonnull -> 29
    //   14: aload_0
    //   15: invokestatic zzch : (Landroid/content/Context;)V
    //   18: new com/google/android/gms/common/zzt
    //   21: dup
    //   22: aload_0
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: putstatic com/google/android/gms/common/zzt.zzfrx : Lcom/google/android/gms/common/zzt;
    //   29: ldc com/google/android/gms/common/zzt
    //   31: monitorexit
    //   32: getstatic com/google/android/gms/common/zzt.zzfrx : Lcom/google/android/gms/common/zzt;
    //   35: areturn
    //   36: astore_0
    //   37: ldc com/google/android/gms/common/zzt
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   8	29	36	finally
    //   29	32	36	finally
    //   37	40	36	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */