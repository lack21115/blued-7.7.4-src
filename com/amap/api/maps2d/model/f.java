package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

class f implements Parcelable.Creator<LatLng> {
  public LatLng a(Parcel paramParcel) {
    double d = paramParcel.readDouble();
    return new LatLng(paramParcel.readDouble(), d);
  }
  
  public LatLng[] a(int paramInt) {
    return new LatLng[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */