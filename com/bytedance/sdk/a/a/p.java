package com.bytedance.sdk.a.a;

final class p {
  static o a;
  
  static long b;
  
  static o a() {
    // Byte code:
    //   0: ldc com/bytedance/sdk/a/a/p
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/a/a/p.a : Lcom/bytedance/sdk/a/a/o;
    //   6: ifnull -> 40
    //   9: getstatic com/bytedance/sdk/a/a/p.a : Lcom/bytedance/sdk/a/a/o;
    //   12: astore_0
    //   13: aload_0
    //   14: getfield f : Lcom/bytedance/sdk/a/a/o;
    //   17: putstatic com/bytedance/sdk/a/a/p.a : Lcom/bytedance/sdk/a/a/o;
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield f : Lcom/bytedance/sdk/a/a/o;
    //   25: getstatic com/bytedance/sdk/a/a/p.b : J
    //   28: ldc2_w 8192
    //   31: lsub
    //   32: putstatic com/bytedance/sdk/a/a/p.b : J
    //   35: ldc com/bytedance/sdk/a/a/p
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: ldc com/bytedance/sdk/a/a/p
    //   42: monitorexit
    //   43: new com/bytedance/sdk/a/a/o
    //   46: dup
    //   47: invokespecial <init> : ()V
    //   50: areturn
    //   51: astore_0
    //   52: ldc com/bytedance/sdk/a/a/p
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	38	51	finally
    //   40	43	51	finally
    //   52	55	51	finally
  }
  
  static void a(o paramo) {
    // Byte code:
    //   0: aload_0
    //   1: getfield f : Lcom/bytedance/sdk/a/a/o;
    //   4: ifnonnull -> 84
    //   7: aload_0
    //   8: getfield g : Lcom/bytedance/sdk/a/a/o;
    //   11: ifnonnull -> 84
    //   14: aload_0
    //   15: getfield d : Z
    //   18: ifeq -> 22
    //   21: return
    //   22: ldc com/bytedance/sdk/a/a/p
    //   24: monitorenter
    //   25: getstatic com/bytedance/sdk/a/a/p.b : J
    //   28: ldc2_w 8192
    //   31: ladd
    //   32: ldc2_w 65536
    //   35: lcmp
    //   36: ifle -> 43
    //   39: ldc com/bytedance/sdk/a/a/p
    //   41: monitorexit
    //   42: return
    //   43: getstatic com/bytedance/sdk/a/a/p.b : J
    //   46: ldc2_w 8192
    //   49: ladd
    //   50: putstatic com/bytedance/sdk/a/a/p.b : J
    //   53: aload_0
    //   54: getstatic com/bytedance/sdk/a/a/p.a : Lcom/bytedance/sdk/a/a/o;
    //   57: putfield f : Lcom/bytedance/sdk/a/a/o;
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield c : I
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield b : I
    //   70: aload_0
    //   71: putstatic com/bytedance/sdk/a/a/p.a : Lcom/bytedance/sdk/a/a/o;
    //   74: ldc com/bytedance/sdk/a/a/p
    //   76: monitorexit
    //   77: return
    //   78: astore_0
    //   79: ldc com/bytedance/sdk/a/a/p
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    //   84: new java/lang/IllegalArgumentException
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   25	42	78	finally
    //   43	77	78	finally
    //   79	82	78	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */