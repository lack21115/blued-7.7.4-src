package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class WalkRouteResult extends RouteResult implements Parcelable {
  public static final Parcelable.Creator<WalkRouteResult> CREATOR = new Parcelable.Creator<WalkRouteResult>() {
    
    };
  
  private List<WalkPath> a = new ArrayList<WalkPath>();
  
  private RouteSearch.WalkRouteQuery b;
  
  public WalkRouteResult() {}
  
  public WalkRouteResult(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(WalkPath.CREATOR);
    this.b = (RouteSearch.WalkRouteQuery)paramParcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<WalkPath> getPaths() {
    return this.a;
  }
  
  public RouteSearch.WalkRouteQuery getWalkQuery() {
    return this.b;
  }
  
  public void setPaths(List<WalkPath> paramList) {
    this.a = paramList;
  }
  
  public void setWalkQuery(RouteSearch.WalkRouteQuery paramWalkRouteQuery) {
    this.b = paramWalkRouteQuery;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\WalkRouteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */