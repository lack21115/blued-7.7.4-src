package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions implements Parcelable {
  public static final h CREATOR = new h();
  
  String a;
  
  private final List<LatLng> b = new ArrayList<LatLng>();
  
  private float c = 10.0F;
  
  private int d = -16777216;
  
  private int e = -16777216;
  
  private float f = 0.0F;
  
  private boolean g = true;
  
  public PolygonOptions add(LatLng paramLatLng) {
    this.b.add(paramLatLng);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs) {
    this.b.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable) {
    if (paramIterable == null)
      return this; 
    try {
      ArrayList<LatLng> arrayList = new ArrayList();
      Iterator<LatLng> iterator = paramIterable.iterator();
      return this;
    } finally {
      paramIterable = null;
      paramIterable.printStackTrace();
    } 
  }
  
  public int describeContents() {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt) {
    this.e = paramInt;
    return this;
  }
  
  public int getFillColor() {
    return this.e;
  }
  
  public List<LatLng> getPoints() {
    return this.b;
  }
  
  public int getStrokeColor() {
    return this.d;
  }
  
  public float getStrokeWidth() {
    return this.c;
  }
  
  public float getZIndex() {
    return this.f;
  }
  
  public boolean isVisible() {
    return this.g;
  }
  
  public PolygonOptions strokeColor(int paramInt) {
    this.d = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat) {
    this.c = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean) {
    this.g = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedList(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeByte((byte)(this.g ^ true));
    paramParcel.writeString(this.a);
  }
  
  public PolygonOptions zIndex(float paramFloat) {
    this.f = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */