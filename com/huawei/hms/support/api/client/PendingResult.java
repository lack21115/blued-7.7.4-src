package com.huawei.hms.support.api.client;

import android.os.Looper;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {
  public abstract R await();
  
  public abstract R await(long paramLong, TimeUnit paramTimeUnit);
  
  @Deprecated
  public abstract void cancel();
  
  public <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> paramResultConvert) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public abstract boolean isCanceled();
  
  public abstract void setResultCallback(Looper paramLooper, ResultCallback<R> paramResultCallback);
  
  public abstract void setResultCallback(ResultCallback<R> paramResultCallback);
  
  @Deprecated
  public abstract void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\PendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */