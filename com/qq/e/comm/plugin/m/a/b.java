package com.qq.e.comm.plugin.m.a;

import com.qq.e.comm.plugin.ab.f.a.b;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.e;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends b {
  public String a() {
    return "recordEvent";
  }
  
  public void a(e parame, String paramString1, String paramString2, String paramString3) {
    try {
      JSONObject jSONObject = new JSONObject(paramString2);
      int i = jSONObject.optInt("eventId");
      int j = jSONObject.optInt("value");
      jSONObject = jSONObject.optJSONObject("ext");
      e e1 = (new e(i)).b(j);
      e1.a(new d(jSONObject));
      u.a(e1);
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */