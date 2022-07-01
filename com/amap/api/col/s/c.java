package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

public final class c extends b<RouteSearch.BusRouteQuery, BusRouteResult> {
  public c(Context paramContext, RouteSearch.BusRouteQuery paramBusRouteQuery) {
    super(paramContext, paramBusRouteQuery);
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("key=");
    stringBuffer.append(bi.f(this.e));
    stringBuffer.append("&origin=");
    stringBuffer.append(i.a(this.b.getFromAndTo().getFrom()));
    stringBuffer.append("&destination=");
    stringBuffer.append(i.a(this.b.getFromAndTo().getTo()));
    String str2 = this.b.getCity();
    String str1 = str2;
    if (!p.f(str2)) {
      str1 = b(str2);
      stringBuffer.append("&city=");
      stringBuffer.append(str1);
    } 
    if (!p.f(this.b.getCity())) {
      str1 = b(str1);
      stringBuffer.append("&cityd=");
      stringBuffer.append(str1);
    } 
    stringBuffer.append("&strategy=");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getMode());
    stringBuffer.append(stringBuilder.toString());
    stringBuffer.append("&nightflag=");
    stringBuffer.append(this.b.getNightFlag());
    if (!TextUtils.isEmpty(this.b.getExtensions())) {
      stringBuffer.append("&extensions=");
      stringBuffer.append(this.b.getExtensions());
    } else {
      stringBuffer.append("&extensions=base");
    } 
    stringBuffer.append("&output=json");
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/direction/transit/integrated?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */