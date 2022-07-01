package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class ConnectionPool {
  private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
  
  private static final ConnectionPool systemDefault;
  
  private Runnable cleanupRunnable = new Runnable() {
      public void run() {
        while (true) {
          long l = ConnectionPool.this.cleanup(System.nanoTime());
          if (l == -1L)
            return; 
          if (l > 0L) {
            long l1 = l / 1000000L;
            synchronized (ConnectionPool.this) {
              ConnectionPool.this.wait(l1, (int)(l - 1000000L * l1));
            } 
            /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_5} */
          } 
        } 
      }
    };
  
  private final Deque<RealConnection> connections = new ArrayDeque<RealConnection>();
  
  private final Executor executor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory("OkHttp ConnectionPool", true));
  
  private final long keepAliveDurationNs;
  
  private final int maxIdleConnections;
  
  final RouteDatabase routeDatabase = new RouteDatabase();
  
  static {
    long l;
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    if (str2 != null) {
      l = Long.parseLong(str2);
    } else {
      l = 300000L;
    } 
    if (str1 != null && !Boolean.parseBoolean(str1)) {
      systemDefault = new ConnectionPool(0, l);
      return;
    } 
    if (str3 != null) {
      systemDefault = new ConnectionPool(Integer.parseInt(str3), l);
      return;
    } 
    systemDefault = new ConnectionPool(5, l);
  }
  
  public ConnectionPool(int paramInt, long paramLong) {
    this(paramInt, paramLong, TimeUnit.MILLISECONDS);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit) {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong > 0L)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("keepAliveDuration <= 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static ConnectionPool getDefault() {
    return systemDefault;
  }
  
  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong) {
    List<Reference> list = paramRealConnection.allocations;
    int i = 0;
    while (i < list.size()) {
      if (((Reference)list.get(i)).get() != null) {
        i++;
        continue;
      } 
      Logger logger = Internal.logger;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("A connection to ");
      stringBuilder.append(paramRealConnection.getRoute().getAddress().url());
      stringBuilder.append(" was leaked. Did you forget to close a response body?");
      logger.warning(stringBuilder.toString());
      list.remove(i);
      paramRealConnection.noNewStreams = true;
      if (list.isEmpty()) {
        paramRealConnection.idleAtNanos = paramLong - this.keepAliveDurationNs;
        return 0;
      } 
    } 
    return list.size();
  }
  
  long cleanup(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connections : Ljava/util/Deque;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore #12
    //   13: iconst_0
    //   14: istore_3
    //   15: aconst_null
    //   16: astore #10
    //   18: ldc2_w -9223372036854775808
    //   21: lstore #6
    //   23: iconst_0
    //   24: istore #4
    //   26: aload #12
    //   28: invokeinterface hasNext : ()Z
    //   33: ifeq -> 106
    //   36: aload #12
    //   38: invokeinterface next : ()Ljava/lang/Object;
    //   43: checkcast com/squareup/okhttp/internal/io/RealConnection
    //   46: astore #11
    //   48: aload_0
    //   49: aload #11
    //   51: lload_1
    //   52: invokespecial pruneAndGetAllocationCount : (Lcom/squareup/okhttp/internal/io/RealConnection;J)I
    //   55: ifle -> 67
    //   58: iload #4
    //   60: iconst_1
    //   61: iadd
    //   62: istore #4
    //   64: goto -> 26
    //   67: iload_3
    //   68: iconst_1
    //   69: iadd
    //   70: istore #5
    //   72: lload_1
    //   73: aload #11
    //   75: getfield idleAtNanos : J
    //   78: lsub
    //   79: lstore #8
    //   81: iload #5
    //   83: istore_3
    //   84: lload #8
    //   86: lload #6
    //   88: lcmp
    //   89: ifle -> 26
    //   92: aload #11
    //   94: astore #10
    //   96: lload #8
    //   98: lstore #6
    //   100: iload #5
    //   102: istore_3
    //   103: goto -> 26
    //   106: lload #6
    //   108: aload_0
    //   109: getfield keepAliveDurationNs : J
    //   112: lcmp
    //   113: ifge -> 163
    //   116: iload_3
    //   117: aload_0
    //   118: getfield maxIdleConnections : I
    //   121: if_icmple -> 127
    //   124: goto -> 163
    //   127: iload_3
    //   128: ifle -> 143
    //   131: aload_0
    //   132: getfield keepAliveDurationNs : J
    //   135: lstore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: lload_1
    //   139: lload #6
    //   141: lsub
    //   142: lreturn
    //   143: iload #4
    //   145: ifle -> 157
    //   148: aload_0
    //   149: getfield keepAliveDurationNs : J
    //   152: lstore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: lload_1
    //   156: lreturn
    //   157: aload_0
    //   158: monitorexit
    //   159: ldc2_w -1
    //   162: lreturn
    //   163: aload_0
    //   164: getfield connections : Ljava/util/Deque;
    //   167: aload #10
    //   169: invokeinterface remove : (Ljava/lang/Object;)Z
    //   174: pop
    //   175: aload_0
    //   176: monitorexit
    //   177: aload #10
    //   179: invokevirtual getSocket : ()Ljava/net/Socket;
    //   182: invokestatic closeQuietly : (Ljava/net/Socket;)V
    //   185: lconst_0
    //   186: lreturn
    //   187: astore #10
    //   189: aload_0
    //   190: monitorexit
    //   191: aload #10
    //   193: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	187	finally
    //   26	58	187	finally
    //   72	81	187	finally
    //   106	124	187	finally
    //   131	138	187	finally
    //   148	155	187	finally
    //   157	159	187	finally
    //   163	177	187	finally
    //   189	191	187	finally
  }
  
  boolean connectionBecameIdle(RealConnection paramRealConnection) {
    if (paramRealConnection.noNewStreams || this.maxIdleConnections == 0) {
      this.connections.remove(paramRealConnection);
      return true;
    } 
    notifyAll();
    return false;
  }
  
  public void evictAll() {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield connections : Ljava/util/Deque;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface hasNext : ()Z
    //   26: ifeq -> 73
    //   29: aload_2
    //   30: invokeinterface next : ()Ljava/lang/Object;
    //   35: checkcast com/squareup/okhttp/internal/io/RealConnection
    //   38: astore_3
    //   39: aload_3
    //   40: getfield allocations : Ljava/util/List;
    //   43: invokeinterface isEmpty : ()Z
    //   48: ifeq -> 20
    //   51: aload_3
    //   52: iconst_1
    //   53: putfield noNewStreams : Z
    //   56: aload_1
    //   57: aload_3
    //   58: invokeinterface add : (Ljava/lang/Object;)Z
    //   63: pop
    //   64: aload_2
    //   65: invokeinterface remove : ()V
    //   70: goto -> 20
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: invokeinterface iterator : ()Ljava/util/Iterator;
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface hasNext : ()Z
    //   88: ifeq -> 109
    //   91: aload_1
    //   92: invokeinterface next : ()Ljava/lang/Object;
    //   97: checkcast com/squareup/okhttp/internal/io/RealConnection
    //   100: invokevirtual getSocket : ()Ljava/net/Socket;
    //   103: invokestatic closeQuietly : (Ljava/net/Socket;)V
    //   106: goto -> 82
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Exception table:
    //   from	to	target	type
    //   10	20	110	finally
    //   20	70	110	finally
    //   73	75	110	finally
    //   111	113	110	finally
  }
  
  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation) {
    for (RealConnection realConnection : this.connections) {
      if (realConnection.allocations.size() < realConnection.allocationLimit() && paramAddress.equals((realConnection.getRoute()).address) && !realConnection.noNewStreams) {
        paramStreamAllocation.acquire(realConnection);
        return realConnection;
      } 
    } 
    return null;
  }
  
  public int getConnectionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connections : Ljava/util/Deque;
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
  
  public int getHttpConnectionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connections : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: invokevirtual getMultiplexedConnectionCount : ()I
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: iload_2
    //   21: isub
    //   22: ireturn
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	23	finally
  }
  
  public int getIdleConnectionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield connections : Ljava/util/Deque;
    //   8: invokeinterface iterator : ()Ljava/util/Iterator;
    //   13: astore_3
    //   14: aload_3
    //   15: invokeinterface hasNext : ()Z
    //   20: ifeq -> 52
    //   23: aload_3
    //   24: invokeinterface next : ()Ljava/lang/Object;
    //   29: checkcast com/squareup/okhttp/internal/io/RealConnection
    //   32: getfield allocations : Ljava/util/List;
    //   35: invokeinterface isEmpty : ()Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifeq -> 14
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -> 14
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_1
    //   55: ireturn
    //   56: astore_3
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_3
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   4	14	56	finally
    //   14	41	56	finally
  }
  
  public int getMultiplexedConnectionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield connections : Ljava/util/Deque;
    //   8: invokeinterface iterator : ()Ljava/util/Iterator;
    //   13: astore_3
    //   14: aload_3
    //   15: invokeinterface hasNext : ()Z
    //   20: ifeq -> 47
    //   23: aload_3
    //   24: invokeinterface next : ()Ljava/lang/Object;
    //   29: checkcast com/squareup/okhttp/internal/io/RealConnection
    //   32: invokevirtual isMultiplexed : ()Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifeq -> 14
    //   40: iload_1
    //   41: iconst_1
    //   42: iadd
    //   43: istore_1
    //   44: goto -> 14
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: astore_3
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   4	14	51	finally
    //   14	36	51	finally
  }
  
  @Deprecated
  public int getSpdyConnectionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual getMultiplexedConnectionCount : ()I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  void put(RealConnection paramRealConnection) {
    if (this.connections.isEmpty())
      this.executor.execute(this.cleanupRunnable); 
    this.connections.add(paramRealConnection);
  }
  
  void setCleanupRunnableForTest(Runnable paramRunnable) {
    this.cleanupRunnable = paramRunnable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\ConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */