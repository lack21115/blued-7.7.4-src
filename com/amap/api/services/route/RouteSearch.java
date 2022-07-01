package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.be;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import java.util.ArrayList;
import java.util.List;

public class RouteSearch {
  public static final int BUS_COMFORTABLE = 4;
  
  public static final int BUS_DEFAULT = 0;
  
  public static final int BUS_LEASE_CHANGE = 2;
  
  public static final int BUS_LEASE_WALK = 3;
  
  public static final int BUS_NO_SUBWAY = 5;
  
  public static final int BUS_SAVE_MONEY = 1;
  
  public static final int BusComfortable = 4;
  
  public static final int BusDefault = 0;
  
  public static final int BusLeaseChange = 2;
  
  public static final int BusLeaseWalk = 3;
  
  public static final int BusNoSubway = 5;
  
  public static final int BusSaveMoney = 1;
  
  public static final int DRIVEING_PLAN_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
  
  public static final int DRIVEING_PLAN_AVOID_CONGESTION_FASTEST_SAVE_MONEY = 11;
  
  public static final int DRIVEING_PLAN_AVOID_CONGESTION_NO_HIGHWAY = 4;
  
  public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY = 6;
  
  public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY_NO_HIGHWAY = 7;
  
  public static final int DRIVEING_PLAN_CHOICE_HIGHWAY = 8;
  
  public static final int DRIVEING_PLAN_DEFAULT = 1;
  
  public static final int DRIVEING_PLAN_FASTEST_SHORTEST = 10;
  
  public static final int DRIVEING_PLAN_NO_HIGHWAY = 2;
  
  public static final int DRIVEING_PLAN_SAVE_MONEY = 3;
  
  public static final int DRIVEING_PLAN_SAVE_MONEY_NO_HIGHWAY = 5;
  
  public static final String DRIVING_EXCLUDE_FERRY = "ferry";
  
  public static final String DRIVING_EXCLUDE_MOTORWAY = "motorway";
  
  public static final String DRIVING_EXCLUDE_TOLL = "toll";
  
  public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
  
  public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
  
  public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
  
  public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
  
  public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
  
  public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
  
  public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
  
  public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
  
  public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
  
  public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
  
  public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
  
  public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
  
  public static final int DRIVING_NORMAL_CAR = 0;
  
  public static final int DRIVING_PLUGIN_HYBRID_CAR = 2;
  
  public static final int DRIVING_PURE_ELECTRIC_VEHICLE = 1;
  
  public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
  
  public static final int DRIVING_SINGLE_DEFAULT = 0;
  
  public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
  
  public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
  
  public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
  
  public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
  
  public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
  
  public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
  
  public static final int DRIVING_SINGLE_SHORTEST = 2;
  
  public static final int DrivingAvoidCongestion = 4;
  
  public static final int DrivingDefault = 0;
  
  public static final int DrivingMultiStrategy = 5;
  
  public static final int DrivingNoExpressways = 3;
  
  public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
  
  public static final int DrivingNoHighWay = 6;
  
  public static final int DrivingNoHighWaySaveMoney = 7;
  
  public static final int DrivingSaveMoney = 1;
  
  public static final int DrivingSaveMoneyAvoidCongestion = 8;
  
  public static final int DrivingShortDistance = 2;
  
  public static final String EXTENSIONS_ALL = "all";
  
  public static final String EXTENSIONS_BASE = "base";
  
  public static final int RIDING_DEFAULT = 0;
  
  public static final int RIDING_FAST = 2;
  
  public static final int RIDING_RECOMMEND = 1;
  
  public static final int RidingDefault = 0;
  
  public static final int RidingFast = 2;
  
  public static final int RidingRecommend = 1;
  
  public static final int TRUCK_AVOID_CONGESTION = 1;
  
  public static final int TRUCK_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
  
  public static final int TRUCK_AVOID_CONGESTION_NO_HIGHWAY = 4;
  
  public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY = 6;
  
  public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY_NO_HIGHWAY = 7;
  
  public static final int TRUCK_CHOICE_HIGHWAY = 8;
  
  public static final int TRUCK_NO_HIGHWAY = 2;
  
  public static final int TRUCK_SAVE_MONEY = 3;
  
  public static final int TRUCK_SAVE_MONEY_NO_HIGHWAY = 5;
  
  public static final int TRUCK_SIZE_HEAVY = 4;
  
  public static final int TRUCK_SIZE_LIGHT = 2;
  
  public static final int TRUCK_SIZE_MEDIUM = 3;
  
  public static final int TRUCK_SIZE_MINI = 1;
  
  public static final int WALK_DEFAULT = 0;
  
  public static final int WALK_MULTI_PATH = 1;
  
  public static final int WalkDefault = 0;
  
  public static final int WalkMultipath = 1;
  
  private IRouteSearch a;
  
  public RouteSearch(Context paramContext) {
    if (this.a == null)
      try {
        this.a = (IRouteSearch)new be(paramContext);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public BusRouteResult calculateBusRoute(BusRouteQuery paramBusRouteQuery) throws AMapException {
    IRouteSearch iRouteSearch = this.a;
    return (iRouteSearch != null) ? iRouteSearch.calculateBusRoute(paramBusRouteQuery) : null;
  }
  
  public void calculateBusRouteAsyn(BusRouteQuery paramBusRouteQuery) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.calculateBusRouteAsyn(paramBusRouteQuery); 
  }
  
  public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery paramDrivePlanQuery) throws AMapException {
    IRouteSearch iRouteSearch = this.a;
    return (iRouteSearch != null) ? iRouteSearch.calculateDrivePlan(paramDrivePlanQuery) : null;
  }
  
  public void calculateDrivePlanAsyn(DrivePlanQuery paramDrivePlanQuery) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.calculateDrivePlanAsyn(paramDrivePlanQuery); 
  }
  
  public DriveRouteResult calculateDriveRoute(DriveRouteQuery paramDriveRouteQuery) throws AMapException {
    IRouteSearch iRouteSearch = this.a;
    return (iRouteSearch != null) ? iRouteSearch.calculateDriveRoute(paramDriveRouteQuery) : null;
  }
  
  public void calculateDriveRouteAsyn(DriveRouteQuery paramDriveRouteQuery) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.calculateDriveRouteAsyn(paramDriveRouteQuery); 
  }
  
  public RideRouteResult calculateRideRoute(RideRouteQuery paramRideRouteQuery) throws AMapException {
    IRouteSearch iRouteSearch = this.a;
    return (iRouteSearch != null) ? iRouteSearch.calculateRideRoute(paramRideRouteQuery) : null;
  }
  
  public void calculateRideRouteAsyn(RideRouteQuery paramRideRouteQuery) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.calculateRideRouteAsyn(paramRideRouteQuery); 
  }
  
  public TruckRouteRestult calculateTruckRoute(TruckRouteQuery paramTruckRouteQuery) throws AMapException {
    IRouteSearch iRouteSearch = this.a;
    return (iRouteSearch != null) ? iRouteSearch.calculateTruckRoute(paramTruckRouteQuery) : null;
  }
  
  public void calculateTruckRouteAsyn(TruckRouteQuery paramTruckRouteQuery) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.calculateTruckRouteAsyn(paramTruckRouteQuery); 
  }
  
  public WalkRouteResult calculateWalkRoute(WalkRouteQuery paramWalkRouteQuery) throws AMapException {
    IRouteSearch iRouteSearch = this.a;
    return (iRouteSearch != null) ? iRouteSearch.calculateWalkRoute(paramWalkRouteQuery) : null;
  }
  
  public void calculateWalkRouteAsyn(WalkRouteQuery paramWalkRouteQuery) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.calculateWalkRouteAsyn(paramWalkRouteQuery); 
  }
  
  public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener paramOnRoutePlanSearchListener) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.setOnRoutePlanSearchListener(paramOnRoutePlanSearchListener); 
  }
  
  public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener paramOnTruckRouteSearchListener) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.setOnTruckRouteSearchListener(paramOnTruckRouteSearchListener); 
  }
  
  public void setRouteSearchListener(OnRouteSearchListener paramOnRouteSearchListener) {
    IRouteSearch iRouteSearch = this.a;
    if (iRouteSearch != null)
      iRouteSearch.setRouteSearchListener(paramOnRouteSearchListener); 
  }
  
  public static class BusRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() {
      
      };
    
    private RouteSearch.FromAndTo a;
    
    private int b;
    
    private String c;
    
    private String d;
    
    private int e;
    
    private String f = "base";
    
    public BusRouteQuery() {}
    
    public BusRouteQuery(Parcel param1Parcel) {
      this.a = (RouteSearch.FromAndTo)param1Parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readString();
      this.e = param1Parcel.readInt();
      this.d = param1Parcel.readString();
      this.f = param1Parcel.readString();
    }
    
    public BusRouteQuery(RouteSearch.FromAndTo param1FromAndTo, int param1Int1, String param1String, int param1Int2) {
      this.a = param1FromAndTo;
      this.b = param1Int1;
      this.c = param1String;
      this.e = param1Int2;
    }
    
    public BusRouteQuery clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "RouteSearch", "BusRouteQueryclone");
      } 
      BusRouteQuery busRouteQuery = new BusRouteQuery(this.a, this.b, this.c, this.e);
      busRouteQuery.setCityd(this.d);
      busRouteQuery.setExtensions(this.f);
      return busRouteQuery;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      String str = this.c;
      if (str == null) {
        if (((BusRouteQuery)param1Object).c != null)
          return false; 
      } else if (!str.equals(((BusRouteQuery)param1Object).c)) {
        return false;
      } 
      str = this.d;
      if (str == null) {
        if (((BusRouteQuery)param1Object).d != null)
          return false; 
      } else if (!str.equals(((BusRouteQuery)param1Object).d)) {
        return false;
      } 
      str = this.f;
      if (str == null) {
        if (((BusRouteQuery)param1Object).f != null)
          return false; 
      } else if (!str.equals(((BusRouteQuery)param1Object).f)) {
        return false;
      } 
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        if (((BusRouteQuery)param1Object).a != null)
          return false; 
      } else if (!fromAndTo.equals(((BusRouteQuery)param1Object).a)) {
        return false;
      } 
      return (this.b != ((BusRouteQuery)param1Object).b) ? false : (!(this.e != ((BusRouteQuery)param1Object).e));
    }
    
    public String getCity() {
      return this.c;
    }
    
    public String getCityd() {
      return this.d;
    }
    
    public String getExtensions() {
      return this.f;
    }
    
    public RouteSearch.FromAndTo getFromAndTo() {
      return this.a;
    }
    
    public int getMode() {
      return this.b;
    }
    
    public int getNightFlag() {
      return this.e;
    }
    
    public int hashCode() {
      int i;
      int j;
      String str2 = this.c;
      int k = 0;
      if (str2 == null) {
        i = 0;
      } else {
        i = str2.hashCode();
      } 
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        j = 0;
      } else {
        j = fromAndTo.hashCode();
      } 
      int m = this.b;
      int n = this.e;
      String str1 = this.d;
      if (str1 != null)
        k = str1.hashCode(); 
      return ((((i + 31) * 31 + j) * 31 + m) * 31 + n) * 31 + k;
    }
    
    public void setCityd(String param1String) {
      this.d = param1String;
    }
    
    public void setExtensions(String param1String) {
      this.f = param1String;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeParcelable(this.a, param1Int);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeString(this.c);
      param1Parcel.writeInt(this.e);
      param1Parcel.writeString(this.d);
      param1Parcel.writeString(this.f);
    }
  }
  
  static final class null implements Parcelable.Creator<BusRouteQuery> {}
  
  public static class DrivePlanQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new Parcelable.Creator<DrivePlanQuery>() {
      
      };
    
    private RouteSearch.FromAndTo a;
    
    private String b;
    
    private int c = 1;
    
    private int d = 0;
    
    private int e = 0;
    
    private int f = 0;
    
    private int g = 48;
    
    public DrivePlanQuery() {}
    
    protected DrivePlanQuery(Parcel param1Parcel) {
      this.a = (RouteSearch.FromAndTo)param1Parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
      this.b = param1Parcel.readString();
      this.c = param1Parcel.readInt();
      this.d = param1Parcel.readInt();
      this.e = param1Parcel.readInt();
      this.f = param1Parcel.readInt();
      this.g = param1Parcel.readInt();
    }
    
    public DrivePlanQuery(RouteSearch.FromAndTo param1FromAndTo, int param1Int1, int param1Int2, int param1Int3) {
      this.a = param1FromAndTo;
      this.e = param1Int1;
      this.f = param1Int2;
      this.g = param1Int3;
    }
    
    public DrivePlanQuery clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "RouteSearch", "DriveRouteQueryclone");
      } 
      DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.a, this.e, this.f, this.g);
      drivePlanQuery.setDestParentPoiID(this.b);
      drivePlanQuery.setMode(this.c);
      drivePlanQuery.setCarType(this.d);
      return drivePlanQuery;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        if (((DrivePlanQuery)param1Object).a != null)
          return false; 
      } else if (!fromAndTo.equals(((DrivePlanQuery)param1Object).a)) {
        return false;
      } 
      String str = this.b;
      if (str == null) {
        if (((DrivePlanQuery)param1Object).b != null)
          return false; 
      } else if (!str.equals(((DrivePlanQuery)param1Object).b)) {
        return false;
      } 
      return (this.c != ((DrivePlanQuery)param1Object).c) ? false : ((this.d != ((DrivePlanQuery)param1Object).d) ? false : ((this.e != ((DrivePlanQuery)param1Object).e) ? false : ((this.f != ((DrivePlanQuery)param1Object).f) ? false : (!(this.g != ((DrivePlanQuery)param1Object).g)))));
    }
    
    public int getCarType() {
      return this.d;
    }
    
    public int getCount() {
      return this.g;
    }
    
    public String getDestParentPoiID() {
      return this.b;
    }
    
    public int getFirstTime() {
      return this.e;
    }
    
    public RouteSearch.FromAndTo getFromAndTo() {
      return this.a;
    }
    
    public int getInterval() {
      return this.f;
    }
    
    public int getMode() {
      return this.c;
    }
    
    public int hashCode() {
      int i;
      RouteSearch.FromAndTo fromAndTo = this.a;
      int j = 0;
      if (fromAndTo == null) {
        i = 0;
      } else {
        i = fromAndTo.hashCode();
      } 
      String str = this.b;
      if (str != null)
        j = str.hashCode(); 
      return ((((((i + 31) * 31 + j) * 31 + this.c) * 31 + this.d) * 31 + this.e) * 31 + this.f) * 31 + this.g;
    }
    
    public void setCarType(int param1Int) {
      this.d = param1Int;
    }
    
    public void setDestParentPoiID(String param1String) {
      this.b = param1String;
    }
    
    public void setMode(int param1Int) {
      this.c = param1Int;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeParcelable(this.a, param1Int);
      param1Parcel.writeString(this.b);
      param1Parcel.writeInt(this.c);
      param1Parcel.writeInt(this.d);
      param1Parcel.writeInt(this.e);
      param1Parcel.writeInt(this.f);
      param1Parcel.writeInt(this.g);
    }
  }
  
  static final class null implements Parcelable.Creator<DrivePlanQuery> {}
  
  public static class DriveRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() {
      
      };
    
    private RouteSearch.FromAndTo a;
    
    private int b;
    
    private List<LatLonPoint> c;
    
    private List<List<LatLonPoint>> d;
    
    private String e;
    
    private boolean f;
    
    private int g;
    
    private String h;
    
    private String i;
    
    public DriveRouteQuery() {
      this.f = true;
      this.g = 0;
      this.h = null;
      this.i = "base";
    }
    
    public DriveRouteQuery(Parcel param1Parcel) {
      boolean bool = true;
      this.f = true;
      this.g = 0;
      this.h = null;
      this.i = "base";
      this.a = (RouteSearch.FromAndTo)param1Parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.createTypedArrayList(LatLonPoint.CREATOR);
      int j = param1Parcel.readInt();
      if (j == 0) {
        this.d = null;
      } else {
        this.d = new ArrayList<List<LatLonPoint>>();
      } 
      for (int i = 0; i < j; i++)
        this.d.add(param1Parcel.createTypedArrayList(LatLonPoint.CREATOR)); 
      this.e = param1Parcel.readString();
      if (param1Parcel.readInt() != 1)
        bool = false; 
      this.f = bool;
      this.g = param1Parcel.readInt();
      this.h = param1Parcel.readString();
      this.i = param1Parcel.readString();
    }
    
    public DriveRouteQuery(RouteSearch.FromAndTo param1FromAndTo, int param1Int, List<LatLonPoint> param1List, List<List<LatLonPoint>> param1List1, String param1String) {
      this.f = true;
      this.g = 0;
      this.h = null;
      this.i = "base";
      this.a = param1FromAndTo;
      this.b = param1Int;
      this.c = param1List;
      this.d = param1List1;
      this.e = param1String;
    }
    
    public DriveRouteQuery clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "RouteSearch", "DriveRouteQueryclone");
      } 
      DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.a, this.b, this.c, this.d, this.e);
      driveRouteQuery.setUseFerry(this.f);
      driveRouteQuery.setCarType(this.g);
      driveRouteQuery.setExclude(this.h);
      driveRouteQuery.setExtensions(this.i);
      return driveRouteQuery;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      String str2 = this.e;
      if (str2 == null) {
        if (((DriveRouteQuery)param1Object).e != null)
          return false; 
      } else if (!str2.equals(((DriveRouteQuery)param1Object).e)) {
        return false;
      } 
      List<List<LatLonPoint>> list1 = this.d;
      if (list1 == null) {
        if (((DriveRouteQuery)param1Object).d != null)
          return false; 
      } else if (!list1.equals(((DriveRouteQuery)param1Object).d)) {
        return false;
      } 
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        if (((DriveRouteQuery)param1Object).a != null)
          return false; 
      } else if (!fromAndTo.equals(((DriveRouteQuery)param1Object).a)) {
        return false;
      } 
      if (this.b != ((DriveRouteQuery)param1Object).b)
        return false; 
      List<LatLonPoint> list = this.c;
      if (list == null) {
        if (((DriveRouteQuery)param1Object).c != null)
          return false; 
      } else {
        if (!list.equals(((DriveRouteQuery)param1Object).c))
          return false; 
        if (this.f != param1Object.isUseFerry())
          return false; 
        if (this.g != ((DriveRouteQuery)param1Object).g)
          return false; 
      } 
      String str1 = this.i;
      if (str1 == null) {
        if (((DriveRouteQuery)param1Object).i != null)
          return false; 
      } else if (!str1.equals(((DriveRouteQuery)param1Object).i)) {
        return false;
      } 
      return true;
    }
    
    public String getAvoidRoad() {
      return this.e;
    }
    
    public List<List<LatLonPoint>> getAvoidpolygons() {
      return this.d;
    }
    
    public String getAvoidpolygonsStr() {
      StringBuffer stringBuffer = new StringBuffer();
      List<List<LatLonPoint>> list = this.d;
      if (list == null || list.size() == 0)
        return null; 
      for (int i = 0; i < this.d.size(); i++) {
        list = (List<List<LatLonPoint>>)this.d.get(i);
        for (int j = 0; j < list.size(); j++) {
          LatLonPoint latLonPoint = (LatLonPoint)list.get(j);
          stringBuffer.append(latLonPoint.getLongitude());
          stringBuffer.append(",");
          stringBuffer.append(latLonPoint.getLatitude());
          if (j < list.size() - 1)
            stringBuffer.append(";"); 
        } 
        if (i < this.d.size() - 1)
          stringBuffer.append("|"); 
      } 
      return stringBuffer.toString();
    }
    
    public int getCarType() {
      return this.g;
    }
    
    public String getExclude() {
      return this.h;
    }
    
    public String getExtensions() {
      return this.i;
    }
    
    public RouteSearch.FromAndTo getFromAndTo() {
      return this.a;
    }
    
    public int getMode() {
      return this.b;
    }
    
    public List<LatLonPoint> getPassedByPoints() {
      return this.c;
    }
    
    public String getPassedPointStr() {
      StringBuffer stringBuffer = new StringBuffer();
      List<LatLonPoint> list = this.c;
      if (list == null || list.size() == 0)
        return null; 
      for (int i = 0; i < this.c.size(); i++) {
        LatLonPoint latLonPoint = this.c.get(i);
        stringBuffer.append(latLonPoint.getLongitude());
        stringBuffer.append(",");
        stringBuffer.append(latLonPoint.getLatitude());
        if (i < this.c.size() - 1)
          stringBuffer.append(";"); 
      } 
      return stringBuffer.toString();
    }
    
    public boolean hasAvoidRoad() {
      return !i.a(getAvoidRoad());
    }
    
    public boolean hasAvoidpolygons() {
      return !i.a(getAvoidpolygonsStr());
    }
    
    public boolean hasPassPoint() {
      return !i.a(getPassedPointStr());
    }
    
    public int hashCode() {
      int i;
      int j;
      int k;
      String str = this.e;
      int m = 0;
      if (str == null) {
        i = 0;
      } else {
        i = str.hashCode();
      } 
      List<List<LatLonPoint>> list1 = this.d;
      if (list1 == null) {
        j = 0;
      } else {
        j = list1.hashCode();
      } 
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        k = 0;
      } else {
        k = fromAndTo.hashCode();
      } 
      int n = this.b;
      List<LatLonPoint> list = this.c;
      if (list != null)
        m = list.hashCode(); 
      return (((((i + 31) * 31 + j) * 31 + k) * 31 + n) * 31 + m) * 31 + this.g;
    }
    
    public boolean isUseFerry() {
      return this.f;
    }
    
    public void setCarType(int param1Int) {
      this.g = param1Int;
    }
    
    public void setExclude(String param1String) {
      this.h = param1String;
    }
    
    public void setExtensions(String param1String) {
      this.i = param1String;
    }
    
    public void setUseFerry(boolean param1Boolean) {
      this.f = param1Boolean;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.Creator<DriveRouteQuery> {}
  
  public static class FromAndTo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() {
      
      };
    
    private LatLonPoint a;
    
    private LatLonPoint b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    private String f;
    
    private String g;
    
    private String h;
    
    public FromAndTo() {}
    
    public FromAndTo(Parcel param1Parcel) {
      this.a = (LatLonPoint)param1Parcel.readParcelable(LatLonPoint.class.getClassLoader());
      this.b = (LatLonPoint)param1Parcel.readParcelable(LatLonPoint.class.getClassLoader());
      this.c = param1Parcel.readString();
      this.d = param1Parcel.readString();
      this.e = param1Parcel.readString();
      this.f = param1Parcel.readString();
    }
    
    public FromAndTo(LatLonPoint param1LatLonPoint1, LatLonPoint param1LatLonPoint2) {
      this.a = param1LatLonPoint1;
      this.b = param1LatLonPoint2;
    }
    
    public FromAndTo clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "RouteSearch", "FromAndToclone");
      } 
      FromAndTo fromAndTo = new FromAndTo(this.a, this.b);
      fromAndTo.setStartPoiID(this.c);
      fromAndTo.setDestinationPoiID(this.d);
      fromAndTo.setOriginType(this.e);
      fromAndTo.setDestinationType(this.f);
      return fromAndTo;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      String str3 = this.d;
      if (str3 == null) {
        if (((FromAndTo)param1Object).d != null)
          return false; 
      } else if (!str3.equals(((FromAndTo)param1Object).d)) {
        return false;
      } 
      LatLonPoint latLonPoint2 = this.a;
      if (latLonPoint2 == null) {
        if (((FromAndTo)param1Object).a != null)
          return false; 
      } else if (!latLonPoint2.equals(((FromAndTo)param1Object).a)) {
        return false;
      } 
      String str2 = this.c;
      if (str2 == null) {
        if (((FromAndTo)param1Object).c != null)
          return false; 
      } else if (!str2.equals(((FromAndTo)param1Object).c)) {
        return false;
      } 
      LatLonPoint latLonPoint1 = this.b;
      if (latLonPoint1 == null) {
        if (((FromAndTo)param1Object).b != null)
          return false; 
      } else if (!latLonPoint1.equals(((FromAndTo)param1Object).b)) {
        return false;
      } 
      String str1 = this.e;
      if (str1 == null) {
        if (((FromAndTo)param1Object).e != null)
          return false; 
      } else if (!str1.equals(((FromAndTo)param1Object).e)) {
        return false;
      } 
      str1 = this.f;
      if (str1 == null) {
        if (((FromAndTo)param1Object).f != null)
          return false; 
      } else if (!str1.equals(((FromAndTo)param1Object).f)) {
        return false;
      } 
      return true;
    }
    
    public String getDestinationPoiID() {
      return this.d;
    }
    
    public String getDestinationType() {
      return this.f;
    }
    
    public LatLonPoint getFrom() {
      return this.a;
    }
    
    public String getOriginType() {
      return this.e;
    }
    
    public String getPlateNumber() {
      return this.h;
    }
    
    public String getPlateProvince() {
      return this.g;
    }
    
    public String getStartPoiID() {
      return this.c;
    }
    
    public LatLonPoint getTo() {
      return this.b;
    }
    
    public int hashCode() {
      int i;
      int j;
      int k;
      int m;
      int n;
      String str3 = this.d;
      int i1 = 0;
      if (str3 == null) {
        i = 0;
      } else {
        i = str3.hashCode();
      } 
      LatLonPoint latLonPoint2 = this.a;
      if (latLonPoint2 == null) {
        j = 0;
      } else {
        j = latLonPoint2.hashCode();
      } 
      String str2 = this.c;
      if (str2 == null) {
        k = 0;
      } else {
        k = str2.hashCode();
      } 
      LatLonPoint latLonPoint1 = this.b;
      if (latLonPoint1 == null) {
        m = 0;
      } else {
        m = latLonPoint1.hashCode();
      } 
      String str1 = this.e;
      if (str1 == null) {
        n = 0;
      } else {
        n = str1.hashCode();
      } 
      str1 = this.f;
      if (str1 != null)
        i1 = str1.hashCode(); 
      return (((((i + 31) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
    }
    
    public void setDestinationPoiID(String param1String) {
      this.d = param1String;
    }
    
    public void setDestinationType(String param1String) {
      this.f = param1String;
    }
    
    public void setOriginType(String param1String) {
      this.e = param1String;
    }
    
    public void setPlateNumber(String param1String) {
      this.h = param1String;
    }
    
    public void setPlateProvince(String param1String) {
      this.g = param1String;
    }
    
    public void setStartPoiID(String param1String) {
      this.c = param1String;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeParcelable((Parcelable)this.a, param1Int);
      param1Parcel.writeParcelable((Parcelable)this.b, param1Int);
      param1Parcel.writeString(this.c);
      param1Parcel.writeString(this.d);
      param1Parcel.writeString(this.e);
      param1Parcel.writeString(this.f);
    }
  }
  
  static final class null implements Parcelable.Creator<FromAndTo> {}
  
  public static interface OnRoutePlanSearchListener {
    void onDriveRoutePlanSearched(DriveRoutePlanResult param1DriveRoutePlanResult, int param1Int);
  }
  
  public static interface OnRouteSearchListener {
    void onBusRouteSearched(BusRouteResult param1BusRouteResult, int param1Int);
    
    void onDriveRouteSearched(DriveRouteResult param1DriveRouteResult, int param1Int);
    
    void onRideRouteSearched(RideRouteResult param1RideRouteResult, int param1Int);
    
    void onWalkRouteSearched(WalkRouteResult param1WalkRouteResult, int param1Int);
  }
  
  public static interface OnTruckRouteSearchListener {
    void onTruckRouteSearched(TruckRouteRestult param1TruckRouteRestult, int param1Int);
  }
  
  public static class RideRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() {
      
      };
    
    private RouteSearch.FromAndTo a;
    
    private int b;
    
    private String c = "base";
    
    public RideRouteQuery() {}
    
    public RideRouteQuery(Parcel param1Parcel) {
      this.a = (RouteSearch.FromAndTo)param1Parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readString();
    }
    
    public RideRouteQuery(RouteSearch.FromAndTo param1FromAndTo) {
      this.a = param1FromAndTo;
    }
    
    public RideRouteQuery(RouteSearch.FromAndTo param1FromAndTo, int param1Int) {
      this.a = param1FromAndTo;
      this.b = param1Int;
    }
    
    public RideRouteQuery clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "RouteSearch", "RideRouteQueryclone");
      } 
      RideRouteQuery rideRouteQuery = new RideRouteQuery(this.a);
      rideRouteQuery.setExtensions(this.c);
      return rideRouteQuery;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        if (((RideRouteQuery)param1Object).a != null)
          return false; 
      } else if (!fromAndTo.equals(((RideRouteQuery)param1Object).a)) {
        return false;
      } 
      return !(this.b != ((RideRouteQuery)param1Object).b);
    }
    
    public String getExtensions() {
      return this.c;
    }
    
    public RouteSearch.FromAndTo getFromAndTo() {
      return this.a;
    }
    
    public int getMode() {
      return this.b;
    }
    
    public int hashCode() {
      int i;
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        i = 0;
      } else {
        i = fromAndTo.hashCode();
      } 
      return (i + 31) * 31 + this.b;
    }
    
    public void setExtensions(String param1String) {
      this.c = param1String;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeParcelable(this.a, param1Int);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeString(this.c);
    }
  }
  
  static final class null implements Parcelable.Creator<RideRouteQuery> {}
  
  public static class TruckRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new Parcelable.Creator<TruckRouteQuery>() {
      
      };
    
    private RouteSearch.FromAndTo a;
    
    private int b = 2;
    
    private int c;
    
    private List<LatLonPoint> d;
    
    private float e;
    
    private float f;
    
    private float g;
    
    private float h;
    
    private float i;
    
    private String j = "base";
    
    protected TruckRouteQuery(Parcel param1Parcel) {
      this.a = (RouteSearch.FromAndTo)param1Parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readInt();
      this.d = param1Parcel.createTypedArrayList(LatLonPoint.CREATOR);
      this.e = param1Parcel.readFloat();
      this.f = param1Parcel.readFloat();
      this.g = param1Parcel.readFloat();
      this.h = param1Parcel.readFloat();
      this.i = param1Parcel.readFloat();
      this.j = param1Parcel.readString();
    }
    
    public TruckRouteQuery(RouteSearch.FromAndTo param1FromAndTo, int param1Int1, List<LatLonPoint> param1List, int param1Int2) {
      this.a = param1FromAndTo;
      this.c = param1Int1;
      this.d = param1List;
      this.b = param1Int2;
    }
    
    public TruckRouteQuery clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "RouteSearch", "TruckRouteQueryclone");
      } 
      TruckRouteQuery truckRouteQuery = new TruckRouteQuery(this.a, this.c, this.d, this.b);
      truckRouteQuery.setExtensions(this.j);
      return truckRouteQuery;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public String getExtensions() {
      return this.j;
    }
    
    public RouteSearch.FromAndTo getFromAndTo() {
      return this.a;
    }
    
    public int getMode() {
      return this.c;
    }
    
    public List<LatLonPoint> getPassedByPoints() {
      return this.d;
    }
    
    public String getPassedPointStr() {
      StringBuffer stringBuffer = new StringBuffer();
      List<LatLonPoint> list = this.d;
      if (list == null || list.size() == 0)
        return null; 
      for (int i = 0; i < this.d.size(); i++) {
        LatLonPoint latLonPoint = this.d.get(i);
        stringBuffer.append(latLonPoint.getLongitude());
        stringBuffer.append(",");
        stringBuffer.append(latLonPoint.getLatitude());
        if (i < this.d.size() - 1)
          stringBuffer.append(";"); 
      } 
      return stringBuffer.toString();
    }
    
    public float getTruckAxis() {
      return this.i;
    }
    
    public float getTruckHeight() {
      return this.e;
    }
    
    public float getTruckLoad() {
      return this.g;
    }
    
    public int getTruckSize() {
      return this.b;
    }
    
    public float getTruckWeight() {
      return this.h;
    }
    
    public float getTruckWidth() {
      return this.f;
    }
    
    public boolean hasPassPoint() {
      return !i.a(getPassedPointStr());
    }
    
    public void setExtensions(String param1String) {
      this.j = param1String;
    }
    
    public void setMode(int param1Int) {
      this.c = param1Int;
    }
    
    public void setTruckAxis(float param1Float) {
      this.i = param1Float;
    }
    
    public void setTruckHeight(float param1Float) {
      this.e = param1Float;
    }
    
    public void setTruckLoad(float param1Float) {
      this.g = param1Float;
    }
    
    public void setTruckSize(int param1Int) {
      this.b = param1Int;
    }
    
    public void setTruckWeight(float param1Float) {
      this.h = param1Float;
    }
    
    public void setTruckWidth(float param1Float) {
      this.f = param1Float;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeParcelable(this.a, param1Int);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeInt(this.c);
      param1Parcel.writeTypedList(this.d);
      param1Parcel.writeFloat(this.e);
      param1Parcel.writeFloat(this.f);
      param1Parcel.writeFloat(this.g);
      param1Parcel.writeFloat(this.h);
      param1Parcel.writeFloat(this.i);
      param1Parcel.writeString(this.j);
    }
  }
  
  static final class null implements Parcelable.Creator<TruckRouteQuery> {}
  
  public static class WalkRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() {
      
      };
    
    private RouteSearch.FromAndTo a;
    
    private int b;
    
    private String c = "base";
    
    public WalkRouteQuery() {}
    
    public WalkRouteQuery(Parcel param1Parcel) {
      this.a = (RouteSearch.FromAndTo)param1Parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readString();
    }
    
    public WalkRouteQuery(RouteSearch.FromAndTo param1FromAndTo) {
      this.a = param1FromAndTo;
    }
    
    public WalkRouteQuery(RouteSearch.FromAndTo param1FromAndTo, int param1Int) {
      this.a = param1FromAndTo;
      this.b = param1Int;
    }
    
    public WalkRouteQuery clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "RouteSearch", "WalkRouteQueryclone");
      } 
      WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.a);
      walkRouteQuery.setExtensions(this.c);
      return walkRouteQuery;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        if (((WalkRouteQuery)param1Object).a != null)
          return false; 
      } else if (!fromAndTo.equals(((WalkRouteQuery)param1Object).a)) {
        return false;
      } 
      String str = this.c;
      if (str == null) {
        if (((WalkRouteQuery)param1Object).c != null)
          return false; 
      } else if (!str.equals(((WalkRouteQuery)param1Object).c)) {
        return false;
      } 
      return !(this.b != ((WalkRouteQuery)param1Object).b);
    }
    
    public String getExtensions() {
      return this.c;
    }
    
    public RouteSearch.FromAndTo getFromAndTo() {
      return this.a;
    }
    
    public int getMode() {
      return this.b;
    }
    
    public int hashCode() {
      int i;
      RouteSearch.FromAndTo fromAndTo = this.a;
      if (fromAndTo == null) {
        i = 0;
      } else {
        i = fromAndTo.hashCode();
      } 
      return (i + 31) * 31 + this.b;
    }
    
    public void setExtensions(String param1String) {
      this.c = param1String;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeParcelable(this.a, param1Int);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeString(this.c);
    }
  }
  
  static final class null implements Parcelable.Creator<WalkRouteQuery> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\RouteSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */