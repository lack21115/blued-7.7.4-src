package com.huawei.hms.support.api.client;

import com.huawei.hms.common.internal.Preconditions;

public abstract class ResultConvert<R extends Result, S extends Result> {
  public final PendingResult newFailedPendingResult(Status paramStatus) {
    Preconditions.checkNotNull(paramStatus, "The input status cannot be null");
    Preconditions.checkArgument(paramStatus.isSuccess() ^ true, "The input status must be call with success status");
    return new FailPendingResult(paramStatus);
  }
  
  public Status onFailed(Status paramStatus) {
    Preconditions.checkNotNull(paramStatus, "The input status cannot be null");
    return (paramStatus.getStatusCode() != 0) ? paramStatus : Status.CoreException;
  }
  
  public abstract PendingResult onSuccess(Result paramResult);
  
  public class FailPendingResult extends EmptyPendingResult {
    public FailPendingResult(Status param1Status) {
      setResult((R)param1Status);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\ResultConvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */