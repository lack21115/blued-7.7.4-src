package com.taobao.tao.remotebusiness.auth;

import com.taobao.tao.remotebusiness.a;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.xstate.a;

class RemoteAuth$AuthHandler implements AuthListener {
  private RemoteAuth$AuthHandler() {}
  
  public static RemoteAuth$AuthHandler instance() {
    return RemoteAuth$AuthHandler$Holder.instance;
  }
  
  public void onAuthCancel(String paramString1, String paramString2) {
    TBSdkLog.b("mtop.rb-RemoteAuth", "auth cancel");
    a.a(paramString1, paramString2);
  }
  
  public void onAuthFail(String paramString1, String paramString2) {
    TBSdkLog.b("mtop.rb-RemoteAuth", "auth fail");
    a.a(paramString1, paramString2);
  }
  
  public void onAuthSuccess() {
    TBSdkLog.b("mtop.rb-RemoteAuth", "auth success");
    a.a("accessToken", RemoteAuth.getAuthToken());
    a.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\auth\RemoteAuth$AuthHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */