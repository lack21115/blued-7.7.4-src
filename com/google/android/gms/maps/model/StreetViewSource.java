package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class StreetViewSource extends AbstractSafeParcelable {
  public static final Parcelable.Creator<StreetViewSource> CREATOR;
  
  public static final StreetViewSource DEFAULT;
  
  public static final StreetViewSource OUTDOOR;
  
  private static final String TAG = StreetViewSource.class.getSimpleName();
  
  private final int type;
  
  static {
    CREATOR = new zzq();
    DEFAULT = new StreetViewSource(0);
    OUTDOOR = new StreetViewSource(1);
  }
  
  public StreetViewSource(int paramInt) {
    this.type = paramInt;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof StreetViewSource))
      return false; 
    paramObject = paramObject;
    return (this.type == ((StreetViewSource)paramObject).type);
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.type) });
  }
  
  public final String toString() {
    String str;
    int i = this.type;
    if (i != 0) {
      if (i != 1) {
        str = String.format("UNKNOWN(%s)", new Object[] { Integer.valueOf(i) });
      } else {
        str = "OUTDOOR";
      } 
    } else {
      str = "DEFAULT";
    } 
    return String.format("StreetViewSource:%s", new Object[] { str });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.type);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\StreetViewSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */