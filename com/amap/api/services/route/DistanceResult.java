package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class DistanceResult implements Parcelable {
  public static final Parcelable.Creator<DistanceResult> CREATOR = new Parcelable.Creator<DistanceResult>() {
    
    };
  
  private DistanceSearch.DistanceQuery a;
  
  private List<DistanceItem> b = null;
  
  public DistanceResult() {}
  
  protected DistanceResult(Parcel paramParcel) {
    this.b = paramParcel.createTypedArrayList(DistanceItem.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public DistanceSearch.DistanceQuery getDistanceQuery() {
    return this.a;
  }
  
  public List<DistanceItem> getDistanceResults() {
    return this.b;
  }
  
  public void setDistanceQuery(DistanceSearch.DistanceQuery paramDistanceQuery) {
    this.a = paramDistanceQuery;
  }
  
  public void setDistanceResults(List<DistanceItem> paramList) {
    this.b = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedList(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\DistanceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */