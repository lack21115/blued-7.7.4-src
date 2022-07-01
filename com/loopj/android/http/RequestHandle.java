package com.loopj.android.http;

import java.lang.ref.WeakReference;

public class RequestHandle {
  private final WeakReference<AsyncHttpRequest> request;
  
  public RequestHandle(AsyncHttpRequest paramAsyncHttpRequest) {
    this.request = new WeakReference<AsyncHttpRequest>(paramAsyncHttpRequest);
  }
  
  public boolean cancel(boolean paramBoolean) {
    AsyncHttpRequest asyncHttpRequest = this.request.get();
    return (asyncHttpRequest == null || asyncHttpRequest.cancel(paramBoolean));
  }
  
  public boolean isCancelled() {
    AsyncHttpRequest asyncHttpRequest = this.request.get();
    return (asyncHttpRequest == null || asyncHttpRequest.isCancelled());
  }
  
  public boolean isFinished() {
    AsyncHttpRequest asyncHttpRequest = this.request.get();
    return (asyncHttpRequest == null || asyncHttpRequest.isDone());
  }
  
  public boolean shouldBeGarbageCollected() {
    boolean bool;
    if (isCancelled() || isFinished()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      this.request.clear(); 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\RequestHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */