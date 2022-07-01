package com.amap.api.maps2d;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.CameraPosition;

public class AMapOptions implements Parcelable {
  public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
  
  public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
  
  public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
  
  public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
  
  public static final int ZOOM_POSITION_RIGHT_BUTTOM = 0;
  
  public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
  
  private int a = 1;
  
  private boolean b = true;
  
  private boolean c = true;
  
  private boolean d = true;
  
  private boolean e = false;
  
  private CameraPosition f;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private int i = 0;
  
  public AMapOptions camera(CameraPosition paramCameraPosition) {
    this.f = paramCameraPosition;
    return this;
  }
  
  public AMapOptions compassEnabled(boolean paramBoolean) {
    this.g = paramBoolean;
    return this;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public CameraPosition getCamera() {
    return this.f;
  }
  
  public Boolean getCompassEnabled() {
    return Boolean.valueOf(this.g);
  }
  
  public int getLogoPosition() {
    return this.i;
  }
  
  public int getMapType() {
    return this.a;
  }
  
  public Boolean getScaleControlsEnabled() {
    return Boolean.valueOf(this.h);
  }
  
  public Boolean getScrollGesturesEnabled() {
    return Boolean.valueOf(this.b);
  }
  
  public Boolean getZOrderOnTop() {
    return Boolean.valueOf(this.e);
  }
  
  public Boolean getZoomControlsEnabled() {
    return Boolean.valueOf(this.d);
  }
  
  public Boolean getZoomGesturesEnabled() {
    return Boolean.valueOf(this.c);
  }
  
  public AMapOptions logoPosition(int paramInt) {
    this.i = paramInt;
    return this;
  }
  
  public AMapOptions mapType(int paramInt) {
    this.a = paramInt;
    return this;
  }
  
  public AMapOptions scaleControlsEnabled(boolean paramBoolean) {
    this.h = paramBoolean;
    return this;
  }
  
  public AMapOptions scrollGesturesEnabled(boolean paramBoolean) {
    this.b = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.f, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeBooleanArray(new boolean[] { this.b, this.c, this.d, this.e, this.g, this.h });
  }
  
  public AMapOptions zOrderOnTop(boolean paramBoolean) {
    this.e = paramBoolean;
    return this;
  }
  
  public AMapOptions zoomControlsEnabled(boolean paramBoolean) {
    this.d = paramBoolean;
    return this;
  }
  
  public AMapOptions zoomGesturesEnabled(boolean paramBoolean) {
    this.c = paramBoolean;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\AMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */