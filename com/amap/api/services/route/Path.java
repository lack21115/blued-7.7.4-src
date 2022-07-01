package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class Path implements Parcelable {
  public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() {
    
    };
  
  private float a;
  
  private long b;
  
  private List<LatLonPoint> c = new ArrayList<LatLonPoint>();
  
  public Path() {}
  
  public Path(Parcel paramParcel) {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readLong();
    this.c = paramParcel.createTypedArrayList(LatLonPoint.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getDistance() {
    return this.a;
  }
  
  public long getDuration() {
    return this.b;
  }
  
  public List<LatLonPoint> getPolyline() {
    return this.c;
  }
  
  public void setDistance(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void setDuration(long paramLong) {
    this.b = paramLong;
  }
  
  public void setPolyline(List<LatLonPoint> paramList) {
    this.c = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeFloat(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\Path.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */