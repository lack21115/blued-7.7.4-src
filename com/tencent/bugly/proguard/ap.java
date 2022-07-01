package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class ap extends k {
  private static byte[] y;
  
  private static Map<String, String> z = new HashMap<String, String>();
  
  public int a = 0;
  
  public String b = "";
  
  public String c = "";
  
  public String d = "";
  
  public String e = "";
  
  public String f = "";
  
  public int g = 0;
  
  public byte[] h = null;
  
  public String i = "";
  
  public String j = "";
  
  public Map<String, String> k = null;
  
  public String l = "";
  
  public long m = 0L;
  
  public String n = "";
  
  public String o = "";
  
  public String p = "";
  
  public long q = 0L;
  
  public String r = "";
  
  public String s = "";
  
  public String t = "";
  
  public String u = "";
  
  public String v = "";
  
  public String w = "";
  
  private String x = "";
  
  static {
    z.put("", "");
  }
  
  public final void a(i parami) {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.b(1, true);
    this.c = parami.b(2, true);
    this.d = parami.b(3, true);
    this.e = parami.b(4, false);
    this.f = parami.b(5, true);
    this.g = parami.a(this.g, 6, true);
    byte[] arrayOfByte = y;
    this.h = parami.c(7, true);
    this.i = parami.b(8, false);
    this.j = parami.b(9, false);
    this.k = (Map<String, String>)parami.<Map<String, String>>a(z, 10, false);
    this.l = parami.b(11, false);
    this.m = parami.a(this.m, 12, false);
    this.n = parami.b(13, false);
    this.o = parami.b(14, false);
    this.p = parami.b(15, false);
    this.q = parami.a(this.q, 16, false);
    this.r = parami.b(17, false);
    this.s = parami.b(18, false);
    this.t = parami.b(19, false);
    this.u = parami.b(20, false);
    this.v = parami.b(21, false);
    this.w = parami.b(22, false);
    this.x = parami.b(23, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
    paramj.a(this.d, 3);
    String str2 = this.e;
    if (str2 != null)
      paramj.a(str2, 4); 
    paramj.a(this.f, 5);
    paramj.a(this.g, 6);
    paramj.a(this.h, 7);
    str2 = this.i;
    if (str2 != null)
      paramj.a(str2, 8); 
    str2 = this.j;
    if (str2 != null)
      paramj.a(str2, 9); 
    Map<String, String> map = this.k;
    if (map != null)
      paramj.a(map, 10); 
    String str1 = this.l;
    if (str1 != null)
      paramj.a(str1, 11); 
    paramj.a(this.m, 12);
    str1 = this.n;
    if (str1 != null)
      paramj.a(str1, 13); 
    str1 = this.o;
    if (str1 != null)
      paramj.a(str1, 14); 
    str1 = this.p;
    if (str1 != null)
      paramj.a(str1, 15); 
    paramj.a(this.q, 16);
    str1 = this.r;
    if (str1 != null)
      paramj.a(str1, 17); 
    str1 = this.s;
    if (str1 != null)
      paramj.a(str1, 18); 
    str1 = this.t;
    if (str1 != null)
      paramj.a(str1, 19); 
    str1 = this.u;
    if (str1 != null)
      paramj.a(str1, 20); 
    str1 = this.v;
    if (str1 != null)
      paramj.a(str1, 21); 
    str1 = this.w;
    if (str1 != null)
      paramj.a(str1, 22); 
    str1 = this.x;
    if (str1 != null)
      paramj.a(str1, 23); 
  }
  
  static {
    byte[] arrayOfByte = new byte[1];
    y = arrayOfByte;
    arrayOfByte[0] = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */