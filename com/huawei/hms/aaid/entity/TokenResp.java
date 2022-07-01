package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenResp implements IMessageEntity {
  @Packed
  public String belongId;
  
  @Packed
  public int retCode = 0;
  
  @Packed
  public String subjectId;
  
  @Packed
  public String token = "";
  
  public String getBelongId() {
    return this.belongId;
  }
  
  public int getRetCode() {
    return this.retCode;
  }
  
  public String getSubjectId() {
    return this.subjectId;
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
  
  public void setSubjectId(String paramString) {
    this.subjectId = paramString;
  }
  
  public void setToken(String paramString) {
    this.token = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\entity\TokenResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */