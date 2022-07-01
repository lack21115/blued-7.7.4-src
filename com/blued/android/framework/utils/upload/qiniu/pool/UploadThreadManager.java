package com.blued.android.framework.utils.upload.qiniu.pool;

import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class UploadThreadManager {
  private static UploadThreadManager a;
  
  private static final Long b = Long.valueOf(10L);
  
  private ThreadPoolExecutor c;
  
  private ThreadPoolExecutor d;
  
  private UploadThreadManager() {
    try {
      this.c = new ThreadPoolExecutor(3, 4, b.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new DefaultThreadFactory(), new RejectedExecutionHandler(this) {
            public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
              if (AppInfo.m()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("rejectedExecution: ");
                stringBuilder.append(param1Runnable.toString());
                Log.i("UploadThreadManager", stringBuilder.toString());
              } 
            }
          });
      this.c.allowCoreThreadTimeOut(true);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    this.d = new ThreadPoolExecutor(1, 2, b.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new DefaultThreadFactory());
  }
  
  public static UploadThreadManager a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager.a : Lcom/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager.a : Lcom/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager.a : Lcom/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager;
    //   25: ldc com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager.a : Lcom/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(ThreadExecutor paramThreadExecutor) {
    if (paramThreadExecutor != null) {
      ThreadPoolExecutor threadPoolExecutor = this.c;
      if (threadPoolExecutor != null)
        threadPoolExecutor.execute((Runnable)paramThreadExecutor); 
    } 
  }
  
  static class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    
    private final ThreadGroup b;
    
    private final AtomicInteger c;
    
    private final String d;
    
    DefaultThreadFactory() {
      ThreadGroup threadGroup;
      this.c = new AtomicInteger(1);
      SecurityManager securityManager = System.getSecurityManager();
      if (securityManager != null) {
        threadGroup = securityManager.getThreadGroup();
      } else {
        threadGroup = Thread.currentThread().getThreadGroup();
      } 
      this.b = threadGroup;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("blued-");
      stringBuilder.append(a.getAndIncrement());
      stringBuilder.append("-pool-");
      this.d = stringBuilder.toString();
    }
    
    public Thread newThread(Runnable param1Runnable) {
      ThreadGroup threadGroup = this.b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.d);
      stringBuilder.append(this.c.getAndIncrement());
      param1Runnable = new Thread(threadGroup, param1Runnable, stringBuilder.toString(), 0L);
      if (param1Runnable.isDaemon())
        param1Runnable.setDaemon(false); 
      if (param1Runnable.getPriority() != 5)
        param1Runnable.setPriority(5); 
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\pool\UploadThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */