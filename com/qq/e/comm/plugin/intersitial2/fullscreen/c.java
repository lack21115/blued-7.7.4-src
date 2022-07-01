package com.qq.e.comm.plugin.intersitial2.fullscreen;

import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.n.i;
import com.qq.e.comm.plugin.s.a;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a implements i {
  private JSONObject J;
  
  private int K;
  
  private String L;
  
  private String M;
  
  private String N;
  
  private boolean O = true;
  
  private String P;
  
  private String Q;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4) {
    super(paramString2, paramString3, paramString4, e.v);
    try {
      this.J = new JSONObject(paramString1);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (NullPointerException nullPointerException) {
      nullPointerException.printStackTrace();
    } 
    a(this.J);
  }
  
  public String a() {
    return this.P;
  }
  
  public void a(String paramString) {
    this.M = paramString;
  }
  
  void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      g(paramJSONObject);
      this.K = paramJSONObject.optInt("video_duration");
      this.L = paramJSONObject.optString("video");
      this.M = paramJSONObject.optString("endcard");
      this.N = paramJSONObject.optString("video_tracking_url");
      boolean bool = true;
      if (paramJSONObject.optInt("endcard_preload", 1) != 1)
        bool = false; 
      this.O = bool;
      this.P = paramJSONObject.optString("landing_page");
      this.Q = paramJSONObject.optString("customized_invoke_url");
    } 
  }
  
  public String e() {
    return this.Q;
  }
  
  public String f() {
    return this.a;
  }
  
  public String g() {
    return this.L;
  }
  
  public String h() {
    return this.M;
  }
  
  public String i() {
    return this.c;
  }
  
  public String j() {
    return this.N;
  }
  
  public boolean k() {
    return this.O;
  }
  
  public boolean k_() {
    return this.O;
  }
  
  public JSONObject l_() {
    return this.J;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\fullscreen\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */