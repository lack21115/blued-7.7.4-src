package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.h;
import org.json.JSONObject;

public class p implements e {
  private p() {}
  
  public static p a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    JSONObject jSONObject = paramd.d();
    if (jSONObject == null)
      return; 
    int i = jSONObject.optInt("taskId");
    int j = jSONObject.optInt("progress");
    long l = jSONObject.optLong("totalSize");
    l.a().a(i, j, l);
  }
  
  public String b() {
    return "updateDownloadProgress";
  }
  
  static final class a {
    static final p a = new p();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */