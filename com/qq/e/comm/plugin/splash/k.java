package com.qq.e.comm.plugin.splash;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.q;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

class k {
  private static d a(String paramString1, Exception paramException, boolean paramBoolean, String paramString2) {
    d d = new d();
    if (!StringUtil.isEmpty(paramString1))
      d.a("rs", paramString1); 
    if (!StringUtil.isEmpty(paramString2))
      d.a("vu", paramString2); 
    if (paramBoolean)
      d.a("nt", Integer.valueOf(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue())); 
    if (paramException != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramException.getClass().getName());
      stringBuilder.append(":");
      stringBuilder.append(paramException.getMessage());
      d.a("ot", stringBuilder.toString());
    } 
    return d;
  }
  
  static void a(int paramInt, b.b paramb, boolean paramBoolean, c paramc) {
    d d = new d();
    d.a("fd", Integer.valueOf(paramInt));
    if (paramb != b.b.a) {
      paramInt = 3;
    } else if (paramBoolean) {
      paramInt = 2;
    } else {
      paramInt = 1;
    } 
    u.a(1010062, paramInt, paramc, d);
  }
  
  static void a(int paramInt, c paramc, a parama) {
    if (paramInt == 0) {
      u.a(1010005, paramc);
      return;
    } 
    if (paramInt == 5001) {
      try {
        d d = new d(new JSONObject(parama.getMessage()));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      u.a(1010007, 0, paramc, (d)jSONException);
      return;
    } 
    u.a(1010012, paramInt, paramc);
  }
  
  static void a(int paramInt, c paramc, d paramd) {
    u.a(1010061, paramInt, paramc, paramd);
  }
  
  static void a(int paramInt, c paramc, Exception paramException) {
    d d;
    if (paramInt == 0) {
      u.a(1010032, paramc);
      return;
    } 
    int i = paramInt;
    if (paramInt < 1000)
      i = 3005; 
    Exception exception = null;
    if (paramException == null) {
      paramException = exception;
    } else {
      d = a((String)null, paramException, false, (String)null);
    } 
    u.a(1010004, i, paramc, d);
  }
  
  static void a(long paramLong, int paramInt, String paramString, c paramc) {
    if (paramLong > 0L) {
      long l = System.currentTimeMillis();
      g g = new g(2010002);
      g.b(l - paramLong);
      g.b(paramInt);
      g.a(paramc);
      g.a(a(paramString, (Exception)null, true, (String)null));
      u.a(g);
    } 
  }
  
  static void a(long paramLong, c paramc) {
    g g = new g(2010004);
    g.b(System.currentTimeMillis() - paramLong);
    g.a(paramc);
    u.a(g);
  }
  
  static void a(q paramq, c paramc) {
    int i = null.a[paramq.ordinal()];
    if (i != 1) {
      if (i != 2)
        return; 
      i = 1010039;
    } else {
      i = 1010038;
    } 
    u.a(i, paramc);
  }
  
  static void a(b.b paramb1, b.b paramb2, c paramc, int paramInt, Exception paramException, String paramString1, String paramString2) {
    if (paramb1 != b.b.a) {
      b(paramb1, paramb2, paramc, paramInt, paramException, paramString1, paramString2);
      return;
    } 
    if (paramb2 == b.b.c) {
      u.a(1010016, paramc);
      return;
    } 
    u.a(1010015, paramInt, paramc, a(paramString1, paramException, true, (String)null));
  }
  
  static void a(c paramc) {
    u.a(1010036, paramc);
  }
  
  static void a(Boolean paramBoolean, int paramInt, c paramc) {
    if (paramBoolean == null) {
      paramInt = 1010059;
    } else if (paramBoolean.booleanValue()) {
      paramInt = 1010046;
    } else {
      u.a(1010060, paramInt, paramc);
      return;
    } 
    u.a(paramInt, paramc);
  }
  
  static void a(Boolean paramBoolean, int paramInt, c paramc, Exception paramException) {
    if (paramBoolean == null) {
      paramInt = 1010037;
    } else if (paramBoolean.booleanValue()) {
      paramInt = 1010023;
    } else {
      u.a(1010022, paramInt, paramc, a((String)null, paramException, false, (String)null));
      return;
    } 
    u.a(paramInt, paramc);
  }
  
  static void a(Boolean paramBoolean, int paramInt, c paramc, String paramString, Exception paramException) {
    d d;
    int i;
    if (paramBoolean == null) {
      i = 1010063;
    } else if (paramBoolean.booleanValue()) {
      i = 1010049;
    } else {
      i = 1010050;
    } 
    paramBoolean = null;
    if (paramException != null)
      d = a(paramString, paramException, false, (String)null); 
    u.a(i, paramInt, paramc, d);
  }
  
  static void a(Boolean paramBoolean, q paramq, c paramc) {
    byte b;
    int i;
    if (paramBoolean == null) {
      u.a(1010403, paramc);
      return;
    } 
    if (paramBoolean.booleanValue()) {
      i = 10110402;
    } else {
      i = 1010401;
    } 
    if (paramq == q.a) {
      b = 0;
    } else if (paramq == q.b) {
      b = 1;
    } else {
      b = 100;
    } 
    u.a(i, b, paramc);
  }
  
  static void a(Boolean paramBoolean, boolean paramBoolean1, c paramc) {
    int i;
    if (paramBoolean == null) {
      u.a(1010064, paramBoolean1 ^ true, paramc);
      return;
    } 
    if (paramBoolean.booleanValue()) {
      i = 1010026;
    } else {
      i = 1010028;
    } 
    u.a(i, paramc);
  }
  
  static void a(String paramString, int paramInt, Exception paramException, c paramc) {
    u.a(1010030, paramInt, paramc, a((String)null, paramException, true, paramString));
  }
  
  static void a(boolean paramBoolean, c paramc) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  static void b(long paramLong, c paramc) {
    u.a(1010027, 0, paramc);
    long l = 0L;
    if (paramLong <= 0L) {
      paramLong = l;
    } else {
      paramLong = System.currentTimeMillis() - paramLong;
    } 
    g g = new g(2010005);
    g.b(paramLong);
    g.a(paramc);
    u.a(g);
  }
  
  static void b(q paramq, c paramc) {
    int i = null.a[paramq.ordinal()];
    if (i != 1) {
      if (i != 2)
        return; 
      i = 1010048;
    } else {
      i = 1010047;
    } 
    u.a(i, paramc);
  }
  
  static void b(b.b paramb1, b.b paramb2, c paramc, int paramInt, Exception paramException, String paramString1, String paramString2) {
    if (paramb1 != b.b.b) {
      d d;
      int i;
      if (paramb2 == b.b.b)
        return; 
      if (paramb1 == b.b.c) {
        u.a(1010040, paramc);
        if (paramb2 == b.b.d) {
          i = 1010043;
          d = a(paramString1, paramException, true, (String)null);
        } else {
          return;
        } 
      } else if (paramb2 == b.b.c) {
        i = 1010044;
        d = a((String)null, paramException, true, paramString2);
      } else {
        i = 1010045;
        d = a(paramString1, paramException, true, paramString2);
      } 
      u.a(i, paramInt, paramc, d);
    } 
  }
  
  static void c(long paramLong, c paramc) {
    long l = 0L;
    if (paramLong <= 0L) {
      paramLong = l;
    } else {
      paramLong = System.currentTimeMillis() - paramLong;
    } 
    g g = new g(2010006);
    g.b(paramLong);
    g.a(paramc);
    u.a(g);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */