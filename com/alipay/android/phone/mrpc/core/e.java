package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

final class e extends DefaultRedirectHandler {
  int a;
  
  e(d paramd) {}
  
  public final boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    this.a++;
    boolean bool = super.isRedirectRequested(paramHttpResponse, paramHttpContext);
    if (!bool && this.a < 5) {
      int i = paramHttpResponse.getStatusLine().getStatusCode();
      if (i == 301 || i == 302)
        return true; 
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */