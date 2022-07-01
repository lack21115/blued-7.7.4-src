package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class y extends w<ab, PoiResult> {
  private int j = 0;
  
  private boolean k = false;
  
  private List<String> l = new ArrayList<String>();
  
  private List<SuggestionCity> m = new ArrayList<SuggestionCity>();
  
  public y(Context paramContext, ab paramab) {
    super(paramContext, paramab);
  }
  
  private String a(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("output=json");
    if (this.b.b != null)
      if (this.b.b.getShape().equals("Bound")) {
        if (paramBoolean) {
          double d1 = i.a(this.b.b.getCenter().getLongitude());
          double d2 = i.a(this.b.b.getCenter().getLatitude());
          stringBuilder.append("&location=");
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(d1);
          stringBuilder1.append(",");
          stringBuilder1.append(d2);
          stringBuilder.append(stringBuilder1.toString());
        } 
        stringBuilder.append("&radius=");
        stringBuilder.append(this.b.b.getRange());
        stringBuilder.append("&sortrule=");
        stringBuilder.append(b(this.b.b.isDistanceSort()));
      } else if (this.b.b.getShape().equals("Rectangle")) {
        LatLonPoint latLonPoint1 = this.b.b.getLowerLeft();
        LatLonPoint latLonPoint2 = this.b.b.getUpperRight();
        double d1 = i.a(latLonPoint1.getLatitude());
        double d2 = i.a(latLonPoint1.getLongitude());
        double d3 = i.a(latLonPoint2.getLatitude());
        double d4 = i.a(latLonPoint2.getLongitude());
        StringBuilder stringBuilder1 = new StringBuilder("&polygon=");
        stringBuilder1.append(d2);
        stringBuilder1.append(",");
        stringBuilder1.append(d1);
        stringBuilder1.append(";");
        stringBuilder1.append(d4);
        stringBuilder1.append(",");
        stringBuilder1.append(d3);
        stringBuilder.append(stringBuilder1.toString());
      } else if (this.b.b.getShape().equals("Polygon")) {
        List<LatLonPoint> list = this.b.b.getPolyGonList();
        if (list != null && list.size() > 0) {
          StringBuilder stringBuilder1 = new StringBuilder("&polygon=");
          stringBuilder1.append(i.a(list));
          stringBuilder.append(stringBuilder1.toString());
        } 
      }  
    String str = this.b.a.getCity();
    if (!c(str)) {
      str = b(str);
      stringBuilder.append("&city=");
      stringBuilder.append(str);
    } 
    str = b(this.b.a.getQueryString());
    if (!c(str)) {
      stringBuilder.append("&keywords=");
      stringBuilder.append(str);
    } 
    stringBuilder.append("&offset=");
    stringBuilder.append(this.b.a.getPageSize());
    stringBuilder.append("&page=");
    stringBuilder.append(this.b.a.getPageNum());
    str = this.b.a.getBuilding();
    if (str != null && str.trim().length() > 0) {
      stringBuilder.append("&building=");
      stringBuilder.append(this.b.a.getBuilding());
    } 
    str = b(this.b.a.getCategory());
    if (!c(str)) {
      stringBuilder.append("&types=");
      stringBuilder.append(str);
    } 
    if (!c(this.b.a.getExtensions())) {
      stringBuilder.append("&extensions=");
      stringBuilder.append(this.b.a.getExtensions());
    } else {
      stringBuilder.append("&extensions=base");
    } 
    stringBuilder.append("&key=");
    stringBuilder.append(bi.f(this.e));
    if (this.b.a.getCityLimit()) {
      stringBuilder.append("&citylimit=true");
    } else {
      stringBuilder.append("&citylimit=false");
    } 
    if (this.b.a.isRequireSubPois()) {
      stringBuilder.append("&children=1");
    } else {
      stringBuilder.append("&children=0");
    } 
    if (this.k)
      if (this.b.a.isSpecial()) {
        stringBuilder.append("&special=1");
      } else {
        stringBuilder.append("&special=0");
      }  
    if (this.b.b == null && this.b.a.getLocation() != null) {
      stringBuilder.append("&sortrule=");
      stringBuilder.append(b(this.b.a.isDistanceSort()));
      double d1 = i.a(this.b.a.getLocation().getLongitude());
      double d2 = i.a(this.b.a.getLocation().getLatitude());
      stringBuilder.append("&location=");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d1);
      stringBuilder1.append(",");
      stringBuilder1.append(d2);
      stringBuilder.append(stringBuilder1.toString());
    } 
    return stringBuilder.toString();
  }
  
  private static String b(boolean paramBoolean) {
    return paramBoolean ? "distance" : "weight";
  }
  
  private PoiResult d(String paramString) throws AMapException {
    JSONException jSONException;
    Exception exception1;
    ArrayList arrayList = new ArrayList();
    if (paramString == null)
      return PoiResult.createPagedResult(this.b.a, this.b.b, this.l, this.m, this.b.a.getPageSize(), this.j, arrayList); 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      this.j = jSONObject.optInt("count");
      ArrayList<PoiItem> arrayList1 = p.c(jSONObject);
      try {
        if (!jSONObject.has("suggestion"))
          return PoiResult.createPagedResult(this.b.a, this.b.b, this.l, this.m, this.b.a.getPageSize(), this.j, arrayList1); 
        JSONObject jSONObject1 = jSONObject.optJSONObject("suggestion");
        if (jSONObject1 == null)
          return PoiResult.createPagedResult(this.b.a, this.b.b, this.l, this.m, this.b.a.getPageSize(), this.j, arrayList1); 
        this.m = p.a(jSONObject1);
        this.l = p.b(jSONObject1);
      } catch (JSONException null) {
        i.a((Throwable)jSONException, "PoiSearchKeywordHandler", "paseJSONJSONException");
      } catch (Exception exception2) {}
    } catch (JSONException jSONException1) {
      Exception exception = exception2;
      jSONException = jSONException1;
    } catch (Exception exception) {
      JSONException jSONException1 = jSONException;
      exception1 = exception;
      i.a(exception1, "PoiSearchKeywordHandler", "paseJSONException");
    } 
    i.a(exception1, "PoiSearchKeywordHandler", "paseJSONJSONException");
  }
  
  protected final String a() {
    return a(true);
  }
  
  protected final ad.b d() {
    ad.b b = new ad.b();
    if (this.k) {
      ae ae = ad.a().a("regeo");
      if (ae == null) {
        ae = null;
      } else {
        ae = ae;
      } 
      double d = 0.0D;
      if (ae != null)
        d = ae.a(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g());
      stringBuilder.append(a(false));
      stringBuilder.append("language=");
      stringBuilder.append(ServiceSettings.getInstance().getLanguage());
      b.a = stringBuilder.toString();
      if (this.b.b.getShape().equals("Bound")) {
        double d1 = i.a(this.b.b.getCenter().getLongitude());
        b.b = new af.a(i.a(this.b.b.getCenter().getLatitude()), d1, d);
        return b;
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g());
      stringBuilder.append(a());
      stringBuilder.append("language=");
      stringBuilder.append(ServiceSettings.getInstance().getLanguage());
      b.a = stringBuilder.toString();
    } 
    return b;
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/place");
    String str = stringBuilder.toString();
    if (this.b.b == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("/text?");
      return stringBuilder.toString();
    } 
    if (this.b.b.getShape().equals("Bound")) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("/around?");
      String str1 = stringBuilder.toString();
      this.k = true;
      return str1;
    } 
    if (!this.b.b.getShape().equals("Rectangle")) {
      String str1 = str;
      if (this.b.b.getShape().equals("Polygon")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append("/polygon?");
        return stringBuilder1.toString();
      } 
      return str1;
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("/polygon?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */