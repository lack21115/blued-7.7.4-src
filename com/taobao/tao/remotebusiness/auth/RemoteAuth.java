package com.taobao.tao.remotebusiness.auth;

import mtopsdk.common.util.TBSdkLog;

public class RemoteAuth {
  private static final String TAG = "mtop.rb-RemoteAuth";
  
  private static IRemoteAuth iRemoteAuth;
  
  public static void authorize(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    IRemoteAuth iRemoteAuth = iRemoteAuth;
    if (iRemoteAuth != null) {
      if (iRemoteAuth.isAuthorizing())
        return; 
      if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
        StringBuilder stringBuilder = new StringBuilder("call auth. bizId=");
        stringBuilder.append(paramString1);
        stringBuilder.append(" apiInfo=");
        stringBuilder.append(paramString2);
        stringBuilder.append(" failInfo=");
        stringBuilder.append(paramString3);
        TBSdkLog.b("mtop.rb-RemoteAuth", stringBuilder.toString());
      } 
      iRemoteAuth.authorize(paramString1, paramString2, paramString3, paramBoolean, RemoteAuth$AuthHandler.instance());
    } 
  }
  
  public static String getAuthToken() {
    IRemoteAuth iRemoteAuth = iRemoteAuth;
    return (iRemoteAuth == null) ? null : iRemoteAuth.getAuthToken();
  }
  
  public static boolean isAuthInfoValid() {
    IRemoteAuth iRemoteAuth = iRemoteAuth;
    return (iRemoteAuth == null) ? true : (iRemoteAuth.isAuthorizing() ? false : iRemoteAuth.isAuthInfoValid());
  }
  
  public static void setAuthImpl(IRemoteAuth paramIRemoteAuth) {
    String str;
    StringBuilder stringBuilder = new StringBuilder("set auth implement. remoteAuth=");
    stringBuilder.append(paramIRemoteAuth);
    if (stringBuilder.toString() != null) {
      str = paramIRemoteAuth.toString();
    } else {
      str = "null";
    } 
    TBSdkLog.a("mtop.rb-RemoteAuth", str);
    iRemoteAuth = paramIRemoteAuth;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\auth\RemoteAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */