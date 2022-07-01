package com.amap.api.maps2d.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

class c implements Parcelable.Creator<CircleOptions> {
  public CircleOptions a(Parcel paramParcel) {
    CircleOptions circleOptions = new CircleOptions();
    Bundle bundle = paramParcel.readBundle();
    circleOptions.center(new LatLng(bundle.getDouble("lat"), bundle.getDouble("lng")));
    circleOptions.radius(paramParcel.readDouble());
    circleOptions.strokeWidth(paramParcel.readFloat());
    circleOptions.strokeColor(paramParcel.readInt());
    circleOptions.fillColor(paramParcel.readInt());
    circleOptions.zIndex(paramParcel.readInt());
    byte b = paramParcel.readByte();
    boolean bool = true;
    if (b != 1)
      bool = false; 
    circleOptions.visible(bool);
    circleOptions.a = paramParcel.readString();
    return circleOptions;
  }
  
  public CircleOptions[] a(int paramInt) {
    return new CircleOptions[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */