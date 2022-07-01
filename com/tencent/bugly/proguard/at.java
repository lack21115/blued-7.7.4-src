package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class at extends k {
  private static Map<String, String> i = new HashMap<String, String>();
  
  public long a = 0L;
  
  public byte b = 0;
  
  public String c = "";
  
  public String d = "";
  
  public String e = "";
  
  public Map<String, String> f = null;
  
  public String g = "";
  
  public boolean h = true;
  
  static {
    i.put("", "");
  }
  
  public final void a(i parami) {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.a(this.b, 1, true);
    this.c = parami.b(2, false);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = (Map<String, String>)parami.<Map<String, String>>a(i, 5, false);
    this.g = parami.b(6, false);
    boolean bool = this.h;
    this.h = parami.a(7, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    String str2 = this.c;
    if (str2 != null)
      paramj.a(str2, 2); 
    str2 = this.d;
    if (str2 != null)
      paramj.a(str2, 3); 
    str2 = this.e;
    if (str2 != null)
      paramj.a(str2, 4); 
    Map<String, String> map = this.f;
    if (map != null)
      paramj.a(map, 5); 
    String str1 = this.g;
    if (str1 != null)
      paramj.a(str1, 6); 
    paramj.a(this.h, 7);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */