package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

class k implements Parcelable.Creator<TileOverlayOptions> {
  public TileOverlayOptions a(Parcel paramParcel) {
    boolean bool1;
    boolean bool2;
    int i = paramParcel.readInt();
    TileProvider tileProvider = (TileProvider)paramParcel.readValue(TileProvider.class.getClassLoader());
    byte b = paramParcel.readByte();
    boolean bool3 = true;
    if (b != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    float f = paramParcel.readFloat();
    int j = paramParcel.readInt();
    int m = paramParcel.readInt();
    String str = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramParcel.readByte() == 0)
      bool3 = false; 
    TileOverlayOptions tileOverlayOptions = new TileOverlayOptions(i, null, bool1, f);
    if (tileProvider != null)
      tileOverlayOptions.tileProvider(tileProvider); 
    tileOverlayOptions.memCacheSize(j);
    tileOverlayOptions.diskCacheSize(m);
    tileOverlayOptions.diskCacheDir(str);
    tileOverlayOptions.memoryCacheEnabled(bool2);
    tileOverlayOptions.diskCacheEnabled(bool3);
    return tileOverlayOptions;
  }
  
  public TileOverlayOptions[] a(int paramInt) {
    return new TileOverlayOptions[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */