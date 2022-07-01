package com.taobao.tao.remotebusiness.auth;

public interface AuthListener {
  void onAuthCancel(String paramString1, String paramString2);
  
  void onAuthFail(String paramString1, String paramString2);
  
  void onAuthSuccess();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\auth\AuthListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */