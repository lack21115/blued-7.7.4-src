package com.amap.api.maps2d.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.cm;

class e implements Parcelable.Creator<LatLngBounds> {
  static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(paramLatLngBounds.a());
    paramParcel.writeParcelable(paramLatLngBounds.southwest, paramInt);
    paramParcel.writeParcelable(paramLatLngBounds.northeast, paramInt);
  }
  
  public LatLngBounds a(Parcel paramParcel) {
    int i = paramParcel.readInt();
    try {
      LatLng latLng = (LatLng)paramParcel.readParcelable(LatLngBounds.class.getClassLoader());
      try {
        LatLng latLng2 = (LatLng)paramParcel.readParcelable(LatLngBounds.class.getClassLoader());
        LatLng latLng1 = latLng;
        latLng = latLng2;
      } catch (BadParcelableException badParcelableException1) {
        LatLng latLng1 = latLng;
        badParcelableException = badParcelableException1;
      } 
    } catch (BadParcelableException badParcelableException) {
      paramParcel = null;
    } 
    cm.a((Throwable)badParcelableException, "LatLngBoundsCreator", "createFromParcel");
    badParcelableException = null;
  }
  
  public LatLngBounds[] a(int paramInt) {
    return new LatLngBounds[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */