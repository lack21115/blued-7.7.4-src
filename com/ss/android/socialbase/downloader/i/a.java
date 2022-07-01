package com.ss.android.socialbase.downloader.i;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
  private static final String a = a.class.getSimpleName();
  
  private static long f = -1L;
  
  private static volatile a g = null;
  
  private final g b = g.a();
  
  private final AtomicInteger c = new AtomicInteger();
  
  private final a d;
  
  private long e;
  
  private a() {
    HandlerThread handlerThread = new HandlerThread("ParseThread");
    handlerThread.start();
    this.d = new a(this, handlerThread.getLooper());
  }
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/i/a.g : Lcom/ss/android/socialbase/downloader/i/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/i/a
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/i/a.g : Lcom/ss/android/socialbase/downloader/i/a;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/i/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/i/a.g : Lcom/ss/android/socialbase/downloader/i/a;
    //   25: ldc com/ss/android/socialbase/downloader/i/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/i/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/i/a.g : Lcom/ss/android/socialbase/downloader/i/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static long d() {
    return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
  }
  
  public void b() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public void c() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  protected void e() {
    // Byte code:
    //   0: invokestatic B : ()Landroid/content/Context;
    //   3: invokestatic a : (Landroid/content/Context;)Z
    //   6: ifeq -> 16
    //   9: invokestatic d : ()J
    //   12: lstore_1
    //   13: goto -> 20
    //   16: invokestatic getMobileRxBytes : ()J
    //   19: lstore_1
    //   20: getstatic com/ss/android/socialbase/downloader/i/a.f : J
    //   23: lstore_3
    //   24: getstatic com/ss/android/socialbase/downloader/i/a.f : J
    //   27: lconst_0
    //   28: lcmp
    //   29: iflt -> 74
    //   32: aload_0
    //   33: monitorenter
    //   34: invokestatic uptimeMillis : ()J
    //   37: lstore #5
    //   39: aload_0
    //   40: getfield b : Lcom/ss/android/socialbase/downloader/i/g;
    //   43: lload_1
    //   44: lload_3
    //   45: lsub
    //   46: lload #5
    //   48: aload_0
    //   49: getfield e : J
    //   52: lsub
    //   53: invokevirtual a : (JJ)V
    //   56: aload_0
    //   57: lload #5
    //   59: putfield e : J
    //   62: aload_0
    //   63: monitorexit
    //   64: goto -> 74
    //   67: astore #7
    //   69: aload_0
    //   70: monitorexit
    //   71: aload #7
    //   73: athrow
    //   74: lload_1
    //   75: putstatic com/ss/android/socialbase/downloader/i/a.f : J
    //   78: return
    //   79: astore #7
    //   81: aload #7
    //   83: invokevirtual printStackTrace : ()V
    //   86: return
    // Exception table:
    //   from	to	target	type
    //   0	13	79	java/lang/Exception
    //   16	20	79	java/lang/Exception
    //   20	34	79	java/lang/Exception
    //   34	64	67	finally
    //   69	71	67	finally
    //   71	74	79	java/lang/Exception
    //   74	78	79	java/lang/Exception
  }
  
  protected void f() {
    e();
    f = -1L;
  }
  
  class a extends Handler {
    public a(a this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public void a() {
      sendEmptyMessage(1);
    }
    
    public void b() {
      removeMessages(1);
    }
    
    public void handleMessage(Message param1Message) {
      if (param1Message.what != 1)
        return; 
      this.a.e();
      sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */