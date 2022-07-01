package com.tencent.tbs.patch.common.task;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTaskRunner extends TaskRunner {
  private AtomicInteger a = new AtomicInteger();
  
  private Executor b;
  
  public ThreadPoolTaskRunner(Executor paramExecutor) {
    this.b = paramExecutor;
  }
  
  public void onTaskEvaluated(Task paramTask) {
    this.a.incrementAndGet();
  }
  
  public void onTaskFinished(Task paramTask) {
    if (this.a.decrementAndGet() <= 0)
      a(); 
  }
  
  public void onTaskPrepared(Task paramTask) {
    this.b.execute(paramTask);
  }
  
  public void run(Task paramTask) {
    paramTask.a(this);
    paramTask.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\task\ThreadPoolTaskRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */