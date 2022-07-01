package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.av;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

public class BusStationSearch {
  private IBusStationSearch a;
  
  public BusStationSearch(Context paramContext, BusStationQuery paramBusStationQuery) {
    if (this.a == null)
      try {
        this.a = (IBusStationSearch)new av(paramContext, paramBusStationQuery);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public BusStationQuery getQuery() {
    IBusStationSearch iBusStationSearch = this.a;
    return (iBusStationSearch != null) ? iBusStationSearch.getQuery() : null;
  }
  
  public BusStationResult searchBusStation() throws AMapException {
    IBusStationSearch iBusStationSearch = this.a;
    return (iBusStationSearch != null) ? iBusStationSearch.searchBusStation() : null;
  }
  
  public void searchBusStationAsyn() {
    IBusStationSearch iBusStationSearch = this.a;
    if (iBusStationSearch != null)
      iBusStationSearch.searchBusStationAsyn(); 
  }
  
  public void setOnBusStationSearchListener(OnBusStationSearchListener paramOnBusStationSearchListener) {
    IBusStationSearch iBusStationSearch = this.a;
    if (iBusStationSearch != null)
      iBusStationSearch.setOnBusStationSearchListener(paramOnBusStationSearchListener); 
  }
  
  public void setQuery(BusStationQuery paramBusStationQuery) {
    IBusStationSearch iBusStationSearch = this.a;
    if (iBusStationSearch != null)
      iBusStationSearch.setQuery(paramBusStationQuery); 
  }
  
  public static interface OnBusStationSearchListener {
    void onBusStationSearched(BusStationResult param1BusStationResult, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\busline\BusStationSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */