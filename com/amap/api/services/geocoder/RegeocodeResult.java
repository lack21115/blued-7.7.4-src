package com.amap.api.services.geocoder;

public class RegeocodeResult {
  private RegeocodeQuery a;
  
  private RegeocodeAddress b;
  
  public RegeocodeResult(RegeocodeQuery paramRegeocodeQuery, RegeocodeAddress paramRegeocodeAddress) {
    this.a = paramRegeocodeQuery;
    this.b = paramRegeocodeAddress;
  }
  
  public RegeocodeAddress getRegeocodeAddress() {
    return this.b;
  }
  
  public RegeocodeQuery getRegeocodeQuery() {
    return this.a;
  }
  
  public void setRegeocodeAddress(RegeocodeAddress paramRegeocodeAddress) {
    this.b = paramRegeocodeAddress;
  }
  
  public void setRegeocodeQuery(RegeocodeQuery paramRegeocodeQuery) {
    this.a = paramRegeocodeQuery;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\RegeocodeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */