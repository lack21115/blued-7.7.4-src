package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

public interface IRouteSearch {
  BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery paramBusRouteQuery) throws AMapException;
  
  void calculateBusRouteAsyn(RouteSearch.BusRouteQuery paramBusRouteQuery);
  
  DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery paramDrivePlanQuery) throws AMapException;
  
  void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery paramDrivePlanQuery);
  
  DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery paramDriveRouteQuery) throws AMapException;
  
  void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery paramDriveRouteQuery);
  
  RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery paramRideRouteQuery) throws AMapException;
  
  void calculateRideRouteAsyn(RouteSearch.RideRouteQuery paramRideRouteQuery);
  
  TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery paramTruckRouteQuery) throws AMapException;
  
  void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery paramTruckRouteQuery);
  
  WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery paramWalkRouteQuery) throws AMapException;
  
  void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery paramWalkRouteQuery);
  
  void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener paramOnRoutePlanSearchListener);
  
  void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener paramOnTruckRouteSearchListener);
  
  void setRouteSearchListener(RouteSearch.OnRouteSearchListener paramOnRouteSearchListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IRouteSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */