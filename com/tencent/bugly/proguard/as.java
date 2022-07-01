package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class as extends k implements Cloneable {
  private static ar m;
  
  private static Map<String, String> n;
  
  public boolean a = true;
  
  public boolean b = true;
  
  public boolean c = true;
  
  public String d = "";
  
  public String e = "";
  
  public ar f = null;
  
  public Map<String, String> g = null;
  
  public long h = 0L;
  
  public int i = 0;
  
  private String j = "";
  
  private String k = "";
  
  private int l = 0;
  
  static {
    m = new ar();
    n = new HashMap<String, String>();
    n.put("", "");
  }
  
  public final void a(i parami) {
    boolean bool = this.a;
    this.a = parami.a(0, true);
    bool = this.b;
    this.b = parami.a(1, true);
    bool = this.c;
    this.c = parami.a(2, true);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = (ar)parami.a(m, 5, false);
    this.g = (Map<String, String>)parami.<Map<String, String>>a(n, 6, false);
    this.h = parami.a(this.h, 7, false);
    this.j = parami.b(8, false);
    this.k = parami.b(9, false);
    this.l = parami.a(this.l, 10, false);
    this.i = parami.a(this.i, 11, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
    String str2 = this.d;
    if (str2 != null)
      paramj.a(str2, 3); 
    str2 = this.e;
    if (str2 != null)
      paramj.a(str2, 4); 
    ar ar1 = this.f;
    if (ar1 != null)
      paramj.a(ar1, 5); 
    Map<String, String> map = this.g;
    if (map != null)
      paramj.a(map, 6); 
    paramj.a(this.h, 7);
    String str1 = this.j;
    if (str1 != null)
      paramj.a(str1, 8); 
    str1 = this.k;
    if (str1 != null)
      paramj.a(str1, 9); 
    paramj.a(this.l, 10);
    paramj.a(this.i, 11);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {
    h h = new h(paramStringBuilder, paramInt);
    h.a(this.a, "enable");
    h.a(this.b, "enableUserInfo");
    h.a(this.c, "enableQuery");
    h.a(this.d, "url");
    h.a(this.e, "expUrl");
    h.a(this.f, "security");
    h.a(this.g, "valueMap");
    h.a(this.h, "strategylastUpdateTime");
    h.a(this.j, "httpsUrl");
    h.a(this.k, "httpsExpUrl");
    h.a(this.l, "eventRecordCount");
    h.a(this.i, "eventTimeInterval");
  }
  
  public final Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      if (o)
        return null; 
      throw new AssertionError();
    } 
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    paramObject = paramObject;
    return (l.a(this.a, ((as)paramObject).a) && l.a(this.b, ((as)paramObject).b) && l.a(this.c, ((as)paramObject).c) && l.a(this.d, ((as)paramObject).d) && l.a(this.e, ((as)paramObject).e) && l.a(this.f, ((as)paramObject).f) && l.a(this.g, ((as)paramObject).g) && l.a(this.h, ((as)paramObject).h) && l.a(this.j, ((as)paramObject).j) && l.a(this.k, ((as)paramObject).k) && l.a(this.l, ((as)paramObject).l) && l.a(this.i, ((as)paramObject).i));
  }
  
  public final int hashCode() {
    try {
      throw new Exception("Need define key first!");
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */