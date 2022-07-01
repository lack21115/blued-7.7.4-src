package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RouteSearchCity extends SearchCity implements Parcelable {
  public static final Parcelable.Creator<RouteSearchCity> CREATOR = new Parcelable.Creator<RouteSearchCity>() {
    
    };
  
  List<District> a = new ArrayList<District>();
  
  public RouteSearchCity() {}
  
  public RouteSearchCity(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(District.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<District> getDistricts() {
    return this.a;
  }
  
  public void setDistricts(List<District> paramList) {
    this.a = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RouteSearchCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */