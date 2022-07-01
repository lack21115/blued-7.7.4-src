package com.qq.e.comm.plugin.b;

import com.qq.e.comm.plugin.ab.a.a;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private static d a(Exception paramException, String paramString) {
    d d = new d();
    if (paramException != null)
      d.a("ot", paramException.getMessage()); 
    if (paramString != null)
      d.a("rs", paramString); 
    return d;
  }
  
  static void a(a parama, c paramc) {
    int i = parama.a();
    if (i == 5018 || i == 5019 || i == 5013) {
      u.a(1050002, i, paramc);
      return;
    } 
    if (i == 5001) {
      try {
        d d = new d(new JSONObject(parama.getMessage()));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      u.a(1050006, 0, paramc, (d)jSONException);
      return;
    } 
    u.a(1050004, i, paramc, a((Exception)jSONException, (String)null));
  }
  
  public static void a(c paramc) {
    u.a(1050011, paramc);
  }
  
  public static void a(Boolean paramBoolean, c paramc, int paramInt, Exception paramException) {
    d d;
    int i;
    Boolean bool = null;
    if (paramBoolean == null) {
      i = 1050016;
      paramBoolean = bool;
    } else if (paramBoolean.booleanValue()) {
      i = 1050017;
      paramBoolean = bool;
    } else {
      i = 1050018;
      d = a(paramException, (String)null);
    } 
    u.a(i, paramInt, paramc, d);
  }
  
  public static void a(Boolean paramBoolean, c paramc, a parama) {
    d d;
    int i;
    Boolean bool = null;
    if (paramBoolean == null) {
      i = 1050007;
      paramBoolean = bool;
    } else if (paramBoolean.booleanValue()) {
      i = 1050009;
      paramBoolean = bool;
    } else {
      i = 1050008;
      d = new d();
      d.a("ot", parama.toString());
    } 
    u.a(i, 0, paramc, d);
  }
  
  static void a(boolean paramBoolean, c paramc, int paramInt) {
    if (paramBoolean) {
      u.a(1050015, paramc);
      return;
    } 
    u.a(1050006, paramInt, paramc);
  }
  
  static void b(c paramc) {
    u.a(1050001, paramc);
  }
  
  static void c(c paramc) {
    u.a(1050005, paramc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */