package com.squareup.okhttp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

public final class Dispatcher {
  private final Deque<Call> executedCalls = new ArrayDeque<Call>();
  
  private ExecutorService executorService;
  
  private int maxRequests = 64;
  
  private int maxRequestsPerHost = 5;
  
  private final Deque<Call.AsyncCall> readyCalls = new ArrayDeque<Call.AsyncCall>();
  
  private final Deque<Call.AsyncCall> runningCalls = new ArrayDeque<Call.AsyncCall>();
  
  public Dispatcher() {}
  
  public Dispatcher(ExecutorService paramExecutorService) {
    this.executorService = paramExecutorService;
  }
  
  private void promoteCalls() {
    if (this.runningCalls.size() >= this.maxRequests)
      return; 
    if (this.readyCalls.isEmpty())
      return; 
    Iterator<Call.AsyncCall> iterator = this.readyCalls.iterator();
    while (iterator.hasNext()) {
      Call.AsyncCall asyncCall = iterator.next();
      if (runningCallsForHost(asyncCall) < this.maxRequestsPerHost) {
        iterator.remove();
        this.runningCalls.add(asyncCall);
        getExecutorService().execute((Runnable)asyncCall);
      } 
      if (this.runningCalls.size() >= this.maxRequests)
        break; 
    } 
  }
  
  private int runningCallsForHost(Call.AsyncCall paramAsyncCall) {
    Iterator<Call.AsyncCall> iterator = this.runningCalls.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      if (((Call.AsyncCall)iterator.next()).host().equals(paramAsyncCall.host()))
        i++; 
    } 
    return i;
  }
  
  public void cancel(Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readyCalls : Ljava/util/Deque;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 49
    //   21: aload_2
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/squareup/okhttp/Call$AsyncCall
    //   30: astore_3
    //   31: aload_1
    //   32: aload_3
    //   33: invokevirtual tag : ()Ljava/lang/Object;
    //   36: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   39: ifeq -> 12
    //   42: aload_3
    //   43: invokevirtual cancel : ()V
    //   46: goto -> 12
    //   49: aload_0
    //   50: getfield runningCalls : Ljava/util/Deque;
    //   53: invokeinterface iterator : ()Ljava/util/Iterator;
    //   58: astore_2
    //   59: aload_2
    //   60: invokeinterface hasNext : ()Z
    //   65: ifeq -> 116
    //   68: aload_2
    //   69: invokeinterface next : ()Ljava/lang/Object;
    //   74: checkcast com/squareup/okhttp/Call$AsyncCall
    //   77: astore_3
    //   78: aload_1
    //   79: aload_3
    //   80: invokevirtual tag : ()Ljava/lang/Object;
    //   83: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   86: ifeq -> 59
    //   89: aload_3
    //   90: invokevirtual get : ()Lcom/squareup/okhttp/Call;
    //   93: iconst_1
    //   94: putfield canceled : Z
    //   97: aload_3
    //   98: invokevirtual get : ()Lcom/squareup/okhttp/Call;
    //   101: getfield engine : Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull -> 59
    //   109: aload_3
    //   110: invokevirtual cancel : ()V
    //   113: goto -> 59
    //   116: aload_0
    //   117: getfield executedCalls : Ljava/util/Deque;
    //   120: invokeinterface iterator : ()Ljava/util/Iterator;
    //   125: astore_2
    //   126: aload_2
    //   127: invokeinterface hasNext : ()Z
    //   132: ifeq -> 163
    //   135: aload_2
    //   136: invokeinterface next : ()Ljava/lang/Object;
    //   141: checkcast com/squareup/okhttp/Call
    //   144: astore_3
    //   145: aload_1
    //   146: aload_3
    //   147: invokevirtual tag : ()Ljava/lang/Object;
    //   150: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   153: ifeq -> 126
    //   156: aload_3
    //   157: invokevirtual cancel : ()V
    //   160: goto -> 126
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	166	finally
    //   12	46	166	finally
    //   49	59	166	finally
    //   59	105	166	finally
    //   109	113	166	finally
    //   116	126	166	finally
    //   126	160	166	finally
  }
  
  void enqueue(Call.AsyncCall paramAsyncCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningCalls : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: aload_0
    //   12: getfield maxRequests : I
    //   15: if_icmpge -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial runningCallsForHost : (Lcom/squareup/okhttp/Call$AsyncCall;)I
    //   23: aload_0
    //   24: getfield maxRequestsPerHost : I
    //   27: if_icmpge -> 54
    //   30: aload_0
    //   31: getfield runningCalls : Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface add : (Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual getExecutorService : ()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   51: goto -> 65
    //   54: aload_0
    //   55: getfield readyCalls : Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface add : (Ljava/lang/Object;)Z
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  void executed(Call paramCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executedCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface add : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  void finished(Call.AsyncCall paramAsyncCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: ifeq -> 22
    //   15: aload_0
    //   16: invokespecial promoteCalls : ()V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: new java/lang/AssertionError
    //   25: dup
    //   26: ldc 'AsyncCall wasn't running!'
    //   28: invokespecial <init> : (Ljava/lang/Object;)V
    //   31: athrow
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	32	finally
    //   22	32	32	finally
  }
  
  void finished(Call paramCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executedCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: new java/lang/AssertionError
    //   23: dup
    //   24: ldc 'Call wasn't in-flight!'
    //   26: invokespecial <init> : (Ljava/lang/Object;)V
    //   29: athrow
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	30	finally
    //   20	30	30	finally
  }
  
  public ExecutorService getExecutorService() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executorService : Ljava/util/concurrent/ExecutorService;
    //   6: ifnonnull -> 42
    //   9: aload_0
    //   10: new java/util/concurrent/ThreadPoolExecutor
    //   13: dup
    //   14: iconst_0
    //   15: ldc 2147483647
    //   17: ldc2_w 60
    //   20: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   23: new java/util/concurrent/SynchronousQueue
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: ldc 'OkHttp Dispatcher'
    //   32: iconst_0
    //   33: invokestatic threadFactory : (Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;
    //   36: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   39: putfield executorService : Ljava/util/concurrent/ExecutorService;
    //   42: aload_0
    //   43: getfield executorService : Ljava/util/concurrent/ExecutorService;
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	51	finally
    //   42	47	51	finally
  }
  
  public int getMaxRequests() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxRequests : I
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
  
  public int getMaxRequestsPerHost() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxRequestsPerHost : I
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
  
  public int getQueuedCallCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readyCalls : Ljava/util/Deque;
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
  
  public int getRunningCallCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningCalls : Ljava/util/Deque;
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
  
  public void setMaxRequests(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_1
    //   4: if_icmplt -> 23
    //   7: aload_0
    //   8: iload_1
    //   9: putfield maxRequests : I
    //   12: aload_0
    //   13: invokespecial promoteCalls : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: goto -> 56
    //   23: new java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: astore_2
    //   31: aload_2
    //   32: ldc 'max < 1: '
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: iload_1
    //   40: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: new java/lang/IllegalArgumentException
    //   47: dup
    //   48: aload_2
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: athrow
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   7	16	19	finally
    //   23	56	19	finally
  }
  
  public void setMaxRequestsPerHost(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_1
    //   4: if_icmplt -> 23
    //   7: aload_0
    //   8: iload_1
    //   9: putfield maxRequestsPerHost : I
    //   12: aload_0
    //   13: invokespecial promoteCalls : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: goto -> 56
    //   23: new java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: astore_2
    //   31: aload_2
    //   32: ldc 'max < 1: '
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: iload_1
    //   40: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: new java/lang/IllegalArgumentException
    //   47: dup
    //   48: aload_2
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: athrow
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   7	16	19	finally
    //   23	56	19	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */