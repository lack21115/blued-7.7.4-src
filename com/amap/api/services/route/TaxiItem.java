package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class TaxiItem implements Parcelable {
  public static final Parcelable.Creator<TaxiItem> CREATOR = new Parcelable.Creator<TaxiItem>() {
    
    };
  
  private LatLonPoint a;
  
  private LatLonPoint b;
  
  private float c;
  
  private float d;
  
  private String e;
  
  private String f;
  
  public TaxiItem() {}
  
  protected TaxiItem(Parcel paramParcel) {
    this.a = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.b = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public LatLonPoint getDestination() {
    return this.b;
  }
  
  public float getDistance() {
    return this.c;
  }
  
  public float getDuration() {
    return this.d;
  }
  
  public LatLonPoint getOrigin() {
    return this.a;
  }
  
  public String getmSname() {
    return this.e;
  }
  
  public String getmTname() {
    return this.f;
  }
  
  public void setDestination(LatLonPoint paramLatLonPoint) {
    this.b = paramLatLonPoint;
  }
  
  public void setDistance(float paramFloat) {
    this.c = paramFloat;
  }
  
  public void setDuration(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void setOrigin(LatLonPoint paramLatLonPoint) {
    this.a = paramLatLonPoint;
  }
  
  public void setSname(String paramString) {
    this.e = paramString;
  }
  
  public void setTname(String paramString) {
    this.f = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.a, paramInt);
    paramParcel.writeParcelable((Parcelable)this.b, paramInt);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\TaxiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */