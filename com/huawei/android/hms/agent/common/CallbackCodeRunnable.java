package com.huawei.android.hms.agent.common;

import com.huawei.android.hms.agent.common.handler.ICallbackCode;

public class CallbackCodeRunnable implements Runnable {
  private ICallbackCode handlerInner;
  
  private int rtnCodeInner;
  
  public CallbackCodeRunnable(ICallbackCode paramICallbackCode, int paramInt) {
    this.handlerInner = paramICallbackCode;
    this.rtnCodeInner = paramInt;
  }
  
  public void run() {
    ICallbackCode iCallbackCode = this.handlerInner;
    if (iCallbackCode != null)
      iCallbackCode.onResult(this.rtnCodeInner); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\CallbackCodeRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */