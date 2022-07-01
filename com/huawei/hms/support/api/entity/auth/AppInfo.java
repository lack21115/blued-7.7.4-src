package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class AppInfo implements IMessageEntity {
  @Packed
  private String appID;
  
  @Packed
  private String packageName;
  
  public AppInfo() {}
  
  public AppInfo(String paramString1, String paramString2) {
    this.appID = paramString1;
    this.packageName = paramString2;
  }
  
  public String getAppID() {
    return this.appID;
  }
  
  public String getPackageName() {
    return this.packageName;
  }
  
  public void setAppID(String paramString) {
    this.appID = paramString;
  }
  
  public void setPackageName(String paramString) {
    this.packageName = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */