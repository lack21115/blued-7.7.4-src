package com.qq.e.comm.plugin.v;

import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.plugin.m.c;
import com.qq.e.comm.plugin.n.i;
import org.json.JSONObject;

class e extends c implements i {
  private String J;
  
  private String K;
  
  private boolean L;
  
  public e(String paramString1, String paramString2, String paramString3, com.qq.e.comm.plugin.ad.e parame, JSONObject paramJSONObject, int paramInt1, int paramInt2, VideoOption2 paramVideoOption2) {
    super(paramString1, paramString2, paramString3, parame, paramJSONObject, paramInt1, paramInt2, paramVideoOption2);
    this.J = paramJSONObject.optString("endcard");
    boolean bool = true;
    if (paramJSONObject.optInt("endcard_preload", 1) != 1)
      bool = false; 
    this.L = bool;
    this.K = paramJSONObject.optString("landing_page");
  }
  
  public String a() {
    return this.K;
  }
  
  public void a(String paramString) {
    this.J = paramString;
  }
  
  public String j() {
    return this.J;
  }
  
  public boolean k_() {
    return this.L;
  }
  
  public JSONObject l_() {
    return this.H;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\v\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */