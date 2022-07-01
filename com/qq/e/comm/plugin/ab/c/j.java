package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.ab.h;
import org.json.JSONException;
import org.json.JSONObject;

public class j implements e {
  private j() {}
  
  public static j a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    e e1;
    com.qq.e.comm.plugin.ab.b.a a;
    JSONObject jSONObject = paramd.d();
    if (jSONObject == null)
      return; 
    int i = jSONObject.optInt("taskId");
    if (l.a().a(i, 1)) {
      JSONObject jSONObject1 = new JSONObject();
      try {
        jSONObject1.put("taskId", i);
      } catch (JSONException jSONException) {
        paramh.b().a(new e(paramd, e.a.b, ""));
      } 
      com.qq.e.comm.plugin.ab.b.a a1 = paramh.b();
      e1 = new e(paramd, e.a.a, jSONObject1);
      a = a1;
    } else {
      com.qq.e.comm.plugin.ab.b.a a1 = e1.b();
      e e2 = new e((d)a, e.a.b, "");
      a = a1;
      e1 = e2;
    } 
    a.a(e1);
  }
  
  public String b() {
    return "pauseDownloadTask";
  }
  
  static final class a {
    static final j a = new j();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */