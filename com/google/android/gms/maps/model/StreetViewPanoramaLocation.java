package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class StreetViewPanoramaLocation extends AbstractSafeParcelable {
  public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new zzo();
  
  public final StreetViewPanoramaLink[] links;
  
  public final String panoId;
  
  public final LatLng position;
  
  public StreetViewPanoramaLocation(StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString) {
    this.links = paramArrayOfStreetViewPanoramaLink;
    this.position = paramLatLng;
    this.panoId = paramString;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof StreetViewPanoramaLocation))
      return false; 
    paramObject = paramObject;
    return (this.panoId.equals(((StreetViewPanoramaLocation)paramObject).panoId) && this.position.equals(((StreetViewPanoramaLocation)paramObject).position));
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.position, this.panoId });
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("panoId", this.panoId).add("position", this.position.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, (Parcelable[])this.links, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.position, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.panoId, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\StreetViewPanoramaLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */