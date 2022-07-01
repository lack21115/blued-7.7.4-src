package com.bytedance.embedapplog.a;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.d.b;
import org.json.JSONObject;

class h extends c {
  private static final long[] b = new long[] { 60000L };
  
  private final b c;
  
  private final i d;
  
  private long e;
  
  h(Context paramContext, i parami, b paramb) {
    super(paramContext);
    this.c = paramb;
    this.d = parami;
  }
  
  boolean a() {
    return false;
  }
  
  long b() {
    return this.e + 60000L;
  }
  
  long[] c() {
    return b;
  }
  
  public boolean d() {
    long l = System.currentTimeMillis();
    k k = e.d();
    if (k != null) {
      Bundle bundle = k.a(l, 50000L);
      if (bundle != null) {
        AppLog.onEventV3("play_session", bundle);
        AppLog.flush();
      } 
    } 
    if (this.d.o() != 0) {
      JSONObject jSONObject = this.d.b();
      if (jSONObject != null) {
        boolean bool = this.c.a(jSONObject);
        this.e = System.currentTimeMillis();
        return bool;
      } 
      com.bytedance.embedapplog.util.h.a(null);
    } 
    return false;
  }
  
  String e() {
    return "p";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */