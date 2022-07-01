package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;

public final class zzc extends zza {
  private zzm zzftx;
  
  public zzc(zzm paramzzm) {
    this.zzftx = paramzzm;
  }
  
  public final void zza(zzae paramzzae, boolean paramBoolean) {
    zzm zzm1 = this.zzftx;
    paramzzae.zzfww.put(zzm1, Boolean.valueOf(paramBoolean));
    zzm1.zza(new zzaf(paramzzae, zzm1));
  }
  
  public final void zza(zzbo paramzzbo) {
    try {
      this.zzftx.zzb((Api.zzb)paramzzbo.zzfwd);
      return;
    } catch (RuntimeException runtimeException) {
      String str1 = runtimeException.getClass().getSimpleName();
      String str2 = runtimeException.getLocalizedMessage();
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 2 + String.valueOf(str2).length());
      stringBuilder.append(str1);
      stringBuilder.append(": ");
      stringBuilder.append(str2);
      Status status = new Status(10, stringBuilder.toString());
      this.zzftx.zzu(status);
      return;
    } 
  }
  
  public final void zzs(Status paramStatus) {
    this.zzftx.zzu(paramStatus);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */