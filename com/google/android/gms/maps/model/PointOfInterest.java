package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class PointOfInterest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<PointOfInterest> CREATOR = new zzj();
  
  public final LatLng latLng;
  
  public final String name;
  
  public final String placeId;
  
  public PointOfInterest(LatLng paramLatLng, String paramString1, String paramString2) {
    this.latLng = paramLatLng;
    this.placeId = paramString1;
    this.name = paramString2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.latLng, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.placeId, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.name, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\PointOfInterest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */