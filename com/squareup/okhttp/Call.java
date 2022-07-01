package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Call {
  volatile boolean canceled;
  
  private final OkHttpClient client;
  
  HttpEngine engine;
  
  private boolean executed;
  
  Request originalRequest;
  
  protected Call(OkHttpClient paramOkHttpClient, Request paramRequest) {
    this.client = paramOkHttpClient.copyWithDefaults();
    this.originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean) throws IOException {
    return (new ApplicationInterceptorChain(0, this.originalRequest, paramBoolean)).proceed(this.originalRequest);
  }
  
  private String toLoggableString() {
    String str;
    if (this.canceled) {
      str = "canceled call";
    } else {
      str = "call";
    } 
    HttpUrl httpUrl = this.originalRequest.httpUrl().resolve("/...");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(" to ");
    stringBuilder.append(httpUrl);
    return stringBuilder.toString();
  }
  
  public void cancel() {
    this.canceled = true;
    HttpEngine httpEngine = this.engine;
    if (httpEngine != null)
      httpEngine.cancel(); 
  }
  
  public void enqueue(Callback paramCallback) {
    enqueue(paramCallback, false);
  }
  
  void enqueue(Callback paramCallback, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: ifne -> 38
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield executed : Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: getfield client : Lcom/squareup/okhttp/OkHttpClient;
    //   20: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
    //   23: new com/squareup/okhttp/Call$AsyncCall
    //   26: dup
    //   27: aload_0
    //   28: aload_1
    //   29: iload_2
    //   30: aconst_null
    //   31: invokespecial <init> : (Lcom/squareup/okhttp/Call;Lcom/squareup/okhttp/Callback;ZLcom/squareup/okhttp/Call$1;)V
    //   34: invokevirtual enqueue : (Lcom/squareup/okhttp/Call$AsyncCall;)V
    //   37: return
    //   38: new java/lang/IllegalStateException
    //   41: dup
    //   42: ldc 'Already Executed'
    //   44: invokespecial <init> : (Ljava/lang/String;)V
    //   47: athrow
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	48	finally
    //   38	48	48	finally
    //   49	51	48	finally
  }
  
  public Response execute() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: ifne -> 74
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield executed : Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: getfield client : Lcom/squareup/okhttp/OkHttpClient;
    //   20: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
    //   23: aload_0
    //   24: invokevirtual executed : (Lcom/squareup/okhttp/Call;)V
    //   27: aload_0
    //   28: iconst_0
    //   29: invokespecial getResponseWithInterceptorChain : (Z)Lcom/squareup/okhttp/Response;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull -> 50
    //   37: aload_0
    //   38: getfield client : Lcom/squareup/okhttp/OkHttpClient;
    //   41: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
    //   44: aload_0
    //   45: invokevirtual finished : (Lcom/squareup/okhttp/Call;)V
    //   48: aload_1
    //   49: areturn
    //   50: new java/io/IOException
    //   53: dup
    //   54: ldc 'Canceled'
    //   56: invokespecial <init> : (Ljava/lang/String;)V
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: getfield client : Lcom/squareup/okhttp/OkHttpClient;
    //   65: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
    //   68: aload_0
    //   69: invokevirtual finished : (Lcom/squareup/okhttp/Call;)V
    //   72: aload_1
    //   73: athrow
    //   74: new java/lang/IllegalStateException
    //   77: dup
    //   78: ldc 'Already Executed'
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	84	finally
    //   16	33	60	finally
    //   50	60	60	finally
    //   74	84	84	finally
    //   85	87	84	finally
  }
  
  Response getResponse(Request paramRequest, boolean paramBoolean) throws IOException {
    RequestBody requestBody = paramRequest.body();
    Request request = paramRequest;
    if (requestBody != null) {
      Request.Builder builder = paramRequest.newBuilder();
      MediaType mediaType = requestBody.contentType();
      if (mediaType != null)
        builder.header("Content-Type", mediaType.toString()); 
      long l = requestBody.contentLength();
      if (l != -1L) {
        builder.header("Content-Length", Long.toString(l));
        builder.removeHeader("Transfer-Encoding");
      } else {
        builder.header("Transfer-Encoding", "chunked");
        builder.removeHeader("Content-Length");
      } 
      request = builder.build();
    } 
    this.engine = new HttpEngine(this.client, request, false, false, paramBoolean, null, null, null);
    int i = 0;
    while (!this.canceled) {
      boolean bool = true;
      try {
        this.engine.sendRequest();
        this.engine.readResponse();
        Response response = this.engine.getResponse();
        Request request1 = this.engine.followUpRequest();
        if (request1 == null)
          return response; 
        StreamAllocation streamAllocation = this.engine.close();
        if (++i <= 20) {
          if (!this.engine.sameConnection(request1.httpUrl())) {
            streamAllocation.release();
            streamAllocation = null;
          } 
          this.engine = new HttpEngine(this.client, request1, false, false, paramBoolean, streamAllocation, null, response);
          continue;
        } 
        streamAllocation.release();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Too many follow-up requests: ");
        stringBuilder.append(i);
        throw new ProtocolException(stringBuilder.toString());
      } catch (RequestException requestException) {
        throw requestException.getCause();
      } catch (RouteException routeException) {
        HttpEngine httpEngine = this.engine.recover(routeException);
        if (httpEngine != null) {
          this.engine = httpEngine;
          continue;
        } 
        throw routeException.getLastConnectException();
      } catch (IOException iOException) {
        HttpEngine httpEngine = this.engine.recover(iOException, null);
      } finally {
        paramRequest = null;
      } 
      if (i != 0)
        this.engine.close().release(); 
      throw paramRequest;
    } 
    this.engine.releaseStreamAllocation();
    throw new IOException("Canceled");
  }
  
  public boolean isCanceled() {
    return this.canceled;
  }
  
  public boolean isExecuted() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  Object tag() {
    return this.originalRequest.tag();
  }
  
  class ApplicationInterceptorChain implements Interceptor.Chain {
    private final boolean forWebSocket;
    
    private final int index;
    
    private final Request request;
    
    ApplicationInterceptorChain(int param1Int, Request param1Request, boolean param1Boolean) {
      this.index = param1Int;
      this.request = param1Request;
      this.forWebSocket = param1Boolean;
    }
    
    public Connection connection() {
      return null;
    }
    
    public Response proceed(Request param1Request) throws IOException {
      Interceptor interceptor;
      if (this.index < Call.this.client.interceptors().size()) {
        ApplicationInterceptorChain applicationInterceptorChain = new ApplicationInterceptorChain(this.index + 1, param1Request, this.forWebSocket);
        interceptor = Call.this.client.interceptors().get(this.index);
        Response response = interceptor.intercept(applicationInterceptorChain);
        if (response != null)
          return response; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("application interceptor ");
        stringBuilder.append(interceptor);
        stringBuilder.append(" returned null");
        throw new NullPointerException(stringBuilder.toString());
      } 
      return Call.this.getResponse((Request)interceptor, this.forWebSocket);
    }
    
    public Request request() {
      return this.request;
    }
  }
  
  final class AsyncCall extends NamedRunnable {
    private final boolean forWebSocket;
    
    private final Callback responseCallback;
    
    private AsyncCall(Callback param1Callback, boolean param1Boolean) {
      super("OkHttp %s", new Object[] { this$0.originalRequest.urlString() });
      this.responseCallback = param1Callback;
      this.forWebSocket = param1Boolean;
    }
    
    void cancel() {
      Call.this.cancel();
    }
    
    public void execute() {
      Exception exception;
      boolean bool = true;
      try {
        Response response = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
        boolean bool1 = Call.this.canceled;
        if (bool1) {
          try {
            this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
            Call.this.client.getDispatcher().finished(this);
          } catch (IOException null) {}
        } else {
          this.responseCallback.onResponse((Response)exception);
          Call.this.client.getDispatcher().finished(this);
        } 
      } catch (IOException null) {
        bool = false;
      } finally {}
      if (bool) {
        Logger logger = Internal.logger;
        Level level = Level.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Callback failure for ");
        stringBuilder.append(Call.this.toLoggableString());
        logger.log(level, stringBuilder.toString(), exception);
      } else {
        Request request;
        if (Call.this.engine == null) {
          request = Call.this.originalRequest;
        } else {
          request = Call.this.engine.getRequest();
        } 
        this.responseCallback.onFailure(request, (IOException)exception);
      } 
      Call.this.client.getDispatcher().finished(this);
    }
    
    Call get() {
      return Call.this;
    }
    
    String host() {
      return Call.this.originalRequest.httpUrl().host();
    }
    
    Request request() {
      return Call.this.originalRequest;
    }
    
    Object tag() {
      return Call.this.originalRequest.tag();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */