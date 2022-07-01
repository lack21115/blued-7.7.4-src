package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class RailwaySpace implements Parcelable {
  public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() {
    
    };
  
  private String a;
  
  private float b;
  
  protected RailwaySpace(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readFloat();
  }
  
  public RailwaySpace(String paramString, float paramFloat) {
    this.a = paramString;
    this.b = paramFloat;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getCode() {
    return this.a;
  }
  
  public float getCost() {
    return this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeFloat(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RailwaySpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */