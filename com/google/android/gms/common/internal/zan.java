package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class zan implements PendingResult.StatusListener {
  zan(PendingResult paramPendingResult, TaskCompletionSource paramTaskCompletionSource, PendingResultUtil.ResultConverter paramResultConverter, PendingResultUtil.zaa paramzaa) {}
  
  public final void onComplete(Status paramStatus) {
    Result result;
    if (paramStatus.isSuccess()) {
      result = this.zaa.await(0L, TimeUnit.MILLISECONDS);
      this.zab.setResult(this.zac.convert(result));
      return;
    } 
    this.zab.setException((Exception)this.zad.zaa((Status)result));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */