package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLonPoint implements Parcelable {
  public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() {
    
    };
  
  private double a;
  
  private double b;
  
  public LatLonPoint(double paramDouble1, double paramDouble2) {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  protected LatLonPoint(Parcel paramParcel) {
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
  }
  
  public LatLonPoint copy() {
    return new LatLonPoint(this.a, this.b);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(((LatLonPoint)paramObject).a)) ? false : (!(Double.doubleToLongBits(this.b) != Double.doubleToLongBits(((LatLonPoint)paramObject).b)));
  }
  
  public double getLatitude() {
    return this.a;
  }
  
  public double getLongitude() {
    return this.b;
  }
  
  public int hashCode() {
    long l = Double.doubleToLongBits(this.a);
    int i = (int)(l ^ l >>> 32L);
    l = Double.doubleToLongBits(this.b);
    return (i + 31) * 31 + (int)(l ^ l >>> 32L);
  }
  
  public void setLatitude(double paramDouble) {
    this.a = paramDouble;
  }
  
  public void setLongitude(double paramDouble) {
    this.b = paramDouble;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(",");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\core\LatLonPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */