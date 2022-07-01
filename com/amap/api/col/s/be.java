package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

public final class be implements IRouteSearch {
  private RouteSearch.OnRouteSearchListener a;
  
  private RouteSearch.OnTruckRouteSearchListener b;
  
  private RouteSearch.OnRoutePlanSearchListener c;
  
  private Context d;
  
  private Handler e;
  
  public be(Context paramContext) {
    this.d = paramContext.getApplicationContext();
    this.e = s.a();
  }
  
  private static boolean a(RouteSearch.FromAndTo paramFromAndTo) {
    return (paramFromAndTo == null) ? false : ((paramFromAndTo.getFrom() != null && paramFromAndTo.getTo() != null));
  }
  
  public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery paramBusRouteQuery) throws AMapException {
    BusRouteResult busRouteResult;
    try {
      q.a(this.d);
      if (paramBusRouteQuery != null) {
        if (a(paramBusRouteQuery.getFromAndTo())) {
          paramBusRouteQuery = paramBusRouteQuery.clone();
          busRouteResult = (new c(this.d, paramBusRouteQuery)).n_();
          if (busRouteResult != null) {
            busRouteResult.setBusQuery(paramBusRouteQuery);
            return busRouteResult;
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } else {
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "RouteSearch", "calculateBusRoute");
      throw aMapException;
    } 
    return busRouteResult;
  }
  
  public final void calculateBusRouteAsyn(RouteSearch.BusRouteQuery paramBusRouteQuery) {
    try {
      return;
    } finally {
      paramBusRouteQuery = null;
      i.a((Throwable)paramBusRouteQuery, "RouteSearch", "calculateBusRouteAsyn");
    } 
  }
  
  public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery paramDrivePlanQuery) throws AMapException {
    DriveRoutePlanResult driveRoutePlanResult;
    try {
      q.a(this.d);
      if (paramDrivePlanQuery != null) {
        if (a(paramDrivePlanQuery.getFromAndTo())) {
          RouteSearch.DrivePlanQuery drivePlanQuery = paramDrivePlanQuery.clone();
          driveRoutePlanResult = (new l(this.d, drivePlanQuery)).n_();
          if (driveRoutePlanResult != null) {
            driveRoutePlanResult.setDrivePlanQuery(paramDrivePlanQuery);
            return driveRoutePlanResult;
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } else {
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "RouteSearch", "calculateDrivePlan");
      throw aMapException;
    } 
    return driveRoutePlanResult;
  }
  
  public final void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery paramDrivePlanQuery) {
    try {
      return;
    } finally {
      paramDrivePlanQuery = null;
      i.a((Throwable)paramDrivePlanQuery, "RouteSearch", "calculateTruckRouteAsyn");
    } 
  }
  
  public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery paramDriveRouteQuery) throws AMapException {
    DriveRouteResult driveRouteResult;
    try {
      q.a(this.d);
      if (paramDriveRouteQuery != null) {
        if (a(paramDriveRouteQuery.getFromAndTo())) {
          ag.a().a(paramDriveRouteQuery.getPassedByPoints());
          ag.a().b(paramDriveRouteQuery.getAvoidpolygons());
          paramDriveRouteQuery = paramDriveRouteQuery.clone();
          driveRouteResult = (new m(this.d, paramDriveRouteQuery)).n_();
          if (driveRouteResult != null) {
            driveRouteResult.setDriveQuery(paramDriveRouteQuery);
            return driveRouteResult;
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } else {
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "RouteSearch", "calculateDriveRoute");
      throw aMapException;
    } 
    return driveRouteResult;
  }
  
  public final void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery paramDriveRouteQuery) {
    try {
      return;
    } finally {
      paramDriveRouteQuery = null;
      i.a((Throwable)paramDriveRouteQuery, "RouteSearch", "calculateDriveRouteAsyn");
    } 
  }
  
  public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery paramRideRouteQuery) throws AMapException {
    RideRouteResult rideRouteResult;
    try {
      q.a(this.d);
      if (paramRideRouteQuery != null) {
        if (a(paramRideRouteQuery.getFromAndTo())) {
          ag.a().a(paramRideRouteQuery.getFromAndTo());
          paramRideRouteQuery = paramRideRouteQuery.clone();
          rideRouteResult = (new ai(this.d, paramRideRouteQuery)).n_();
          if (rideRouteResult != null) {
            rideRouteResult.setRideQuery(paramRideRouteQuery);
            return rideRouteResult;
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } else {
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "RouteSearch", "calculaterideRoute");
      throw aMapException;
    } 
    return rideRouteResult;
  }
  
  public final void calculateRideRouteAsyn(RouteSearch.RideRouteQuery paramRideRouteQuery) {
    try {
      return;
    } finally {
      paramRideRouteQuery = null;
      i.a((Throwable)paramRideRouteQuery, "RouteSearch", "calculateRideRouteAsyn");
    } 
  }
  
  public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery paramTruckRouteQuery) throws AMapException {
    TruckRouteRestult truckRouteRestult;
    try {
      q.a(this.d);
      if (paramTruckRouteQuery != null) {
        if (a(paramTruckRouteQuery.getFromAndTo())) {
          ag.a().a(paramTruckRouteQuery.getFromAndTo(), paramTruckRouteQuery.getPassedByPoints());
          ag.a().a(paramTruckRouteQuery.getPassedByPoints());
          paramTruckRouteQuery = paramTruckRouteQuery.clone();
          truckRouteRestult = (new ao(this.d, paramTruckRouteQuery)).n_();
          if (truckRouteRestult != null) {
            truckRouteRestult.setTruckQuery(paramTruckRouteQuery);
            return truckRouteRestult;
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } else {
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "RouteSearch", "calculateDriveRoute");
      throw aMapException;
    } 
    return truckRouteRestult;
  }
  
  public final void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery paramTruckRouteQuery) {
    try {
      return;
    } finally {
      paramTruckRouteQuery = null;
      i.a((Throwable)paramTruckRouteQuery, "RouteSearch", "calculateTruckRouteAsyn");
    } 
  }
  
  public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery paramWalkRouteQuery) throws AMapException {
    WalkRouteResult walkRouteResult;
    try {
      q.a(this.d);
      if (paramWalkRouteQuery != null) {
        if (a(paramWalkRouteQuery.getFromAndTo())) {
          ag.a().b(paramWalkRouteQuery.getFromAndTo());
          paramWalkRouteQuery = paramWalkRouteQuery.clone();
          walkRouteResult = (new ap(this.d, paramWalkRouteQuery)).n_();
          if (walkRouteResult != null) {
            walkRouteResult.setWalkQuery(paramWalkRouteQuery);
            return walkRouteResult;
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } else {
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "RouteSearch", "calculateWalkRoute");
      throw aMapException;
    } 
    return walkRouteResult;
  }
  
  public final void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery paramWalkRouteQuery) {
    try {
      return;
    } finally {
      paramWalkRouteQuery = null;
      i.a((Throwable)paramWalkRouteQuery, "RouteSearch", "calculateWalkRouteAsyn");
    } 
  }
  
  public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener paramOnRoutePlanSearchListener) {
    this.c = paramOnRoutePlanSearchListener;
  }
  
  public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener paramOnTruckRouteSearchListener) {
    this.b = paramOnTruckRouteSearchListener;
  }
  
  public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener paramOnRouteSearchListener) {
    this.a = paramOnRouteSearchListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */