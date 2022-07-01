package com.amap.api.services.interfaces;

import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;

public interface IBusStationSearch {
  BusStationQuery getQuery();
  
  BusStationResult searchBusStation() throws AMapException;
  
  void searchBusStationAsyn();
  
  void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener paramOnBusStationSearchListener);
  
  void setQuery(BusStationQuery paramBusStationQuery);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IBusStationSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */