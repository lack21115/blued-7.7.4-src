package com.qq.e.comm.plugin.util;

import com.qq.e.comm.plugin.ab.a.a;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;

public class v {
  private static d a(Exception paramException, String paramString) {
    d d = new d();
    if (paramException != null)
      d.a("ot", paramException.getMessage()); 
    if (paramString != null)
      d.a("rs", paramString); 
    return d;
  }
  
  public static void a(e parame, c paramc) {
    int i;
    if (parame == e.n) {
      i = 1031001;
    } else if (parame == e.v) {
      i = 1030003;
    } else {
      return;
    } 
    u.a(i, paramc);
  }
  
  public static void a(e parame, c paramc, String paramString, int paramInt, Exception paramException) {
    int i;
    if (parame == e.v) {
      i = 1030027;
    } else if (parame == e.n) {
      i = 1031006;
    } else {
      return;
    } 
    u.a(i, paramInt, paramc, a(paramException, paramString));
  }
  
  public static void a(e parame, boolean paramBoolean, int paramInt, c paramc) {
    int i;
    if (parame == e.v) {
      i = 1030024;
    } else if (parame == e.n) {
      if (paramBoolean) {
        i = 1031005;
      } else {
        i = 1031010;
      } 
    } else {
      return;
    } 
    u.a(i, paramInt, paramc);
  }
  
  public static void a(e parame, boolean paramBoolean, c paramc) {
    int i;
    if (parame == e.v) {
      i = 1030004;
    } else if (parame == e.n) {
      if (paramBoolean) {
        i = 1031004;
      } else {
        i = 1031009;
      } 
    } else {
      return;
    } 
    u.a(i, paramc);
  }
  
  public static void a(e parame, boolean paramBoolean, c paramc, int paramInt, Exception paramException) {
    d d;
    int i;
    if (parame == e.v) {
      if (paramBoolean) {
        i = 1030009;
      } else {
        i = 1030007;
      } 
    } else if (parame == e.n) {
      if (paramBoolean) {
        i = 1031007;
      } else {
        i = 1031008;
      } 
    } else {
      return;
    } 
    parame = null;
    if (!paramBoolean)
      d = a(paramException, (String)null); 
    u.a(i, paramInt, paramc, d);
  }
  
  public static void a(a parama, c paramc) {
    int i = parama.a();
    if (i == 5018 || i == 5019 || i == 5013) {
      u.a(1030025, i, paramc);
      return;
    } 
    if (i == 5001) {
      try {
        d d = new d(new JSONObject(parama.getMessage()));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      u.a(1030015, 0, paramc, (d)jSONException);
      return;
    } 
    u.a(1030016, i, paramc, a((Exception)jSONException, (String)null));
  }
  
  public static void a(c paramc) {
    u.a(1030013, paramc);
  }
  
  public static void a(c paramc, int paramInt) {
    u.a(1030015, paramInt, paramc);
  }
  
  public static void a(Boolean paramBoolean, c paramc, int paramInt, Exception paramException) {
    d d;
    int i;
    Boolean bool = null;
    if (paramBoolean == null) {
      i = 1030028;
      paramBoolean = bool;
    } else if (paramBoolean.booleanValue()) {
      i = 1030010;
      paramBoolean = bool;
    } else {
      i = 1030011;
      d = a(paramException, (String)null);
    } 
    u.a(i, paramInt, paramc, d);
  }
  
  public static void a(Boolean paramBoolean, c paramc, a parama) {
    d d;
    int i;
    Boolean bool = null;
    if (paramBoolean == null) {
      i = 1031013;
      paramBoolean = bool;
    } else if (paramBoolean.booleanValue()) {
      i = 1031002;
      paramBoolean = bool;
    } else {
      i = 1031003;
      d = new d();
      d.a("ot", parama.toString());
    } 
    u.a(i, 0, paramc, d);
  }
  
  public static void a(boolean paramBoolean, c paramc) {
    int i;
    if (paramBoolean) {
      i = 1030020;
    } else {
      i = 1030017;
    } 
    u.a(i, paramc);
  }
  
  public static void b(c paramc) {
    u.a(1031011, paramc);
  }
  
  public static void b(boolean paramBoolean, c paramc) {
    int i;
    if (paramBoolean) {
      i = 1030023;
    } else {
      i = 1030022;
    } 
    u.a(i, paramc);
  }
  
  public static void c(c paramc) {
    u.a(1030001, paramc);
  }
  
  public static void d(c paramc) {
    u.a(1030002, paramc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */