package com.bytedance.sdk.a.b.a.g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class d<T> {
  private final Class<?> a;
  
  private final String b;
  
  private final Class[] c;
  
  d(Class<?> paramClass, String paramString, Class... paramVarArgs) {
    this.a = paramClass;
    this.b = paramString;
    this.c = paramVarArgs;
  }
  
  private Method a(Class<?> paramClass) {
    String str = this.b;
    Method method = null;
    if (str != null) {
      method = a(paramClass, str, this.c);
      if (method != null) {
        paramClass = this.a;
        if (paramClass != null && !paramClass.isAssignableFrom(method.getReturnType()))
          return null; 
      } 
    } 
    return method;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class[] paramArrayOfClass) {
    try {
      Method method = paramClass.getMethod(paramString, paramArrayOfClass);
      try {
        int i = method.getModifiers();
        return ((i & 0x1) == 0) ? null : method;
      } catch (NoSuchMethodException noSuchMethodException) {
        return method;
      } 
    } catch (NoSuchMethodException noSuchMethodException) {}
    return null;
  }
  
  public Object a(T paramT, Object... paramVarArgs) throws InvocationTargetException {
    Method method = a(paramT.getClass());
    if (method == null)
      return null; 
    try {
      return method.invoke(paramT, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      return null;
    } 
  }
  
  public boolean a(T paramT) {
    return (a(paramT.getClass()) != null);
  }
  
  public Object b(T paramT, Object... paramVarArgs) {
    try {
      return a(paramT, paramVarArgs);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getTargetException();
      if (throwable instanceof RuntimeException)
        throw (RuntimeException)throwable; 
      AssertionError assertionError = new AssertionError("Unexpected exception");
      assertionError.initCause(throwable);
      throw assertionError;
    } 
  }
  
  public Object c(T paramT, Object... paramVarArgs) throws InvocationTargetException {
    Method method = a(paramT.getClass());
    if (method != null)
      try {
        return method.invoke(paramT, paramVarArgs);
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpectedly could not call: ");
        stringBuilder1.append(method);
        AssertionError assertionError = new AssertionError(stringBuilder1.toString());
        assertionError.initCause(illegalAccessException);
        throw assertionError;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Method ");
    stringBuilder.append(this.b);
    stringBuilder.append(" not supported for object ");
    stringBuilder.append(illegalAccessException);
    throw new AssertionError(stringBuilder.toString());
  }
  
  public Object d(T paramT, Object... paramVarArgs) {
    try {
      return c(paramT, paramVarArgs);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getTargetException();
      if (throwable instanceof RuntimeException)
        throw (RuntimeException)throwable; 
      AssertionError assertionError = new AssertionError("Unexpected exception");
      assertionError.initCause(throwable);
      throw assertionError;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */