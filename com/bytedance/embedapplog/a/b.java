package com.bytedance.embedapplog.a;

import android.content.Context;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.c.a;
import com.bytedance.embedapplog.util.h;
import org.json.JSONObject;

class b extends c {
  private boolean b;
  
  private final i c;
  
  b(Context paramContext, i parami) {
    super(paramContext);
    this.c = parami;
  }
  
  boolean a() {
    return true;
  }
  
  long b() {
    return this.b ? Long.MAX_VALUE : 0L;
  }
  
  long[] c() {
    return i.b;
  }
  
  boolean d() {
    if (this.c.o() != 0) {
      JSONObject jSONObject = this.c.a();
      if (jSONObject != null) {
        this.b = a.b(com.bytedance.embedapplog.c.b.a(this.a, this.c.a(), a.a().getActiveUri(), true, AppLog.getIAppParam()), jSONObject);
      } else {
        h.a(null);
      } 
    } 
    return this.b;
  }
  
  String e() {
    return "ac";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */