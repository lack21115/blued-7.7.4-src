package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

class a implements Parcelable.Creator<BitmapDescriptor> {
  public BitmapDescriptor a(Parcel paramParcel) {
    BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null);
    bitmapDescriptor.d = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    bitmapDescriptor.b = paramParcel.readInt();
    bitmapDescriptor.c = paramParcel.readInt();
    return bitmapDescriptor;
  }
  
  public BitmapDescriptor[] a(int paramInt) {
    return new BitmapDescriptor[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */