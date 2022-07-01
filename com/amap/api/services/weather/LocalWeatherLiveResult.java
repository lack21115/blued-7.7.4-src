package com.amap.api.services.weather;

public class LocalWeatherLiveResult {
  private WeatherSearchQuery a;
  
  private LocalWeatherLive b;
  
  private LocalWeatherLiveResult(WeatherSearchQuery paramWeatherSearchQuery, LocalWeatherLive paramLocalWeatherLive) {
    this.a = paramWeatherSearchQuery;
    this.b = paramLocalWeatherLive;
  }
  
  public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery paramWeatherSearchQuery, LocalWeatherLive paramLocalWeatherLive) {
    return new LocalWeatherLiveResult(paramWeatherSearchQuery, paramLocalWeatherLive);
  }
  
  public LocalWeatherLive getLiveResult() {
    return this.b;
  }
  
  public WeatherSearchQuery getWeatherLiveQuery() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\weather\LocalWeatherLiveResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */