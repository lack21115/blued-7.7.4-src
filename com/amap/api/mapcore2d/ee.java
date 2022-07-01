package com.amap.api.mapcore2d;

import java.util.HashMap;
import java.util.Map;

@du(a = "file")
public class ee {
  @dv(a = "fname", b = 6)
  private String a;
  
  @dv(a = "md", b = 6)
  private String b;
  
  @dv(a = "sname", b = 6)
  private String c;
  
  @dv(a = "version", b = 6)
  private String d;
  
  @dv(a = "dversion", b = 6)
  private String e;
  
  @dv(a = "status", b = 6)
  private String f;
  
  private ee() {}
  
  public ee(a parama) {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
  }
  
  public static String a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("sname", paramString);
    return dt.a((Map)hashMap);
  }
  
  public static String a(String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("sname", paramString1);
    hashMap.put("dversion", paramString2);
    return dt.a((Map)hashMap);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("fname", paramString1);
    hashMap.put("sname", paramString2);
    hashMap.put("dversion", paramString4);
    hashMap.put("version", paramString3);
    return dt.a((Map)hashMap);
  }
  
  public static String b(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("fname", paramString);
    return dt.a((Map)hashMap);
  }
  
  public static String b(String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("sname", paramString1);
    hashMap.put("status", paramString2);
    return dt.a((Map)hashMap);
  }
  
  public String a() {
    return this.a;
  }
  
  public String b() {
    return this.b;
  }
  
  public String c() {
    return this.c;
  }
  
  public void c(String paramString) {
    this.f = paramString;
  }
  
  public String d() {
    return this.d;
  }
  
  public String e() {
    return this.e;
  }
  
  public String f() {
    return this.f;
  }
  
  public static class a {
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    private String f = "copy";
    
    public a(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1String3;
      this.d = param1String4;
      this.e = param1String5;
    }
    
    public a a(String param1String) {
      this.f = param1String;
      return this;
    }
    
    public ee a() {
      return new ee(this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */