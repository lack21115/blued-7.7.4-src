package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import java.util.List;

public interface IGeocodeSearch {
  RegeocodeAddress getFromLocation(RegeocodeQuery paramRegeocodeQuery) throws AMapException;
  
  void getFromLocationAsyn(RegeocodeQuery paramRegeocodeQuery);
  
  List<GeocodeAddress> getFromLocationName(GeocodeQuery paramGeocodeQuery) throws AMapException;
  
  void getFromLocationNameAsyn(GeocodeQuery paramGeocodeQuery);
  
  void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener paramOnGeocodeSearchListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IGeocodeSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */