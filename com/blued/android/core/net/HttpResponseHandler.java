package com.blued.android.core.net;

import com.blued.android.core.net.http.AbstractHttpResponseHandler;
import com.blued.android.core.utils.Log;

public abstract class HttpResponseHandler<T> extends AbstractHttpResponseHandler<T> {
  private static final String TAG = "HttpResponseHandler";
  
  public HttpResponseHandler() {
    this(false);
  }
  
  public HttpResponseHandler(boolean paramBoolean) {
    super(paramBoolean);
  }
  
  public void onCancel() {
    if (HttpManager.c())
      Log.a("HttpResponseHandler", "onCancel()"); 
  }
  
  @Deprecated
  public void onFailure(Throwable paramThrowable) {}
  
  public void onFailure(Throwable paramThrowable, int paramInt, T paramT) {
    if (HttpManager.c()) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onFailure(), , content: ");
      if (paramT != null) {
        str = paramT.toString();
      } else {
        str = "null";
      } 
      stringBuilder.append(str);
      stringBuilder.append(", error: ");
      stringBuilder.append(paramThrowable);
      Log.a("HttpResponseHandler", stringBuilder.toString());
    } 
    onFailure(paramThrowable);
  }
  
  public void onFinish() {}
  
  public void onProgress(int paramInt1, int paramInt2) {}
  
  public void onStart() {}
  
  public abstract void onSuccess(T paramT);
  
  protected void setHttpRequestWrapper(HttpRequestWrapper paramHttpRequestWrapper) {
    this.requestWrapper = paramHttpRequestWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\HttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */