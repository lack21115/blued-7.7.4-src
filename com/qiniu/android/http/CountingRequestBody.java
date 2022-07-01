package com.qiniu.android.http;

import com.qiniu.android.utils.AsyncRun;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public final class CountingRequestBody extends RequestBody {
  private static final int SEGMENT_SIZE = 2048;
  
  private final RequestBody body;
  
  private final CancellationHandler cancellationHandler;
  
  private final ProgressHandler progress;
  
  private final long totalSize;
  
  public CountingRequestBody(RequestBody paramRequestBody, ProgressHandler paramProgressHandler, long paramLong, CancellationHandler paramCancellationHandler) {
    this.body = paramRequestBody;
    this.progress = paramProgressHandler;
    this.totalSize = paramLong;
    this.cancellationHandler = paramCancellationHandler;
  }
  
  public long contentLength() throws IOException {
    return this.body.contentLength();
  }
  
  public MediaType contentType() {
    return this.body.contentType();
  }
  
  public void writeTo(BufferedSink paramBufferedSink) throws IOException {
    paramBufferedSink = Okio.buffer((Sink)new CountingSink((Sink)paramBufferedSink));
    this.body.writeTo(paramBufferedSink);
    paramBufferedSink.flush();
  }
  
  public final class CountingSink extends ForwardingSink {
    private int bytesWritten = 0;
    
    public CountingSink(Sink param1Sink) {
      super(param1Sink);
    }
    
    public void write(Buffer param1Buffer, long param1Long) throws IOException {
      if (CountingRequestBody.this.cancellationHandler == null && CountingRequestBody.this.progress == null) {
        super.write(param1Buffer, param1Long);
        return;
      } 
      if (CountingRequestBody.this.cancellationHandler == null || !CountingRequestBody.this.cancellationHandler.isCancelled()) {
        super.write(param1Buffer, param1Long);
        this.bytesWritten = (int)(this.bytesWritten + param1Long);
        if (CountingRequestBody.this.progress != null)
          AsyncRun.runInMain(new Runnable() {
                public void run() {
                  CountingRequestBody.this.progress.onProgress(CountingRequestBody.CountingSink.this.bytesWritten, CountingRequestBody.this.totalSize);
                }
              }); 
        return;
      } 
      throw new CancellationHandler.CancellationException();
    }
  }
  
  class null implements Runnable {
    public void run() {
      CountingRequestBody.this.progress.onProgress(this.this$1.bytesWritten, CountingRequestBody.this.totalSize);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\CountingRequestBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */