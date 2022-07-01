package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.j;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Tasks {
  private static j a = new j();
  
  public static <TResult> Task<TResult> a(Callable<TResult> paramCallable) {
    return a.a(TaskExecutors.b(), paramCallable);
  }
  
  public static <TResult> TResult a(Task<TResult> paramTask) throws ExecutionException, InterruptedException {
    j.a("await must not be called on the UI thread");
    if (paramTask.a())
      return (TResult)j.a(paramTask); 
    j.a a = new j.a();
    paramTask.a((OnSuccessListener<TResult>)a).a((OnFailureListener)a);
    a.a.await();
    return (TResult)j.a(paramTask);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\Tasks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */