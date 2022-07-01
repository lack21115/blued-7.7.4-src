package com.google.android.gms.tasks;

public interface Continuation<TResult, TContinuationResult> {
  TContinuationResult then(Task<TResult> paramTask) throws Exception;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\Continuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */