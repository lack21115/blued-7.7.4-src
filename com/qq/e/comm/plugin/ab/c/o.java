package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONObject;

public class o implements e {
  public static final o a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    JSONObject jSONObject = paramd.d();
    int i = jSONObject.optInt("code", 0);
    jSONObject = jSONObject.optJSONObject("paras");
    if (jSONObject != null)
      u.a(90002, i, null, new d(jSONObject)); 
  }
  
  public String b() {
    return "sdkServerReport";
  }
  
  static final class a {
    static final o a = new o();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */