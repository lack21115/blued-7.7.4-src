package com.qq.e.comm.plugin.r.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
  private String a;
  
  private int b;
  
  private int c;
  
  private String d;
  
  private String e;
  
  private List<c> f;
  
  public a(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optString("pos_id");
    this.b = paramJSONObject.optInt("timeout");
    this.c = paramJSONObject.optInt("request_type");
    this.d = paramJSONObject.optString("no_ad_view_id");
    this.e = paramJSONObject.optString("pos_view_id");
    this.f = new ArrayList<c>();
    JSONArray jSONArray = paramJSONObject.optJSONArray("network_config");
    if (jSONArray != null && jSONArray.length() >= 0)
      for (int i = 0; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        this.f.add(new c(jSONObject));
      }  
  }
  
  public String a() {
    return this.a;
  }
  
  public int b() {
    return this.b;
  }
  
  public int c() {
    return this.c;
  }
  
  public String d() {
    return this.d;
  }
  
  public String e() {
    return this.e;
  }
  
  public List<c> f() {
    for (c c : this.f) {
      c.c(0);
      c.c(false);
      c.a(-1);
      c.b(false);
      c.d(false);
      c.a(false);
    } 
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\r\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */