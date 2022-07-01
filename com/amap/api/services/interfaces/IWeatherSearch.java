package com.amap.api.services.interfaces;

import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

public interface IWeatherSearch {
  WeatherSearchQuery getQuery();
  
  void searchWeatherAsyn();
  
  void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener paramOnWeatherSearchListener);
  
  void setQuery(WeatherSearchQuery paramWeatherSearchQuery);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IWeatherSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */