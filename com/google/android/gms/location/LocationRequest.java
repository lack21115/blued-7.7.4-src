package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

public final class LocationRequest extends zzbgl implements ReflectedParcelable {
  public static final Parcelable.Creator CREATOR = new zzab();
  
  private int mPriority = 102;
  
  private int zzirl = Integer.MAX_VALUE;
  
  private long zzirp = Long.MAX_VALUE;
  
  private long zzisg = 3600000L;
  
  private long zzish = 600000L;
  
  private boolean zzisi = false;
  
  private float zzisj = 0.0F;
  
  private long zzisk = 0L;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public LocationRequest() {}
  
  LocationRequest(int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt2, float paramFloat, long paramLong4) {}
  
  public static LocationRequest create() {
    return new LocationRequest();
  }
  
  private long getMaxWaitTime() {
    long l2 = this.zzisk;
    long l1 = l2;
    if (l2 < this.zzisg)
      l1 = this.zzisg; 
    return l1;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LocationRequest))
      return false; 
    paramObject = paramObject;
    return (this.mPriority == ((LocationRequest)paramObject).mPriority && this.zzisg == ((LocationRequest)paramObject).zzisg && this.zzish == ((LocationRequest)paramObject).zzish && this.zzisi == ((LocationRequest)paramObject).zzisi && this.zzirp == ((LocationRequest)paramObject).zzirp && this.zzirl == ((LocationRequest)paramObject).zzirl && this.zzisj == ((LocationRequest)paramObject).zzisj && getMaxWaitTime() == paramObject.getMaxWaitTime());
  }
  
  public final int hashCode() {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.mPriority), Long.valueOf(this.zzisg), Float.valueOf(this.zzisj), Long.valueOf(this.zzisk) });
  }
  
  public final LocationRequest setInterval(long paramLong) {
    if (paramLong >= 0L) {
      this.zzisg = paramLong;
      if (!this.zzisi)
        this.zzish = (long)(this.zzisg / 6.0D); 
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder(38);
    stringBuilder.append("invalid interval: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final LocationRequest setPriority(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder(28);
        stringBuilder.append("invalid quality: ");
        stringBuilder.append(paramInt);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 100:
      case 102:
      case 104:
      case 105:
        break;
    } 
    this.mPriority = paramInt;
    return this;
  }
  
  public final String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Request[");
    switch (this.mPriority) {
      default:
        str = "???";
        break;
      case 105:
        str = "PRIORITY_NO_POWER";
        break;
      case 104:
        str = "PRIORITY_LOW_POWER";
        break;
      case 102:
        str = "PRIORITY_BALANCED_POWER_ACCURACY";
        break;
      case 100:
        str = "PRIORITY_HIGH_ACCURACY";
        break;
    } 
    stringBuilder.append(str);
    if (this.mPriority != 105) {
      stringBuilder.append(" requested=");
      stringBuilder.append(this.zzisg);
      stringBuilder.append("ms");
    } 
    stringBuilder.append(" fastest=");
    stringBuilder.append(this.zzish);
    stringBuilder.append("ms");
    if (this.zzisk > this.zzisg) {
      stringBuilder.append(" maxWait=");
      stringBuilder.append(this.zzisk);
      stringBuilder.append("ms");
    } 
    if (this.zzisj > 0.0F) {
      stringBuilder.append(" smallestDisplacement=");
      stringBuilder.append(this.zzisj);
      stringBuilder.append("m");
    } 
    if (this.zzirp != Long.MAX_VALUE) {
      long l1 = this.zzirp;
      long l2 = SystemClock.elapsedRealtime();
      stringBuilder.append(" expireIn=");
      stringBuilder.append(l1 - l2);
      stringBuilder.append("ms");
    } 
    if (this.zzirl != Integer.MAX_VALUE) {
      stringBuilder.append(" num=");
      stringBuilder.append(this.zzirl);
    } 
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.mPriority);
    zzbgo.zza(paramParcel, 2, this.zzisg);
    zzbgo.zza(paramParcel, 3, this.zzish);
    zzbgo.zza(paramParcel, 4, this.zzisi);
    zzbgo.zza(paramParcel, 5, this.zzirp);
    zzbgo.zzc(paramParcel, 6, this.zzirl);
    zzbgo.zza(paramParcel, 7, this.zzisj);
    zzbgo.zza(paramParcel, 8, this.zzisk);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\location\LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */