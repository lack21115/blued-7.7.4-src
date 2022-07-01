package com.qq.e.comm.plugin.h;

import android.content.Context;
import com.qq.e.comm.plugin.h.a.a;
import com.qq.e.comm.plugin.h.a.c;
import com.qq.e.comm.plugin.h.a.d;
import com.qq.e.comm.plugin.h.a.e;
import com.qq.e.comm.plugin.h.a.f;

public enum b {
  a("m1", (a)new f()),
  b("m5", (a)new e()),
  c("m3", (a)new d()),
  d("m4", (a)new a()),
  e("device_ext", (a)new c());
  
  private final String f;
  
  private final a g;
  
  b(String paramString1, a parama) {
    this.f = paramString1;
    this.g = parama;
  }
  
  public a a() {
    return this.g;
  }
  
  public String a(Context paramContext) {
    return a().a(paramContext);
  }
  
  public String b() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */