package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class TaskExecutors {
  private static final TaskExecutors a = new TaskExecutors();
  
  private final Executor b = new ImmediateExecutor();
  
  private final ExecutorService c = a.a();
  
  private final Executor d = a.b();
  
  public static Executor a() {
    return a.d;
  }
  
  static ExecutorService b() {
    return a.c;
  }
  
  static final class ImmediateExecutor implements Executor {
    public final void execute(Runnable param1Runnable) {
      param1Runnable.run();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\TaskExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */