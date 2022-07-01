package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class DeleteTokenResp implements IMessageEntity {
  @Packed
  public int retCode = 0;
  
  public int getRetCode() {
    return this.retCode;
  }
  
  public void setRetCode(int paramInt) {
    this.retCode = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\entity\DeleteTokenResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */