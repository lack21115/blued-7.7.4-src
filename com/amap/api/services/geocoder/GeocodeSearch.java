package com.amap.api.services.geocoder;

import android.content.Context;
import com.amap.api.col.s.az;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

public final class GeocodeSearch {
  public static final String AMAP = "autonavi";
  
  public static final String EXTENSIONS_ALL = "all";
  
  public static final String EXTENSIONS_BASE = "base";
  
  public static final String GPS = "gps";
  
  private IGeocodeSearch a;
  
  public GeocodeSearch(Context paramContext) {
    if (this.a == null)
      try {
        this.a = (IGeocodeSearch)new az(paramContext);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public final RegeocodeAddress getFromLocation(RegeocodeQuery paramRegeocodeQuery) throws AMapException {
    IGeocodeSearch iGeocodeSearch = this.a;
    return (iGeocodeSearch != null) ? iGeocodeSearch.getFromLocation(paramRegeocodeQuery) : null;
  }
  
  public final void getFromLocationAsyn(RegeocodeQuery paramRegeocodeQuery) {
    IGeocodeSearch iGeocodeSearch = this.a;
    if (iGeocodeSearch != null)
      iGeocodeSearch.getFromLocationAsyn(paramRegeocodeQuery); 
  }
  
  public final List<GeocodeAddress> getFromLocationName(GeocodeQuery paramGeocodeQuery) throws AMapException {
    IGeocodeSearch iGeocodeSearch = this.a;
    return (iGeocodeSearch != null) ? iGeocodeSearch.getFromLocationName(paramGeocodeQuery) : null;
  }
  
  public final void getFromLocationNameAsyn(GeocodeQuery paramGeocodeQuery) {
    IGeocodeSearch iGeocodeSearch = this.a;
    if (iGeocodeSearch != null)
      iGeocodeSearch.getFromLocationNameAsyn(paramGeocodeQuery); 
  }
  
  public final void setOnGeocodeSearchListener(OnGeocodeSearchListener paramOnGeocodeSearchListener) {
    IGeocodeSearch iGeocodeSearch = this.a;
    if (iGeocodeSearch != null)
      iGeocodeSearch.setOnGeocodeSearchListener(paramOnGeocodeSearchListener); 
  }
  
  public static interface OnGeocodeSearchListener {
    void onGeocodeSearched(GeocodeResult param1GeocodeResult, int param1Int);
    
    void onRegeocodeSearched(RegeocodeResult param1RegeocodeResult, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\GeocodeSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */