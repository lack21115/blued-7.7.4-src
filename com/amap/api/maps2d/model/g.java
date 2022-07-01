package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

class g implements Parcelable.Creator<MarkerOptions> {
  public MarkerOptions a(Parcel paramParcel) {
    MarkerOptions markerOptions = new MarkerOptions();
    markerOptions.position((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    markerOptions.icon((BitmapDescriptor)paramParcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
    markerOptions.title(paramParcel.readString());
    markerOptions.snippet(paramParcel.readString());
    markerOptions.anchor(paramParcel.readFloat(), paramParcel.readFloat());
    byte b = paramParcel.readByte();
    boolean bool2 = false;
    if (b == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    markerOptions.visible(bool1);
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    markerOptions.draggable(bool1);
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1)
      bool1 = true; 
    markerOptions.setGps(bool1);
    markerOptions.a = paramParcel.readString();
    markerOptions.zIndex(paramParcel.readFloat());
    markerOptions.icons(paramParcel.createTypedArrayList(BitmapDescriptor.a));
    return markerOptions;
  }
  
  public MarkerOptions[] a(int paramInt) {
    return new MarkerOptions[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */