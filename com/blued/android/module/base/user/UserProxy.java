package com.blued.android.module.base.user;

public class UserProxy implements IUser {
  private static UserProxy a = new UserProxy();
  
  private IUser b;
  
  public static UserProxy b() {
    return a;
  }
  
  public String a() {
    IUser iUser = this.b;
    return (iUser != null) ? iUser.a() : null;
  }
  
  public void a(IUser paramIUser) {
    this.b = paramIUser;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\bas\\user\UserProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */