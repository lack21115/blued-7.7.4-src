package com.blued.android.module.external_sense_library.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SenseLibThreadPoolHelper {
  public static int a = 1;
  
  private static SenseLibThreadPoolHelper b;
  
  private ThreadPoolExecutor c = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new SenseLibThreadFactory(this), new ThreadPoolExecutor.DiscardPolicy());
  
  public static SenseLibThreadPoolHelper a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper.b : Lcom/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper.b : Lcom/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper.b : Lcom/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper;
    //   25: ldc com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper.b : Lcom/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper;
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
  
  public static class SenseLibThread extends Thread {
    protected boolean a = true;
    
    protected boolean b = false;
    
    public SenseLibThread() {
      super(stringBuilder.toString());
      SenseLibThreadPoolHelper.a++;
      this.a = true;
      this.b = false;
    }
    
    public SenseLibThread(Runnable param1Runnable) {
      super(param1Runnable);
      this.a = true;
      this.b = false;
    }
    
    public SenseLibThread(Runnable param1Runnable, String param1String) {
      super(param1Runnable, param1String);
      this.a = true;
      this.b = false;
    }
    
    public void run() {
      if (this.a) {
        this.b = false;
        super.run();
        this.b = true;
        SenseLibThreadPoolHelper.a--;
      } 
    }
  }
  
  class SenseLibThreadFactory implements ThreadFactory {
    public SenseLibThreadFactory(SenseLibThreadPoolHelper this$0) {
      SenseLibThreadPoolHelper.a = 1;
    }
    
    public Thread newThread(Runnable param1Runnable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stv_thread_");
      stringBuilder.append(SenseLibThreadPoolHelper.a);
      param1Runnable = new SenseLibThreadPoolHelper.SenseLibThread(param1Runnable, stringBuilder.toString());
      SenseLibThreadPoolHelper.a++;
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\SenseLibThreadPoolHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */