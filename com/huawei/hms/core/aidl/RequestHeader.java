package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

public class RequestHeader implements IMessageEntity {
  @Packed
  private int apiLevel;
  
  @Packed
  private List<String> apiNameList;
  
  @Packed
  private String appId;
  
  @Packed
  private String packageName;
  
  @Packed
  private int sdkVersion;
  
  @Packed
  private String sessionId;
  
  public RequestHeader() {}
  
  public RequestHeader(String paramString1, String paramString2, int paramInt, String paramString3) {
    this.appId = paramString1;
    this.packageName = paramString2;
    this.sdkVersion = paramInt;
    this.sessionId = paramString3;
  }
  
  public List<String> getApiNameList() {
    return this.apiNameList;
  }
  
  public String getAppID() {
    return this.appId;
  }
  
  public String getPackageName() {
    return this.packageName;
  }
  
  public int getSdkVersion() {
    return this.sdkVersion;
  }
  
  public String getSessionId() {
    return this.sessionId;
  }
  
  public void setApiLevel(int paramInt) {
    this.apiLevel = paramInt;
  }
  
  public void setApiNameList(List<String> paramList) {
    this.apiNameList = paramList;
  }
  
  public void setAppID(String paramString) {
    this.appId = paramString;
  }
  
  public void setPackageName(String paramString) {
    this.packageName = paramString;
  }
  
  public void setSdkVersion(int paramInt) {
    this.sdkVersion = paramInt;
  }
  
  public void setSessionId(String paramString) {
    this.sessionId = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\core\aidl\RequestHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */