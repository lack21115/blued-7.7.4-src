package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class x extends w<String, PoiItem> {
  private PoiSearch.Query j = null;
  
  public x(Context paramContext, String paramString, PoiSearch.Query paramQuery) {
    super(paramContext, paramString);
    this.j = paramQuery;
  }
  
  private static PoiItem d(String paramString) throws AMapException {
    try {
      JSONArray jSONArray = (new JSONObject(paramString)).optJSONArray("pois");
      if (jSONArray != null) {
        if (jSONArray.length() <= 0)
          return null; 
        JSONObject jSONObject = jSONArray.optJSONObject(0);
        return (jSONObject == null) ? null : p.d(jSONObject);
      } 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "PoiSearchIdHandler", "paseJSONJSONException");
    } catch (Exception exception) {
      i.a(exception, "PoiSearchIdHandler", "paseJSONException");
      return null;
    } 
    return null;
  }
  
  protected final String a() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("id=");
    stringBuilder1.append(this.b);
    stringBuilder1.append("&output=json");
    PoiSearch.Query query = this.j;
    if (query != null && !c(query.getExtensions())) {
      stringBuilder1.append("&extensions=");
      stringBuilder1.append(this.j.getExtensions());
    } else {
      stringBuilder1.append("&extensions=base");
    } 
    stringBuilder1.append("&children=1");
    StringBuilder stringBuilder2 = new StringBuilder("&key=");
    stringBuilder2.append(bi.f(this.e));
    stringBuilder1.append(stringBuilder2.toString());
    return stringBuilder1.toString();
  }
  
  protected final ad.b d() {
    ad.b b = new ad.b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g());
    stringBuilder.append(a());
    stringBuilder.append("language=");
    stringBuilder.append(ServiceSettings.getInstance().getLanguage());
    b.a = stringBuilder.toString();
    return b;
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/place/detail?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */