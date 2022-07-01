package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzo;
import java.util.Collections;
import java.util.List;

public final class zzj extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzj> CREATOR;
  
  static final List<ClientIdentity> zza = Collections.emptyList();
  
  static final zzo zzb = new zzo();
  
  private zzo zzc;
  
  private List<ClientIdentity> zzd;
  
  private String zze;
  
  static {
    CREATOR = new zzm();
  }
  
  zzj(zzo paramzzo, List<ClientIdentity> paramList, String paramString) {
    this.zzc = paramzzo;
    this.zzd = paramList;
    this.zze = paramString;
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof zzj))
      return false; 
    paramObject = paramObject;
    return (Objects.equal(this.zzc, ((zzj)paramObject).zzc) && Objects.equal(this.zzd, ((zzj)paramObject).zzd) && Objects.equal(this.zze, ((zzj)paramObject).zze));
  }
  
  public final int hashCode() {
    return this.zzc.hashCode();
  }
  
  public final String toString() {
    String str1 = String.valueOf(this.zzc);
    String str2 = String.valueOf(this.zzd);
    String str3 = this.zze;
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 77 + String.valueOf(str2).length() + String.valueOf(str3).length());
    stringBuilder.append("DeviceOrientationRequestInternal{deviceOrientationRequest=");
    stringBuilder.append(str1);
    stringBuilder.append(", clients=");
    stringBuilder.append(str2);
    stringBuilder.append(", tag='");
    stringBuilder.append(str3);
    stringBuilder.append("'}");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, (Parcelable)this.zzc, paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, this.zzd, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zze, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */