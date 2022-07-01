package com.huawei.hms.framework.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorEnhance extends ThreadPoolExecutor {
  public ThreadPoolExcutorEnhance(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory) {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {
    if (paramRunnable instanceof RunnableEnhance) {
      String str2 = ((RunnableEnhance)paramRunnable).getParentName();
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
  
  public void execute(Runnable paramRunnable) {
    super.execute(new RunnableEnhance(paramRunnable));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\ThreadPoolExcutorEnhance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */