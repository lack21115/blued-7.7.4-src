package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;

class b implements Runnable {
  private static long a = 300000L;
  
  private static b a;
  
  private static boolean j = false;
  
  static void destroy() {
    r.a().f(5);
    j = false;
    a = null;
  }
  
  static void init() {
    if (!j) {
      i.a("CleanTask", new Object[] { "init TimeoutEventManager" });
      a = new b();
      r.a().a(5, a, a);
      j = true;
    } 
  }
  
  public void run() {
    i.a("CleanTask", new Object[] { "clean TimeoutEvent" });
    e.a().h();
    r.a().a(5, a, a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */