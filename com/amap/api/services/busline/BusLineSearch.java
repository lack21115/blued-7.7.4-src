package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.au;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;

public class BusLineSearch {
  public static final String EXTENSIONS_ALL = "all";
  
  public static final String EXTENSIONS_BASE = "base";
  
  private IBusLineSearch a = null;
  
  public BusLineSearch(Context paramContext, BusLineQuery paramBusLineQuery) {
    if (this.a == null)
      try {
        this.a = (IBusLineSearch)new au(paramContext, paramBusLineQuery);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public BusLineQuery getQuery() {
    IBusLineSearch iBusLineSearch = this.a;
    return (iBusLineSearch != null) ? iBusLineSearch.getQuery() : null;
  }
  
  public BusLineResult searchBusLine() throws AMapException {
    IBusLineSearch iBusLineSearch = this.a;
    return (iBusLineSearch != null) ? iBusLineSearch.searchBusLine() : null;
  }
  
  public void searchBusLineAsyn() {
    IBusLineSearch iBusLineSearch = this.a;
    if (iBusLineSearch != null)
      iBusLineSearch.searchBusLineAsyn(); 
  }
  
  public void setOnBusLineSearchListener(OnBusLineSearchListener paramOnBusLineSearchListener) {
    IBusLineSearch iBusLineSearch = this.a;
    if (iBusLineSearch != null)
      iBusLineSearch.setOnBusLineSearchListener(paramOnBusLineSearchListener); 
  }
  
  public void setQuery(BusLineQuery paramBusLineQuery) {
    IBusLineSearch iBusLineSearch = this.a;
    if (iBusLineSearch != null)
      iBusLineSearch.setQuery(paramBusLineQuery); 
  }
  
  public static interface OnBusLineSearchListener {
    void onBusLineSearched(BusLineResult param1BusLineResult, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\busline\BusLineSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */