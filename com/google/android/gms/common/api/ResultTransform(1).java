package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.zaca;

public abstract class ResultTransform<R extends Result, S extends Result> {
  public final PendingResult<S> createFailedResult(Status paramStatus) {
    return (PendingResult<S>)new zaca(paramStatus);
  }
  
  public Status onFailure(Status paramStatus) {
    return paramStatus;
  }
  
  public abstract PendingResult<S> onSuccess(R paramR);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\ResultTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */