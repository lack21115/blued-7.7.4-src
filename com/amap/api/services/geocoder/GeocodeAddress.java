package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public final class GeocodeAddress implements Parcelable {
  public static final Parcelable.Creator<GeocodeAddress> CREATOR = new Parcelable.Creator<GeocodeAddress>() {
    
    };
  
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private LatLonPoint i;
  
  private String j;
  
  private String k;
  
  private String l;
  
  public GeocodeAddress() {}
  
  private GeocodeAddress(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String getAdcode() {
    return this.h;
  }
  
  public final String getBuilding() {
    return this.g;
  }
  
  public final String getCity() {
    return this.c;
  }
  
  public final String getCountry() {
    return this.k;
  }
  
  public final String getDistrict() {
    return this.d;
  }
  
  public final String getFormatAddress() {
    return this.a;
  }
  
  public final LatLonPoint getLatLonPoint() {
    return this.i;
  }
  
  public final String getLevel() {
    return this.j;
  }
  
  public final String getNeighborhood() {
    return this.f;
  }
  
  public final String getPostcode() {
    return this.l;
  }
  
  public final String getProvince() {
    return this.b;
  }
  
  public final String getTownship() {
    return this.e;
  }
  
  public final void setAdcode(String paramString) {
    this.h = paramString;
  }
  
  public final void setBuilding(String paramString) {
    this.g = paramString;
  }
  
  public final void setCity(String paramString) {
    this.c = paramString;
  }
  
  public final void setCountry(String paramString) {
    this.k = paramString;
  }
  
  public final void setDistrict(String paramString) {
    this.d = paramString;
  }
  
  public final void setFormatAddress(String paramString) {
    this.a = paramString;
  }
  
  public final void setLatLonPoint(LatLonPoint paramLatLonPoint) {
    this.i = paramLatLonPoint;
  }
  
  public final void setLevel(String paramString) {
    this.j = paramString;
  }
  
  public final void setNeighborhood(String paramString) {
    this.f = paramString;
  }
  
  public final void setPostcode(String paramString) {
    this.l = paramString;
  }
  
  public final void setProvince(String paramString) {
    this.b = paramString;
  }
  
  public final void setTownship(String paramString) {
    this.e = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeValue(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\GeocodeAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */