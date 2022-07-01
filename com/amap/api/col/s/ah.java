package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah extends b<RegeocodeQuery, RegeocodeAddress> {
  public ah(Context paramContext, RegeocodeQuery paramRegeocodeQuery) {
    super(paramContext, paramRegeocodeQuery);
  }
  
  private String a(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("output=json&location=");
    if (paramBoolean) {
      stringBuilder.append(i.a(this.b.getPoint().getLongitude()));
      stringBuilder.append(",");
      stringBuilder.append(i.a(this.b.getPoint().getLatitude()));
    } 
    if (!TextUtils.isEmpty(this.b.getPoiType())) {
      stringBuilder.append("&poitype=");
      stringBuilder.append(this.b.getPoiType());
    } 
    if (!TextUtils.isEmpty(this.b.getMode())) {
      stringBuilder.append("&mode=");
      stringBuilder.append(this.b.getMode());
    } 
    if (!TextUtils.isEmpty(this.b.getExtensions())) {
      stringBuilder.append("&extensions=");
      stringBuilder.append(this.b.getExtensions());
    } else {
      stringBuilder.append("&extensions=base");
    } 
    stringBuilder.append("&radius=");
    stringBuilder.append((int)this.b.getRadius());
    stringBuilder.append("&coordsys=");
    stringBuilder.append(this.b.getLatLonType());
    stringBuilder.append("&key=");
    stringBuilder.append(bi.f(this.e));
    return stringBuilder.toString();
  }
  
  private static RegeocodeAddress c(String paramString) throws AMapException {
    RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
    try {
      JSONObject jSONObject1 = (new JSONObject(paramString)).optJSONObject("regeocode");
      if (jSONObject1 == null)
        return regeocodeAddress; 
      regeocodeAddress.setFormatAddress(p.a(jSONObject1, "formatted_address"));
      JSONObject jSONObject2 = jSONObject1.optJSONObject("addressComponent");
      if (jSONObject2 != null)
        p.a(jSONObject2, regeocodeAddress); 
      regeocodeAddress.setPois(p.c(jSONObject1));
      JSONArray jSONArray2 = jSONObject1.optJSONArray("roads");
      if (jSONArray2 != null)
        p.b(jSONArray2, regeocodeAddress); 
      jSONArray2 = jSONObject1.optJSONArray("roadinters");
      if (jSONArray2 != null)
        p.a(jSONArray2, regeocodeAddress); 
      JSONArray jSONArray1 = jSONObject1.optJSONArray("aois");
      if (jSONArray1 != null) {
        p.c(jSONArray1, regeocodeAddress);
        return regeocodeAddress;
      } 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "ReverseGeocodingHandler", "paseJSON");
    } 
    return regeocodeAddress;
  }
  
  protected final String a() {
    return a(true);
  }
  
  protected final ad.b d() {
    ae ae = ad.a().a("regeo");
    if (ae == null) {
      ae = null;
    } else {
      ae = ae;
    } 
    double d = 0.0D;
    if (ae != null)
      d = ae.a(); 
    ad.b b1 = new ad.b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g());
    stringBuilder.append(a(false));
    stringBuilder.append("language=");
    stringBuilder.append(ServiceSettings.getInstance().getLanguage());
    b1.a = stringBuilder.toString();
    if (this.b != null && this.b.getPoint() != null)
      b1.b = new af.a(this.b.getPoint().getLatitude(), this.b.getPoint().getLongitude(), d); 
    return b1;
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/geocode/regeo?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */