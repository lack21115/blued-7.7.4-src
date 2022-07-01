package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class DriveRouteResult extends RouteResult implements Parcelable {
  public static final Parcelable.Creator<DriveRouteResult> CREATOR = new Parcelable.Creator<DriveRouteResult>() {
    
    };
  
  private float a;
  
  private List<DrivePath> b = new ArrayList<DrivePath>();
  
  private RouteSearch.DriveRouteQuery c;
  
  public DriveRouteResult() {}
  
  public DriveRouteResult(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.readFloat();
    this.b = paramParcel.createTypedArrayList(DrivePath.CREATOR);
    this.c = (RouteSearch.DriveRouteQuery)paramParcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public RouteSearch.DriveRouteQuery getDriveQuery() {
    return this.c;
  }
  
  public List<DrivePath> getPaths() {
    return this.b;
  }
  
  public float getTaxiCost() {
    return this.a;
  }
  
  public void setDriveQuery(RouteSearch.DriveRouteQuery paramDriveRouteQuery) {
    this.c = paramDriveRouteQuery;
  }
  
  public void setPaths(List<DrivePath> paramList) {
    this.b = paramList;
  }
  
  public void setTaxiCost(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.a);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\DriveRouteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */