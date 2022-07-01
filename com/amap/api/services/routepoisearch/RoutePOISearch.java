package com.amap.api.services.routepoisearch;

import android.content.Context;
import com.amap.api.col.s.bd;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;

public class RoutePOISearch {
  public static final int DrivingAvoidCongestion = 4;
  
  public static final int DrivingDefault = 0;
  
  public static final int DrivingNoExpressways = 3;
  
  public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
  
  public static final int DrivingNoHighWay = 6;
  
  public static final int DrivingNoHighWaySaveMoney = 7;
  
  public static final int DrivingSaveMoney = 1;
  
  public static final int DrivingSaveMoneyAvoidCongestion = 8;
  
  public static final int DrivingShortDistance = 2;
  
  private IRoutePOISearch a;
  
  public RoutePOISearch(Context paramContext, RoutePOISearchQuery paramRoutePOISearchQuery) {
    if (this.a == null)
      try {
        this.a = (IRoutePOISearch)new bd(paramContext, paramRoutePOISearchQuery);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public RoutePOISearchResult searchRoutePOI() throws AMapException {
    IRoutePOISearch iRoutePOISearch = this.a;
    return (iRoutePOISearch != null) ? iRoutePOISearch.searchRoutePOI() : null;
  }
  
  public void searchRoutePOIAsyn() {
    IRoutePOISearch iRoutePOISearch = this.a;
    if (iRoutePOISearch != null)
      iRoutePOISearch.searchRoutePOIAsyn(); 
  }
  
  public void setPoiSearchListener(OnRoutePOISearchListener paramOnRoutePOISearchListener) {
    IRoutePOISearch iRoutePOISearch = this.a;
    if (iRoutePOISearch != null)
      iRoutePOISearch.setRoutePOISearchListener(paramOnRoutePOISearchListener); 
  }
  
  public void setQuery(RoutePOISearchQuery paramRoutePOISearchQuery) {
    IRoutePOISearch iRoutePOISearch = this.a;
    if (iRoutePOISearch != null)
      iRoutePOISearch.setQuery(paramRoutePOISearchQuery); 
  }
  
  public static interface OnRoutePOISearchListener {
    void onRoutePoiSearched(RoutePOISearchResult param1RoutePOISearchResult, int param1Int);
  }
  
  public enum RoutePOISearchType {
    TypeATM, TypeFillingStation, TypeGasStation, TypeMaintenanceStation, TypeServiceArea, TypeToilet;
    
    static {
      TypeFillingStation = new RoutePOISearchType("TypeFillingStation", 4);
      TypeServiceArea = new RoutePOISearchType("TypeServiceArea", 5);
      a = new RoutePOISearchType[] { TypeGasStation, TypeMaintenanceStation, TypeATM, TypeToilet, TypeFillingStation, TypeServiceArea };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\routepoisearch\RoutePOISearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */