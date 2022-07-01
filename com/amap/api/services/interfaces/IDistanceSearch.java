package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

public interface IDistanceSearch {
  DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery paramDistanceQuery) throws AMapException;
  
  void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery paramDistanceQuery);
  
  void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener paramOnDistanceSearchListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IDistanceSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */