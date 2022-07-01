package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RoutePOIItem implements Parcelable {
  public static final Parcelable.Creator<RoutePOIItem> CREATOR = new Parcelable.Creator<RoutePOIItem>() {
    
    };
  
  private String a;
  
  private String b;
  
  private LatLonPoint c;
  
  private float d;
  
  private float e;
  
  public RoutePOIItem() {}
  
  protected RoutePOIItem(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readFloat();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getDistance() {
    return this.d;
  }
  
  public float getDuration() {
    return this.e;
  }
  
  public String getID() {
    return this.a;
  }
  
  public LatLonPoint getPoint() {
    return this.c;
  }
  
  public String getTitle() {
    return this.b;
  }
  
  public void setDistance(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void setDuration(float paramFloat) {
    this.e = paramFloat;
  }
  
  public void setID(String paramString) {
    this.a = paramString;
  }
  
  public void setPoint(LatLonPoint paramLatLonPoint) {
    this.c = paramLatLonPoint;
  }
  
  public void setTitle(String paramString) {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable((Parcelable)this.c, paramInt);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\routepoisearch\RoutePOIItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */