package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;

class h {
  private static d a(Exception paramException, String paramString) {
    d d = new d();
    if (paramException != null)
      d.a("ot", paramException.getMessage()); 
    if (paramString != null)
      d.a("rs", paramString); 
    return d;
  }
  
  static void a(int paramInt, c paramc) {
    u.a(1020060, paramInt, paramc);
  }
  
  static void a(int paramInt, c paramc, String paramString, Exception paramException) {
    u.a(1020009, paramInt, paramc, a(paramException, paramString));
  }
  
  static void a(f.d paramd, c paramc) {
    int i = null.a[paramd.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        i = 1020010;
      } else {
        i = 1020011;
      } 
    } else {
      i = 1020013;
    } 
    u.a(i, paramc);
  }
  
  static void a(a parama, c paramc) {
    int i = parama.a();
    if (i == 5018 || i == 5019 || i == 5013) {
      u.a(1020018, paramc);
      return;
    } 
    if (i == 5001) {
      try {
        d d = new d(new JSONObject(parama.getMessage()));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      u.a(1020060, 0, paramc, (d)jSONException);
      return;
    } 
    u.a(1020002, i, paramc, a((Exception)jSONException, (String)null));
  }
  
  static void a(e parame, int paramInt, c paramc) {
    int i;
    if (null.b[parame.ordinal()] != 2) {
      i = 1020007;
    } else {
      i = 1022001;
    } 
    u.a(i, paramInt, paramc);
  }
  
  static void a(e parame, c paramc) {
    int i = null.b[parame.ordinal()];
    if (i != 1) {
      if (i != 2) {
        i = 0;
      } else {
        i = 1022007;
      } 
    } else {
      i = 1020012;
    } 
    u.a(i, paramc);
  }
  
  static void a(e parame, boolean paramBoolean, c paramc) {
    int i = null.b[parame.ordinal()];
    if (i != 1) {
      if (i != 2) {
        i = 0;
      } else if (paramBoolean) {
        i = 1022005;
      } else {
        i = 1022006;
      } 
    } else if (paramBoolean) {
      i = 1020021;
    } else {
      i = 1020022;
    } 
    u.a(i, paramc);
  }
  
  static void a(e parame, boolean paramBoolean1, boolean paramBoolean2, c paramc, String paramString, c paramc1) {
    d d;
    int k = null.b[parame.ordinal()];
    int j = 0;
    int i = 0;
    parame = null;
    if (k != 1) {
      if (k != 2) {
        i = 0;
      } else {
        i = 1022008;
      } 
    } else if (paramBoolean1) {
      i = 1020063;
    } else if (paramBoolean2) {
      i = 1020004;
    } else {
      k = 1020005;
      if (paramc1 == null) {
        j = i;
      } else {
        j = paramc1.a();
      } 
      d = a((Exception)paramc1, paramString);
      i = k;
    } 
    u.a(i, j, paramc, d);
  }
  
  static void a(c paramc) {
    u.a(1020014, paramc);
  }
  
  static void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, c paramc) {
    if (paramBoolean) {
      u.a(1022002, paramc);
      return;
    } 
    d d = new d();
    d.a("rs", paramString1);
    d.a("ot", paramString2);
    u.a(1022003, paramInt, paramc, d);
  }
  
  static void b(e parame, c paramc) {
    int i = null.b[parame.ordinal()];
    if (i != 1) {
      if (i != 2) {
        i = 0;
      } else {
        i = 1022004;
      } 
    } else {
      i = 1020008;
    } 
    u.a(i, paramc);
  }
  
  static void b(e parame, boolean paramBoolean, c paramc) {
    if (parame == e.a && paramBoolean)
      return; 
    u.a(1020003, paramc);
  }
  
  static void b(c paramc) {
    u.a(1020006, paramc);
  }
  
  static void c(e parame, c paramc) {
    u.a(1020062, paramc);
    int i = null.b[parame.ordinal()];
    if (i != 1) {
      if (i != 2) {
        i = 0;
      } else {
        i = 1022017;
      } 
    } else {
      i = 1020072;
    } 
    u.a(i, paramc);
  }
  
  static void c(c paramc) {
    u.a(1020001, paramc);
  }
  
  static void d(c paramc) {
    u.a(1020061, paramc);
  }
  
  static void e(c paramc) {
    u.a(1020064, paramc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */