package com.bytedance.embedapplog.a;

import android.content.Context;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.c.a;
import com.bytedance.embedapplog.c.b;
import com.bytedance.embedapplog.util.h;
import org.json.JSONObject;

class i extends c {
  static final long[] b = new long[] { 60000L, 60000L, 60000L, 120000L, 120000L, 120000L, 180000L, 180000L };
  
  static final long[] c = new long[] { 180000L, 180000L, 360000L, 360000L, 540000L, 540000L };
  
  private static final long[] d = new long[] { 10000L, 10000L, 20000L, 20000L, 60000L, 6000L, 180000L, 180000L, 540000L, 540000L };
  
  private com.bytedance.embedapplog.b.i e;
  
  private k f;
  
  i(Context paramContext, com.bytedance.embedapplog.b.i parami, k paramk) {
    super(paramContext);
    this.e = parami;
    this.f = paramk;
  }
  
  boolean a() {
    return true;
  }
  
  long b() {
    int j;
    long l = this.e.p();
    if (this.f.c()) {
      j = 21600000;
    } else {
      j = 43200000;
    } 
    return l + j;
  }
  
  long[] c() {
    int j = this.e.o();
    if (j != 0) {
      if (j != 1) {
        if (j != 2) {
          h.a(null);
          return c;
        } 
        return b;
      } 
      return c;
    } 
    return d;
  }
  
  boolean d() {
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = this.e.a();
    if (jSONObject2 != null) {
      jSONObject1.put("magic_tag", "ss_app_log");
      jSONObject1.put("header", jSONObject2);
      jSONObject1.put("_gen_time", System.currentTimeMillis());
      jSONObject1 = a.a(b.a(this.a, this.e.a(), a.a().getRegisterUri(), true, AppLog.getIAppParam()), jSONObject1);
      if (jSONObject1 != null) {
        String str1 = jSONObject1.optString("device_id", "");
        String str2 = jSONObject1.optString("install_id", "");
        String str3 = jSONObject1.optString("ssid", "");
        return this.e.a(jSONObject1, str1, str2, str3);
      } 
    } else {
      h.a(null);
    } 
    return false;
  }
  
  String e() {
    return "r";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */