package com.alibaba.mtl.log.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.alibaba.mtl.appmonitor.b.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class r {
  private static int F = 1;
  
  private static int G = 2;
  
  private static int H = 10;
  
  private static int I = 60;
  
  public static r a;
  
  private static ThreadPoolExecutor a;
  
  private static final AtomicInteger f = new AtomicInteger();
  
  private HandlerThread b = new HandlerThread("AppMonitor");
  
  private Handler mHandler;
  
  private r() {
    this.b.start();
    this.mHandler = new Handler(this, this.b.getLooper()) {
        public void handleMessage(Message param1Message) {
          super.handleMessage(param1Message);
          try {
            return;
          } finally {
            param1Message = null;
          } 
        }
      };
  }
  
  public static r a() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/e/r
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/e/r.a : Lcom/alibaba/mtl/log/e/r;
    //   6: ifnonnull -> 19
    //   9: new com/alibaba/mtl/log/e/r
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/alibaba/mtl/log/e/r.a : Lcom/alibaba/mtl/log/e/r;
    //   19: getstatic com/alibaba/mtl/log/e/r.a : Lcom/alibaba/mtl/log/e/r;
    //   22: astore_0
    //   23: ldc com/alibaba/mtl/log/e/r
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/alibaba/mtl/log/e/r
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  private static ThreadPoolExecutor a() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/e/r
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/e/r.a : Ljava/util/concurrent/ThreadPoolExecutor;
    //   6: ifnonnull -> 30
    //   9: getstatic com/alibaba/mtl/log/e/r.F : I
    //   12: getstatic com/alibaba/mtl/log/e/r.G : I
    //   15: getstatic com/alibaba/mtl/log/e/r.H : I
    //   18: getstatic com/alibaba/mtl/log/e/r.I : I
    //   21: sipush #500
    //   24: invokestatic a : (IIIII)Ljava/util/concurrent/ThreadPoolExecutor;
    //   27: putstatic com/alibaba/mtl/log/e/r.a : Ljava/util/concurrent/ThreadPoolExecutor;
    //   30: getstatic com/alibaba/mtl/log/e/r.a : Ljava/util/concurrent/ThreadPoolExecutor;
    //   33: astore_0
    //   34: ldc com/alibaba/mtl/log/e/r
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: ldc com/alibaba/mtl/log/e/r
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	39	finally
    //   30	34	39	finally
  }
  
  private static ThreadPoolExecutor a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    LinkedBlockingQueue<Runnable> linkedBlockingQueue;
    if (paramInt5 > 0) {
      linkedBlockingQueue = new LinkedBlockingQueue(paramInt5);
    } else {
      linkedBlockingQueue = new LinkedBlockingQueue();
    } 
    a a = new a(paramInt1);
    return new ThreadPoolExecutor(paramInt2, paramInt3, paramInt4, TimeUnit.SECONDS, linkedBlockingQueue, a, new ThreadPoolExecutor.DiscardOldestPolicy());
  }
  
  public final void a(int paramInt, Runnable paramRunnable, long paramLong) {
    try {
      Message message = Message.obtain(this.mHandler, paramInt);
      message.obj = paramRunnable;
      this.mHandler.sendMessageDelayed(message, paramLong);
      return;
    } catch (Exception exception) {
      b.a(exception);
      return;
    } 
  }
  
  public void b(Runnable paramRunnable) {
    try {
      return;
    } finally {
      paramRunnable = null;
    } 
  }
  
  public final boolean b(int paramInt) {
    return this.mHandler.hasMessages(paramInt);
  }
  
  public final void f(int paramInt) {
    this.mHandler.removeMessages(paramInt);
  }
  
  static class a implements ThreadFactory {
    private int priority;
    
    public a(int param1Int) {
      this.priority = param1Int;
    }
    
    public Thread newThread(Runnable param1Runnable) {
      int i = r.a().getAndIncrement();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AppMonitor:");
      stringBuilder.append(i);
      param1Runnable = new Thread(param1Runnable, stringBuilder.toString());
      param1Runnable.setPriority(this.priority);
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */