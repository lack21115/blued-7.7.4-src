package com.bytedance.sdk.openadsdk.core.h;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
  String a;
  
  HashMap<String, d> b = new HashMap<String, d>();
  
  public static c a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    try {
      d d;
      c c1 = new c();
      c1.a(paramJSONObject.optString("cip"));
      JSONArray jSONArray = paramJSONObject.optJSONArray("dns");
      if (jSONArray != null) {
        for (int i = 0; i < jSONArray.length(); i++) {
          d = d.a(jSONArray.getJSONObject(i));
          c1.b().put(d.a(), d);
        } 
      } else {
        d = d.a((JSONObject)d);
        c1.b().put(d.a(), d);
      } 
      return c1;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public HashMap<String, d> b() {
    return this.b;
  }
  
  public JSONObject c() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("cip", a());
      JSONArray jSONArray = new JSONArray();
      if (b() != null) {
        Iterator<Map.Entry> iterator = b().entrySet().iterator();
        while (iterator.hasNext())
          jSONArray.put(((d)((Map.Entry)iterator.next()).getValue()).h()); 
      } 
      jSONObject.put("dns", jSONArray);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */