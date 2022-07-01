package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzbc extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzbc> CREATOR;
  
  static final List<ClientIdentity> zza = Collections.emptyList();
  
  private LocationRequest zzb;
  
  private List<ClientIdentity> zzc;
  
  private String zzd;
  
  private boolean zze;
  
  private boolean zzf;
  
  private boolean zzg;
  
  private String zzh;
  
  private boolean zzi;
  
  private boolean zzj;
  
  private String zzk;
  
  private long zzl;
  
  private boolean zzm = true;
  
  static {
    CREATOR = new zzbb();
  }
  
  zzbc(LocationRequest paramLocationRequest, List<ClientIdentity> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, boolean paramBoolean4, boolean paramBoolean5, String paramString3, long paramLong) {
    this.zzb = paramLocationRequest;
    this.zzc = paramList;
    this.zzd = paramString1;
    this.zze = paramBoolean1;
    this.zzf = paramBoolean2;
    this.zzg = paramBoolean3;
    this.zzh = paramString2;
    this.zzi = paramBoolean4;
    this.zzj = paramBoolean5;
    this.zzk = paramString3;
    this.zzl = paramLong;
  }
  
  @Deprecated
  public static zzbc zza(LocationRequest paramLocationRequest) {
    return zza(null, paramLocationRequest);
  }
  
  public static zzbc zza(String paramString, LocationRequest paramLocationRequest) {
    return new zzbc(paramLocationRequest, zza, null, false, false, false, null, false, false, null, Long.MAX_VALUE);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof zzbc))
      return false; 
    paramObject = paramObject;
    return (Objects.equal(this.zzb, ((zzbc)paramObject).zzb) && Objects.equal(this.zzc, ((zzbc)paramObject).zzc) && Objects.equal(this.zzd, ((zzbc)paramObject).zzd) && this.zze == ((zzbc)paramObject).zze && this.zzf == ((zzbc)paramObject).zzf && this.zzg == ((zzbc)paramObject).zzg && Objects.equal(this.zzh, ((zzbc)paramObject).zzh) && this.zzi == ((zzbc)paramObject).zzi && this.zzj == ((zzbc)paramObject).zzj && Objects.equal(this.zzk, ((zzbc)paramObject).zzk));
  }
  
  public final int hashCode() {
    return this.zzb.hashCode();
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.zzb);
    if (this.zzd != null) {
      stringBuilder.append(" tag=");
      stringBuilder.append(this.zzd);
    } 
    if (this.zzh != null) {
      stringBuilder.append(" moduleId=");
      stringBuilder.append(this.zzh);
    } 
    if (this.zzk != null) {
      stringBuilder.append(" contextAttributionTag=");
      stringBuilder.append(this.zzk);
    } 
    stringBuilder.append(" hideAppOps=");
    stringBuilder.append(this.zze);
    stringBuilder.append(" clients=");
    stringBuilder.append(this.zzc);
    stringBuilder.append(" forceCoarseLocation=");
    stringBuilder.append(this.zzf);
    if (this.zzg)
      stringBuilder.append(" exemptFromBackgroundThrottle"); 
    if (this.zzi)
      stringBuilder.append(" locationSettingsIgnored"); 
    if (this.zzj)
      stringBuilder.append(" inaccurateLocationsDelayed"); 
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, (Parcelable)this.zzb, paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 5, this.zzc, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzd, false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zze);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzf);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzg);
    SafeParcelWriter.writeString(paramParcel, 10, this.zzh, false);
    SafeParcelWriter.writeBoolean(paramParcel, 11, this.zzi);
    SafeParcelWriter.writeBoolean(paramParcel, 12, this.zzj);
    SafeParcelWriter.writeString(paramParcel, 13, this.zzk, false);
    SafeParcelWriter.writeLong(paramParcel, 14, this.zzl);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final zzbc zza(long paramLong) {
    if (this.zzb.getMaxWaitTime() <= this.zzb.getInterval()) {
      this.zzl = 10000L;
      return this;
    } 
    paramLong = this.zzb.getInterval();
    long l = this.zzb.getMaxWaitTime();
    StringBuilder stringBuilder = new StringBuilder(120);
    stringBuilder.append("could not set max age when location batching is requested, interval=");
    stringBuilder.append(paramLong);
    stringBuilder.append("maxWaitTime=");
    stringBuilder.append(l);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final zzbc zza(String paramString) {
    this.zzk = paramString;
    return this;
  }
  
  public final zzbc zza(boolean paramBoolean) {
    this.zzj = true;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */