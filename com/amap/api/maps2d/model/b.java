package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

class b implements Parcelable.Creator<CameraPosition> {
  public CameraPosition a(Parcel paramParcel) {
    float f1 = paramParcel.readFloat();
    float f2 = paramParcel.readFloat();
    float f3 = paramParcel.readFloat();
    float f4 = paramParcel.readFloat();
    float f5 = paramParcel.readFloat();
    return new CameraPosition(new LatLng(f2, f3), f5, f4, f1);
  }
  
  public CameraPosition[] a(int paramInt) {
    return new CameraPosition[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */