package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

class h implements Parcelable.Creator<PolygonOptions> {
  public PolygonOptions a(Parcel paramParcel) {
    boolean bool;
    PolygonOptions polygonOptions = new PolygonOptions();
    ArrayList arrayList = new ArrayList();
    paramParcel.readTypedList(arrayList, LatLng.CREATOR);
    float f1 = paramParcel.readFloat();
    int i = paramParcel.readInt();
    int j = paramParcel.readInt();
    float f2 = paramParcel.readFloat();
    if (paramParcel.readByte() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    polygonOptions.add((LatLng[])arrayList.toArray((Object[])new LatLng[arrayList.size()]));
    polygonOptions.strokeWidth(f1);
    polygonOptions.strokeColor(i);
    polygonOptions.fillColor(j);
    polygonOptions.zIndex(f2);
    polygonOptions.visible(bool);
    polygonOptions.a = paramParcel.readString();
    return polygonOptions;
  }
  
  public PolygonOptions[] a(int paramInt) {
    return new PolygonOptions[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */