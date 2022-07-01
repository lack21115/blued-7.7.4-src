package com.amap.api.maps2d;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.CameraPosition;

public class AMapOptionsCreator implements Parcelable.Creator<AMapOptions> {
  public AMapOptions createFromParcel(Parcel paramParcel) {
    AMapOptions aMapOptions = new AMapOptions();
    CameraPosition cameraPosition = (CameraPosition)paramParcel.readParcelable(CameraPosition.class.getClassLoader());
    aMapOptions.mapType(paramParcel.readInt());
    aMapOptions.camera(cameraPosition);
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    if (arrayOfBoolean != null && arrayOfBoolean.length >= 6) {
      aMapOptions.scrollGesturesEnabled(arrayOfBoolean[0]);
      aMapOptions.zoomGesturesEnabled(arrayOfBoolean[1]);
      aMapOptions.zoomControlsEnabled(arrayOfBoolean[2]);
      aMapOptions.zOrderOnTop(arrayOfBoolean[3]);
      aMapOptions.compassEnabled(arrayOfBoolean[4]);
      aMapOptions.scaleControlsEnabled(arrayOfBoolean[5]);
    } 
    return aMapOptions;
  }
  
  public AMapOptions[] newArray(int paramInt) {
    return new AMapOptions[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\AMapOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */