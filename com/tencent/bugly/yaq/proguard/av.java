package com.tencent.bugly.yaq.proguard;

import com.tencent.bugly.yaq.crashreport.crash.jni.b;
import java.util.HashMap;
import java.util.Map;

public final class av extends j implements Cloneable {
  private static au m;
  
  private static Map<String, String> n;
  
  public boolean a = true;
  
  public boolean b = true;
  
  public boolean c = true;
  
  public String d = "";
  
  public String e = "";
  
  public au f = null;
  
  public Map<String, String> g = null;
  
  public long h = 0L;
  
  public int i = 0;
  
  private String j = "";
  
  private String k = "";
  
  private int l = 0;
  
  static {
    boolean bool;
    if (!av.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    o = bool;
    m = new au();
    n = new HashMap<String, String>();
    n.put("", "");
  }
  
  public final void a(h paramh) {
    boolean bool = this.a;
    this.a = paramh.a(0, true);
    bool = this.b;
    this.b = paramh.a(1, true);
    bool = this.c;
    this.c = paramh.a(2, true);
    this.d = paramh.b(3, false);
    this.e = paramh.b(4, false);
    this.f = (au)paramh.a(m, 5, false);
    this.g = (Map<String, String>)paramh.a(n, 6, false);
    this.h = paramh.a(this.h, 7, false);
    this.j = paramh.b(8, false);
    this.k = paramh.b(9, false);
    this.l = paramh.a(this.l, 10, false);
    this.i = paramh.a(this.i, 11, false);
  }
  
  public final void a(i parami) {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
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
    if (this.j != null)
      parami.a(this.j, 8); 
    if (this.k != null)
      parami.a(this.k, 9); 
    parami.a(this.l, 10);
    parami.a(this.i, 11);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {
    b b = new b(paramStringBuilder, paramInt);
    b.a(this.a, "enable");
    b.a(this.b, "enableUserInfo");
    b.a(this.c, "enableQuery");
    b.b(this.d, "url");
    b.b(this.e, "expUrl");
    b.a(this.f, "security");
    b.a(this.g, "valueMap");
    b.a(this.h, "strategylastUpdateTime");
    b.b(this.j, "httpsUrl");
    b.b(this.k, "httpsExpUrl");
    b.a(this.l, "eventRecordCount");
    b.a(this.i, "eventTimeInterval");
  }
  
  public final Object clone() {
    Object object = null;
    try {
      Object object1 = super.clone();
      object = object1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {}
    return object;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject != null) {
      paramObject = paramObject;
      if (k.a(this.a, ((av)paramObject).a) && k.a(this.b, ((av)paramObject).b) && k.a(this.c, ((av)paramObject).c) && k.a(this.d, ((av)paramObject).d) && k.a(this.e, ((av)paramObject).e) && k.a(this.f, ((av)paramObject).f) && k.a(this.g, ((av)paramObject).g) && k.a(this.h, ((av)paramObject).h) && k.a(this.j, ((av)paramObject).j) && k.a(this.k, ((av)paramObject).k) && k.a(this.l, ((av)paramObject).l) && k.a(this.i, ((av)paramObject).i))
        return true; 
    } 
    return false;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */