package com.google.common.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Throwables {
  @NullableDecl
  private static final Object a = d();
  
  @NullableDecl
  private static final Method b;
  
  @NullableDecl
  private static final Method c;
  
  static {
    Object object = a;
    Object object1 = null;
    if (object == null) {
      object = null;
    } else {
      object = e();
    } 
    b = (Method)object;
    if (a == null) {
      object = object1;
    } else {
      object = f();
    } 
    c = (Method)object;
  }
  
  @NullableDecl
  private static Method a(String paramString, Class<?>... paramVarArgs) throws ThreadDeath {
    try {
      return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(paramString, paramVarArgs);
    } catch (ThreadDeath threadDeath) {
      throw threadDeath;
    } finally {
      paramString = null;
    } 
  }
  
  public static void a(Throwable paramThrowable) {
    Preconditions.a(paramThrowable);
    if (!(paramThrowable instanceof RuntimeException)) {
      if (!(paramThrowable instanceof Error))
        return; 
      throw (Error)paramThrowable;
    } 
    throw (RuntimeException)paramThrowable;
  }
  
  public static <X extends Throwable> void a(Throwable paramThrowable, Class<X> paramClass) throws X {
    Preconditions.a(paramThrowable);
    if (!paramClass.isInstance(paramThrowable))
      return; 
    throw (X)paramClass.cast(paramThrowable);
  }
  
  private static Object b(Method paramMethod, Object paramObject, Object... paramVarArgs) {
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw c(invocationTargetException.getCause());
    } 
  }
  
  @Deprecated
  public static void b(@NullableDecl Throwable paramThrowable) {
    if (paramThrowable != null)
      a(paramThrowable); 
  }
  
  @Deprecated
  public static <X extends Throwable> void b(@NullableDecl Throwable paramThrowable, Class<X> paramClass) throws X {
    if (paramThrowable != null)
      a(paramThrowable, paramClass); 
  }
  
  @Deprecated
  public static RuntimeException c(Throwable paramThrowable) {
    a(paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public static <X extends Throwable> void c(@NullableDecl Throwable paramThrowable, Class<X> paramClass) throws X {
    b(paramThrowable, paramClass);
    b(paramThrowable);
  }
  
  @NullableDecl
  private static Object d() {
    try {
      return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
    } catch (ThreadDeath threadDeath) {
      throw threadDeath;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String d(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString();
  }
  
  @NullableDecl
  private static Method e() {
    return a("getStackTraceElement", new Class[] { Throwable.class, int.class });
  }
  
  @NullableDecl
  private static Method f() {
    try {
      Method method = a("getStackTraceDepth", new Class[] { Throwable.class });
      if (method == null)
        return null; 
      method.invoke(d(), new Object[] { new Throwable() });
      return method;
    } catch (UnsupportedOperationException|IllegalAccessException|InvocationTargetException unsupportedOperationException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Throwables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */