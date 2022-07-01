package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

public final class CrashUtils {
  private static final String[] zza = new String[] { "android.", "com.android.", "dalvik.", "java.", "javax." };
  
  private static DropBoxManager zzb = null;
  
  private static boolean zzc = false;
  
  private static int zzd = -1;
  
  private static int zze = 0;
  
  private static int zzf = 0;
  
  public static boolean addDynamiteErrorToDropBox(Context paramContext, Throwable paramThrowable) {
    return zza(paramContext, paramThrowable, 536870912);
  }
  
  private static boolean zza(Context paramContext, Throwable paramThrowable, int paramInt) {
    try {
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramThrowable);
      return false;
    } catch (Exception exception) {
      Log.e("CrashUtils", "Error adding exception to DropBox!", exception);
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\CrashUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */