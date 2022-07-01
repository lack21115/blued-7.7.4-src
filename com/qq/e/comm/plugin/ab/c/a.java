package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Iterator;
import org.json.JSONObject;

public class a implements e {
  private a() {}
  
  public static final a a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    JSONObject jSONObject = paramd.d();
    String str = jSONObject.optString("type", "");
    jSONObject = jSONObject.optJSONObject("paras");
    if (!StringUtil.isEmpty(str)) {
      com.qq.e.comm.plugin.ab.a.a a1 = com.qq.e.comm.plugin.ab.a.a.a(str, jSONObject);
      if (a1 != null) {
        Iterator<b> iterator = paramh.d().iterator();
        while (iterator.hasNext())
          ((b)iterator.next()).a(a1); 
      } 
    } else {
      GDTLogger.report("Invoke ADEvent Handler with out evtType in paras");
    } 
  }
  
  public String b() {
    return "adEvent";
  }
  
  static final class a {
    static final a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */