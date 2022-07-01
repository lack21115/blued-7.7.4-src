package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public abstract class az {
  private final long a;
  
  private final long b;
  
  private long c;
  
  private long d;
  
  private boolean e = false;
  
  private boolean f = false;
  
  private Handler g = new Handler(this, Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        synchronized (this.a) {
          if (!az.a(this.a) && !az.b(this.a)) {
            long l = az.c(this.a) - SystemClock.elapsedRealtime();
            if (l <= 0L) {
              this.a.a();
            } else {
              long l1 = SystemClock.elapsedRealtime();
              this.a.a(l);
              for (l = az.d(this.a) + l1 - SystemClock.elapsedRealtime(); l < 0L; l += az.d(this.a));
              sendMessageDelayed(obtainMessage(1), l);
            } 
          } 
          return;
        } 
      }
    };
  
  public az(long paramLong1, long paramLong2) {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  private az b(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield e : Z
    //   7: lload_1
    //   8: lconst_0
    //   9: lcmp
    //   10: ifgt -> 20
    //   13: aload_0
    //   14: invokevirtual a : ()V
    //   17: goto -> 45
    //   20: aload_0
    //   21: invokestatic elapsedRealtime : ()J
    //   24: lload_1
    //   25: ladd
    //   26: putfield c : J
    //   29: aload_0
    //   30: getfield g : Landroid/os/Handler;
    //   33: aload_0
    //   34: getfield g : Landroid/os/Handler;
    //   37: iconst_1
    //   38: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   41: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   44: pop
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: areturn
    //   49: astore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_3
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	49	finally
    //   13	17	49	finally
    //   20	45	49	finally
  }
  
  public abstract void a();
  
  public abstract void a(long paramLong);
  
  public final void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield a : J
    //   7: invokespecial b : (J)Lcom/qq/e/comm/plugin/util/az;
    //   10: pop
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
  }
  
  public final void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield e : Z
    //   7: aload_0
    //   8: getfield g : Landroid/os/Handler;
    //   11: iconst_1
    //   12: invokevirtual removeMessages : (I)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
  }
  
  public final void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Z
    //   6: ifne -> 44
    //   9: aload_0
    //   10: getfield f : Z
    //   13: ifeq -> 19
    //   16: goto -> 44
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield f : Z
    //   24: aload_0
    //   25: aload_0
    //   26: getfield c : J
    //   29: invokestatic elapsedRealtime : ()J
    //   32: lsub
    //   33: putfield d : J
    //   36: aload_0
    //   37: getfield g : Landroid/os/Handler;
    //   40: iconst_1
    //   41: invokevirtual removeMessages : (I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	47	finally
    //   19	44	47	finally
  }
  
  public final void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Z
    //   6: ifne -> 33
    //   9: aload_0
    //   10: getfield f : Z
    //   13: ifne -> 19
    //   16: goto -> 33
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield f : Z
    //   24: aload_0
    //   25: aload_0
    //   26: getfield d : J
    //   29: invokespecial b : (J)Lcom/qq/e/comm/plugin/util/az;
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	36	finally
    //   19	33	36	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */