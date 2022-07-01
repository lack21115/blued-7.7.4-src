package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class WalkPath extends Path implements Parcelable {
  public static final Parcelable.Creator<WalkPath> CREATOR = new Parcelable.Creator<WalkPath>() {
    
    };
  
  private List<WalkStep> a = new ArrayList<WalkStep>();
  
  public WalkPath() {}
  
  public WalkPath(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(WalkStep.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<WalkStep> getSteps() {
    return this.a;
  }
  
  public void setSteps(List<WalkStep> paramList) {
    this.a = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\WalkPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */