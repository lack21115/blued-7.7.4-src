package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzau();
  
  @Deprecated
  private int zza;
  
  @Deprecated
  private int zzb;
  
  private long zzc;
  
  private int zzd;
  
  private zzbd[] zze;
  
  LocationAvailability(int paramInt1, int paramInt2, int paramInt3, long paramLong, zzbd[] paramArrayOfzzbd) {
    this.zzd = paramInt1;
    this.zza = paramInt2;
    this.zzb = paramInt3;
    this.zzc = paramLong;
    this.zze = paramArrayOfzzbd;
  }
  
  public static LocationAvailability extractLocationAvailability(Intent paramIntent) {
    if (!hasLocationAvailability(paramIntent))
      return null; 
    try {
      return (LocationAvailability)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    } catch (ClassCastException classCastException) {
      return null;
    } 
  }
  
  public static boolean hasLocationAvailability(Intent paramIntent) {
    return (paramIntent == null) ? false : paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (this.zza == ((LocationAvailability)paramObject).zza && this.zzb == ((LocationAvailability)paramObject).zzb && this.zzc == ((LocationAvailability)paramObject).zzc && this.zzd == ((LocationAvailability)paramObject).zzd && Arrays.equals((Object[])this.zze, (Object[])((LocationAvailability)paramObject).zze))
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzd), Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Long.valueOf(this.zzc), this.zze });
  }
  
  public final boolean isLocationAvailable() {
    return (this.zzd < 1000);
  }
  
  public final String toString() {
    boolean bool = isLocationAvailable();
    StringBuilder stringBuilder = new StringBuilder(48);
    stringBuilder.append("LocationAvailability[isLocationAvailable: ");
    stringBuilder.append(bool);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzd);
    SafeParcelWriter.writeTypedArray(paramParcel, 5, (Parcelable[])this.zze, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\LocationAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */