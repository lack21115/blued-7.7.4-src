package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class BusinessArea implements Parcelable {
  public static final Parcelable.Creator<BusinessArea> CREATOR = new Parcelable.Creator<BusinessArea>() {
    
    };
  
  private LatLonPoint a;
  
  private String b;
  
  public BusinessArea() {}
  
  public BusinessArea(Parcel paramParcel) {
    this.a = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.b = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public LatLonPoint getCenterPoint() {
    return this.a;
  }
  
  public String getName() {
    return this.b;
  }
  
  public void setCenterPoint(LatLonPoint paramLatLonPoint) {
    this.a = paramLatLonPoint;
  }
  
  public void setName(String paramString) {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.a, paramInt);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\BusinessArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */