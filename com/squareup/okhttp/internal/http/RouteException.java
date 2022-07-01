package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException extends Exception {
  private static final Method addSuppressedExceptionMethod;
  
  private IOException lastException;
  
  static {
    try {
      Method method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
    } catch (Exception exception) {
      exception = null;
    } 
    addSuppressedExceptionMethod = (Method)exception;
  }
  
  public RouteException(IOException paramIOException) {
    super(paramIOException);
    this.lastException = paramIOException;
  }
  
  private void addSuppressedIfPossible(IOException paramIOException1, IOException paramIOException2) {
    Method method = addSuppressedExceptionMethod;
    if (method != null)
      try {
        method.invoke(paramIOException1, new Object[] { paramIOException2 });
        return;
      } catch (InvocationTargetException|IllegalAccessException invocationTargetException) {
        return;
      }  
  }
  
  public void addConnectException(IOException paramIOException) {
    addSuppressedIfPossible(paramIOException, this.lastException);
    this.lastException = paramIOException;
  }
  
  public IOException getLastConnectException() {
    return this.lastException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\RouteException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */