package org.chromium.base;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class AsyncTask$StealRunnableHandler implements RejectedExecutionHandler {
  private AsyncTask$StealRunnableHandler() {}
  
  public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor) {
    AsyncTask.THREAD_POOL_EXECUTOR.execute(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\AsyncTask$StealRunnableHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */