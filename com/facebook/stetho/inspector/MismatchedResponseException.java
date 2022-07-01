package com.facebook.stetho.inspector;

public class MismatchedResponseException extends MessageHandlingException {
  public long mRequestId;
  
  public MismatchedResponseException(long paramLong) {
    super(stringBuilder.toString());
    this.mRequestId = paramLong;
  }
  
  public long getRequestId() {
    return this.mRequestId;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\MismatchedResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */