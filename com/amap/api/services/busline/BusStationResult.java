package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

public final class BusStationResult {
  private int a;
  
  private ArrayList<BusStationItem> b = new ArrayList<BusStationItem>();
  
  private BusStationQuery c;
  
  private List<String> d = new ArrayList<String>();
  
  private List<SuggestionCity> e = new ArrayList<SuggestionCity>();
  
  private BusStationResult(BusStationQuery paramBusStationQuery, int paramInt, List<SuggestionCity> paramList, List<String> paramList1, ArrayList<BusStationItem> paramArrayList) {
    this.c = paramBusStationQuery;
    int i = this.c.getPageSize();
    paramInt = (paramInt + i - 1) / i;
    i = 30;
    if (paramInt > 30)
      paramInt = i; 
    this.a = paramInt;
    this.e = paramList;
    this.d = paramList1;
    this.b = paramArrayList;
  }
  
  public static BusStationResult createPagedResult(BusStationQuery paramBusStationQuery, int paramInt, List<SuggestionCity> paramList, List<String> paramList1, ArrayList<BusStationItem> paramArrayList) {
    return new BusStationResult(paramBusStationQuery, paramInt, paramList, paramList1, paramArrayList);
  }
  
  public final List<BusStationItem> getBusStations() {
    return this.b;
  }
  
  public final int getPageCount() {
    return this.a;
  }
  
  public final BusStationQuery getQuery() {
    return this.c;
  }
  
  public final List<SuggestionCity> getSearchSuggestionCities() {
    return this.e;
  }
  
  public final List<String> getSearchSuggestionKeywords() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\busline\BusStationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */