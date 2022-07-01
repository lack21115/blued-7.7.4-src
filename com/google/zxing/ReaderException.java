package com.google.zxing;

public abstract class ReaderException extends Exception {
  protected static final boolean a;
  
  protected static final StackTraceElement[] b = new StackTraceElement[0];
  
  ReaderException() {}
  
  ReaderException(Throwable paramThrowable) {
    super(paramThrowable);
  }
  
  public final Throwable fillInStackTrace() {
    /* monitor enter ThisExpression{ObjectType{com/google/zxing/ReaderException}} */
    /* monitor exit ThisExpression{ObjectType{com/google/zxing/ReaderException}} */
    return null;
  }
  
  static {
    boolean bool;
    if (System.getProperty("surefire.test.class.path") != null) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\ReaderException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */