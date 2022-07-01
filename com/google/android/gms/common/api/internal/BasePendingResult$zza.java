package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public final class BasePendingResult$zza extends Handler {
  public BasePendingResult$zza() {
    this(Looper.getMainLooper());
  }
  
  public BasePendingResult$zza(Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    int i;
    switch (paramMessage.what) {
      default:
        i = paramMessage.what;
        stringBuilder = new StringBuilder(45);
        stringBuilder.append("Don't know how to handle message: ");
        stringBuilder.append(i);
        Log.wtf("BasePendingResult", stringBuilder.toString(), new Exception());
        return;
      case 2:
        ((BasePendingResult)((Message)stringBuilder).obj).zzv(Status.zzftt);
        return;
      case 1:
        break;
    } 
    Pair pair = (Pair)((Message)stringBuilder).obj;
    ResultCallback resultCallback = (ResultCallback)pair.first;
    Result result = (Result)pair.second;
    try {
      resultCallback.onResult(result);
      return;
    } catch (RuntimeException runtimeException) {
      BasePendingResult.zzd(result);
      throw runtimeException;
    } 
  }
  
  public final void zza(ResultCallback paramResultCallback, Result paramResult) {
    sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramResult)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\BasePendingResult$zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */