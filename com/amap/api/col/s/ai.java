package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

public final class ai extends b<RouteSearch.RideRouteQuery, RideRouteResult> {
  public ai(Context paramContext, RouteSearch.RideRouteQuery paramRideRouteQuery) {
    super(paramContext, paramRideRouteQuery);
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("key=");
    stringBuffer.append(bi.f(this.e));
    stringBuffer.append("&origin=");
    stringBuffer.append(i.a(this.b.getFromAndTo().getFrom()));
    stringBuffer.append("&destination=");
    stringBuffer.append(i.a(this.b.getFromAndTo().getTo()));
    stringBuffer.append("&output=json");
    stringBuffer.append("&geometry=false");
    if (!TextUtils.isEmpty(this.b.getExtensions())) {
      stringBuffer.append("&extensions=");
      stringBuffer.append(this.b.getExtensions());
    } else {
      stringBuffer.append("&extensions=base");
    } 
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.b());
    stringBuilder.append("/direction/bicycling?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */