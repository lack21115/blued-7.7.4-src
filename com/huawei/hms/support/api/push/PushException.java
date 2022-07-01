package com.huawei.hms.support.api.push;

public class PushException extends RuntimeException {
  public static final String EXCEPTION_SEND_FAILED = "send message failed";
  
  public static final long serialVersionUID = -5781932794540482177L;
  
  public PushException() {}
  
  public PushException(String paramString) {
    super(paramString);
  }
  
  public PushException(String paramString, Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  public PushException(Throwable paramThrowable) {
    super(paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\PushException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */