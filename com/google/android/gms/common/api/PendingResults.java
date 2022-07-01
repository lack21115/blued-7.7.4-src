package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

public final class PendingResults {
  public static PendingResult<Status> canceledPendingResult() {
    StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    statusPendingResult.cancel();
    return (PendingResult<Status>)statusPendingResult;
  }
  
  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR) {
    boolean bool;
    Preconditions.checkNotNull(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Status code must be CommonStatusCodes.CANCELED");
    zaa<R> zaa = new zaa<R>(paramR);
    zaa.cancel();
    return (PendingResult<R>)zaa;
  }
  
  public static <R extends Result> PendingResult<R> immediateFailedResult(R paramR, GoogleApiClient paramGoogleApiClient) {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    Preconditions.checkArgument(paramR.getStatus().isSuccess() ^ true, "Status code must not be SUCCESS");
    zac<R> zac = new zac<R>(paramGoogleApiClient, paramR);
    zac.setResult((Result)paramR);
    return (PendingResult<R>)zac;
  }
  
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR) {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    zab<Result> zab = new zab<Result>(null);
    zab.setResult((Result)paramR);
    return (OptionalPendingResult<R>)new OptionalPendingResultImpl((PendingResult)zab);
  }
  
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR, GoogleApiClient paramGoogleApiClient) {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    zab<Result> zab = new zab<Result>(paramGoogleApiClient);
    zab.setResult((Result)paramR);
    return (OptionalPendingResult<R>)new OptionalPendingResultImpl((PendingResult)zab);
  }
  
  public static PendingResult<Status> immediatePendingResult(Status paramStatus) {
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    statusPendingResult.setResult(paramStatus);
    return (PendingResult<Status>)statusPendingResult;
  }
  
  public static PendingResult<Status> immediatePendingResult(Status paramStatus, GoogleApiClient paramGoogleApiClient) {
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult statusPendingResult = new StatusPendingResult(paramGoogleApiClient);
    statusPendingResult.setResult(paramStatus);
    return (PendingResult<Status>)statusPendingResult;
  }
  
  static final class zaa<R extends Result> extends BasePendingResult<R> {
    private final R zab;
    
    public zaa(R param1R) {
      super(Looper.getMainLooper());
      this.zab = param1R;
    }
    
    public final R createFailedResult(Status param1Status) {
      if (param1Status.getStatusCode() == this.zab.getStatus().getStatusCode())
        return this.zab; 
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
  
  static final class zab<R extends Result> extends BasePendingResult<R> {
    public zab(GoogleApiClient param1GoogleApiClient) {
      super(param1GoogleApiClient);
    }
    
    public final R createFailedResult(Status param1Status) {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
  
  static final class zac<R extends Result> extends BasePendingResult<R> {
    private final R zab;
    
    public zac(GoogleApiClient param1GoogleApiClient, R param1R) {
      super(param1GoogleApiClient);
      this.zab = param1R;
    }
    
    public final R createFailedResult(Status param1Status) {
      return this.zab;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\PendingResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */