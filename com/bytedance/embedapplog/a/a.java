package com.bytedance.embedapplog.a;

import android.app.Application;
import android.content.Context;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.c.b;
import com.bytedance.embedapplog.util.h;
import com.bytedance.embedapplog.util.i;
import org.json.JSONObject;

class a extends c {
  private long b;
  
  private final h c;
  
  private final i d;
  
  a(Application paramApplication, i parami, h paramh) {
    super((Context)paramApplication);
    this.d = parami;
    this.c = paramh;
  }
  
  boolean a() {
    return true;
  }
  
  long b() {
    long l2 = this.c.v();
    long l1 = l2;
    if (l2 < 600000L)
      l1 = 600000L; 
    return this.b + l1;
  }
  
  long[] c() {
    return i.c;
  }
  
  boolean d() {
    JSONObject jSONObject = this.d.a();
    if (this.d.o() != 0 && jSONObject != null) {
      long l = System.currentTimeMillis();
      jSONObject = new JSONObject();
      jSONObject.put("header", this.d.a());
      jSONObject.put("magic_tag", "ss_app_log");
      jSONObject.put("_gen_time", l);
      jSONObject = com.bytedance.embedapplog.c.a.d(b.a(this.a, this.d.a(), com.bytedance.embedapplog.c.a.a().getABConfigUri(), true, AppLog.getIAppParam()), jSONObject);
      if (jSONObject != null) {
        JSONObject jSONObject1 = AppLog.getAbConfig();
        AppLog.getDataObserver().onRemoteAbConfigGet(i.a(jSONObject1, jSONObject) ^ true, jSONObject);
        if (h.b) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("getAbConfig ");
          stringBuilder.append(jSONObject);
          h.a(stringBuilder.toString(), null);
        } 
        this.d.a(jSONObject);
        this.b = l;
        return true;
      } 
    } 
    return false;
  }
  
  String e() {
    return "ab";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */