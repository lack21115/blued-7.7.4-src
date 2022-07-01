package com.bytedance.sdk.a.b.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e extends RuntimeException {
  private static final Method a;
  
  private IOException b;
  
  static {
    try {
      Method method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
    } catch (Exception exception) {
      exception = null;
    } 
    a = (Method)exception;
  }
  
  public e(IOException paramIOException) {
    super(paramIOException);
    this.b = paramIOException;
  }
  
  private void a(IOException paramIOException1, IOException paramIOException2) {
    Method method = a;
    if (method != null)
      try {
        method.invoke(paramIOException1, new Object[] { paramIOException2 });
        return;
      } catch (InvocationTargetException|IllegalAccessException invocationTargetException) {
        return;
      }  
  }
  
  public IOException a() {
    return this.b;
  }
  
  public void a(IOException paramIOException) {
    a(paramIOException, this.b);
    this.b = paramIOException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */