package com.google.android.gms.common.api.internal;

public final class zzck {
  private final Object zzgat;
  
  private final String zzgaw;
  
  public zzck(Object paramObject, String paramString) {
    this.zzgat = paramObject;
    this.zzgaw = paramString;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzck))
      return false; 
    paramObject = paramObject;
    return (this.zzgat == ((zzck)paramObject).zzgat && this.zzgaw.equals(((zzck)paramObject).zzgaw));
  }
  
  public final int hashCode() {
    return System.identityHashCode(this.zzgat) * 31 + this.zzgaw.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */