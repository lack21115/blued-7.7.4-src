package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzbq;

public final class Api {
  public final String mName;
  
  private final Api$zza zzfsa;
  
  private final Api$zzf zzfsc;
  
  public Api(String paramString, Api$zza paramApi$zza, Api$zzf paramApi$zzf) {
    zzbq.checkNotNull(paramApi$zza, "Cannot construct an Api with a null ClientBuilder");
    zzbq.checkNotNull(paramApi$zzf, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.zzfsa = paramApi$zza;
    this.zzfsc = paramApi$zzf;
  }
  
  public final Api$zza zzahl() {
    boolean bool;
    if (this.zzfsa != null) {
      bool = true;
    } else {
      bool = false;
    } 
    zzbq.zza(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
    return this.zzfsa;
  }
  
  public final Api$zzc zzahm() {
    if (this.zzfsc != null)
      return this.zzfsc; 
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */