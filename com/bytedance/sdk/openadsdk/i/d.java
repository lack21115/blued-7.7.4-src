package com.bytedance.sdk.openadsdk.i;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class d implements ThreadFactory {
  private static final AtomicInteger a = new AtomicInteger(1);
  
  private final ThreadGroup b;
  
  private final AtomicInteger c;
  
  private final String d;
  
  private final int e;
  
  d(int paramInt, String paramString) {
    StringBuilder stringBuilder1;
    ThreadGroup threadGroup;
    this.c = new AtomicInteger(1);
    this.e = paramInt;
    SecurityManager securityManager = System.getSecurityManager();
    if (securityManager != null) {
      threadGroup = securityManager.getThreadGroup();
    } else {
      threadGroup = Thread.currentThread().getThreadGroup();
    } 
    this.b = threadGroup;
    if (TextUtils.isEmpty(paramString)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("ttbackground-");
      stringBuilder1.append(a.getAndIncrement());
      stringBuilder1.append("-thread-");
      this.d = stringBuilder1.toString();
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((String)stringBuilder1);
    stringBuilder2.append(a.getAndIncrement());
    stringBuilder2.append("-thread-");
    this.d = stringBuilder2.toString();
  }
  
  public Thread newThread(Runnable paramRunnable) {
    ThreadGroup threadGroup = this.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d);
    stringBuilder.append(this.c.getAndIncrement());
    paramRunnable = new Thread(threadGroup, paramRunnable, stringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon())
      paramRunnable.setDaemon(false); 
    if (this.e == 1) {
      paramRunnable.setPriority(1);
      return (Thread)paramRunnable;
    } 
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(3);
      return (Thread)paramRunnable;
    } 
    paramRunnable.setPriority(5);
    return (Thread)paramRunnable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */