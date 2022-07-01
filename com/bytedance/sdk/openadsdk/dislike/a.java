package com.bytedance.sdk.openadsdk.dislike;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.List;

public class a {
  private static volatile a a;
  
  private final p<com.bytedance.sdk.openadsdk.c.a> b = o.f();
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/dislike/a.a : Lcom/bytedance/sdk/openadsdk/dislike/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/dislike/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/dislike/a.a : Lcom/bytedance/sdk/openadsdk/dislike/a;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/dislike/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/dislike/a.a : Lcom/bytedance/sdk/openadsdk/dislike/a;
    //   25: ldc com/bytedance/sdk/openadsdk/dislike/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/dislike/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/dislike/a.a : Lcom/bytedance/sdk/openadsdk/dislike/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(k paramk, List<FilterWord> paramList) {
    this.b.a(paramk, paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\dislike\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */