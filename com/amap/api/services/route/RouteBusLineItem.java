package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class RouteBusLineItem extends BusLineItem implements Parcelable {
  public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new Parcelable.Creator<RouteBusLineItem>() {
    
    };
  
  private BusStationItem a;
  
  private BusStationItem b;
  
  private List<LatLonPoint> c = new ArrayList<LatLonPoint>();
  
  private int d;
  
  private List<BusStationItem> e = new ArrayList<BusStationItem>();
  
  private float f;
  
  public RouteBusLineItem() {}
  
  public RouteBusLineItem(Parcel paramParcel) {
    super(paramParcel);
    this.a = (BusStationItem)paramParcel.readParcelable(BusStationItem.class.getClassLoader());
    this.b = (BusStationItem)paramParcel.readParcelable(BusStationItem.class.getClassLoader());
    this.c = paramParcel.createTypedArrayList(LatLonPoint.CREATOR);
    this.d = paramParcel.readInt();
    this.e = paramParcel.createTypedArrayList(BusStationItem.CREATOR);
    this.f = paramParcel.readFloat();
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
    BusStationItem busStationItem = this.b;
    if (busStationItem == null) {
      if (((RouteBusLineItem)paramObject).b != null)
        return false; 
    } else if (!busStationItem.equals(((RouteBusLineItem)paramObject).b)) {
      return false;
    } 
    busStationItem = this.a;
    if (busStationItem == null) {
      if (((RouteBusLineItem)paramObject).a != null)
        return false; 
    } else if (!busStationItem.equals(((RouteBusLineItem)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public BusStationItem getArrivalBusStation() {
    return this.b;
  }
  
  public BusStationItem getDepartureBusStation() {
    return this.a;
  }
  
  public float getDuration() {
    return this.f;
  }
  
  public int getPassStationNum() {
    return this.d;
  }
  
  public List<BusStationItem> getPassStations() {
    return this.e;
  }
  
  public List<LatLonPoint> getPolyline() {
    return this.c;
  }
  
  public int hashCode() {
    int i;
    int k = super.hashCode();
    BusStationItem busStationItem = this.b;
    int j = 0;
    if (busStationItem == null) {
      i = 0;
    } else {
      i = busStationItem.hashCode();
    } 
    busStationItem = this.a;
    if (busStationItem != null)
      j = busStationItem.hashCode(); 
    return (k * 31 + i) * 31 + j;
  }
  
  public void setArrivalBusStation(BusStationItem paramBusStationItem) {
    this.b = paramBusStationItem;
  }
  
  public void setDepartureBusStation(BusStationItem paramBusStationItem) {
    this.a = paramBusStationItem;
  }
  
  public void setDuration(float paramFloat) {
    this.f = paramFloat;
  }
  
  public void setPassStationNum(int paramInt) {
    this.d = paramInt;
  }
  
  public void setPassStations(List<BusStationItem> paramList) {
    this.e = paramList;
  }
  
  public void setPolyline(List<LatLonPoint> paramList) {
    this.c = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable((Parcelable)this.a, paramInt);
    paramParcel.writeParcelable((Parcelable)this.b, paramInt);
    paramParcel.writeTypedList(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeTypedList(this.e);
    paramParcel.writeFloat(this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RouteBusLineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */