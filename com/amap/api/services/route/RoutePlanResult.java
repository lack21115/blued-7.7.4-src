package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RoutePlanResult implements Parcelable {
  public static final Parcelable.Creator<RoutePlanResult> CREATOR = new Parcelable.Creator<RoutePlanResult>() {
    
    };
  
  private LatLonPoint a;
  
  private LatLonPoint b;
  
  public RoutePlanResult() {}
  
  public RoutePlanResult(Parcel paramParcel) {
    this.a = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.b = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public LatLonPoint getStartPos() {
    return this.a;
  }
  
  public LatLonPoint getTargetPos() {
    return this.b;
  }
  
  public void setStartPos(LatLonPoint paramLatLonPoint) {
    this.a = paramLatLonPoint;
  }
  
  public void setTargetPos(LatLonPoint paramLatLonPoint) {
    this.b = paramLatLonPoint;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.a, paramInt);
    paramParcel.writeParcelable((Parcelable)this.b, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RoutePlanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */