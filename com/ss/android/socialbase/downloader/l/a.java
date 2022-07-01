package com.ss.android.socialbase.downloader.l;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements ThreadFactory {
  private final String a;
  
  private final AtomicInteger b = new AtomicInteger();
  
  private final boolean c;
  
  public a(String paramString) {
    this(paramString, false);
  }
  
  public a(String paramString, boolean paramBoolean) {
    this.a = paramString;
    this.c = paramBoolean;
  }
  
  public Thread newThread(Runnable paramRunnable) {
    int i = this.b.incrementAndGet();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("-");
    stringBuilder.append(i);
    paramRunnable = new Thread(paramRunnable, stringBuilder.toString());
    if (!this.c) {
      if (paramRunnable.isDaemon())
        paramRunnable.setDaemon(false); 
      if (paramRunnable.getPriority() != 5)
        paramRunnable.setPriority(5); 
    } 
    return (Thread)paramRunnable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */