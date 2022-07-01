package com.amap.api.services.interfaces;

import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;

public interface IBusLineSearch {
  BusLineQuery getQuery();
  
  BusLineResult searchBusLine() throws AMapException;
  
  void searchBusLineAsyn();
  
  void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener paramOnBusLineSearchListener);
  
  void setQuery(BusLineQuery paramBusLineQuery);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IBusLineSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */