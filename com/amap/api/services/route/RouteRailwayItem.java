package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RouteRailwayItem extends Railway implements Parcelable {
  public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new Parcelable.Creator<RouteRailwayItem>() {
    
    };
  
  private String a;
  
  private String b;
  
  private float c;
  
  private String d;
  
  private RailwayStationItem e;
  
  private RailwayStationItem f;
  
  private List<RailwayStationItem> g = new ArrayList<RailwayStationItem>();
  
  private List<Railway> h = new ArrayList<Railway>();
  
  private List<RailwaySpace> i = new ArrayList<RailwaySpace>();
  
  public RouteRailwayItem() {}
  
  protected RouteRailwayItem(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readString();
    this.e = (RailwayStationItem)paramParcel.readParcelable(RailwayStationItem.class.getClassLoader());
    this.f = (RailwayStationItem)paramParcel.readParcelable(RailwayStationItem.class.getClassLoader());
    this.g = paramParcel.createTypedArrayList(RailwayStationItem.CREATOR);
    this.h = paramParcel.createTypedArrayList(Railway.CREATOR);
    this.i = paramParcel.createTypedArrayList(RailwaySpace.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public List<Railway> getAlters() {
    return this.h;
  }
  
  public RailwayStationItem getArrivalstop() {
    return this.f;
  }
  
  public RailwayStationItem getDeparturestop() {
    return this.e;
  }
  
  public float getDistance() {
    return this.c;
  }
  
  public List<RailwaySpace> getSpaces() {
    return this.i;
  }
  
  public String getTime() {
    return this.a;
  }
  
  public String getTrip() {
    return this.b;
  }
  
  public String getType() {
    return this.d;
  }
  
  public List<RailwayStationItem> getViastops() {
    return this.g;
  }
  
  public void setAlters(List<Railway> paramList) {
    this.h = paramList;
  }
  
  public void setArrivalstop(RailwayStationItem paramRailwayStationItem) {
    this.f = paramRailwayStationItem;
  }
  
  public void setDeparturestop(RailwayStationItem paramRailwayStationItem) {
    this.e = paramRailwayStationItem;
  }
  
  public void setDistance(float paramFloat) {
    this.c = paramFloat;
  }
  
  public void setSpaces(List<RailwaySpace> paramList) {
    this.i = paramList;
  }
  
  public void setTime(String paramString) {
    this.a = paramString;
  }
  
  public void setTrip(String paramString) {
    this.b = paramString;
  }
  
  public void setType(String paramString) {
    this.d = paramString;
  }
  
  public void setViastops(List<RailwayStationItem> paramList) {
    this.g = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeParcelable(this.f, paramInt);
    paramParcel.writeTypedList(this.g);
    paramParcel.writeTypedList(this.h);
    paramParcel.writeTypedList(this.i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RouteRailwayItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */