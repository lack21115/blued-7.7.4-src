package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {
  private final TaskApiCall<? extends AnyClient, TResult> mTaskApiCall;
  
  private final TaskCompletionSource<TResult> mTaskCompletionSource;
  
  public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> paramTaskApiCall, TaskCompletionSource<TResult> paramTaskCompletionSource) {
    super(1);
    this.mTaskApiCall = paramTaskApiCall;
    this.mTaskCompletionSource = paramTaskCompletionSource;
  }
  
  public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
    return this.mTaskApiCall;
  }
  
  public TaskCompletionSource<TResult> getTaskCompletionSource() {
    return this.mTaskCompletionSource;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\TaskApiCallWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */