package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends e<aa, CloudItemDetail> {
  public f(Context paramContext, aa paramaa) {
    super(paramContext, paramaa);
  }
  
  private static CloudItemDetail c(String paramString) throws AMapException {
    if (paramString != null) {
      if (paramString.equals(""))
        return null; 
      try {
        JSONArray jSONArray = a(new JSONObject(paramString));
        if (jSONArray != null) {
          if (jSONArray.length() <= 0)
            return null; 
          JSONObject jSONObject = jSONArray.getJSONObject(0);
          CloudItemDetail cloudItemDetail = b(jSONObject);
          a((CloudItem)cloudItemDetail, jSONObject);
          return cloudItemDetail;
        } 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
        return null;
      } 
    } 
    return null;
  }
  
  protected final String a() {
    return null;
  }
  
  public final Map<String, String> e() {
    Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>(16);
    hashtable.put("key", bi.f(this.e));
    hashtable.put("layerId", this.b.a);
    hashtable.put("output", "json");
    hashtable.put("id", this.b.b);
    String str1 = bl.a();
    String str2 = bl.a(this.e, str1, bs.b((Map)hashtable));
    hashtable.put("ts", str1);
    hashtable.put("scode", str2);
    return (Map)hashtable;
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.d());
    stringBuilder.append("/datasearch/id");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */