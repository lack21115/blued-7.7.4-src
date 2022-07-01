package com.huawei.android.hms.agent.common;

import com.huawei.android.hms.agent.common.handler.ICallbackResult;

public class CallbackResultRunnable<R> implements Runnable {
  private ICallbackResult<R> handlerInner;
  
  private R resultInner;
  
  private int rtnCodeInner;
  
  public CallbackResultRunnable(ICallbackResult<R> paramICallbackResult, int paramInt, R paramR) {
    this.handlerInner = paramICallbackResult;
    this.rtnCodeInner = paramInt;
    this.resultInner = paramR;
  }
  
  public void run() {
    ICallbackResult<R> iCallbackResult = this.handlerInner;
    if (iCallbackResult != null)
      iCallbackResult.onResult(this.rtnCodeInner, this.resultInner); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\CallbackResultRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */