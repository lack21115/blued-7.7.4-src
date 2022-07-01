package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class au extends k implements Cloneable {
  private static ArrayList<at> f;
  
  private static Map<String, String> g;
  
  public byte a = 0;
  
  public String b = "";
  
  public String c = "";
  
  public ArrayList<at> d = null;
  
  public Map<String, String> e = null;
  
  public final void a(i parami) {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.b(1, false);
    this.c = parami.b(2, false);
    if (f == null) {
      f = new ArrayList<at>();
      at at = new at();
      f.add(at);
    } 
    this.d = (ArrayList<at>)parami.<ArrayList<at>>a(f, 3, false);
    if (g == null) {
      g = new HashMap<String, String>();
      g.put("", "");
    } 
    this.e = (Map<String, String>)parami.<Map<String, String>>a(g, 4, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    String str = this.b;
    if (str != null)
      paramj.a(str, 1); 
    str = this.c;
    if (str != null)
      paramj.a(str, 2); 
    ArrayList<at> arrayList = this.d;
    if (arrayList != null)
      paramj.a(arrayList, 3); 
    Map<String, String> map = this.e;
    if (map != null)
      paramj.a(map, 4); 
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */