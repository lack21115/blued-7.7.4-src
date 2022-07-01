package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

final class zzbv implements Runnable {
  zzbv(zzbu paramzzbu, ConnectionResult paramConnectionResult) {}
  
  public final void run() {
    if (this.zzgab.isSuccess()) {
      this.zzgae.zzgad = true;
      if (this.zzgae.zzfwd.zzacc()) {
        this.zzgae.zzakp();
        return;
      } 
      this.zzgae.zzfwd.zza(null, Collections.emptySet());
      return;
    } 
    ((zzbo)zzbm.zzj(this.zzgae.zzfzq).get(this.zzgae.zzfsn)).onConnectionFailed(this.zzgab);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */