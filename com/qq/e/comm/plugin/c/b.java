package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.c.a.b;
import com.qq.e.comm.plugin.util.y;
import org.json.JSONObject;
import yaq.gdtadv;

class b implements b, k {
  private f a;
  
  private j b;
  
  private String c;
  
  private int d;
  
  private a e;
  
  private c a(a parama) {
    return (c)gdtadv.getobjresult(211, 0, new Object[] { this, parama });
  }
  
  private String a(String paramString, int paramInt) {
    return (String)gdtadv.getobjresult(214, 0, new Object[] { this, paramString, Integer.valueOf(paramInt) });
  }
  
  private void d() {
    gdtadv.getVresult(218, 0, new Object[] { this });
  }
  
  private void e() {
    gdtadv.getVresult(220, 0, new Object[] { this });
  }
  
  private a f() {
    return (a)gdtadv.getobjresult(221, 0, new Object[] { this });
  }
  
  private a g() {
    return (a)gdtadv.getobjresult(222, 0, new Object[] { this });
  }
  
  private a h() {
    return (a)gdtadv.getobjresult(223, 0, new Object[] { this });
  }
  
  private boolean i() {
    return gdtadv.getZresult(224, 0, new Object[] { this });
  }
  
  private c j() {
    return (c)gdtadv.getobjresult(225, 0, new Object[] { this });
  }
  
  public void a() {
    gdtadv.getVresult(226, 0, new Object[] { this });
  }
  
  public boolean a(f paramf) {
    return gdtadv.getZresult(227, 0, new Object[] { this, paramf });
  }
  
  public boolean a(f paramf, a parama) {
    return gdtadv.getZresult(228, 0, new Object[] { this, paramf, parama });
  }
  
  public void b() {
    gdtadv.getVresult(229, 0, new Object[] { this });
  }
  
  public void c() {
    gdtadv.getVresult(230, 0, new Object[] { this });
  }
  
  static class a {
    private final String a;
    
    private final String b;
    
    public a(String param1String1, String param1String2) {
      this.a = param1String1;
      this.b = param1String2;
    }
    
    public a(JSONObject param1JSONObject) {
      this.a = param1JSONObject.optString("name");
      this.b = param1JSONObject.optString("iconurl");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */