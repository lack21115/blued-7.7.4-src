package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

final class c implements HttpRequestInterceptor {
  public final void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) {
    if (Looper.myLooper() != null) {
      if (Looper.myLooper() != Looper.getMainLooper())
        return; 
      throw new RuntimeException("This thread forbids HTTP requests");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */