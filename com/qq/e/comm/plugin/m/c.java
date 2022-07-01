package com.qq.e.comm.plugin.m;

import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.s.a;
import org.json.JSONObject;

public class c extends a {
  private JSONObject J;
  
  private JSONObject K;
  
  private String L;
  
  private int M;
  
  private int N;
  
  private VideoOption2 O;
  
  private int P;
  
  private boolean Q;
  
  public c(String paramString1, String paramString2, String paramString3, e parame, JSONObject paramJSONObject, int paramInt1, int paramInt2, VideoOption2 paramVideoOption2) {
    super(paramString1, paramString2, paramString3, parame);
    g(paramJSONObject);
    this.M = paramInt1;
    this.N = paramInt2;
    this.O = paramVideoOption2;
    this.K = paramJSONObject.optJSONObject("tpl_info");
    this.J = com.qq.e.comm.plugin.z.c.a().a(this.K);
    this.L = paramJSONObject.optString("customized_invoke_url");
    this.P = paramJSONObject.optInt("video_duration") * 1000;
    this.Q = com.qq.e.comm.plugin.z.c.b(this.J);
  }
  
  public JSONObject b() {
    return this.K;
  }
  
  public int c() {
    return this.M;
  }
  
  public int d() {
    return this.N;
  }
  
  public String e() {
    return this.L;
  }
  
  public VideoOption2 f() {
    return this.O;
  }
  
  public int g() {
    return this.P;
  }
  
  public boolean h() {
    return this.Q;
  }
  
  public JSONObject m_() {
    return this.J;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */