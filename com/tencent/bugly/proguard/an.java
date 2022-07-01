package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class an extends k {
  private static ArrayList<am> A;
  
  private static Map<String, String> B;
  
  private static Map<String, String> C;
  
  private static Map<String, String> v = new HashMap<String, String>();
  
  private static al w = new al();
  
  private static ak x = new ak();
  
  private static ArrayList<ak> y = new ArrayList<ak>();
  
  private static ArrayList<ak> z = new ArrayList<ak>();
  
  public String a = "";
  
  public long b = 0L;
  
  public String c = "";
  
  public String d = "";
  
  public String e = "";
  
  public String f = "";
  
  public String g = "";
  
  public Map<String, String> h = null;
  
  public String i = "";
  
  public al j = null;
  
  public int k = 0;
  
  public String l = "";
  
  public String m = "";
  
  public ak n = null;
  
  public ArrayList<ak> o = null;
  
  public ArrayList<ak> p = null;
  
  public ArrayList<am> q = null;
  
  public Map<String, String> r = null;
  
  public Map<String, String> s = null;
  
  public String t = "";
  
  private boolean u = true;
  
  static {
    ak1 = new ak();
    z.add(ak1);
    A = new ArrayList<am>();
    am am = new am();
    A.add(am);
    B = new HashMap<String, String>();
    B.put("", "");
    C = new HashMap<String, String>();
    C.put("", "");
  }
  
  public final void a(i parami) {
    this.a = parami.b(0, true);
    this.b = parami.a(this.b, 1, true);
    this.c = parami.b(2, true);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = parami.b(5, false);
    this.g = parami.b(6, false);
    this.h = (Map<String, String>)parami.<Map<String, String>>a(v, 7, false);
    this.i = parami.b(8, false);
    this.j = (al)parami.a(w, 9, false);
    this.k = parami.a(this.k, 10, false);
    this.l = parami.b(11, false);
    this.m = parami.b(12, false);
    this.n = (ak)parami.a(x, 13, false);
    this.o = (ArrayList<ak>)parami.<ArrayList<ak>>a(y, 14, false);
    this.p = (ArrayList<ak>)parami.<ArrayList<ak>>a(z, 15, false);
    this.q = (ArrayList<am>)parami.<ArrayList<am>>a(A, 16, false);
    this.r = (Map<String, String>)parami.<Map<String, String>>a(B, 17, false);
    this.s = (Map<String, String>)parami.<Map<String, String>>a(C, 18, false);
    this.t = parami.b(19, false);
    boolean bool = this.u;
    this.u = parami.a(20, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
    String str4 = this.d;
    if (str4 != null)
      paramj.a(str4, 3); 
    str4 = this.e;
    if (str4 != null)
      paramj.a(str4, 4); 
    str4 = this.f;
    if (str4 != null)
      paramj.a(str4, 5); 
    str4 = this.g;
    if (str4 != null)
      paramj.a(str4, 6); 
    Map<String, String> map2 = this.h;
    if (map2 != null)
      paramj.a(map2, 7); 
    String str3 = this.i;
    if (str3 != null)
      paramj.a(str3, 8); 
    al al1 = this.j;
    if (al1 != null)
      paramj.a(al1, 9); 
    paramj.a(this.k, 10);
    String str2 = this.l;
    if (str2 != null)
      paramj.a(str2, 11); 
    str2 = this.m;
    if (str2 != null)
      paramj.a(str2, 12); 
    ak ak1 = this.n;
    if (ak1 != null)
      paramj.a(ak1, 13); 
    ArrayList<ak> arrayList1 = this.o;
    if (arrayList1 != null)
      paramj.a(arrayList1, 14); 
    arrayList1 = this.p;
    if (arrayList1 != null)
      paramj.a(arrayList1, 15); 
    ArrayList<am> arrayList = this.q;
    if (arrayList != null)
      paramj.a(arrayList, 16); 
    Map<String, String> map1 = this.r;
    if (map1 != null)
      paramj.a(map1, 17); 
    map1 = this.s;
    if (map1 != null)
      paramj.a(map1, 18); 
    String str1 = this.t;
    if (str1 != null)
      paramj.a(str1, 19); 
    paramj.a(this.u, 20);
  }
  
  static {
    v.put("", "");
  }
  
  static {
    ak ak1 = new ak();
    y.add(ak1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */