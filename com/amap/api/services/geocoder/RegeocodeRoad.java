package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public final class RegeocodeRoad implements Parcelable {
  public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new Parcelable.Creator<RegeocodeRoad>() {
    
    };
  
  private String a;
  
  private String b;
  
  private float c;
  
  private String d;
  
  private LatLonPoint e;
  
  public RegeocodeRoad() {}
  
  private RegeocodeRoad(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readString();
    this.e = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String getDirection() {
    return this.d;
  }
  
  public final float getDistance() {
    return this.c;
  }
  
  public final String getId() {
    return this.a;
  }
  
  public final LatLonPoint getLatLngPoint() {
    return this.e;
  }
  
  public final String getName() {
    return this.b;
  }
  
  public final void setDirection(String paramString) {
    this.d = paramString;
  }
  
  public final void setDistance(float paramFloat) {
    this.c = paramFloat;
  }
  
  public final void setId(String paramString) {
    this.a = paramString;
  }
  
  public final void setLatLngPoint(LatLonPoint paramLatLonPoint) {
    this.e = paramLatLonPoint;
  }
  
  public final void setName(String paramString) {
    this.b = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeValue(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\RegeocodeRoad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */