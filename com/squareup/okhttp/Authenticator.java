package com.squareup.okhttp;

import java.io.IOException;
import java.net.Proxy;

public interface Authenticator {
  Request authenticate(Proxy paramProxy, Response paramResponse) throws IOException;
  
  Request authenticateProxy(Proxy paramProxy, Response paramResponse) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Authenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */