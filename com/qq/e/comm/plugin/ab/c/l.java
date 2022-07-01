package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.ab.h;
import org.json.JSONException;
import org.json.JSONObject;

public class l implements e {
  private l() {}
  
  public static l a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    JSONObject jSONObject = paramd.d();
    if (jSONObject == null)
      return; 
    int i = jSONObject.optInt("taskId");
    int j = jSONObject.optInt("nId");
    String str = jSONObject.optString("nTag");
    if (com.qq.e.comm.plugin.a.l.a().a(i, str, j)) {
      JSONObject jSONObject1 = new JSONObject();
      try {
        jSONObject1.put("taskId", i);
      } catch (JSONException jSONException) {
        paramh.b().a(new e(paramd, e.a.b, ""));
      } 
      paramh.b().a(new e(paramd, e.a.a, jSONObject1));
      return;
    } 
    paramh.b().a(new e(paramd, e.a.b, ""));
  }
  
  public String b() {
    return "removeDownloadTask";
  }
  
  static final class a {
    static final l a = new l();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */