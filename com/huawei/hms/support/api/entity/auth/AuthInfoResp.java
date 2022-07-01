package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.annotation.Packed;

public class AuthInfoResp extends AbstractResp {
  @Packed
  private AuthorizationInfo authInfo;
  
  public AuthorizationInfo getAuthInfo() {
    return this.authInfo;
  }
  
  public int getRtnCode() {
    return super.getRtnCode();
  }
  
  public void setAuthInfo(AuthorizationInfo paramAuthorizationInfo) {
    this.authInfo = paramAuthorizationInfo;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\AuthInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */