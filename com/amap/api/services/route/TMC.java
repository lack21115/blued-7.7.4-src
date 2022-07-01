package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class TMC implements Parcelable {
  public static final Parcelable.Creator<TMC> CREATOR = new Parcelable.Creator<TMC>() {
    
    };
  
  private int a;
  
  private String b;
  
  private List<LatLonPoint> c = new ArrayList<LatLonPoint>();
  
  public TMC() {}
  
  public TMC(Parcel paramParcel) {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.createTypedArrayList(LatLonPoint.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public int getDistance() {
    return this.a;
  }
  
  public List<LatLonPoint> getPolyline() {
    return this.c;
  }
  
  public String getStatus() {
    return this.b;
  }
  
  public void setDistance(int paramInt) {
    this.a = paramInt;
  }
  
  public void setPolyline(List<LatLonPoint> paramList) {
    this.c = paramList;
  }
  
  public void setStatus(String paramString) {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\TMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */