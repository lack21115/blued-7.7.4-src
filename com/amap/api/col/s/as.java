package com.amap.api.col.s;

import android.content.Context;

abstract class as<T, V> extends b<T, V> {
  public as(Context paramContext, T paramT) {
    super(paramContext, paramT);
  }
  
  public String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/weather/weatherInfo?");
    return stringBuilder.toString();
  }
  
  public final T h() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */