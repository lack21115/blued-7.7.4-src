package com.facebook.stetho.server.http;

import java.util.ArrayList;

public class HandlerRegistry {
  private final ArrayList<HttpHandler> mHttpHandlers = new ArrayList<HttpHandler>();
  
  private final ArrayList<PathMatcher> mPathMatchers = new ArrayList<PathMatcher>();
  
  public HttpHandler lookup(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield mPathMatchers : Ljava/util/ArrayList;
    //   8: invokevirtual size : ()I
    //   11: istore_3
    //   12: iload_2
    //   13: iload_3
    //   14: if_icmpge -> 60
    //   17: aload_0
    //   18: getfield mPathMatchers : Ljava/util/ArrayList;
    //   21: iload_2
    //   22: invokevirtual get : (I)Ljava/lang/Object;
    //   25: checkcast com/facebook/stetho/server/http/PathMatcher
    //   28: aload_1
    //   29: invokeinterface match : (Ljava/lang/String;)Z
    //   34: ifeq -> 53
    //   37: aload_0
    //   38: getfield mHttpHandlers : Ljava/util/ArrayList;
    //   41: iload_2
    //   42: invokevirtual get : (I)Ljava/lang/Object;
    //   45: checkcast com/facebook/stetho/server/http/HttpHandler
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: iload_2
    //   54: iconst_1
    //   55: iadd
    //   56: istore_2
    //   57: goto -> 12
    //   60: aload_0
    //   61: monitorexit
    //   62: aconst_null
    //   63: areturn
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   4	12	64	finally
    //   17	49	64	finally
  }
  
  public void register(PathMatcher paramPathMatcher, HttpHandler paramHttpHandler) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPathMatchers : Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual add : (Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield mHttpHandlers : Ljava/util/ArrayList;
    //   15: aload_2
    //   16: invokevirtual add : (Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	23	finally
  }
  
  public boolean unregister(PathMatcher paramPathMatcher, HttpHandler paramHttpHandler) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPathMatchers : Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   10: istore_3
    //   11: iload_3
    //   12: iflt -> 49
    //   15: aload_2
    //   16: aload_0
    //   17: getfield mHttpHandlers : Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual get : (I)Ljava/lang/Object;
    //   24: if_acmpne -> 49
    //   27: aload_0
    //   28: getfield mPathMatchers : Ljava/util/ArrayList;
    //   31: iload_3
    //   32: invokevirtual remove : (I)Ljava/lang/Object;
    //   35: pop
    //   36: aload_0
    //   37: getfield mHttpHandlers : Ljava/util/ArrayList;
    //   40: iload_3
    //   41: invokevirtual remove : (I)Ljava/lang/Object;
    //   44: pop
    //   45: aload_0
    //   46: monitorexit
    //   47: iconst_1
    //   48: ireturn
    //   49: aload_0
    //   50: monitorexit
    //   51: iconst_0
    //   52: ireturn
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	53	finally
    //   15	45	53	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\http\HandlerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */