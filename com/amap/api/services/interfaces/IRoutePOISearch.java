package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

public interface IRoutePOISearch {
  RoutePOISearchQuery getQuery();
  
  RoutePOISearchResult searchRoutePOI() throws AMapException;
  
  void searchRoutePOIAsyn();
  
  void setQuery(RoutePOISearchQuery paramRoutePOISearchQuery);
  
  void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener paramOnRoutePOISearchListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IRoutePOISearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */