package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class FramedConnection implements Closeable {
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  
  private static final ExecutorService executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp FramedConnection", true));
  
  long bytesLeftInWriteWindow;
  
  final boolean client;
  
  private final Set<Integer> currentPushRequests = new LinkedHashSet<Integer>();
  
  final FrameWriter frameWriter;
  
  private final String hostName;
  
  private long idleStartTimeNs = System.nanoTime();
  
  private int lastGoodStreamId;
  
  private final Listener listener;
  
  private int nextPingId;
  
  private int nextStreamId;
  
  Settings okHttpSettings = new Settings();
  
  final Settings peerSettings = new Settings();
  
  private Map<Integer, Ping> pings;
  
  final Protocol protocol;
  
  private final ExecutorService pushExecutor;
  
  private final PushObserver pushObserver;
  
  final Reader readerRunnable;
  
  private boolean receivedInitialPeerSettings = false;
  
  private boolean shutdown;
  
  final Socket socket;
  
  private final Map<Integer, FramedStream> streams = new HashMap<Integer, FramedStream>();
  
  long unacknowledgedBytesRead = 0L;
  
  final Variant variant;
  
  private FramedConnection(Builder paramBuilder) throws IOException {
    this.protocol = paramBuilder.protocol;
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    boolean bool = paramBuilder.client;
    byte b2 = 2;
    if (bool) {
      b1 = 1;
    } else {
      b1 = 2;
    } 
    this.nextStreamId = b1;
    if (paramBuilder.client && this.protocol == Protocol.HTTP_2)
      this.nextStreamId += 2; 
    byte b1 = b2;
    if (paramBuilder.client)
      b1 = 1; 
    this.nextPingId = b1;
    if (paramBuilder.client)
      this.okHttpSettings.set(7, 0, 16777216); 
    this.hostName = paramBuilder.hostName;
    if (this.protocol == Protocol.HTTP_2) {
      this.variant = new Http2();
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] { this.hostName }), true));
      this.peerSettings.set(7, 0, 65535);
      this.peerSettings.set(5, 0, 16384);
    } else if (this.protocol == Protocol.SPDY_3) {
      this.variant = new Spdy3();
      this.pushExecutor = null;
    } else {
      throw new AssertionError(this.protocol);
    } 
    this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
    this.socket = paramBuilder.socket;
    this.frameWriter = this.variant.newWriter(paramBuilder.sink, this.client);
    this.readerRunnable = new Reader(this.variant.newReader(paramBuilder.source, this.client));
    (new Thread((Runnable)this.readerRunnable)).start();
  }
  
  private void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore #9
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual shutdown : (Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   8: aconst_null
    //   9: astore_1
    //   10: goto -> 14
    //   13: astore_1
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield streams : Ljava/util/Map;
    //   20: invokeinterface isEmpty : ()Z
    //   25: istore #6
    //   27: iconst_0
    //   28: istore #4
    //   30: iload #6
    //   32: ifne -> 275
    //   35: aload_0
    //   36: getfield streams : Ljava/util/Map;
    //   39: invokeinterface values : ()Ljava/util/Collection;
    //   44: aload_0
    //   45: getfield streams : Ljava/util/Map;
    //   48: invokeinterface size : ()I
    //   53: anewarray com/squareup/okhttp/internal/framed/FramedStream
    //   56: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   61: checkcast [Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   64: astore #8
    //   66: aload_0
    //   67: getfield streams : Ljava/util/Map;
    //   70: invokeinterface clear : ()V
    //   75: aload_0
    //   76: iconst_0
    //   77: invokespecial setIdle : (Z)V
    //   80: goto -> 83
    //   83: aload_0
    //   84: getfield pings : Ljava/util/Map;
    //   87: ifnull -> 126
    //   90: aload_0
    //   91: getfield pings : Ljava/util/Map;
    //   94: invokeinterface values : ()Ljava/util/Collection;
    //   99: aload_0
    //   100: getfield pings : Ljava/util/Map;
    //   103: invokeinterface size : ()I
    //   108: anewarray com/squareup/okhttp/internal/framed/Ping
    //   111: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   116: checkcast [Lcom/squareup/okhttp/internal/framed/Ping;
    //   119: astore #9
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield pings : Ljava/util/Map;
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: astore #7
    //   131: aload #8
    //   133: ifnull -> 193
    //   136: aload #8
    //   138: arraylength
    //   139: istore #5
    //   141: iconst_0
    //   142: istore_3
    //   143: iload_3
    //   144: iload #5
    //   146: if_icmpge -> 190
    //   149: aload #8
    //   151: iload_3
    //   152: aaload
    //   153: astore #7
    //   155: aload #7
    //   157: aload_2
    //   158: invokevirtual close : (Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   161: aload_1
    //   162: astore #7
    //   164: goto -> 180
    //   167: astore #10
    //   169: aload_1
    //   170: astore #7
    //   172: aload_1
    //   173: ifnull -> 180
    //   176: aload #10
    //   178: astore #7
    //   180: iload_3
    //   181: iconst_1
    //   182: iadd
    //   183: istore_3
    //   184: aload #7
    //   186: astore_1
    //   187: goto -> 143
    //   190: aload_1
    //   191: astore #7
    //   193: aload #9
    //   195: ifnull -> 226
    //   198: aload #9
    //   200: arraylength
    //   201: istore #5
    //   203: iload #4
    //   205: istore_3
    //   206: iload_3
    //   207: iload #5
    //   209: if_icmpge -> 226
    //   212: aload #9
    //   214: iload_3
    //   215: aaload
    //   216: invokevirtual cancel : ()V
    //   219: iload_3
    //   220: iconst_1
    //   221: iadd
    //   222: istore_3
    //   223: goto -> 206
    //   226: aload_0
    //   227: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   230: invokeinterface close : ()V
    //   235: aload #7
    //   237: astore_1
    //   238: goto -> 252
    //   241: astore_2
    //   242: aload #7
    //   244: astore_1
    //   245: aload #7
    //   247: ifnonnull -> 252
    //   250: aload_2
    //   251: astore_1
    //   252: aload_0
    //   253: getfield socket : Ljava/net/Socket;
    //   256: invokevirtual close : ()V
    //   259: goto -> 263
    //   262: astore_1
    //   263: aload_1
    //   264: ifnonnull -> 268
    //   267: return
    //   268: aload_1
    //   269: athrow
    //   270: astore_1
    //   271: aload_0
    //   272: monitorexit
    //   273: aload_1
    //   274: athrow
    //   275: aconst_null
    //   276: astore #8
    //   278: goto -> 83
    // Exception table:
    //   from	to	target	type
    //   3	8	13	java/io/IOException
    //   16	27	270	finally
    //   35	80	270	finally
    //   83	126	270	finally
    //   126	128	270	finally
    //   155	161	167	java/io/IOException
    //   226	235	241	java/io/IOException
    //   252	259	262	java/io/IOException
    //   271	273	270	finally
  }
  
  private FramedStream newStream(int paramInt, List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
    // Byte code:
    //   0: iload_3
    //   1: iconst_1
    //   2: ixor
    //   3: istore #6
    //   5: iload #4
    //   7: iconst_1
    //   8: ixor
    //   9: istore #4
    //   11: aload_0
    //   12: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   15: astore #7
    //   17: aload #7
    //   19: monitorenter
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield shutdown : Z
    //   26: ifne -> 168
    //   29: aload_0
    //   30: getfield nextStreamId : I
    //   33: istore #5
    //   35: aload_0
    //   36: aload_0
    //   37: getfield nextStreamId : I
    //   40: iconst_2
    //   41: iadd
    //   42: putfield nextStreamId : I
    //   45: new com/squareup/okhttp/internal/framed/FramedStream
    //   48: dup
    //   49: iload #5
    //   51: aload_0
    //   52: iload #6
    //   54: iload #4
    //   56: aload_2
    //   57: invokespecial <init> : (ILcom/squareup/okhttp/internal/framed/FramedConnection;ZZLjava/util/List;)V
    //   60: astore #8
    //   62: aload #8
    //   64: invokevirtual isOpen : ()Z
    //   67: ifeq -> 92
    //   70: aload_0
    //   71: getfield streams : Ljava/util/Map;
    //   74: iload #5
    //   76: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   79: aload #8
    //   81: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: aload_0
    //   88: iconst_0
    //   89: invokespecial setIdle : (Z)V
    //   92: aload_0
    //   93: monitorexit
    //   94: iload_1
    //   95: ifne -> 118
    //   98: aload_0
    //   99: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   102: iload #6
    //   104: iload #4
    //   106: iload #5
    //   108: iload_1
    //   109: aload_2
    //   110: invokeinterface synStream : (ZZIILjava/util/List;)V
    //   115: goto -> 138
    //   118: aload_0
    //   119: getfield client : Z
    //   122: ifne -> 157
    //   125: aload_0
    //   126: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   129: iload_1
    //   130: iload #5
    //   132: aload_2
    //   133: invokeinterface pushPromise : (IILjava/util/List;)V
    //   138: aload #7
    //   140: monitorexit
    //   141: iload_3
    //   142: ifne -> 154
    //   145: aload_0
    //   146: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   149: invokeinterface flush : ()V
    //   154: aload #8
    //   156: areturn
    //   157: new java/lang/IllegalArgumentException
    //   160: dup
    //   161: ldc_w 'client streams shouldn't have associated stream IDs'
    //   164: invokespecial <init> : (Ljava/lang/String;)V
    //   167: athrow
    //   168: new java/io/IOException
    //   171: dup
    //   172: ldc_w 'shutdown'
    //   175: invokespecial <init> : (Ljava/lang/String;)V
    //   178: athrow
    //   179: astore_2
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_2
    //   183: athrow
    //   184: astore_2
    //   185: aload #7
    //   187: monitorexit
    //   188: aload_2
    //   189: athrow
    // Exception table:
    //   from	to	target	type
    //   20	22	184	finally
    //   22	92	179	finally
    //   92	94	179	finally
    //   98	115	184	finally
    //   118	138	184	finally
    //   138	141	184	finally
    //   157	168	184	finally
    //   168	179	179	finally
    //   180	182	179	finally
    //   182	184	184	finally
    //   185	188	184	finally
  }
  
  private void pushDataLater(final int streamId, BufferedSource paramBufferedSource, final int byteCount, final boolean inFinished) throws IOException {
    final Buffer buffer = new Buffer();
    long l = byteCount;
    paramBufferedSource.require(l);
    paramBufferedSource.read(buffer, l);
    if (buffer.size() == l) {
      this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Data[%s]", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
            public void execute() {
              try {
                boolean bool = FramedConnection.this.pushObserver.onData(streamId, (BufferedSource)buffer, byteCount, inFinished);
                if (bool)
                  FramedConnection.this.frameWriter.rstStream(streamId, ErrorCode.CANCEL); 
                if (bool || inFinished)
                  synchronized (FramedConnection.this) {
                    FramedConnection.this.currentPushRequests.remove(Integer.valueOf(streamId));
                    return;
                  }  
                return;
              } catch (IOException iOException) {
                return;
              } 
            }
          });
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(buffer.size());
    stringBuilder.append(" != ");
    stringBuilder.append(byteCount);
    throw new IOException(stringBuilder.toString());
  }
  
  private void pushHeadersLater(final int streamId, final List<Header> requestHeaders, final boolean inFinished) {
    this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
          public void execute() {
            // Byte code:
            //   0: aload_0
            //   1: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
            //   4: invokestatic access$2700 : (Lcom/squareup/okhttp/internal/framed/FramedConnection;)Lcom/squareup/okhttp/internal/framed/PushObserver;
            //   7: aload_0
            //   8: getfield val$streamId : I
            //   11: aload_0
            //   12: getfield val$requestHeaders : Ljava/util/List;
            //   15: aload_0
            //   16: getfield val$inFinished : Z
            //   19: invokeinterface onHeaders : (ILjava/util/List;Z)Z
            //   24: istore_1
            //   25: iload_1
            //   26: ifeq -> 48
            //   29: aload_0
            //   30: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
            //   33: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
            //   36: aload_0
            //   37: getfield val$streamId : I
            //   40: getstatic com/squareup/okhttp/internal/framed/ErrorCode.CANCEL : Lcom/squareup/okhttp/internal/framed/ErrorCode;
            //   43: invokeinterface rstStream : (ILcom/squareup/okhttp/internal/framed/ErrorCode;)V
            //   48: iload_1
            //   49: ifne -> 59
            //   52: aload_0
            //   53: getfield val$inFinished : Z
            //   56: ifeq -> 94
            //   59: aload_0
            //   60: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
            //   63: astore_2
            //   64: aload_2
            //   65: monitorenter
            //   66: aload_0
            //   67: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
            //   70: invokestatic access$2800 : (Lcom/squareup/okhttp/internal/framed/FramedConnection;)Ljava/util/Set;
            //   73: aload_0
            //   74: getfield val$streamId : I
            //   77: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   80: invokeinterface remove : (Ljava/lang/Object;)Z
            //   85: pop
            //   86: aload_2
            //   87: monitorexit
            //   88: return
            //   89: astore_3
            //   90: aload_2
            //   91: monitorexit
            //   92: aload_3
            //   93: athrow
            //   94: return
            //   95: astore_2
            //   96: return
            // Exception table:
            //   from	to	target	type
            //   29	48	95	java/io/IOException
            //   52	59	95	java/io/IOException
            //   59	66	95	java/io/IOException
            //   66	88	89	finally
            //   90	92	89	finally
            //   92	94	95	java/io/IOException
          }
        });
  }
  
  private void pushRequestLater(int paramInt, List<Header> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield currentPushRequests : Ljava/util/Set;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface contains : (Ljava/lang/Object;)Z
    //   15: ifeq -> 29
    //   18: aload_0
    //   19: iload_1
    //   20: getstatic com/squareup/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   23: invokevirtual writeSynResetLater : (ILcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield currentPushRequests : Ljava/util/Set;
    //   33: iload_1
    //   34: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   37: invokeinterface add : (Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: getfield pushExecutor : Ljava/util/concurrent/ExecutorService;
    //   49: new com/squareup/okhttp/internal/framed/FramedConnection$4
    //   52: dup
    //   53: aload_0
    //   54: ldc_w 'OkHttp %s Push Request[%s]'
    //   57: iconst_2
    //   58: anewarray java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: getfield hostName : Ljava/lang/String;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: iload_1
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: aastore
    //   75: iload_1
    //   76: aload_2
    //   77: invokespecial <init> : (Lcom/squareup/okhttp/internal/framed/FramedConnection;Ljava/lang/String;[Ljava/lang/Object;ILjava/util/List;)V
    //   80: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   85: return
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	86	finally
    //   29	45	86	finally
    //   87	89	86	finally
  }
  
  private void pushResetLater(final int streamId, final ErrorCode errorCode) {
    this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
          public void execute() {
            FramedConnection.this.pushObserver.onReset(streamId, errorCode);
            synchronized (FramedConnection.this) {
              FramedConnection.this.currentPushRequests.remove(Integer.valueOf(streamId));
              return;
            } 
          }
        });
  }
  
  private boolean pushedStream(int paramInt) {
    return (this.protocol == Protocol.HTTP_2 && paramInt != 0 && (paramInt & 0x1) == 0);
  }
  
  private Ping removePing(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield pings : Ljava/util/Map;
    //   6: ifnull -> 29
    //   9: aload_0
    //   10: getfield pings : Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   17: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast com/squareup/okhttp/internal/framed/Ping
    //   25: astore_2
    //   26: goto -> 31
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void setIdle(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 31
    //   6: invokestatic nanoTime : ()J
    //   9: lstore_2
    //   10: goto -> 13
    //   13: aload_0
    //   14: lload_2
    //   15: putfield idleStartTimeNs : J
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: monitorexit
    //   23: aload #4
    //   25: athrow
    //   26: astore #4
    //   28: goto -> 21
    //   31: ldc2_w 9223372036854775807
    //   34: lstore_2
    //   35: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   6	10	26	finally
    //   13	18	26	finally
  }
  
  private void writePing(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   4: astore #5
    //   6: aload #5
    //   8: monitorenter
    //   9: aload #4
    //   11: ifnull -> 19
    //   14: aload #4
    //   16: invokevirtual send : ()V
    //   19: aload_0
    //   20: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   23: iload_1
    //   24: iload_2
    //   25: iload_3
    //   26: invokeinterface ping : (ZII)V
    //   31: aload #5
    //   33: monitorexit
    //   34: return
    //   35: astore #4
    //   37: aload #5
    //   39: monitorexit
    //   40: aload #4
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   14	19	35	finally
    //   19	34	35	finally
    //   37	40	35	finally
  }
  
  private void writePingLater(final boolean reply, final int payload1, final int payload2, final Ping ping) {
    executor.execute((Runnable)new NamedRunnable("OkHttp %s ping %08x%08x", new Object[] { this.hostName, Integer.valueOf(payload1), Integer.valueOf(payload2) }) {
          public void execute() {
            try {
              FramedConnection.this.writePing(reply, payload1, payload2, ping);
              return;
            } catch (IOException iOException) {
              return;
            } 
          }
        });
  }
  
  void addBytesToWriteWindow(long paramLong) {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L)
      notifyAll(); 
  }
  
  public void close() throws IOException {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public void flush() throws IOException {
    this.frameWriter.flush();
  }
  
  public long getIdleStartTimeNs() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield idleStartTimeNs : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public Protocol getProtocol() {
    return this.protocol;
  }
  
  FramedStream getStream(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast com/squareup/okhttp/internal/framed/FramedStream
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	23	finally
  }
  
  public boolean isIdle() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield idleStartTimeNs : J
    //   6: lstore_1
    //   7: lload_1
    //   8: ldc2_w 9223372036854775807
    //   11: lcmp
    //   12: ifeq -> 20
    //   15: iconst_1
    //   16: istore_3
    //   17: goto -> 22
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: astore #4
    //   28: aload_0
    //   29: monitorexit
    //   30: aload #4
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
  }
  
  public int maxConcurrentStreams() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield peerSettings : Lcom/squareup/okhttp/internal/framed/Settings;
    //   6: ldc 2147483647
    //   8: invokevirtual getMaxConcurrentStreams : (I)I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
  
  public FramedStream newStream(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
    return newStream(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int openStreamCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
  
  public Ping ping() throws IOException {
    // Byte code:
    //   0: new com/squareup/okhttp/internal/framed/Ping
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield shutdown : Z
    //   14: ifne -> 79
    //   17: aload_0
    //   18: getfield nextPingId : I
    //   21: istore_1
    //   22: aload_0
    //   23: aload_0
    //   24: getfield nextPingId : I
    //   27: iconst_2
    //   28: iadd
    //   29: putfield nextPingId : I
    //   32: aload_0
    //   33: getfield pings : Ljava/util/Map;
    //   36: ifnonnull -> 50
    //   39: aload_0
    //   40: new java/util/HashMap
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: putfield pings : Ljava/util/Map;
    //   50: aload_0
    //   51: getfield pings : Ljava/util/Map;
    //   54: iload_1
    //   55: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   58: aload_2
    //   59: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_0
    //   68: iconst_0
    //   69: iload_1
    //   70: ldc_w 1330343787
    //   73: aload_2
    //   74: invokespecial writePing : (ZIILcom/squareup/okhttp/internal/framed/Ping;)V
    //   77: aload_2
    //   78: areturn
    //   79: new java/io/IOException
    //   82: dup
    //   83: ldc_w 'shutdown'
    //   86: invokespecial <init> : (Ljava/lang/String;)V
    //   89: athrow
    //   90: astore_2
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   10	50	90	finally
    //   50	67	90	finally
    //   79	90	90	finally
    //   91	93	90	finally
  }
  
  public FramedStream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean) throws IOException {
    if (!this.client) {
      if (this.protocol == Protocol.HTTP_2)
        return newStream(paramInt, paramList, paramBoolean, false); 
      throw new IllegalStateException("protocol != HTTP_2");
    } 
    throw new IllegalStateException("Client cannot push requests.");
  }
  
  FramedStream removeStream(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast com/squareup/okhttp/internal/framed/FramedStream
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull -> 40
    //   23: aload_0
    //   24: getfield streams : Ljava/util/Map;
    //   27: invokeinterface isEmpty : ()Z
    //   32: ifeq -> 40
    //   35: aload_0
    //   36: iconst_1
    //   37: invokespecial setIdle : (Z)V
    //   40: aload_0
    //   41: invokevirtual notifyAll : ()V
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	48	finally
    //   23	40	48	finally
    //   40	44	48	finally
  }
  
  public void sendConnectionPreface() throws IOException {
    this.frameWriter.connectionPreface();
    this.frameWriter.settings(this.okHttpSettings);
    int i = this.okHttpSettings.getInitialWindowSize(65536);
    if (i != 65536)
      this.frameWriter.windowUpdate(0, (i - 65536)); 
  }
  
  public void setSettings(Settings paramSettings) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield shutdown : Z
    //   13: ifne -> 39
    //   16: aload_0
    //   17: getfield okHttpSettings : Lcom/squareup/okhttp/internal/framed/Settings;
    //   20: aload_1
    //   21: invokevirtual merge : (Lcom/squareup/okhttp/internal/framed/Settings;)V
    //   24: aload_0
    //   25: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   28: aload_1
    //   29: invokeinterface settings : (Lcom/squareup/okhttp/internal/framed/Settings;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: monitorexit
    //   38: return
    //   39: new java/io/IOException
    //   42: dup
    //   43: ldc_w 'shutdown'
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: athrow
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: aload_2
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   7	9	55	finally
    //   9	36	50	finally
    //   36	38	55	finally
    //   39	50	50	finally
    //   51	53	50	finally
    //   53	55	55	finally
    //   56	58	55	finally
  }
  
  public void shutdown(ErrorCode paramErrorCode) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield shutdown : Z
    //   13: ifeq -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_3
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield shutdown : Z
    //   26: aload_0
    //   27: getfield lastGoodStreamId : I
    //   30: istore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   37: iload_2
    //   38: aload_1
    //   39: getstatic com/squareup/okhttp/internal/Util.EMPTY_BYTE_ARRAY : [B
    //   42: invokeinterface goAway : (ILcom/squareup/okhttp/internal/framed/ErrorCode;[B)V
    //   47: aload_3
    //   48: monitorexit
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: aload_3
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   7	9	55	finally
    //   9	18	50	finally
    //   18	20	55	finally
    //   21	33	50	finally
    //   33	49	55	finally
    //   51	53	50	finally
    //   53	55	55	finally
    //   56	58	55	finally
  }
  
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong) throws IOException {
    // Byte code:
    //   0: lload #4
    //   2: lstore #8
    //   4: lload #4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne -> 25
    //   11: aload_0
    //   12: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokeinterface data : (ZILokio/Buffer;I)V
    //   24: return
    //   25: lload #8
    //   27: lconst_0
    //   28: lcmp
    //   29: ifle -> 188
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield bytesLeftInWriteWindow : J
    //   38: lconst_0
    //   39: lcmp
    //   40: ifgt -> 77
    //   43: aload_0
    //   44: getfield streams : Ljava/util/Map;
    //   47: iload_1
    //   48: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   51: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   56: ifeq -> 66
    //   59: aload_0
    //   60: invokevirtual wait : ()V
    //   63: goto -> 34
    //   66: new java/io/IOException
    //   69: dup
    //   70: ldc_w 'stream closed'
    //   73: invokespecial <init> : (Ljava/lang/String;)V
    //   76: athrow
    //   77: lload #8
    //   79: aload_0
    //   80: getfield bytesLeftInWriteWindow : J
    //   83: invokestatic min : (JJ)J
    //   86: l2i
    //   87: aload_0
    //   88: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   91: invokeinterface maxDataLength : ()I
    //   96: invokestatic min : (II)I
    //   99: istore #6
    //   101: aload_0
    //   102: getfield bytesLeftInWriteWindow : J
    //   105: lstore #4
    //   107: iload #6
    //   109: i2l
    //   110: lstore #10
    //   112: aload_0
    //   113: lload #4
    //   115: lload #10
    //   117: lsub
    //   118: putfield bytesLeftInWriteWindow : J
    //   121: aload_0
    //   122: monitorexit
    //   123: lload #8
    //   125: lload #10
    //   127: lsub
    //   128: lstore #8
    //   130: aload_0
    //   131: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   134: astore #12
    //   136: iload_2
    //   137: ifeq -> 153
    //   140: lload #8
    //   142: lconst_0
    //   143: lcmp
    //   144: ifne -> 153
    //   147: iconst_1
    //   148: istore #7
    //   150: goto -> 156
    //   153: iconst_0
    //   154: istore #7
    //   156: aload #12
    //   158: iload #7
    //   160: iload_1
    //   161: aload_3
    //   162: iload #6
    //   164: invokeinterface data : (ZILokio/Buffer;I)V
    //   169: goto -> 25
    //   172: astore_3
    //   173: goto -> 184
    //   176: new java/io/InterruptedIOException
    //   179: dup
    //   180: invokespecial <init> : ()V
    //   183: athrow
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_3
    //   187: athrow
    //   188: return
    //   189: astore_3
    //   190: goto -> 176
    // Exception table:
    //   from	to	target	type
    //   34	63	189	java/lang/InterruptedException
    //   34	63	172	finally
    //   66	77	189	java/lang/InterruptedException
    //   66	77	172	finally
    //   77	107	172	finally
    //   112	123	172	finally
    //   176	184	172	finally
    //   184	186	172	finally
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList) throws IOException {
    this.frameWriter.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode) throws IOException {
    this.frameWriter.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(final int streamId, final ErrorCode errorCode) {
    executor.submit((Runnable)new NamedRunnable("OkHttp %s stream %d", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
          public void execute() {
            try {
              FramedConnection.this.writeSynReset(streamId, errorCode);
              return;
            } catch (IOException iOException) {
              return;
            } 
          }
        });
  }
  
  void writeWindowUpdateLater(final int streamId, final long unacknowledgedBytesRead) {
    executor.execute((Runnable)new NamedRunnable("OkHttp Window Update %s stream %d", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
          public void execute() {
            try {
              FramedConnection.this.frameWriter.windowUpdate(streamId, unacknowledgedBytesRead);
              return;
            } catch (IOException iOException) {
              return;
            } 
          }
        });
  }
  
  public static class Builder {
    private boolean client;
    
    private String hostName;
    
    private FramedConnection.Listener listener = FramedConnection.Listener.REFUSE_INCOMING_STREAMS;
    
    private Protocol protocol = Protocol.SPDY_3;
    
    private PushObserver pushObserver = PushObserver.CANCEL;
    
    private BufferedSink sink;
    
    private Socket socket;
    
    private BufferedSource source;
    
    public Builder(boolean param1Boolean) throws IOException {
      this.client = param1Boolean;
    }
    
    public FramedConnection build() throws IOException {
      return new FramedConnection(this);
    }
    
    public Builder listener(FramedConnection.Listener param1Listener) {
      this.listener = param1Listener;
      return this;
    }
    
    public Builder protocol(Protocol param1Protocol) {
      this.protocol = param1Protocol;
      return this;
    }
    
    public Builder pushObserver(PushObserver param1PushObserver) {
      this.pushObserver = param1PushObserver;
      return this;
    }
    
    public Builder socket(Socket param1Socket) throws IOException {
      return socket(param1Socket, ((InetSocketAddress)param1Socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(param1Socket)), Okio.buffer(Okio.sink(param1Socket)));
    }
    
    public Builder socket(Socket param1Socket, String param1String, BufferedSource param1BufferedSource, BufferedSink param1BufferedSink) {
      this.socket = param1Socket;
      this.hostName = param1String;
      this.source = param1BufferedSource;
      this.sink = param1BufferedSink;
      return this;
    }
  }
  
  public static abstract class Listener {
    public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
        public void onStream(FramedStream param2FramedStream) throws IOException {
          param2FramedStream.close(ErrorCode.REFUSED_STREAM);
        }
      };
    
    public void onSettings(FramedConnection param1FramedConnection) {}
    
    public abstract void onStream(FramedStream param1FramedStream) throws IOException;
  }
  
  static final class null extends Listener {
    public void onStream(FramedStream param1FramedStream) throws IOException {
      param1FramedStream.close(ErrorCode.REFUSED_STREAM);
    }
  }
  
  class Reader extends NamedRunnable implements FrameReader.Handler {
    final FrameReader frameReader;
    
    private Reader(FrameReader param1FrameReader) {
      super("OkHttp %s", new Object[] { FramedConnection.access$1100(this$0) });
      this.frameReader = param1FrameReader;
    }
    
    private void ackSettingsLater(final Settings peerSettings) {
      FramedConnection.executor.execute((Runnable)new NamedRunnable("OkHttp %s ACK Settings", new Object[] { FramedConnection.access$1100(this.this$0) }) {
            public void execute() {
              try {
                FramedConnection.this.frameWriter.ackSettings(peerSettings);
                return;
              } catch (IOException iOException) {
                return;
              } 
            }
          });
    }
    
    public void ackSettings() {}
    
    public void alternateService(int param1Int1, String param1String1, ByteString param1ByteString, String param1String2, int param1Int2, long param1Long) {}
    
    public void data(boolean param1Boolean, int param1Int1, BufferedSource param1BufferedSource, int param1Int2) throws IOException {
      if (FramedConnection.this.pushedStream(param1Int1)) {
        FramedConnection.this.pushDataLater(param1Int1, param1BufferedSource, param1Int2, param1Boolean);
        return;
      } 
      FramedStream framedStream = FramedConnection.this.getStream(param1Int1);
      if (framedStream == null) {
        FramedConnection.this.writeSynResetLater(param1Int1, ErrorCode.INVALID_STREAM);
        param1BufferedSource.skip(param1Int2);
        return;
      } 
      framedStream.receiveData(param1BufferedSource, param1Int2);
      if (param1Boolean)
        framedStream.receiveFin(); 
    }
    
    public void execute() {
      // Byte code:
      //   0: getstatic com/squareup/okhttp/internal/framed/ErrorCode.INTERNAL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   3: astore_3
      //   4: getstatic com/squareup/okhttp/internal/framed/ErrorCode.INTERNAL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   7: astore #5
      //   9: aload_3
      //   10: astore_1
      //   11: aload_3
      //   12: astore_2
      //   13: aload_0
      //   14: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   17: getfield client : Z
      //   20: ifne -> 36
      //   23: aload_3
      //   24: astore_1
      //   25: aload_3
      //   26: astore_2
      //   27: aload_0
      //   28: getfield frameReader : Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   31: invokeinterface readConnectionPreface : ()V
      //   36: aload_3
      //   37: astore_1
      //   38: aload_3
      //   39: astore_2
      //   40: aload_0
      //   41: getfield frameReader : Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   44: aload_0
      //   45: invokeinterface nextFrame : (Lcom/squareup/okhttp/internal/framed/FrameReader$Handler;)Z
      //   50: ifeq -> 56
      //   53: goto -> 36
      //   56: aload_3
      //   57: astore_1
      //   58: aload_3
      //   59: astore_2
      //   60: getstatic com/squareup/okhttp/internal/framed/ErrorCode.NO_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   63: astore_3
      //   64: aload_3
      //   65: astore_1
      //   66: aload_3
      //   67: astore_2
      //   68: getstatic com/squareup/okhttp/internal/framed/ErrorCode.CANCEL : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   71: astore #4
      //   73: aload_0
      //   74: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   77: astore #5
      //   79: aload_3
      //   80: astore_2
      //   81: aload #4
      //   83: astore_1
      //   84: aload #5
      //   86: astore_3
      //   87: goto -> 115
      //   90: astore_2
      //   91: goto -> 129
      //   94: aload_2
      //   95: astore_1
      //   96: getstatic com/squareup/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   99: astore_2
      //   100: aload_2
      //   101: astore_1
      //   102: getstatic com/squareup/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   105: astore #4
      //   107: aload_0
      //   108: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   111: astore_3
      //   112: aload #4
      //   114: astore_1
      //   115: aload_3
      //   116: aload_2
      //   117: aload_1
      //   118: invokestatic access$1200 : (Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   121: aload_0
      //   122: getfield frameReader : Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   125: invokestatic closeQuietly : (Ljava/io/Closeable;)V
      //   128: return
      //   129: aload_0
      //   130: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   133: aload_1
      //   134: aload #5
      //   136: invokestatic access$1200 : (Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   139: aload_0
      //   140: getfield frameReader : Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   143: invokestatic closeQuietly : (Ljava/io/Closeable;)V
      //   146: aload_2
      //   147: athrow
      //   148: astore_1
      //   149: goto -> 94
      //   152: astore_1
      //   153: goto -> 121
      //   156: astore_1
      //   157: goto -> 139
      // Exception table:
      //   from	to	target	type
      //   13	23	148	java/io/IOException
      //   13	23	90	finally
      //   27	36	148	java/io/IOException
      //   27	36	90	finally
      //   40	53	148	java/io/IOException
      //   40	53	90	finally
      //   60	64	148	java/io/IOException
      //   60	64	90	finally
      //   68	73	148	java/io/IOException
      //   68	73	90	finally
      //   73	79	152	java/io/IOException
      //   96	100	90	finally
      //   102	107	90	finally
      //   107	112	152	java/io/IOException
      //   115	121	152	java/io/IOException
      //   129	139	156	java/io/IOException
    }
    
    public void goAway(int param1Int, ErrorCode param1ErrorCode, ByteString param1ByteString) {
      FramedConnection framedConnection;
      FramedStream framedStream;
      param1ByteString.size();
      synchronized (FramedConnection.this) {
        FramedStream[] arrayOfFramedStream = (FramedStream[])FramedConnection.this.streams.values().toArray((Object[])new FramedStream[FramedConnection.this.streams.size()]);
        FramedConnection.access$1602(FramedConnection.this, true);
        int j = arrayOfFramedStream.length;
        int i;
        for (i = 0; i < j; i++) {
          framedStream = arrayOfFramedStream[i];
          if (framedStream.getId() > param1Int && framedStream.isLocallyInitiated()) {
            framedStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
            FramedConnection.this.removeStream(framedStream.getId());
          } 
        } 
        return;
      } 
    }
    
    public void headers(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, List<Header> param1List, HeadersMode param1HeadersMode) {
      if (FramedConnection.this.pushedStream(param1Int1)) {
        FramedConnection.this.pushHeadersLater(param1Int1, param1List, param1Boolean2);
        return;
      } 
      synchronized (FramedConnection.this) {
        final FramedStream newStream;
        if (FramedConnection.this.shutdown)
          return; 
        FramedStream framedStream2 = FramedConnection.this.getStream(param1Int1);
        if (framedStream2 == null) {
          if (param1HeadersMode.failIfStreamAbsent()) {
            FramedConnection.this.writeSynResetLater(param1Int1, ErrorCode.INVALID_STREAM);
            return;
          } 
          if (param1Int1 <= FramedConnection.this.lastGoodStreamId)
            return; 
          if (param1Int1 % 2 == FramedConnection.this.nextStreamId % 2)
            return; 
          framedStream1 = new FramedStream(param1Int1, FramedConnection.this, param1Boolean1, param1Boolean2, param1List);
          FramedConnection.access$1702(FramedConnection.this, param1Int1);
          FramedConnection.this.streams.put(Integer.valueOf(param1Int1), framedStream1);
          FramedConnection.executor.execute((Runnable)new NamedRunnable("OkHttp %s stream %d", new Object[] { FramedConnection.access$1100(this.this$0), Integer.valueOf(param1Int1) }) {
                public void execute() {
                  try {
                    FramedConnection.this.listener.onStream(newStream);
                    return;
                  } catch (IOException iOException) {
                    Logger logger = Internal.logger;
                    Level level = Level.INFO;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("FramedConnection.Listener failure for ");
                    stringBuilder.append(FramedConnection.this.hostName);
                    logger.log(level, stringBuilder.toString(), iOException);
                    try {
                      newStream.close(ErrorCode.PROTOCOL_ERROR);
                      return;
                    } catch (IOException iOException1) {
                      return;
                    } 
                  } 
                }
              });
          return;
        } 
        if (param1HeadersMode.failIfStreamPresent()) {
          framedStream2.closeLater(ErrorCode.PROTOCOL_ERROR);
          FramedConnection.this.removeStream(param1Int1);
          return;
        } 
        framedStream2.receiveHeaders((List<Header>)framedStream1, param1HeadersMode);
        if (param1Boolean2)
          framedStream2.receiveFin(); 
        return;
      } 
    }
    
    public void ping(boolean param1Boolean, int param1Int1, int param1Int2) {
      if (param1Boolean) {
        Ping ping = FramedConnection.this.removePing(param1Int1);
        if (ping != null) {
          ping.receive();
          return;
        } 
      } else {
        FramedConnection.this.writePingLater(true, param1Int1, param1Int2, null);
      } 
    }
    
    public void priority(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {}
    
    public void pushPromise(int param1Int1, int param1Int2, List<Header> param1List) {
      FramedConnection.this.pushRequestLater(param1Int2, param1List);
    }
    
    public void rstStream(int param1Int, ErrorCode param1ErrorCode) {
      if (FramedConnection.this.pushedStream(param1Int)) {
        FramedConnection.this.pushResetLater(param1Int, param1ErrorCode);
        return;
      } 
      FramedStream framedStream = FramedConnection.this.removeStream(param1Int);
      if (framedStream != null)
        framedStream.receiveRstStream(param1ErrorCode); 
    }
    
    public void settings(boolean param1Boolean, Settings param1Settings) {
      synchronized (FramedConnection.this) {
        FramedStream[] arrayOfFramedStream;
        long l;
        int i = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
        if (param1Boolean)
          FramedConnection.this.peerSettings.clear(); 
        FramedConnection.this.peerSettings.merge(param1Settings);
        if (FramedConnection.this.getProtocol() == Protocol.HTTP_2)
          ackSettingsLater(param1Settings); 
        int j = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
        param1Settings = null;
        if (j != -1 && j != i) {
          long l1 = (j - i);
          if (!FramedConnection.this.receivedInitialPeerSettings) {
            FramedConnection.this.addBytesToWriteWindow(l1);
            FramedConnection.access$2302(FramedConnection.this, true);
          } 
          l = l1;
          if (!FramedConnection.this.streams.isEmpty()) {
            arrayOfFramedStream = (FramedStream[])FramedConnection.this.streams.values().toArray((Object[])new FramedStream[FramedConnection.this.streams.size()]);
            l = l1;
          } 
        } else {
          l = 0L;
        } 
        ExecutorService executorService = FramedConnection.executor;
        String str = FramedConnection.this.hostName;
        i = 0;
        executorService.execute((Runnable)new NamedRunnable("OkHttp %s settings", new Object[] { str }) {
              public void execute() {
                FramedConnection.this.listener.onSettings(FramedConnection.this);
              }
            });
        if (arrayOfFramedStream != null && l != 0L) {
          j = arrayOfFramedStream.length;
          while (i < j) {
            synchronized (arrayOfFramedStream[i]) {
              null.addBytesToWriteWindow(l);
              i++;
            } 
          } 
        } 
        return;
      } 
    }
    
    public void windowUpdate(int param1Int, long param1Long) {
      // Byte code:
      //   0: iload_1
      //   1: ifne -> 50
      //   4: aload_0
      //   5: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   8: astore #4
      //   10: aload #4
      //   12: monitorenter
      //   13: aload_0
      //   14: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   17: astore #5
      //   19: aload #5
      //   21: aload #5
      //   23: getfield bytesLeftInWriteWindow : J
      //   26: lload_2
      //   27: ladd
      //   28: putfield bytesLeftInWriteWindow : J
      //   31: aload_0
      //   32: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   35: invokevirtual notifyAll : ()V
      //   38: aload #4
      //   40: monitorexit
      //   41: return
      //   42: astore #5
      //   44: aload #4
      //   46: monitorexit
      //   47: aload #5
      //   49: athrow
      //   50: aload_0
      //   51: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   54: iload_1
      //   55: invokevirtual getStream : (I)Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   58: astore #4
      //   60: aload #4
      //   62: ifnull -> 86
      //   65: aload #4
      //   67: monitorenter
      //   68: aload #4
      //   70: lload_2
      //   71: invokevirtual addBytesToWriteWindow : (J)V
      //   74: aload #4
      //   76: monitorexit
      //   77: return
      //   78: astore #5
      //   80: aload #4
      //   82: monitorexit
      //   83: aload #5
      //   85: athrow
      //   86: return
      // Exception table:
      //   from	to	target	type
      //   13	41	42	finally
      //   44	47	42	finally
      //   68	77	78	finally
      //   80	83	78	finally
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object[] param1ArrayOfObject) {
      super(param1String, param1ArrayOfObject);
    }
    
    public void execute() {
      try {
        FramedConnection.this.listener.onStream(newStream);
        return;
      } catch (IOException iOException) {
        Logger logger = Internal.logger;
        Level level = Level.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FramedConnection.Listener failure for ");
        stringBuilder.append(FramedConnection.this.hostName);
        logger.log(level, stringBuilder.toString(), iOException);
        try {
          newStream.close(ErrorCode.PROTOCOL_ERROR);
          return;
        } catch (IOException iOException1) {
          return;
        } 
      } 
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object... param1VarArgs) {
      super(param1String, param1VarArgs);
    }
    
    public void execute() {
      FramedConnection.this.listener.onSettings(FramedConnection.this);
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object[] param1ArrayOfObject) {
      super(param1String, param1ArrayOfObject);
    }
    
    public void execute() {
      try {
        FramedConnection.this.frameWriter.ackSettings(peerSettings);
        return;
      } catch (IOException iOException) {
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\FramedConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */