package com.bumptech.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {
  private final Map<String, WriteLock> a = new HashMap<String, WriteLock>();
  
  private final WriteLockPool b = new WriteLockPool();
  
  void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: aload_3
    //   19: ifnonnull -> 42
    //   22: aload_0
    //   23: getfield b : Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool;
    //   26: invokevirtual a : ()Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock;
    //   29: astore_2
    //   30: aload_0
    //   31: getfield a : Ljava/util/Map;
    //   34: aload_1
    //   35: aload_2
    //   36: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_2
    //   43: aload_2
    //   44: getfield b : I
    //   47: iconst_1
    //   48: iadd
    //   49: putfield b : I
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: getfield a : Ljava/util/concurrent/locks/Lock;
    //   58: invokeinterface lock : ()V
    //   63: return
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	64	finally
    //   22	42	64	finally
    //   42	54	64	finally
    //   65	67	64	finally
  }
  
  void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: invokestatic a : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock
    //   18: astore_2
    //   19: aload_2
    //   20: getfield b : I
    //   23: iconst_1
    //   24: if_icmplt -> 156
    //   27: aload_2
    //   28: aload_2
    //   29: getfield b : I
    //   32: iconst_1
    //   33: isub
    //   34: putfield b : I
    //   37: aload_2
    //   38: getfield b : I
    //   41: ifne -> 144
    //   44: aload_0
    //   45: getfield a : Ljava/util/Map;
    //   48: aload_1
    //   49: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock
    //   57: astore_3
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual equals : (Ljava/lang/Object;)Z
    //   63: ifeq -> 77
    //   66: aload_0
    //   67: getfield b : Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool;
    //   70: aload_3
    //   71: invokevirtual a : (Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock;)V
    //   74: goto -> 144
    //   77: new java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial <init> : ()V
    //   84: astore #4
    //   86: aload #4
    //   88: ldc 'Removed the wrong lock, expected to remove: '
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload #4
    //   96: aload_2
    //   97: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload #4
    //   103: ldc ', but actually removed: '
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload #4
    //   111: aload_3
    //   112: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload #4
    //   118: ldc ', safeKey: '
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload #4
    //   126: aload_1
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: new java/lang/IllegalStateException
    //   134: dup
    //   135: aload #4
    //   137: invokevirtual toString : ()Ljava/lang/String;
    //   140: invokespecial <init> : (Ljava/lang/String;)V
    //   143: athrow
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_2
    //   147: getfield a : Ljava/util/concurrent/locks/Lock;
    //   150: invokeinterface unlock : ()V
    //   155: return
    //   156: new java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: astore_3
    //   164: aload_3
    //   165: ldc 'Cannot release a lock that is not held, safeKey: '
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_3
    //   172: aload_1
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_3
    //   178: ldc ', interestedThreads: '
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_3
    //   185: aload_2
    //   186: getfield b : I
    //   189: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: new java/lang/IllegalStateException
    //   196: dup
    //   197: aload_3
    //   198: invokevirtual toString : ()Ljava/lang/String;
    //   201: invokespecial <init> : (Ljava/lang/String;)V
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    // Exception table:
    //   from	to	target	type
    //   2	74	205	finally
    //   77	144	205	finally
    //   144	146	205	finally
    //   156	205	205	finally
    //   206	208	205	finally
  }
  
  static class WriteLock {
    final Lock a = new ReentrantLock();
    
    int b;
  }
  
  static class WriteLockPool {
    private final Queue<DiskCacheWriteLocker.WriteLock> a = new ArrayDeque<DiskCacheWriteLocker.WriteLock>();
    
    DiskCacheWriteLocker.WriteLock a() {
      Queue<DiskCacheWriteLocker.WriteLock> queue;
      DiskCacheWriteLocker.WriteLock writeLock;
      synchronized (this.a) {
        DiskCacheWriteLocker.WriteLock writeLock1 = this.a.poll();
        writeLock = writeLock1;
        if (writeLock1 == null)
          writeLock = new DiskCacheWriteLocker.WriteLock(); 
        return writeLock;
      } 
    }
    
    void a(DiskCacheWriteLocker.WriteLock param1WriteLock) {
      synchronized (this.a) {
        if (this.a.size() < 10)
          this.a.offer(param1WriteLock); 
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\DiskCacheWriteLocker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */