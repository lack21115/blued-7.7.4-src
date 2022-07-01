package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1xStream implements HttpStream {
  private static final int STATE_CLOSED = 6;
  
  private static final int STATE_IDLE = 0;
  
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  
  private static final int STATE_READING_RESPONSE_BODY = 5;
  
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  
  private HttpEngine httpEngine;
  
  private final BufferedSink sink;
  
  private final BufferedSource source;
  
  private int state = 0;
  
  private final StreamAllocation streamAllocation;
  
  public Http1xStream(StreamAllocation paramStreamAllocation, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink) {
    this.streamAllocation = paramStreamAllocation;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
  }
  
  private void detachTimeout(ForwardingTimeout paramForwardingTimeout) {
    Timeout timeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    timeout.clearDeadline();
    timeout.clearTimeout();
  }
  
  private Source getTransferStream(Response paramResponse) throws IOException {
    if (!HttpEngine.hasBody(paramResponse))
      return newFixedLengthSource(0L); 
    if ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding")))
      return newChunkedSource(this.httpEngine); 
    long l = OkHeaders.contentLength(paramResponse);
    return (l != -1L) ? newFixedLengthSource(l) : newUnknownLengthSource();
  }
  
  public void cancel() {
    RealConnection realConnection = this.streamAllocation.connection();
    if (realConnection != null)
      realConnection.cancel(); 
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong) throws IOException {
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding")))
      return newChunkedSink(); 
    if (paramLong != -1L)
      return newFixedLengthSink(paramLong); 
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public void finishRequest() throws IOException {
    this.sink.flush();
  }
  
  public boolean isClosed() {
    return (this.state == 6);
  }
  
  public Sink newChunkedSink() {
    if (this.state == 1) {
      this.state = 2;
      return new ChunkedSink();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.state);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public Source newChunkedSource(HttpEngine paramHttpEngine) throws IOException {
    if (this.state == 4) {
      this.state = 5;
      return new ChunkedSource(paramHttpEngine);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.state);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public Sink newFixedLengthSink(long paramLong) {
    if (this.state == 1) {
      this.state = 2;
      return new FixedLengthSink(paramLong);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.state);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public Source newFixedLengthSource(long paramLong) throws IOException {
    if (this.state == 4) {
      this.state = 5;
      return new FixedLengthSource(paramLong);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.state);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public Source newUnknownLengthSource() throws IOException {
    if (this.state == 4) {
      StreamAllocation streamAllocation = this.streamAllocation;
      if (streamAllocation != null) {
        this.state = 5;
        streamAllocation.noNewStreams();
        return new UnknownLengthSource();
      } 
      throw new IllegalStateException("streamAllocation == null");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.state);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public ResponseBody openResponseBody(Response paramResponse) throws IOException {
    Source source = getTransferStream(paramResponse);
    return new RealResponseBody(paramResponse.headers(), Okio.buffer(source));
  }
  
  public Headers readHeaders() throws IOException {
    Headers.Builder builder = new Headers.Builder();
    while (true) {
      String str = this.source.readUtf8LineStrict();
      if (str.length() != 0) {
        Internal.instance.addLenient(builder, str);
        continue;
      } 
      return builder.build();
    } 
  }
  
  public Response.Builder readResponse() throws IOException {
    int i = this.state;
    if (i == 1 || i == 3)
      try {
        while (true) {
          StatusLine statusLine = StatusLine.parse(this.source.readUtf8LineStrict());
          Response.Builder builder = (new Response.Builder()).protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(readHeaders());
          if (statusLine.code != 100) {
            this.state = 4;
            return builder;
          } 
        } 
      } catch (EOFException eOFException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("unexpected end of stream on ");
        stringBuilder1.append(this.streamAllocation);
        IOException iOException = new IOException(stringBuilder1.toString());
        iOException.initCause(eOFException);
        throw iOException;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.state);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public Response.Builder readResponseHeaders() throws IOException {
    return readResponse();
  }
  
  public void setHttpEngine(HttpEngine paramHttpEngine) {
    this.httpEngine = paramHttpEngine;
  }
  
  public void writeRequest(Headers paramHeaders, String paramString) throws IOException {
    if (this.state == 0) {
      this.sink.writeUtf8(paramString).writeUtf8("\r\n");
      int i = 0;
      int j = paramHeaders.size();
      while (i < j) {
        this.sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
        i++;
      } 
      this.sink.writeUtf8("\r\n");
      this.state = 1;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.state);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void writeRequestBody(RetryableSink paramRetryableSink) throws IOException {
    if (this.state == 1) {
      this.state = 3;
      paramRetryableSink.writeToSocket((Sink)this.sink);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.state);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void writeRequestHeaders(Request paramRequest) throws IOException {
    this.httpEngine.writingRequestHeaders();
    String str = RequestLine.get(paramRequest, this.httpEngine.getConnection().getRoute().getProxy().type());
    writeRequest(paramRequest.headers(), str);
  }
  
  abstract class AbstractSource implements Source {
    protected boolean closed;
    
    protected final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.this.source.timeout());
    
    private AbstractSource() {}
    
    protected final void endOfInput() throws IOException {
      if (Http1xStream.this.state == 5) {
        Http1xStream.this.detachTimeout(this.timeout);
        Http1xStream.access$502(Http1xStream.this, 6);
        if (Http1xStream.this.streamAllocation != null)
          Http1xStream.this.streamAllocation.streamFinished(Http1xStream.this); 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("state: ");
      stringBuilder.append(Http1xStream.this.state);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public Timeout timeout() {
      return (Timeout)this.timeout;
    }
    
    protected final void unexpectedEndOfInput() {
      if (Http1xStream.this.state == 6)
        return; 
      Http1xStream.access$502(Http1xStream.this, 6);
      if (Http1xStream.this.streamAllocation != null) {
        Http1xStream.this.streamAllocation.noNewStreams();
        Http1xStream.this.streamAllocation.streamFinished(Http1xStream.this);
      } 
    }
  }
  
  final class ChunkedSink implements Sink {
    private boolean closed;
    
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.this.sink.timeout());
    
    private ChunkedSink() {}
    
    public void close() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield closed : Z
      //   19: aload_0
      //   20: getfield this$0 : Lcom/squareup/okhttp/internal/http/Http1xStream;
      //   23: invokestatic access$300 : (Lcom/squareup/okhttp/internal/http/Http1xStream;)Lokio/BufferedSink;
      //   26: ldc '0\\r\\n\\r\\n'
      //   28: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
      //   33: pop
      //   34: aload_0
      //   35: getfield this$0 : Lcom/squareup/okhttp/internal/http/Http1xStream;
      //   38: aload_0
      //   39: getfield timeout : Lokio/ForwardingTimeout;
      //   42: invokestatic access$400 : (Lcom/squareup/okhttp/internal/http/Http1xStream;Lokio/ForwardingTimeout;)V
      //   45: aload_0
      //   46: getfield this$0 : Lcom/squareup/okhttp/internal/http/Http1xStream;
      //   49: iconst_3
      //   50: invokestatic access$502 : (Lcom/squareup/okhttp/internal/http/Http1xStream;I)I
      //   53: pop
      //   54: aload_0
      //   55: monitorexit
      //   56: return
      //   57: astore_2
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_2
      //   61: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	57	finally
      //   14	54	57	finally
    }
    
    public void flush() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield this$0 : Lcom/squareup/okhttp/internal/http/Http1xStream;
      //   18: invokestatic access$300 : (Lcom/squareup/okhttp/internal/http/Http1xStream;)Lokio/BufferedSink;
      //   21: invokeinterface flush : ()V
      //   26: aload_0
      //   27: monitorexit
      //   28: return
      //   29: astore_2
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
    
    public Timeout timeout() {
      return (Timeout)this.timeout;
    }
    
    public void write(Buffer param1Buffer, long param1Long) throws IOException {
      if (!this.closed) {
        if (param1Long == 0L)
          return; 
        Http1xStream.this.sink.writeHexadecimalUnsignedLong(param1Long);
        Http1xStream.this.sink.writeUtf8("\r\n");
        Http1xStream.this.sink.write(param1Buffer, param1Long);
        Http1xStream.this.sink.writeUtf8("\r\n");
        return;
      } 
      throw new IllegalStateException("closed");
    }
  }
  
  class ChunkedSource extends AbstractSource {
    private static final long NO_CHUNK_YET = -1L;
    
    private long bytesRemainingInChunk = -1L;
    
    private boolean hasMoreChunks = true;
    
    private final HttpEngine httpEngine;
    
    ChunkedSource(HttpEngine param1HttpEngine) throws IOException {
      this.httpEngine = param1HttpEngine;
    }
    
    private void readChunkSize() throws IOException {
      if (this.bytesRemainingInChunk != -1L)
        Http1xStream.this.source.readUtf8LineStrict(); 
      try {
        this.bytesRemainingInChunk = Http1xStream.this.source.readHexadecimalUnsignedLong();
        String str = Http1xStream.this.source.readUtf8LineStrict().trim();
        if (this.bytesRemainingInChunk >= 0L) {
          if (!str.isEmpty()) {
            boolean bool = str.startsWith(";");
            if (bool) {
              if (this.bytesRemainingInChunk == 0L) {
                this.hasMoreChunks = false;
                this.httpEngine.receiveHeaders(Http1xStream.this.readHeaders());
                endOfInput();
              } 
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected chunk size and optional extensions but was \"");
            stringBuilder.append(this.bytesRemainingInChunk);
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new ProtocolException(stringBuilder.toString());
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("expected chunk size and optional extensions but was \"");
          stringBuilder.append(this.bytesRemainingInChunk);
          stringBuilder.append(str);
          stringBuilder.append("\"");
          throw new ProtocolException(stringBuilder.toString());
        } 
        if (this.bytesRemainingInChunk == 0L) {
          this.hasMoreChunks = false;
          this.httpEngine.receiveHeaders(Http1xStream.this.readHeaders());
          endOfInput();
        } 
        return;
      } catch (NumberFormatException numberFormatException) {
        throw new ProtocolException(numberFormatException.getMessage());
      } 
    }
    
    public void close() throws IOException {
      if (this.closed)
        return; 
      if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
        unexpectedEndOfInput(); 
      this.closed = true;
    }
    
    public long read(Buffer param1Buffer, long param1Long) throws IOException {
      if (param1Long >= 0L) {
        if (!this.closed) {
          if (!this.hasMoreChunks)
            return -1L; 
          long l = this.bytesRemainingInChunk;
          if (l == 0L || l == -1L) {
            readChunkSize();
            if (!this.hasMoreChunks)
              return -1L; 
          } 
          param1Long = Http1xStream.this.source.read(param1Buffer, Math.min(param1Long, this.bytesRemainingInChunk));
          if (param1Long != -1L) {
            this.bytesRemainingInChunk -= param1Long;
            return param1Long;
          } 
          unexpectedEndOfInput();
          throw new ProtocolException("unexpected end of stream");
        } 
        throw new IllegalStateException("closed");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(param1Long);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
  }
  
  final class FixedLengthSink implements Sink {
    private long bytesRemaining;
    
    private boolean closed;
    
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.this.sink.timeout());
    
    private FixedLengthSink(long param1Long) {
      this.bytesRemaining = param1Long;
    }
    
    public void close() throws IOException {
      if (this.closed)
        return; 
      this.closed = true;
      if (this.bytesRemaining <= 0L) {
        Http1xStream.this.detachTimeout(this.timeout);
        Http1xStream.access$502(Http1xStream.this, 3);
        return;
      } 
      throw new ProtocolException("unexpected end of stream");
    }
    
    public void flush() throws IOException {
      if (this.closed)
        return; 
      Http1xStream.this.sink.flush();
    }
    
    public Timeout timeout() {
      return (Timeout)this.timeout;
    }
    
    public void write(Buffer param1Buffer, long param1Long) throws IOException {
      if (!this.closed) {
        Util.checkOffsetAndCount(param1Buffer.size(), 0L, param1Long);
        if (param1Long <= this.bytesRemaining) {
          Http1xStream.this.sink.write(param1Buffer, param1Long);
          this.bytesRemaining -= param1Long;
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected ");
        stringBuilder.append(this.bytesRemaining);
        stringBuilder.append(" bytes but received ");
        stringBuilder.append(param1Long);
        throw new ProtocolException(stringBuilder.toString());
      } 
      throw new IllegalStateException("closed");
    }
  }
  
  class FixedLengthSource extends AbstractSource {
    private long bytesRemaining;
    
    public FixedLengthSource(long param1Long) throws IOException {
      this.bytesRemaining = param1Long;
      if (this.bytesRemaining == 0L)
        endOfInput(); 
    }
    
    public void close() throws IOException {
      if (this.closed)
        return; 
      if (this.bytesRemaining != 0L && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
        unexpectedEndOfInput(); 
      this.closed = true;
    }
    
    public long read(Buffer param1Buffer, long param1Long) throws IOException {
      if (param1Long >= 0L) {
        if (!this.closed) {
          if (this.bytesRemaining == 0L)
            return -1L; 
          param1Long = Http1xStream.this.source.read(param1Buffer, Math.min(this.bytesRemaining, param1Long));
          if (param1Long != -1L) {
            this.bytesRemaining -= param1Long;
            if (this.bytesRemaining == 0L)
              endOfInput(); 
            return param1Long;
          } 
          unexpectedEndOfInput();
          throw new ProtocolException("unexpected end of stream");
        } 
        throw new IllegalStateException("closed");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(param1Long);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
  }
  
  class UnknownLengthSource extends AbstractSource {
    private boolean inputExhausted;
    
    private UnknownLengthSource() {}
    
    public void close() throws IOException {
      if (this.closed)
        return; 
      if (!this.inputExhausted)
        unexpectedEndOfInput(); 
      this.closed = true;
    }
    
    public long read(Buffer param1Buffer, long param1Long) throws IOException {
      if (param1Long >= 0L) {
        if (!this.closed) {
          if (this.inputExhausted)
            return -1L; 
          param1Long = Http1xStream.this.source.read(param1Buffer, param1Long);
          if (param1Long == -1L) {
            this.inputExhausted = true;
            endOfInput();
            return -1L;
          } 
          return param1Long;
        } 
        throw new IllegalStateException("closed");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(param1Long);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\Http1xStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */