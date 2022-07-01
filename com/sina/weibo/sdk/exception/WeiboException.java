package com.sina.weibo.sdk.exception;

public class WeiboException extends RuntimeException {
  private static final long serialVersionUID = 475022994858770424L;
  
  public WeiboException() {}
  
  public WeiboException(String paramString) {
    super(paramString);
  }
  
  public WeiboException(String paramString, Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  public WeiboException(Throwable paramThrowable) {
    super(paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\exception\WeiboException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */