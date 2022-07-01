package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BasePendingResult<BatchResult> {
  private int zab;
  
  private boolean zac;
  
  private boolean zad;
  
  private final PendingResult<?>[] zae;
  
  private final Object zaf = new Object();
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient) {
    super(paramGoogleApiClient);
    this.zab = paramList.size();
    this.zae = (PendingResult<?>[])new PendingResult[this.zab];
    if (paramList.isEmpty()) {
      setResult(new BatchResult(Status.RESULT_SUCCESS, this.zae));
      return;
    } 
    for (int i = 0; i < paramList.size(); i++) {
      PendingResult<?> pendingResult = paramList.get(i);
      this.zae[i] = pendingResult;
      pendingResult.addStatusListener(new zab(this));
    } 
  }
  
  public final void cancel() {
    super.cancel();
    PendingResult<?>[] arrayOfPendingResult = this.zae;
    int j = arrayOfPendingResult.length;
    for (int i = 0; i < j; i++)
      arrayOfPendingResult[i].cancel(); 
  }
  
  public final BatchResult createFailedResult(Status paramStatus) {
    return new BatchResult(paramStatus, this.zae);
  }
  
  public static final class Builder {
    private List<PendingResult<?>> zaa = new ArrayList<PendingResult<?>>();
    
    private GoogleApiClient zab;
    
    public Builder(GoogleApiClient param1GoogleApiClient) {
      this.zab = param1GoogleApiClient;
    }
    
    public final <R extends Result> BatchResultToken<R> add(PendingResult<R> param1PendingResult) {
      BatchResultToken<Result> batchResultToken = new BatchResultToken<Result>(this.zaa.size());
      this.zaa.add(param1PendingResult);
      return (BatchResultToken)batchResultToken;
    }
    
    public final Batch build() {
      return new Batch(this.zaa, this.zab, null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */