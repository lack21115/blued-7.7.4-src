package com.taobao.tao.remotebusiness.login;

import mtopsdk.common.util.TBSdkLog;

public class RemoteLogin {
  public static final String TAG = "mtop.rb-Login";
  
  private static IRemoteLogin login;
  
  public static IRemoteLogin getLogin() {
    if (login == null) {
      DefaultLoginImpl defaultLoginImpl = DefaultLoginImpl.getDefaultLoginImpl();
      login = defaultLoginImpl;
      if (defaultLoginImpl == null) {
        TBSdkLog.d("mtop.rb-Login", "login is null");
        throw new LoginNotImplementException("Login Not Implement!");
      } 
    } 
    return login;
  }
  
  public static LoginContext getLoginContext() {
    return getLogin().getLoginContext();
  }
  
  public static boolean isSessionValid() {
    IRemoteLogin iRemoteLogin = getLogin();
    return iRemoteLogin.isLogining() ? false : iRemoteLogin.isSessionValid();
  }
  
  public static void login(boolean paramBoolean) {
    login(paramBoolean, null);
  }
  
  public static void login(boolean paramBoolean, Object paramObject) {
    IRemoteLogin iRemoteLogin = getLogin();
    if (iRemoteLogin.isLogining())
      return; 
    TBSdkLog.b("mtop.rb-Login", "call login");
    if (paramObject != null && iRemoteLogin instanceof DefaultLoginImpl)
      ((DefaultLoginImpl)iRemoteLogin).setSessionInvalid(paramObject); 
    iRemoteLogin.login(LoginHandler.instance(), paramBoolean);
    LoginHandler.instance().sendEmptyMessageDelayed(911104, 20000L);
  }
  
  public static void setLoginImpl(IRemoteLogin paramIRemoteLogin) {
    login = paramIRemoteLogin;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\login\RemoteLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */