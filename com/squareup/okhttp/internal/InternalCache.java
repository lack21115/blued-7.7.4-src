package com.squareup.okhttp.internal;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.IOException;

public interface InternalCache {
  Response get(Request paramRequest) throws IOException;
  
  CacheRequest put(Response paramResponse) throws IOException;
  
  void remove(Request paramRequest) throws IOException;
  
  void trackConditionalCacheHit();
  
  void trackResponse(CacheStrategy paramCacheStrategy);
  
  void update(Response paramResponse1, Response paramResponse2) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\InternalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */