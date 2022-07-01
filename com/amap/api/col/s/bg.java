package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

public final class bg implements IWeatherSearch {
  private Context a;
  
  private WeatherSearchQuery b;
  
  private WeatherSearch.OnWeatherSearchListener c;
  
  private LocalWeatherLiveResult d;
  
  private LocalWeatherForecastResult e;
  
  private Handler f = null;
  
  public bg(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    this.f = s.a();
  }
  
  public final WeatherSearchQuery getQuery() {
    return this.b;
  }
  
  public final void searchWeatherAsyn() {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener paramOnWeatherSearchListener) {
    this.c = paramOnWeatherSearchListener;
  }
  
  public final void setQuery(WeatherSearchQuery paramWeatherSearchQuery) {
    this.b = paramWeatherSearchQuery;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */