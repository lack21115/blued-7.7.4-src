package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class BusStep implements Parcelable {
  public static final Parcelable.Creator<BusStep> CREATOR = new Parcelable.Creator<BusStep>() {
    
    };
  
  private RouteBusWalkItem a;
  
  private List<RouteBusLineItem> b = new ArrayList<RouteBusLineItem>();
  
  private Doorway c;
  
  private Doorway d;
  
  private RouteRailwayItem e;
  
  private TaxiItem f;
  
  public BusStep() {}
  
  public BusStep(Parcel paramParcel) {
    this.a = (RouteBusWalkItem)paramParcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
    this.b = paramParcel.createTypedArrayList(RouteBusLineItem.CREATOR);
    this.c = (Doorway)paramParcel.readParcelable(Doorway.class.getClassLoader());
    this.d = (Doorway)paramParcel.readParcelable(Doorway.class.getClassLoader());
    this.e = (RouteRailwayItem)paramParcel.readParcelable(RouteRailwayItem.class.getClassLoader());
    this.f = (TaxiItem)paramParcel.readParcelable(TaxiItem.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  @Deprecated
  public RouteBusLineItem getBusLine() {
    List<RouteBusLineItem> list = this.b;
    return (list == null || list.size() == 0) ? null : this.b.get(0);
  }
  
  public List<RouteBusLineItem> getBusLines() {
    return this.b;
  }
  
  public Doorway getEntrance() {
    return this.c;
  }
  
  public Doorway getExit() {
    return this.d;
  }
  
  public RouteRailwayItem getRailway() {
    return this.e;
  }
  
  public TaxiItem getTaxi() {
    return this.f;
  }
  
  public RouteBusWalkItem getWalk() {
    return this.a;
  }
  
  @Deprecated
  public void setBusLine(RouteBusLineItem paramRouteBusLineItem) {
    List<RouteBusLineItem> list = this.b;
    if (list == null)
      return; 
    if (list.size() == 0)
      this.b.add(paramRouteBusLineItem); 
    this.b.set(0, paramRouteBusLineItem);
  }
  
  public void setBusLines(List<RouteBusLineItem> paramList) {
    this.b = paramList;
  }
  
  public void setEntrance(Doorway paramDoorway) {
    this.c = paramDoorway;
  }
  
  public void setExit(Doorway paramDoorway) {
    this.d = paramDoorway;
  }
  
  public void setRailway(RouteRailwayItem paramRouteRailwayItem) {
    this.e = paramRouteRailwayItem;
  }
  
  public void setTaxi(TaxiItem paramTaxiItem) {
    this.f = paramTaxiItem;
  }
  
  public void setWalk(RouteBusWalkItem paramRouteBusWalkItem) {
    this.a = paramRouteBusWalkItem;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
    paramParcel.writeParcelable(this.d, paramInt);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeParcelable(this.f, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\BusStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */