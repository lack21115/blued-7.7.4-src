package com.baidu.mobads.production;

import com.baidu.mobads.b.a;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class c implements IOAdEventListener {
  c(b paramb) {}
  
  public void run(IOAdEvent paramIOAdEvent) {
    this.a.m();
    if ("URLLoader.Load.Complete".equals(paramIOAdEvent.getType())) {
      this.a.a(paramIOAdEvent, "");
      return;
    } 
    XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "request ad-server error, io_err/timeout", "");
    this.a.d("request ad-server error, io_err/timeout");
    a.a().a("request ad-server error, io_err/timeout");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */