package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {
  private final int a;
  
  public HttpException(int paramInt) {
    this(stringBuilder.toString(), paramInt);
  }
  
  public HttpException(String paramString) {
    this(paramString, -1);
  }
  
  public HttpException(String paramString, int paramInt) {
    this(paramString, paramInt, null);
  }
  
  public HttpException(String paramString, int paramInt, Throwable paramThrowable) {
    super(paramString, paramThrowable);
    this.a = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\HttpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */