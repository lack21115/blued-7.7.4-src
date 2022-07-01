package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.i;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusLineItem implements Parcelable {
  public static final Parcelable.Creator<BusLineItem> CREATOR = new Parcelable.Creator<BusLineItem>() {
    
    };
  
  private float a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private List<LatLonPoint> e = new ArrayList<LatLonPoint>();
  
  private List<LatLonPoint> f = new ArrayList<LatLonPoint>();
  
  private String g;
  
  private String h;
  
  private String i;
  
  private Date j;
  
  private Date k;
  
  private String l;
  
  private float m;
  
  private float n;
  
  private List<BusStationItem> o = new ArrayList<BusStationItem>();
  
  public BusLineItem() {}
  
  public BusLineItem(Parcel paramParcel) {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readArrayList(LatLonPoint.class.getClassLoader());
    this.f = paramParcel.readArrayList(LatLonPoint.class.getClassLoader());
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = i.e(paramParcel.readString());
    this.k = i.e(paramParcel.readString());
    this.l = paramParcel.readString();
    this.m = paramParcel.readFloat();
    this.n = paramParcel.readFloat();
    this.o = paramParcel.readArrayList(BusStationItem.class.getClassLoader());
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
    String str = this.g;
    if (str == null) {
      if (((BusLineItem)paramObject).g != null)
        return false; 
    } else if (!str.equals(((BusLineItem)paramObject).g)) {
      return false;
    } 
    return true;
  }
  
  public float getBasicPrice() {
    return this.m;
  }
  
  public List<LatLonPoint> getBounds() {
    return this.f;
  }
  
  public String getBusCompany() {
    return this.l;
  }
  
  public String getBusLineId() {
    return this.g;
  }
  
  public String getBusLineName() {
    return this.b;
  }
  
  public String getBusLineType() {
    return this.c;
  }
  
  public List<BusStationItem> getBusStations() {
    return this.o;
  }
  
  public String getCityCode() {
    return this.d;
  }
  
  public List<LatLonPoint> getDirectionsCoordinates() {
    return this.e;
  }
  
  public float getDistance() {
    return this.a;
  }
  
  public Date getFirstBusTime() {
    Date date = this.j;
    return (date == null) ? null : (Date)date.clone();
  }
  
  public Date getLastBusTime() {
    Date date = this.k;
    return (date == null) ? null : (Date)date.clone();
  }
  
  public String getOriginatingStation() {
    return this.h;
  }
  
  public String getTerminalStation() {
    return this.i;
  }
  
  public float getTotalPrice() {
    return this.n;
  }
  
  public int hashCode() {
    int i;
    String str = this.g;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    return i + 31;
  }
  
  public void setBasicPrice(float paramFloat) {
    this.m = paramFloat;
  }
  
  public void setBounds(List<LatLonPoint> paramList) {
    this.f = paramList;
  }
  
  public void setBusCompany(String paramString) {
    this.l = paramString;
  }
  
  public void setBusLineId(String paramString) {
    this.g = paramString;
  }
  
  public void setBusLineName(String paramString) {
    this.b = paramString;
  }
  
  public void setBusLineType(String paramString) {
    this.c = paramString;
  }
  
  public void setBusStations(List<BusStationItem> paramList) {
    this.o = paramList;
  }
  
  public void setCityCode(String paramString) {
    this.d = paramString;
  }
  
  public void setDirectionsCoordinates(List<LatLonPoint> paramList) {
    this.e = paramList;
  }
  
  public void setDistance(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void setFirstBusTime(Date paramDate) {
    if (paramDate == null) {
      this.j = null;
      return;
    } 
    this.j = (Date)paramDate.clone();
  }
  
  public void setLastBusTime(Date paramDate) {
    if (paramDate == null) {
      this.k = null;
      return;
    } 
    this.k = (Date)paramDate.clone();
  }
  
  public void setOriginatingStation(String paramString) {
    this.h = paramString;
  }
  
  public void setTerminalStation(String paramString) {
    this.i = paramString;
  }
  
  public void setTotalPrice(float paramFloat) {
    this.n = paramFloat;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append(" ");
    stringBuilder.append(i.a(this.j));
    stringBuilder.append("-");
    stringBuilder.append(i.a(this.k));
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeFloat(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeList(this.e);
    paramParcel.writeList(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(i.a(this.j));
    paramParcel.writeString(i.a(this.k));
    paramParcel.writeString(this.l);
    paramParcel.writeFloat(this.m);
    paramParcel.writeFloat(this.n);
    paramParcel.writeList(this.o);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\busline\BusLineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */