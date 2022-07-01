package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

public class c {
  private String a;
  
  private String b;
  
  private Map<String, String> c;
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    if (!TextUtils.isEmpty(this.a)) {
      if (TextUtils.isEmpty(this.b))
        return jSONObject; 
      try {
        jSONObject.put("url", this.a);
        jSONObject.put("html", this.b);
        JSONObject jSONObject1 = new JSONObject();
        if (this.c != null && this.c.size() > 0)
          for (Map.Entry<String, String> entry : this.c.entrySet())
            jSONObject1.put((String)entry.getKey(), entry.getValue());  
        jSONObject.put("headers", jSONObject1);
        return jSONObject;
      } catch (Exception exception) {
        return jSONObject;
      } 
    } 
    return jSONObject;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(Map<String, String> paramMap) {
    this.c = paramMap;
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */