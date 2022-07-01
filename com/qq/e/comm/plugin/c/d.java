package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.util.ak;

class d {
  public static l a() {
    b b = new b();
    b.a();
    return b;
  }
  
  public static l a(f paramf) {
    a a;
    d d1;
    if (paramf.g) {
      a = new a();
    } else if (((f)a).h != null && ((f)a).h.booleanValue()) {
      f f1 = new f();
    } else {
      d1 = new d();
    } 
    String str = d.class.getSimpleName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buildChain = ");
    stringBuilder.append(d1.getClass().getSimpleName());
    ak.a(str, stringBuilder.toString());
    d1.a();
    return d1;
  }
  
  public static l b() {
    e e = new e();
    e.a();
    return e;
  }
  
  public static l c() {
    c c = new c();
    c.a();
    return c;
  }
  
  static class a extends a {
    private a() {}
    
    public void a() {
      this.a.add(r.class);
      this.a.add(n.class);
      this.a.add(p.class);
      this.a.add(i.class);
      this.a.add(q.class);
      this.a.add(b.class);
    }
  }
  
  static class b extends a {
    private b() {}
    
    public void a() {
      this.a.add(s.class);
      this.a.add(h.class);
    }
  }
  
  static class c extends a {
    private c() {}
    
    public void a() {
      this.a.add(m.class);
      this.a.add(q.class);
      this.a.add(b.class);
    }
  }
  
  static class d extends a {
    private d() {}
    
    public void a() {
      this.a.add(r.class);
      this.a.add(n.class);
      this.a.add(j.class);
      this.a.add(o.class);
      this.a.add(i.class);
    }
  }
  
  static class e extends a {
    private e() {}
    
    public void a() {
      this.a.add(m.class);
      this.a.add(n.class);
      this.a.add(p.class);
    }
  }
  
  static class f extends a {
    private f() {}
    
    public void a() {
      this.a.add(r.class);
      this.a.add(j.class);
      this.a.add(i.class);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */