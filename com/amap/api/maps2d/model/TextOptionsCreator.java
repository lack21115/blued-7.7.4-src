package com.amap.api.maps2d.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class TextOptionsCreator implements Parcelable.Creator<TextOptions> {
  public TextOptions createFromParcel(Parcel paramParcel) {
    TextOptions textOptions = new TextOptions();
    Bundle bundle2 = paramParcel.readBundle();
    textOptions.position(new LatLng(bundle2.getDouble("lat"), bundle2.getDouble("lng")));
    textOptions.text(paramParcel.readString());
    textOptions.typeface(Typeface.defaultFromStyle(paramParcel.readInt()));
    textOptions.rotate(paramParcel.readFloat());
    textOptions.align(paramParcel.readInt(), paramParcel.readInt());
    textOptions.backgroundColor(paramParcel.readInt());
    textOptions.fontColor(paramParcel.readInt());
    textOptions.fontSize(paramParcel.readInt());
    textOptions.zIndex(paramParcel.readInt());
    byte b = paramParcel.readByte();
    boolean bool = true;
    if (b != 1)
      bool = false; 
    textOptions.visible(bool);
    Bundle bundle1 = paramParcel.readBundle();
    try {
      Parcelable parcelable = bundle1.getParcelable("obj");
    } finally {
      bundle1 = null;
    } 
    return textOptions;
  }
  
  public TextOptions[] newArray(int paramInt) {
    return new TextOptions[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\TextOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */