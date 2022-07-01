package com.bytedance.tea.crash.a;

import android.content.Context;

public class f {
  private static volatile f a;
  
  private final c b;
  
  private f(Context paramContext) {
    this.b = new c(paramContext);
  }
  
  public static f a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/tea/crash/a/f.a : Lcom/bytedance/tea/crash/a/f;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/tea/crash/a/f
    //   8: monitorenter
    //   9: getstatic com/bytedance/tea/crash/a/f.a : Lcom/bytedance/tea/crash/a/f;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/tea/crash/a/f
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/tea/crash/a/f.a : Lcom/bytedance/tea/crash/a/f;
    //   26: ldc com/bytedance/tea/crash/a/f
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/tea/crash/a/f
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/tea/crash/a/f.a : Lcom/bytedance/tea/crash/a/f;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public void a() {
    this.b.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */