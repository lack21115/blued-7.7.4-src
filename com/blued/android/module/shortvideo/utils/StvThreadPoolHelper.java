package com.blued.android.module.shortvideo.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StvThreadPoolHelper {
  public static int a = 1;
  
  private static StvThreadPoolHelper b;
  
  private ThreadPoolExecutor c = new ThreadPoolExecutor(4, 8, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new StvThreadFactory(this), new ThreadPoolExecutor.DiscardPolicy());
  
  private ThreadPoolExecutor d = new ThreadPoolExecutor(4, 8, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new StvThreadFactory(this), new ThreadPoolExecutor.DiscardPolicy());
  
  public static StvThreadPoolHelper a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/shortvideo/utils/StvThreadPoolHelper.b : Lcom/blued/android/module/shortvideo/utils/StvThreadPoolHelper;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/shortvideo/utils/StvThreadPoolHelper
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/shortvideo/utils/StvThreadPoolHelper.b : Lcom/blued/android/module/shortvideo/utils/StvThreadPoolHelper;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/shortvideo/utils/StvThreadPoolHelper
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/shortvideo/utils/StvThreadPoolHelper.b : Lcom/blued/android/module/shortvideo/utils/StvThreadPoolHelper;
    //   25: ldc com/blued/android/module/shortvideo/utils/StvThreadPoolHelper
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/shortvideo/utils/StvThreadPoolHelper
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/shortvideo/utils/StvThreadPoolHelper.b : Lcom/blued/android/module/shortvideo/utils/StvThreadPoolHelper;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(StvThread paramStvThread) {
    if (paramStvThread != null && !paramStvThread.b()) {
      paramStvThread.a();
      paramStvThread.interrupt();
    } 
  }
  
  public void a(Runnable paramRunnable) {
    this.c.execute(paramRunnable);
  }
  
  public void b(Runnable paramRunnable) {
    this.d.execute(paramRunnable);
  }
  
  public static class StvThread extends Thread {
    protected boolean b = true;
    
    protected boolean c = false;
    
    public StvThread() {
      super(stringBuilder.toString());
      StvThreadPoolHelper.a++;
      this.b = true;
      this.c = false;
    }
    
    public StvThread(Runnable param1Runnable) {
      super(param1Runnable);
      this.b = true;
      this.c = false;
    }
    
    public StvThread(Runnable param1Runnable, String param1String) {
      super(param1Runnable, param1String);
      this.b = true;
      this.c = false;
    }
    
    public void a() {
      this.b = false;
      this.c = true;
    }
    
    public boolean b() {
      return this.c;
    }
    
    public void run() {
      if (this.b) {
        this.c = false;
        super.run();
        this.c = true;
        StvThreadPoolHelper.a--;
      } 
    }
  }
  
  class StvThreadFactory implements ThreadFactory {
    public StvThreadFactory(StvThreadPoolHelper this$0) {
      StvThreadPoolHelper.a = 1;
    }
    
    public Thread newThread(Runnable param1Runnable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stv_thread_");
      stringBuilder.append(StvThreadPoolHelper.a);
      param1Runnable = new StvThreadPoolHelper.StvThread(param1Runnable, stringBuilder.toString());
      StvThreadPoolHelper.a++;
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvThreadPoolHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */