package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

public final class BusLineResult {
  private int a;
  
  private ArrayList<BusLineItem> b = new ArrayList<BusLineItem>();
  
  private BusLineQuery c;
  
  private List<String> d = new ArrayList<String>();
  
  private List<SuggestionCity> e = new ArrayList<SuggestionCity>();
  
  private BusLineResult(BusLineQuery paramBusLineQuery, int paramInt, List<SuggestionCity> paramList, List<String> paramList1, ArrayList<BusLineItem> paramArrayList) {
    this.c = paramBusLineQuery;
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
  
  public static BusLineResult createPagedResult(BusLineQuery paramBusLineQuery, int paramInt, List<SuggestionCity> paramList, List<String> paramList1, ArrayList<BusLineItem> paramArrayList) {
    return new BusLineResult(paramBusLineQuery, paramInt, paramList, paramList1, paramArrayList);
  }
  
  public final List<BusLineItem> getBusLines() {
    return this.b;
  }
  
  public final int getPageCount() {
    return this.a;
  }
  
  public final BusLineQuery getQuery() {
    return this.c;
  }
  
  public final List<SuggestionCity> getSearchSuggestionCities() {
    return this.e;
  }
  
  public final List<String> getSearchSuggestionKeywords() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\busline\BusLineResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */