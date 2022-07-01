package com.alipay.android.phone.mrpc.core;

import org.apache.http.client.RedirectHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

final class d extends DefaultHttpClient {
  d(b paramb, ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
    super(paramClientConnectionManager, paramHttpParams);
  }
  
  protected final ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
    return new f(this);
  }
  
  protected final HttpContext createHttpContext() {
    BasicHttpContext basicHttpContext = new BasicHttpContext();
    basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
    basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
    basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
    return (HttpContext)basicHttpContext;
  }
  
  protected final BasicHttpProcessor createHttpProcessor() {
    BasicHttpProcessor basicHttpProcessor = super.createHttpProcessor();
    basicHttpProcessor.addRequestInterceptor(b.a());
    basicHttpProcessor.addRequestInterceptor(new b.a(this.a, (byte)0));
    return basicHttpProcessor;
  }
  
  protected final RedirectHandler createRedirectHandler() {
    return (RedirectHandler)new e(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */