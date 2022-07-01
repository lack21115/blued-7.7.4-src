package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore2d.cl;
import com.amap.api.mapcore2d.cm;

public final class CameraPosition implements Parcelable {
  public static final b CREATOR = new b();
  
  public final float bearing;
  
  public final boolean isAbroad;
  
  public final LatLng target;
  
  public final float tilt;
  
  public final float zoom;
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3) {
    if (paramLatLng == null)
      Log.w("CameraPosition", "构建CameraPosition时,位置(target)不能为null"); 
    this.target = paramLatLng;
    this.zoom = cm.b(paramFloat1);
    this.tilt = cm.a(paramFloat2);
    paramFloat1 = paramFloat3;
    if (paramFloat3 <= 0.0D)
      paramFloat1 = paramFloat3 % 360.0F + 360.0F; 
    this.bearing = paramFloat1 % 360.0F;
    if (paramLatLng != null) {
      this.isAbroad = cl.a(paramLatLng.latitude, paramLatLng.longitude) ^ true;
      return;
    } 
    this.isAbroad = false;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(CameraPosition paramCameraPosition) {
    return new Builder(paramCameraPosition);
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat) {
    return new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof CameraPosition))
      return false; 
    paramObject = paramObject;
    return (this.target.equals(((CameraPosition)paramObject).target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(((CameraPosition)paramObject).zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(((CameraPosition)paramObject).tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((CameraPosition)paramObject).bearing));
  }
  
  public int hashCode() {
    return super.hashCode();
  }
  
  public String toString() {
    return cm.a(new String[] { cm.a("target", this.target), cm.a("zoom", Float.valueOf(this.zoom)), cm.a("tilt", Float.valueOf(this.tilt)), cm.a("bearing", Float.valueOf(this.bearing)) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeFloat(this.bearing);
    LatLng latLng = this.target;
    if (latLng != null) {
      paramParcel.writeFloat((float)latLng.latitude);
      paramParcel.writeFloat((float)this.target.longitude);
    } 
    paramParcel.writeFloat(this.tilt);
    paramParcel.writeFloat(this.zoom);
  }
  
  public static final class Builder {
    private LatLng a;
    
    private float b;
    
    private float c;
    
    private float d;
    
    public Builder() {}
    
    public Builder(CameraPosition param1CameraPosition) {
      target(param1CameraPosition.target).bearing(param1CameraPosition.bearing).tilt(param1CameraPosition.tilt).zoom(param1CameraPosition.zoom);
    }
    
    public Builder bearing(float param1Float) {
      this.d = param1Float;
      return this;
    }
    
    public CameraPosition build() {
      try {
        return new CameraPosition(this.a, this.b, this.c, this.d);
      } finally {
        Exception exception = null;
        cm.a(exception, "CameraPosition", "build");
      } 
    }
    
    public Builder target(LatLng param1LatLng) {
      this.a = param1LatLng;
      return this;
    }
    
    public Builder tilt(float param1Float) {
      this.c = param1Float;
      return this;
    }
    
    public Builder zoom(float param1Float) {
      this.b = param1Float;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\CameraPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */