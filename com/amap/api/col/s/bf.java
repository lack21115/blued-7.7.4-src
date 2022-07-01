package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

public final class bf implements IShareSearch {
  private static String b = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";
  
  private static String c = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";
  
  private static String d = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";
  
  private static String e = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";
  
  private static final String f = "";
  
  private Context a;
  
  private ShareSearch.OnShareSearchListener g;
  
  public bf(Context paramContext) {
    this.a = paramContext;
  }
  
  public final String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery paramShareBusRouteQuery) throws AMapException {
    if (paramShareBusRouteQuery != null)
      try {
        int i = paramShareBusRouteQuery.getBusMode();
        ShareSearch.ShareFromAndTo shareFromAndTo = paramShareBusRouteQuery.getShareFromAndTo();
        if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
          LatLonPoint latLonPoint1 = shareFromAndTo.getFrom();
          LatLonPoint latLonPoint2 = shareFromAndTo.getTo();
          String str2 = shareFromAndTo.getFromName();
          String str3 = shareFromAndTo.getToName();
          String str1 = String.format(b, new Object[] { 
                Double.valueOf(latLonPoint1.getLatitude()), Double.valueOf(latLonPoint1.getLongitude()), str2, Double.valueOf(latLonPoint2.getLatitude()), Double.valueOf(latLonPoint2.getLongitude()), str3, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), f, 
                f, f });
          return (new ak(this.a, str1)).n_();
        } 
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } catch (AMapException aMapException) {
        i.a((Throwable)aMapException, "ShareSearch", "searchBusRouteShareUrl");
        throw aMapException;
      }  
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public final void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery paramShareBusRouteQuery) {
    try {
      return;
    } finally {
      paramShareBusRouteQuery = null;
      paramShareBusRouteQuery.printStackTrace();
    } 
  }
  
  public final String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery paramShareDrivingRouteQuery) throws AMapException {
    if (paramShareDrivingRouteQuery != null)
      try {
        int i = paramShareDrivingRouteQuery.getDrivingMode();
        ShareSearch.ShareFromAndTo shareFromAndTo = paramShareDrivingRouteQuery.getShareFromAndTo();
        if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
          LatLonPoint latLonPoint1 = shareFromAndTo.getFrom();
          LatLonPoint latLonPoint2 = shareFromAndTo.getTo();
          String str2 = shareFromAndTo.getFromName();
          String str3 = shareFromAndTo.getToName();
          String str1 = String.format(b, new Object[] { 
                Double.valueOf(latLonPoint1.getLatitude()), Double.valueOf(latLonPoint1.getLongitude()), str2, Double.valueOf(latLonPoint2.getLatitude()), Double.valueOf(latLonPoint2.getLongitude()), str3, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), f, 
                f, f });
          return (new ak(this.a, str1)).n_();
        } 
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } catch (AMapException aMapException) {
        i.a((Throwable)aMapException, "ShareSearch", "searchDrivingRouteShareUrl");
        throw aMapException;
      }  
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public final void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery paramShareDrivingRouteQuery) {
    try {
      return;
    } finally {
      paramShareDrivingRouteQuery = null;
      paramShareDrivingRouteQuery.printStackTrace();
    } 
  }
  
  public final String searchLocationShareUrl(LatLonSharePoint paramLatLonSharePoint) throws AMapException {
    if (paramLatLonSharePoint != null)
      try {
        String str = String.format(c, new Object[] { Double.valueOf(paramLatLonSharePoint.getLatitude()), Double.valueOf(paramLatLonSharePoint.getLongitude()), paramLatLonSharePoint.getSharePointName() });
        return (new ak(this.a, str)).n_();
      } catch (AMapException aMapException) {
        i.a((Throwable)aMapException, "ShareSearch", "searchLocationShareUrl");
        throw aMapException;
      }  
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public final void searchLocationShareUrlAsyn(LatLonSharePoint paramLatLonSharePoint) {
    try {
      return;
    } finally {
      paramLatLonSharePoint = null;
      paramLatLonSharePoint.printStackTrace();
    } 
  }
  
  public final String searchNaviShareUrl(ShareSearch.ShareNaviQuery paramShareNaviQuery) throws AMapException {
    if (paramShareNaviQuery != null)
      try {
        ShareSearch.ShareFromAndTo shareFromAndTo = paramShareNaviQuery.getFromAndTo();
        if (shareFromAndTo.getTo() != null) {
          String str;
          LatLonPoint latLonPoint1 = shareFromAndTo.getFrom();
          LatLonPoint latLonPoint2 = shareFromAndTo.getTo();
          int i = paramShareNaviQuery.getNaviMode();
          if (shareFromAndTo.getFrom() == null) {
            str = String.format(d, new Object[] { null, null, Double.valueOf(latLonPoint2.getLatitude()), Double.valueOf(latLonPoint2.getLongitude()), Integer.valueOf(i) });
          } else {
            str = String.format(d, new Object[] { Double.valueOf(latLonPoint1.getLatitude()), Double.valueOf(latLonPoint1.getLongitude()), Double.valueOf(latLonPoint2.getLatitude()), Double.valueOf(latLonPoint2.getLongitude()), Integer.valueOf(i) });
          } 
          return (new ak(this.a, str)).n_();
        } 
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } catch (AMapException aMapException) {
        i.a((Throwable)aMapException, "ShareSearch", "searchNaviShareUrl");
        throw aMapException;
      }  
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public final void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery paramShareNaviQuery) {
    try {
      return;
    } finally {
      paramShareNaviQuery = null;
      paramShareNaviQuery.printStackTrace();
    } 
  }
  
  public final String searchPoiShareUrl(PoiItem paramPoiItem) throws AMapException {
    if (paramPoiItem != null)
      try {
        if (paramPoiItem.getLatLonPoint() != null) {
          LatLonPoint latLonPoint = paramPoiItem.getLatLonPoint();
          String str = String.format(e, new Object[] { paramPoiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), paramPoiItem.getTitle(), paramPoiItem.getSnippet() });
          return (new ak(this.a, str)).n_();
        } 
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } catch (AMapException aMapException) {
        i.a((Throwable)aMapException, "ShareSearch", "searchPoiShareUrl");
        throw aMapException;
      }  
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public final void searchPoiShareUrlAsyn(PoiItem paramPoiItem) {
    try {
      return;
    } finally {
      paramPoiItem = null;
      paramPoiItem.printStackTrace();
    } 
  }
  
  public final String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery paramShareWalkRouteQuery) throws AMapException {
    if (paramShareWalkRouteQuery != null)
      try {
        int i = paramShareWalkRouteQuery.getWalkMode();
        ShareSearch.ShareFromAndTo shareFromAndTo = paramShareWalkRouteQuery.getShareFromAndTo();
        if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
          LatLonPoint latLonPoint1 = shareFromAndTo.getFrom();
          LatLonPoint latLonPoint2 = shareFromAndTo.getTo();
          String str2 = shareFromAndTo.getFromName();
          String str3 = shareFromAndTo.getToName();
          String str1 = String.format(b, new Object[] { 
                Double.valueOf(latLonPoint1.getLatitude()), Double.valueOf(latLonPoint1.getLongitude()), str2, Double.valueOf(latLonPoint2.getLatitude()), Double.valueOf(latLonPoint2.getLongitude()), str3, Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0), f, 
                f, f });
          return (new ak(this.a, str1)).n_();
        } 
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } catch (AMapException aMapException) {
        i.a((Throwable)aMapException, "ShareSearch", "searchWalkRouteShareUrl");
        throw aMapException;
      }  
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public final void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery paramShareWalkRouteQuery) {
    try {
      return;
    } finally {
      paramShareWalkRouteQuery = null;
      paramShareWalkRouteQuery.printStackTrace();
    } 
  }
  
  public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener paramOnShareSearchListener) {
    this.g = paramOnShareSearchListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */