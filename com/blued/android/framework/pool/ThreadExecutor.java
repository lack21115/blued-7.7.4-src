package com.blued.android.framework.pool;

import android.util.Log;
import com.blued.android.core.AppInfo;

public abstract class ThreadExecutor implements Runnable {
  private static final String TAG = "ThreadExecutor";
  
  private String threadName;
  
  private ThreadPriority threadPriority = ThreadPriority.b;
  
  private ThreadExecutor() {}
  
  public ThreadExecutor(String paramString) {
    this.threadName = paramString;
  }
  
  public ThreadExecutor(String paramString, ThreadPriority paramThreadPriority) {
    this.threadName = paramString;
    this.threadPriority = paramThreadPriority;
  }
  
  public abstract void execute();
  
  public String getThreadName() {
    return this.threadName;
  }
  
  public ThreadPriority getThreadPriority() {
    return this.threadPriority;
  }
  
  public void run() {
    if (AppInfo.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(toString());
      stringBuilder.append(": start to run.");
      Log.i("ThreadExecutor", stringBuilder.toString());
    } 
    execute();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("Thread [name:");
    stringBuilder.append(this.threadName);
    stringBuilder.append(", priority:");
    stringBuilder.append(this.threadPriority.name());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\pool\ThreadExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */