package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzag {
  private static final Object zzggs = new Object();
  
  private static zzag zzggt;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static zzag zzcp(Context paramContext) {
    synchronized (zzggs) {
      if (zzggt == null)
        zzggt = new zzai(paramContext.getApplicationContext()); 
      return zzggt;
    } 
  }
  
  protected abstract boolean zza$2a82e825(zzah paramzzah, ServiceConnection paramServiceConnection);
  
  public final void zza$5bbd53b4(String paramString1, String paramString2, int paramInt, ServiceConnection paramServiceConnection) {
    zzb$2a82e821(new zzah(paramString1, paramString2, paramInt), paramServiceConnection);
  }
  
  protected abstract void zzb$2a82e821(zzah paramzzah, ServiceConnection paramServiceConnection);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */