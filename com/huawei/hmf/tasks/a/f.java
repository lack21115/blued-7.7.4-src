package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class f<TResult> implements ExecuteResult<TResult> {
  private OnFailureListener a;
  
  private Executor b;
  
  private final Object c = new Object();
  
  f(Executor paramExecutor, OnFailureListener paramOnFailureListener) {
    this.a = paramOnFailureListener;
    this.b = paramExecutor;
  }
  
  public final void a() {
    synchronized (this.c) {
      this.a = null;
      return;
    } 
  }
  
  public final void a(Task<TResult> paramTask) {
    if (!paramTask.b() && !paramTask.c())
      this.b.execute(new Runnable(this, paramTask) {
            public final void run() {
              synchronized (f.a(this.b)) {
                if (f.b(this.b) != null)
                  f.b(this.b).a(this.a.e()); 
                return;
              } 
            }
          }); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */