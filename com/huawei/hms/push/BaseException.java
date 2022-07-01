package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

public class BaseException extends Exception {
  public final int a;
  
  public final ErrorEnum b;
  
  public BaseException(int paramInt) {
    this.b = ErrorEnum.fromCode(paramInt);
    this.a = this.b.getExternalCode();
  }
  
  public int getErrorCode() {
    return this.a;
  }
  
  public String getMessage() {
    return this.b.getMessage();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\BaseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */