package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
  private static final EngineResourceFactory e = new EngineResourceFactory();
  
  final ResourceCallbacksAndExecutors a = new ResourceCallbacksAndExecutors();
  
  DataSource b;
  
  GlideException c;
  
  EngineResource<?> d;
  
  private final StateVerifier f = StateVerifier.a();
  
  private final EngineResource.ResourceListener g;
  
  private final Pools.Pool<EngineJob<?>> h;
  
  private final EngineResourceFactory i;
  
  private final EngineJobListener j;
  
  private final GlideExecutor k;
  
  private final GlideExecutor l;
  
  private final GlideExecutor m;
  
  private final GlideExecutor n;
  
  private final AtomicInteger o = new AtomicInteger();
  
  private Key p;
  
  private boolean q;
  
  private boolean r;
  
  private boolean s;
  
  private boolean t;
  
  private Resource<?> u;
  
  private boolean v;
  
  private boolean w;
  
  private DecodeJob<R> x;
  
  private volatile boolean y;
  
  EngineJob(GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, EngineJobListener paramEngineJobListener, EngineResource.ResourceListener paramResourceListener, Pools.Pool<EngineJob<?>> paramPool) {
    this(paramGlideExecutor1, paramGlideExecutor2, paramGlideExecutor3, paramGlideExecutor4, paramEngineJobListener, paramResourceListener, paramPool, e);
  }
  
  EngineJob(GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, EngineJobListener paramEngineJobListener, EngineResource.ResourceListener paramResourceListener, Pools.Pool<EngineJob<?>> paramPool, EngineResourceFactory paramEngineResourceFactory) {
    this.k = paramGlideExecutor1;
    this.l = paramGlideExecutor2;
    this.m = paramGlideExecutor3;
    this.n = paramGlideExecutor4;
    this.j = paramEngineJobListener;
    this.g = paramResourceListener;
    this.h = paramPool;
    this.i = paramEngineResourceFactory;
  }
  
  private GlideExecutor g() {
    return this.r ? this.m : (this.s ? this.n : this.l);
  }
  
  private boolean h() {
    return (this.w || this.v || this.y);
  }
  
  private void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield p : Lcom/bumptech/glide/load/Key;
    //   6: ifnull -> 83
    //   9: aload_0
    //   10: getfield a : Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   13: invokevirtual c : ()V
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield p : Lcom/bumptech/glide/load/Key;
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield d : Lcom/bumptech/glide/load/engine/EngineResource;
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield u : Lcom/bumptech/glide/load/engine/Resource;
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield w : Z
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield y : Z
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield v : Z
    //   46: aload_0
    //   47: getfield x : Lcom/bumptech/glide/load/engine/DecodeJob;
    //   50: iconst_0
    //   51: invokevirtual a : (Z)V
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield x : Lcom/bumptech/glide/load/engine/DecodeJob;
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield c : Lcom/bumptech/glide/load/engine/GlideException;
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield b : Lcom/bumptech/glide/load/DataSource;
    //   69: aload_0
    //   70: getfield h : Landroidx/core/util/Pools$Pool;
    //   73: aload_0
    //   74: invokeinterface release : (Ljava/lang/Object;)Z
    //   79: pop
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: new java/lang/IllegalArgumentException
    //   86: dup
    //   87: invokespecial <init> : ()V
    //   90: athrow
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	80	91	finally
    //   83	91	91	finally
  }
  
  EngineJob<R> a(Key paramKey, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield p : Lcom/bumptech/glide/load/Key;
    //   7: aload_0
    //   8: iload_2
    //   9: putfield q : Z
    //   12: aload_0
    //   13: iload_3
    //   14: putfield r : Z
    //   17: aload_0
    //   18: iload #4
    //   20: putfield s : Z
    //   23: aload_0
    //   24: iload #5
    //   26: putfield t : Z
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	33	finally
  }
  
  void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial h : ()Z
    //   6: ldc 'Not yet complete!'
    //   8: invokestatic a : (ZLjava/lang/String;)V
    //   11: aload_0
    //   12: getfield o : Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: iload_1
    //   16: invokevirtual getAndAdd : (I)I
    //   19: ifne -> 36
    //   22: aload_0
    //   23: getfield d : Lcom/bumptech/glide/load/engine/EngineResource;
    //   26: ifnull -> 36
    //   29: aload_0
    //   30: getfield d : Lcom/bumptech/glide/load/engine/EngineResource;
    //   33: invokevirtual g : ()V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   2	36	39	finally
  }
  
  public void a(DecodeJob<?> paramDecodeJob) {
    g().execute(paramDecodeJob);
  }
  
  public void a(GlideException paramGlideException) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield c : Lcom/bumptech/glide/load/engine/GlideException;
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: invokevirtual f : ()V
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	14	finally
    //   15	17	14	finally
  }
  
  public void a(Resource<R> paramResource, DataSource paramDataSource) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield u : Lcom/bumptech/glide/load/engine/Resource;
    //   7: aload_0
    //   8: aload_2
    //   9: putfield b : Lcom/bumptech/glide/load/DataSource;
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: invokevirtual c : ()V
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	19	finally
    //   20	22	19	finally
  }
  
  void a(ResourceCallback paramResourceCallback) {
    try {
      return;
    } finally {
      paramResourceCallback = null;
    } 
  }
  
  void a(ResourceCallback paramResourceCallback, Executor paramExecutor) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Lcom/bumptech/glide/util/pool/StateVerifier;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: getfield a : Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual a : (Lcom/bumptech/glide/request/ResourceCallback;Ljava/util/concurrent/Executor;)V
    //   18: aload_0
    //   19: getfield v : Z
    //   22: istore #4
    //   24: iconst_1
    //   25: istore_3
    //   26: iload #4
    //   28: ifeq -> 54
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual a : (I)V
    //   36: aload_2
    //   37: new com/bumptech/glide/load/engine/EngineJob$CallResourceReady
    //   40: dup
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial <init> : (Lcom/bumptech/glide/load/engine/EngineJob;Lcom/bumptech/glide/request/ResourceCallback;)V
    //   46: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   51: goto -> 100
    //   54: aload_0
    //   55: getfield w : Z
    //   58: ifeq -> 84
    //   61: aload_0
    //   62: iconst_1
    //   63: invokevirtual a : (I)V
    //   66: aload_2
    //   67: new com/bumptech/glide/load/engine/EngineJob$CallLoadFailed
    //   70: dup
    //   71: aload_0
    //   72: aload_1
    //   73: invokespecial <init> : (Lcom/bumptech/glide/load/engine/EngineJob;Lcom/bumptech/glide/request/ResourceCallback;)V
    //   76: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   81: goto -> 100
    //   84: aload_0
    //   85: getfield y : Z
    //   88: ifne -> 108
    //   91: goto -> 94
    //   94: iload_3
    //   95: ldc 'Cannot add callbacks to a cancelled EngineJob'
    //   97: invokestatic a : (ZLjava/lang/String;)V
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: iconst_0
    //   109: istore_3
    //   110: goto -> 94
    // Exception table:
    //   from	to	target	type
    //   2	24	103	finally
    //   31	51	103	finally
    //   54	81	103	finally
    //   84	91	103	finally
    //   94	100	103	finally
  }
  
  boolean a() {
    return this.t;
  }
  
  void b() {
    if (h())
      return; 
    this.y = true;
    this.x.b();
    this.j.a(this, this.p);
  }
  
  public void b(DecodeJob<R> paramDecodeJob) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield x : Lcom/bumptech/glide/load/engine/DecodeJob;
    //   7: aload_1
    //   8: invokevirtual a : ()Z
    //   11: ifeq -> 22
    //   14: aload_0
    //   15: getfield k : Lcom/bumptech/glide/load/engine/executor/GlideExecutor;
    //   18: astore_2
    //   19: goto -> 27
    //   22: aload_0
    //   23: invokespecial g : ()Lcom/bumptech/glide/load/engine/executor/GlideExecutor;
    //   26: astore_2
    //   27: aload_2
    //   28: aload_1
    //   29: invokevirtual execute : (Ljava/lang/Runnable;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	35	finally
    //   22	27	35	finally
    //   27	32	35	finally
  }
  
  void b(ResourceCallback paramResourceCallback) {
    try {
      return;
    } finally {
      paramResourceCallback = null;
    } 
  }
  
  void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Lcom/bumptech/glide/util/pool/StateVerifier;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: getfield y : Z
    //   13: ifeq -> 32
    //   16: aload_0
    //   17: getfield u : Lcom/bumptech/glide/load/engine/Resource;
    //   20: invokeinterface c : ()V
    //   25: aload_0
    //   26: invokespecial i : ()V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield a : Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   36: invokevirtual a : ()Z
    //   39: ifne -> 187
    //   42: aload_0
    //   43: getfield v : Z
    //   46: ifne -> 176
    //   49: aload_0
    //   50: aload_0
    //   51: getfield i : Lcom/bumptech/glide/load/engine/EngineJob$EngineResourceFactory;
    //   54: aload_0
    //   55: getfield u : Lcom/bumptech/glide/load/engine/Resource;
    //   58: aload_0
    //   59: getfield q : Z
    //   62: aload_0
    //   63: getfield p : Lcom/bumptech/glide/load/Key;
    //   66: aload_0
    //   67: getfield g : Lcom/bumptech/glide/load/engine/EngineResource$ResourceListener;
    //   70: invokevirtual a : (Lcom/bumptech/glide/load/engine/Resource;ZLcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/engine/EngineResource$ResourceListener;)Lcom/bumptech/glide/load/engine/EngineResource;
    //   73: putfield d : Lcom/bumptech/glide/load/engine/EngineResource;
    //   76: aload_0
    //   77: iconst_1
    //   78: putfield v : Z
    //   81: aload_0
    //   82: getfield a : Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   85: invokevirtual d : ()Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   88: astore_1
    //   89: aload_0
    //   90: aload_1
    //   91: invokevirtual b : ()I
    //   94: iconst_1
    //   95: iadd
    //   96: invokevirtual a : (I)V
    //   99: aload_0
    //   100: getfield p : Lcom/bumptech/glide/load/Key;
    //   103: astore_2
    //   104: aload_0
    //   105: getfield d : Lcom/bumptech/glide/load/engine/EngineResource;
    //   108: astore_3
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_0
    //   112: getfield j : Lcom/bumptech/glide/load/engine/EngineJobListener;
    //   115: aload_0
    //   116: aload_2
    //   117: aload_3
    //   118: invokeinterface a : (Lcom/bumptech/glide/load/engine/EngineJob;Lcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/engine/EngineResource;)V
    //   123: aload_1
    //   124: invokevirtual iterator : ()Ljava/util/Iterator;
    //   127: astore_1
    //   128: aload_1
    //   129: invokeinterface hasNext : ()Z
    //   134: ifeq -> 171
    //   137: aload_1
    //   138: invokeinterface next : ()Ljava/lang/Object;
    //   143: checkcast com/bumptech/glide/load/engine/EngineJob$ResourceCallbackAndExecutor
    //   146: astore_2
    //   147: aload_2
    //   148: getfield b : Ljava/util/concurrent/Executor;
    //   151: new com/bumptech/glide/load/engine/EngineJob$CallResourceReady
    //   154: dup
    //   155: aload_0
    //   156: aload_2
    //   157: getfield a : Lcom/bumptech/glide/request/ResourceCallback;
    //   160: invokespecial <init> : (Lcom/bumptech/glide/load/engine/EngineJob;Lcom/bumptech/glide/request/ResourceCallback;)V
    //   163: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   168: goto -> 128
    //   171: aload_0
    //   172: invokevirtual e : ()V
    //   175: return
    //   176: new java/lang/IllegalStateException
    //   179: dup
    //   180: ldc_w 'Already have resource'
    //   183: invokespecial <init> : (Ljava/lang/String;)V
    //   186: athrow
    //   187: new java/lang/IllegalStateException
    //   190: dup
    //   191: ldc_w 'Received a resource without any callbacks to notify'
    //   194: invokespecial <init> : (Ljava/lang/String;)V
    //   197: athrow
    //   198: astore_1
    //   199: aload_0
    //   200: monitorexit
    //   201: aload_1
    //   202: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	198	finally
    //   32	111	198	finally
    //   176	187	198	finally
    //   187	198	198	finally
    //   199	201	198	finally
  }
  
  void c(ResourceCallback paramResourceCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Lcom/bumptech/glide/util/pool/StateVerifier;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: getfield a : Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   13: aload_1
    //   14: invokevirtual a : (Lcom/bumptech/glide/request/ResourceCallback;)V
    //   17: aload_0
    //   18: getfield a : Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   21: invokevirtual a : ()Z
    //   24: ifeq -> 66
    //   27: aload_0
    //   28: invokevirtual b : ()V
    //   31: aload_0
    //   32: getfield v : Z
    //   35: ifne -> 79
    //   38: aload_0
    //   39: getfield w : Z
    //   42: ifeq -> 74
    //   45: goto -> 79
    //   48: iload_2
    //   49: ifeq -> 66
    //   52: aload_0
    //   53: getfield o : Ljava/util/concurrent/atomic/AtomicInteger;
    //   56: invokevirtual get : ()I
    //   59: ifne -> 66
    //   62: aload_0
    //   63: invokespecial i : ()V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -> 48
    //   79: iconst_1
    //   80: istore_2
    //   81: goto -> 48
    // Exception table:
    //   from	to	target	type
    //   2	45	69	finally
    //   52	66	69	finally
  }
  
  public StateVerifier d() {
    return this.f;
  }
  
  void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Lcom/bumptech/glide/util/pool/StateVerifier;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: invokespecial h : ()Z
    //   13: ldc 'Not yet complete!'
    //   15: invokestatic a : (ZLjava/lang/String;)V
    //   18: aload_0
    //   19: getfield o : Ljava/util/concurrent/atomic/AtomicInteger;
    //   22: invokevirtual decrementAndGet : ()I
    //   25: istore_1
    //   26: iload_1
    //   27: iflt -> 74
    //   30: iconst_1
    //   31: istore_2
    //   32: goto -> 35
    //   35: iload_2
    //   36: ldc_w 'Can't decrement below 0'
    //   39: invokestatic a : (ZLjava/lang/String;)V
    //   42: iload_1
    //   43: ifne -> 79
    //   46: aload_0
    //   47: getfield d : Lcom/bumptech/glide/load/engine/EngineResource;
    //   50: astore_3
    //   51: aload_0
    //   52: invokespecial i : ()V
    //   55: goto -> 58
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_3
    //   61: ifnull -> 68
    //   64: aload_3
    //   65: invokevirtual h : ()V
    //   68: return
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -> 35
    //   79: aconst_null
    //   80: astore_3
    //   81: goto -> 58
    // Exception table:
    //   from	to	target	type
    //   2	26	69	finally
    //   35	42	69	finally
    //   46	55	69	finally
    //   58	60	69	finally
    //   70	72	69	finally
  }
  
  void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Lcom/bumptech/glide/util/pool/StateVerifier;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: getfield y : Z
    //   13: ifeq -> 23
    //   16: aload_0
    //   17: invokespecial i : ()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield a : Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   27: invokevirtual a : ()Z
    //   30: ifne -> 146
    //   33: aload_0
    //   34: getfield w : Z
    //   37: ifne -> 135
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield w : Z
    //   45: aload_0
    //   46: getfield p : Lcom/bumptech/glide/load/Key;
    //   49: astore_1
    //   50: aload_0
    //   51: getfield a : Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   54: invokevirtual d : ()Lcom/bumptech/glide/load/engine/EngineJob$ResourceCallbacksAndExecutors;
    //   57: astore_2
    //   58: aload_0
    //   59: aload_2
    //   60: invokevirtual b : ()I
    //   63: iconst_1
    //   64: iadd
    //   65: invokevirtual a : (I)V
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield j : Lcom/bumptech/glide/load/engine/EngineJobListener;
    //   74: aload_0
    //   75: aload_1
    //   76: aconst_null
    //   77: invokeinterface a : (Lcom/bumptech/glide/load/engine/EngineJob;Lcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/engine/EngineResource;)V
    //   82: aload_2
    //   83: invokevirtual iterator : ()Ljava/util/Iterator;
    //   86: astore_1
    //   87: aload_1
    //   88: invokeinterface hasNext : ()Z
    //   93: ifeq -> 130
    //   96: aload_1
    //   97: invokeinterface next : ()Ljava/lang/Object;
    //   102: checkcast com/bumptech/glide/load/engine/EngineJob$ResourceCallbackAndExecutor
    //   105: astore_2
    //   106: aload_2
    //   107: getfield b : Ljava/util/concurrent/Executor;
    //   110: new com/bumptech/glide/load/engine/EngineJob$CallLoadFailed
    //   113: dup
    //   114: aload_0
    //   115: aload_2
    //   116: getfield a : Lcom/bumptech/glide/request/ResourceCallback;
    //   119: invokespecial <init> : (Lcom/bumptech/glide/load/engine/EngineJob;Lcom/bumptech/glide/request/ResourceCallback;)V
    //   122: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   127: goto -> 87
    //   130: aload_0
    //   131: invokevirtual e : ()V
    //   134: return
    //   135: new java/lang/IllegalStateException
    //   138: dup
    //   139: ldc_w 'Already failed once'
    //   142: invokespecial <init> : (Ljava/lang/String;)V
    //   145: athrow
    //   146: new java/lang/IllegalStateException
    //   149: dup
    //   150: ldc_w 'Received an exception without any callbacks to notify'
    //   153: invokespecial <init> : (Ljava/lang/String;)V
    //   156: athrow
    //   157: astore_1
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	157	finally
    //   23	70	157	finally
    //   135	146	157	finally
    //   146	157	157	finally
    //   158	160	157	finally
  }
  
  class CallLoadFailed implements Runnable {
    private final ResourceCallback b;
    
    CallLoadFailed(EngineJob this$0, ResourceCallback param1ResourceCallback) {
      this.b = param1ResourceCallback;
    }
    
    public void run() {
      synchronized (this.b.h()) {
        synchronized (this.a) {
          if (this.a.a.b(this.b))
            this.a.b(this.b); 
          this.a.e();
          return;
        } 
      } 
    }
  }
  
  class CallResourceReady implements Runnable {
    private final ResourceCallback b;
    
    CallResourceReady(EngineJob this$0, ResourceCallback param1ResourceCallback) {
      this.b = param1ResourceCallback;
    }
    
    public void run() {
      synchronized (this.b.h()) {
        synchronized (this.a) {
          if (this.a.a.b(this.b)) {
            this.a.d.g();
            this.a.a(this.b);
            this.a.c(this.b);
          } 
          this.a.e();
          return;
        } 
      } 
    }
  }
  
  static class EngineResourceFactory {
    public <R> EngineResource<R> a(Resource<R> param1Resource, boolean param1Boolean, Key param1Key, EngineResource.ResourceListener param1ResourceListener) {
      return new EngineResource<R>(param1Resource, param1Boolean, true, param1Key, param1ResourceListener);
    }
  }
  
  static final class ResourceCallbackAndExecutor {
    final ResourceCallback a;
    
    final Executor b;
    
    ResourceCallbackAndExecutor(ResourceCallback param1ResourceCallback, Executor param1Executor) {
      this.a = param1ResourceCallback;
      this.b = param1Executor;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof ResourceCallbackAndExecutor) {
        param1Object = param1Object;
        return this.a.equals(((ResourceCallbackAndExecutor)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
  }
  
  static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
    private final List<EngineJob.ResourceCallbackAndExecutor> a;
    
    ResourceCallbacksAndExecutors() {
      this(new ArrayList<EngineJob.ResourceCallbackAndExecutor>(2));
    }
    
    ResourceCallbacksAndExecutors(List<EngineJob.ResourceCallbackAndExecutor> param1List) {
      this.a = param1List;
    }
    
    private static EngineJob.ResourceCallbackAndExecutor c(ResourceCallback param1ResourceCallback) {
      return new EngineJob.ResourceCallbackAndExecutor(param1ResourceCallback, Executors.b());
    }
    
    void a(ResourceCallback param1ResourceCallback) {
      this.a.remove(c(param1ResourceCallback));
    }
    
    void a(ResourceCallback param1ResourceCallback, Executor param1Executor) {
      this.a.add(new EngineJob.ResourceCallbackAndExecutor(param1ResourceCallback, param1Executor));
    }
    
    boolean a() {
      return this.a.isEmpty();
    }
    
    int b() {
      return this.a.size();
    }
    
    boolean b(ResourceCallback param1ResourceCallback) {
      return this.a.contains(c(param1ResourceCallback));
    }
    
    void c() {
      this.a.clear();
    }
    
    ResourceCallbacksAndExecutors d() {
      return new ResourceCallbacksAndExecutors(new ArrayList<EngineJob.ResourceCallbackAndExecutor>(this.a));
    }
    
    public Iterator<EngineJob.ResourceCallbackAndExecutor> iterator() {
      return this.a.iterator();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\EngineJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */