package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class b<TResult> implements ExecuteResult<TResult> {
  private OnCanceledListener a;
  
  private Executor b;
  
  private final Object c;
  
  public final void a() {
    synchronized (this.c) {
      this.a = null;
      return;
    } 
  }
  
  public final void a(Task<TResult> paramTask) {
    if (paramTask.c())
      this.b.execute(new Runnable(this) {
            public final void run() {
              synchronized (b.a(this.a)) {
                if (b.b(this.a) != null)
                  b.b(this.a).a(); 
                return;
              } 
            }
          }); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */