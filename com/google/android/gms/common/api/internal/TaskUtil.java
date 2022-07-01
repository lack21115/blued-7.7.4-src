package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class TaskUtil {
  public static void setResultOrApiException(Status paramStatus, TaskCompletionSource<Void> paramTaskCompletionSource) {
    setResultOrApiException(paramStatus, null, paramTaskCompletionSource);
  }
  
  public static <TResult> void setResultOrApiException(Status paramStatus, TResult paramTResult, TaskCompletionSource<TResult> paramTaskCompletionSource) {
    if (paramStatus.isSuccess()) {
      paramTaskCompletionSource.setResult(paramTResult);
      return;
    } 
    paramTaskCompletionSource.setException((Exception)new ApiException(paramStatus));
  }
  
  @Deprecated
  public static Task<Void> toVoidTaskThatFailsOnFalse(Task<Boolean> paramTask) {
    return paramTask.continueWith(new zacj());
  }
  
  public static <ResultT> boolean trySetResultOrApiException(Status paramStatus, ResultT paramResultT, TaskCompletionSource<ResultT> paramTaskCompletionSource) {
    return paramStatus.isSuccess() ? paramTaskCompletionSource.trySetResult(paramResultT) : paramTaskCompletionSource.trySetException((Exception)new ApiException(paramStatus));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\TaskUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */