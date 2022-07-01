package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

public class GeocodeResult {
  private GeocodeQuery a;
  
  private List<GeocodeAddress> b = new ArrayList<GeocodeAddress>();
  
  public GeocodeResult(GeocodeQuery paramGeocodeQuery, List<GeocodeAddress> paramList) {
    this.a = paramGeocodeQuery;
    this.b = paramList;
  }
  
  public List<GeocodeAddress> getGeocodeAddressList() {
    return this.b;
  }
  
  public GeocodeQuery getGeocodeQuery() {
    return this.a;
  }
  
  public void setGeocodeAddressList(List<GeocodeAddress> paramList) {
    this.b = paramList;
  }
  
  public void setGeocodeQuery(GeocodeQuery paramGeocodeQuery) {
    this.a = paramGeocodeQuery;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\GeocodeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */