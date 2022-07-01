package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class TimeInfo implements Parcelable {
  public static final Parcelable.Creator<TimeInfo> CREATOR = new Parcelable.Creator<TimeInfo>() {
    
    };
  
  private long a;
  
  private List<TimeInfosElement> b = new ArrayList<TimeInfosElement>();
  
  public TimeInfo() {}
  
  public TimeInfo(Parcel paramParcel) {
    this.a = paramParcel.readInt();
    this.b = paramParcel.createTypedArrayList(TimeInfosElement.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<TimeInfosElement> getElements() {
    return this.b;
  }
  
  public long getStartTime() {
    return this.a;
  }
  
  public void setElements(List<TimeInfosElement> paramList) {
    this.b = paramList;
  }
  
  public void setStartTime(long paramLong) {
    this.a = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeLong(this.a);
    paramParcel.writeTypedList(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\TimeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */