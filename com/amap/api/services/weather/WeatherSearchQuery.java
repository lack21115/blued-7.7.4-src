package com.amap.api.services.weather;

import com.amap.api.col.s.i;

public class WeatherSearchQuery implements Cloneable {
  public static final int WEATHER_TYPE_FORECAST = 2;
  
  public static final int WEATHER_TYPE_LIVE = 1;
  
  private String a;
  
  private int b = 1;
  
  public WeatherSearchQuery() {}
  
  public WeatherSearchQuery(String paramString, int paramInt) {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public WeatherSearchQuery clone() {
    try {
      super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      i.a(cloneNotSupportedException, "WeatherSearchQuery", "clone");
    } 
    return new WeatherSearchQuery(this.a, this.b);
  }
  
  public String getCity() {
    return this.a;
  }
  
  public int getType() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\weather\WeatherSearchQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */