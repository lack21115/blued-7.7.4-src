package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.Sink;

public interface HttpStream {
  public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
  
  void cancel();
  
  Sink createRequestBody(Request paramRequest, long paramLong) throws IOException;
  
  void finishRequest() throws IOException;
  
  ResponseBody openResponseBody(Response paramResponse) throws IOException;
  
  Response.Builder readResponseHeaders() throws IOException;
  
  void setHttpEngine(HttpEngine paramHttpEngine);
  
  void writeRequestBody(RetryableSink paramRetryableSink) throws IOException;
  
  void writeRequestHeaders(Request paramRequest) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\HttpStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */