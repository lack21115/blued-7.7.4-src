package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class JosBaseResp implements IMessageEntity {
  @Packed
  private int statusCode;
  
  public int getStatusCode() {
    return this.statusCode;
  }
  
  public void setStatusCode(int paramInt) {
    this.statusCode = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\core\JosBaseResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */