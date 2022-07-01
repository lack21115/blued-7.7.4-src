package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

public class TruckRouteRestult implements Parcelable {
  public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new Parcelable.Creator<TruckRouteRestult>() {
    
    };
  
  private RouteSearch.TruckRouteQuery a;
  
  private List<TruckPath> b;
  
  private LatLonPoint c;
  
  private LatLonPoint d;
  
  public TruckRouteRestult() {}
  
  protected TruckRouteRestult(Parcel paramParcel) {
    this.b = paramParcel.createTypedArrayList(TruckPath.CREATOR);
    this.c = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.d = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<TruckPath> getPaths() {
    return this.b;
  }
  
  public LatLonPoint getStartPos() {
    return this.c;
  }
  
  public LatLonPoint getTargetPos() {
    return this.d;
  }
  
  public RouteSearch.TruckRouteQuery getTruckQuery() {
    return this.a;
  }
  
  public void setPaths(List<TruckPath> paramList) {
    this.b = paramList;
  }
  
  public void setStartPos(LatLonPoint paramLatLonPoint) {
    this.c = paramLatLonPoint;
  }
  
  public void setTargetPos(LatLonPoint paramLatLonPoint) {
    this.d = paramLatLonPoint;
  }
  
  public void setTruckQuery(RouteSearch.TruckRouteQuery paramTruckRouteQuery) {
    this.a = paramTruckRouteQuery;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedList(this.b);
    paramParcel.writeParcelable((Parcelable)this.c, paramInt);
    paramParcel.writeParcelable((Parcelable)this.d, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\TruckRouteRestult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */