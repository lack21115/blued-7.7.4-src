package org.chromium.android_webview;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.chromium.base.ThreadUtils;

public final class WebViewChromiumRunQueue {
  private final WebViewChromiumRunQueue$ChromiumHasStartedCallable mChromiumHasStartedCallable;
  
  private final Queue mQueue = new ConcurrentLinkedQueue();
  
  public WebViewChromiumRunQueue(WebViewChromiumRunQueue$ChromiumHasStartedCallable paramWebViewChromiumRunQueue$ChromiumHasStartedCallable) {
    this.mChromiumHasStartedCallable = paramWebViewChromiumRunQueue$ChromiumHasStartedCallable;
  }
  
  public final void addTask(Runnable paramRunnable) {
    this.mQueue.add(paramRunnable);
    if (this.mChromiumHasStartedCallable.hasStarted())
      ThreadUtils.runOnUiThread(new WebViewChromiumRunQueue$1(this)); 
  }
  
  public final boolean chromiumHasStarted() {
    return this.mChromiumHasStartedCallable.hasStarted();
  }
  
  public final void drainQueue() {
    if (this.mQueue != null) {
      if (this.mQueue.isEmpty())
        return; 
      while (true) {
        Runnable runnable = this.mQueue.poll();
        if (runnable != null) {
          runnable.run();
          continue;
        } 
        break;
      } 
      return;
    } 
  }
  
  public final Object runBlockingFuture(FutureTask<FutureTask> paramFutureTask) {
    if (chromiumHasStarted()) {
      if (!ThreadUtils.runningOnUiThread()) {
        addTask(paramFutureTask);
        try {
          return paramFutureTask.get(4L, TimeUnit.SECONDS);
        } catch (TimeoutException timeoutException) {
          throw new RuntimeException("Probable deadlock detected due to WebView API being called on incorrect thread while the UI thread is blocked.", timeoutException);
        } catch (Exception exception) {
          throw new RuntimeException(exception);
        } 
      } 
      throw new IllegalStateException("This method should only be called off the UI thread");
    } 
    throw new RuntimeException("Must be started before we block!");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\WebViewChromiumRunQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */