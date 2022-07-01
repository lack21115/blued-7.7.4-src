package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

public final class ar extends as<WeatherSearchQuery, LocalWeatherLive> {
  private LocalWeatherLive j = new LocalWeatherLive();
  
  public ar(Context paramContext, WeatherSearchQuery paramWeatherSearchQuery) {
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
    stringBuffer.append("&extensions=base");
    StringBuilder stringBuilder = new StringBuilder("&key=");
    stringBuilder.append(bi.f(this.e));
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */