package com.huawei.hmf.tasks;

public interface SuccessContinuation<TResult, TContinuationResult> {
  Task<TContinuationResult> a(TResult paramTResult) throws Exception;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\SuccessContinuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */