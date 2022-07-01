package com.huawei.hms.support.api.client;

public class SubAppInfo {
  private String subAppID;
  
  public SubAppInfo(SubAppInfo paramSubAppInfo) {
    if (paramSubAppInfo != null)
      this.subAppID = paramSubAppInfo.getSubAppID(); 
  }
  
  public SubAppInfo(String paramString) {
    this.subAppID = paramString;
  }
  
  public String getSubAppID() {
    return this.subAppID;
  }
  
  public void setSubAppID(String paramString) {
    this.subAppID = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\SubAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */