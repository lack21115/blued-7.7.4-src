package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;

class h implements Runnable {
  h(b paramb) {}
  
  public void run() {
    try {
      this.a.f();
      this.a.n();
      this.a.m();
      this.a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
      return;
    } catch (Exception exception) {
      this.a.u.e(exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */