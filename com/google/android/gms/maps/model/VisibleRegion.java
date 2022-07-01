package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class VisibleRegion extends AbstractSafeParcelable {
  public static final Parcelable.Creator<VisibleRegion> CREATOR = new zzv();
  
  public final LatLng farLeft;
  
  public final LatLng farRight;
  
  public final LatLngBounds latLngBounds;
  
  public final LatLng nearLeft;
  
  public final LatLng nearRight;
  
  public VisibleRegion(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds) {
    this.nearLeft = paramLatLng1;
    this.nearRight = paramLatLng2;
    this.farLeft = paramLatLng3;
    this.farRight = paramLatLng4;
    this.latLngBounds = paramLatLngBounds;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof VisibleRegion))
      return false; 
    paramObject = paramObject;
    return (this.nearLeft.equals(((VisibleRegion)paramObject).nearLeft) && this.nearRight.equals(((VisibleRegion)paramObject).nearRight) && this.farLeft.equals(((VisibleRegion)paramObject).farLeft) && this.farRight.equals(((VisibleRegion)paramObject).farRight) && this.latLngBounds.equals(((VisibleRegion)paramObject).latLngBounds));
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds });
  }
  
  public final String toString() {
    return Objects.toStringHelper(this).add("nearLeft", this.nearLeft).add("nearRight", this.nearRight).add("farLeft", this.farLeft).add("farRight", this.farRight).add("latLngBounds", this.latLngBounds).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.nearLeft, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.nearRight, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)this.farLeft, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, (Parcelable)this.farRight, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, (Parcelable)this.latLngBounds, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\VisibleRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */