package com.loopj.android.http;

import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest implements Runnable {
  private boolean cancelIsNotified;
  
  private final AbstractHttpClient client;
  
  private final HttpContext context;
  
  private int executionCount;
  
  private boolean isCancelled;
  
  private boolean isFinished;
  
  private boolean isRequestPreProcessed;
  
  private final HttpUriRequest request;
  
  private final ResponseHandlerInterface responseHandler;
  
  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, ResponseHandlerInterface paramResponseHandlerInterface) {
    this.client = paramAbstractHttpClient;
    this.context = paramHttpContext;
    this.request = paramHttpUriRequest;
    this.responseHandler = paramResponseHandlerInterface;
  }
  
  private void makeRequest() throws IOException {
    if (isCancelled())
      return; 
    if (this.request.getURI().getScheme() != null) {
      HttpResponse httpResponse = this.client.execute(this.request, this.context);
      if (!isCancelled()) {
        ResponseHandlerInterface responseHandlerInterface = this.responseHandler;
        if (responseHandlerInterface == null)
          return; 
        responseHandlerInterface.onPreProcessResponse(responseHandlerInterface, httpResponse);
        if (isCancelled())
          return; 
        this.responseHandler.sendResponseMessage(httpResponse);
        if (isCancelled())
          return; 
        responseHandlerInterface = this.responseHandler;
        responseHandlerInterface.onPostProcessResponse(responseHandlerInterface, httpResponse);
      } 
      return;
    } 
    throw new MalformedURLException("No valid URI scheme was provided");
  }
  
  private void makeRequestWithRetries() throws IOException {
    HttpRequestRetryHandler httpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
    Object object = null;
    boolean bool = true;
    while (true) {
      while (true)
        break; 
      if (SYNTHETIC_LOCAL_VARIABLE_2 != null) {
        Object object1 = SYNTHETIC_LOCAL_VARIABLE_2;
        object = SYNTHETIC_LOCAL_VARIABLE_4;
        if (this.responseHandler != null) {
          this.responseHandler.sendRetryMessage(this.executionCount);
          object1 = SYNTHETIC_LOCAL_VARIABLE_2;
          object = SYNTHETIC_LOCAL_VARIABLE_4;
        } 
      } 
    } 
  }
  
  private void sendCancelNotification() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield isFinished : Z
    //   6: ifne -> 44
    //   9: aload_0
    //   10: getfield isCancelled : Z
    //   13: ifeq -> 44
    //   16: aload_0
    //   17: getfield cancelIsNotified : Z
    //   20: ifne -> 44
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield cancelIsNotified : Z
    //   28: aload_0
    //   29: getfield responseHandler : Lcom/loopj/android/http/ResponseHandlerInterface;
    //   32: ifnull -> 44
    //   35: aload_0
    //   36: getfield responseHandler : Lcom/loopj/android/http/ResponseHandlerInterface;
    //   39: invokeinterface sendCancelMessage : ()V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	44	47	finally
  }
  
  public boolean cancel(boolean paramBoolean) {
    this.isCancelled = true;
    this.request.abort();
    return isCancelled();
  }
  
  public boolean isCancelled() {
    if (this.isCancelled)
      sendCancelNotification(); 
    return this.isCancelled;
  }
  
  public boolean isDone() {
    return (isCancelled() || this.isFinished);
  }
  
  public void onPostProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void onPreProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isCancelled : ()Z
    //   4: ifeq -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield isRequestPreProcessed : Z
    //   12: ifne -> 25
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield isRequestPreProcessed : Z
    //   20: aload_0
    //   21: aload_0
    //   22: invokevirtual onPreProcessRequest : (Lcom/loopj/android/http/AsyncHttpRequest;)V
    //   25: aload_0
    //   26: invokevirtual isCancelled : ()Z
    //   29: ifeq -> 33
    //   32: return
    //   33: aload_0
    //   34: getfield responseHandler : Lcom/loopj/android/http/ResponseHandlerInterface;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull -> 48
    //   42: aload_1
    //   43: invokeinterface sendStartMessage : ()V
    //   48: aload_0
    //   49: invokevirtual isCancelled : ()Z
    //   52: ifeq -> 56
    //   55: return
    //   56: aload_0
    //   57: invokespecial makeRequestWithRetries : ()V
    //   60: goto -> 102
    //   63: astore_1
    //   64: aload_0
    //   65: invokevirtual isCancelled : ()Z
    //   68: ifne -> 93
    //   71: aload_0
    //   72: getfield responseHandler : Lcom/loopj/android/http/ResponseHandlerInterface;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull -> 93
    //   80: aload_2
    //   81: iconst_0
    //   82: aconst_null
    //   83: aconst_null
    //   84: aload_1
    //   85: invokeinterface sendFailureMessage : (I[Lorg/apache/http/Header;[BLjava/lang/Throwable;)V
    //   90: goto -> 102
    //   93: ldc 'AsyncHttpRequest'
    //   95: ldc 'makeRequestWithRetries returned error, but handler is null'
    //   97: aload_1
    //   98: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   101: pop
    //   102: aload_0
    //   103: invokevirtual isCancelled : ()Z
    //   106: ifeq -> 110
    //   109: return
    //   110: aload_0
    //   111: getfield responseHandler : Lcom/loopj/android/http/ResponseHandlerInterface;
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull -> 125
    //   119: aload_1
    //   120: invokeinterface sendFinishMessage : ()V
    //   125: aload_0
    //   126: invokevirtual isCancelled : ()Z
    //   129: ifeq -> 133
    //   132: return
    //   133: aload_0
    //   134: aload_0
    //   135: invokevirtual onPostProcessRequest : (Lcom/loopj/android/http/AsyncHttpRequest;)V
    //   138: aload_0
    //   139: iconst_1
    //   140: putfield isFinished : Z
    //   143: return
    // Exception table:
    //   from	to	target	type
    //   56	60	63	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\AsyncHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */