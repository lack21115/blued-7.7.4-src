package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class District implements Parcelable {
  public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() {
    
    };
  
  private String a;
  
  private String b;
  
  public District() {}
  
  public District(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getDistrictAdcode() {
    return this.b;
  }
  
  public String getDistrictName() {
    return this.a;
  }
  
  public void setDistrictAdcode(String paramString) {
    this.b = paramString;
  }
  
  public void setDistrictName(String paramString) {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\District.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */