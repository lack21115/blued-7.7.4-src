package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.ab.h;
import java.util.HashMap;

public class g {
  private HashMap<String, e> a;
  
  private h b;
  
  public g(h paramh) {
    this.b = paramh;
    this.a = new HashMap<String, e>();
  }
  
  public e a(String paramString) {
    return this.a.get(paramString);
  }
  
  public void a(d paramd) {
    e e = a(paramd.a());
    if (e != null) {
      e.a(this.b, paramd);
      return;
    } 
    this.b.b().a(new e(paramd, e.a.c, "handler not found."));
  }
  
  public void a(String paramString, e parame) {
    if (paramString != null && parame != null)
      this.a.put(paramString, parame); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */