package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class DriveRoutePlanResult extends RoutePlanResult implements Parcelable {
  public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new Parcelable.Creator<DriveRoutePlanResult>() {
    
    };
  
  private List<DrivePlanPath> a = new ArrayList<DrivePlanPath>();
  
  private List<TimeInfo> b = new ArrayList<TimeInfo>();
  
  private RouteSearch.DrivePlanQuery c;
  
  public DriveRoutePlanResult() {}
  
  public DriveRoutePlanResult(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(DrivePlanPath.CREATOR);
    this.b = paramParcel.createTypedArrayList(TimeInfo.CREATOR);
    this.c = (RouteSearch.DrivePlanQuery)paramParcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<DrivePlanPath> getPaths() {
    return this.a;
  }
  
  public List<TimeInfo> getTimeInfos() {
    return this.b;
  }
  
  public void setDrivePlanQuery(RouteSearch.DrivePlanQuery paramDrivePlanQuery) {
    this.c = paramDrivePlanQuery;
    RouteSearch.FromAndTo fromAndTo = this.c.getFromAndTo();
    if (fromAndTo != null) {
      setStartPos(fromAndTo.getFrom());
      setTargetPos(fromAndTo.getTo());
    } 
  }
  
  public void setPaths(List<DrivePlanPath> paramList) {
    this.a = paramList;
  }
  
  public void setTimeInfos(List<TimeInfo> paramList) {
    this.b = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\DriveRoutePlanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */