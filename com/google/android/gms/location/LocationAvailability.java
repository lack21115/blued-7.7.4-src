package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

public final class LocationAvailability extends zzbgl implements ReflectedParcelable {
  public static final Parcelable.Creator CREATOR = new zzaa();
  
  @Deprecated
  private int zzisb;
  
  @Deprecated
  private int zzisc;
  
  private long zzisd;
  
  private int zzise;
  
  private zzaj[] zzisf;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  LocationAvailability(int paramInt1, int paramInt2, int paramInt3, long paramLong, zzaj[] paramArrayOfzzaj) {
    this.zzise = paramInt1;
    this.zzisb = paramInt2;
    this.zzisc = paramInt3;
    this.zzisd = paramLong;
    this.zzisf = paramArrayOfzzaj;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (this.zzisb == ((LocationAvailability)paramObject).zzisb && this.zzisc == ((LocationAvailability)paramObject).zzisc && this.zzisd == ((LocationAvailability)paramObject).zzisd && this.zzise == ((LocationAvailability)paramObject).zzise && Arrays.equals((Object[])this.zzisf, (Object[])((LocationAvailability)paramObject).zzisf))
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.zzise), Integer.valueOf(this.zzisb), Integer.valueOf(this.zzisc), Long.valueOf(this.zzisd), this.zzisf });
  }
  
  public final String toString() {
    boolean bool;
    if (this.zzise < 1000) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = new StringBuilder(48);
    stringBuilder.append("LocationAvailability[isLocationAvailable: ");
    stringBuilder.append(bool);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.zzisb);
    zzbgo.zzc(paramParcel, 2, this.zzisc);
    zzbgo.zza(paramParcel, 3, this.zzisd);
    zzbgo.zzc(paramParcel, 4, this.zzise);
    zzbgo.zza$2d7953c6(paramParcel, 5, (Parcelable[])this.zzisf, paramInt);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\location\LocationAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */