package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyLocationStyleCreator implements Parcelable.Creator<MyLocationStyle> {
  public MyLocationStyle createFromParcel(Parcel paramParcel) {
    MyLocationStyle myLocationStyle = new MyLocationStyle();
    myLocationStyle.myLocationIcon((BitmapDescriptor)paramParcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
    myLocationStyle.anchor(paramParcel.readFloat(), paramParcel.readFloat());
    myLocationStyle.radiusFillColor(paramParcel.readInt());
    myLocationStyle.strokeColor(paramParcel.readInt());
    myLocationStyle.strokeWidth(paramParcel.readFloat());
    return myLocationStyle;
  }
  
  public MyLocationStyle[] newArray(int paramInt) {
    return new MyLocationStyle[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\MyLocationStyleCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */