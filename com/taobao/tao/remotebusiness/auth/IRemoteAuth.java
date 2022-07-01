package com.taobao.tao.remotebusiness.auth;

public interface IRemoteAuth {
  void authorize(String paramString1, String paramString2, String paramString3, boolean paramBoolean, AuthListener paramAuthListener);
  
  String getAuthToken();
  
  boolean isAuthInfoValid();
  
  boolean isAuthorizing();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\auth\IRemoteAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */