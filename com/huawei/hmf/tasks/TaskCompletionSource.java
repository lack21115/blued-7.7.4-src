package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;

public class TaskCompletionSource<TResult> {
  private final i<TResult> a = new i();
  
  public TaskCompletionSource() {}
  
  public TaskCompletionSource(CancellationToken paramCancellationToken) {
    paramCancellationToken.a(new Runnable(this) {
          public void run() {
            TaskCompletionSource.a(this.a).f();
          }
        });
  }
  
  public Task<TResult> a() {
    return (Task<TResult>)this.a;
  }
  
  public void a(Exception paramException) {
    this.a.a(paramException);
  }
  
  public void a(TResult paramTResult) {
    this.a.a(paramTResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\TaskCompletionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */