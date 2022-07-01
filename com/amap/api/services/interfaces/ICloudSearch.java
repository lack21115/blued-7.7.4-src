package com.amap.api.services.interfaces;

import com.amap.api.services.cloud.CloudSearch;

public interface ICloudSearch {
  void searchCloudAsyn(CloudSearch.Query paramQuery);
  
  void searchCloudDetailAsyn(String paramString1, String paramString2);
  
  void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener paramOnCloudSearchListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\ICloudSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */