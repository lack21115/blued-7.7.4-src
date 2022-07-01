package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.n;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class l {
  private static volatile n a;
  
  private static volatile n b;
  
  public static n a(boolean paramBoolean) {
    // Byte code:
    //   0: iload_0
    //   1: ifeq -> 70
    //   4: getstatic com/ss/android/socialbase/downloader/impls/l.b : Lcom/ss/android/socialbase/downloader/downloader/n;
    //   7: ifnonnull -> 66
    //   10: ldc com/ss/android/socialbase/downloader/impls/l
    //   12: monitorenter
    //   13: getstatic com/ss/android/socialbase/downloader/impls/l.b : Lcom/ss/android/socialbase/downloader/downloader/n;
    //   16: ifnonnull -> 54
    //   19: ldc com/ss/android/socialbase/downloader/impls/l
    //   21: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   24: astore_1
    //   25: new com/ss/android/socialbase/downloader/impls/l$a
    //   28: dup
    //   29: iconst_1
    //   30: invokespecial <init> : (Z)V
    //   33: astore_2
    //   34: aload_1
    //   35: iconst_1
    //   36: anewarray java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc com/ss/android/socialbase/downloader/downloader/n
    //   43: aastore
    //   44: aload_2
    //   45: invokestatic newProxyInstance : (Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   48: checkcast com/ss/android/socialbase/downloader/downloader/n
    //   51: putstatic com/ss/android/socialbase/downloader/impls/l.b : Lcom/ss/android/socialbase/downloader/downloader/n;
    //   54: ldc com/ss/android/socialbase/downloader/impls/l
    //   56: monitorexit
    //   57: goto -> 66
    //   60: astore_1
    //   61: ldc com/ss/android/socialbase/downloader/impls/l
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: getstatic com/ss/android/socialbase/downloader/impls/l.b : Lcom/ss/android/socialbase/downloader/downloader/n;
    //   69: areturn
    //   70: getstatic com/ss/android/socialbase/downloader/impls/l.a : Lcom/ss/android/socialbase/downloader/downloader/n;
    //   73: ifnonnull -> 132
    //   76: ldc com/ss/android/socialbase/downloader/impls/l
    //   78: monitorenter
    //   79: getstatic com/ss/android/socialbase/downloader/impls/l.a : Lcom/ss/android/socialbase/downloader/downloader/n;
    //   82: ifnonnull -> 120
    //   85: ldc com/ss/android/socialbase/downloader/impls/l
    //   87: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   90: astore_1
    //   91: new com/ss/android/socialbase/downloader/impls/l$a
    //   94: dup
    //   95: iconst_0
    //   96: invokespecial <init> : (Z)V
    //   99: astore_2
    //   100: aload_1
    //   101: iconst_1
    //   102: anewarray java/lang/Class
    //   105: dup
    //   106: iconst_0
    //   107: ldc com/ss/android/socialbase/downloader/downloader/n
    //   109: aastore
    //   110: aload_2
    //   111: invokestatic newProxyInstance : (Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   114: checkcast com/ss/android/socialbase/downloader/downloader/n
    //   117: putstatic com/ss/android/socialbase/downloader/impls/l.a : Lcom/ss/android/socialbase/downloader/downloader/n;
    //   120: ldc com/ss/android/socialbase/downloader/impls/l
    //   122: monitorexit
    //   123: goto -> 132
    //   126: astore_1
    //   127: ldc com/ss/android/socialbase/downloader/impls/l
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: getstatic com/ss/android/socialbase/downloader/impls/l.a : Lcom/ss/android/socialbase/downloader/downloader/n;
    //   135: areturn
    // Exception table:
    //   from	to	target	type
    //   13	54	60	finally
    //   54	57	60	finally
    //   61	64	60	finally
    //   79	120	126	finally
    //   120	123	126	finally
    //   127	130	126	finally
  }
  
  static class a implements InvocationHandler {
    private volatile n a;
    
    public a(boolean param1Boolean) {
      if (!param1Boolean) {
        this.a = new p();
        return;
      } 
      this.a = new o();
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      try {
        return (this.a != null) ? param1Method.invoke(this.a, param1ArrayOfObject) : null;
      } catch (InvocationTargetException invocationTargetException) {
        if (invocationTargetException.getCause() != null)
          invocationTargetException.getCause().printStackTrace(); 
        throw invocationTargetException.getCause();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */