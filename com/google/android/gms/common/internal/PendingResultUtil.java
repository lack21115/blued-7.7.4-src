package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class PendingResultUtil {
  private static final zaa zaa = new zao();
  
  public static <R extends com.google.android.gms.common.api.Result, T extends Response<R>> Task<T> toResponseTask(PendingResult<R> paramPendingResult, T paramT) {
    return toTask(paramPendingResult, new zaq((Response)paramT));
  }
  
  public static <R extends com.google.android.gms.common.api.Result, T> Task<T> toTask(PendingResult<R> paramPendingResult, ResultConverter<R, T> paramResultConverter) {
    zaa zaa1 = zaa;
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    paramPendingResult.addStatusListener(new zan(paramPendingResult, taskCompletionSource, paramResultConverter, zaa1));
    return taskCompletionSource.getTask();
  }
  
  public static <R extends com.google.android.gms.common.api.Result> Task<Void> toVoidTask(PendingResult<R> paramPendingResult) {
    return toTask(paramPendingResult, new zap());
  }
  
  public static interface ResultConverter<R extends com.google.android.gms.common.api.Result, T> {
    T convert(R param1R);
  }
  
  public static interface zaa {
    ApiException zaa(Status param1Status);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\PendingResultUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */