package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

public class RoutePOISearchResult {
  private List<RoutePOIItem> a = new ArrayList<RoutePOIItem>();
  
  private RoutePOISearchQuery b;
  
  public RoutePOISearchResult(ArrayList<RoutePOIItem> paramArrayList, RoutePOISearchQuery paramRoutePOISearchQuery) {
    this.a = paramArrayList;
    this.b = paramRoutePOISearchQuery;
  }
  
  public RoutePOISearchQuery getQuery() {
    return this.b;
  }
  
  public List<RoutePOIItem> getRoutePois() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\routepoisearch\RoutePOISearchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */