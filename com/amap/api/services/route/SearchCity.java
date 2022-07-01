package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchCity implements Parcelable {
  public static final Parcelable.Creator<SearchCity> CREATOR = new Parcelable.Creator<SearchCity>() {
    
    };
  
  private String a;
  
  private String b;
  
  private String c;
  
  public SearchCity() {}
  
  public SearchCity(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getSearchCityAdCode() {
    return this.c;
  }
  
  public String getSearchCityName() {
    return this.a;
  }
  
  public String getSearchCitycode() {
    return this.b;
  }
  
  public void setSearchCityName(String paramString) {
    this.a = paramString;
  }
  
  public void setSearchCitycode(String paramString) {
    this.b = paramString;
  }
  
  public void setSearchCityhAdCode(String paramString) {
    this.c = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\SearchCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */