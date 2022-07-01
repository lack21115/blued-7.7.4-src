package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class f implements ConnectionKeepAliveStrategy {
  f(d paramd) {}
  
  public final long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    return 180000L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */