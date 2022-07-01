package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

class j implements Parcelable.Creator<Tile> {
  public Tile a(Parcel paramParcel) {
    return new Tile(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.createByteArray());
  }
  
  public Tile[] a(int paramInt) {
    return new Tile[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */