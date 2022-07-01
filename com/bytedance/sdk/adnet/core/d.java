package com.bytedance.sdk.adnet.core;

import android.os.Process;
import com.bytedance.sdk.adnet.face.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

class d extends Thread {
  private static final boolean a = p.a;
  
  private final BlockingQueue<Request<?>> b;
  
  private final BlockingQueue<Request<?>> c;
  
  private final com.bytedance.sdk.adnet.face.a d;
  
  private final c e;
  
  private volatile boolean f = false;
  
  private final a g;
  
  public d(BlockingQueue<Request<?>> paramBlockingQueue1, BlockingQueue<Request<?>> paramBlockingQueue2, com.bytedance.sdk.adnet.face.a parama, c paramc) {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = parama;
    this.e = paramc;
    this.g = new a(this);
  }
  
  private void b() throws InterruptedException {
    a(this.b.take());
  }
  
  public void a() {
    this.f = true;
    interrupt();
  }
  
  void a(Request<?> paramRequest) throws InterruptedException {
    paramRequest.addMarker("cache-queue-take");
    paramRequest.a(1);
    try {
      if (paramRequest.isCanceled()) {
        paramRequest.a("cache-discard-canceled");
        return;
      } 
      com.bytedance.sdk.adnet.face.a.a a1 = this.d.a(paramRequest.getCacheKey());
      if (a1 == null) {
        paramRequest.addMarker("cache-miss");
        if (!a.a(this.g, paramRequest))
          this.c.put(paramRequest); 
        return;
      } 
      if (a1.a()) {
        paramRequest.addMarker("cache-hit-expired");
        paramRequest.setCacheEntry(a1);
        if (!a.a(this.g, paramRequest))
          this.c.put(paramRequest); 
        return;
      } 
      paramRequest.addMarker("cache-hit");
      n<?> n = paramRequest.a(new j(a1.b, a1.h));
      paramRequest.addMarker("cache-hit-parsed");
    } finally {
      null = null;
    } 
    paramRequest.a(2);
  }
  
  public void run() {
    if (a)
      p.a("start new dispatcher", new Object[0]); 
    Process.setThreadPriority(10);
    this.d.a();
    while (true) {
      try {
        while (true)
          b(); 
        break;
      } catch (InterruptedException interruptedException) {
        if (this.f) {
          Thread.currentThread().interrupt();
          return;
        } 
        p.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
      } 
    } 
  }
  
  static class a implements Request.a {
    private final Map<String, List<Request<?>>> a = new HashMap<String, List<Request<?>>>();
    
    private final d b;
    
    a(d param1d) {
      this.b = param1d;
    }
    
    private boolean b(Request<?> param1Request) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokevirtual getCacheKey : ()Ljava/lang/String;
      //   6: astore #4
      //   8: aload_0
      //   9: getfield a : Ljava/util/Map;
      //   12: aload #4
      //   14: invokeinterface containsKey : (Ljava/lang/Object;)Z
      //   19: ifeq -> 102
      //   22: aload_0
      //   23: getfield a : Ljava/util/Map;
      //   26: aload #4
      //   28: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   33: checkcast java/util/List
      //   36: astore_3
      //   37: aload_3
      //   38: astore_2
      //   39: aload_3
      //   40: ifnonnull -> 51
      //   43: new java/util/ArrayList
      //   46: dup
      //   47: invokespecial <init> : ()V
      //   50: astore_2
      //   51: aload_1
      //   52: ldc 'waiting-for-response'
      //   54: invokevirtual addMarker : (Ljava/lang/String;)V
      //   57: aload_2
      //   58: aload_1
      //   59: invokeinterface add : (Ljava/lang/Object;)Z
      //   64: pop
      //   65: aload_0
      //   66: getfield a : Ljava/util/Map;
      //   69: aload #4
      //   71: aload_2
      //   72: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   77: pop
      //   78: getstatic com/bytedance/sdk/adnet/core/p.a : Z
      //   81: ifeq -> 98
      //   84: ldc 'Request for cacheKey=%s is in flight, putting on hold.'
      //   86: iconst_1
      //   87: anewarray java/lang/Object
      //   90: dup
      //   91: iconst_0
      //   92: aload #4
      //   94: aastore
      //   95: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   98: aload_0
      //   99: monitorexit
      //   100: iconst_1
      //   101: ireturn
      //   102: aload_0
      //   103: getfield a : Ljava/util/Map;
      //   106: aload #4
      //   108: aconst_null
      //   109: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   114: pop
      //   115: aload_1
      //   116: aload_0
      //   117: invokevirtual a : (Lcom/bytedance/sdk/adnet/core/Request$a;)V
      //   120: getstatic com/bytedance/sdk/adnet/core/p.a : Z
      //   123: ifeq -> 140
      //   126: ldc 'new request, sending to network %s'
      //   128: iconst_1
      //   129: anewarray java/lang/Object
      //   132: dup
      //   133: iconst_0
      //   134: aload #4
      //   136: aastore
      //   137: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   140: aload_0
      //   141: monitorexit
      //   142: iconst_0
      //   143: ireturn
      //   144: astore_1
      //   145: aload_0
      //   146: monitorexit
      //   147: aload_1
      //   148: athrow
      // Exception table:
      //   from	to	target	type
      //   2	37	144	finally
      //   43	51	144	finally
      //   51	98	144	finally
      //   102	140	144	finally
    }
    
    public void a(Request<?> param1Request) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokevirtual getCacheKey : ()Ljava/lang/String;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield a : Ljava/util/Map;
      //   11: aload_1
      //   12: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
      //   17: checkcast java/util/List
      //   20: astore_2
      //   21: aload_2
      //   22: ifnull -> 139
      //   25: aload_2
      //   26: invokeinterface isEmpty : ()Z
      //   31: ifne -> 139
      //   34: getstatic com/bytedance/sdk/adnet/core/p.a : Z
      //   37: ifeq -> 65
      //   40: ldc '%d waiting requests for cacheKey=%s; resend to network'
      //   42: iconst_2
      //   43: anewarray java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: aload_2
      //   49: invokeinterface size : ()I
      //   54: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   57: aastore
      //   58: dup
      //   59: iconst_1
      //   60: aload_1
      //   61: aastore
      //   62: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   65: aload_2
      //   66: iconst_0
      //   67: invokeinterface remove : (I)Ljava/lang/Object;
      //   72: checkcast com/bytedance/sdk/adnet/core/Request
      //   75: astore_3
      //   76: aload_0
      //   77: getfield a : Ljava/util/Map;
      //   80: aload_1
      //   81: aload_2
      //   82: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   87: pop
      //   88: aload_3
      //   89: aload_0
      //   90: invokevirtual a : (Lcom/bytedance/sdk/adnet/core/Request$a;)V
      //   93: aload_0
      //   94: getfield b : Lcom/bytedance/sdk/adnet/core/d;
      //   97: invokestatic a : (Lcom/bytedance/sdk/adnet/core/d;)Ljava/util/concurrent/BlockingQueue;
      //   100: aload_3
      //   101: invokeinterface put : (Ljava/lang/Object;)V
      //   106: goto -> 139
      //   109: astore_1
      //   110: ldc 'Couldn't add request to queue. %s'
      //   112: iconst_1
      //   113: anewarray java/lang/Object
      //   116: dup
      //   117: iconst_0
      //   118: aload_1
      //   119: invokevirtual toString : ()Ljava/lang/String;
      //   122: aastore
      //   123: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   126: invokestatic currentThread : ()Ljava/lang/Thread;
      //   129: invokevirtual interrupt : ()V
      //   132: aload_0
      //   133: getfield b : Lcom/bytedance/sdk/adnet/core/d;
      //   136: invokevirtual a : ()V
      //   139: aload_0
      //   140: monitorexit
      //   141: return
      //   142: astore_1
      //   143: aload_0
      //   144: monitorexit
      //   145: aload_1
      //   146: athrow
      // Exception table:
      //   from	to	target	type
      //   2	21	142	finally
      //   25	65	142	finally
      //   65	93	142	finally
      //   93	106	109	java/lang/InterruptedException
      //   93	106	142	finally
      //   110	139	142	finally
    }
    
    public void a(Request<?> param1Request, n<?> param1n) {
      // Byte code:
      //   0: aload_2
      //   1: getfield b : Lcom/bytedance/sdk/adnet/face/a$a;
      //   4: ifnull -> 127
      //   7: aload_2
      //   8: getfield b : Lcom/bytedance/sdk/adnet/face/a$a;
      //   11: invokevirtual a : ()Z
      //   14: ifeq -> 20
      //   17: goto -> 127
      //   20: aload_1
      //   21: invokevirtual getCacheKey : ()Ljava/lang/String;
      //   24: astore_1
      //   25: aload_0
      //   26: monitorenter
      //   27: aload_0
      //   28: getfield a : Ljava/util/Map;
      //   31: aload_1
      //   32: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
      //   37: checkcast java/util/List
      //   40: astore_3
      //   41: aload_0
      //   42: monitorexit
      //   43: aload_3
      //   44: ifnull -> 121
      //   47: getstatic com/bytedance/sdk/adnet/core/p.a : Z
      //   50: ifeq -> 78
      //   53: ldc 'Releasing %d waiting requests for cacheKey=%s.'
      //   55: iconst_2
      //   56: anewarray java/lang/Object
      //   59: dup
      //   60: iconst_0
      //   61: aload_3
      //   62: invokeinterface size : ()I
      //   67: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   70: aastore
      //   71: dup
      //   72: iconst_1
      //   73: aload_1
      //   74: aastore
      //   75: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   78: aload_3
      //   79: invokeinterface iterator : ()Ljava/util/Iterator;
      //   84: astore_1
      //   85: aload_1
      //   86: invokeinterface hasNext : ()Z
      //   91: ifeq -> 121
      //   94: aload_1
      //   95: invokeinterface next : ()Ljava/lang/Object;
      //   100: checkcast com/bytedance/sdk/adnet/core/Request
      //   103: astore_3
      //   104: aload_0
      //   105: getfield b : Lcom/bytedance/sdk/adnet/core/d;
      //   108: invokestatic b : (Lcom/bytedance/sdk/adnet/core/d;)Lcom/bytedance/sdk/adnet/face/c;
      //   111: aload_3
      //   112: aload_2
      //   113: invokeinterface a : (Lcom/bytedance/sdk/adnet/core/Request;Lcom/bytedance/sdk/adnet/core/n;)V
      //   118: goto -> 85
      //   121: return
      //   122: astore_1
      //   123: aload_0
      //   124: monitorexit
      //   125: aload_1
      //   126: athrow
      //   127: aload_0
      //   128: aload_1
      //   129: invokevirtual a : (Lcom/bytedance/sdk/adnet/core/Request;)V
      //   132: return
      // Exception table:
      //   from	to	target	type
      //   27	43	122	finally
      //   123	125	122	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */