package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.n.i;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.m;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a implements i {
  private JSONObject J;
  
  private int K;
  
  private int L;
  
  private String M;
  
  private String N;
  
  private String O;
  
  private String P;
  
  private String Q;
  
  private boolean R = true;
  
  private String S;
  
  private String T;
  
  private String U;
  
  private e V;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4) {
    super(paramString2, paramString3, paramString4, e.k);
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
    return this.U;
  }
  
  public void a(e parame) {
    this.V = parame;
  }
  
  public void a(String paramString) {
    this.N = paramString;
  }
  
  void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      g(paramJSONObject);
      this.K = paramJSONObject.optInt("video_duration");
      this.L = paramJSONObject.optInt("card_show_time");
      this.M = paramJSONObject.optString("video");
      this.N = paramJSONObject.optString("endcard");
      this.O = paramJSONObject.optString("endcard_info");
      this.P = paramJSONObject.optString("edid");
      this.Q = paramJSONObject.optString("video_tracking_url");
      boolean bool = true;
      if (paramJSONObject.optInt("endcard_preload", 1) != 1)
        bool = false; 
      this.R = bool;
      this.U = paramJSONObject.optString("landing_page");
      this.T = paramJSONObject.optString("landing_page_report_url");
      this.S = paramJSONObject.optString("customized_invoke_url");
    } 
  }
  
  public String ak() {
    return this.N;
  }
  
  public String al() {
    return this.f;
  }
  
  public String am() {
    return this.Q;
  }
  
  public String an() {
    return this.T;
  }
  
  public e ao() {
    return this.V;
  }
  
  public void d(boolean paramBoolean) {
    this.R = paramBoolean;
  }
  
  public String e() {
    return this.S;
  }
  
  boolean f() {
    return (this.J != null && m.b(this.M) && this.K >= 0);
  }
  
  boolean g() {
    return (this.J != null && m.b(this.U));
  }
  
  public int h() {
    return this.K;
  }
  
  public String i() {
    return this.c;
  }
  
  public String j() {
    return this.a;
  }
  
  public String k() {
    return this.M;
  }
  
  public boolean k_() {
    return this.R;
  }
  
  public JSONObject l_() {
    return this.J;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */