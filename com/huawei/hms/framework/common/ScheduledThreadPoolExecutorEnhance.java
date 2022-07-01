package com.huawei.hms.framework.common;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class ScheduledThreadPoolExecutorEnhance extends ScheduledThreadPoolExecutor {
  private static final String TAG = "ScheduledThreadPoolExec";
  
  public ScheduledThreadPoolExecutorEnhance(int paramInt, ThreadFactory paramThreadFactory) {
    super(paramInt, paramThreadFactory);
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {
    if (paramRunnable instanceof RunnableScheduledFutureEnhance) {
      String str2 = ((RunnableScheduledFutureEnhance)paramRunnable).getParentName();
      int i = str2.lastIndexOf(" -->");
      String str1 = str2;
      if (i != -1)
        str1 = StringUtils.substring(str2, i + 4); 
      String str3 = paramThread.getName();
      i = str3.lastIndexOf(" -->");
      str2 = str3;
      if (i != -1)
        str2 = StringUtils.substring(str3, i + 4); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(" -->");
      stringBuilder.append(str2);
      paramThread.setName(stringBuilder.toString());
    } 
    super.beforeExecute(paramThread, paramRunnable);
  }
  
  protected <V> RunnableScheduledFuture<V> decorateTask(Runnable paramRunnable, RunnableScheduledFuture<V> paramRunnableScheduledFuture) {
    return new RunnableScheduledFutureEnhance<V>(super.decorateTask(paramRunnable, paramRunnableScheduledFuture));
  }
  
  protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> paramCallable, RunnableScheduledFuture<V> paramRunnableScheduledFuture) {
    return new RunnableScheduledFutureEnhance<V>(super.decorateTask(paramCallable, paramRunnableScheduledFuture));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\ScheduledThreadPoolExecutorEnhance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */