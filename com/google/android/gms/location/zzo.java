package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzo extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzo> CREATOR = new zzn();
  
  private boolean zza;
  
  private long zzb;
  
  private float zzc;
  
  private long zzd;
  
  private int zze;
  
  public zzo() {
    this(true, 50L, 0.0F, Long.MAX_VALUE, 2147483647);
  }
  
  zzo(boolean paramBoolean, long paramLong1, float paramFloat, long paramLong2, int paramInt) {
    this.zza = paramBoolean;
    this.zzb = paramLong1;
    this.zzc = paramFloat;
    this.zzd = paramLong2;
    this.zze = paramInt;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzo))
      return false; 
    paramObject = paramObject;
    return (this.zza == ((zzo)paramObject).zza && this.zzb == ((zzo)paramObject).zzb && Float.compare(this.zzc, ((zzo)paramObject).zzc) == 0 && this.zzd == ((zzo)paramObject).zzd && this.zze == ((zzo)paramObject).zze);
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Boolean.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzc), Long.valueOf(this.zzd), Integer.valueOf(this.zze) });
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DeviceOrientationRequest[mShouldUseMag=");
    stringBuilder.append(this.zza);
    stringBuilder.append(" mMinimumSamplingPeriodMs=");
    stringBuilder.append(this.zzb);
    stringBuilder.append(" mSmallestAngleChangeRadians=");
    stringBuilder.append(this.zzc);
    long l = this.zzd;
    if (l != Long.MAX_VALUE) {
      long l1 = SystemClock.elapsedRealtime();
      stringBuilder.append(" expireIn=");
      stringBuilder.append(l - l1);
      stringBuilder.append("ms");
    } 
    if (this.zze != Integer.MAX_VALUE) {
      stringBuilder.append(" num=");
      stringBuilder.append(this.zze);
    } 
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, this.zza);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzd);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zze);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */