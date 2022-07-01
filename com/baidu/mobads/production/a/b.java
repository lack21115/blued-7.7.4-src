package com.baidu.mobads.production.a;

import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class b implements Runnable {
  b(a parama) {}
  
  public void run() {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().getBaiduMapsInfo(a.a(this.a));
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getCUID(a.b(this.a));
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getCell(a.c(this.a));
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getAppSDC();
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getWIFI(a.d(this.a));
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getGPS(a.e(this.a));
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getNetType(a.f(this.a));
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getAppSDC();
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getMem();
    XAdSDKFoundationFacade.getInstance().getSystemUtils().getAndroidId(a.g(this.a));
    XAdSDKFoundationFacade.getInstance().getCommonUtils().createRequestId(a.h(this.a), "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */