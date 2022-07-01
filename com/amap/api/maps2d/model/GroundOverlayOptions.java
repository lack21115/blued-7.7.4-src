package com.amap.api.maps2d.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore2d.cm;

public final class GroundOverlayOptions implements Parcelable {
  public static final d CREATOR = new d();
  
  public static final float NO_DIMENSION = -1.0F;
  
  private final int a = 1;
  
  private BitmapDescriptor b;
  
  private LatLng c;
  
  private float d;
  
  private float e;
  
  private LatLngBounds f;
  
  private float g;
  
  private float h;
  
  private boolean i = true;
  
  private float j = 0.0F;
  
  private float k = 0.5F;
  
  private float l = 0.5F;
  
  public GroundOverlayOptions() {}
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7) {
    this.b = BitmapDescriptorFactory.fromBitmap(null);
    this.c = paramLatLng;
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramLatLngBounds;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.i = paramBoolean;
    this.j = paramFloat5;
    this.k = paramFloat6;
    this.l = paramFloat7;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2) {
    this.c = paramLatLng;
    this.d = paramFloat1;
    this.e = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2) {
    this.k = paramFloat1;
    this.l = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat) {
    this.g = paramFloat;
    return this;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getAnchorU() {
    return this.k;
  }
  
  public float getAnchorV() {
    return this.l;
  }
  
  public float getBearing() {
    return this.g;
  }
  
  public LatLngBounds getBounds() {
    return this.f;
  }
  
  public float getHeight() {
    return this.e;
  }
  
  public BitmapDescriptor getImage() {
    return this.b;
  }
  
  public LatLng getLocation() {
    return this.c;
  }
  
  public float getTransparency() {
    return this.j;
  }
  
  public float getWidth() {
    return this.d;
  }
  
  public float getZIndex() {
    return this.h;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor) {
    this.b = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible() {
    return this.i;
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat) {
    try {
      if (this.f != null)
        Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds"); 
      if (paramLatLng == null)
        Log.w("GroundOverlayOptions", "Location must be specified"); 
      if (paramFloat <= 0.0F)
        Log.w("GroundOverlayOptions", "Width must be non-negative"); 
      return a(paramLatLng, paramFloat, paramFloat);
    } catch (Exception exception) {
      cm.a(exception, "GroundOverlayOptions", "position");
      return null;
    } 
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2) {
    try {
      if (this.f != null)
        Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds"); 
      if (paramLatLng == null)
        Log.w("GroundOverlayOptions", "Location must be specified"); 
    } catch (Exception exception) {
      cm.a(exception, "GroundOverlayOptions", "position");
      return null;
    } 
    if (paramFloat1 <= 0.0F || paramFloat2 <= 0.0F)
      Log.w("GroundOverlayOptions", "Width and Height must be non-negative"); 
    return a((LatLng)exception, paramFloat1, paramFloat2);
  }
  
  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds) {
    try {
      if (this.c != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position has already been set using position: ");
        stringBuilder.append(this.c);
        Log.w("GroundOverlayOptions", stringBuilder.toString());
      } 
      this.f = paramLatLngBounds;
      return this;
    } catch (Exception exception) {
      cm.a(exception, "GroundOverlayOptions", "positionFromBounds");
      return null;
    } 
  }
  
  public GroundOverlayOptions transparency(float paramFloat) {
    float f = paramFloat;
    if (paramFloat < 0.0F)
      try {
        Log.w("GroundOverlayOptions", "Transparency must be in the range [0..1]");
        f = 0.0F;
        this.j = f;
        return this;
      } catch (Exception exception) {
        cm.a(exception, "GroundOverlayOptions", "transparency");
        return null;
      }  
    this.j = f;
    return this;
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean) {
    this.i = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeParcelable(this.c, paramInt);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeParcelable(this.f, paramInt);
    paramParcel.writeFloat(this.g);
    paramParcel.writeFloat(this.h);
    paramParcel.writeByte((byte)this.i);
    paramParcel.writeFloat(this.j);
    paramParcel.writeFloat(this.k);
    paramParcel.writeFloat(this.l);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat) {
    this.h = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */