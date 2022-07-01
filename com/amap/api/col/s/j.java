package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

public final class j extends b<DistanceSearch.DistanceQuery, DistanceResult> {
  private final String j = "/distance?";
  
  private final String k = "|";
  
  private final String l = ",";
  
  public j(Context paramContext, DistanceSearch.DistanceQuery paramDistanceQuery) {
    super(paramContext, paramDistanceQuery);
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("key=");
    stringBuffer.append(bi.f(this.e));
    List<LatLonPoint> list = this.b.getOrigins();
    if (list != null && list.size() > 0) {
      stringBuffer.append("&origins=");
      int k = list.size();
      int i;
      for (i = 0; i < k; i++) {
        LatLonPoint latLonPoint1 = list.get(i);
        if (latLonPoint1 != null) {
          double d = i.a(latLonPoint1.getLatitude());
          stringBuffer.append(i.a(latLonPoint1.getLongitude()));
          stringBuffer.append(",");
          stringBuffer.append(d);
          if (i < k)
            stringBuffer.append("|"); 
        } 
      } 
    } 
    LatLonPoint latLonPoint = this.b.getDestination();
    if (latLonPoint != null) {
      double d1 = i.a(latLonPoint.getLatitude());
      double d2 = i.a(latLonPoint.getLongitude());
      stringBuffer.append("&destination=");
      stringBuffer.append(d2);
      stringBuffer.append(",");
      stringBuffer.append(d1);
    } 
    stringBuffer.append("&type=");
    stringBuffer.append(this.b.getType());
    if (!TextUtils.isEmpty(this.b.getExtensions())) {
      stringBuffer.append("&extensions=");
      stringBuffer.append(this.b.getExtensions());
    } else {
      stringBuffer.append("&extensions=base");
    } 
    stringBuffer.append("&output=json");
    if (this.b.getType() == 1) {
      stringBuffer.append("&strategy=");
      stringBuffer.append(this.b.getMode());
    } 
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/distance?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */