package com.amap.api.maps2d.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

class l implements Parcelable.Creator<VisibleRegion> {
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(paramVisibleRegion.a());
    paramParcel.writeParcelable(paramVisibleRegion.nearLeft, paramInt);
    paramParcel.writeParcelable(paramVisibleRegion.nearRight, paramInt);
    paramParcel.writeParcelable(paramVisibleRegion.farLeft, paramInt);
    paramParcel.writeParcelable(paramVisibleRegion.farRight, paramInt);
    paramParcel.writeParcelable(paramVisibleRegion.latLngBounds, paramInt);
  }
  
  public VisibleRegion a(Parcel paramParcel) {
    int i = paramParcel.readInt();
    try {
      Parcel parcel;
      LatLng latLng = (LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader());
      try {
        LatLng latLng1 = (LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader());
        try {
          LatLng latLng2 = (LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader());
          try {
            LatLng latLng3 = (LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader());
            try {
              LatLngBounds latLngBounds1 = (LatLngBounds)paramParcel.readParcelable(LatLngBounds.class.getClassLoader());
              LatLngBounds latLngBounds2 = latLngBounds1;
            } catch (BadParcelableException badParcelableException) {
              LatLng latLng4 = latLng3;
            } 
          } catch (BadParcelableException badParcelableException) {
            paramParcel = null;
          } 
        } catch (BadParcelableException badParcelableException) {
          paramParcel = null;
          LatLng latLng2 = latLng;
          parcel = paramParcel;
        } 
      } catch (BadParcelableException badParcelableException) {
        Parcel parcel1 = parcel;
      } 
    } catch (BadParcelableException badParcelableException) {
      Object object = null;
    } 
    Object object2 = null;
    Object object1 = null;
  }
  
  public VisibleRegion[] a(int paramInt) {
    return new VisibleRegion[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */