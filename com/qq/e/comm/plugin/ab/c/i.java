package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i implements e {
  private i() {}
  
  public static i a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    e e1;
    com.qq.e.comm.plugin.ab.b.a a;
    List list = l.a().d();
    if (list == null || list.isEmpty()) {
      com.qq.e.comm.plugin.ab.b.a a1 = paramh.b();
      e e2 = new e(paramd, e.a.b, "");
      a = a1;
      e1 = e2;
    } else {
      JSONObject jSONObject = new JSONObject();
      JSONArray jSONArray = new JSONArray();
      try {
        for (c c : list) {
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("taskId", c.m());
          jSONObject1.put("logoUrl", c.i());
          jSONObject1.put("appName", c.f());
          jSONObject1.put("pkgName", c.h());
          jSONObject1.put("progress", c.b("progress"));
          jSONObject1.put("totalSize", c.c("totalSize"));
          jSONObject1.put("status", c.o());
          jSONObject1.put("nTag", c.a("notifyTag"));
          jSONObject1.put("nId", c.b("notifyId"));
          jSONArray.put(jSONObject1);
        } 
        jSONObject.put("list", jSONArray);
      } catch (JSONException jSONException) {
        e1.b().a(new e((d)a, e.a.b, ""));
        GDTLogger.w("LoadDownloadingTask Json Err");
      } 
      com.qq.e.comm.plugin.ab.b.a a1 = e1.b();
      e1 = new e((d)a, e.a.a, jSONObject);
      a = a1;
    } 
    a.a(e1);
  }
  
  public String b() {
    return "loadDownloadingTask";
  }
  
  static final class a {
    static final i a = new i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */