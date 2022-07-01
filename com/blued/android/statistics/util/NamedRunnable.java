package com.blued.android.statistics.util;

import android.os.Looper;

public abstract class NamedRunnable implements Runnable {
  private volatile String a;
  
  public NamedRunnable(String paramString) {
    this.a = paramString;
  }
  
  protected abstract void a();
  
  public final void run() {
    Thread thread = Thread.currentThread();
    if (thread != Looper.getMainLooper().getThread())
      thread.setName(this.a); 
    a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistic\\util\NamedRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */