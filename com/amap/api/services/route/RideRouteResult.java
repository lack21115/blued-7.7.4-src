package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RideRouteResult extends RouteResult implements Parcelable {
  public static final Parcelable.Creator<RideRouteResult> CREATOR = new Parcelable.Creator<RideRouteResult>() {
    
    };
  
  private List<RidePath> a = new ArrayList<RidePath>();
  
  private RouteSearch.RideRouteQuery b;
  
  public RideRouteResult() {}
  
  public RideRouteResult(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(RidePath.CREATOR);
    this.b = (RouteSearch.RideRouteQuery)paramParcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<RidePath> getPaths() {
    return this.a;
  }
  
  public RouteSearch.RideRouteQuery getRideQuery() {
    return this.b;
  }
  
  public void setPaths(List<RidePath> paramList) {
    this.a = paramList;
  }
  
  public void setRideQuery(RouteSearch.RideRouteQuery paramRideRouteQuery) {
    this.b = paramRideRouteQuery;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RideRouteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */