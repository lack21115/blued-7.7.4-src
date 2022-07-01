package com.sina.weibo.sdk.statistic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WBAgentExecutor {
  private static long TIMEOUT;
  
  private static ExecutorService mExecutor = Executors.newSingleThreadExecutor();
  
  static {
    TIMEOUT = 5L;
  }
  
  public static void execute(Runnable paramRunnable) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/statistic/WBAgentExecutor
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/statistic/WBAgentExecutor.mExecutor : Ljava/util/concurrent/ExecutorService;
    //   6: invokeinterface isShutdown : ()Z
    //   11: ifeq -> 20
    //   14: invokestatic newSingleThreadExecutor : ()Ljava/util/concurrent/ExecutorService;
    //   17: putstatic com/sina/weibo/sdk/statistic/WBAgentExecutor.mExecutor : Ljava/util/concurrent/ExecutorService;
    //   20: getstatic com/sina/weibo/sdk/statistic/WBAgentExecutor.mExecutor : Ljava/util/concurrent/ExecutorService;
    //   23: aload_0
    //   24: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   29: ldc com/sina/weibo/sdk/statistic/WBAgentExecutor
    //   31: monitorexit
    //   32: return
    //   33: astore_0
    //   34: ldc com/sina/weibo/sdk/statistic/WBAgentExecutor
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	33	finally
    //   20	29	33	finally
  }
  
  public static void shutDownExecutor() {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/statistic/WBAgentExecutor
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/statistic/WBAgentExecutor.mExecutor : Ljava/util/concurrent/ExecutorService;
    //   6: invokeinterface isShutdown : ()Z
    //   11: ifne -> 22
    //   14: getstatic com/sina/weibo/sdk/statistic/WBAgentExecutor.mExecutor : Ljava/util/concurrent/ExecutorService;
    //   17: invokeinterface shutdown : ()V
    //   22: getstatic com/sina/weibo/sdk/statistic/WBAgentExecutor.mExecutor : Ljava/util/concurrent/ExecutorService;
    //   25: getstatic com/sina/weibo/sdk/statistic/WBAgentExecutor.TIMEOUT : J
    //   28: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   31: invokeinterface awaitTermination : (JLjava/util/concurrent/TimeUnit;)Z
    //   36: pop
    //   37: goto -> 46
    //   40: astore_0
    //   41: ldc com/sina/weibo/sdk/statistic/WBAgentExecutor
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: ldc com/sina/weibo/sdk/statistic/WBAgentExecutor
    //   48: monitorexit
    //   49: return
    //   50: astore_0
    //   51: goto -> 46
    // Exception table:
    //   from	to	target	type
    //   3	22	50	java/lang/Exception
    //   3	22	40	finally
    //   22	37	50	java/lang/Exception
    //   22	37	40	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\WBAgentExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */