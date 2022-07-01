package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

public final class av implements IBusStationSearch {
  private Context a;
  
  private BusStationSearch.OnBusStationSearchListener b;
  
  private BusStationQuery c;
  
  private BusStationQuery d;
  
  private ArrayList<BusStationResult> e = new ArrayList<BusStationResult>();
  
  private int f;
  
  private Handler g;
  
  public av(Context paramContext, BusStationQuery paramBusStationQuery) {
    this.a = paramContext.getApplicationContext();
    this.c = paramBusStationQuery;
    this.g = s.a();
  }
  
  public final BusStationQuery getQuery() {
    return this.c;
  }
  
  public final BusStationResult searchBusStation() throws AMapException {
    Exception exception;
    try {
      int i;
      q.a(this.a);
      BusStationQuery busStationQuery = this.c;
      boolean bool = true;
      int j = 0;
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "BusStationSearch", "searchBusStation");
      throw new AMapException(aMapException.getErrorMessage());
    } finally {
      exception = null;
      i.a(exception, "BusStationSearch", "searchBusStation");
    } 
    return (BusStationResult)exception;
  }
  
  public final void searchBusStationAsyn() {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener paramOnBusStationSearchListener) {
    this.b = paramOnBusStationSearchListener;
  }
  
  public final void setQuery(BusStationQuery paramBusStationQuery) {
    if (!paramBusStationQuery.weakEquals(this.c))
      this.c = paramBusStationQuery; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */