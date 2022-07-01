package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {
  private static final String TAG = "PendingResultImpl";
  
  private WeakReference<ApiClient> api;
  
  private CountDownLatch countLatch;
  
  private boolean isNeedReport = true;
  
  private R result = null;
  
  private String transId = null;
  
  protected DatagramTransport transport = null;
  
  private String url = null;
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity) {
    init(paramApiClient, paramString, paramIMessageEntity, getResponseType(), 0);
  }
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, int paramInt) {
    init(paramApiClient, paramString, paramIMessageEntity, getResponseType(), paramInt);
  }
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass) {
    init(paramApiClient, paramString, paramIMessageEntity, paramClass, 0);
  }
  
  private void biReportEvent(int paramInt1, int paramInt2) {
    HMSLog.i("PendingResultImpl", "biReportEvent ====== ");
    ApiClient apiClient = this.api.get();
    if (apiClient != null && this.url != null) {
      if (HiAnalyticsUtil.getInstance().hasError(apiClient.getContext()))
        return; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("package", apiClient.getPackageName());
      hashMap.put("baseVersion", "5.0.4.301");
      if (paramInt2 == 1) {
        hashMap.put("direction", "req");
      } else {
        hashMap.put("direction", "rsp");
        hashMap.put("result", String.valueOf(paramInt1));
        R r = this.result;
        if (r != null && r.getStatus() != null)
          hashMap.put("statusCode", String.valueOf(this.result.getStatus().getStatusCode())); 
      } 
      hashMap.put("version", "0");
      String str2 = Util.getAppId(apiClient.getContext());
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        SubAppInfo subAppInfo = apiClient.getSubAppInfo();
        str1 = str2;
        if (subAppInfo != null)
          str1 = subAppInfo.getSubAppID(); 
      } 
      hashMap.put("appid", str1);
      if (TextUtils.isEmpty(this.transId)) {
        this.transId = TransactionIdCreater.getId(str1, this.url);
        hashMap.put("transId", this.transId);
      } else {
        hashMap.put("transId", this.transId);
        this.transId = null;
      } 
      String[] arrayOfString = this.url.split("\\.");
      if (arrayOfString.length >= 2) {
        hashMap.put("service", arrayOfString[0]);
        hashMap.put("apiName", arrayOfString[1]);
      } 
      hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
      hashMap.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
      HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), "HMS_SDK_BASE_CALL_AIDL", hashMap);
    } 
  }
  
  private void init(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass, int paramInt) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("init uri:");
    stringBuilder2.append(paramString);
    HMSLog.i("PendingResultImpl", stringBuilder2.toString());
    this.url = paramString;
    if (paramApiClient == null) {
      HMSLog.e("PendingResultImpl", "client is null");
      return;
    } 
    this.api = new WeakReference<ApiClient>(paramApiClient);
    this.countLatch = new CountDownLatch(1);
    try {
      this.transport = Class.forName(paramApiClient.getTransportName()).getConstructor(new Class[] { String.class, IMessageEntity.class, Class.class, int.class }).newInstance(new Object[] { paramString, paramIMessageEntity, paramClass, Integer.valueOf(paramInt) });
      return;
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {
    
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (ClassNotFoundException classNotFoundException) {}
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("gen transport error:");
    stringBuilder1.append(classNotFoundException.getMessage());
    HMSLog.e("PendingResultImpl", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Instancing transport exception, ");
    stringBuilder1.append(classNotFoundException.getMessage());
    throw new IllegalStateException(stringBuilder1.toString(), classNotFoundException);
  }
  
  private void setResult(int paramInt, IMessageEntity paramIMessageEntity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setResult:");
    stringBuilder.append(paramInt);
    HMSLog.i("PendingResultImpl", stringBuilder.toString());
    if (paramIMessageEntity instanceof AbstractMessageEntity) {
      Status status = ((AbstractMessageEntity)paramIMessageEntity).getCommonStatus();
    } else {
      stringBuilder = null;
    } 
    if (paramInt == 0) {
      this.result = onComplete((T)paramIMessageEntity);
    } else {
      this.result = onError(paramInt);
    } 
    if (this.isNeedReport)
      biReportEvent(paramInt, 2); 
    R r = this.result;
    if (r != null) {
      Status status = r.getStatus();
      if (status != null && stringBuilder != null) {
        StringBuilder stringBuilder1;
        paramInt = status.getStatusCode();
        String str1 = status.getStatusMessage();
        int i = stringBuilder.getStatusCode();
        String str2 = stringBuilder.getStatusMessage();
        if (paramInt != i) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("rstStatus code (");
          stringBuilder1.append(paramInt);
          stringBuilder1.append(") is not equal commonStatus code (");
          stringBuilder1.append(i);
          stringBuilder1.append(")");
          HMSLog.e("PendingResultImpl", stringBuilder1.toString());
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("rstStatus msg (");
          stringBuilder1.append(str1);
          stringBuilder1.append(") is not equal commonStatus msg (");
          stringBuilder1.append(str2);
          stringBuilder1.append(")");
          HMSLog.e("PendingResultImpl", stringBuilder1.toString());
          return;
        } 
        if (TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("rstStatus msg (");
          stringBuilder2.append(str1);
          stringBuilder2.append(") is not equal commonStatus msg (");
          stringBuilder2.append(str2);
          stringBuilder2.append(")");
          HMSLog.i("PendingResultImpl", stringBuilder2.toString());
          this.result.setStatus(new Status(paramInt, str2, stringBuilder1.getResolution()));
        } 
      } 
    } 
  }
  
  public final R await() {
    HMSLog.i("PendingResultImpl", "await");
    if (Looper.myLooper() != Looper.getMainLooper())
      return awaitOnAnyThread(); 
    HMSLog.e("PendingResultImpl", "await in main thread");
    throw new IllegalStateException("await must not be called on the UI thread");
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("await timeout:");
    stringBuilder.append(paramLong);
    stringBuilder.append(" unit:");
    stringBuilder.append(paramTimeUnit.toString());
    HMSLog.i("PendingResultImpl", stringBuilder.toString());
    if (Looper.myLooper() != Looper.getMainLooper())
      return awaitOnAnyThread(paramLong, paramTimeUnit); 
    HMSLog.i("PendingResultImpl", "await in main thread");
    throw new IllegalStateException("await must not be called on the UI thread");
  }
  
  public final R awaitOnAnyThread() {
    HMSLog.i("PendingResultImpl", "awaitOnAnyThread");
    WeakReference<ApiClient> weakReference = this.api;
    if (weakReference == null) {
      HMSLog.e("PendingResultImpl", "api is null");
      setResult(907135003, null);
      return this.result;
    } 
    ApiClient apiClient = weakReference.get();
    if (!checkApiClient(apiClient)) {
      HMSLog.e("PendingResultImpl", "client invalid");
      setResult(907135003, null);
      return this.result;
    } 
    if (this.isNeedReport)
      biReportEvent(0, 1); 
    this.transport.send(apiClient, new DatagramTransport.CallBack() {
          public void onCallback(int param1Int, IMessageEntity param1IMessageEntity) {
            PendingResultImpl.this.setResult(param1Int, param1IMessageEntity);
            PendingResultImpl.this.countLatch.countDown();
          }
        });
    try {
      this.countLatch.await();
    } catch (InterruptedException interruptedException) {
      HMSLog.e("PendingResultImpl", "await in anythread InterruptedException");
      setResult(907135001, null);
    } 
    return this.result;
  }
  
  public final R awaitOnAnyThread(long paramLong, TimeUnit paramTimeUnit) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("awaitOnAnyThread timeout:");
    stringBuilder.append(paramLong);
    stringBuilder.append(" unit:");
    stringBuilder.append(paramTimeUnit.toString());
    HMSLog.i("PendingResultImpl", stringBuilder.toString());
    WeakReference<ApiClient> weakReference = this.api;
    if (weakReference == null) {
      HMSLog.e("PendingResultImpl", "api is null");
      setResult(907135003, null);
      return this.result;
    } 
    ApiClient apiClient = weakReference.get();
    if (!checkApiClient(apiClient)) {
      HMSLog.e("PendingResultImpl", "client invalid");
      setResult(907135003, null);
      return this.result;
    } 
    final AtomicBoolean cancelled = new AtomicBoolean();
    if (this.isNeedReport)
      biReportEvent(0, 1); 
    this.transport.post(apiClient, new DatagramTransport.CallBack() {
          public void onCallback(int param1Int, IMessageEntity param1IMessageEntity) {
            if (!cancelled.get())
              PendingResultImpl.this.setResult(param1Int, param1IMessageEntity); 
            PendingResultImpl.this.countLatch.countDown();
          }
        });
    try {
      if (!this.countLatch.await(paramLong, paramTimeUnit)) {
        atomicBoolean.set(true);
        setResult(907135004, null);
      } 
    } catch (InterruptedException interruptedException) {
      HMSLog.e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
      setResult(907135001, null);
    } 
    return this.result;
  }
  
  @Deprecated
  public void cancel() {}
  
  protected boolean checkApiClient(ApiClient paramApiClient) {
    return true;
  }
  
  protected Class<T> getResponseType() {
    Type type = getClass().getGenericSuperclass();
    if (type != null) {
      type = ((ParameterizedType)type).getActualTypeArguments()[1];
      if (type != null)
        return (Class<T>)type; 
    } 
    return null;
  }
  
  @Deprecated
  public boolean isCanceled() {
    return false;
  }
  
  public abstract R onComplete(T paramT);
  
  protected R onError(int paramInt) {
    Type type = getClass().getGenericSuperclass();
    if (type != null) {
      type = ((ParameterizedType)type).getActualTypeArguments()[0];
    } else {
      type = null;
    } 
    if (type != null) {
      type = GenericTypeReflector.getType(type);
    } else {
      type = null;
    } 
    if (type != null)
      try {
        this.result = (R)type.newInstance();
        this.result.setStatus(new Status(paramInt));
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("on Error:");
        stringBuilder.append(exception.getMessage());
        HMSLog.e("PendingResultImpl", stringBuilder.toString());
        return null;
      }  
    return this.result;
  }
  
  public final void setResultCallback(Looper paramLooper, final ResultCallback<R> callback) {
    HMSLog.i("PendingResultImpl", "setResultCallback");
    Looper looper = paramLooper;
    if (paramLooper == null)
      looper = Looper.myLooper(); 
    final CallbackHandler<Result> cb = new CallbackHandler<Result>(looper);
    WeakReference<ApiClient> weakReference = this.api;
    if (weakReference == null) {
      HMSLog.e("PendingResultImpl", "api is null");
      setResult(907135003, null);
      return;
    } 
    ApiClient apiClient = weakReference.get();
    if (!checkApiClient(apiClient)) {
      HMSLog.e("PendingResultImpl", "client is invalid");
      setResult(907135003, null);
      callbackHandler.post(callback, (Result)this.result);
      return;
    } 
    if (this.isNeedReport)
      biReportEvent(0, 1); 
    this.transport.post(apiClient, new DatagramTransport.CallBack() {
          public void onCallback(int param1Int, IMessageEntity param1IMessageEntity) {
            PendingResultImpl.this.setResult(param1Int, param1IMessageEntity);
            cb.post(callback, (Result)PendingResultImpl.this.result);
          }
        });
  }
  
  public void setResultCallback(ResultCallback<R> paramResultCallback) {
    this.isNeedReport = paramResultCallback instanceof com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback ^ true;
    setResultCallback(Looper.getMainLooper(), paramResultCallback);
  }
  
  @Deprecated
  public void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit) {
    setResultCallback(paramResultCallback);
  }
  
  public static class CallbackHandler<R extends Result> extends Handler {
    public CallbackHandler() {
      this(Looper.getMainLooper());
    }
    
    public CallbackHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      if (param1Message.what != 1)
        return; 
      Pair pair = (Pair)param1Message.obj;
      send((ResultCallback<? super R>)pair.first, (R)pair.second);
    }
    
    public void post(ResultCallback<? super R> param1ResultCallback, R param1R) {
      sendMessage(obtainMessage(1, new Pair(param1ResultCallback, param1R)));
    }
    
    protected void send(ResultCallback<? super R> param1ResultCallback, R param1R) {
      param1ResultCallback.onResult(param1R);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\PendingResultImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */