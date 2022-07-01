package com.tencent.tbs.patch.common.task;

import com.tencent.tbs.patch.common.util.PatchLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Task implements Runnable {
  private boolean a;
  
  private AtomicBoolean b = new AtomicBoolean();
  
  private AtomicBoolean c = new AtomicBoolean();
  
  private TaskRunner d;
  
  private List<Task> e = new ArrayList<Task>();
  
  private List<Runnable> f = new ArrayList<Runnable>();
  
  private void a(Runnable paramRunnable) {
    this.f.add(paramRunnable);
  }
  
  private boolean b() {
    return this.c.get();
  }
  
  private void c() {
    for (Task task : this.e) {
      if (task == null)
        return; 
      if (!task.b())
        return; 
    } 
    d();
  }
  
  private void d() {
    if (this.b.compareAndSet(false, true))
      this.d.onTaskPrepared(this); 
  }
  
  void a() {
    if (this.a)
      return; 
    this.a = true;
    List<Task> list = this.e;
    if (list == null || list.size() <= 0) {
      d();
    } else {
      for (Task task : this.e) {
        task.a(this.d);
        task.a(new Runnable(this) {
              public void run() {
                Task.a(this.a);
              }
            });
        task.a();
      } 
    } 
    this.d.onTaskEvaluated(this);
  }
  
  void a(TaskRunner paramTaskRunner) {
    this.d = paramTaskRunner;
  }
  
  public void dependsOn(Task paramTask) {
    this.e.add(paramTask);
  }
  
  public void fail(int paramInt, String paramString) {
    fail(paramInt, paramString, null);
  }
  
  public void fail(int paramInt, String paramString, Throwable paramThrowable) {
    PatchLogger.e(paramString, paramThrowable);
    TaskRunner taskRunner = this.d;
    if (taskRunner != null)
      taskRunner.a(this, paramInt, paramString, paramThrowable); 
  }
  
  public void finish() {
    this.c.set(true);
    Iterator<Runnable> iterator = this.f.iterator();
    while (iterator.hasNext())
      ((Runnable)iterator.next()).run(); 
    this.d.onTaskFinished(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\task\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */