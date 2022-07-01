package org.chromium.mojo.bindings;

public final class ExceptionHandler$DefaultExceptionHandler implements ExceptionHandler {
  private ExceptionHandler mDelegate;
  
  private ExceptionHandler$DefaultExceptionHandler() {}
  
  public final boolean handleException(RuntimeException paramRuntimeException) {
    if (this.mDelegate != null)
      return this.mDelegate.handleException(paramRuntimeException); 
    throw paramRuntimeException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\ExceptionHandler$DefaultExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */