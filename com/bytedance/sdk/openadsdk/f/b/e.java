package com.bytedance.sdk.openadsdk.f.b;

import com.bytedance.sdk.openadsdk.f.a.b;

class e implements a {
  private static volatile e a;
  
  public static e c() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/f/b/e.a : Lcom/bytedance/sdk/openadsdk/f/b/e;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/f/b/e
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/f/b/e.a : Lcom/bytedance/sdk/openadsdk/f/b/e;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/f/b/e
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/f/b/e.a : Lcom/bytedance/sdk/openadsdk/f/b/e;
    //   25: ldc com/bytedance/sdk/openadsdk/f/b/e
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/f/b/e
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/f/b/e.a : Lcom/bytedance/sdk/openadsdk/f/b/e;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a() {}
  
  public void a(b paramb) {}
  
  public void a(b paramb, boolean paramBoolean) {}
  
  public void b() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\f\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */