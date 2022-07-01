package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbg;

public final class zzh {
  public final Api zzfop;
  
  private final Api.ApiOptions zzfsm;
  
  private final boolean zzfud = true;
  
  private final int zzfue;
  
  public zzh(Api paramApi) {
    this.zzfop = paramApi;
    this.zzfsm = null;
    this.zzfue = System.identityHashCode(this);
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzh))
      return false; 
    paramObject = paramObject;
    return (!this.zzfud && !((zzh)paramObject).zzfud && zzbg.equal(this.zzfop, ((zzh)paramObject).zzfop) && zzbg.equal(this.zzfsm, ((zzh)paramObject).zzfsm));
  }
  
  public final int hashCode() {
    return this.zzfue;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */