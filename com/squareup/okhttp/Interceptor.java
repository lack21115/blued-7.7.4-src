package com.squareup.okhttp;

import java.io.IOException;

public interface Interceptor {
  Response intercept(Chain paramChain) throws IOException;
  
  public static interface Chain {
    Connection connection();
    
    Response proceed(Request param1Request) throws IOException;
    
    Request request();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Interceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */