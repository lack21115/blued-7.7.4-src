package com.qq.e.comm.plugin.m.a;

import com.qq.e.comm.plugin.ab.f.a.b;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {
  public String a() {
    return "recordPerfEvent";
  }
  
  public void a(e parame, String paramString1, String paramString2, String paramString3) {
    try {
      JSONObject jSONObject = new JSONObject(paramString2);
      int i = jSONObject.optInt("eventId");
      int j = jSONObject.optInt("duration");
      int k = jSONObject.optInt("resSize");
      jSONObject = jSONObject.optJSONObject("ext");
      g g = (new g(i)).b(j).b(k);
      g.a(new d(jSONObject));
      u.a(g);
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */