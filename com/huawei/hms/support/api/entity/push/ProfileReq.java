package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class ProfileReq implements IMessageEntity {
  @Packed
  public int operation;
  
  @Packed
  public String pkgName;
  
  @Packed
  public String profileId;
  
  @Packed
  public String subjectId;
  
  @Packed
  public int type;
  
  public int getOperation() {
    return this.operation;
  }
  
  public String getPkgName() {
    return this.pkgName;
  }
  
  public String getProfileId() {
    return this.profileId;
  }
  
  public String getSubjectId() {
    return this.subjectId;
  }
  
  public int getType() {
    return this.type;
  }
  
  public void setOperation(int paramInt) {
    this.operation = paramInt;
  }
  
  public void setPkgName(String paramString) {
    this.pkgName = paramString;
  }
  
  public void setProfileId(String paramString) {
    this.profileId = paramString;
  }
  
  public void setSubjectId(String paramString) {
    this.subjectId = paramString;
  }
  
  public void setType(int paramInt) {
    this.type = paramInt;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(ProfileReq.class.getName());
    stringBuilder.append("{ pkgName: ");
    stringBuilder.append(this.pkgName);
    stringBuilder.append(",subjectId: ");
    stringBuilder.append(this.subjectId);
    stringBuilder.append(",operation: ");
    stringBuilder.append(this.operation);
    stringBuilder.append(" type: ");
    stringBuilder.append(this.type);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\push\ProfileReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */