package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.s.bf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

public class ShareSearch {
  public static final int BusComfortable = 4;
  
  public static final int BusDefault = 0;
  
  public static final int BusLeaseChange = 2;
  
  public static final int BusLeaseWalk = 3;
  
  public static final int BusNoSubway = 5;
  
  public static final int BusSaveMoney = 1;
  
  public static final int DrivingAvoidCongestion = 4;
  
  public static final int DrivingDefault = 0;
  
  public static final int DrivingNoHighWay = 3;
  
  public static final int DrivingNoHighWayAvoidCongestion = 6;
  
  public static final int DrivingNoHighWaySaveMoney = 5;
  
  public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
  
  public static final int DrivingSaveMoney = 1;
  
  public static final int DrivingSaveMoneyAvoidCongestion = 7;
  
  public static final int DrivingShortDistance = 2;
  
  public static final int NaviAvoidCongestion = 4;
  
  public static final int NaviDefault = 0;
  
  public static final int NaviNoHighWay = 3;
  
  public static final int NaviNoHighWayAvoidCongestion = 6;
  
  public static final int NaviNoHighWaySaveMoney = 5;
  
  public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
  
  public static final int NaviSaveMoney = 1;
  
  public static final int NaviSaveMoneyAvoidCongestion = 7;
  
  public static final int NaviShortDistance = 2;
  
  private IShareSearch a;
  
  public ShareSearch(Context paramContext) {
    if (this.a == null)
      try {
        this.a = (IShareSearch)new bf(paramContext);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public String searchBusRouteShareUrl(ShareBusRouteQuery paramShareBusRouteQuery) throws AMapException {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchBusRouteShareUrl(paramShareBusRouteQuery); 
    return null;
  }
  
  public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery paramShareBusRouteQuery) {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchBusRouteShareUrlAsyn(paramShareBusRouteQuery); 
  }
  
  public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery paramShareDrivingRouteQuery) throws AMapException {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchDrivingRouteShareUrl(paramShareDrivingRouteQuery); 
    return null;
  }
  
  public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery paramShareDrivingRouteQuery) {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchDrivingRouteShareUrlAsyn(paramShareDrivingRouteQuery); 
  }
  
  public String searchLocationShareUrl(LatLonSharePoint paramLatLonSharePoint) throws AMapException {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchLocationShareUrl(paramLatLonSharePoint); 
    return null;
  }
  
  public void searchLocationShareUrlAsyn(LatLonSharePoint paramLatLonSharePoint) {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchLocationShareUrlAsyn(paramLatLonSharePoint); 
  }
  
  public String searchNaviShareUrl(ShareNaviQuery paramShareNaviQuery) throws AMapException {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchNaviShareUrl(paramShareNaviQuery); 
    return null;
  }
  
  public void searchNaviShareUrlAsyn(ShareNaviQuery paramShareNaviQuery) {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchNaviShareUrlAsyn(paramShareNaviQuery); 
  }
  
  public String searchPoiShareUrl(PoiItem paramPoiItem) throws AMapException {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchPoiShareUrl(paramPoiItem); 
    return null;
  }
  
  public void searchPoiShareUrlAsyn(PoiItem paramPoiItem) {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchPoiShareUrlAsyn(paramPoiItem); 
  }
  
  public String searchWalkRouteShareUrl(ShareWalkRouteQuery paramShareWalkRouteQuery) throws AMapException {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchWalkRouteShareUrl(paramShareWalkRouteQuery); 
    return null;
  }
  
  public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery paramShareWalkRouteQuery) {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.searchWalkRouteShareUrlAsyn(paramShareWalkRouteQuery); 
  }
  
  public void setOnShareSearchListener(OnShareSearchListener paramOnShareSearchListener) {
    IShareSearch iShareSearch = this.a;
    if (iShareSearch != null)
      iShareSearch.setOnShareSearchListener(paramOnShareSearchListener); 
  }
  
  public static interface OnShareSearchListener {
    void onBusRouteShareUrlSearched(String param1String, int param1Int);
    
    void onDrivingRouteShareUrlSearched(String param1String, int param1Int);
    
    void onLocationShareUrlSearched(String param1String, int param1Int);
    
    void onNaviShareUrlSearched(String param1String, int param1Int);
    
    void onPoiShareUrlSearched(String param1String, int param1Int);
    
    void onWalkRouteShareUrlSearched(String param1String, int param1Int);
  }
  
  public static class ShareBusRouteQuery {
    private ShareSearch.ShareFromAndTo a;
    
    private int b;
    
    public ShareBusRouteQuery(ShareSearch.ShareFromAndTo param1ShareFromAndTo, int param1Int) {
      this.a = param1ShareFromAndTo;
      this.b = param1Int;
    }
    
    public int getBusMode() {
      return this.b;
    }
    
    public ShareSearch.ShareFromAndTo getShareFromAndTo() {
      return this.a;
    }
  }
  
  public static class ShareDrivingRouteQuery {
    private ShareSearch.ShareFromAndTo a;
    
    private int b;
    
    public ShareDrivingRouteQuery(ShareSearch.ShareFromAndTo param1ShareFromAndTo, int param1Int) {
      this.a = param1ShareFromAndTo;
      this.b = param1Int;
    }
    
    public int getDrivingMode() {
      return this.b;
    }
    
    public ShareSearch.ShareFromAndTo getShareFromAndTo() {
      return this.a;
    }
  }
  
  public static class ShareFromAndTo {
    private LatLonPoint a;
    
    private LatLonPoint b;
    
    private String c = "起点";
    
    private String d = "终点";
    
    public ShareFromAndTo(LatLonPoint param1LatLonPoint1, LatLonPoint param1LatLonPoint2) {
      this.a = param1LatLonPoint1;
      this.b = param1LatLonPoint2;
    }
    
    public LatLonPoint getFrom() {
      return this.a;
    }
    
    public String getFromName() {
      return this.c;
    }
    
    public LatLonPoint getTo() {
      return this.b;
    }
    
    public String getToName() {
      return this.d;
    }
    
    public void setFromName(String param1String) {
      this.c = param1String;
    }
    
    public void setToName(String param1String) {
      this.d = param1String;
    }
  }
  
  public static class ShareNaviQuery {
    private ShareSearch.ShareFromAndTo a;
    
    private int b;
    
    public ShareNaviQuery(ShareSearch.ShareFromAndTo param1ShareFromAndTo, int param1Int) {
      this.a = param1ShareFromAndTo;
      this.b = param1Int;
    }
    
    public ShareSearch.ShareFromAndTo getFromAndTo() {
      return this.a;
    }
    
    public int getNaviMode() {
      return this.b;
    }
  }
  
  public static class ShareWalkRouteQuery {
    private ShareSearch.ShareFromAndTo a;
    
    private int b;
    
    public ShareWalkRouteQuery(ShareSearch.ShareFromAndTo param1ShareFromAndTo, int param1Int) {
      this.a = param1ShareFromAndTo;
      this.b = param1Int;
    }
    
    public ShareSearch.ShareFromAndTo getShareFromAndTo() {
      return this.a;
    }
    
    public int getWalkMode() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\share\ShareSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */