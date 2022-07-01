package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class h<TResult> implements ExecuteResult<TResult> {
  private OnSuccessListener<TResult> a;
  
  private Executor b;
  
  private final Object c = new Object();
  
  h(Executor paramExecutor, OnSuccessListener<TResult> paramOnSuccessListener) {
    this.a = paramOnSuccessListener;
    this.b = paramExecutor;
  }
  
  public final void a() {
    synchronized (this.c) {
      this.a = null;
      return;
    } 
  }
  
  public final void a(Task<TResult> paramTask) {
    if (paramTask.b() && !paramTask.c())
      this.b.execute(new Runnable(this, paramTask) {
            public final void run() {
              synchronized (h.a(this.b)) {
                if (h.b(this.b) != null)
                  h.b(this.b).a(this.a.d()); 
                return;
              } 
            }
          }); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */