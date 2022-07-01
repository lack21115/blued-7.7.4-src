package com.qq.e.comm.plugin.r.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private int a;
  
  private String b;
  
  private String c;
  
  private int d;
  
  private int e;
  
  private String f;
  
  private String g;
  
  private List<a> h;
  
  public b(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        this.a = jSONObject.optInt("ret_code");
        this.b = jSONObject.optString("config_version");
        this.c = jSONObject.optString("country");
        this.d = jSONObject.optInt("ts");
        this.e = jSONObject.optInt("update_interval");
        this.f = jSONObject.optString("report_url");
        this.g = jSONObject.optString("app_view_id");
        this.h = new ArrayList<a>();
        JSONArray jSONArray = jSONObject.optJSONArray("layer_config");
        if (jSONArray != null && jSONArray.length() > 0)
          for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject1 = jSONArray.optJSONObject(i);
            this.h.add(new a(jSONObject1));
          }  
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
  }
  
  public String a() {
    return this.b;
  }
  
  public int b() {
    return this.e;
  }
  
  public String c() {
    return this.f;
  }
  
  public String d() {
    return this.g;
  }
  
  public List<a> e() {
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\r\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */