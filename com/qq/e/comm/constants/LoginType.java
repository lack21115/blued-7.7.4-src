package com.qq.e.comm.constants;

public enum LoginType {
  QQ,
  Unknow(0),
  WeiXin(1);
  
  private int a;
  
  static {
    QQ = new LoginType("QQ", 2, 2);
    b = new LoginType[] { Unknow, WeiXin, QQ };
  }
  
  LoginType(int paramInt1) {
    this.a = paramInt1;
    ordinal();
  }
  
  public final int getValue() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\constants\LoginType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */