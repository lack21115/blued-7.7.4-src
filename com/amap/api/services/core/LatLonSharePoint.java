package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLonSharePoint extends LatLonPoint implements Parcelable {
  public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() {
    
    };
  
  private String a;
  
  public LatLonSharePoint(double paramDouble1, double paramDouble2, String paramString) {
    super(paramDouble1, paramDouble2);
    this.a = paramString;
  }
  
  protected LatLonSharePoint(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!super.equals(paramObject))
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    String str = this.a;
    if (str == null) {
      if (((LatLonSharePoint)paramObject).a != null)
        return false; 
    } else if (!str.equals(((LatLonSharePoint)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public String getSharePointName() {
    return this.a;
  }
  
  public int hashCode() {
    int i;
    int j = super.hashCode();
    String str = this.a;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    return j * 31 + i;
  }
  
  public void setSharePointName(String paramString) {
    this.a = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append(",");
    stringBuilder.append(this.a);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\core\LatLonSharePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */