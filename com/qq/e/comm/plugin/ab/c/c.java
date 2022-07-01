package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

public class c implements e {
  private c() {}
  
  public static c a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    JSONObject jSONObject = paramd.d();
    if (jSONObject != null && jSONObject.has("url")) {
      a(paramh, jSONObject.optString("url"), jSONObject.optString("browsertype"));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("InvokeBrowserHandler with illegal paras,request:");
    stringBuilder.append(paramd);
    GDTLogger.e(stringBuilder.toString());
  }
  
  public void a(h paramh, String paramString1, String paramString2) {
    if ("innerbrowser".equals(paramString2)) {
      com.qq.e.comm.plugin.c.c.a(paramString1, null);
      return;
    } 
    if (!"website".equals(paramString2) && "loadurl".equals(paramString2)) {
      paramh.a(paramString1);
      return;
    } 
    com.qq.e.comm.plugin.c.c.a(paramString1);
  }
  
  public String b() {
    return "loadURL";
  }
  
  static final class a {
    static final c a = new c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */