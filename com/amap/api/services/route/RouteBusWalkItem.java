package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RouteBusWalkItem extends WalkPath implements Parcelable {
  public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new Parcelable.Creator<RouteBusWalkItem>() {
    
    };
  
  private LatLonPoint a;
  
  private LatLonPoint b;
  
  public RouteBusWalkItem() {}
  
  public RouteBusWalkItem(Parcel paramParcel) {
    super(paramParcel);
    this.a = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.b = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public LatLonPoint getDestination() {
    return this.b;
  }
  
  public LatLonPoint getOrigin() {
    return this.a;
  }
  
  public void setDestination(LatLonPoint paramLatLonPoint) {
    this.b = paramLatLonPoint;
  }
  
  public void setOrigin(LatLonPoint paramLatLonPoint) {
    this.a = paramLatLonPoint;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable((Parcelable)this.a, paramInt);
    paramParcel.writeParcelable((Parcelable)this.b, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RouteBusWalkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */