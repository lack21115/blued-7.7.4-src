package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;

public interface IPoiSearch {
  PoiSearch.SearchBound getBound();
  
  String getLanguage();
  
  PoiSearch.Query getQuery();
  
  PoiResult searchPOI() throws AMapException;
  
  void searchPOIAsyn();
  
  PoiItem searchPOIId(String paramString) throws AMapException;
  
  void searchPOIIdAsyn(String paramString);
  
  void setBound(PoiSearch.SearchBound paramSearchBound);
  
  void setLanguage(String paramString);
  
  void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener paramOnPoiSearchListener);
  
  void setQuery(PoiSearch.Query paramQuery);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IPoiSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */