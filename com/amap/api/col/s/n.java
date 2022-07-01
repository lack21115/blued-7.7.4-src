package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class n extends b<GeocodeQuery, ArrayList<GeocodeAddress>> {
  public n(Context paramContext, GeocodeQuery paramGeocodeQuery) {
    super(paramContext, paramGeocodeQuery);
  }
  
  private static ArrayList<GeocodeAddress> c(String paramString) throws AMapException {
    ArrayList<GeocodeAddress> arrayList = new ArrayList();
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.has("count"))
        return arrayList; 
      if (jSONObject.getInt("count") > 0)
        return p.g(jSONObject); 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "GeocodingHandler", "paseJSONJSONException");
    } catch (Exception exception) {
      i.a(exception, "GeocodingHandler", "paseJSONException");
      return arrayList;
    } 
    return arrayList;
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("output=json&address=");
    stringBuffer.append(b(this.b.getLocationName()));
    String str = this.b.getCity();
    if (!p.f(str)) {
      str = b(str);
      stringBuffer.append("&city=");
      stringBuffer.append(str);
    } 
    if (!p.f(this.b.getCountry())) {
      stringBuffer.append("&country=");
      stringBuffer.append(b(this.b.getCountry()));
    } 
    StringBuilder stringBuilder = new StringBuilder("&key=");
    stringBuilder.append(bi.f(this.e));
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
  
  protected final ad.b d() {
    ad.b b1 = new ad.b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g());
    stringBuilder.append(a());
    stringBuilder.append("language=");
    stringBuilder.append(ServiceSettings.getInstance().getLanguage());
    b1.a = stringBuilder.toString();
    return b1;
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/geocode/geo?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */