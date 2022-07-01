package com.amap.api.mapcore2d;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class fw {
  private static fw a;
  
  private ExecutorService b;
  
  private ConcurrentHashMap<fx, Future<?>> c = new ConcurrentHashMap<fx, Future<?>>();
  
  private fx.a d = new fx.a(this) {
      public void a(fx param1fx) {}
      
      public void b(fx param1fx) {
        fw.a(this.a, param1fx, false);
      }
    };
  
  private fw(int paramInt) {
    try {
      return;
    } finally {
      Exception exception = null;
      do.c(exception, "TPool", "ThreadPool");
      exception.printStackTrace();
    } 
  }
  
  public static fw a(int paramInt) {
    return new fw(paramInt);
  }
  
  private void a(fx paramfx, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast java/util/concurrent/Future
    //   13: astore_1
    //   14: iload_2
    //   15: ifeq -> 46
    //   18: aload_1
    //   19: ifnull -> 46
    //   22: aload_1
    //   23: iconst_1
    //   24: invokeinterface cancel : (Z)Z
    //   29: pop
    //   30: goto -> 46
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 'TPool'
    //   37: ldc 'removeQueue'
    //   39: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_1
    //   43: invokevirtual printStackTrace : ()V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
    //   22	30	33	finally
    //   34	46	49	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */