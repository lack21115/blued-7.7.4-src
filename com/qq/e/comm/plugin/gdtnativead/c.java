package com.qq.e.comm.plugin.gdtnativead;

import com.qq.e.comm.plugin.ab.a.a;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.b.b;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.util.v;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;

class c {
  private static d a(Exception paramException, String paramString) {
    d d = new d();
    if (paramException != null)
      d.a("ot", paramException.getMessage()); 
    if (paramString != null)
      d.a("rs", paramString); 
    return d;
  }
  
  static void a(e parame, a parama, com.qq.e.comm.plugin.y.c paramc) {
    if (parame != e.i)
      return; 
    int i = parama.a();
    if (i == 5018 || i == 5019 || i == 5013) {
      u.a(1040002, i, paramc);
      return;
    } 
    if (i == 5001) {
      try {
        d d = new d(new JSONObject(parama.getMessage()));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      u.a(1040006, i, paramc, (d)jSONException);
      return;
    } 
    u.a(1040004, i, paramc, a((Exception)parama, (String)null));
  }
  
  static void a(e parame, com.qq.e.comm.plugin.y.c paramc) {
    if (parame == e.n) {
      v.b(paramc);
      return;
    } 
    if (parame == e.m) {
      b.a(paramc);
      return;
    } 
    if (parame == e.i)
      u.a(1040011, paramc); 
  }
  
  static void a(e parame, com.qq.e.comm.plugin.y.c paramc, String paramString, int paramInt, Exception paramException) {
    if (parame == e.n) {
      v.a(parame, paramc, paramString, paramInt, paramException);
      return;
    } 
    if (parame == e.i)
      u.a(1040012, paramInt, paramc, a(paramException, paramString)); 
  }
  
  static void a(e parame, Boolean paramBoolean, com.qq.e.comm.plugin.y.c paramc, int paramInt, Exception paramException) {
    if (parame == e.n) {
      v.a(paramBoolean, paramc, paramInt, paramException);
      return;
    } 
    if (parame == e.m) {
      b.a(paramBoolean, paramc, paramInt, paramException);
      return;
    } 
    if (parame == e.i) {
      d d;
      int i;
      parame = null;
      if (paramBoolean == null) {
        i = 1040016;
      } else if (paramBoolean.booleanValue()) {
        i = 1040017;
      } else {
        i = 1040018;
        d = a(paramException, (String)null);
      } 
      u.a(i, paramInt, paramc, d);
    } 
  }
  
  static void a(e parame, Boolean paramBoolean, com.qq.e.comm.plugin.y.c paramc, a parama) {
    if (parame == e.n) {
      v.a(paramBoolean, paramc, parama);
      return;
    } 
    if (parame == e.m) {
      b.a(paramBoolean, paramc, parama);
      return;
    } 
    if (parame == e.i) {
      d d;
      int i;
      parame = null;
      if (paramBoolean == null) {
        i = 1040007;
      } else if (paramBoolean.booleanValue()) {
        i = 1040009;
      } else {
        i = 1040008;
        d = new d();
        d.a("ot", parama.toString());
      } 
      u.a(i, 0, paramc, d);
    } 
  }
  
  static void a(e parame, boolean paramBoolean, com.qq.e.comm.plugin.y.c paramc, int paramInt) {
    if (parame != e.i)
      return; 
    if (paramBoolean) {
      d d = new d();
      d.a("cnt", Integer.valueOf(paramInt));
      u.a(1040015, 0, paramc, d);
      return;
    } 
    u.a(1040006, paramInt, paramc);
  }
  
  static void a(e parame, boolean paramBoolean, com.qq.e.comm.plugin.y.c paramc, int paramInt, Exception paramException) {
    if (parame == e.n) {
      v.a(parame, paramBoolean, paramc, paramInt, paramException);
      return;
    } 
    if (parame == e.i) {
      if (paramBoolean) {
        u.a(1040014, paramc);
        return;
      } 
      u.a(1040013, paramInt, paramc, a(paramException, (String)null));
    } 
  }
  
  static void b(e parame, com.qq.e.comm.plugin.y.c paramc) {
    if (parame != e.i)
      return; 
    u.a(1040010, paramc);
  }
  
  static void c(e parame, com.qq.e.comm.plugin.y.c paramc) {
    if (parame != e.i)
      return; 
    u.a(1040019, paramc);
  }
  
  static void d(e parame, com.qq.e.comm.plugin.y.c paramc) {
    if (parame != e.i)
      return; 
    u.a(1040001, paramc);
  }
  
  static void e(e parame, com.qq.e.comm.plugin.y.c paramc) {
    if (parame != e.i)
      return; 
    u.a(1040005, paramc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */