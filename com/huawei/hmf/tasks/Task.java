package com.huawei.hmf.tasks;

import java.util.concurrent.Executor;

public abstract class Task<TResult> {
  public Task<TResult> a(OnCompleteListener<TResult> paramOnCompleteListener) {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  public abstract Task<TResult> a(OnFailureListener paramOnFailureListener);
  
  public abstract Task<TResult> a(OnSuccessListener<TResult> paramOnSuccessListener);
  
  public Task<TResult> a(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener) {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract TResult d();
  
  public abstract Exception e();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */