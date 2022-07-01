package com.google.common.base;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class FinalizableReferenceQueue implements Closeable {
  private static final Logger d = Logger.getLogger(FinalizableReferenceQueue.class.getName());
  
  private static final Method e = a(a(new FinalizerLoader[] { new SystemLoader(), new DecoupledLoader(), new DirectLoader() }));
  
  final ReferenceQueue<Object> a;
  
  final PhantomReference<Object> b;
  
  final boolean c;
  
  private static Class<?> a(FinalizerLoader... paramVarArgs) {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      Class<?> clazz = paramVarArgs[i].a();
      if (clazz != null)
        return clazz; 
    } 
    throw new AssertionError();
  }
  
  static Method a(Class<?> paramClass) {
    try {
      return paramClass.getMethod("startFinalizer", new Class[] { Class.class, ReferenceQueue.class, PhantomReference.class });
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new AssertionError(noSuchMethodException);
    } 
  }
  
  void a() {
    if (this.c)
      return; 
    while (true) {
      Reference<?> reference = this.a.poll();
      if (reference != null) {
        reference.clear();
        try {
          ((FinalizableReference)reference).a();
        } finally {
          reference = null;
        } 
      } 
      break;
    } 
  }
  
  public void close() {
    this.b.enqueue();
    a();
  }
  
  static class DecoupledLoader implements FinalizerLoader {
    @NullableDecl
    public Class<?> a() {
      try {
        return a(b()).loadClass("com.google.common.base.internal.Finalizer");
      } catch (Exception exception) {
        FinalizableReferenceQueue.b().log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", exception);
        return null;
      } 
    }
    
    URLClassLoader a(URL param1URL) {
      return new URLClassLoader(new URL[] { param1URL }, null);
    }
    
    URL b() throws IOException {
      StringBuilder stringBuilder2;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("com.google.common.base.internal.Finalizer".replace('.', '/'));
      stringBuilder1.append(".class");
      String str = stringBuilder1.toString();
      URL uRL = getClass().getClassLoader().getResource(str);
      if (uRL != null) {
        String str1 = uRL.toString();
        if (str1.endsWith(str))
          return new URL(uRL, str1.substring(0, str1.length() - str.length())); 
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unsupported path style: ");
        stringBuilder2.append(str1);
        throw new IOException(stringBuilder2.toString());
      } 
      throw new FileNotFoundException(stringBuilder2);
    }
  }
  
  static class DirectLoader implements FinalizerLoader {
    public Class<?> a() {
      try {
        return Class.forName("com.google.common.base.internal.Finalizer");
      } catch (ClassNotFoundException classNotFoundException) {
        throw new AssertionError(classNotFoundException);
      } 
    }
  }
  
  static interface FinalizerLoader {
    @NullableDecl
    Class<?> a();
  }
  
  static class SystemLoader implements FinalizerLoader {
    static boolean a;
    
    @NullableDecl
    public Class<?> a() {
      if (a)
        return null; 
      try {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        if (classLoader != null)
          try {
            return classLoader.loadClass("com.google.common.base.internal.Finalizer");
          } catch (ClassNotFoundException classNotFoundException) {
            return null;
          }  
        return null;
      } catch (SecurityException securityException) {
        FinalizableReferenceQueue.b().info("Not allowed to access system class loader.");
        return null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\FinalizableReferenceQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */