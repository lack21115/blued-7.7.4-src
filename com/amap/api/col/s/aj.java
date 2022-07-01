package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class aj extends b<RoutePOISearchQuery, RoutePOISearchResult> {
  public aj(Context paramContext, RoutePOISearchQuery paramRoutePOISearchQuery) {
    super(paramContext, paramRoutePOISearchQuery);
  }
  
  private RoutePOISearchResult c(String paramString) throws AMapException {
    ArrayList arrayList1;
    ArrayList arrayList2 = new ArrayList();
    try {
      arrayList1 = p.i(new JSONObject(paramString));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      arrayList1 = arrayList2;
    } 
    return new RoutePOISearchResult(arrayList1, this.b);
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("key=");
    stringBuffer.append(bi.f(this.e));
    stringBuffer.append("&range=");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getRange());
    stringBuffer.append(stringBuilder.toString());
    String str = "";
    try {
      switch (null.a[this.b.getSearchType().ordinal()]) {
        case 1:
          str = "0101";
        default:
          if (this.b.getPolylines() != null && this.b.getPolylines().size() > 0) {
            stringBuffer.append("&polyline=");
            stringBuffer.append(i.a(this.b.getPolylines()));
          } else {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(this.b.getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(this.b.getTo()));
            stringBuffer.append("&strategy=");
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(this.b.getMode());
            stringBuffer.append(stringBuilder1.toString());
          } 
          stringBuffer.append("&types=");
          stringBuffer.append(str);
          return stringBuffer.toString();
        case 6:
          str = "180301";
        case 5:
          str = "0103";
        case 4:
          str = "2003";
        case 3:
          str = "1603";
        case 2:
          break;
      } 
    } catch (Exception exception) {}
    str = "0300";
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/place/route?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */