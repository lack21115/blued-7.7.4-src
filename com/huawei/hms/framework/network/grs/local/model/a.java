package com.huawei.hms.framework.network.grs.local.model;

import java.util.HashMap;
import java.util.Map;

public class a {
  private String a;
  
  private long b;
  
  private Map<String, c> c = new HashMap<String, c>(16);
  
  public c a(String paramString) {
    return this.c.get(paramString);
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(long paramLong) {
    this.b = paramLong;
  }
  
  public void a(String paramString, c paramc) {
    this.c.put(paramString, paramc);
  }
  
  public Map<String, c> b() {
    return this.c;
  }
  
  public void b(String paramString) {
    this.a = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\local\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */