package com.tencent.bugly.yaq.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ax extends j implements Cloneable {
  private static ArrayList<aw> f;
  
  private static Map<String, String> g;
  
  public byte a = 0;
  
  public String b = "";
  
  public String c = "";
  
  public ArrayList<aw> d = null;
  
  public Map<String, String> e = null;
  
  public final void a(h paramh) {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, false);
    this.c = paramh.b(2, false);
    if (f == null) {
      f = new ArrayList<aw>();
      aw aw = new aw();
      f.add(aw);
    } 
    this.d = (ArrayList<aw>)paramh.a(f, 3, false);
    if (g == null) {
      g = new HashMap<String, String>();
      g.put("", "");
    } 
    this.e = (Map<String, String>)paramh.a(g, 4, false);
  }
  
  public final void a(i parami) {
    parami.a(this.a, 0);
    if (this.b != null)
      parami.a(this.b, 1); 
    if (this.c != null)
      parami.a(this.c, 2); 
    if (this.d != null)
      parami.a(this.d, 3); 
    if (this.e != null)
      parami.a(this.e, 4); 
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */