package com.amap.api.services.routepoisearch;

import com.amap.api.col.s.i;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

public class RoutePOISearchQuery implements Cloneable {
  private LatLonPoint a;
  
  private LatLonPoint b;
  
  private int c;
  
  private RoutePOISearch.RoutePOISearchType d;
  
  private int e = 250;
  
  private List<LatLonPoint> f;
  
  public RoutePOISearchQuery(LatLonPoint paramLatLonPoint1, LatLonPoint paramLatLonPoint2, int paramInt1, RoutePOISearch.RoutePOISearchType paramRoutePOISearchType, int paramInt2) {
    this.a = paramLatLonPoint1;
    this.b = paramLatLonPoint2;
    this.c = paramInt1;
    this.d = paramRoutePOISearchType;
    this.e = paramInt2;
  }
  
  public RoutePOISearchQuery(List<LatLonPoint> paramList, RoutePOISearch.RoutePOISearchType paramRoutePOISearchType, int paramInt) {
    this.f = paramList;
    this.d = paramRoutePOISearchType;
    this.e = paramInt;
  }
  
  public RoutePOISearchQuery clone() {
    try {
      super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      i.a(cloneNotSupportedException, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
    } 
    List<LatLonPoint> list = this.f;
    return (list != null && list.size() > 0) ? new RoutePOISearchQuery(this.f, this.d, this.e) : new RoutePOISearchQuery(this.a, this.b, this.c, this.d, this.e);
  }
  
  public LatLonPoint getFrom() {
    return this.a;
  }
  
  public int getMode() {
    return this.c;
  }
  
  public List<LatLonPoint> getPolylines() {
    return this.f;
  }
  
  public int getRange() {
    return this.e;
  }
  
  public RoutePOISearch.RoutePOISearchType getSearchType() {
    return this.d;
  }
  
  public LatLonPoint getTo() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\routepoisearch\RoutePOISearchQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */