package com.amap.api.col.s;

import android.content.Context;

public class bt {
  private static bt a;
  
  private final Context b;
  
  private final String c;
  
  private bt(Context paramContext) {
    this.b = paramContext.getApplicationContext();
    this.c = ca.a(bs.c("RYW1hcF9kZXZpY2VfYWRpdQ"));
  }
  
  public static bt a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/amap/api/col/s/bt.a : Lcom/amap/api/col/s/bt;
    //   3: ifnonnull -> 38
    //   6: ldc com/amap/api/col/s/bt
    //   8: monitorenter
    //   9: getstatic com/amap/api/col/s/bt.a : Lcom/amap/api/col/s/bt;
    //   12: ifnonnull -> 26
    //   15: new com/amap/api/col/s/bt
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/amap/api/col/s/bt.a : Lcom/amap/api/col/s/bt;
    //   26: ldc com/amap/api/col/s/bt
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/amap/api/col/s/bt
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/amap/api/col/s/bt.a : Lcom/amap/api/col/s/bt;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public final void a(String paramString) {
    bu.a(this.b).a(this.c);
    bu.a(this.b).b(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */