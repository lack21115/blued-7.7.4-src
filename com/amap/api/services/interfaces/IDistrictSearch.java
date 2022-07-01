package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;

public interface IDistrictSearch {
  DistrictSearchQuery getQuery();
  
  DistrictResult searchDistrict() throws AMapException;
  
  void searchDistrictAnsy();
  
  void searchDistrictAsyn();
  
  void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener paramOnDistrictSearchListener);
  
  void setQuery(DistrictSearchQuery paramDistrictSearchQuery);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IDistrictSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */