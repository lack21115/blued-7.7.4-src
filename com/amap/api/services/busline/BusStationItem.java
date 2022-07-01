package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class BusStationItem implements Parcelable {
  public static final Parcelable.Creator<BusStationItem> CREATOR = new Parcelable.Creator<BusStationItem>() {
    
    };
  
  private String a;
  
  private String b;
  
  private LatLonPoint c;
  
  private String d;
  
  private String e;
  
  private List<BusLineItem> f = new ArrayList<BusLineItem>();
  
  public BusStationItem() {}
  
  private BusStationItem(Parcel paramParcel) {
    this.b = paramParcel.readString();
    this.a = paramParcel.readString();
    this.c = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readArrayList(BusLineItem.class.getClassLoader());
  }
  
  private static String a(List<BusLineItem> paramList) {
    StringBuffer stringBuffer = new StringBuffer();
    if (paramList != null)
      for (int i = 0; i < paramList.size(); i++) {
        stringBuffer.append(((BusLineItem)paramList.get(i)).getBusLineName());
        if (i < paramList.size() - 1)
          stringBuffer.append("|"); 
      }  
    return stringBuffer.toString();
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
    String str = this.a;
    if (str == null) {
      if (((BusStationItem)paramObject).a != null)
        return false; 
    } else if (!str.equals(((BusStationItem)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public String getAdCode() {
    return this.e;
  }
  
  public List<BusLineItem> getBusLineItems() {
    return this.f;
  }
  
  public String getBusStationId() {
    return this.a;
  }
  
  public String getBusStationName() {
    return this.b;
  }
  
  public String getCityCode() {
    return this.d;
  }
  
  public LatLonPoint getLatLonPoint() {
    return this.c;
  }
  
  public int hashCode() {
    int i;
    String str = this.a;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    return i + 31;
  }
  
  public void setAdCode(String paramString) {
    this.e = paramString;
  }
  
  public void setBusLineItems(List<BusLineItem> paramList) {
    this.f = paramList;
  }
  
  public void setBusStationId(String paramString) {
    this.a = paramString;
  }
  
  public void setBusStationName(String paramString) {
    this.b = paramString;
  }
  
  public void setCityCode(String paramString) {
    this.d = paramString;
  }
  
  public void setLatLonPoint(LatLonPoint paramLatLonPoint) {
    this.c = paramLatLonPoint;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("BusStationName: ");
    stringBuilder.append(this.b);
    stringBuilder.append(" LatLonPoint: ");
    stringBuilder.append(this.c.toString());
    stringBuilder.append(" BusLines: ");
    stringBuilder.append(a(this.f));
    stringBuilder.append(" CityCode: ");
    stringBuilder.append(this.d);
    stringBuilder.append(" AdCode: ");
    stringBuilder.append(this.e);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.a);
    paramParcel.writeValue(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeList(this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\busline\BusStationItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */