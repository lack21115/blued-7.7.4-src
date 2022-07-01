package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.IMessageEntity;

public abstract class Result implements IMessageEntity {
  private Status status = Status.FAILURE;
  
  public Status getStatus() {
    return this.status;
  }
  
  public void setStatus(Status paramStatus) {
    if (paramStatus == null)
      return; 
    this.status = paramStatus;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */