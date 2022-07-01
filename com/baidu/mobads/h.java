package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class h implements IOAdEventListener {
  h(BaiduNativeH5AdView paramBaiduNativeH5AdView) {}
  
  public void run(IOAdEvent paramIOAdEvent) {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new i(this, paramIOAdEvent));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */