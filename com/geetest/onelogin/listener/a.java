package com.geetest.onelogin.listener;

public class a {
  private static volatile a a;
  
  private a b;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/geetest/onelogin/listener/a.a : Lcom/geetest/onelogin/listener/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/geetest/onelogin/listener/a
    //   8: monitorenter
    //   9: getstatic com/geetest/onelogin/listener/a.a : Lcom/geetest/onelogin/listener/a;
    //   12: ifnonnull -> 25
    //   15: new com/geetest/onelogin/listener/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/geetest/onelogin/listener/a.a : Lcom/geetest/onelogin/listener/a;
    //   25: ldc com/geetest/onelogin/listener/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/geetest/onelogin/listener/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/geetest/onelogin/listener/a.a : Lcom/geetest/onelogin/listener/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(a parama) {
    this.b = parama;
  }
  
  public void b() {
    if (this.b != null)
      this.b = null; 
  }
  
  public void c() {
    a a1 = this.b;
    if (a1 != null)
      a1.a(); 
  }
  
  public void d() {
    a a1 = this.b;
    if (a1 != null)
      a1.b(); 
  }
  
  public void e() {
    a a1 = this.b;
    if (a1 != null)
      a1.c(); 
  }
  
  public void f() {
    a a1 = this.b;
    if (a1 != null)
      a1.d(); 
  }
  
  public static interface a {
    void a();
    
    void b();
    
    void c();
    
    void d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\listener\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */