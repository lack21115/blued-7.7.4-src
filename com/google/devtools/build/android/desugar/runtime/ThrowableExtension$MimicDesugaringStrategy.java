package com.google.devtools.build.android.desugar.runtime;

final class ThrowableExtension$MimicDesugaringStrategy extends ThrowableExtension$AbstractDesugaringStrategy {
  private final ThrowableExtension$ConcurrentWeakIdentityHashMap map = new ThrowableExtension$ConcurrentWeakIdentityHashMap();
  
  public final void addSuppressed(Throwable paramThrowable1, Throwable paramThrowable2) {
    if (paramThrowable2 != paramThrowable1) {
      if (paramThrowable2 != null) {
        this.map.get(paramThrowable1, true).add(paramThrowable2);
        return;
      } 
      throw new NullPointerException("The suppressed exception cannot be null.");
    } 
    throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
  }
  
  public final void printStackTrace(Throwable paramThrowable) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual printStackTrace : ()V
    //   4: aload_0
    //   5: getfield map : Lcom/google/devtools/build/android/desugar/runtime/ThrowableExtension$ConcurrentWeakIdentityHashMap;
    //   8: aload_1
    //   9: iconst_0
    //   10: invokevirtual get : (Ljava/lang/Throwable;Z)Ljava/util/List;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull -> 19
    //   18: return
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_1
    //   22: invokeinterface iterator : ()Ljava/util/Iterator;
    //   27: astore_2
    //   28: aload_2
    //   29: invokeinterface hasNext : ()Z
    //   34: ifeq -> 62
    //   37: aload_2
    //   38: invokeinterface next : ()Ljava/lang/Object;
    //   43: checkcast java/lang/Throwable
    //   46: astore_3
    //   47: getstatic java/lang/System.err : Ljava/io/PrintStream;
    //   50: ldc 'Suppressed: '
    //   52: invokevirtual print : (Ljava/lang/String;)V
    //   55: aload_3
    //   56: invokevirtual printStackTrace : ()V
    //   59: goto -> 28
    //   62: aload_1
    //   63: monitorexit
    //   64: return
    //   65: astore_2
    //   66: aload_1
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   21	28	65	finally
    //   28	59	65	finally
    //   62	64	65	finally
    //   66	68	65	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\devtools\build\android\desugar\runtime\ThrowableExtension$MimicDesugaringStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */