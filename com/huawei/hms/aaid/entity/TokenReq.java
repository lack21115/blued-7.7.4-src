package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenReq implements IMessageEntity {
  @Packed
  public String aaid;
  
  @Packed
  public String appId;
  
  @Packed
  public boolean firstTime;
  
  @Packed
  public boolean isFastApp = false;
  
  @Packed
  public boolean isMultiSender = false;
  
  @Packed
  public String packageName;
  
  @Packed
  public String projectId;
  
  @Packed
  public String scope;
  
  @Packed
  public String subjectId;
  
  public String getAaid() {
    return this.aaid;
  }
  
  public String getAppId() {
    return this.appId;
  }
  
  public String getPackageName() {
    return this.packageName;
  }
  
  public String getProjectId() {
    return this.projectId;
  }
  
  public String getScope() {
    return this.scope;
  }
  
  public String getSubjectId() {
    return this.subjectId;
  }
  
  public boolean isFastApp() {
    return this.isFastApp;
  }
  
  public boolean isFirstTime() {
    return this.firstTime;
  }
  
  public boolean isMultiSender() {
    return this.isMultiSender;
  }
  
  public void setAaid(String paramString) {
    this.aaid = paramString;
  }
  
  public void setAppId(String paramString) {
    this.appId = paramString;
  }
  
  public void setFastApp(boolean paramBoolean) {
    this.isFastApp = paramBoolean;
  }
  
  public void setFirstTime(boolean paramBoolean) {
    this.firstTime = paramBoolean;
  }
  
  public void setMultiSender(boolean paramBoolean) {
    this.isMultiSender = paramBoolean;
  }
  
  public void setPackageName(String paramString) {
    this.packageName = paramString;
  }
  
  public void setProjectId(String paramString) {
    this.projectId = paramString;
  }
  
  public void setScope(String paramString) {
    this.scope = paramString;
  }
  
  public void setSubjectId(String paramString) {
    this.subjectId = paramString;
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TokenReq.class.getName());
    stringBuffer.append("{");
    stringBuffer.append("pkgName: ");
    stringBuffer.append(this.packageName);
    stringBuffer.append(",isFirstTime: ");
    stringBuffer.append(this.firstTime);
    stringBuffer.append(",scope:");
    stringBuffer.append(this.scope);
    stringBuffer.append(",appId:");
    stringBuffer.append(this.appId);
    stringBuffer.append(",projectId:");
    stringBuffer.append(this.projectId);
    stringBuffer.append(",subjectId:");
    stringBuffer.append(this.subjectId);
    stringBuffer.append("}");
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\entity\TokenReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */