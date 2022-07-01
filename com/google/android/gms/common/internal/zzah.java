package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

public final class zzah {
  final ComponentName mComponentName;
  
  private final String zzdxe;
  
  final String zzggu;
  
  final int zzggv;
  
  public zzah(String paramString1, String paramString2, int paramInt) {
    this.zzdxe = zzbq.zzgv(paramString1);
    this.zzggu = zzbq.zzgv(paramString2);
    this.mComponentName = null;
    this.zzggv = paramInt;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzah))
      return false; 
    paramObject = paramObject;
    return (zzbg.equal(this.zzdxe, ((zzah)paramObject).zzdxe) && zzbg.equal(this.zzggu, ((zzah)paramObject).zzggu) && zzbg.equal(this.mComponentName, ((zzah)paramObject).mComponentName) && this.zzggv == ((zzah)paramObject).zzggv);
  }
  
  public final int hashCode() {
    return Arrays.hashCode(new Object[] { this.zzdxe, this.zzggu, this.mComponentName, Integer.valueOf(this.zzggv) });
  }
  
  public final String toString() {
    return (this.zzdxe == null) ? this.mComponentName.flattenToString() : this.zzdxe;
  }
  
  public final Intent zzcq$7ec49240() {
    return (this.zzdxe != null) ? (new Intent(this.zzdxe)).setPackage(this.zzggu) : (new Intent()).setComponent(this.mComponentName);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */