package com.bytedance.tea.crash.e.a;

import android.content.Context;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.c.a;
import java.util.HashMap;
import java.util.Map;

public class e {
  private static volatile e a;
  
  private Context b;
  
  private Map<c, c> c = new HashMap<c, c>();
  
  private b d;
  
  private d e;
  
  private e(Context paramContext) {
    this.b = paramContext;
    this.d = new b(this.b);
    this.e = new d(this.b);
  }
  
  private c a(c paramc) {
    c c1 = this.c.get(paramc);
    if (c1 != null)
      return c1; 
    int i = null.a[paramc.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i == 3)
          c1 = new f(this.b, this.d, this.e); 
      } else {
        c1 = new a(this.b, this.d, this.e);
      } 
    } else {
      c1 = new g(this.b, this.d, this.e);
    } 
    if (c1 != null)
      this.c.put(paramc, c1); 
    return c1;
  }
  
  public static e a() {
    if (a != null)
      return a; 
    throw new IllegalArgumentException("CrashContextAssembly not init");
  }
  
  public static void a(Context paramContext) {
    if (a == null)
      a = new e(paramContext); 
  }
  
  public a a(c paramc, a parama) {
    if (paramc == null)
      return parama; 
    c c1 = a(paramc);
    return (c1 != null) ? c1.a(parama) : parama;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */