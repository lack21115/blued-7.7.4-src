package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class Doorway implements Parcelable {
  public static final Parcelable.Creator<Doorway> CREATOR = new Parcelable.Creator<Doorway>() {
    
    };
  
  private String a;
  
  private LatLonPoint b;
  
  public Doorway() {}
  
  public Doorway(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public LatLonPoint getLatLonPoint() {
    return this.b;
  }
  
  public String getName() {
    return this.a;
  }
  
  public void setLatLonPoint(LatLonPoint paramLatLonPoint) {
    this.b = paramLatLonPoint;
  }
  
  public void setName(String paramString) {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable((Parcelable)this.b, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\Doorway.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */