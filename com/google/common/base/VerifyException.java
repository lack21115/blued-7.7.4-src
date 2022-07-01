package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class VerifyException extends RuntimeException {
  public VerifyException() {}
  
  public VerifyException(@NullableDecl String paramString) {
    super(paramString);
  }
  
  public VerifyException(@NullableDecl String paramString, @NullableDecl Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\VerifyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */