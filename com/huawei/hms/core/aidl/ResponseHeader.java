package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;

public class ResponseHeader implements IMessageEntity {
  @Packed
  protected int statusCode;
  
  public ResponseHeader() {}
  
  public ResponseHeader(int paramInt) {
    this.statusCode = paramInt;
  }
  
  public int getStatusCode() {
    return this.statusCode;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\core\aidl\ResponseHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */