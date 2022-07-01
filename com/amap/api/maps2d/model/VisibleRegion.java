package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.cm;

public final class VisibleRegion implements Parcelable {
  public static final l CREATOR = new l();
  
  private final int a;
  
  public final LatLng farLeft;
  
  public final LatLng farRight;
  
  public final LatLngBounds latLngBounds;
  
  public final LatLng nearLeft;
  
  public final LatLng nearRight;
  
  VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds) {
    this.a = paramInt;
    this.nearLeft = paramLatLng1;
    this.nearRight = paramLatLng2;
    this.farLeft = paramLatLng3;
    this.farRight = paramLatLng4;
    this.latLngBounds = paramLatLngBounds;
  }
  
  public VisibleRegion(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds) {
    this(1, paramLatLng1, paramLatLng2, paramLatLng3, paramLatLng4, paramLatLngBounds);
  }
  
  int a() {
    return this.a;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof VisibleRegion))
      return false; 
    paramObject = paramObject;
    return (this.nearLeft.equals(((VisibleRegion)paramObject).nearLeft) && this.nearRight.equals(((VisibleRegion)paramObject).nearRight) && this.farLeft.equals(((VisibleRegion)paramObject).farLeft) && this.farRight.equals(((VisibleRegion)paramObject).farRight) && this.latLngBounds.equals(((VisibleRegion)paramObject).latLngBounds));
  }
  
  public int hashCode() {
    return cm.a(new Object[] { this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds });
  }
  
  public String toString() {
    return cm.a(new String[] { cm.a("nearLeft", this.nearLeft), cm.a("nearRight", this.nearRight), cm.a("farLeft", this.farLeft), cm.a("farRight", this.farRight), cm.a("latLngBounds", this.latLngBounds) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    l.a(this, paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\VisibleRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */