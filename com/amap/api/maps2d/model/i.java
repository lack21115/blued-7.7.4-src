package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

class i implements Parcelable.Creator<PolylineOptions> {
  public PolylineOptions a(Parcel paramParcel) {
    boolean bool1;
    PolylineOptions polylineOptions = new PolylineOptions();
    ArrayList<LatLng> arrayList = new ArrayList();
    paramParcel.readTypedList(arrayList, LatLng.CREATOR);
    float f1 = paramParcel.readFloat();
    int j = paramParcel.readInt();
    float f2 = paramParcel.readFloat();
    byte b = paramParcel.readByte();
    boolean bool2 = false;
    if (b == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    polylineOptions.addAll(arrayList);
    polylineOptions.width(f1);
    polylineOptions.color(j);
    polylineOptions.zIndex(f2);
    polylineOptions.visible(bool1);
    polylineOptions.a = paramParcel.readString();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramParcel.readByte() == 1)
      bool2 = true; 
    polylineOptions.geodesic(bool1);
    polylineOptions.setDottedLine(bool2);
    return polylineOptions;
  }
  
  public PolylineOptions[] a(int paramInt) {
    return new PolylineOptions[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */