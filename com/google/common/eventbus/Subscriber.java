package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class Subscriber {
  final Object a;
  
  private EventBus b;
  
  private final Method c;
  
  private SubscriberExceptionContext b(Object paramObject) {
    return new SubscriberExceptionContext(this.b, paramObject, this.a, this.c);
  }
  
  void a(Object paramObject) throws InvocationTargetException {
    try {
      this.c.invoke(this.a, new Object[] { Preconditions.a(paramObject) });
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Method rejected target/argument: ");
      stringBuilder.append(paramObject);
      throw new Error(stringBuilder.toString(), illegalArgumentException);
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Method became inaccessible: ");
      stringBuilder.append(paramObject);
      throw new Error(stringBuilder.toString(), illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      if (invocationTargetException.getCause() instanceof Error)
        throw (Error)invocationTargetException.getCause(); 
      throw invocationTargetException;
    } 
  }
  
  public final boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Subscriber;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.a == ((Subscriber)paramObject).a) {
        bool1 = bool2;
        if (this.c.equals(((Subscriber)paramObject).c))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public final int hashCode() {
    return (this.c.hashCode() + 31) * 31 + System.identityHashCode(this.a);
  }
  
  static final class SynchronizedSubscriber extends Subscriber {
    void a(Object param1Object) throws InvocationTargetException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_1
      //   4: invokespecial a : (Ljava/lang/Object;)V
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_1
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_1
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	10	finally
      //   11	13	10	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\eventbus\Subscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */