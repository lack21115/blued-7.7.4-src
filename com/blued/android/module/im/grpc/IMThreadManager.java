package com.blued.android.module.im.grpc;

import android.util.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IMThreadManager {
  private ThreadPoolExecutor a = null;
  
  public IMThreadManager(int paramInt1, int paramInt2) {
    if (this.a == null) {
      this.a = new ThreadPoolExecutor(paramInt1, paramInt2, 32767L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(30), Executors.defaultThreadFactory(), new RejectedExecutionHandler(this) {
            public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
              Log.i("rejectedExecution:", param1Runnable.toString());
            }
          });
      this.a.allowCoreThreadTimeOut(true);
    } 
  }
  
  public void a(Runnable paramRunnable) {
    if (paramRunnable != null) {
      ThreadPoolExecutor threadPoolExecutor = this.a;
      if (threadPoolExecutor != null)
        try {
          threadPoolExecutor.execute(paramRunnable);
          return;
        } catch (OutOfMemoryError outOfMemoryError) {
          return;
        }  
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\grpc\IMThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */