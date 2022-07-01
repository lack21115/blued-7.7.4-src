package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

public final class aq extends as<WeatherSearchQuery, LocalWeatherForecast> {
  private LocalWeatherForecast j = new LocalWeatherForecast();
  
  public aq(Context paramContext, WeatherSearchQuery paramWeatherSearchQuery) {
    super(paramContext, paramWeatherSearchQuery);
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("output=json");
    String str = this.b.getCity();
    if (!p.f(str)) {
      str = b(str);
      stringBuffer.append("&city=");
      stringBuffer.append(str);
    } 
    stringBuffer.append("&extensions=all");
    StringBuilder stringBuilder = new StringBuilder("&key=");
    stringBuilder.append(bi.f(this.e));
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */