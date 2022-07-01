package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONObject;

public class k implements e {
  private k() {}
  
  public static k a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    JSONObject jSONObject = paramd.d();
    if (jSONObject != null && jSONObject.has("url")) {
      String str = jSONObject.optString("url");
      boolean bool = jSONObject.optBoolean("imp", false);
      if (!StringUtil.isEmpty(str))
        ah.a(str, bool); 
    } 
  }
  
  public String b() {
    return "ping";
  }
  
  static final class a {
    static final k a = new k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */