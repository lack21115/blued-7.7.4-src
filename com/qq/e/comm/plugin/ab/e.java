package com.qq.e.comm.plugin.ab;

import android.content.Context;
import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ab.c.a;
import com.qq.e.comm.plugin.ab.c.b;
import com.qq.e.comm.plugin.ab.c.c;
import com.qq.e.comm.plugin.ab.c.d;
import com.qq.e.comm.plugin.ab.c.h;
import com.qq.e.comm.plugin.ab.c.k;
import com.qq.e.comm.plugin.ab.c.n;
import com.qq.e.comm.plugin.util.bk;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collection;

public class e {
  private static boolean k;
  
  private Context a;
  
  private c b;
  
  private b c;
  
  private h.a d;
  
  private boolean e = true;
  
  private boolean f = false;
  
  private boolean g = false;
  
  private boolean h = true;
  
  private boolean i = true;
  
  private boolean j = true;
  
  public e(Context paramContext, c paramc) {
    this.a = paramContext;
    this.b = paramc;
  }
  
  public static boolean b() {
    return k;
  }
  
  public static boolean c() {
    return bk.b();
  }
  
  public e a(b paramb) {
    this.c = paramb;
    return this;
  }
  
  public e a(h.a parama) {
    this.d = parama;
    return this;
  }
  
  public e a(boolean paramBoolean) {
    this.e = paramBoolean;
    return this;
  }
  
  public h a() {
    g g;
    Context context = this.a;
    n n = null;
    if (context != null) {
      g g1;
      if (this.b == null)
        return null; 
      try {
        if (bk.a()) {
          n = new n(this.a, this.b);
        } else {
          g g2 = new g(this.a, this.b);
        } 
      } catch (Exception exception1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WebViewBuilder Exception:");
        stringBuilder.append(exception1.getMessage());
        GDTLogger.d(stringBuilder.toString());
        exception1 = null;
      } 
      Exception exception2 = exception1;
      if (exception1 == null)
        g1 = new g(this.a, this.b); 
      k = g1 instanceof n;
      b b1 = this.c;
      if (b1 != null)
        g1.a(b1); 
      g1.a(this.f);
      g1.b(this.g);
      g1.c(this.h);
      g1.d(this.i);
      g1.e(this.j);
      h.a a1 = this.d;
      if (a1 != null)
        g1.a(a1); 
      g = g1;
      if (this.e) {
        ArrayList<h> arrayList = new ArrayList();
        arrayList.add(h.a());
        arrayList.add(d.a());
        arrayList.add(a.a());
        arrayList.add(k.a());
        arrayList.add(n.a());
        arrayList.add(b.a());
        arrayList.add(c.a());
        g1.a((Collection)arrayList);
        g = g1;
      } 
    } 
    return g;
  }
  
  public e b(boolean paramBoolean) {
    this.h = paramBoolean;
    return this;
  }
  
  public e c(boolean paramBoolean) {
    this.i = paramBoolean;
    return this;
  }
  
  public e d(boolean paramBoolean) {
    this.j = paramBoolean;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */