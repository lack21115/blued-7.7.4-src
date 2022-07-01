package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzbd extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzbd> CREATOR = new zzbf();
  
  private final int zza;
  
  private final int zzb;
  
  private final long zzc;
  
  private final long zzd;
  
  zzbd(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
    this.zza = paramInt1;
    this.zzb = paramInt2;
    this.zzc = paramLong1;
    this.zzd = paramLong2;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (this.zza == ((zzbd)paramObject).zza && this.zzb == ((zzbd)paramObject).zzb && this.zzc == ((zzbd)paramObject).zzc && this.zzd == ((zzbd)paramObject).zzd)
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzb), Integer.valueOf(this.zza), Long.valueOf(this.zzd), Long.valueOf(this.zzc) });
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("NetworkLocationStatus:");
    stringBuilder.append(" Wifi status: ");
    stringBuilder.append(this.zza);
    stringBuilder.append(" Cell status: ");
    stringBuilder.append(this.zzb);
    stringBuilder.append(" elapsed time NS: ");
    stringBuilder.append(this.zzd);
    stringBuilder.append(" system time ms: ");
    stringBuilder.append(this.zzc);
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzd);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */