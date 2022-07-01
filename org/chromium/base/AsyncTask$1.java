package org.chromium.base;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class AsyncTask$1 implements ThreadFactory {
  private final AtomicInteger mCount = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable) {
    StringBuilder stringBuilder = new StringBuilder("AsyncTask #");
    stringBuilder.append(this.mCount.getAndIncrement());
    return new Thread(paramRunnable, stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\AsyncTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */