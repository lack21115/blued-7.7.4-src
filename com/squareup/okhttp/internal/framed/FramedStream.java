package com.squareup.okhttp.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream {
  long bytesLeftInWriteWindow;
  
  private final FramedConnection connection;
  
  private ErrorCode errorCode = null;
  
  private final int id;
  
  private final StreamTimeout readTimeout = new StreamTimeout();
  
  private final List<Header> requestHeaders;
  
  private List<Header> responseHeaders;
  
  final FramedDataSink sink;
  
  private final FramedDataSource source;
  
  long unacknowledgedBytesRead = 0L;
  
  private final StreamTimeout writeTimeout = new StreamTimeout();
  
  FramedStream(int paramInt, FramedConnection paramFramedConnection, boolean paramBoolean1, boolean paramBoolean2, List<Header> paramList) {
    if (paramFramedConnection != null) {
      if (paramList != null) {
        this.id = paramInt;
        this.connection = paramFramedConnection;
        this.bytesLeftInWriteWindow = paramFramedConnection.peerSettings.getInitialWindowSize(65536);
        this.source = new FramedDataSource(paramFramedConnection.okHttpSettings.getInitialWindowSize(65536));
        this.sink = new FramedDataSink();
        FramedDataSource.access$102(this.source, paramBoolean2);
        FramedDataSink.access$202(this.sink, paramBoolean1);
        this.requestHeaders = paramList;
        return;
      } 
      throw new NullPointerException("requestHeaders == null");
    } 
    throw new NullPointerException("connection == null");
  }
  
  private void cancelStreamIfNecessary() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield source : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   6: invokestatic access$100 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   9: ifne -> 91
    //   12: aload_0
    //   13: getfield source : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   16: invokestatic access$300 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   19: ifeq -> 91
    //   22: aload_0
    //   23: getfield sink : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   26: invokestatic access$200 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   29: ifne -> 86
    //   32: aload_0
    //   33: getfield sink : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   36: invokestatic access$400 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   39: ifeq -> 91
    //   42: goto -> 86
    //   45: aload_0
    //   46: invokevirtual isOpen : ()Z
    //   49: istore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ifeq -> 64
    //   56: aload_0
    //   57: getstatic com/squareup/okhttp/internal/framed/ErrorCode.CANCEL : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   60: invokevirtual close : (Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   63: return
    //   64: iload_2
    //   65: ifne -> 80
    //   68: aload_0
    //   69: getfield connection : Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   72: aload_0
    //   73: getfield id : I
    //   76: invokevirtual removeStream : (I)Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   79: pop
    //   80: return
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    //   86: iconst_1
    //   87: istore_1
    //   88: goto -> 45
    //   91: iconst_0
    //   92: istore_1
    //   93: goto -> 45
    // Exception table:
    //   from	to	target	type
    //   2	42	81	finally
    //   45	52	81	finally
    //   82	84	81	finally
  }
  
  private void checkOutNotClosed() throws IOException {
    if (!this.sink.closed) {
      if (!this.sink.finished) {
        if (this.errorCode == null)
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream was reset: ");
        stringBuilder.append(this.errorCode);
        throw new IOException(stringBuilder.toString());
      } 
      throw new IOException("stream finished");
    } 
    throw new IOException("stream closed");
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield errorCode : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   6: ifnull -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: getfield source : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   17: invokestatic access$100 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   20: ifeq -> 37
    //   23: aload_0
    //   24: getfield sink : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   27: invokestatic access$200 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   30: ifeq -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: putfield errorCode : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   42: aload_0
    //   43: invokevirtual notifyAll : ()V
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_0
    //   49: getfield connection : Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   52: aload_0
    //   53: getfield id : I
    //   56: invokevirtual removeStream : (I)Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   59: pop
    //   60: iconst_1
    //   61: ireturn
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	62	finally
    //   13	35	62	finally
    //   37	48	62	finally
    //   63	65	62	finally
  }
  
  private void waitForIo() throws InterruptedIOException {
    try {
      wait();
      return;
    } catch (InterruptedException interruptedException) {
      throw new InterruptedIOException();
    } 
  }
  
  void addBytesToWriteWindow(long paramLong) {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L)
      notifyAll(); 
  }
  
  public void close(ErrorCode paramErrorCode) throws IOException {
    if (!closeInternal(paramErrorCode))
      return; 
    this.connection.writeSynReset(this.id, paramErrorCode);
  }
  
  public void closeLater(ErrorCode paramErrorCode) {
    if (!closeInternal(paramErrorCode))
      return; 
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }
  
  public FramedConnection getConnection() {
    return this.connection;
  }
  
  public ErrorCode getErrorCode() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield errorCode : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int getId() {
    return this.id;
  }
  
  public List<Header> getRequestHeaders() {
    return this.requestHeaders;
  }
  
  public List<Header> getResponseHeaders() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readTimeout : Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   6: invokevirtual enter : ()V
    //   9: aload_0
    //   10: getfield responseHeaders : Ljava/util/List;
    //   13: ifnonnull -> 30
    //   16: aload_0
    //   17: getfield errorCode : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   20: ifnonnull -> 30
    //   23: aload_0
    //   24: invokespecial waitForIo : ()V
    //   27: goto -> 9
    //   30: aload_0
    //   31: getfield readTimeout : Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   34: invokevirtual exitAndThrowIfTimedOut : ()V
    //   37: aload_0
    //   38: getfield responseHeaders : Ljava/util/List;
    //   41: ifnull -> 53
    //   44: aload_0
    //   45: getfield responseHeaders : Ljava/util/List;
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: new java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: astore_1
    //   61: aload_1
    //   62: ldc 'stream was reset: '
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: aload_0
    //   70: getfield errorCode : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   73: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new java/io/IOException
    //   80: dup
    //   81: aload_1
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: invokespecial <init> : (Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_1
    //   90: aload_0
    //   91: getfield readTimeout : Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   94: invokevirtual exitAndThrowIfTimedOut : ()V
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	99	finally
    //   9	27	89	finally
    //   30	49	99	finally
    //   53	89	99	finally
    //   90	99	99	finally
  }
  
  public Sink getSink() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield responseHeaders : Ljava/util/List;
    //   6: ifnonnull -> 29
    //   9: aload_0
    //   10: invokevirtual isLocallyInitiated : ()Z
    //   13: ifeq -> 19
    //   16: goto -> 29
    //   19: new java/lang/IllegalStateException
    //   22: dup
    //   23: ldc 'reply before requesting the sink'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: athrow
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_0
    //   32: getfield sink : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   35: areturn
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	36	finally
    //   19	29	36	finally
    //   29	31	36	finally
    //   37	39	36	finally
  }
  
  public Source getSource() {
    return this.source;
  }
  
  public boolean isLocallyInitiated() {
    boolean bool;
    if ((this.id & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    return (this.connection.client == bool);
  }
  
  public boolean isOpen() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield errorCode : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield source : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   19: invokestatic access$100 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   22: ifne -> 35
    //   25: aload_0
    //   26: getfield source : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   29: invokestatic access$300 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   32: ifeq -> 68
    //   35: aload_0
    //   36: getfield sink : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   39: invokestatic access$200 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   42: ifne -> 55
    //   45: aload_0
    //   46: getfield sink : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   49: invokestatic access$400 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   52: ifeq -> 68
    //   55: aload_0
    //   56: getfield responseHeaders : Ljava/util/List;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull -> 68
    //   64: aload_0
    //   65: monitorexit
    //   66: iconst_0
    //   67: ireturn
    //   68: aload_0
    //   69: monitorexit
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	72	finally
    //   15	35	72	finally
    //   35	55	72	finally
    //   55	60	72	finally
  }
  
  public Timeout readTimeout() {
    return (Timeout)this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt) throws IOException {
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield source : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   6: iconst_1
    //   7: invokestatic access$102 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;Z)Z
    //   10: pop
    //   11: aload_0
    //   12: invokevirtual isOpen : ()Z
    //   15: istore_1
    //   16: aload_0
    //   17: invokevirtual notifyAll : ()V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ifne -> 38
    //   26: aload_0
    //   27: getfield connection : Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   30: aload_0
    //   31: getfield id : I
    //   34: invokevirtual removeStream : (I)Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   37: pop
    //   38: return
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	39	finally
    //   40	42	39	finally
  }
  
  void receiveHeaders(List<Header> paramList, HeadersMode paramHeadersMode) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: iconst_1
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield responseHeaders : Ljava/util/List;
    //   11: ifnonnull -> 48
    //   14: aload_2
    //   15: invokevirtual failIfHeadersAbsent : ()Z
    //   18: ifeq -> 28
    //   21: getstatic com/squareup/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   24: astore_1
    //   25: goto -> 97
    //   28: aload_0
    //   29: aload_1
    //   30: putfield responseHeaders : Ljava/util/List;
    //   33: aload_0
    //   34: invokevirtual isOpen : ()Z
    //   37: istore_3
    //   38: aload_0
    //   39: invokevirtual notifyAll : ()V
    //   42: aload #4
    //   44: astore_1
    //   45: goto -> 97
    //   48: aload_2
    //   49: invokevirtual failIfHeadersPresent : ()Z
    //   52: ifeq -> 62
    //   55: getstatic com/squareup/okhttp/internal/framed/ErrorCode.STREAM_IN_USE : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   58: astore_1
    //   59: goto -> 97
    //   62: new java/util/ArrayList
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore_2
    //   70: aload_2
    //   71: aload_0
    //   72: getfield responseHeaders : Ljava/util/List;
    //   75: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   80: pop
    //   81: aload_2
    //   82: aload_1
    //   83: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   88: pop
    //   89: aload_0
    //   90: aload_2
    //   91: putfield responseHeaders : Ljava/util/List;
    //   94: aload #4
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: ifnull -> 109
    //   103: aload_0
    //   104: aload_1
    //   105: invokevirtual closeLater : (Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   108: return
    //   109: iload_3
    //   110: ifne -> 125
    //   113: aload_0
    //   114: getfield connection : Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   117: aload_0
    //   118: getfield id : I
    //   121: invokevirtual removeStream : (I)Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   124: pop
    //   125: return
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Exception table:
    //   from	to	target	type
    //   7	25	126	finally
    //   28	42	126	finally
    //   48	59	126	finally
    //   62	94	126	finally
    //   97	99	126	finally
    //   127	129	126	finally
  }
  
  void receiveRstStream(ErrorCode paramErrorCode) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield errorCode : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   6: ifnonnull -> 18
    //   9: aload_0
    //   10: aload_1
    //   11: putfield errorCode : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   14: aload_0
    //   15: invokevirtual notifyAll : ()V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public void reply(List<Header> paramList, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull -> 73
    //   8: aload_0
    //   9: getfield responseHeaders : Ljava/util/List;
    //   12: ifnonnull -> 62
    //   15: aload_0
    //   16: aload_1
    //   17: putfield responseHeaders : Ljava/util/List;
    //   20: iload_2
    //   21: ifne -> 35
    //   24: aload_0
    //   25: getfield sink : Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   28: iconst_1
    //   29: invokestatic access$202 : (Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;Z)Z
    //   32: pop
    //   33: iconst_1
    //   34: istore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: getfield connection : Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   41: aload_0
    //   42: getfield id : I
    //   45: iload_3
    //   46: aload_1
    //   47: invokevirtual writeSynReply : (IZLjava/util/List;)V
    //   50: iload_3
    //   51: ifeq -> 61
    //   54: aload_0
    //   55: getfield connection : Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   58: invokevirtual flush : ()V
    //   61: return
    //   62: new java/lang/IllegalStateException
    //   65: dup
    //   66: ldc_w 'reply already sent'
    //   69: invokespecial <init> : (Ljava/lang/String;)V
    //   72: athrow
    //   73: new java/lang/NullPointerException
    //   76: dup
    //   77: ldc_w 'responseHeaders == null'
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: athrow
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: goto -> 84
    // Exception table:
    //   from	to	target	type
    //   8	20	88	finally
    //   24	33	88	finally
    //   35	37	88	finally
    //   62	73	88	finally
    //   73	84	88	finally
    //   84	86	88	finally
  }
  
  public Timeout writeTimeout() {
    return (Timeout)this.writeTimeout;
  }
  
  final class FramedDataSink implements Sink {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    
    private boolean closed;
    
    private boolean finished;
    
    private final Buffer sendBuffer = new Buffer();
    
    private void emitDataFrame(boolean param1Boolean) throws IOException {
      synchronized (FramedStream.this) {
        FramedStream.this.writeTimeout.enter();
        try {
          while (FramedStream.this.bytesLeftInWriteWindow <= 0L && !this.finished && !this.closed && FramedStream.this.errorCode == null)
            FramedStream.this.waitForIo(); 
          FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
          FramedStream.this.checkOutNotClosed();
          long l = Math.min(FramedStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
          FramedStream framedStream = FramedStream.this;
          framedStream.bytesLeftInWriteWindow -= l;
          FramedStream.this.writeTimeout.enter();
        } finally {
          FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
        } 
      } 
    }
    
    public void close() throws IOException {
      synchronized (FramedStream.this) {
        if (this.closed)
          return; 
        if (!FramedStream.this.sink.finished)
          if (this.sendBuffer.size() > 0L) {
            while (this.sendBuffer.size() > 0L)
              emitDataFrame(true); 
          } else {
            FramedStream.this.connection.writeData(FramedStream.this.id, true, null, 0L);
          }  
        synchronized (FramedStream.this) {
          this.closed = true;
          FramedStream.this.connection.flush();
          FramedStream.this.cancelStreamIfNecessary();
          return;
        } 
      } 
    }
    
    public void flush() throws IOException {
      synchronized (FramedStream.this) {
        FramedStream.this.checkOutNotClosed();
        while (this.sendBuffer.size() > 0L) {
          emitDataFrame(false);
          FramedStream.this.connection.flush();
        } 
        return;
      } 
    }
    
    public Timeout timeout() {
      return (Timeout)FramedStream.this.writeTimeout;
    }
    
    public void write(Buffer param1Buffer, long param1Long) throws IOException {
      this.sendBuffer.write(param1Buffer, param1Long);
      while (this.sendBuffer.size() >= 16384L)
        emitDataFrame(false); 
    }
  }
  
  final class FramedDataSource implements Source {
    private boolean closed;
    
    private boolean finished;
    
    private final long maxByteCount;
    
    private final Buffer readBuffer = new Buffer();
    
    private final Buffer receiveBuffer = new Buffer();
    
    private FramedDataSource(long param1Long) {
      this.maxByteCount = param1Long;
    }
    
    private void checkNotClosed() throws IOException {
      if (!this.closed) {
        if (FramedStream.this.errorCode == null)
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream was reset: ");
        stringBuilder.append(FramedStream.this.errorCode);
        throw new IOException(stringBuilder.toString());
      } 
      throw new IOException("stream closed");
    }
    
    private void waitUntilReadable() throws IOException {
      FramedStream.this.readTimeout.enter();
      try {
        while (this.readBuffer.size() == 0L && !this.finished && !this.closed && FramedStream.this.errorCode == null)
          FramedStream.this.waitForIo(); 
        return;
      } finally {
        FramedStream.this.readTimeout.exitAndThrowIfTimedOut();
      } 
    }
    
    public void close() throws IOException {
      synchronized (FramedStream.this) {
        this.closed = true;
        this.readBuffer.clear();
        FramedStream.this.notifyAll();
        FramedStream.this.cancelStreamIfNecessary();
        return;
      } 
    }
    
    public long read(Buffer param1Buffer, long param1Long) throws IOException {
      if (param1Long >= 0L)
        synchronized (FramedStream.this) {
          waitUntilReadable();
          checkNotClosed();
          if (this.readBuffer.size() == 0L)
            return -1L; 
          param1Long = this.readBuffer.read(param1Buffer, Math.min(param1Long, this.readBuffer.size()));
          FramedStream framedStream = FramedStream.this;
          framedStream.unacknowledgedBytesRead += param1Long;
          if (FramedStream.this.unacknowledgedBytesRead >= (FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)) {
            FramedStream.this.connection.writeWindowUpdateLater(FramedStream.this.id, FramedStream.this.unacknowledgedBytesRead);
            FramedStream.this.unacknowledgedBytesRead = 0L;
          } 
          synchronized (FramedStream.this.connection) {
            FramedConnection framedConnection = FramedStream.this.connection;
            framedConnection.unacknowledgedBytesRead += param1Long;
            if (FramedStream.this.connection.unacknowledgedBytesRead >= (FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)) {
              FramedStream.this.connection.writeWindowUpdateLater(0, FramedStream.this.connection.unacknowledgedBytesRead);
              FramedStream.this.connection.unacknowledgedBytesRead = 0L;
            } 
            return param1Long;
          } 
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(param1Long);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    void receive(BufferedSource param1BufferedSource, long param1Long) throws IOException {
      while (true) {
        if (param1Long > 0L)
          synchronized (FramedStream.this) {
            boolean bool1;
            boolean bool = this.finished;
            long l1 = this.readBuffer.size();
            long l2 = this.maxByteCount;
            boolean bool2 = true;
            if (l1 + param1Long > l2) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (bool1) {
              param1BufferedSource.skip(param1Long);
              FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
              return;
            } 
            if (bool) {
              param1BufferedSource.skip(param1Long);
              return;
            } 
            l1 = param1BufferedSource.read(this.receiveBuffer, param1Long);
            if (l1 != -1L) {
              param1Long -= l1;
              synchronized (FramedStream.this) {
                if (this.readBuffer.size() == 0L) {
                  bool1 = bool2;
                } else {
                  bool1 = false;
                } 
                this.readBuffer.writeAll((Source)this.receiveBuffer);
                if (bool1)
                  FramedStream.this.notifyAll(); 
              } 
              continue;
            } 
            throw new EOFException();
          }  
        return;
      } 
    }
    
    public Timeout timeout() {
      return (Timeout)FramedStream.this.readTimeout;
    }
  }
  
  class StreamTimeout extends AsyncTimeout {
    public void exitAndThrowIfTimedOut() throws IOException {
      if (!exit())
        return; 
      throw newTimeoutException(null);
    }
    
    public IOException newTimeoutException(IOException param1IOException) {
      SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
      if (param1IOException != null)
        socketTimeoutException.initCause(param1IOException); 
      return socketTimeoutException;
    }
    
    public void timedOut() {
      FramedStream.this.closeLater(ErrorCode.CANCEL);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\FramedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */