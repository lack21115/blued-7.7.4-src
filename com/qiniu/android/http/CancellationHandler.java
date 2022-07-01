package com.qiniu.android.http;

import java.io.IOException;

public interface CancellationHandler {
  boolean isCancelled();
  
  public static class CancellationException extends IOException {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\CancellationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */