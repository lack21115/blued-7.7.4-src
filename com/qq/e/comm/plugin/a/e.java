package com.qq.e.comm.plugin.a;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.d.b;
import com.qq.e.comm.plugin.a.d.d;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

final class e {
  private volatile ScheduledExecutorService a;
  
  private final b b;
  
  e(b paramb) {
    this.b = paramb;
  }
  
  void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: ldc2_w 2000
    //   7: invokevirtual a : (Ljava/lang/String;J)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  void a(String paramString, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/concurrent/ScheduledExecutorService;
    //   6: ifnonnull -> 24
    //   9: aload_0
    //   10: new com/qq/e/comm/plugin/a/e$1
    //   13: dup
    //   14: aload_0
    //   15: invokespecial <init> : (Lcom/qq/e/comm/plugin/a/e;)V
    //   18: invokestatic newSingleThreadScheduledExecutor : (Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;
    //   21: putfield a : Ljava/util/concurrent/ScheduledExecutorService;
    //   24: aload_0
    //   25: getfield a : Ljava/util/concurrent/ScheduledExecutorService;
    //   28: new com/qq/e/comm/plugin/a/e$a
    //   31: dup
    //   32: aload_0
    //   33: aload_1
    //   34: lload_2
    //   35: invokespecial <init> : (Lcom/qq/e/comm/plugin/a/e;Ljava/lang/String;J)V
    //   38: lload_2
    //   39: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   42: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   47: pop
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	51	finally
    //   24	48	51	finally
  }
  
  class a implements Runnable {
    private final String b;
    
    private final long c;
    
    public a(e this$0, String param1String, long param1Long) {
      this.b = param1String;
      this.c = param1Long;
    }
    
    private long a() {
      long l2 = this.c;
      long l1 = l2;
      if (l2 > 64000L)
        l1 = -1L; 
      return l1;
    }
    
    public void run() {
      if (e.a(this.a) != null) {
        if (!e.a(this.a).b(this.b))
          return; 
        if (d.a(b.a().a(GDTADManager.getInstance().getAppContext(), this.b))) {
          e.a(this.a).a(this.b);
          return;
        } 
        long l = a();
        if (l > 0L)
          this.a.a(this.b, l * 2L); 
      } 
    }
  }
  
  static interface b {
    void a(String param1String);
    
    boolean b(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */