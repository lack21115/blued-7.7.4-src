package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.k;
import org.json.JSONObject;

public class a {
  public k a;
  
  public String b;
  
  public String c;
  
  public JSONObject d;
  
  public static a a() {
    return new a();
  }
  
  public static a a(JSONObject paramJSONObject) {
    String str1;
    k k1 = null;
    if (paramJSONObject == null)
      return null; 
    try {
      str1 = paramJSONObject.optString("tag", null);
      try {
        String str = paramJSONObject.optString("label", null);
        try {
          JSONObject jSONObject = paramJSONObject.optJSONObject("extra");
          try {
            k k2 = c.a(paramJSONObject.optJSONObject("material_meta"));
            k1 = k2;
            JSONObject jSONObject1 = jSONObject;
          } catch (Exception exception) {
            JSONObject jSONObject1 = jSONObject;
          } 
        } catch (Exception exception) {
          exception = null;
        } 
      } catch (Exception exception) {}
    } catch (Exception exception) {
      str1 = null;
    } 
    String str2 = null;
    paramJSONObject = null;
    return a().a(str1).b(str2).b(paramJSONObject).a(k1);
  }
  
  public a a(k paramk) {
    this.a = paramk;
    return this;
  }
  
  public a a(String paramString) {
    this.b = paramString;
    return this;
  }
  
  public a b(String paramString) {
    this.c = paramString;
    return this;
  }
  
  public a b(JSONObject paramJSONObject) {
    this.d = paramJSONObject;
    return this;
  }
  
  public JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("tag", this.b);
      jSONObject.put("label", this.c);
      if (this.d != null)
        jSONObject.put("extra", this.d); 
      if (this.a != null)
        jSONObject.put("material_meta", this.a.ae()); 
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */