package com.blued.android.module.media.selector.utils;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolHelper {
  public static int a = 1;
  
  private static ThreadPoolHelper b;
  
  private ThreadPoolExecutor c = new ThreadPoolExecutor(4, 8, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new AlbumThreadFactory(this), new ThreadPoolExecutor.DiscardPolicy());
  
  private ThreadPoolExecutor d = new ThreadPoolExecutor(4, 8, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new AlbumThreadFactory(this), new ThreadPoolExecutor.DiscardPolicy());
  
  public static ThreadPoolHelper a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/media/selector/utils/ThreadPoolHelper.b : Lcom/blued/android/module/media/selector/utils/ThreadPoolHelper;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/media/selector/utils/ThreadPoolHelper
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/media/selector/utils/ThreadPoolHelper.b : Lcom/blued/android/module/media/selector/utils/ThreadPoolHelper;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/media/selector/utils/ThreadPoolHelper
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/media/selector/utils/ThreadPoolHelper.b : Lcom/blued/android/module/media/selector/utils/ThreadPoolHelper;
    //   25: ldc com/blued/android/module/media/selector/utils/ThreadPoolHelper
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/media/selector/utils/ThreadPoolHelper
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/media/selector/utils/ThreadPoolHelper.b : Lcom/blued/android/module/media/selector/utils/ThreadPoolHelper;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(Runnable paramRunnable) {
    this.c.execute(paramRunnable);
  }
  
  public Future b(Runnable paramRunnable) {
    return this.d.submit(paramRunnable);
  }
  
  public static class AlbumThread extends Thread {
    protected boolean a = true;
    
    protected boolean b = false;
    
    public AlbumThread() {
      super(stringBuilder.toString());
      ThreadPoolHelper.a++;
      this.a = true;
      this.b = false;
    }
    
    public AlbumThread(Runnable param1Runnable, String param1String) {
      super(param1Runnable, param1String);
      this.a = true;
      this.b = false;
    }
    
    public void run() {
      if (this.a) {
        this.b = false;
        super.run();
        this.b = true;
        ThreadPoolHelper.a--;
      } 
    }
  }
  
  class AlbumThreadFactory implements ThreadFactory {
    public AlbumThreadFactory(ThreadPoolHelper this$0) {
      ThreadPoolHelper.a = 1;
    }
    
    public Thread newThread(Runnable param1Runnable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("vr_thread_");
      stringBuilder.append(ThreadPoolHelper.a);
      param1Runnable = new ThreadPoolHelper.AlbumThread(param1Runnable, stringBuilder.toString());
      ThreadPoolHelper.a++;
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selecto\\utils\ThreadPoolHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */