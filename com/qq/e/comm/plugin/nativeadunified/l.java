package com.qq.e.comm.plugin.nativeadunified;

import android.os.SystemClock;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;

class l {
  private static d a(Exception paramException, String paramString) {
    d d = new d();
    if (paramException != null)
      d.a("ot", paramException.getMessage()); 
    if (paramString != null)
      d.a("rs", paramString); 
    return d;
  }
  
  static void a(int paramInt, c paramc) {
    u.a(1060002, paramInt, paramc);
  }
  
  static void a(c paramc, String paramString, c paramc1) {
    d d = a((Exception)paramc, paramString);
    u.a(1060012, paramc.a(), paramc1, d);
  }
  
  static void a(a parama, c paramc) {
    int i = parama.a();
    if (i == 5018 || i == 5019 || i == 5013) {
      a(i, paramc);
      return;
    } 
    if (i == 5001) {
      try {
        d d = new d(new JSONObject(parama.getMessage()));
      } catch (JSONException jSONException) {
        jSONException = null;
      } 
      u.a(1060006, 0, paramc, (d)jSONException);
      return;
    } 
    u.a(1060004, i, paramc, a((Exception)jSONException, (String)null));
  }
  
  static void a(c paramc) {
    u.a(1060001, paramc);
  }
  
  static void a(c paramc, long paramLong) {
    u.a(1060005, paramc);
    long l1 = SystemClock.elapsedRealtime();
    g g = new g(2030001);
    g.a(paramc);
    g.b(l1 - paramLong);
    u.a(g);
  }
  
  static void a(Boolean paramBoolean, c paramc, int paramInt) {
    if (paramBoolean == null) {
      paramInt = 1060016;
    } else if (paramBoolean.booleanValue()) {
      paramInt = 1060017;
    } else {
      u.a(1060018, paramInt, paramc);
      return;
    } 
    u.a(paramInt, paramc);
  }
  
  static void a(boolean paramBoolean, int paramInt, c paramc) {
    if (paramBoolean) {
      u.a(1060007, paramc);
      return;
    } 
    u.a(1060019, paramInt, paramc);
  }
  
  static void a(boolean paramBoolean, c paramc, int paramInt) {
    if (paramBoolean) {
      d d = new d();
      d.a("cnt", Integer.valueOf(paramInt));
      u.a(1060015, 0, paramc, d);
      return;
    } 
    u.a(1060006, paramInt, paramc);
  }
  
  static void b(c paramc) {
    u.a(1060011, paramc);
  }
  
  static void b(boolean paramBoolean, c paramc, int paramInt) {
    if (paramBoolean) {
      u.a(1060014, paramc);
      return;
    } 
    u.a(1060013, paramInt, paramc);
  }
  
  static void c(c paramc) {
    u.a(1060010, paramc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */