package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbz;
import java.util.Iterator;

public final class zzal implements zzbh {
  final zzbi zzfxd;
  
  boolean zzfxe = false;
  
  public zzal(zzbi paramzzbi) {
    this.zzfxd = paramzzbi;
  }
  
  public final void begin() {}
  
  public final void connect() {
    if (this.zzfxe) {
      this.zzfxe = false;
      this.zzfxd.zza(new zzan(this, this));
    } 
  }
  
  public final boolean disconnect() {
    if (this.zzfxe)
      return false; 
    if (this.zzfxd.zzfvq.zzajt()) {
      this.zzfxe = true;
      Iterator iterator = this.zzfxd.zzfvq.zzfyo.iterator();
      while (iterator.hasNext())
        ((zzdh)iterator.next()).zzgbj = null; 
      return false;
    } 
    this.zzfxd.zzg$5d4cef71();
    return true;
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt) {
    this.zzfxd.zzg$5d4cef71();
    this.zzfxd.zzfzc.zzf(paramInt, this.zzfxe);
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api paramApi, boolean paramBoolean) {}
  
  public final zzm zze(zzm paramzzm) {
    try {
      Api.zzg zzg;
      this.zzfxd.zzfvq.zzfyp.zzb(paramzzm);
      zzba zzba = this.zzfxd.zzfvq;
      Api.zzc zzc = paramzzm.zzfus;
      Api.zze zze2 = (Api.zze)zzba.zzfyj.get(zzc);
      zzbq.checkNotNull(zze2, "Appropriate Api was not requested.");
      if (!zze2.isConnected() && this.zzfxd.zzfyy.containsKey(paramzzm.zzfus)) {
        paramzzm.zzu(new Status(17));
        return paramzzm;
      } 
      Api.zze zze1 = zze2;
      if (zze2 instanceof zzbz)
        zzg = zzbz.zzanb(); 
      paramzzm.zzb((Api.zzb)zzg);
      return paramzzm;
    } catch (DeadObjectException deadObjectException) {
      this.zzfxd.zza(new zzam(this, this));
      return paramzzm;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */