package com.qq.e.comm.plugin.n;

import android.content.Context;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.y.c;

public class a {
  public static g a(Context paramContext, com.qq.e.comm.plugin.s.a parama, c paramc) {
    if (paramContext == null || parama == null) {
      ak.a("BottomCardFactory", "params error, create BottomCard fail.");
      return null;
    } 
    if (q.a(parama)) {
      ak.a("BottomCardFactory", "dpa ad, create DpaCardView.");
      return new c(paramContext, parama, paramc);
    } 
    ak.a("BottomCardFactory", "normal ad, create BottomCardView.");
    return new b(paramContext, parama);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\n\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */