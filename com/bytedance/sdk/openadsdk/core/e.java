package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

public class e extends f {
  private static volatile e a;
  
  private e(Context paramContext) {
    super(paramContext);
  }
  
  public static e a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/e.a : Lcom/bytedance/sdk/openadsdk/core/e;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/core/e
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/e.a : Lcom/bytedance/sdk/openadsdk/core/e;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/core/e
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/core/e.a : Lcom/bytedance/sdk/openadsdk/core/e;
    //   26: ldc com/bytedance/sdk/openadsdk/core/e
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/core/e
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/core/e.a : Lcom/bytedance/sdk/openadsdk/core/e;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */