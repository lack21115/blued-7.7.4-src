package com.huawei.hms.api;

public final class HuaweiServicesNotAvailableException extends Exception {
  public final int errorCode;
  
  public HuaweiServicesNotAvailableException(int paramInt) {
    this.errorCode = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\HuaweiServicesNotAvailableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */