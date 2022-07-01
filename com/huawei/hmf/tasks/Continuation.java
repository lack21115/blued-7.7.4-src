package com.huawei.hmf.tasks;

public interface Continuation<TResult, TContinuationResult> {
  TContinuationResult a(Task<TResult> paramTask) throws Exception;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\Continuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */