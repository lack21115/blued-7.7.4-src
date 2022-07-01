package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public abstract class AbstractResp implements IMessageEntity {
  @Packed
  private String errorReason;
  
  @Packed
  private int rtnCode = 0;
  
  public String getErrorReason() {
    return this.errorReason;
  }
  
  public int getRtnCode() {
    return this.rtnCode;
  }
  
  public void setErrorReason(String paramString) {
    this.errorReason = paramString;
  }
  
  public void setRtnCode(int paramInt) {
    this.rtnCode = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\AbstractResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */