package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zza();
  
  private final String tag;
  
  private final int versionCode;
  
  private final String zza;
  
  private final String zzb;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3) {
    this.versionCode = paramInt;
    this.zza = paramString1;
    this.tag = paramString2;
    this.zzb = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2) {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty("unknown");
    int i = "unknown".hashCode();
    boolean bool = false;
    switch (i) {
      default:
        i = -1;
        break;
      case -284840886:
        i = 0;
        break;
      case 1164924125:
      case 1287171955:
      case -1436706272:
      case -1194968642:
      case -262743844:
        i = -1;
        break;
    } 
    if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5)
      bool = true; 
    Preconditions.checkArgument(bool, "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, "unknown");
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof PlaceReport))
      return false; 
    paramObject = paramObject;
    return (Objects.equal(this.zza, ((PlaceReport)paramObject).zza) && Objects.equal(this.tag, ((PlaceReport)paramObject).tag) && Objects.equal(this.zzb, ((PlaceReport)paramObject).zzb));
  }
  
  public String getPlaceId() {
    return this.zza;
  }
  
  public String getTag() {
    return this.tag;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.zza, this.tag, this.zzb });
  }
  
  public String toString() {
    Objects.ToStringHelper toStringHelper = Objects.toStringHelper(this);
    toStringHelper.add("placeId", this.zza);
    toStringHelper.add("tag", this.tag);
    if (!"unknown".equals(this.zzb))
      toStringHelper.add("source", this.zzb); 
    return toStringHelper.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, getPlaceId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getTag(), false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzb, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\places\PlaceReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */