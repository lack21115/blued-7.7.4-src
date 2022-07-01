package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class LatLng implements Parcelable, Cloneable {
  public static final f CREATOR = new f();
  
  private static DecimalFormat a = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
  
  public final double latitude;
  
  public final double longitude;
  
  public LatLng(double paramDouble1, double paramDouble2) {
    if (-180.0D <= paramDouble2 && paramDouble2 < 180.0D) {
      this.longitude = a(paramDouble2);
    } else {
      this.longitude = a(((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D);
    } 
    this.latitude = a(Math.max(-90.0D, Math.min(90.0D, paramDouble1)));
  }
  
  private static double a(double paramDouble) {
    try {
      return Double.parseDouble(a.format(paramDouble));
    } finally {
      Exception exception = null;
    } 
  }
  
  public LatLng clone() {
    return new LatLng(this.latitude, this.longitude);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LatLng))
      return false; 
    paramObject = paramObject;
    return (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(((LatLng)paramObject).latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(((LatLng)paramObject).longitude));
  }
  
  public int hashCode() {
    long l = Double.doubleToLongBits(this.latitude);
    int i = (int)(l ^ l >>> 32L);
    l = Double.doubleToLongBits(this.longitude);
    return (i + 31) * 31 + (int)(l ^ l >>> 32L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("lat/lng: (");
    stringBuilder.append(this.latitude);
    stringBuilder.append(",");
    stringBuilder.append(this.longitude);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeDouble(this.latitude);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */