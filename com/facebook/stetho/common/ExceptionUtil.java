package com.facebook.stetho.common;

public class ExceptionUtil {
  public static RuntimeException propagate(Throwable paramThrowable) {
    propagateIfInstanceOf(paramThrowable, Error.class);
    propagateIfInstanceOf(paramThrowable, RuntimeException.class);
    throw new RuntimeException(paramThrowable);
  }
  
  public static <T extends Throwable> void propagateIfInstanceOf(Throwable paramThrowable, Class<T> paramClass) throws T {
    if (!paramClass.isInstance(paramThrowable))
      return; 
    throw (T)paramThrowable;
  }
  
  public static <T extends Throwable> void sneakyThrow(Throwable paramThrowable) throws T {
    throw (T)paramThrowable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\ExceptionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */