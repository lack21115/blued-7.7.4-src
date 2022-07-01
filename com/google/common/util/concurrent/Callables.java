package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

public final class Callables {
  static Runnable a(Runnable paramRunnable, Supplier<String> paramSupplier) {
    Preconditions.a(paramSupplier);
    Preconditions.a(paramRunnable);
    return new Runnable(paramSupplier, paramRunnable) {
        public void run() {
          Thread thread = Thread.currentThread();
          String str = thread.getName();
          boolean bool = Callables.a((String)this.a.get(), thread);
          try {
            this.b.run();
            return;
          } finally {
            if (bool)
              Callables.a(str, thread); 
          } 
        }
      };
  }
  
  static <T> Callable<T> a(Callable<T> paramCallable, Supplier<String> paramSupplier) {
    Preconditions.a(paramSupplier);
    Preconditions.a(paramCallable);
    return new Callable<T>(paramSupplier, paramCallable) {
        public T call() throws Exception {
          Thread thread = Thread.currentThread();
          String str = thread.getName();
          boolean bool = Callables.a((String)this.a.get(), thread);
          try {
            return (T)this.b.call();
          } finally {
            if (bool)
              Callables.a(str, thread); 
          } 
        }
      };
  }
  
  private static boolean b(String paramString, Thread paramThread) {
    try {
      paramThread.setName(paramString);
      return true;
    } catch (SecurityException securityException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\Callables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */