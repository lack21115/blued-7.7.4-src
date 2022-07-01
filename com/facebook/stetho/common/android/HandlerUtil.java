package com.facebook.stetho.common.android;

import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

public final class HandlerUtil {
  public static boolean checkThreadAccess(Handler paramHandler) {
    return (Looper.myLooper() == paramHandler.getLooper());
  }
  
  public static <V> V postAndWait(Handler paramHandler, final UncheckedCallable<V> c) {
    if (checkThreadAccess(paramHandler))
      try {
        return (V)c.call();
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      }  
    return (new WaitableRunnable<V>() {
        protected V onRun() {
          return (V)c.call();
        }
      }).invoke((Handler)exception);
  }
  
  public static void postAndWait(Handler paramHandler, final Runnable r) {
    if (checkThreadAccess(paramHandler))
      try {
        r.run();
        return;
      } catch (RuntimeException runtimeException) {
        throw new RuntimeException(runtimeException);
      }  
    (new WaitableRunnable<Void>() {
        protected Void onRun() {
          r.run();
          return null;
        }
      }).invoke((Handler)runtimeException);
  }
  
  public static void verifyThreadAccess(Handler paramHandler) {
    Util.throwIfNot(checkThreadAccess(paramHandler));
  }
  
  static abstract class WaitableRunnable<V> implements Runnable {
    private Exception mException;
    
    private boolean mIsDone;
    
    private V mValue;
    
    private void join() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield mIsDone : Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifne -> 18
      //   11: aload_0
      //   12: invokevirtual wait : ()V
      //   15: goto -> 2
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: athrow
      //   26: astore_2
      //   27: goto -> 2
      // Exception table:
      //   from	to	target	type
      //   2	7	21	finally
      //   11	15	26	java/lang/InterruptedException
      //   11	15	21	finally
      //   18	20	21	finally
      //   22	24	21	finally
    }
    
    public V invoke(Handler param1Handler) {
      if (param1Handler.post(this)) {
        join();
        Exception exception = this.mException;
        if (exception == null)
          return this.mValue; 
        throw new RuntimeException(exception);
      } 
      throw new RuntimeException("Handler.post() returned false");
    }
    
    protected abstract V onRun();
    
    public final void run() {
      // Byte code:
      //   0: aload_0
      //   1: aload_0
      //   2: invokevirtual onRun : ()Ljava/lang/Object;
      //   5: putfield mValue : Ljava/lang/Object;
      //   8: aload_0
      //   9: aconst_null
      //   10: putfield mException : Ljava/lang/Exception;
      //   13: aload_0
      //   14: monitorenter
      //   15: aload_0
      //   16: iconst_1
      //   17: putfield mIsDone : Z
      //   20: aload_0
      //   21: invokevirtual notifyAll : ()V
      //   24: aload_0
      //   25: monitorexit
      //   26: return
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      //   32: astore_1
      //   33: goto -> 66
      //   36: astore_1
      //   37: aload_0
      //   38: aconst_null
      //   39: putfield mValue : Ljava/lang/Object;
      //   42: aload_0
      //   43: aload_1
      //   44: putfield mException : Ljava/lang/Exception;
      //   47: aload_0
      //   48: monitorenter
      //   49: aload_0
      //   50: iconst_1
      //   51: putfield mIsDone : Z
      //   54: aload_0
      //   55: invokevirtual notifyAll : ()V
      //   58: aload_0
      //   59: monitorexit
      //   60: return
      //   61: astore_1
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_1
      //   65: athrow
      //   66: aload_0
      //   67: monitorenter
      //   68: aload_0
      //   69: iconst_1
      //   70: putfield mIsDone : Z
      //   73: aload_0
      //   74: invokevirtual notifyAll : ()V
      //   77: aload_0
      //   78: monitorexit
      //   79: aload_1
      //   80: athrow
      //   81: astore_1
      //   82: aload_0
      //   83: monitorexit
      //   84: aload_1
      //   85: athrow
      // Exception table:
      //   from	to	target	type
      //   0	13	36	java/lang/Exception
      //   0	13	32	finally
      //   15	26	27	finally
      //   28	30	27	finally
      //   37	47	32	finally
      //   49	60	61	finally
      //   62	64	61	finally
      //   68	79	81	finally
      //   82	84	81	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\HandlerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */