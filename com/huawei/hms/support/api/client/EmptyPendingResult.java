package com.huawei.hms.support.api.client;

import android.os.Looper;
import java.util.concurrent.TimeUnit;

public class EmptyPendingResult<R extends Result> extends PendingResult<R> {
  private R result;
  
  public R await() {
    return this.result;
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit) {
    return this.result;
  }
  
  public void cancel() {}
  
  public R getResult() {
    return this.result;
  }
  
  public boolean isCanceled() {
    return false;
  }
  
  public void setResult(R paramR) {
    this.result = paramR;
  }
  
  public void setResultCallback(Looper paramLooper, ResultCallback<R> paramResultCallback) {}
  
  public void setResultCallback(ResultCallback<R> paramResultCallback) {}
  
  public void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\EmptyPendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */