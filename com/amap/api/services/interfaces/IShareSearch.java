package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.share.ShareSearch;

public interface IShareSearch {
  String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery paramShareBusRouteQuery) throws AMapException;
  
  void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery paramShareBusRouteQuery);
  
  String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery paramShareDrivingRouteQuery) throws AMapException;
  
  void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery paramShareDrivingRouteQuery);
  
  String searchLocationShareUrl(LatLonSharePoint paramLatLonSharePoint) throws AMapException;
  
  void searchLocationShareUrlAsyn(LatLonSharePoint paramLatLonSharePoint);
  
  String searchNaviShareUrl(ShareSearch.ShareNaviQuery paramShareNaviQuery) throws AMapException;
  
  void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery paramShareNaviQuery);
  
  String searchPoiShareUrl(PoiItem paramPoiItem) throws AMapException;
  
  void searchPoiShareUrlAsyn(PoiItem paramPoiItem);
  
  String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery paramShareWalkRouteQuery) throws AMapException;
  
  void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery paramShareWalkRouteQuery);
  
  void setOnShareSearchListener(ShareSearch.OnShareSearchListener paramOnShareSearchListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IShareSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */