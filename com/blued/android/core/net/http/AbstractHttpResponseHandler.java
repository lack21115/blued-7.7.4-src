package com.blued.android.core.net.http;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Log;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Apm;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class AbstractHttpResponseHandler<T> {
  protected static final int CANCEL_MESSAGE = 5;
  
  protected static final int FAILURE_MESSAGE = 1;
  
  protected static final int FINISH_MESSAGE = 3;
  
  protected static final int PROGRESS_MESSAGE = 4;
  
  protected static final int START_MESSAGE = 2;
  
  protected static final int SUCCESS_MESSAGE = 0;
  
  private Object extraData;
  
  protected HttpRequestWrapper requestWrapper;
  
  private String serverIP = "";
  
  private long startTime = 0L;
  
  private boolean uiCallback;
  
  public AbstractHttpResponseHandler() {
    this(false);
  }
  
  public AbstractHttpResponseHandler(boolean paramBoolean) {
    this.uiCallback = paramBoolean;
  }
  
  private boolean isActive() {
    HttpRequestWrapper httpRequestWrapper = this.requestWrapper;
    return (httpRequestWrapper == null || httpRequestWrapper.e() == null || this.requestWrapper.e().isActive());
  }
  
  public Object getData() {
    return this.extraData;
  }
  
  public HttpRequestWrapper getRequestWrapper() {
    return this.requestWrapper;
  }
  
  public abstract long getResponseLength(T paramT);
  
  public abstract String getResponseType();
  
  protected void handleCancelMessage() {
    if (isActive())
      onCancel(); 
  }
  
  protected void handleFailureMessage(String paramString, Throwable paramThrowable, int paramInt, T paramT) {
    if (isActive()) {
      long l;
      Apm apm = BluedStatistics.b();
      String str = getResponseType();
      if (0L == this.startTime) {
        l = 0L;
      } else {
        l = SystemClock.uptimeMillis() - this.startTime;
      } 
      apm.a(paramString, paramInt, str, paramThrowable, l, this.serverIP);
      onFailure(paramThrowable, paramInt, paramT);
    } 
  }
  
  protected void handleFinishMessage() {
    if (isActive())
      onFinish(); 
  }
  
  protected void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown msg:");
                stringBuilder.append(paramMessage);
                Log.e("HttpManager", stringBuilder.toString());
                handleCancelMessage();
                return;
              } 
              handleCancelMessage();
              return;
            } 
            arrayOfObject = (Object[])paramMessage.obj;
            handleProgressMessage(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue());
            return;
          } 
          handleFinishMessage();
          return;
        } 
        handleStartMessage();
        return;
      } 
      arrayOfObject = (Object[])((Message)arrayOfObject).obj;
      handleFailureMessage((String)arrayOfObject[0], (Throwable)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue(), (T)arrayOfObject[3]);
      return;
    } 
    Object[] arrayOfObject = (Object[])((Message)arrayOfObject).obj;
    handleSuccessMessage((String)arrayOfObject[0], ((Integer)arrayOfObject[1]).intValue(), (T)arrayOfObject[2]);
  }
  
  protected void handleProgressMessage(int paramInt1, int paramInt2) {
    if (isActive())
      onProgress(paramInt1, paramInt2); 
  }
  
  protected void handleStartMessage() {
    this.startTime = SystemClock.uptimeMillis();
    if (isActive())
      onStart(); 
  }
  
  protected void handleSuccessMessage(String paramString, int paramInt, T paramT) {
    if (isActive()) {
      Apm apm = BluedStatistics.b();
      String str = getResponseType();
      long l2 = getResponseLength(paramT);
      long l3 = this.startTime;
      long l1 = 0L;
      if (0L != l3)
        l1 = SystemClock.uptimeMillis() - this.startTime; 
      apm.a(paramString, paramInt, str, l2, l1, this.serverIP);
      onSuccess(paramInt, paramT);
    } 
  }
  
  protected boolean isCancelled() {
    if (Thread.currentThread().isInterrupted())
      return true; 
    HttpRequestWrapper httpRequestWrapper = this.requestWrapper;
    if (httpRequestWrapper != null) {
      IRequestHost iRequestHost = httpRequestWrapper.e();
      if (iRequestHost != null)
        return iRequestHost.isActive() ^ true; 
    } 
    return false;
  }
  
  protected Message obtainMessage(int paramInt, Object paramObject) {
    if (this.uiCallback)
      return AppInfo.n().obtainMessage(paramInt, paramObject); 
    Message message = Message.obtain();
    message.what = paramInt;
    message.obj = paramObject;
    return message;
  }
  
  public boolean onAccept(int paramInt, long paramLong) {
    return true;
  }
  
  public abstract void onCancel();
  
  @Deprecated
  public abstract void onFailure(Throwable paramThrowable);
  
  public void onFailure(Throwable paramThrowable, int paramInt, T paramT) {
    onFailure(paramThrowable);
  }
  
  public abstract void onFinish();
  
  public abstract void onProgress(int paramInt1, int paramInt2);
  
  public abstract void onStart();
  
  public void onSuccess(int paramInt, T paramT) {
    onSuccess(paramT);
  }
  
  public abstract void onSuccess(T paramT);
  
  protected abstract T parseResponse(int paramInt, ResponseBody paramResponseBody) throws IOException;
  
  protected void sendCancelMessage(String paramString) {
    if (HttpManager.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cancel, reason:");
      stringBuilder.append(paramString);
      Log.a("HttpManager", stringBuilder.toString());
    } 
    sendMessage(obtainMessage(5, null));
  }
  
  protected void sendFailureMessage(String paramString, Throwable paramThrowable, int paramInt, T paramT) {
    if (HttpManager.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fail, url:");
      stringBuilder.append(paramString);
      stringBuilder.append(", e:");
      stringBuilder.append(paramThrowable);
      stringBuilder.append(", statusCode:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", responseBody:");
      stringBuilder.append(paramT);
      Log.a("HttpManager", stringBuilder.toString());
    } 
    sendMessage(obtainMessage(1, new Object[] { paramString, paramThrowable, Integer.valueOf(paramInt), paramT }));
  }
  
  protected void sendFinishMessage() {
    sendMessage(obtainMessage(3, null));
  }
  
  protected void sendMessage(Message paramMessage) {
    if (this.uiCallback) {
      AppInfo.n().post(new Runnable(this, paramMessage) {
            public void run() {
              this.b.handleMessage(this.a);
            }
          });
      return;
    } 
    handleMessage(paramMessage);
  }
  
  public void sendProgressMessage(int paramInt1, int paramInt2) {
    sendMessage(obtainMessage(4, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  protected void sendResponseMessage(String paramString, Response paramResponse) {
    StringBuilder stringBuilder;
    long l;
    Response response = null;
    if (paramResponse == null) {
      sendFailureMessage(paramString, new Exception("response is null!"), -1001, null);
      return;
    } 
    ResponseBody responseBody = paramResponse.h();
    int i = paramResponse.c();
    if (responseBody != null) {
      l = responseBody.b();
    } else {
      l = 0L;
    } 
    if (!onAccept(i, l)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("response donot accept, statusCode:");
      stringBuilder.append(i);
      stringBuilder.append(", entityLength:");
      stringBuilder.append(l);
      sendCancelMessage(stringBuilder.toString());
      return;
    } 
    try {
      responseBody = (ResponseBody)parseResponse(i, responseBody);
      iOException = null;
    } catch (IOException iOException) {
      responseBody = null;
    } 
    if (iOException != null) {
      int j = i;
      if (i == 0)
        j = StatusCode.a(iOException); 
      sendFailureMessage((String)stringBuilder, iOException, j, (T)responseBody);
      return;
    } 
    if (i >= 300) {
      Exception exception;
      if (HttpManager.c()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("status code is ");
        stringBuilder1.append(i);
        Log.e("HttpManager", stringBuilder1.toString());
      } 
      if (TextUtils.isEmpty(paramResponse.e())) {
        paramResponse = response;
      } else {
        exception = new Exception(paramResponse.e());
      } 
      sendFailureMessage((String)stringBuilder, exception, i, (T)responseBody);
      return;
    } 
    sendSuccessMessage((String)stringBuilder, i, (T)responseBody);
  }
  
  protected void sendStartMessage() {
    sendMessage(obtainMessage(2, null));
  }
  
  protected void sendSuccessMessage(String paramString, int paramInt, T paramT) {
    if (HttpManager.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("success, url:");
      stringBuilder.append(paramString);
      stringBuilder.append(", statusCode:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", responseBody:");
      stringBuilder.append(paramT);
      Log.a("HttpManager", stringBuilder.toString());
    } 
    sendMessage(obtainMessage(0, new Object[] { paramString, Integer.valueOf(paramInt), paramT }));
  }
  
  public void setData(Object paramObject) {
    this.extraData = paramObject;
  }
  
  public void setServerIP(String paramString) {
    this.serverIP = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\AbstractHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */