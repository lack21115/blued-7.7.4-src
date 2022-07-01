package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public final class RetryableSink implements Sink {
  private boolean closed;
  
  private final Buffer content = new Buffer();
  
  private final int limit;
  
  public RetryableSink() {
    this(-1);
  }
  
  public RetryableSink(int paramInt) {
    this.limit = paramInt;
  }
  
  public void close() throws IOException {
    if (this.closed)
      return; 
    this.closed = true;
    if (this.content.size() >= this.limit)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("content-length promised ");
    stringBuilder.append(this.limit);
    stringBuilder.append(" bytes, but received ");
    stringBuilder.append(this.content.size());
    throw new ProtocolException(stringBuilder.toString());
  }
  
  public long contentLength() throws IOException {
    return this.content.size();
  }
  
  public void flush() throws IOException {}
  
  public Timeout timeout() {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong) throws IOException {
    if (!this.closed) {
      Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      if (this.limit == -1 || this.content.size() <= this.limit - paramLong) {
        this.content.write(paramBuffer, paramLong);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exceeded content-length limit of ");
      stringBuilder.append(this.limit);
      stringBuilder.append(" bytes");
      throw new ProtocolException(stringBuilder.toString());
    } 
    throw new IllegalStateException("closed");
  }
  
  public void writeToSocket(Sink paramSink) throws IOException {
    Buffer buffer1 = new Buffer();
    Buffer buffer2 = this.content;
    buffer2.copyTo(buffer1, 0L, buffer2.size());
    paramSink.write(buffer1, buffer1.size());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\RetryableSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */