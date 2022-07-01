package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.b.c;
import com.bytedance.sdk.a.b.a.b.d;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.g.e;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class j {
  private static final Executor d = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), c.a("OkHttp ConnectionPool", true));
  
  final d a = new d();
  
  boolean b;
  
  private final int e;
  
  private final long f;
  
  private final Runnable g = new Runnable(this) {
      public void run() {
        while (true) {
          long l = this.a.a(System.nanoTime());
          if (l == -1L)
            return; 
          if (l > 0L) {
            long l1 = l / 1000000L;
            synchronized (this.a) {
              this.a.wait(l1, (int)(l - 1000000L * l1));
            } 
            /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_5} */
          } 
        } 
      }
    };
  
  private final Deque<c> h = new ArrayDeque<c>();
  
  public j() {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public j(int paramInt, long paramLong, TimeUnit paramTimeUnit) {
    this.e = paramInt;
    this.f = paramTimeUnit.toNanos(paramLong);
    if (paramLong > 0L)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("keepAliveDuration <= 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private int a(c paramc, long paramLong) {
    List<Reference> list = paramc.d;
    int i = 0;
    while (i < list.size()) {
      Reference reference = list.get(i);
      if (reference.get() != null) {
        i++;
        continue;
      } 
      g.a a = (g.a)reference;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("A connection to ");
      stringBuilder.append(paramc.a().a().a());
      stringBuilder.append(" was leaked. Did you forget to close a response body?");
      String str = stringBuilder.toString();
      e.b().a(str, a.a);
      list.remove(i);
      paramc.a = true;
      if (list.isEmpty()) {
        paramc.e = paramLong - this.f;
        return 0;
      } 
    } 
    return list.size();
  }
  
  long a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Ljava/util/Deque;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore #12
    //   13: ldc2_w -9223372036854775808
    //   16: lstore #6
    //   18: aconst_null
    //   19: astore #10
    //   21: iconst_0
    //   22: istore_3
    //   23: iconst_0
    //   24: istore #4
    //   26: aload #12
    //   28: invokeinterface hasNext : ()Z
    //   33: ifeq -> 106
    //   36: aload #12
    //   38: invokeinterface next : ()Ljava/lang/Object;
    //   43: checkcast com/bytedance/sdk/a/b/a/b/c
    //   46: astore #11
    //   48: aload_0
    //   49: aload #11
    //   51: lload_1
    //   52: invokespecial a : (Lcom/bytedance/sdk/a/b/a/b/c;J)I
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
    //   75: getfield e : J
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
    //   109: getfield f : J
    //   112: lcmp
    //   113: ifge -> 168
    //   116: iload_3
    //   117: aload_0
    //   118: getfield e : I
    //   121: if_icmple -> 127
    //   124: goto -> 168
    //   127: iload_3
    //   128: ifle -> 143
    //   131: aload_0
    //   132: getfield f : J
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
    //   149: getfield f : J
    //   152: lstore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: lload_1
    //   156: lreturn
    //   157: aload_0
    //   158: iconst_0
    //   159: putfield b : Z
    //   162: aload_0
    //   163: monitorexit
    //   164: ldc2_w -1
    //   167: lreturn
    //   168: aload_0
    //   169: getfield h : Ljava/util/Deque;
    //   172: aload #10
    //   174: invokeinterface remove : (Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload_0
    //   181: monitorexit
    //   182: aload #10
    //   184: invokevirtual b : ()Ljava/net/Socket;
    //   187: invokestatic a : (Ljava/net/Socket;)V
    //   190: lconst_0
    //   191: lreturn
    //   192: astore #10
    //   194: aload_0
    //   195: monitorexit
    //   196: aload #10
    //   198: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	192	finally
    //   26	58	192	finally
    //   72	81	192	finally
    //   106	124	192	finally
    //   131	138	192	finally
    //   148	155	192	finally
    //   157	164	192	finally
    //   168	182	192	finally
    //   194	196	192	finally
  }
  
  c a(a parama, g paramg, ac paramac) {
    if (c || Thread.holdsLock(this)) {
      for (c c : this.h) {
        if (c.a(parama, paramac)) {
          paramg.a(c, true);
          return c;
        } 
      } 
      return null;
    } 
    throw new AssertionError();
  }
  
  Socket a(a parama, g paramg) {
    if (c || Thread.holdsLock(this)) {
      for (c c : this.h) {
        if (c.a(parama, null) && c.d() && c != paramg.b())
          return paramg.a(c); 
      } 
      return null;
    } 
    throw new AssertionError();
  }
  
  void a(c paramc) {
    if (c || Thread.holdsLock(this)) {
      if (!this.b) {
        this.b = true;
        d.execute(this.g);
      } 
      this.h.add(paramc);
      return;
    } 
    throw new AssertionError();
  }
  
  boolean b(c paramc) {
    if (c || Thread.holdsLock(this)) {
      if (paramc.a || this.e == 0) {
        this.h.remove(paramc);
        return true;
      } 
      notifyAll();
      return false;
    } 
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */