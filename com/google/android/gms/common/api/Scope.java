package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public final class Scope extends zzbgl implements ReflectedParcelable {
  public static final Parcelable.Creator CREATOR = new zzf();
  
  private int zzehz;
  
  private final String zzftp;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  Scope(int paramInt, String paramString) {
    zzbq.zzh(paramString, "scopeUri must not be null or empty");
    this.zzehz = paramInt;
    this.zzftp = paramString;
  }
  
  public Scope(String paramString) {
    this(1, paramString);
  }
  
  public final boolean equals(Object paramObject) {
    return (this == paramObject) ? true : (!(paramObject instanceof Scope) ? false : this.zzftp.equals(((Scope)paramObject).zzftp));
  }
  
  public final int hashCode() {
    return this.zzftp.hashCode();
  }
  
  public final String toString() {
    return this.zzftp;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.zzehz);
    zzbgo.zza(paramParcel, 2, this.zzftp, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\Scope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */