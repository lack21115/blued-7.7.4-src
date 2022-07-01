package com.tencent.bugly.yaq.proguard;

import java.util.HashMap;
import java.util.Map;

public final class aw extends j {
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
  
  public final void a(h paramh) {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.a(this.b, 1, true);
    this.c = paramh.b(2, false);
    this.d = paramh.b(3, false);
    this.e = paramh.b(4, false);
    this.f = (Map<String, String>)paramh.a(i, 5, false);
    this.g = paramh.b(6, false);
    boolean bool = this.h;
    this.h = paramh.a(7, false);
  }
  
  public final void a(i parami) {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    if (this.c != null)
      parami.a(this.c, 2); 
    if (this.d != null)
      parami.a(this.d, 3); 
    if (this.e != null)
      parami.a(this.e, 4); 
    if (this.f != null)
      parami.a(this.f, 5); 
    if (this.g != null)
      parami.a(this.g, 6); 
    parami.a(this.h, 7);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */