package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class Tip implements Parcelable {
  public static final Parcelable.Creator<Tip> CREATOR = new Parcelable.Creator<Tip>() {
    
    };
  
  private String a;
  
  private LatLonPoint b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h = "";
  
  public Tip() {}
  
  private Tip(Parcel paramParcel) {
    this.c = paramParcel.readString();
    this.e = paramParcel.readString();
    this.d = paramParcel.readString();
    this.a = paramParcel.readString();
    this.b = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getAdcode() {
    return this.e;
  }
  
  public String getAddress() {
    return this.f;
  }
  
  public String getDistrict() {
    return this.d;
  }
  
  public String getName() {
    return this.c;
  }
  
  public String getPoiID() {
    return this.a;
  }
  
  public LatLonPoint getPoint() {
    return this.b;
  }
  
  public String getTypeCode() {
    return this.g;
  }
  
  public void setAdcode(String paramString) {
    this.e = paramString;
  }
  
  public void setAddress(String paramString) {
    this.f = paramString;
  }
  
  public void setDistrict(String paramString) {
    this.d = paramString;
  }
  
  public void setID(String paramString) {
    this.a = paramString;
  }
  
  public void setName(String paramString) {
    this.c = paramString;
  }
  
  public void setPostion(LatLonPoint paramLatLonPoint) {
    this.b = paramLatLonPoint;
  }
  
  public void setTypeCode(String paramString) {
    this.g = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("name:");
    stringBuilder.append(this.c);
    stringBuilder.append(" district:");
    stringBuilder.append(this.d);
    stringBuilder.append(" adcode:");
    stringBuilder.append(this.e);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.a);
    paramParcel.writeValue(this.b);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\help\Tip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */