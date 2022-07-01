package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k extends b<DistrictSearchQuery, DistrictResult> {
  public k(Context paramContext, DistrictSearchQuery paramDistrictSearchQuery) {
    super(paramContext, paramDistrictSearchQuery);
  }
  
  private DistrictResult c(String paramString) throws AMapException {
    ArrayList<DistrictItem> arrayList = new ArrayList();
    DistrictResult districtResult = new DistrictResult(this.b, arrayList);
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      districtResult.setPageCount(jSONObject.optInt("count"));
      JSONArray jSONArray = jSONObject.optJSONArray("districts");
      if (jSONArray == null)
        return districtResult; 
      p.a(jSONArray, arrayList, null);
      return districtResult;
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "DistrictServerHandler", "paseJSONJSONException");
      return districtResult;
    } catch (Exception exception) {
      i.a(exception, "DistrictServerHandler", "paseJSONException");
      return districtResult;
    } 
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("output=json");
    stringBuffer.append("&page=");
    stringBuffer.append(this.b.getPageNum());
    stringBuffer.append("&offset=");
    stringBuffer.append(this.b.getPageSize());
    if (this.b.isShowBoundary()) {
      stringBuffer.append("&extensions=all");
    } else {
      stringBuffer.append("&extensions=base");
    } 
    if (this.b.checkKeyWords()) {
      String str = b(this.b.getKeywords());
      stringBuffer.append("&keywords=");
      stringBuffer.append(str);
    } 
    StringBuilder stringBuilder = new StringBuilder("&key=");
    stringBuilder.append(bi.f(this.e));
    stringBuffer.append(stringBuilder.toString());
    stringBuilder = new StringBuilder("&subdistrict=");
    stringBuilder.append(String.valueOf(this.b.getSubDistrict()));
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/config/district?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */