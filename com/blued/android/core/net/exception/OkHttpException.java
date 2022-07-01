package com.blued.android.core.net.exception;

public class OkHttpException extends RuntimeException {
  private Exception a;
  
  public OkHttpException(Exception paramException) {
    this.a = paramException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\exception\OkHttpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */