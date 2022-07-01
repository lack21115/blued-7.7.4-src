package com.amap.api.maps2d.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class CircleOptions implements Parcelable {
  public static final c CREATOR = new c();
  
  String a;
  
  private LatLng b = null;
  
  private double c = 0.0D;
  
  private float d = 10.0F;
  
  private int e = -16777216;
  
  private int f = 0;
  
  private float g = 0.0F;
  
  private boolean h = true;
  
  public CircleOptions center(LatLng paramLatLng) {
    this.b = paramLatLng;
    return this;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt) {
    this.f = paramInt;
    return this;
  }
  
  public LatLng getCenter() {
    return this.b;
  }
  
  public int getFillColor() {
    return this.f;
  }
  
  public double getRadius() {
    return this.c;
  }
  
  public int getStrokeColor() {
    return this.e;
  }
  
  public float getStrokeWidth() {
    return this.d;
  }
  
  public float getZIndex() {
    return this.g;
  }
  
  public boolean isVisible() {
    return this.h;
  }
  
  public CircleOptions radius(double paramDouble) {
    this.c = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt) {
    this.e = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat) {
    this.d = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean) {
    this.h = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    Bundle bundle = new Bundle();
    LatLng latLng = this.b;
    if (latLng != null) {
      bundle.putDouble("lat", latLng.latitude);
      bundle.putDouble("lng", this.b.longitude);
    } 
    paramParcel.writeBundle(bundle);
    paramParcel.writeDouble(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeFloat(this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeString(this.a);
  }
  
  public CircleOptions zIndex(float paramFloat) {
    this.g = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */