package com.squareup.okhttp.internal.http;

import java.io.IOException;

public final class RequestException extends Exception {
  public RequestException(IOException paramIOException) {
    super(paramIOException);
  }
  
  public IOException getCause() {
    return (IOException)super.getCause();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\RequestException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */