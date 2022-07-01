package com.google.android.gms.common.api;

import android.util.Log;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
  public abstract void onFailure(Status paramStatus);
  
  public final void onResult(R paramR) {
    Status status = paramR.getStatus();
    if (status.isSuccess()) {
      onSuccess(paramR);
      return;
    } 
    onFailure(status);
    if (paramR instanceof Releasable)
      try {
        ((Releasable)paramR).release();
        return;
      } catch (RuntimeException runtimeException) {
        String str = String.valueOf(paramR);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 18);
        stringBuilder.append("Unable to release ");
        stringBuilder.append(str);
        Log.w("ResultCallbacks", stringBuilder.toString(), runtimeException);
      }  
  }
  
  public abstract void onSuccess(R paramR);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\ResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */