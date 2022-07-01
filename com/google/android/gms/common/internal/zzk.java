package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class zzk extends zzax {
  private zzd zzgfm;
  
  private final int zzgfn;
  
  public zzk(zzd paramzzd, int paramInt) {
    this.zzgfm = paramzzd;
    this.zzgfn = paramInt;
  }
  
  public final void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
    zzbq.checkNotNull(this.zzgfm, "onPostInitComplete can be called only once per call to getRemoteService");
    this.zzgfm.zza(paramInt, paramIBinder, paramBundle, this.zzgfn);
    this.zzgfm = null;
  }
  
  public final void zza$68e2e3e6() {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */