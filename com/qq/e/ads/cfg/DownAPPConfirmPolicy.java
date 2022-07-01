package com.qq.e.ads.cfg;

public enum DownAPPConfirmPolicy {
  Default(0),
  NOConfirm(2);
  
  private final int a;
  
  DownAPPConfirmPolicy(int paramInt1) {
    this.a = paramInt1;
  }
  
  public final int value() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\cfg\DownAPPConfirmPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */