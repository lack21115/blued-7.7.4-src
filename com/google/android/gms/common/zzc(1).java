package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
final class zzc {
  private static volatile zzq zza;
  
  private static final Object zzb = new Object();
  
  private static Context zzc;
  
  static zzl zza(String paramString, zzd paramzzd, boolean paramBoolean1, boolean paramBoolean2) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      return zzb(paramString, paramzzd, paramBoolean1, paramBoolean2);
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  static void zza(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/common/zzc
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/common/zzc.zzc : Landroid/content/Context;
    //   6: ifnonnull -> 24
    //   9: aload_0
    //   10: ifnull -> 32
    //   13: aload_0
    //   14: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   17: putstatic com/google/android/gms/common/zzc.zzc : Landroid/content/Context;
    //   20: ldc com/google/android/gms/common/zzc
    //   22: monitorexit
    //   23: return
    //   24: ldc 'GoogleCertificates'
    //   26: ldc 'GoogleCertificates has been initialized already'
    //   28: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: ldc com/google/android/gms/common/zzc
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/google/android/gms/common/zzc
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	36	finally
    //   13	20	36	finally
    //   24	32	36	finally
  }
  
  private static zzl zzb(String paramString, zzd paramzzd, boolean paramBoolean1, boolean paramBoolean2) {
    try {
      if (zza == null) {
        Preconditions.checkNotNull(zzc);
        synchronized (zzb) {
          if (zza == null)
            zza = zzp.zza(DynamiteModule.load(zzc, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl")); 
        } 
      } 
      Preconditions.checkNotNull(zzc);
      zzj zzj = new zzj(paramString, paramzzd, paramBoolean1, paramBoolean2);
      try {
        paramBoolean2 = zza.zza(zzj, ObjectWrapper.wrap(zzc.getPackageManager()));
        return paramBoolean2 ? zzl.zza() : zzl.zza(new zze(paramBoolean1, paramString, paramzzd));
      } catch (RemoteException remoteException) {
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)remoteException);
        return zzl.zza("module call", (Throwable)remoteException);
      } 
    } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loadingException) {
      Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)loadingException);
      paramString = String.valueOf(loadingException.getMessage());
      if (paramString.length() != 0) {
        paramString = "module init: ".concat(paramString);
      } else {
        paramString = new String("module init: ");
      } 
      return zzl.zza(paramString, (Throwable)loadingException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */