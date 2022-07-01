package com.qq.e.ads.cfg;

public enum BrowserType {
  Default(0),
  Inner(1),
  Sys(2);
  
  private final int a;
  
  BrowserType(int paramInt1) {
    this.a = paramInt1;
  }
  
  public final int value() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\cfg\BrowserType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */