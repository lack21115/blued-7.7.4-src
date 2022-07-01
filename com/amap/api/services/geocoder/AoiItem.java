package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class AoiItem implements Parcelable {
  public static final Parcelable.Creator<AoiItem> CREATOR = new Parcelable.Creator<AoiItem>() {
    
    };
  
  private String a;
  
  private String b;
  
  private String c;
  
  private LatLonPoint d;
  
  private Float e;
  
  public AoiItem() {}
  
  public AoiItem(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.e = Float.valueOf(paramParcel.readFloat());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getAdCode() {
    return this.c;
  }
  
  public Float getAoiArea() {
    return this.e;
  }
  
  public LatLonPoint getAoiCenterPoint() {
    return this.d;
  }
  
  public String getAoiId() {
    return this.a;
  }
  
  public String getAoiName() {
    return this.b;
  }
  
  public void setAdcode(String paramString) {
    this.c = paramString;
  }
  
  public void setArea(Float paramFloat) {
    this.e = paramFloat;
  }
  
  public void setId(String paramString) {
    this.a = paramString;
  }
  
  public void setLocation(LatLonPoint paramLatLonPoint) {
    this.d = paramLatLonPoint;
  }
  
  public void setName(String paramString) {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable((Parcelable)this.d, paramInt);
    paramParcel.writeFloat(this.e.floatValue());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\AoiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */