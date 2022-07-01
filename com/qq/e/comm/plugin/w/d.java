package com.qq.e.comm.plugin.w;

import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.services.RetCodeService;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import yaq.gdtadv;

public class d {
  @Deprecated
  private static final Pattern a = Pattern.compile("^http\\://v\\.gdt\\.qq\\.com/gdt_stats\\.fcg\\?viewid=([^&]*).*");
  
  private static final Pattern b = Pattern.compile(".*[?&]viewid=([^&]*).*");
  
  private static String a() {
    return (String)gdtadv.getobjresult(55, 1, new Object[0]);
  }
  
  private static String a(String paramString) {
    return (String)gdtadv.getobjresult(56, 1, new Object[] { paramString });
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, b paramb, b paramb1) {
    gdtadv.getVresult(57, 1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), paramString, paramb, paramb1 });
  }
  
  public static void a(a parama, List<String> paramList, b paramb, b paramb1) {
    gdtadv.getVresult(58, 1, new Object[] { parama, paramList, paramb, paramb1 });
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, b paramb, b paramb1) {
    gdtadv.getVresult(59, 1, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramb, paramb1 });
  }
  
  private static void b(List<String> paramList, String paramString1, String paramString2, m paramm, int paramInt1, int paramInt2, a parama) {
    gdtadv.getVresult(61, 1, new Object[] { paramList, paramString1, paramString2, paramm, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), parama });
  }
  
  public static class a {
    private int a;
    
    private Map<String, Object> b;
    
    public int a() {
      return this.a;
    }
    
    public void a(int param1Int) {
      this.a = param1Int;
    }
    
    public void a(Map<String, Object> param1Map) {
      this.b = param1Map;
    }
    
    public Map<String, Object> b() {
      return this.b;
    }
  }
  
  public static interface b {
    void a();
    
    void a(int param1Int, Exception param1Exception);
  }
  
  static class c implements com.qq.e.comm.plugin.t.b {
    final List<String> a;
    
    final String b;
    
    final e c;
    
    final String d;
    
    final m e;
    
    final long f;
    
    final d.a g;
    
    final d.b h;
    
    c(List<String> param1List, String param1String1, e param1e, String param1String2, m param1m, d.a param1a, long param1Long, d.b param1b) {
      this.a = param1List;
      this.b = param1String1;
      this.c = param1e;
      this.d = param1String2;
      this.e = param1m;
      this.g = param1a;
      this.f = param1Long;
      this.h = param1b;
    }
    
    public void a(e param1e, f param1f) {
      int i;
      byte b1;
      if (param1f == null) {
        i = 0;
      } else {
        i = param1f.e();
      } 
      if (i == 200 || i == 204) {
        d.a(this.a, this.b, "", this.e, (int)(System.currentTimeMillis() - this.f), i, this.g);
        d.b b2 = this.h;
        if (b2 != null)
          b2.a(); 
      } else {
        d.a(this.a, this.b, "HttpStatus error", this.e, (int)(System.currentTimeMillis() - this.f), i, this.g);
        d.b b2 = this.h;
        if (b2 != null)
          b2.a(i, null); 
      } 
      if (i == 204) {
        b1 = 1;
      } else {
        b1 = 0;
      } 
      RetCodeService retCodeService = RetCodeService.getInstance();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("gdt_stats.fcg?");
      stringBuilder.append(this.c);
      String str = stringBuilder.toString();
      if (b1)
        i = 0; 
      int j = (int)(System.currentTimeMillis() - this.f);
      if (b1) {
        b1 = 1;
      } else {
        b1 = 2;
      } 
      retCodeService.send(new RetCodeService.RetCodeInfo("v.gdt.qq.com", str, "-", i, j, 0, 0, b1));
    }
    
    public void a(Exception param1Exception) {
      d.a(this.a, this.b, param1Exception.getMessage(), this.e, (int)(System.currentTimeMillis() - this.f), -1, this.g);
      d.b b1 = this.h;
      if (b1 != null)
        b1.a(0, param1Exception); 
      RetCodeService retCodeService = RetCodeService.getInstance();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("gdt_stats.fcg?");
      stringBuilder.append(this.c);
      retCodeService.send(new RetCodeService.RetCodeInfo("v.gdt.qq.com", stringBuilder.toString(), "-", 1, (int)(System.currentTimeMillis() - this.f), 0, 0, 2));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */