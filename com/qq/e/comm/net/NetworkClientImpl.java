package com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkClientImpl implements NetworkClient {
  private static final NetworkClient a = new NetworkClientImpl();
  
  private final ExecutorService b = new ThreadPoolExecutor(5, 10, 180L, TimeUnit.SECONDS, this.c);
  
  private PriorityBlockingQueue<Runnable> c = new PriorityBlockingQueue<Runnable>(15);
  
  public static HttpURLConnection followRedirect(HttpURLConnection paramHttpURLConnection) throws IOException {
    String str = null;
    if (paramHttpURLConnection == null)
      return null; 
    int i = 0;
    int j = paramHttpURLConnection.getConnectTimeout();
    int k = paramHttpURLConnection.getReadTimeout();
    try {
      String str1 = paramHttpURLConnection.getRequestProperty("User-Agent");
      str = str1;
    } catch (Exception exception) {}
    while (i < 3) {
      paramHttpURLConnection.connect();
      int m = paramHttpURLConnection.getResponseCode();
      if (m == 302 || m == 301 || m == 303) {
        String str1 = paramHttpURLConnection.getHeaderField("location");
        paramHttpURLConnection.disconnect();
        paramHttpURLConnection = (HttpURLConnection)(new URL(str1)).openConnection();
        paramHttpURLConnection.setConnectTimeout(j);
        paramHttpURLConnection.setReadTimeout(k);
        if (str != null)
          paramHttpURLConnection.setRequestProperty("User-Agent", str); 
        i++;
      } 
    } 
    if (i != 3)
      return paramHttpURLConnection; 
    StringBuilder stringBuilder = new StringBuilder("HttpURLConnection exceed max redirect ");
    stringBuilder.append(3);
    stringBuilder.append(" ");
    stringBuilder.append(paramHttpURLConnection.getURL());
    throw new IOException(stringBuilder.toString());
  }
  
  public static NetworkClient getInstance() {
    return a;
  }
  
  public Future<Response> submit(Request paramRequest) {
    return submit(paramRequest, NetworkClient.Priority.Mid);
  }
  
  public Future<Response> submit(Request paramRequest, NetworkClient.Priority paramPriority) {
    NetFutureTask<Response> netFutureTask = new NetFutureTask(new TaskCallable(paramRequest), paramPriority);
    this.b.execute(netFutureTask);
    StringBuilder stringBuilder = new StringBuilder("QueueSize:");
    stringBuilder.append(this.c.size());
    GDTLogger.d(stringBuilder.toString());
    return netFutureTask;
  }
  
  public void submit(Request paramRequest, NetworkCallBack paramNetworkCallBack) {
    submit(paramRequest, NetworkClient.Priority.Mid, paramNetworkCallBack);
  }
  
  public void submit(Request paramRequest, NetworkClient.Priority paramPriority, NetworkCallBack paramNetworkCallBack) {
    submit(paramRequest, paramPriority, paramNetworkCallBack, this.b);
  }
  
  public void submit(Request paramRequest, NetworkClient.Priority paramPriority, NetworkCallBack paramNetworkCallBack, Executor paramExecutor) {
    if (paramExecutor == null) {
      GDTLogger.e("Submit failed for no executor");
      return;
    } 
    paramExecutor.execute(new NetFutureTask(new TaskCallable(paramRequest, paramNetworkCallBack), paramPriority));
    StringBuilder stringBuilder = new StringBuilder("QueueSize:");
    stringBuilder.append(this.c.size());
    GDTLogger.d(stringBuilder.toString());
  }
  
  static class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {
    private final NetworkClient.Priority a;
    
    public NetFutureTask(Callable<T> param1Callable, NetworkClient.Priority param1Priority) {
      super(param1Callable);
      this.a = param1Priority;
    }
    
    public int compareTo(NetFutureTask<T> param1NetFutureTask) {
      return (param1NetFutureTask == null) ? 1 : (this.a.value() - param1NetFutureTask.a.value());
    }
    
    public boolean equals(Object param1Object) {
      return (param1Object != null && param1Object.getClass() == getClass() && compareTo((NetFutureTask<T>)param1Object) == 0);
    }
    
    public int hashCode() {
      return this.a.value();
    }
  }
  
  static class TaskCallable implements Callable<Response> {
    private Request a;
    
    private NetworkCallBack b;
    
    public TaskCallable(Request param1Request) {
      this(param1Request, null);
    }
    
    public TaskCallable(Request param1Request, NetworkCallBack param1NetworkCallBack) {
      this.a = param1Request;
      this.b = param1NetworkCallBack;
    }
    
    private void a(HttpURLConnection param1HttpURLConnection) {
      for (Map.Entry entry : this.a.getHeaders().entrySet())
        param1HttpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
      StringBuilder stringBuilder = new StringBuilder("GDTADNetClient-[");
      stringBuilder.append(System.getProperty("http.agent"));
      stringBuilder.append("]");
      param1HttpURLConnection.setRequestProperty("User-Agent", stringBuilder.toString());
      if (this.a.getConnectionTimeOut() > 0) {
        param1HttpURLConnection.setConnectTimeout(this.a.getConnectionTimeOut());
      } else {
        param1HttpURLConnection.setConnectTimeout(30000);
      } 
      if (this.a.getSocketTimeOut() > 0) {
        param1HttpURLConnection.setReadTimeout(this.a.getSocketTimeOut());
        return;
      } 
      param1HttpURLConnection.setReadTimeout(30000);
    }
    
    public Response call() throws Exception {
      Response response;
      NetworkCallBack networkCallBack;
      exception = null;
      try {
        HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(this.a.getUrlWithParas())).openConnection();
        a(httpURLConnection);
        if (NetworkClientImpl.null.a[this.a.getMethod().ordinal()] == 1) {
          httpURLConnection.setDoOutput(true);
          httpURLConnection.setChunkedStreamingMode(0);
          byte[] arrayOfByte = this.a.getPostData();
          if (arrayOfByte != null && arrayOfByte.length > 0) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(arrayOfByte);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
          } 
        } 
        httpURLConnection = NetworkClientImpl.followRedirect(httpURLConnection);
        response = this.a.initResponse(httpURLConnection);
      } catch (Exception exception) {
        response = null;
      } 
      if (exception == null) {
        networkCallBack = this.b;
        if (networkCallBack != null)
          networkCallBack.onResponse(this.a, response); 
        if (this.a.isAutoClose()) {
          response.close();
          return response;
        } 
      } else {
        if (this.b != null) {
          GDTLogger.w("NetworkClientException", (Throwable)networkCallBack);
          this.b.onException((Exception)networkCallBack);
          if (response != null) {
            response.close();
            return response;
          } 
          return response;
        } 
        throw networkCallBack;
      } 
      return response;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\NetworkClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */