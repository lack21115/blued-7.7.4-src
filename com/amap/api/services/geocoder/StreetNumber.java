package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public final class StreetNumber implements Parcelable {
  public static final Parcelable.Creator<StreetNumber> CREATOR = new Parcelable.Creator<StreetNumber>() {
    
    };
  
  private String a;
  
  private String b;
  
  private LatLonPoint c;
  
  private String d;
  
  private float e;
  
  public StreetNumber() {}
  
  private StreetNumber(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
    this.d = paramParcel.readString();
    this.e = paramParcel.readFloat();
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String getDirection() {
    return this.d;
  }
  
  public final float getDistance() {
    return this.e;
  }
  
  public final LatLonPoint getLatLonPoint() {
    return this.c;
  }
  
  public final String getNumber() {
    return this.b;
  }
  
  public final String getStreet() {
    return this.a;
  }
  
  public final void setDirection(String paramString) {
    this.d = paramString;
  }
  
  public final void setDistance(float paramFloat) {
    this.e = paramFloat;
  }
  
  public final void setLatLonPoint(LatLonPoint paramLatLonPoint) {
    this.c = paramLatLonPoint;
  }
  
  public final void setNumber(String paramString) {
    this.b = paramString;
  }
  
  public final void setStreet(String paramString) {
    this.a = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeValue(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeFloat(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\StreetNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */