package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okio.Sink;

public final class StreamAllocation {
  public final Address address;
  
  private boolean canceled;
  
  private RealConnection connection;
  
  private final ConnectionPool connectionPool;
  
  private boolean released;
  
  private RouteSelector routeSelector;
  
  private HttpStream stream;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress) {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
  }
  
  private void connectionFailed(IOException paramIOException) {
    synchronized (this.connectionPool) {
      if (this.routeSelector != null)
        if (this.connection.streamCount == 0) {
          Route route = this.connection.getRoute();
          this.routeSelector.connectFailed(route, paramIOException);
        } else {
          this.routeSelector = null;
        }  
      connectionFailed();
      return;
    } 
  }
  
  private void deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aload_0
    //   1: getfield connectionPool : Lcom/squareup/okhttp/ConnectionPool;
    //   4: astore #5
    //   6: aload #5
    //   8: monitorenter
    //   9: iload_3
    //   10: ifeq -> 21
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield stream : Lcom/squareup/okhttp/internal/http/HttpStream;
    //   18: goto -> 21
    //   21: iload_2
    //   22: ifeq -> 30
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield released : Z
    //   30: aload_0
    //   31: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   34: ifnull -> 189
    //   37: iload_1
    //   38: ifeq -> 49
    //   41: aload_0
    //   42: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   45: iconst_1
    //   46: putfield noNewStreams : Z
    //   49: aload_0
    //   50: getfield stream : Lcom/squareup/okhttp/internal/http/HttpStream;
    //   53: ifnonnull -> 189
    //   56: aload_0
    //   57: getfield released : Z
    //   60: ifne -> 73
    //   63: aload_0
    //   64: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   67: getfield noNewStreams : Z
    //   70: ifeq -> 189
    //   73: aload_0
    //   74: aload_0
    //   75: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   78: invokespecial release : (Lcom/squareup/okhttp/internal/io/RealConnection;)V
    //   81: aload_0
    //   82: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   85: getfield streamCount : I
    //   88: ifle -> 96
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield routeSelector : Lcom/squareup/okhttp/internal/http/RouteSelector;
    //   96: aload_0
    //   97: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   100: getfield allocations : Ljava/util/List;
    //   103: invokeinterface isEmpty : ()Z
    //   108: ifeq -> 183
    //   111: aload_0
    //   112: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   115: invokestatic nanoTime : ()J
    //   118: putfield idleAtNanos : J
    //   121: getstatic com/squareup/okhttp/internal/Internal.instance : Lcom/squareup/okhttp/internal/Internal;
    //   124: aload_0
    //   125: getfield connectionPool : Lcom/squareup/okhttp/ConnectionPool;
    //   128: aload_0
    //   129: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   132: invokevirtual connectionBecameIdle : (Lcom/squareup/okhttp/ConnectionPool;Lcom/squareup/okhttp/internal/io/RealConnection;)Z
    //   135: ifeq -> 183
    //   138: aload_0
    //   139: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   142: astore #4
    //   144: goto -> 147
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   152: goto -> 155
    //   155: aload #5
    //   157: monitorexit
    //   158: aload #4
    //   160: ifnull -> 171
    //   163: aload #4
    //   165: invokevirtual getSocket : ()Ljava/net/Socket;
    //   168: invokestatic closeQuietly : (Ljava/net/Socket;)V
    //   171: return
    //   172: aload #5
    //   174: monitorexit
    //   175: aload #4
    //   177: athrow
    //   178: astore #4
    //   180: goto -> 172
    //   183: aconst_null
    //   184: astore #4
    //   186: goto -> 147
    //   189: aconst_null
    //   190: astore #4
    //   192: goto -> 155
    // Exception table:
    //   from	to	target	type
    //   13	18	178	finally
    //   25	30	178	finally
    //   30	37	178	finally
    //   41	49	178	finally
    //   49	73	178	finally
    //   73	96	178	finally
    //   96	144	178	finally
    //   147	152	178	finally
    //   155	158	178	finally
    //   172	175	178	finally
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) throws IOException, RouteException {
    synchronized (this.connectionPool) {
      if (!this.released) {
        if (this.stream == null) {
          if (!this.canceled) {
            null = this.connection;
            if (null != null && !null.noNewStreams)
              return null; 
            null = Internal.instance.get(this.connectionPool, this.address, this);
            if (null != null) {
              this.connection = null;
              return null;
            } 
            if (this.routeSelector == null)
              this.routeSelector = new RouteSelector(this.address, routeDatabase()); 
            null = new RealConnection(this.routeSelector.next());
            acquire(null);
            synchronized (this.connectionPool) {
              Internal.instance.put(this.connectionPool, null);
              this.connection = null;
              if (!this.canceled) {
                null.connect(paramInt1, paramInt2, paramInt3, this.address.getConnectionSpecs(), paramBoolean);
                routeDatabase().connected(null.getRoute());
                return null;
              } 
              throw new IOException("Canceled");
            } 
          } 
          throw new IOException("Canceled");
        } 
        throw new IllegalStateException("stream != null");
      } 
      throw new IllegalStateException("released");
    } 
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) throws IOException, RouteException {
    while (true) {
      null = findConnection(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.connectionPool) {
        if (null.streamCount == 0)
          return null; 
        if (null.isHealthy(paramBoolean2))
          return null; 
        connectionFailed();
      } 
    } 
  }
  
  private boolean isRecoverable(RouteException paramRouteException) {
    IOException iOException = paramRouteException.getLastConnectException();
    return (iOException instanceof java.net.ProtocolException) ? false : ((iOException instanceof java.io.InterruptedIOException) ? (iOException instanceof java.net.SocketTimeoutException) : ((iOException instanceof javax.net.ssl.SSLHandshakeException && iOException.getCause() instanceof java.security.cert.CertificateException) ? false : (!(iOException instanceof javax.net.ssl.SSLPeerUnverifiedException))));
  }
  
  private boolean isRecoverable(IOException paramIOException) {
    return (paramIOException instanceof java.net.ProtocolException) ? false : (!(paramIOException instanceof java.io.InterruptedIOException));
  }
  
  private void release(RealConnection paramRealConnection) {
    int j = paramRealConnection.allocations.size();
    for (int i = 0; i < j; i++) {
      if (((Reference<StreamAllocation>)paramRealConnection.allocations.get(i)).get() == this) {
        paramRealConnection.allocations.remove(i);
        return;
      } 
    } 
    throw new IllegalStateException();
  }
  
  private RouteDatabase routeDatabase() {
    return Internal.instance.routeDatabase(this.connectionPool);
  }
  
  public void acquire(RealConnection paramRealConnection) {
    paramRealConnection.allocations.add(new WeakReference<StreamAllocation>(this));
  }
  
  public void cancel() {
    synchronized (this.connectionPool) {
      this.canceled = true;
      HttpStream httpStream = this.stream;
      RealConnection realConnection = this.connection;
      if (httpStream != null) {
        httpStream.cancel();
        return;
      } 
      if (realConnection != null)
        realConnection.cancel(); 
      return;
    } 
  }
  
  public RealConnection connection() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
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
  
  public void connectionFailed() {
    deallocate(true, false, true);
  }
  
  public HttpStream newStream(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) throws RouteException, IOException {
    try {
      RealConnection realConnection = findHealthyConnection(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      if (realConnection.framedConnection != null) {
        Http2xStream http2xStream = new Http2xStream(this, realConnection.framedConnection);
      } else {
        realConnection.getSocket().setSoTimeout(paramInt2);
        realConnection.source.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
        realConnection.sink.timeout().timeout(paramInt3, TimeUnit.MILLISECONDS);
        null = new Http1xStream(this, realConnection.source, realConnection.sink);
      } 
      synchronized (this.connectionPool) {
        realConnection.streamCount++;
        this.stream = null;
        return null;
      } 
    } catch (IOException iOException) {
      throw new RouteException(iOException);
    } 
  }
  
  public void noNewStreams() {
    deallocate(true, false, false);
  }
  
  public boolean recover(RouteException paramRouteException) {
    if (this.connection != null)
      connectionFailed(paramRouteException.getLastConnectException()); 
    RouteSelector routeSelector = this.routeSelector;
    return !((routeSelector != null && !routeSelector.hasNext()) || !isRecoverable(paramRouteException));
  }
  
  public boolean recover(IOException paramIOException, Sink paramSink) {
    boolean bool;
    RealConnection realConnection = this.connection;
    if (realConnection != null) {
      bool = realConnection.streamCount;
      connectionFailed(paramIOException);
      if (bool == true)
        return false; 
    } 
    if (paramSink == null || paramSink instanceof RetryableSink) {
      bool = true;
    } else {
      bool = false;
    } 
    RouteSelector routeSelector = this.routeSelector;
    return ((routeSelector == null || routeSelector.hasNext()) && isRecoverable(paramIOException)) ? (!!bool) : false;
  }
  
  public void release() {
    deallocate(false, true, false);
  }
  
  public HttpStream stream() {
    synchronized (this.connectionPool) {
      return this.stream;
    } 
  }
  
  public void streamFinished(HttpStream paramHttpStream) {
    // Byte code:
    //   0: aload_0
    //   1: getfield connectionPool : Lcom/squareup/okhttp/ConnectionPool;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull -> 29
    //   11: aload_1
    //   12: aload_0
    //   13: getfield stream : Lcom/squareup/okhttp/internal/http/HttpStream;
    //   16: if_acmpne -> 29
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_0
    //   22: iconst_0
    //   23: iconst_0
    //   24: iconst_1
    //   25: invokespecial deallocate : (ZZZ)V
    //   28: return
    //   29: new java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore_3
    //   37: aload_3
    //   38: ldc_w 'expected '
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: aload_0
    //   47: getfield stream : Lcom/squareup/okhttp/internal/http/HttpStream;
    //   50: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc_w ' but was '
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: aload_1
    //   64: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: new java/lang/IllegalStateException
    //   71: dup
    //   72: aload_3
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: invokespecial <init> : (Ljava/lang/String;)V
    //   79: athrow
    //   80: astore_1
    //   81: aload_2
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Exception table:
    //   from	to	target	type
    //   11	21	80	finally
    //   29	80	80	finally
    //   81	83	80	finally
  }
  
  public String toString() {
    return this.address.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\StreamAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */