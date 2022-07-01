package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends b<InputtipsQuery, ArrayList<Tip>> {
  public o(Context paramContext, InputtipsQuery paramInputtipsQuery) {
    super(paramContext, paramInputtipsQuery);
  }
  
  private static ArrayList<Tip> c(String paramString) throws AMapException {
    try {
      return p.h(new JSONObject(paramString));
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "InputtipsHandler", "paseJSON");
      return null;
    } 
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("output=json");
    String str = b(this.b.getKeyword());
    if (!TextUtils.isEmpty(str)) {
      stringBuffer.append("&keywords=");
      stringBuffer.append(str);
    } 
    str = this.b.getCity();
    if (!p.f(str)) {
      str = b(str);
      stringBuffer.append("&city=");
      stringBuffer.append(str);
    } 
    str = this.b.getType();
    if (!p.f(str)) {
      str = b(str);
      stringBuffer.append("&type=");
      stringBuffer.append(str);
    } 
    if (this.b.getCityLimit()) {
      stringBuffer.append("&citylimit=true");
    } else {
      stringBuffer.append("&citylimit=false");
    } 
    LatLonPoint latLonPoint = this.b.getLocation();
    if (latLonPoint != null) {
      stringBuffer.append("&location=");
      stringBuffer.append(latLonPoint.getLongitude());
      stringBuffer.append(",");
      stringBuffer.append(latLonPoint.getLatitude());
    } 
    stringBuffer.append("&key=");
    stringBuffer.append(bi.f(this.e));
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/assistant/inputtips?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */