package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;

public final class PendingResultsCreator {
  public static PendingResult<Status> discardedPendingResult() {
    return new DiscardedPendingResult<Result>();
  }
  
  public static <R extends Result> PendingResult<R> discardedPendingResult(R paramR) {
    return new DiscardedPendingResult<R>(paramR);
  }
  
  public static <R extends Result> OptionalPendingResult<R> instantPendingResult(R paramR) {
    return (OptionalPendingResult<R>)new OptionalPendingResultImpl(new InstantPendingResult<R>(paramR));
  }
  
  public static PendingResult<Status> instantPendingResult(Status paramStatus) {
    return new InstantPendingResult<Status>(paramStatus);
  }
  
  public static class DiscardedPendingResult<R extends Result> extends EmptyPendingResult {
    public DiscardedPendingResult() {}
    
    public DiscardedPendingResult(R param1R) {
      setResult(param1R);
    }
    
    public boolean isCanceled() {
      return true;
    }
  }
  
  public static class InstantPendingResult<R extends Result> extends EmptyPendingResult {
    public InstantPendingResult(R param1R) {
      setResult(param1R);
    }
    
    public void cancel() {
      throw new IllegalStateException("cancel() is not available.");
    }
    
    public void setResultCallback(ResultCallback<R> param1ResultCallback) {
      param1ResultCallback.onResult(getResult());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\PendingResultsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */