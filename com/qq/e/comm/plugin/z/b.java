package com.qq.e.comm.plugin.z;

import android.text.TextUtils;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class b {
  private Map<String, a> a = new HashMap<String, a>();
  
  public b(String paramString) {
    try {
      if (!TextUtils.isEmpty(paramString)) {
        JSONObject jSONObject = new JSONObject(paramString);
        Iterator<String> iterator = jSONObject.keys();
        while (iterator.hasNext()) {
          String str = iterator.next();
          a a = new a(jSONObject.getJSONObject(str));
          this.a.put(str, a);
        } 
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
  
  public a a(String paramString) {
    return this.a.get(paramString);
  }
  
  public boolean a(JSONObject paramJSONObject, c paramc) {
    if (paramJSONObject != null) {
      String str1 = paramJSONObject.optString("id");
      String str2 = paramJSONObject.optString("data");
      if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
        this.a.put(str1, new a(str1, str2, paramJSONObject));
        u.a(1210026, paramc);
        return true;
      } 
      u.a(1210025, paramc);
    } 
    return false;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      for (Map.Entry<String, a> entry : this.a.entrySet()) {
        a a = (a)entry.getValue();
        if (a != null && a.a(a) != null)
          jSONObject.put((String)entry.getKey(), a.a(a)); 
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject.toString();
  }
  
  public static class a {
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    private JSONObject f;
    
    public a(String param1String1, String param1String2, JSONObject param1JSONObject) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1JSONObject.optString("ver");
      this.d = param1JSONObject.optString("root_id");
      this.e = param1JSONObject.optString("url");
      this.f = param1JSONObject;
    }
    
    public a(JSONObject param1JSONObject) {
      this(param1JSONObject.optString("id"), param1JSONObject.optString("data"), param1JSONObject);
    }
    
    public String a() {
      return this.b;
    }
    
    public JSONObject b() {
      try {
        return new JSONObject(this.f, new String[] { "id", "ver" });
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        return null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\z\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */