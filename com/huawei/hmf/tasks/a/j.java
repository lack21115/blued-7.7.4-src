package com.huawei.hmf.tasks.a;

import android.os.Looper;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class j {
  public static <TResult> TResult a(Task<TResult> paramTask) throws ExecutionException {
    if (paramTask.b())
      return (TResult)paramTask.d(); 
    throw new ExecutionException(paramTask.e());
  }
  
  public static void a(String paramString) {
    if (Looper.myLooper() != Looper.getMainLooper())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  public final <TResult> Task<TResult> a(Executor paramExecutor, Callable<TResult> paramCallable) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    try {
      paramExecutor.execute(new Runnable(this, taskCompletionSource, paramCallable) {
            public final void run() {
              try {
                this.a.a(this.b.call());
                return;
              } catch (Exception exception) {
                this.a.a(exception);
                return;
              } 
            }
          });
    } catch (Exception exception) {
      taskCompletionSource.a(exception);
    } 
    return taskCompletionSource.a();
  }
  
  public static final class a<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
    public final CountDownLatch a = new CountDownLatch(1);
    
    public final void a() {
      this.a.countDown();
    }
    
    public final void a(Exception param1Exception) {
      this.a.countDown();
    }
    
    public final void a(TResult param1TResult) {
      this.a.countDown();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */