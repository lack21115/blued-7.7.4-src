package com.huawei.hms.common;

import com.huawei.hms.support.api.client.Status;

public class ApiException extends Exception {
  protected final Status mStatus;
  
  public ApiException(Status paramStatus) {
    super(stringBuilder.toString());
    String str;
    this.mStatus = paramStatus;
  }
  
  public int getStatusCode() {
    return this.mStatus.getStatusCode();
  }
  
  @Deprecated
  public String getStatusMessage() {
    return this.mStatus.getStatusMessage();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\ApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */