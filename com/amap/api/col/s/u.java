package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class u extends b<NearbySearch.NearbyQuery, NearbySearchResult> {
  private Context j;
  
  private NearbySearch.NearbyQuery k;
  
  public u(Context paramContext, NearbySearch.NearbyQuery paramNearbyQuery) {
    super(paramContext, paramNearbyQuery);
    this.j = paramContext;
    this.k = paramNearbyQuery;
  }
  
  private NearbySearchResult c(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      int i = this.k.getType();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      ArrayList<NearbyInfo> arrayList = p.a(jSONObject, bool);
      NearbySearchResult nearbySearchResult = new NearbySearchResult();
      nearbySearchResult.setNearbyInfoList(arrayList);
      return nearbySearchResult;
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "NearbySearchHandler", "paseJSON");
      return null;
    } 
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("key=");
    stringBuffer.append(bi.f(this.j));
    LatLonPoint latLonPoint = this.k.getCenterPoint();
    if (latLonPoint != null) {
      stringBuffer.append("&center=");
      stringBuffer.append(latLonPoint.getLongitude());
      stringBuffer.append(",");
      stringBuffer.append(latLonPoint.getLatitude());
    } 
    stringBuffer.append("&radius=");
    stringBuffer.append(this.k.getRadius());
    stringBuffer.append("&limit=30");
    stringBuffer.append("&searchtype=");
    stringBuffer.append(this.k.getType());
    stringBuffer.append("&timerange=");
    stringBuffer.append(this.k.getTimeRange());
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.c());
    stringBuilder.append("/nearby/around");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */