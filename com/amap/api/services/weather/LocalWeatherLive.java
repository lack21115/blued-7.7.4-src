package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

public class LocalWeatherLive implements Parcelable {
  public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new Parcelable.Creator<LocalWeatherLive>() {
    
    };
  
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  public LocalWeatherLive() {}
  
  public LocalWeatherLive(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getAdCode() {
    return this.c;
  }
  
  public String getCity() {
    return this.b;
  }
  
  public String getHumidity() {
    return this.h;
  }
  
  public String getProvince() {
    return this.a;
  }
  
  public String getReportTime() {
    return this.i;
  }
  
  public String getTemperature() {
    return this.e;
  }
  
  public String getWeather() {
    return this.d;
  }
  
  public String getWindDirection() {
    return this.f;
  }
  
  public String getWindPower() {
    return this.g;
  }
  
  public void setAdCode(String paramString) {
    this.c = paramString;
  }
  
  public void setCity(String paramString) {
    this.b = paramString;
  }
  
  public void setHumidity(String paramString) {
    this.h = paramString;
  }
  
  public void setProvince(String paramString) {
    this.a = paramString;
  }
  
  public void setReportTime(String paramString) {
    this.i = paramString;
  }
  
  public void setTemperature(String paramString) {
    this.e = paramString;
  }
  
  public void setWeather(String paramString) {
    this.d = paramString;
  }
  
  public void setWindDirection(String paramString) {
    this.f = paramString;
  }
  
  public void setWindPower(String paramString) {
    this.g = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\weather\LocalWeatherLive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */