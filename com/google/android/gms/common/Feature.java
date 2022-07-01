package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class Feature extends AbstractSafeParcelable {
  public static final Parcelable.Creator<Feature> CREATOR = new zzb();
  
  private final String zza;
  
  @Deprecated
  private final int zzb;
  
  private final long zzc;
  
  public Feature(String paramString, int paramInt, long paramLong) {
    this.zza = paramString;
    this.zzb = paramInt;
    this.zzc = paramLong;
  }
  
  public Feature(String paramString, long paramLong) {
    this.zza = paramString;
    this.zzc = paramLong;
    this.zzb = -1;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof Feature) {
      paramObject = paramObject;
      if (((getName() != null && getName().equals(paramObject.getName())) || (getName() == null && paramObject.getName() == null)) && getVersion() == paramObject.getVersion())
        return true; 
    } 
    return false;
  }
  
  public String getName() {
    return this.zza;
  }
  
  public long getVersion() {
    long l2 = this.zzc;
    long l1 = l2;
    if (l2 == -1L)
      l1 = this.zzb; 
    return l1;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { getName(), Long.valueOf(getVersion()) });
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeLong(paramParcel, 3, getVersion());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\Feature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */