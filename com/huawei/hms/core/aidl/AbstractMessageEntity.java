package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Status;

public class AbstractMessageEntity implements IMessageEntity {
  @Packed
  private Status commonStatus;
  
  public Status getCommonStatus() {
    return this.commonStatus;
  }
  
  public void setCommonStatus(Status paramStatus) {
    this.commonStatus = paramStatus;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\core\aidl\AbstractMessageEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */