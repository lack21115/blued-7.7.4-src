package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzbig;
import com.google.android.gms.internal.zzbih;

public final class zzbf {
  private static Object sLock = new Object();
  
  private static boolean zzcqk;
  
  private static int zzghn;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int zzcs(Context paramContext) {
    synchronized (sLock) {
      if (!zzcqk) {
        zzcqk = true;
        String str = paramContext.getPackageName();
        zzbig zzbig = zzbih.zzdd(paramContext);
        try {
          Bundle bundle = (zzbig.getApplicationInfo(str, 128)).metaData;
          if (bundle != null) {
            bundle.getString("com.google.app.id");
            zzghn = bundle.getInt("com.google.android.gms.version");
          } 
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
          Log.wtf("MetadataValueReader", "This should never happen.", (Throwable)nameNotFoundException);
        } 
        return zzghn;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */