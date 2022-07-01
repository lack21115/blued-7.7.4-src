package com.taobao.tao.remotebusiness.auth;

public class AuthParam {
  public String bizId;
  
  public String failInfo;
  
  public String sid;
  
  public AuthParam(String paramString1, String paramString2, String paramString3) {
    this.sid = paramString1;
    this.bizId = paramString2;
    this.failInfo = paramString3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\auth\AuthParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */