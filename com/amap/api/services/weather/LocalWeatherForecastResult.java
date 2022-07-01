package com.amap.api.services.weather;

public class LocalWeatherForecastResult {
  private WeatherSearchQuery a;
  
  private LocalWeatherForecast b;
  
  private LocalWeatherForecastResult(WeatherSearchQuery paramWeatherSearchQuery, LocalWeatherForecast paramLocalWeatherForecast) {
    this.a = paramWeatherSearchQuery;
    this.b = paramLocalWeatherForecast;
  }
  
  public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery paramWeatherSearchQuery, LocalWeatherForecast paramLocalWeatherForecast) {
    return new LocalWeatherForecastResult(paramWeatherSearchQuery, paramLocalWeatherForecast);
  }
  
  public LocalWeatherForecast getForecastResult() {
    return this.b;
  }
  
  public WeatherSearchQuery getWeatherForecastQuery() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\weather\LocalWeatherForecastResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */