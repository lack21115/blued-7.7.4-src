package com.qq.e.comm.plugin.y;

public class u {
  public static void a(int paramInt1, int paramInt2, c paramc) {
    a(paramInt1, paramInt2, paramc, null);
  }
  
  public static void a(int paramInt1, int paramInt2, c paramc, d paramd) {
    e e = (new e(paramInt1)).b(paramInt2);
    e.a(paramc);
    e.a(paramd);
    a(e);
  }
  
  public static void a(int paramInt, c paramc) {
    a(paramInt, 0, paramc);
  }
  
  public static void a(e parame) {
    if (parame != null) {
      if (!h.d())
        return; 
      k k = l.a(parame);
      s.a().a(k);
    } 
  }
  
  public static void a(g paramg) {
    if (paramg != null) {
      if (!h.c())
        return; 
      o o = p.a(paramg);
      s.a().a(o);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */