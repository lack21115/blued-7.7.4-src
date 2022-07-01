package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RailwayStationItem implements Parcelable {
  public static final Parcelable.Creator<RailwayStationItem> CREATOR = new Parcelable.Creator<RailwayStationItem>() {
    
    };
  
  private String a;
  
  private String b;
  
  private LatLonPoint c;
  
  private String d;
  
  private String e;
  
  private boolean f = false;
  
  private boolean g = false;
  
  private float h;
  
  public RailwayStationItem() {}
  
  protected RailwayStationItem(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    boolean[] arrayOfBoolean = new boolean[2];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.f = arrayOfBoolean[0];
    this.g = arrayOfBoolean[1];
    this.h = paramParcel.readFloat();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getAdcode() {
    return this.d;
  }
  
  public String getID() {
    return this.a;
  }
  
  public LatLonPoint getLocation() {
    return this.c;
  }
  
  public String getName() {
    return this.b;
  }
  
  public String getTime() {
    return this.e;
  }
  
  public float getWait() {
    return this.h;
  }
  
  public boolean isEnd() {
    return this.g;
  }
  
  public boolean isStart() {
    return this.f;
  }
  
  public void setAdcode(String paramString) {
    this.d = paramString;
  }
  
  public void setID(String paramString) {
    this.a = paramString;
  }
  
  public void setLocation(LatLonPoint paramLatLonPoint) {
    this.c = paramLatLonPoint;
  }
  
  public void setName(String paramString) {
    this.b = paramString;
  }
  
  public void setTime(String paramString) {
    this.e = paramString;
  }
  
  public void setWait(float paramFloat) {
    this.h = paramFloat;
  }
  
  public void setisEnd(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void setisStart(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable((Parcelable)this.c, paramInt);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeBooleanArray(new boolean[] { this.f, this.g });
    paramParcel.writeFloat(this.h);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RailwayStationItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */