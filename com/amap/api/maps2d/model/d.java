package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

class d implements Parcelable.Creator<GroundOverlayOptions> {
  public GroundOverlayOptions a(Parcel paramParcel) {
    boolean bool;
    int i = paramParcel.readInt();
    BitmapDescriptor bitmapDescriptor = (BitmapDescriptor)paramParcel.readParcelable(BitmapDescriptor.class.getClassLoader());
    LatLng latLng = (LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader());
    float f1 = paramParcel.readFloat();
    float f2 = paramParcel.readFloat();
    LatLngBounds latLngBounds = (LatLngBounds)paramParcel.readParcelable(LatLngBounds.class.getClassLoader());
    float f3 = paramParcel.readFloat();
    float f4 = paramParcel.readFloat();
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions(i, null, latLng, f1, f2, latLngBounds, f3, f4, bool, paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
    groundOverlayOptions.image(bitmapDescriptor);
    return groundOverlayOptions;
  }
  
  public GroundOverlayOptions[] a(int paramInt) {
    return new GroundOverlayOptions[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */