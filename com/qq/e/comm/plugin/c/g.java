package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;

public class g {
  private static d a(f paramf) {
    return null;
  }
  
  static void a(int paramInt, f paramf) {
    u.a(1101003, paramInt, paramf.z, a(paramf));
  }
  
  public static void a(int paramInt, Exception paramException, c paramc) {
    if (paramException != null) {
      d d2 = new d();
      d2.a("ot", paramException.toString());
      d d1 = d2;
    } else {
      paramException = null;
    } 
    u.a(1101004, paramInt, paramc, (d)paramException);
  }
  
  static void a(boolean paramBoolean, int paramInt, f paramf) {
    if (paramBoolean) {
      u.a(1101002, paramInt, paramf.z, a(paramf));
      return;
    } 
    u.a(1101001, paramf.z);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */