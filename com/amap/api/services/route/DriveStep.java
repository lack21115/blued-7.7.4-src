package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class DriveStep implements Parcelable {
  public static final Parcelable.Creator<DriveStep> CREATOR = new Parcelable.Creator<DriveStep>() {
    
    };
  
  private String a;
  
  private String b;
  
  private String c;
  
  private float d;
  
  private float e;
  
  private float f;
  
  private String g;
  
  private float h;
  
  private List<LatLonPoint> i = new ArrayList<LatLonPoint>();
  
  private String j;
  
  private String k;
  
  private List<RouteSearchCity> l = new ArrayList<RouteSearchCity>();
  
  private List<TMC> m = new ArrayList<TMC>();
  
  public DriveStep() {}
  
  public DriveStep(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readString();
    this.h = paramParcel.readFloat();
    this.i = paramParcel.createTypedArrayList(LatLonPoint.CREATOR);
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.createTypedArrayList(RouteSearchCity.CREATOR);
    this.m = paramParcel.createTypedArrayList(TMC.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getAction() {
    return this.j;
  }
  
  public String getAssistantAction() {
    return this.k;
  }
  
  public float getDistance() {
    return this.d;
  }
  
  public float getDuration() {
    return this.h;
  }
  
  public String getInstruction() {
    return this.a;
  }
  
  public String getOrientation() {
    return this.b;
  }
  
  public List<LatLonPoint> getPolyline() {
    return this.i;
  }
  
  public String getRoad() {
    return this.c;
  }
  
  public List<RouteSearchCity> getRouteSearchCityList() {
    return this.l;
  }
  
  public List<TMC> getTMCs() {
    return this.m;
  }
  
  public float getTollDistance() {
    return this.f;
  }
  
  public String getTollRoad() {
    return this.g;
  }
  
  public float getTolls() {
    return this.e;
  }
  
  public void setAction(String paramString) {
    this.j = paramString;
  }
  
  public void setAssistantAction(String paramString) {
    this.k = paramString;
  }
  
  public void setDistance(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void setDuration(float paramFloat) {
    this.h = paramFloat;
  }
  
  public void setInstruction(String paramString) {
    this.a = paramString;
  }
  
  public void setOrientation(String paramString) {
    this.b = paramString;
  }
  
  public void setPolyline(List<LatLonPoint> paramList) {
    this.i = paramList;
  }
  
  public void setRoad(String paramString) {
    this.c = paramString;
  }
  
  public void setRouteSearchCityList(List<RouteSearchCity> paramList) {
    this.l = paramList;
  }
  
  public void setTMCs(List<TMC> paramList) {
    this.m = paramList;
  }
  
  public void setTollDistance(float paramFloat) {
    this.f = paramFloat;
  }
  
  public void setTollRoad(String paramString) {
    this.g = paramString;
  }
  
  public void setTolls(float paramFloat) {
    this.e = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeFloat(this.h);
    paramParcel.writeTypedList(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeTypedList(this.l);
    paramParcel.writeTypedList(this.m);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\DriveStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */