package com.bumptech.glide.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {
  private final Map<T, Y> a = new LinkedHashMap<T, Y>(100, 0.75F, true);
  
  private final long b;
  
  private long c;
  
  private long d;
  
  public LruCache(long paramLong) {
    this.b = paramLong;
    this.c = paramLong;
  }
  
  private void d() {
    a(this.c);
  }
  
  public int a(Y paramY) {
    return 1;
  }
  
  public long a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : J
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
  
  protected void a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : J
    //   6: lload_1
    //   7: lcmp
    //   8: ifle -> 88
    //   11: aload_0
    //   12: getfield a : Ljava/util/Map;
    //   15: invokeinterface entrySet : ()Ljava/util/Set;
    //   20: invokeinterface iterator : ()Ljava/util/Iterator;
    //   25: astore_3
    //   26: aload_3
    //   27: invokeinterface next : ()Ljava/lang/Object;
    //   32: checkcast java/util/Map$Entry
    //   35: astore #5
    //   37: aload #5
    //   39: invokeinterface getValue : ()Ljava/lang/Object;
    //   44: astore #4
    //   46: aload_0
    //   47: aload_0
    //   48: getfield d : J
    //   51: aload_0
    //   52: aload #4
    //   54: invokevirtual a : (Ljava/lang/Object;)I
    //   57: i2l
    //   58: lsub
    //   59: putfield d : J
    //   62: aload #5
    //   64: invokeinterface getKey : ()Ljava/lang/Object;
    //   69: astore #5
    //   71: aload_3
    //   72: invokeinterface remove : ()V
    //   77: aload_0
    //   78: aload #5
    //   80: aload #4
    //   82: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   85: goto -> 2
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: astore_3
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_3
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	85	91	finally
  }
  
  protected void a(T paramT, Y paramY) {}
  
  public long b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : J
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
  
  public Y b(T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	17	finally
  }
  
  public Y b(T paramT, Y paramY) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual a : (Ljava/lang/Object;)I
    //   7: i2l
    //   8: lstore_3
    //   9: lload_3
    //   10: aload_0
    //   11: getfield c : J
    //   14: lcmp
    //   15: iflt -> 28
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: aconst_null
    //   27: areturn
    //   28: aload_2
    //   29: ifnull -> 42
    //   32: aload_0
    //   33: aload_0
    //   34: getfield d : J
    //   37: lload_3
    //   38: ladd
    //   39: putfield d : J
    //   42: aload_0
    //   43: getfield a : Ljava/util/Map;
    //   46: aload_1
    //   47: aload_2
    //   48: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore #5
    //   55: aload #5
    //   57: ifnull -> 92
    //   60: aload_0
    //   61: aload_0
    //   62: getfield d : J
    //   65: aload_0
    //   66: aload #5
    //   68: invokevirtual a : (Ljava/lang/Object;)I
    //   71: i2l
    //   72: lsub
    //   73: putfield d : J
    //   76: aload #5
    //   78: aload_2
    //   79: invokevirtual equals : (Ljava/lang/Object;)Z
    //   82: ifne -> 92
    //   85: aload_0
    //   86: aload_1
    //   87: aload #5
    //   89: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   92: aload_0
    //   93: invokespecial d : ()V
    //   96: aload_0
    //   97: monitorexit
    //   98: aload #5
    //   100: areturn
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	101	finally
    //   32	42	101	finally
    //   42	55	101	finally
    //   60	92	101	finally
    //   92	96	101	finally
  }
  
  public Y c(T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull -> 32
    //   17: aload_0
    //   18: aload_0
    //   19: getfield d : J
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual a : (Ljava/lang/Object;)I
    //   27: i2l
    //   28: lsub
    //   29: putfield d : J
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	36	finally
    //   17	32	36	finally
  }
  
  public void c() {
    a(0L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\LruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */