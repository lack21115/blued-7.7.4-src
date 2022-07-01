package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class d<TResult> implements ExecuteResult<TResult> {
  Executor a;
  
  private OnCompleteListener<TResult> b;
  
  private final Object c = new Object();
  
  d(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener) {
    this.b = paramOnCompleteListener;
    this.a = paramExecutor;
  }
  
  public final void a() {
    synchronized (this.c) {
      this.b = null;
      return;
    } 
  }
  
  public final void a(Task<TResult> paramTask) {
    this.a.execute(new Runnable(this, paramTask) {
          public final void run() {
            synchronized (d.a(this.b)) {
              if (d.b(this.b) != null)
                d.b(this.b).onComplete(this.a); 
              return;
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */