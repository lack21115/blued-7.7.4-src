package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

public interface CacheRequest {
  void abort();
  
  Sink body() throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\CacheRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */