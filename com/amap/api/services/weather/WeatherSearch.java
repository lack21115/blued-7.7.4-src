package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.col.s.bg;
import com.amap.api.services.interfaces.IWeatherSearch;

public class WeatherSearch {
  private IWeatherSearch a = null;
  
  public WeatherSearch(Context paramContext) {
    if (this.a == null)
      try {
        this.a = (IWeatherSearch)new bg(paramContext);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public WeatherSearchQuery getQuery() {
    IWeatherSearch iWeatherSearch = this.a;
    return (iWeatherSearch != null) ? iWeatherSearch.getQuery() : null;
  }
  
  public void searchWeatherAsyn() {
    IWeatherSearch iWeatherSearch = this.a;
    if (iWeatherSearch != null)
      iWeatherSearch.searchWeatherAsyn(); 
  }
  
  public void setOnWeatherSearchListener(OnWeatherSearchListener paramOnWeatherSearchListener) {
    IWeatherSearch iWeatherSearch = this.a;
    if (iWeatherSearch != null)
      iWeatherSearch.setOnWeatherSearchListener(paramOnWeatherSearchListener); 
  }
  
  public void setQuery(WeatherSearchQuery paramWeatherSearchQuery) {
    IWeatherSearch iWeatherSearch = this.a;
    if (iWeatherSearch != null)
      iWeatherSearch.setQuery(paramWeatherSearchQuery); 
  }
  
  public static interface OnWeatherSearchListener {
    void onWeatherForecastSearched(LocalWeatherForecastResult param1LocalWeatherForecastResult, int param1Int);
    
    void onWeatherLiveSearched(LocalWeatherLiveResult param1LocalWeatherLiveResult, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\weather\WeatherSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */