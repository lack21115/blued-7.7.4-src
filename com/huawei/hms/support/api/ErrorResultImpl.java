package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public abstract class ErrorResultImpl<R extends Result> extends PendingResult<R> {
  private static final String TAG = "ErrorResultImpl";
  
  private R result = null;
  
  private int statusCode;
  
  public ErrorResultImpl(int paramInt) {
    this.statusCode = paramInt;
  }
  
  private R newResultInstance(int paramInt) {
    Type type = getClass().getGenericSuperclass();
    if (type != null) {
      type = GenericTypeReflector.getType(((ParameterizedType)type).getActualTypeArguments()[0]);
      try {
        this.result = (R)type.newInstance();
        this.result.setStatus(new Status(paramInt));
      } catch (InstantiationException instantiationException) {
        HMSLog.e("ErrorResultImpl", "InstantiationException");
      } catch (IllegalAccessException illegalAccessException) {
        HMSLog.e("ErrorResultImpl", "IllegalAccessException");
      } 
      return this.result;
    } 
    return null;
  }
  
  public final R await() {
    return await(0L, null);
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit) {
    if (Looper.myLooper() != Looper.getMainLooper())
      return newResultInstance(this.statusCode); 
    throw new IllegalStateException("await must not be called on the UI thread");
  }
  
  @Deprecated
  public void cancel() {}
  
  @Deprecated
  public boolean isCanceled() {
    return false;
  }
  
  public final void setResultCallback(Looper paramLooper, final ResultCallback<R> callback) {
    Looper looper = paramLooper;
    if (paramLooper == null)
      looper = Looper.myLooper(); 
    (new Handler(looper)).post(new Runnable() {
          public void run() {
            ResultCallback resultCallback = callback;
            ErrorResultImpl errorResultImpl = ErrorResultImpl.this;
            resultCallback.onResult(errorResultImpl.newResultInstance(errorResultImpl.statusCode));
          }
        });
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback) {
    setResultCallback(Looper.getMainLooper(), paramResultCallback);
  }
  
  @Deprecated
  public void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit) {
    setResultCallback(paramResultCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\ErrorResultImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */