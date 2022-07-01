package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class BusRouteResult extends RouteResult implements Parcelable {
  public static final Parcelable.Creator<BusRouteResult> CREATOR = new Parcelable.Creator<BusRouteResult>() {
    
    };
  
  private float a;
  
  private List<BusPath> b = new ArrayList<BusPath>();
  
  private RouteSearch.BusRouteQuery c;
  
  public BusRouteResult() {}
  
  public BusRouteResult(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.readFloat();
    this.b = paramParcel.createTypedArrayList(BusPath.CREATOR);
    this.c = (RouteSearch.BusRouteQuery)paramParcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public RouteSearch.BusRouteQuery getBusQuery() {
    return this.c;
  }
  
  public List<BusPath> getPaths() {
    return this.b;
  }
  
  public float getTaxiCost() {
    return this.a;
  }
  
  public void setBusQuery(RouteSearch.BusRouteQuery paramBusRouteQuery) {
    this.c = paramBusRouteQuery;
  }
  
  public void setPaths(List<BusPath> paramList) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\BusRouteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */