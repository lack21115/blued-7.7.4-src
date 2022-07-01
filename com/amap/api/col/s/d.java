package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class d<T> extends b<T, Object> {
  private int j = 0;
  
  private List<String> k = new ArrayList<String>();
  
  private List<SuggestionCity> l = new ArrayList<SuggestionCity>();
  
  public d(Context paramContext, T paramT) {
    super(paramContext, paramT);
  }
  
  protected final Object a(String paramString) throws AMapException {
    try {
      JSONObject jSONObject1 = new JSONObject(paramString);
      JSONObject jSONObject2 = jSONObject1.optJSONObject("suggestion");
      if (jSONObject2 != null) {
        this.l = p.a(jSONObject2);
        this.k = p.b(jSONObject2);
      } 
      this.j = jSONObject1.optInt("count");
      if (this.b instanceof BusLineQuery) {
        arrayList = p.f(jSONObject1);
        return BusLineResult.createPagedResult((BusLineQuery)this.b, this.j, this.l, this.k, arrayList);
      } 
      ArrayList<BusLineItem> arrayList = (ArrayList)p.e((JSONObject)arrayList);
      return BusStationResult.createPagedResult((BusStationQuery)this.b, this.j, this.l, this.k, arrayList);
    } catch (Exception exception) {
      i.a(exception, "BusSearchServerHandler", "paseJSON");
      return null;
    } 
  }
  
  protected final String a() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("output=json");
    if (this.b instanceof BusLineQuery) {
      BusLineQuery busLineQuery = (BusLineQuery)this.b;
      if (!TextUtils.isEmpty(busLineQuery.getExtensions())) {
        stringBuilder1.append("&extensions=");
        stringBuilder1.append(busLineQuery.getExtensions());
      } else {
        stringBuilder1.append("&extensions=base");
      } 
      if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
        stringBuilder1.append("&id=");
        stringBuilder1.append(b(((BusLineQuery)this.b).getQueryString()));
      } else {
        String str = busLineQuery.getCity();
        if (!p.f(str)) {
          str = b(str);
          stringBuilder1.append("&city=");
          stringBuilder1.append(str);
        } 
        StringBuilder stringBuilder = new StringBuilder("&keywords=");
        stringBuilder.append(b(busLineQuery.getQueryString()));
        stringBuilder1.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("&offset=");
        stringBuilder.append(busLineQuery.getPageSize());
        stringBuilder1.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("&page=");
        stringBuilder.append(busLineQuery.getPageNumber());
        stringBuilder1.append(stringBuilder.toString());
      } 
    } else {
      BusStationQuery busStationQuery = (BusStationQuery)this.b;
      String str = busStationQuery.getCity();
      if (!p.f(str)) {
        str = b(str);
        stringBuilder1.append("&city=");
        stringBuilder1.append(str);
      } 
      StringBuilder stringBuilder = new StringBuilder("&keywords=");
      stringBuilder.append(b(busStationQuery.getQueryString()));
      stringBuilder1.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("&offset=");
      stringBuilder.append(busStationQuery.getPageSize());
      stringBuilder1.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("&page=");
      stringBuilder.append(busStationQuery.getPageNumber());
      stringBuilder1.append(stringBuilder.toString());
    } 
    StringBuilder stringBuilder2 = new StringBuilder("&key=");
    stringBuilder2.append(bi.f(this.e));
    stringBuilder1.append(stringBuilder2.toString());
    return stringBuilder1.toString();
  }
  
  public final String g() {
    String str;
    if (this.b instanceof BusLineQuery) {
      if (((BusLineQuery)this.b).getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
        str = "lineid";
      } else if (((BusLineQuery)this.b).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME) {
        str = "linename";
      } else {
        str = "";
      } 
    } else {
      str = "stopname";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/bus/");
    stringBuilder.append(str);
    stringBuilder.append("?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */