package com.google.android.gms.common.api;

public class ApiException extends Exception {
  @Deprecated
  protected final Status mStatus;
  
  public ApiException(Status paramStatus) {
    super(stringBuilder.toString());
    String str;
    this.mStatus = paramStatus;
  }
  
  public Status getStatus() {
    return this.mStatus;
  }
  
  public int getStatusCode() {
    return this.mStatus.getStatusCode();
  }
  
  @Deprecated
  public String getStatusMessage() {
    return this.mStatus.getStatusMessage();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\ApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */