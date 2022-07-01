package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RidePath extends Path implements Parcelable {
  public static final Parcelable.Creator<RidePath> CREATOR = new Parcelable.Creator<RidePath>() {
    
    };
  
  private List<RideStep> a = new ArrayList<RideStep>();
  
  public RidePath() {}
  
  public RidePath(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(RideStep.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<RideStep> getSteps() {
    return this.a;
  }
  
  public void setSteps(List<RideStep> paramList) {
    this.a = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RidePath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */