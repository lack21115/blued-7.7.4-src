package com.google.android.gms.tasks;

public interface SuccessContinuation<TResult, TContinuationResult> {
  Task<TContinuationResult> then(TResult paramTResult) throws Exception;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\SuccessContinuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */