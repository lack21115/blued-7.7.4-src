package com.cmic.sso.sdk.utils;

public class g {
  private static g a;
  
  private a b;
  
  public static g a() {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/utils/g.a : Lcom/cmic/sso/sdk/utils/g;
    //   3: ifnonnull -> 37
    //   6: ldc com/cmic/sso/sdk/utils/g
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/utils/g.a : Lcom/cmic/sso/sdk/utils/g;
    //   12: ifnonnull -> 25
    //   15: new com/cmic/sso/sdk/utils/g
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/cmic/sso/sdk/utils/g.a : Lcom/cmic/sso/sdk/utils/g;
    //   25: ldc com/cmic/sso/sdk/utils/g
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/cmic/sso/sdk/utils/g
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/cmic/sso/sdk/utils/g.a : Lcom/cmic/sso/sdk/utils/g;
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
  
  public a b() {
    return this.b;
  }
  
  public void c() {
    if (this.b != null)
      this.b = null; 
  }
  
  public static interface a {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */