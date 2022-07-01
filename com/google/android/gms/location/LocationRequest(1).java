package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<LocationRequest> CREATOR = new zzav();
  
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  
  public static final int PRIORITY_LOW_POWER = 104;
  
  public static final int PRIORITY_NO_POWER = 105;
  
  private int zza = 102;
  
  private long zzb = 3600000L;
  
  private long zzc = 600000L;
  
  private boolean zzd = false;
  
  private long zze = Long.MAX_VALUE;
  
  private int zzf = Integer.MAX_VALUE;
  
  private float zzg = 0.0F;
  
  private long zzh = 0L;
  
  public LocationRequest() {}
  
  LocationRequest(int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt2, float paramFloat, long paramLong4) {}
  
  public static LocationRequest create() {
    return new LocationRequest();
  }
  
  private static void zza(long paramLong) {
    if (paramLong >= 0L)
      return; 
    StringBuilder stringBuilder = new StringBuilder(38);
    stringBuilder.append("invalid interval: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LocationRequest))
      return false; 
    paramObject = paramObject;
    return (this.zza == ((LocationRequest)paramObject).zza && this.zzb == ((LocationRequest)paramObject).zzb && this.zzc == ((LocationRequest)paramObject).zzc && this.zzd == ((LocationRequest)paramObject).zzd && this.zze == ((LocationRequest)paramObject).zze && this.zzf == ((LocationRequest)paramObject).zzf && this.zzg == ((LocationRequest)paramObject).zzg && getMaxWaitTime() == paramObject.getMaxWaitTime());
  }
  
  public final long getExpirationTime() {
    return this.zze;
  }
  
  public final long getFastestInterval() {
    return this.zzc;
  }
  
  public final long getInterval() {
    return this.zzb;
  }
  
  public final long getMaxWaitTime() {
    long l2 = this.zzh;
    long l3 = this.zzb;
    long l1 = l2;
    if (l2 < l3)
      l1 = l3; 
    return l1;
  }
  
  public final int getNumUpdates() {
    return this.zzf;
  }
  
  public final int getPriority() {
    return this.zza;
  }
  
  public final float getSmallestDisplacement() {
    return this.zzg;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzg), Long.valueOf(this.zzh) });
  }
  
  public final boolean isFastestIntervalExplicitlySet() {
    return this.zzd;
  }
  
  public final LocationRequest setExpirationDuration(long paramLong) {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {
      this.zze = Long.MAX_VALUE;
    } else {
      this.zze = paramLong + l;
    } 
    if (this.zze < 0L)
      this.zze = 0L; 
    return this;
  }
  
  public final LocationRequest setExpirationTime(long paramLong) {
    this.zze = paramLong;
    if (this.zze < 0L)
      this.zze = 0L; 
    return this;
  }
  
  public final LocationRequest setFastestInterval(long paramLong) {
    zza(paramLong);
    this.zzd = true;
    this.zzc = paramLong;
    return this;
  }
  
  public final LocationRequest setInterval(long paramLong) {
    zza(paramLong);
    this.zzb = paramLong;
    if (!this.zzd)
      this.zzc = (long)(this.zzb / 6.0D); 
    return this;
  }
  
  public final LocationRequest setMaxWaitTime(long paramLong) {
    zza(paramLong);
    this.zzh = paramLong;
    return this;
  }
  
  public final LocationRequest setNumUpdates(int paramInt) {
    if (paramInt > 0) {
      this.zzf = paramInt;
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder(31);
    stringBuilder.append("invalid numUpdates: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final LocationRequest setPriority(int paramInt) {
    if (paramInt == 100 || paramInt == 102 || paramInt == 104 || paramInt == 105) {
      this.zza = paramInt;
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder(28);
    stringBuilder.append("invalid quality: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final LocationRequest setSmallestDisplacement(float paramFloat) {
    if (paramFloat >= 0.0F) {
      this.zzg = paramFloat;
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder(37);
    stringBuilder.append("invalid displacement: ");
    stringBuilder.append(paramFloat);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Request[");
    int i = this.zza;
    if (i != 100) {
      if (i != 102) {
        if (i != 104) {
          if (i != 105) {
            str = "???";
          } else {
            str = "PRIORITY_NO_POWER";
          } 
        } else {
          str = "PRIORITY_LOW_POWER";
        } 
      } else {
        str = "PRIORITY_BALANCED_POWER_ACCURACY";
      } 
    } else {
      str = "PRIORITY_HIGH_ACCURACY";
    } 
    stringBuilder.append(str);
    if (this.zza != 105) {
      stringBuilder.append(" requested=");
      stringBuilder.append(this.zzb);
      stringBuilder.append("ms");
    } 
    stringBuilder.append(" fastest=");
    stringBuilder.append(this.zzc);
    stringBuilder.append("ms");
    if (this.zzh > this.zzb) {
      stringBuilder.append(" maxWait=");
      stringBuilder.append(this.zzh);
      stringBuilder.append("ms");
    } 
    if (this.zzg > 0.0F) {
      stringBuilder.append(" smallestDisplacement=");
      stringBuilder.append(this.zzg);
      stringBuilder.append("m");
    } 
    long l = this.zze;
    if (l != Long.MAX_VALUE) {
      long l1 = SystemClock.elapsedRealtime();
      stringBuilder.append(" expireIn=");
      stringBuilder.append(l - l1);
      stringBuilder.append("ms");
    } 
    if (this.zzf != Integer.MAX_VALUE) {
      stringBuilder.append(" num=");
      stringBuilder.append(this.zzf);
    } 
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzd);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zze);
    SafeParcelWriter.writeInt(paramParcel, 6, this.zzf);
    SafeParcelWriter.writeFloat(paramParcel, 7, this.zzg);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzh);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */