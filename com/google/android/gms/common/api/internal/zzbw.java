package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi;

public final class zzbw extends zzak {
  private final GoogleApi zzgaf;
  
  public zzbw(GoogleApi paramGoogleApi) {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    this.zzgaf = paramGoogleApi;
  }
  
  public final Looper getLooper() {
    return this.zzgaf.zzalj;
  }
  
  public final void zza(zzdh paramzzdh) {}
  
  public final void zzb(zzdh paramzzdh) {}
  
  public final zzm zze(zzm paramzzm) {
    return this.zzgaf.zzb(paramzzm);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */