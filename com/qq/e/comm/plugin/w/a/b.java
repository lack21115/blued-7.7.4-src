package com.qq.e.comm.plugin.w.a;

import java.util.Stack;

public class b {
  private static final ThreadLocal<Stack<a>> a = new ThreadLocal<Stack<a>>();
  
  public static Stack<a> a() {
    // Byte code:
    //   0: ldc com/qq/e/comm/plugin/w/a/b
    //   2: monitorenter
    //   3: getstatic com/qq/e/comm/plugin/w/a/b.a : Ljava/lang/ThreadLocal;
    //   6: invokevirtual get : ()Ljava/lang/Object;
    //   9: checkcast java/util/Stack
    //   12: astore_0
    //   13: getstatic com/qq/e/comm/plugin/w/a/b.a : Ljava/lang/ThreadLocal;
    //   16: aconst_null
    //   17: invokevirtual set : (Ljava/lang/Object;)V
    //   20: ldc com/qq/e/comm/plugin/w/a/b
    //   22: monitorexit
    //   23: aload_0
    //   24: areturn
    //   25: astore_0
    //   26: ldc com/qq/e/comm/plugin/w/a/b
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	25	finally
  }
  
  public static void a(a parama) {
    // Byte code:
    //   0: ldc com/qq/e/comm/plugin/w/a/b
    //   2: monitorenter
    //   3: getstatic com/qq/e/comm/plugin/w/a/b.a : Ljava/lang/ThreadLocal;
    //   6: invokevirtual get : ()Ljava/lang/Object;
    //   9: checkcast java/util/Stack
    //   12: astore_2
    //   13: aload_2
    //   14: astore_1
    //   15: aload_2
    //   16: ifnonnull -> 34
    //   19: new java/util/Stack
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore_1
    //   27: getstatic com/qq/e/comm/plugin/w/a/b.a : Ljava/lang/ThreadLocal;
    //   30: aload_1
    //   31: invokevirtual set : (Ljava/lang/Object;)V
    //   34: aload_1
    //   35: aload_0
    //   36: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: ldc com/qq/e/comm/plugin/w/a/b
    //   42: monitorexit
    //   43: return
    //   44: astore_0
    //   45: ldc com/qq/e/comm/plugin/w/a/b
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	44	finally
    //   19	34	44	finally
    //   34	40	44	finally
  }
  
  static class a {
    final int a;
    
    public a(int param1Int) {
      this.a = param1Int;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ErrInfo [code=");
      stringBuilder.append(this.a);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */