package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;

public class TokenResult extends Result {
  @Packed
  public String belongId;
  
  @Packed
  public int retCode = 0;
  
  @Packed
  public String token = "";
  
  public String getBelongId() {
    return this.belongId;
  }
  
  public int getRetCode() {
    return this.retCode;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public void setBelongId(String paramString) {
    this.belongId = paramString;
  }
  
  public void setRetCode(int paramInt) {
    this.retCode = paramInt;
  }
  
  public void setToken(String paramString) {
    this.token = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\entity\TokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */