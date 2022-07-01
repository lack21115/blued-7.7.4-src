package com.blued.android.core.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory implements ThreadFactory {
  private static final AtomicInteger a = new AtomicInteger(1);
  
  private final ThreadGroup b;
  
  private final AtomicInteger c;
  
  private final String d;
  
  public DefaultThreadFactory() {
    this("default");
  }
  
  public DefaultThreadFactory(String paramString) {
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
    stringBuilder.append("-");
    stringBuilder.append(paramString);
    stringBuilder.append("-");
    this.d = stringBuilder.toString();
  }
  
  public Thread newThread(Runnable paramRunnable) {
    ThreadGroup threadGroup = this.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d);
    stringBuilder.append(this.c.getAndIncrement());
    paramRunnable = new Thread(threadGroup, paramRunnable, stringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon())
      paramRunnable.setDaemon(false); 
    if (paramRunnable.getPriority() != 5)
      paramRunnable.setPriority(5); 
    return (Thread)paramRunnable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\pool\DefaultThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */