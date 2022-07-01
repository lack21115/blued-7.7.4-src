package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.log.HMSLog;

@Deprecated
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
  private static final String TAG = "ResultCallbacks";
  
  public abstract void onFailure(Status paramStatus);
  
  public final void onResult(R paramR) {
    try {
      Status status = paramR.getStatus();
      if (status.isSuccess()) {
        onSuccess(paramR);
        return;
      } 
      onFailure(status);
      if (paramR instanceof Releasable) {
        ((Releasable)paramR).release();
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to release ");
      stringBuilder.append(paramR);
      stringBuilder.append(", reason: ");
      stringBuilder.append(exception);
      HMSLog.w("ResultCallbacks", stringBuilder.toString());
    } 
  }
  
  public abstract void onSuccess(R paramR);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\ResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */