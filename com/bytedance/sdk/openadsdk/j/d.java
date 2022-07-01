package com.bytedance.sdk.openadsdk.j;

import java.util.List;

class d implements a {
  private static volatile d a;
  
  public static d b() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/j/d.a : Lcom/bytedance/sdk/openadsdk/j/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/j/d
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/j/d.a : Lcom/bytedance/sdk/openadsdk/j/d;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/j/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/j/d.a : Lcom/bytedance/sdk/openadsdk/j/d;
    //   25: ldc com/bytedance/sdk/openadsdk/j/d
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/j/d
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/j/d.a : Lcom/bytedance/sdk/openadsdk/j/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a() {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */