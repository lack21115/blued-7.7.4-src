package com.alipay.android.phone.mrpc.core;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class ad implements HttpRequestRetryHandler {
  static final String a = ad.class.getSimpleName();
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext) {
    return (paramInt >= 3) ? false : ((paramIOException instanceof org.apache.http.NoHttpResponseException) ? true : (((paramIOException instanceof java.net.SocketException || paramIOException instanceof javax.net.ssl.SSLException) && paramIOException.getMessage() != null && paramIOException.getMessage().contains("Broken pipe"))));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */