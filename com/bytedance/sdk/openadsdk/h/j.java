package com.bytedance.sdk.openadsdk.h;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

class j extends ProxySelector {
  private static final List<Proxy> a = Collections.singletonList(Proxy.NO_PROXY);
  
  private final ProxySelector b = ProxySelector.getDefault();
  
  private final String c;
  
  private final int d;
  
  private j(String paramString, int paramInt) {
    this.c = paramString;
    this.d = paramInt;
  }
  
  static void a(String paramString, int paramInt) {
    ProxySelector.setDefault(new j(paramString, paramInt));
  }
  
  public void connectFailed(URI paramURI, SocketAddress paramSocketAddress, IOException paramIOException) {
    this.b.connectFailed(paramURI, paramSocketAddress, paramIOException);
  }
  
  public List<Proxy> select(URI paramURI) {
    if (paramURI != null)
      return (this.c.equalsIgnoreCase(paramURI.getHost()) && this.d == paramURI.getPort()) ? a : this.b.select(paramURI); 
    throw new IllegalArgumentException("URI can't be null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */