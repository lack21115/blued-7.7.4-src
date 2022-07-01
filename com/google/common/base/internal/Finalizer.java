package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class Finalizer implements Runnable {
  static {
    if (e == null) {
      field = b();
    } else {
      field = null;
    } 
    f = field;
  }
  
  @NullableDecl
  private Method a() {
    Class clazz = this.b.get();
    if (clazz == null)
      return null; 
    try {
      return clazz.getMethod("finalizeReferent", new Class[0]);
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new AssertionError(noSuchMethodException);
    } 
  }
  
  private boolean a(Reference<?> paramReference) {
    Method method = a();
    if (method == null)
      return false; 
    while (true) {
      Reference<?> reference;
      paramReference.clear();
      if (paramReference == this.c)
        return false; 
      try {
        method.invoke(paramReference, new Object[0]);
      } finally {
        paramReference = null;
      } 
      paramReference = reference;
      if (reference == null)
        return true; 
    } 
  }
  
  @NullableDecl
  private static Field b() {
    try {
      return field;
    } finally {
      Exception exception = null;
      a.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
    } 
  }
  
  @NullableDecl
  private static Constructor<Thread> c() {
    try {
      return Thread.class.getConstructor(new Class[] { ThreadGroup.class, Runnable.class, String.class, long.class, boolean.class });
    } finally {
      Exception exception = null;
    } 
  }
  
  public void run() {
    while (true) {
      try {
        boolean bool;
        do {
          bool = a(this.d.remove());
        } while (bool);
        return;
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  static {
    Field field;
  }
  
  private static final Logger a = Logger.getLogger(Finalizer.class.getName());
  
  @NullableDecl
  private static final Constructor<Thread> e = c();
  
  @NullableDecl
  private static final Field f;
  
  private final WeakReference<Class<?>> b;
  
  private final PhantomReference<Object> c;
  
  private final ReferenceQueue<Object> d;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\internal\Finalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */