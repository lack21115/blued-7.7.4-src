package com.geetest.onelogin.a;

import java.util.HashMap;
import java.util.Map;

public class f {
  private String a;
  
  private String b;
  
  private boolean c;
  
  private Map<String, e> d = new HashMap<String, e>();
  
  private String e;
  
  public String a() {
    return this.a;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(String paramString, e parame) {
    this.d.put(paramString, parame);
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public boolean b() {
    return this.c;
  }
  
  public int c() {
    return this.d.size();
  }
  
  public e c(String paramString) {
    return this.d.containsKey(paramString) ? this.d.get(paramString) : null;
  }
  
  public String d() {
    return this.e;
  }
  
  public void d(String paramString) {
    this.e = paramString;
  }
  
  public void e() {
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */