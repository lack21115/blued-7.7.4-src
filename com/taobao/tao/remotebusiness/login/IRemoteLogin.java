package com.taobao.tao.remotebusiness.login;

public interface IRemoteLogin {
  LoginContext getLoginContext();
  
  boolean isLogining();
  
  boolean isSessionValid();
  
  void login(onLoginListener paramonLoginListener, boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\login\IRemoteLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */