package com.amap.api.maps2d.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public class MyLocationStyle implements Parcelable {
  public static final MyLocationStyleCreator CREATOR = new MyLocationStyleCreator();
  
  public static final String ERROR_CODE = "errorCode";
  
  public static final String ERROR_INFO = "errorInfo";
  
  public static final String LOCATION_TYPE = "locationType";
  
  public static final int LOCATION_TYPE_FOLLOW = 2;
  
  public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
  
  public static final int LOCATION_TYPE_LOCATE = 1;
  
  public static final int LOCATION_TYPE_SHOW = 0;
  
  private BitmapDescriptor a;
  
  private float b = 0.5F;
  
  private float c = 0.5F;
  
  private int d = Color.argb(100, 0, 0, 180);
  
  private int e = Color.argb(255, 0, 0, 220);
  
  private float f = 1.0F;
  
  private int g = 1;
  
  private long h = 2000L;
  
  private boolean i = true;
  
  public MyLocationStyle anchor(float paramFloat1, float paramFloat2) {
    this.b = paramFloat1;
    this.c = paramFloat2;
    return this;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getAnchorU() {
    return this.b;
  }
  
  public float getAnchorV() {
    return this.c;
  }
  
  public long getInterval() {
    return this.h;
  }
  
  public BitmapDescriptor getMyLocationIcon() {
    return this.a;
  }
  
  public int getMyLocationType() {
    return this.g;
  }
  
  public int getRadiusFillColor() {
    return this.d;
  }
  
  public int getStrokeColor() {
    return this.e;
  }
  
  public float getStrokeWidth() {
    return this.f;
  }
  
  public MyLocationStyle interval(long paramLong) {
    this.h = paramLong;
    return this;
  }
  
  public boolean isMyLocationShowing() {
    return this.i;
  }
  
  public MyLocationStyle myLocationIcon(BitmapDescriptor paramBitmapDescriptor) {
    this.a = paramBitmapDescriptor;
    return this;
  }
  
  public MyLocationStyle myLocationType(int paramInt) {
    this.g = paramInt;
    return this;
  }
  
  public MyLocationStyle radiusFillColor(int paramInt) {
    this.d = paramInt;
    return this;
  }
  
  public MyLocationStyle showMyLocation(boolean paramBoolean) {
    this.i = paramBoolean;
    return this;
  }
  
  public MyLocationStyle strokeColor(int paramInt) {
    this.e = paramInt;
    return this;
  }
  
  public MyLocationStyle strokeWidth(float paramFloat) {
    this.f = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeBooleanArray(new boolean[] { this.i });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\MyLocationStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */