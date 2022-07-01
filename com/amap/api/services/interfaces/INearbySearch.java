package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;

public interface INearbySearch {
  void addNearbyListener(NearbySearch.NearbyListener paramNearbyListener);
  
  void clearUserInfoAsyn();
  
  void destroy();
  
  void removeNearbyListener(NearbySearch.NearbyListener paramNearbyListener);
  
  NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery paramNearbyQuery) throws AMapException;
  
  void searchNearbyInfoAsyn(NearbySearch.NearbyQuery paramNearbyQuery);
  
  void setUserID(String paramString);
  
  void startUploadNearbyInfoAuto(UploadInfoCallback paramUploadInfoCallback, int paramInt);
  
  void stopUploadNearbyInfoAuto();
  
  void uploadNearbyInfoAsyn(UploadInfo paramUploadInfo);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\INearbySearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */